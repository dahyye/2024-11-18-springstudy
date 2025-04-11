 let listApp=Vue.createApp({
	 data(){
		 return {
			 seoul_list:[],
			 curpage:1,
			 totalpage:0,
			 startPage:0,
			 endPage:0,
			 type:1,
			 title:'서울 명소'
			 
		 }
	 },
	 mounted(){
		 this.dataRecv()
	 },
	 methods:{
		//범위 지정을 위한 함수
		prev(){
			//페이지만 바꿔주기
			this.curpage=this.startPage-1
			this.dataRecv()
		},
		next(){
			this.curpage=this.endPage+1
			this.dataRecv()
			
		},
		pageChange(page){
			this.curpage=page
			this.dataRecv()
		},
		range(start,end){
			let arr=[]
			let len=end-start
			for(let i=0;i<=len;i++)
			{
				arr[i]=start
				start++;
			}
			return arr;
		},
		seoul(type){
			this.type=type;
			this.curpage=1
			this.dataRecv()
		},
		dataRecv(){
			let _this=this
			axios.get("http://localhost:8080/web/seoul/list_vue.do",{
				params:{
					page:this.curpage,
					type:this.type
				}
			}).then(response=>{
				console.log(response.data)
				this.seoul_list=response.data.list;
				this.title=response.data.title;
				this.curpage=response.data.curpage;
				this.totalpage=response.data.totalpage;
				this.startPage=response.data.startPage;
				this.endPage=response.data.endPage;
			}).catch(function(error){
				console.log(error.response)
			})
		} 
	 }
	 //watch / computed / components
 }).mount(".container")