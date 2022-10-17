<template>
  <div class="icon-style">
    <component :is="icon"/>
  </div>
</template>

<script setup lang="ts">
defineProps({
  icon: {
    type: String,
    required: true
  }
})
</script>

<style scoped lang="scss">
.icon-style{
  //position: relative;
 // width: 1em;
  //height: 1em;
 // text-align: center;
  //vertical-align: middle;
 // margin: 0  auto;
}
</style>