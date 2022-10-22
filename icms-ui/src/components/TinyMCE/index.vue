<template>
  <n-spin :show="spinShow" description="编辑器加载中......">
<div style="width: 100%;height: 700px">

    <Editor api-key="no-api-key"  :init="{
  skin_url : '/tinymce/skins/ui/oxide',
  language_url : '/tinymce/langs/zh_CN.js',
  language: 'zh_CN',
   menubar: 'edit view insert format tools table help',
   hidden_input: false,
  height: '700px',
  init_instance_callback : initializationComplete,
  plugins: 'print preview searchreplace autolink directionality visualblocks visualchars fullscreen image link media template code codesample table charmap hr pagebreak nonbreaking anchor insertdatetime advlist lists wordcount  textpattern help emoticons autosave     ',
    toolbar: 'code undo redo restoredraft | cut copy paste pastetext | forecolor backcolor bold italic underline strikethrough link anchor | alignleft aligncenter alignright alignjustify outdent indent | \
    styleselect formatselect fontselect fontsizeselect | bullist numlist | blockquote subscript superscript removeformat | \
    table image media charmap emoticons hr pagebreak insertdatetime print preview | fullscreen    lineheight  ',

}" tinymce-script-src="/tinymce/tinymce.min.js"  />

</div>
  </n-spin>
</template>

<script setup lang="ts">
import { ref } from "vue"


import Editor  from '@tinymce/tinymce-vue'
const api_key ="1bgpygd9dq2095jbg5vvkoicpv8oh9tgaaawu3rfikbv7n2r"
const spinShow= ref(true)
const initializationComplete = (e : any) => {
  spinShow.value = false

  
}
</script>

<style scoped>
textarea {
  display: none;
}
</style>