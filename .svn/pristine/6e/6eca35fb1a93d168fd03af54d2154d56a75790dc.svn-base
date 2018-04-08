//function tabChange(obj,id)
//{
// var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
// var arrayul = document.getElementById(id).getElementsByTagName("ul"); //获取ul数组
// for(i=0;i<arrayul.length;i++)
// {
//  if(obj==arrayli[i])
//  {
//   arrayli[i].className = "cli";
//   arrayul[i].className = "";
//  }
//  else
//  {
//   arrayli[i].className = "";
//   arrayul[i].className = "hidden";
//  }
// }
//}


//学校公告
function setTab(name,cursel){
	cursel_0=cursel;
	for(var i=1; i<=4; i++){
		var menu = document.getElementById(name+i);
		var menudiv = document.getElementById("con_"+name+"_"+i);
		if(i==cursel){
			menu.className="off";
			menudiv.style.display="block";
		}
		else{
			menu.className="";
			menudiv.style.display="none";
		}
	}
}
function Next(){                                                        
	cursel_0++;
	if (cursel_0>links_len)cursel_0=1
	setTab(name_0,cursel_0);
} 
var name_0='one';
var cursel_0=1;
var links_len,iIntervalId;
onload=function(){
	var links = document.getElementById("tab1").getElementsByTagName('li')
	links_len=links.length;
	for(var i=0; i<links_len; i++){
		links[i].onmouseover=function(){
			clearInterval(iIntervalId);
			this.onmouseout=function(){
				iIntervalId = setInterval(Next,ScrollTime);;
			}
		}
	}
	document.getElementById("con_"+name_0+"_"+links_len).parentNode.onmouseover=function(){
		clearInterval(iIntervalId);
		this.onmouseout=function(){
			iIntervalId = setInterval(Next,ScrollTime);;
		}
	}
	setTab(name_0,cursel_0);
	iIntervalId = setInterval(Next,ScrollTime);
}


//专业动态

function tabChange(obj,id)
{
 var arrayli = obj.parentNode.getElementsByTagName("li"); //获取li数组
 var arrayul = document.getElementById(id).getElementsByTagName("ul"); //获取ul数组
 for(i=0;i<5;i++)
 {
  if(obj==arrayli[i])
  {
   arrayli[i].className = "cli1";
   arrayul[i].className = "";
  }
  else
  {
   arrayli[i].className = "";
   arrayul[i].className = "hidden1";
  }
 }
}



//建校新闻

$(function(){
		window.onload = function()
		{
			var $li = $('#tab li');
			var $ul = $('#content ul');
						
			$li.mouseover(function(){
				var $this = $(this);
				var $t = $this.index();
				$li.removeClass();
				$this.addClass('current');
				$ul.css('display','none');
				$ul.eq($t).css('display','block');
			})
		}
	});
	




