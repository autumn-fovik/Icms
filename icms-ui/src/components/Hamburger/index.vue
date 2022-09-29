<template>
  <div class="hamburger" @click="toggleClick">
    <svg width="20px" :style="style" class="svg" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M128 192h768v128H128V192zm0 256h512v128H128V448zm0 256h768v128H128V704zm576-352 192 160-192 128V352z"></path></svg>
  </div>
</template>

<script setup lang="ts">
import {useAppStoreWidthOut} from "@/store/modules/app";
import {computed} from "vue";

const  toggleClick = ()=>{
  useAppStoreWidthOut().changeCollapsed()
}
const style = computed(()=>{
  return useAppStoreWidthOut().getCollapsed ? 'transform:rotate(180deg);transition: all .28s ease-in-out' : 'transform:rotate(0deg);transition: all .28s ease-in-out'
})
</script>

<style scoped lang="scss">
.hamburger{
  position: relative;
  width: 60px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  align-items: center;
  display: flex;
  cursor: pointer;
  &:hover{
    background-color: rgba(0,0,0,.1);
    transition: background-color .38s;
  }
  .svg{
    position: absolute;
    margin: auto;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;

  }
}
</style>