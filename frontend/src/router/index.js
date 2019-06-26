import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Calculator from '@/components/basic/Calculator'
import JoinForm from '@/components/member/JoinForm'
import LoginForm from '@/components/member/LoginForm'
import TestForm from '@/components/test/TestForm'
import MemberList from '@/components/member/MemberList'
import JumboTron from '@/components/common/JumboTron'



Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {path: '/',name: 'home',component: Home},
    {path: '/calculator',name: 'calculator',component: Calculator},
    {path: '/joinForm',name: 'joinForm',component: JoinForm},
    {path: '/loginForm',name: 'loginForm',component: LoginForm},
    {path: '/testForm',name: 'testForm',component: TestForm},
    {path: '/memberList',name: 'memberList',component: MemberList},
    {path: '/jumboTron',name: 'jumboTron',component: JumboTron}
  ]
}) 
