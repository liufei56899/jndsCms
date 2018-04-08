window.onload = function () {
    //    导航菜单
    $(function(){
        $(".nav li").hover(function(){
            $(this).find("a").addClass("active").parent("li").siblings("li").children("a").removeClass("active");
            $(this).find(".erji").stop().slideDown(500);
        },function(){
            $(this).find(".erji").stop().slideUp(500);
        });
    });
	

    /*选项卡*/
    function For(c, d) {
        function stopPropagation(e) {
            e = e || window.event;
            if(e.stopPropagation) { //W3C阻止冒泡方法
                e.stopPropagation();
            } else {
                e.cancelBubble = true; //IE阻止冒泡方法
            }
        };
        for(var i = 0; i < c.length; i++) {
            c[i].index = i;
            c[i].onmouseover = function(e) {
                stopPropagation(e)
                for(var j = 0; j < c.length; j++) {
                    c[j].className = "";
                    d[j].className = "hide";
                }
                this.className = "tapActiveLi";
                d[this.index].className = "";
            }
        }
    }

    function tab(a, b) {
        var aLi = document.getElementById(a).getElementsByTagName('li');
        var aDiv = document.getElementById(b).getElementsByTagName('ul');
        For(aLi, aDiv)
    }
    tab('tabHead', 'wrap');
    tab('tabHead1', 'wrap1');
    tab('tabHead2', 'wrap2');
    tab('tabHead3', 'wrap3');
    tab('tabHead4', 'wrap4');
    tab('tabHead5', 'wrap5');
    
    
    /*无缝滚动封装*/
    //父元素
    var con=document.getElementsByClassName("marquee")[0];
    var con1=document.getElementsByClassName("marquee")[1];
/*    var con2=document.getElementsByClassName("marquee")[2];
    var con3=document.getElementsByClassName("marquee")[3];*/
    //子元素
    var img=con.getElementsByTagName("li");

    function ground(parentObj,childObj,widthNum)
    {

        parentObj.innerHTML+=parentObj.innerHTML;

        parentObj.style.width=childObj.length*widthNum+"px";

        parentObj.style.left="-"+(childObj.length/2)*widthNum+"px";

        var timer=null;
        function run()
        {
            if(parentObj.offsetLeft<0)
            {
                parentObj.style.left=parentObj.offsetLeft+1+"px";
            }
            else
            {
                parentObj.style.left="-"+(childObj.length/2)*widthNum+"px";
            }
        }
        timer=setInterval(run,20);

        parentObj.onmouseover=function()
        {
            clearInterval(timer);
        };

        parentObj.onmouseout=function()
        {
            clearInterval(timer);
            timer=setInterval(run,20);
        }
    }
    //调用函数
    ground(con,img,195);
    ground(con1,img,195);
/*    ground(con2,img,300);
    ground(con3,img,300);*/
    
    $(function () {
        $(".hj_m li").mouseover(function () {
            $(".hj_m span").hide();
            $(".hj_m span").eq($(this).index()).show();
        });
    })
    
   
};







