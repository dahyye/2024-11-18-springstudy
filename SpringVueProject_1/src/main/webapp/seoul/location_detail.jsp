<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin:0px auto;
	width: 960px;
}
p{
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
.nav-link:hover{
	cursor:pointer;
}
</style>
</head>
<body>
<div class="container"  id="detail">
 <div class="row">
  <table class="table">
   <tr>
    <td colspan="3" class="text-center">
     <img :src="vo.poster" style="width: 500px; height: 500px;">
    </td>
   </tr>
   <tr>
    <td colspan="3" class="text-center">
     <h3>{{vo.title}}</h3>
    </td>
   </tr>
   <tr>
    <td colspan="3" class="text-center" style="color:gray;">
     <span style="color: gray;">{{vo.msg}}</span>
    </td>
   </tr>
   <tr>
    <td colspan="3" class="text-center" style="color:gray;">
     {{vo.address}}
    </td>
   </tr>
   </table>
  </div>
   <div class="col-sm-3" v-for="vo in food_list">
   <div class="thumbnail">
    <a :href="'../food/detail.do?fno='+vo.fno">
     <img :src="'http://www.menupan.com'+vo.poster" style="width: 230px; height: 130px;">
     <p>{{vo.name}}</p>
    </a>
   </div>
  </div>
 </div>
</body>

<script type="importmap">
{
    "imports":{
      "vue":"https://unpkg.com/vue@3/dist/vue.esm-browser.js"
    }
 }
</script>
<script type="module">
import {createApp} from "vue"
import axiosClient from "../js/api.js"
const app=createApp({
	data(){
		return {
			no:${param.no},
			vo:{},
			food_list:[],
			address:'',
			count:0	
	
		}
	},
	mounted(){
		this.dataRecv()
	},
	methods:{
		async dataRecv() {
			const res=await axiosClient.get('seoul/location_detail_vue.do',{
				params:{
					no:this.no
				}
			})
			console.log(res)
			this.vo=res.data.vo
			this.food_list=res.data.list
			this.count=res.data.count
		}
	}
})
app.mount("#detail")
</script>

</html>