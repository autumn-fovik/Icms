<template>
  <div>
    <n-grid y-gap="10" x-gap="10">
      <n-gi span="24">
        <n-card>
          <n-input>
            <template #prefix>文章标题</template>
          </n-input>
        </n-card>
      </n-gi>
      <n-gi span="18">
        <TinyMCE/>
      </n-gi>
     <n-gi span="6">
       <n-grid y-gap="10">
         <n-gi span="24">
           <n-card>
             <template #header>
               SEO 设置
             </template>
             <template #default>
               <n-form label-placement="left">
                 <n-form-item>
                   <n-input><template #prefix >标题</template></n-input>
                 </n-form-item>
                 <n-form-item>
                   <n-input><template #prefix >描述</template></n-input>
                 </n-form-item>
                 <n-form-item>
                   <n-input><template #prefix >关键字</template></n-input>
                 </n-form-item>
               </n-form>
             </template>
           </n-card>
         </n-gi>
         <n-gi span="24">
           <n-card>
             <template #header>
               文章设置
             </template>
             <template #default>
               <n-form label-placement="left">
                 <n-form-item label="分类">
                   <n-select multiple />
                 </n-form-item>
                 <n-form-item label="标签">
                   <n-select multiple />
                 </n-form-item>
               </n-form>
             </template>
           </n-card>
         </n-gi>
       </n-grid>
     </n-gi>
    </n-grid>
  </div>
</template>

<script setup lang="ts"></script>

<style scoped lang="scss">
</style>