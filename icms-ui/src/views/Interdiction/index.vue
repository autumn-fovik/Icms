<template>
  <div class="login-container">
<!--    <star-background />-->
    <div class="drop-shadow">
      <div class=" glass"></div>
      <span>毛玻璃效果GLASS</span>
    </div>
  </div>
</template>

<script>
import StarBackground from '@/components/StarBackground.vue'

export default {
  beforeCreate: function() {
    document.getElementsByTagName('body')[0].className = 'body-bg'
  },
  components: { StarBackground }
}
</script>

<style>
.body-bg {
  background-attachment: fixed;
  overflow: hidden;
}

.login-container {
  height: 100vh;
  width: 100%;
  overflow: hidden;
  background-color: #050608!important;
}
.glass{
  width: 100%;
  height: 100%;
  background-size: cover;
  background-position: center;
  clip-path: inset(200px 200px); /*裁切*/
  filter: blur(20px); /*滤镜*/
  display: flex;
  justify-content: center;
  align-items: center;
}


.drop-shadow{
  height: 200px;
  width: 200px;
  filter: drop-shadow( 0px 20px 10px rgba(0, 0, 0, 0.5));
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>