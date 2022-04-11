import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
//导入ant Design vue
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
//导入 icon图标库
import * as Icons from '@ant-design/icons-vue';
import {message} from 'ant-design-vue';
//导入 icon图标库




const app = createApp(App);

createApp(App).use(store).use(router).use(Antd).mount('#app')

//全局使用图标
const icons: any = Icons;
for (const i in icons){
    app.component(i,icons[i]);

}
