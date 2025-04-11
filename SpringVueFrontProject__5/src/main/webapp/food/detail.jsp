<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
				           <h3><span id="name">{{vo.name }}</span><span style="color: orange;">&nbsp;{{vo.score }}</span></h3>
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
   <div id="map" style="width:100%;height:350px;"></div>
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
		  axios.get('http://localhost:8080/web/food/detail_vue.do',{
			  params:{
				  fno:this.fno
				  
			  }
		  //데이터값 받기
		  }).then(res=>{
			  //console.log(vo)
			  this.vo=res.data
			  this.name=res.data.name
			  this.data_list=res.data.images.split(",")
			  console.log(res.data)
			  console.log(res.data.name)
			  if(window.kakao && window.kakao.maps)
		 		{
		 			this.initMap()
		 		}
		 		else
		 		{
		 			this.addScript()
		 		}
		  }).catch(error=>{
			  console.log(error)
		  })//에러처리
	  },
	  methods:{
		  addScript(){
	   			const script=document.createElement("script")
	   			/* global kakao */
	   			script.onload=()=>kakao.maps.load(this.initMap)
	   			script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=433db32967fe83b6259bc22338c25ba1&libraries=services"
	   		    document.head.appendChild(script)
	   		},
			   initMap(){
				   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  

					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption); 
		
					// 주소-좌표 변환 객체를 생성합니다
					var geocoder = new kakao.maps.services.Geocoder();
		
					// 주소로 좌표를 검색합니다
					geocoder.addressSearch(this.vo.address, function(result, status) {
		
					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {
		
					        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });
		
					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
					        });
					        infowindow.open(map, marker);
		
					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        map.setCenter(coords);
					    } 
					});       
			   }
			   
		   
		  
	  }
 }).mount(".container")
</script>      
</body>
</html>