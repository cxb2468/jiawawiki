<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
        mode="inline"
        :style="{ height: '100%', borderRight: 0 }"
        @click="handleClick"
        :openKeys="openKeys"
      >
        <a-menu-item key="welcome">
          <MailOutlined />
          <span>欢迎</span>
        </a-menu-item>
        <a-sub-menu v-for="item in level1" :key="item.id" :disabled="true">
          <template v-slot:title>
            <span><user-outlined />{{item.name}}</span>
          </template>
          <a-menu-item v-for="child in item.children" :key="child.id">
            <MailOutlined /><span>{{child.name}}</span>
          </a-menu-item>
        </a-sub-menu>
        <a-menu-item key="tip" :disabled="true">
          <span>以上菜单在分类管理配置</span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout-content
      :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >

      <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="listData">
        <template #footer>
          <div>
            <b>ant design vue</b>
            footer part
          </div>
        </template>
        <template #renderItem="{ item }">
          <a-list-item key="item.title">
            <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
            </template>
            <template #extra>
              <img
                width="272"
                alt="logo"
                src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
              />
            </template>
            <a-list-item-meta :description="item.description">
              <template #title>
                <a :href="item.href">{{ item.title }}</a>
              </template>
              <template #avatar><a-avatar :src="item.avatar" /></template>
            </a-list-item-meta>
            {{ item.content }}
          </a-list-item>
        </template>
      </a-list>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent,onMounted,ref } from 'vue';
import axios from 'axios';


const listData: any = [];

for (let i = 0; i < 23; i++) {
    listData.push({
        href: 'https://www.antdv.com/',
        title: `ant design vue part ${i}`,
        avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
        description:
            'Ant Design, a design language for background applications, is refined by Ant UED Team.',
        content:
            'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
    });
}

export  default  defineComponent({
    name: 'Home',
    setup(){
        console.log("setup");
        const ebooks = ref();

        onMounted(() => {
            console.log("onMounted");
            axios.get("http://localhost:8080/ebook/list").then(
                (response)=>{

                    const data =response.data;
                    ebooks.value = data.content;
                    console.log(response);

                });

        });

        return {
            ebooks,
            listData,
            pagination: {
                onChange: (page: any) => {
                    console.log(page);
                },
                pageSize: 3,
            },
            actions: [
                {type: 'StartOutlined', text: '156'},
                {type: 'LikeOutlined', text: '156'},
                {type: 'MessageOutlined', text: '2'},
            ]
        }





    }
})


</script>

<style scoped>
  .ant-avatar {
    width: 50px;
    height: 50px;
    line-height: 50px;
    border-radius: 8%;
    margin: 5px 0;
  }
</style>
