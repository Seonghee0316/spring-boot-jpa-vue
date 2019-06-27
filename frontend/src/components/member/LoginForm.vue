<template>
  <div>
    <Nav></Nav>
    <form>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" id="email" placeholder="Enter email" v-model="email">
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" v-model="pass">
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
      <button @click="info" type="submit" class="btn btn-default">Submit</button>
      <!-- <button  @submit="info" type="submit" class="btn btn-default">Submit</button> -->
    </form>
    <Footer></Footer>
  </div>
</template>

<script>
import Nav from "@/components/common/Nav.vue";
import Footer from "@/components/common/Footer.vue";
import axios from 'axios'

export default {
  components: {
    Nav,
    Footer
  },

  data() {
    return {
      email: '',
      pass: ''
    }
  },

  methods: {
    info: function() {
      // alert('email: ' + this.email + '  / pass: ' + this.pass);
      alert('되는가?...')
      axios.get('/customers/count')
      .then(d=>{
        alert(`SUCCESS : ${d.data}`)
      })
      .catch(e=>{
        alert('ERROR')
      })
    }
  }
};

// submit누르면 alert뜸 @submit id = '' , pw = ''
</script>

<style scoped>
</style>