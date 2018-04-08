$(document).ready(function(){
			var channelId =$("#channelId_1").val();
			$(".right01 ul").html("");
		 $.ajax({
				url:"/dqjyadmin/jcExamination/professional.do",
				data:{"channelId":channelId},
				cache:false,
				success:function(json){
					 if(json !="false"){
						if(json.length ==0){
							$(".hdjlbox").append("没有试卷!");
							return ;
						}
						
						for(var i =0 ;i<json.length;i++){ 
						 	$(".right01 ul").append("<li><a href='/dqjyadmin/jcExamination/goAnswerpaper.do?examinationid="+json[i].id+"&describe="+encodeURI(encodeURI(json[i].describe))+"&tm="+json[i].createdate.time+"&channelId="+channelId+"&retUrl="+location.href+"'>"+json[i].describe+"<span>"+new Date(json[i].createdate.time).toLocaleString().substring(0,10)+"</span></a></li>"); 
						}
					}else{
							$(".right01 ul").append("没有试卷！！");
					} 
				}
			});
		 
	}); 