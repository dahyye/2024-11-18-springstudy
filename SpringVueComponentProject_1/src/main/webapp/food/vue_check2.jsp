<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
 <div class="container">
  <div class="row">
   <input type="checkbox" value="사과" v-model="f">사과
   <input type="checkbox" value="배" v-model="f">배
   <input type="checkbox" value="바나나" v-model="f">바나나
   <input type="checkbox" value="토마토" v-model="f">토마토
   <input type="checkbox" value="딸기" v-model="f">딸기
   <br>
   <input type="text" size=15 v-model="ss">
   <input type="button" value="전송" @click="send()">
  </div>
 </div>
 <script>
  let app=Vue.createApp({
	  data(){
		  return {
			  f:[],
			  ss:''
		  	
		  }
	  },
	  methods:{
		send(){
			let formData=new FormData()
			formData.append("ss",this.ss)
			for(let i=0;i<f.length;i++)
			{
				console.log(this.f[i])
				formData.append("f",f[i])
			}
			axios.get('vue_check2_vue.do',formData,{
				params:{
					f:formData
				}
			}).then(res=>{
				console.log(res.data)
			})
		}  
	  }
	  
  }).mount(".container")
 </script>
</body>
</html>