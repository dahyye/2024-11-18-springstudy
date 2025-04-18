<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
<div class="container" id="app">
 <div class="row" id="detail">
  <table class="table">
   <tr>
    <td colspan="3" class="text-center">
     <img :src="vo.poster" style="width: 800px; height: 700px;">
    </td>
   </tr>
   <tr>
    <td colspan="3" class="text-center">
     <h3>{{vo.title}}</h3>
    </td>
   </tr>
   <tr>
    <td colspan="3" class="text-center" style="color:gray;">
     {{vo.content}}
    </td>
   </tr>
   <tr>
    <td class="text-center"><img src="a1.png"></td>
    <td class="text-center"><img src="a2.png"></td>
    <td class="text-center"><img src="a3.png"></td>
   </tr>
    <tr>
    <td class="text-center">{{vo.info1}}</td>
    <td class="text-center">{{vo.info2}}</td>
    <td class="text-center">{{vo.info3}}</td>
   </tr>
  </table>
  <table class="table">
   <tr>
    <td><h3>[재료]</h3></td>
   </tr>
   <tr>
    <td>
     <ul>
      <li v-for="d in rlist">{{d}}</li>
     </ul>
    </td>
   </tr>
  </table>
  <table class="table">
   <tr>
    <td>
     <table class="table" v-for="(m,index) in mlist">
      <tr>
       <td width="80%" class="text-left">{{m}}</td>
       <td width="20%" class="text-right">
        <img :src="ilist[index]" style="width: 120px; height: 80px">
       </td>       
      </tr>
     </table>
    </td>
   </tr>
  </table>
 </div>
 </div>
</div>
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
			mlist:[],
			ilist:[],
			rdata:[]			
		}
	},
	mounted(){
		this.dataRecv()
	},
	methods:{
		async dataRecv() {
			const res=await axiosClient.get('recipe/detail_vue.do',{
				params:{
					no:this.no
				}
			})
			console.log(res)
			this.vo=res.data.vo
			this.mlist=res.data.mlist
			this.ilist=res.data.ilist
			this.rdata=res.data.vo.data.split(",")
		}
	}
 })
app.mount("#app")
</script>
</body>
</html>