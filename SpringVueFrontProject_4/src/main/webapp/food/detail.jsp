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
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">

                        <!-- Single Post -->
                        <div class="col-12 col-sm-12">
                            
                            <!-- Related Post Area -->
                            <div class="related-post-area section_padding_50">
                              
                                <!-- <div class="related-post-slider owl-carousel">
                                    Single Related Post
	                                   <div class="single-post" v-for="i in data_list">
	                                        Post Thumb
	                                        <div class="post-thumb">
	                                            <img :src="'http://www.menupan.com'+i" alt="">
	                                        </div>
	                                    </div>
                                </div> -->
                            </div>
                          
                      <table class="table">
				       <tr>
				         <td width=50% class="text-center" rowspan="8">
				          <div class="post-thumb">
				            <img :src="'https://www.menupan.com/'+vo.poster" style="width: 450px;height: 400px"
				           class="img-rounded"
				           >
				          </div>
				         </td>
				         <td colspan="2">
				           <h3>{{vo.name }}&nbsp;<span style="color: orange;">{{vo.score }}</span></h3>
				         </td>
				       </tr>
				       <tr>
				         <th width=15%>음식종류</th>
				         <td width=35%>{{vo.type }}</td>
				       </tr>
				       <tr>
				         <th width=15%>주소</th>
				         <td width=35%>{{vo.address }}</td>
				       </tr>
				       <tr>
				         <th width=15%>전화</th>
				         <td width=35%>{{vo.phone }}</td>
				       </tr>
				       <tr>
				         <th width=15%>가격대</th>
				         <td width=35%>{{vo.price }}</td>
				       </tr>
				       <tr>
				         <th width=15%>주차</th>
				         <td width=35%>{{vo.parking }}</td>
				       </tr>
				       <tr>
				         <th width=15%>영업시간</th>
				         <td width=35%>{{vo.time }}</td>
				       </tr>
				       <tr>
				         <th width=15%>테마</th>
				         <td width=35%>{{vo.theme }}</td>
				       </tr>
				      </table>
				      <table class="table">
				        <tr>
				         <td>{{vo.content }}</td>
				        </tr>    
				      </table>
     				</div>
    </div>
   </div>
  </div>
 </div>
 <script>
 let app=Vue.createApp({
	  data(){
		  return {
			  fno:${param.fno},
			  vo:{}
		  }
		  
	  },
	  mounted(){
		  axios.get('../food/detail_vue.do',{
			  params:{
				  fno:this.fno
				  
			  }
		  //데이터값 받기
		  }).then(res=>{
			  //console.log(vo)
			  this.vo=res.data.vo
			  this.data_list=res.data.vo.images.split(",")
			  console.log(this.data_list)
			  
		  }).catch(error=>{
			  console.log(error)
		  })//에러처리
	  },
	  methods(){
		  
	  }
 }).mount(".container")
</script>      
</body>
</html>