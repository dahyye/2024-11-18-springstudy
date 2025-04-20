<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Reddit 스타일 게시글 + 큰 이미지 슬라이드</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
  <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <style>
  body {
    background-color: #f6f7f8;
    font-family: 'Segoe UI', sans-serif;
    padding: 20px;
  }

  /* ✅ 전체 너비를 70%로 제한 */
  .custom-container {
    width: 70%;
    margin: 0 auto;
  }

  /* ✅ 일정 패널 높이 조정 */
  .panel-info {
    min-height: 800px; /* 일정 영역 더 길게 */
  }

  .post {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px;
    margin-bottom: 20px;
    padding: 15px;
  }

  .post-title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 8px;
  }

  .post-meta {
    color: #999;
    font-size: 12px;
    margin-bottom: 10px;
  }

  .post-body {
    margin-top: 15px;
  }

  .post-footer .btn {
    margin-right: 10px;
    padding: 2px 8px;
    font-size: 12px;
  }

  .carousel {
    margin-top: 15px;
  }

  .carousel-inner > .item > img {
    width: 100%;
    height: 500px;
    object-fit: cover;
    border-radius: 8px;
  }

  .carousel-control.left, .carousel-control.right {
    background-image: none;
    color: #333;
  }

  @media (max-width: 768px) {
    .carousel-inner > .item > img {
      height: 300px;
    }

    .custom-container {
      width: 95%;
    }
  }
</style>
</head>
<body>
<div class="container-fluid custom-container">
  <div class="row">
    
    <!-- 왼쪽 일정 영역 -->
    <div class="col-sm-3">
      <div class="panel panel-info">
        <div class="panel-heading">📅 오늘의 일정</div>
        <div class="panel-body">
          <ul class="list-unstyled">
            <li><strong>10:00</strong> 회의</li>
            <li><strong>13:30</strong> 디자인 피드백</li>
            <li><strong>16:00</strong> 개발 회의</li>
          </ul>
        </div>
      </div>
    </div>

    <!-- 중앙 피드 영역 -->
    <div class="col-sm-9">
      
      <!-- 상단 새 피드 쓰기 버튼 -->
      <div class="text-center" style="margin-bottom: 15px;">
        <button class="btn btn-primary" data-toggle="modal" data-target="#newPostModal">
          <span class="glyphicon glyphicon-pencil"></span> 새 글 쓰기
        </button>
      </div>
      <!--  상단 새 일정 쓰기 버튼 -->
      <!-- <div class="text-right" style="margin-bottom: 15px;">
        <button class="btn btn-primary" data-toggle="modal" data-target="#newPostModal">
          <span class="glyphicon glyphicon-pencil"></span> 일정 추가
        </button>
      </div> -->

	  <div id="newPostModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">새 글 작성</h4>
      </div>

      <div class="modal-body">
        <form @submit.prevent="addPost">
          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" class="form-control" v-model="newPost.title" required><!--   -->
          </div>

          <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" class="form-control" rows="4" v-model="newPost.content" required></textarea><!--  -->
          </div>

          <div class="form-group">
            <label for="images">이미지 URL (콤마로 구분)</label>
            <input type="text" id="images" class="form-control" v-model="newPost.imageInput"><!--   -->
          </div>

          <button type="submit" class="btn btn-success">게시하기</button>
        </form>
      </div>

    </div>
  </div>
</div>

      <!-- 게시글 반복 렌더링 -->
    <div class="post" v-for="(vo, index) in list" :key="vo.feed_no"> 
        <div class="post-title">{{ vo.title }}</div>
        <div class="post-meta">
          {{ vo.regdate }}
          vo.regdate
        </div>

        이미지 슬라이드
       <!--  <div :id="'carousel-' + index" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li  :data-target="'#carousel-' + index" :data-slide-to="imgIndex" :class="{ active: imgIndex === 0 }"></li>
          </ol>
          <div class="carousel-inner">
            <div class="item" v-for="(image, imgIndex) in post.images" :class="{ active: imgIndex === 0 }">
              <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAyMDhfMTg2%2FMDAxNjc1ODI1NDU4ODAy.r-OTedxUBE0S-kO_cmPOp1RARfs_DyOsuhMFsJiSu5Ag.lcSPhivCsVpE0p3GiqYndeHF5c5I_hoXZv3W0luTFUMg.JPEG.gywls55566%2F694D01C0-B082-47B3-882C-91CB1421A4C0.jpg&type=ofullfill340_600_png" class="img-responsive" style="width: 100%; height: 500px; object-fit: cover;">
            </div>
          </div>
          <a class="left carousel-control" :href="'#carousel-' + index" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
          </a>
          <a class="right carousel-control" :href="'#carousel-' + index" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div> -->

        <div class="post-body" style="margin-top: 10px;">
          {{ vo.content }}
        </div>

        <div class="post-footer">
          <button class="btn btn-default btn-sm"><span class="glyphicon glyphicon-comment"></span> 댓글</button>
          <button class="btn btn-default btn-sm"><span class="glyphicon glyphicon-share"></span> 공유</button>
          <button class="btn btn-default btn-sm"><span class="glyphicon glyphicon-star"></span> 저장</button>
        </div>
      </div>

    </div>
  </div>
</div>
</div>
<script type="module">
  import { createApp, ref } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'

  createApp({
	data(){
      return {
         list:[],
		 group_no:1,
		 newPost: {
         			title: '',
         			content: '',
         			imageInput: ''
      			   },
		 
      }
    },
	mounted(){
		this.dataRecv()
	},
    methods:{
		addPost() {
			const res = axios.post('/board/feed_insert.do',{
					title : this.newPost.title,
					content : this.newPost.content,
					images : this.newPost.imageInput
					
			}).then(response=> {
				console.log("데이터 등록 성공")
				
			})
			
			
		},
		async dataRecv(){
			console.log("dataRecv 실행")
			const res = await axios.get('/board/feed_vue.do',{
					params:{
							group_no:this.group_no
					}
			})
            this.list=res.data.list 
			console.log(res)
		}

	}
  }).mount('.container-fluid')
</script>
</body>
</html>