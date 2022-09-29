<template>
  <div>
    <div id="vditor" class="ads"  />
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import Vditor from 'vditor';
import 'vditor/dist/index.css';

const vditor = ref<Vditor | null>(null);

onMounted(() => {
  vditor.value = new Vditor('vditor', {
    width : "100%",
    after: () => {
      // vditor.value is a instance of Vditor now and thus can be safely used here
      vditor.value!.setValue('Vue Composition API + Vditor + TypeScript Minimal Example');
    },
  });
});
</script>

<style scoped lang="scss">
.ads {
  //position: fixed;
  //top: 0;
  //width: 100% !important;
  //left: 0;
  //height: 100vh !important;
  //z-index: 90;
  //border-radius: 0;
}
</style>
