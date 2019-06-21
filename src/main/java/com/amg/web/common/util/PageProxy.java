package com.amg.web.common.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * PageProxy
 */
@Component @Data @Lazy
public class PageProxy {
    @Autowired Printer p;
    private int pageNum, pageSize, blockSize, startRow,
                endRow, startPage, endPage, prevBlock, nextBlock, totalCount;
                //pageNum, pageSize, blockSize Json은 map구조니까 text로 보내야함???
    private String search;
    
    // 다음 > 과 이전이 보일지 말지 정함
    private boolean existPrev, existNext;

    // 와일드 카드는 오브젝트 리턴함. 와일드 카드 Map<?, ?>
    public void execute(Map<?, ?> paramMap){

        //  Dim-1 scalar count 
        int totalCount = Integer.parseInt(String.valueOf(paramMap.get("totalCount")));

        // Di-2 scalar info (사용자가 몇페이지 보고싶은지) 
        // 내부에서 쓰는 변수는 _로 함 (임시로 지정할때나)
        String _pageNum = (String)paramMap.get("page_num");

        //customer페이지에서 product페이지 넘어갈때 1페이지로 지정.
        pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
        
        //한 화면에 보이는 글의 수
        String _pageSize = (String)paramMap.get("page_size");
        pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize); 

        //totalCount = DB에 있는 테이블에서 개수 가져옴. 
        int nmg = totalCount % pageSize;

        // 맨 마지막 페이지 2개여도 페이지 1개 늘어나야하니까.
        int pageCount = (nmg == 0) ? totalCount / pageSize : totalCount / pageSize + 1;

        // startRow와 endRow는 2차원
        // startRow (1페이지면 1) 
        startRow = (pageNum - 1) * pageSize; 
        
        // endRow (1페이지면 5)
        endRow = (totalCount > pageNum * pageSize) ? pageNum * pageSize : totalCount;

        // Di-3 Block saclar info   
        //blocksize (1~10까지면 10) 기본값 5 <- -> ?
        String _blockSize = (String)paramMap.get("block_size");
        blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);
        int blockNum = (pageNum -1) / blockSize;

        existPrev = (startPage - pageSize) > 0;
        existNext = (startPage + pageSize) <= pageCount;

        startPage = (existPrev) ? blockNum * blockSize + 1 : 1;
        endPage = (endPage > pageCount) ? pageCount : startPage + (blockSize -1);

        prevBlock = startPage - pageSize;
        nextBlock = startPage + pageSize;
        search = (String)paramMap.get("search");
    }
    
}