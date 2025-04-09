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
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
 <div class="container">
  <div class="row">
   <input type="text" size=20 class="input-sm" ref="fd" v-model="fd" v-on:keyup.enter="find()">
  </div>
  <div style="height: 10px"></div>
  <div class="row">
   <div class="col-md-3" v-for="vo in recipe_list">
    <div class="thumbnail">
      <a href="#">
        <img :src="vo.poster" alt="Lights" style="width:230px; height: 150px">
        <div class="caption">
          <p>{{vo.title}}</p>
        </div>
      </a>
    </div>
  </div>
  </div>
 </div>
  <script type="text/javascript">
 let app=Vue.createApp({
	data(){
		return {
			recipe_list:[],
			curpage:1,
			totalpage:0,
			fd:'디저트'
		}
		
	},
	mounted(){
		//화면 시작과 동시에 데이터 전송
		//-> React
		this.dataRecv()
	},
	methods:{
		prev(){
			this.curpage=this.curpage>1?this.curpage-1:this.curpage
			this.dataRecv()
			
		},
		next:function(){
			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.totalpage
			this.dataRecv()
			
		},
		dataRecv(){  //aws에서 ../를 인식을 잘 못하는 경우가 있어서 가급적이면 http로 써주는게 좋아
			axios.get('http://localhost:8080/web/recipe/find_vue.do',{
				params:{
					page:this.curpage,
					fd:this.fd
					//키 : 값
					//?page=1&fd=마포
					
				}
			}).then(response=>{
				console.log(response.data)
				this.recipe_list=response.data.list
				this.curpage=response.data.curpage
				this.totalpage=response.data.totalpage
			})
		
		},
		find(){
			this.curpage=1
			if(this.fd==="")
			{
				this.$refs.fd.focus()
				return
			}
			this.dataRecv()
			
		}
	}
 }).mount(".container")
 </script>
</body>
</html>