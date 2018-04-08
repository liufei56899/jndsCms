


$(document).ready(function(){
	
	//
	 $("#s_t01").click(function(){
							
	  $("#s_t01").addClass("cur");
	  $("#s_t02").removeClass("cur");
	

		
    	$("#s_t1").show();
	    $("#s_t2").hide();
	   
	 })
	 
	 $("#s_t02").click(function(){
							  
	  $("#s_t02").addClass("cur");
	  $("#s_t01").removeClass("cur");


		
    	$("#s_t2").show();
	    $("#s_t1").hide();
	   
	 })
	
	


	//
	 $("#s_u01").click(function(){
							 
	  $("#s_u01").addClass("cur");
	  $("#s_u02").removeClass("cur");
	

		
    	$("#s_u1").show();
	    $("#s_u2").hide();
	   
	 })
	 
	 $("#s_u02").click(function(){
							  
	  $("#s_u02").addClass("cur");
	  $("#s_u01").removeClass("cur");


		
    	$("#s_u2").show();
	    $("#s_u1").hide();
	   
	 })
})


$(function(){
	$(".concent0201 .tab a").click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		number = index;
		$('.concent0201 .content li').hide();
		$('.concent0201 .content li:eq('+index+')').show();
	});
	
	var auto = 1;  //等于1则自动切换，其他任意数字则不自动切换
	if(auto ==1){
		var number = 0;
		var maxNumber = $('.concent0201 .tab a').length;
		function autotab(){
			number++;
			number == maxNumber? number = 0 : number;
			$('.concent0201 .tab a:eq('+number+')').addClass('on').siblings().removeClass('on');
			$('.concent0201 .content ul li:eq('+number+')').show().siblings().hide();
		}
		//var tabChange = setInterval(autotab,3000);
//		//鼠标悬停暂停切换
//		$('.concent0201').mouseover(function(){
//			clearInterval(tabChange);
//		});
//		$('.concent0201').mouseout(function(){
//			tabChange = setInterval(autotab,3000);
//		});
	  }
});



$(function(){
	$(".concent0202 .tab a").click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		number = index;
		$('.concent0202 .content li').hide();
		$('.concent0202 .content li:eq('+index+')').show();
	});
	
	var auto = 1;  //等于1则自动切换，其他任意数字则不自动切换
	if(auto ==1){
		var number = 0;
		var maxNumber = $('.concent0202 .tab a').length;
		function autotab(){
			number++;
			number == maxNumber? number = 0 : number;
			$('.concent0202 .tab a:eq('+number+')').addClass('on').siblings().removeClass('on');
			$('.concent0202 .content ul li:eq('+number+')').show().siblings().hide();
		}
		//var tabChange = setInterval(autotab,3000);
//		//鼠标悬停暂停切换
//		$('.concent0202').mouseover(function(){
//			clearInterval(tabChange);
//		});
//		$('.concent0202').mouseout(function(){
//			tabChange = setInterval(autotab,3000);
//		});
	  }
});