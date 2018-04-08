$(document).ready(function() {
//alert(111);
    //setMyFocus('myFocus',3)
    });
//年月日
function showweek() //显示中文星期
{
    now = new Date() //定义新对象，new具有Date的性质
if (now.getDay() == 0) return ("星期日")
if (now.getDay() == 1) return ("星期一")
if (now.getDay() == 2) return ("星期二")
if (now.getDay() == 3) return ("星期三")
if (now.getDay() == 4) return ("星期四")
if (now.getDay() == 5) return ("星期五")
if (now.getDay() == 6) return ("星期六")
}

function showdate() //显示系统日期
{

var now=new Date();

var year = now.getFullYear();

var month = now.getMonth()+1;

var day = now.getDate();

return year+"年"+month+"月"+day+"日";
}

//焦点图
function setMyFocus(ID,t){//主函数...
function $(id) {return document.getElementById(id);}
function $$(tag,obj){return (typeof obj=='object'?obj:$(obj)).getElementsByTagName(tag);}
function poptit(n){//文字上下运动函数
	var ts = $$('li',tit);
	var H = ts[n].clientHeight;
	var setway=function(obj,y){obj.style.bottom=y+'px';}
	var getway=function(obj){return parseInt(obj.style.bottom);}
	var y1,y2;
	var up=function(){
		y1=getway(ts[n]);
		if (ts[n].movement) clearTimeout(ts[n].movement);//为了兼容变化中的点击
		if (y1 == 0) return true;
		y1+=Math.ceil((0 - y1) / 5);
		setway(ts[n],y1);
		if(y1<0) ts[n].movement = setTimeout(up, 1);
	}
	var down=function(){
		y2=getway(ts[N]);
		if (ts[N].movement) clearTimeout(ts[N].movement);
		if (y2 == -H) return true;
		y2+=Math.floor((-H - y2) / 5);
		setway(ts[N],y2);
		if(y2>-H) ts[N].movement = setTimeout(down, 1);
	}
	for(var i=0;i<ts.length;i++){
		if (!ts[i].style.bottom) ts[i].style.bottom = -H+'px';
		if(ts[i].name=='up') var N=i;
	}
	if(!N&&n==0) {//开始载入...
		ts[n].name='up';
		var y1=getway(ts[n]);
		up();
		return true;
	} 
	if(N==n) return true;//防止快速移出移入的抖动
	ts[N].name=''//标记淡入的name为空
	ts[n].name='up';
	down();
	up();
}
function opa(n){//图片淡入淡出函数
	var pics = $$('img',pic);
	var setfade=function(obj,o){
		if (document.all) obj.style.filter = "alpha(opacity=" + o + ")";
		else obj.style.opacity = (o / 100);
	};
	var getfade=function(obj){
		return (document.all)?((obj.filters.alpha)?obj.filters.alpha.opacity:false):((obj.style.opacity)?obj.style.opacity*100:false);
	}
	var show=function(){
		if(pics[n].move) clearTimeout(pics[n].move);
		if (o1 >= 100) return true;
		o1+=5;
		setfade(pics[n],o1);
		pics[n].move=setTimeout(show,1);
	};
	var hide=function(){
		if(pics[N].move) clearTimeout(pics[N].move);
		if (o2 <= 0) {pics[N].style.display='none';return true;}
		o2-=5;
		setfade(pics[N],o2);
		pics[N].move=setTimeout(hide,1);
	};
	for(var i=0;i<pics.length;i++){
		if(!getfade(pics[i])) {setfade(pics[i],0);pics[i].style.display='none';}
		if(pics[i].name=='out') var N=i;
	}
	if(!N&&n==0) {//开始载入...
		pics[n].name='out';
		pics[n].style.display='';
		var o1=getfade(pics[n]);
		show();
		return true;
	}
	if(N==n) return true;
	pics[N].name=''
	pics[n].name='out';
	pics[n].style.display='';
	var o1=getfade(pics[n]);
	var o2=getfade(pics[N]);
	hide();
	show();
}
function classNormal() {//数字标签样式清除
    var focusBtnList = $$('li',btn);
    for (var i = 0; i < focusBtnList.length; i++) {
        focusBtnList[i].className = '';
    }
}
function autoFocusChange() {//自动运行
    if (atuokey) return;
    var focusBtnList = $$('li',btn);
    for (var i = 0; i < focusBtnList.length; i++) {
        if (focusBtnList[i].className == 'current') {
            var currentNum = i;
        }
    }
	if(currentNum<focusBtnList.length-1){
		poptit(currentNum+1);
		opa(currentNum+1);
       	classNormal();
       	focusBtnList[currentNum+1].className = 'current';
	}else if(currentNum==focusBtnList.length-1){
		poptit(0);
		opa(0);
       	classNormal();
       	focusBtnList[0].className = 'current';
	}
}
function focusChange() {//交互切换
    var focusBtnList = $$('li',btn);
    for (var i = 0; i < focusBtnList.length; i++) {
		focusBtnList[i].I=i;
		focusBtnList[i].onclick = function(){
        	poptit(this.I);
			opa(this.I);
        	classNormal();
        	focusBtnList[this.I].className = 'current';
		}
		focusBtnList[i].onmouseover = function(){
			if(!this.className) this.className = 'hover'
		}
		focusBtnList[i].onmouseout = function(){
			if(this.className=='hover') this.className ='';
		}
	}
}
function init(){//初始化
	$(ID).removeChild($$('div',ID)[2]);
	opa(0);
	poptit(0);
    classNormal();
    $$('li',$$('div',ID)[4])[0].className = 'current';
	$(ID).onmouseover = function() {
        atuokey = true;
		clearInterval(auto);
    }
    $(ID).onmouseout = function() {
        atuokey = false;
		auto=setInterval(autoFocusChange, T);
    }
}
var ul=$$('ul',ID)[0];
var li=$$('li',ul);
var NUM=li.length;
var s1='<div class="tsBg"></div><div class="btnBg"><ul>';for(var i=0;i<NUM;i++){s1+='<li></li>'};s1+='</ul></div>';
var s2='<div class="ts"><ul>';
for(var i=0;i<NUM;i++){var a=$$('a',li[i])[0];var img=$$('img',li[i])[0];s2+='<li><a href="'+a.href+'">'+img.alt+'</a></li>'};s2+='</ul></div>';
var s3='<div class="btn"><ul>';
for(var i=0;i<NUM;i++){s3+='<li>'+(i+1)+'</li>'};s3+='</ul></div>';
$(ID).innerHTML=s1+$(ID).innerHTML+s2+s3;
//生成HTML结束
var pic=$$('div',ID)[3];
var tit=$$('div',ID)[4];
var btn=$$('div',ID)[5];
var atuokey = '';
var auto='';
var T=t*1000;//每帧图片停留的时间，1000=1秒
	init();
	focusChange();
	auto=setInterval(autoFocusChange, T);
}

