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
    <div class="col-md-3" v-for="vo in food_list">
    <div class="thumbnail">
      <a :href="'../food/detail.do?fno='+vo.fno">
        <img :src="'https://www.menupan.com/'+vo.poster" alt="Lights" style="width:width:230px; height: 150px">
        <div class="caption">
          <p>{{vo.name}}</p>
        </div>
      </a>
    </div>
  </div>
  </div>
  <div style="height: 10px; "></div>
  <div class="row">
   <div class="text-center" style="margin-bottom: 10px">
    <input type="button" class="btn-sm btn-danger" value="이전" @click="prev()">
     {{curpage}} page / {{totalpage}} pages
    <input type="button" class="btn-sm btn-danger" value="다음" v-on:click="next()">
   </div>
  </div>
 </div>
 <script type="text/javascript">
 let app=Vue.createApp({
	data(){
		return {
			food_list:[],
			curpage:1,
			totalpage:0
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
			axios.get('http://localhost:8080/web/food/list_vue.do',{
				params:{
					page:this.curpage,
					
				}
			}).then(response=>{
				console.log(response.data)
				this.food_list=response.data.list
				this.curpage=response.data.curpage
				this.totalpage=response.data.totalpage
			})
		
		}
	}
 }).mount(".container")
 </script>
</body>
</html>