/**
 * Author: 张中乐
 * Email: sjz20072-304@163.com
 * Update: 2014.4.23 
 */
;(function($){
	//私人插件  start
	$.fn.extend({
		/**
		 * 功能介绍：横向多级菜单
		 * 参数介绍：
		 * m_first:'#m_first',一级菜父级ID默认#m_first，可修改
		 * m_second:'.m_second',二级样式默认.m_second，可修改
		 * m_third:'.m_third',三级样式名默认.m_third，可修改
		 * m_more:'.m_more'四级以上样式名默认.m_more，可修改
		 *---------------------------------------
		 * Update: 2014.4.23 
		 */
		'menu':function(options){
			var this_parent=this;
			var mouseover_tid = [];
			var mouseout_tid = [];
			options=$.extend({
				m_first:'#m_first',
				m_second:'.m_second',
				m_third:'.m_third',
				m_more:'.m_more'
			},options);
			
			this_parent.active=function (this_ele,index){
				this_ele.hover(
					function(){
						var _self = this;
						clearTimeout(mouseout_tid[index]);
						mouseover_tid[index] = setTimeout(function() { 
							 $(_self).children('ul:eq(0)').slideDown(200); 
						}, 200);
					},function(){
						var _self = this;
						clearTimeout(mouseover_tid[index]);
						mouseout_tid[index] = setTimeout(function() { 
						   $(_self).children('ul:eq(0)').slideUp(100); 
						}, 200);
					}
				);
			}
			
			if(options.m_first){
				$(options.m_first+'>li').each(function(index){
					this_parent.active($(this),index);
				});
			}
			if(options.m_second){
				$(options.m_second+'>li',this).each(function(index){
					this_parent.active($(this),index);
				});
			}
			if(options.m_third){
				$(options.m_third+'>li',this).each(function(index){
					this_parent.active($(this),index);
				});
			}
			if(options.m_more){
				$(options.m_third+'>li',this).each(function(index){
					this_parent.active($(this),index);
				});
			}
			
			return this;
		},
		/**
		 * 功能介绍：标签切换tab
		 * 参数介绍：
		 * m_first:'.m_first',一级菜样式默认.m_first，可修改
		 * m_second:'.m_second',二级样式默认.m_second，可修改
		 * m_third:'.m_third',三级样式名默认.m_third，可修改
		 * m_more:'.m_more'四级以上样式名默认.m_more，可修改
		 *---------------------------------------
		 * Update: 2014.4.23 
		 */
		'tab':function(options){
			options=$.extend({
				myevent:'click',
				titleId:'',
				contentId:'',
				titleOff:'',
				titleOn:'',
				contentCss:''
			},options);
			
			$(options.titleId+' li').on(options.myevent,function(){
				$(this).attr('class',options.titleOn).siblings().attr('class',options.titleOff);	
				$(options.contentId+" "+options.contentCss).eq($(this).index()).show().siblings().hide();
			});
			return this;
		}
			
			
		
	});
	//私人插件  end
	
	//集成他人插件  start
	$.fn.carousel = function(args) {
		var $this = $(this),
			$viewport = $this.find("[role=viewport]"),
			$content = $this.find("[role=content]"),
			$leftBtn = null,
			$rightBtn = null,
		
			defaults = $.extend({
				self: $this,
				content: $content,
				points: null,			// 底部按钮组
				isPagination: false,	// 是否有底部按钮
				isButton: false,		// 是否有左右按钮组
				isLoop: true,			// 是否循环
				isHideBtn: true,		// 是否 hover button
				isSlow: false,			// 是否缓慢移动
				direction: true,		// 正方向为向上滚动，向左滚动
				directionXY: true,		// 默认滚动X轴
				interval: 3000,			// 间隔时间
				speed: 700,				// 如果为缓慢滚动此为滚动 1px 间歇时间 否则为滚动一屏的时间
				curClass: "cur",		// 底部按钮默认选中的class
				isMove: true
			}, args),
			
			timer = null;
		
		// 计算高度或者宽度值
		defaults.contentXY = defaults.directionXY ? $content.children().eq(0).width() * $content.children().length : $content.height();
		defaults.distance = defaults.directionXY ? $viewport.width() : $viewport.height();
		
		$content.html($content.html() + $content.html() + $content.html());
		$content.css((defaults.directionXY ? "width" : "height"), defaults.contentXY * 3);
		$content.css((defaults.directionXY ? "left" : "top"), defaults.contentXY * -1);
		
		
		
		if (defaults.isButton && !defaults.isSlow) {
			$leftBtn = $this.find("[role=left]");
			$rightBtn = $this.find("[role=right]");
			
			$this.on({
				click: function() {
					if ($(this).attr("role") == "right") {
						move(true, defaults);
					} else {
						move(false, defaults);
					}
				}
			}, "[role=left], [role=right]");
			
			if (defaults.isHideBtn) {
				$this.on({
					mouseenter: function() {
						$leftBtn.css("display", "block");
						$rightBtn.css("display", "block");
					},
					mouseleave: function() {
						$leftBtn.css("display", "none");
						$rightBtn.css("display", "none");
					}
				});
			}
		}
		
		$this.on({
			mouseenter: function() {
				clearInterval(timer);
			},
			mouseleave: function() {
				timer = setInterval(function() {
					move(defaults.direction, defaults);
				}, defaults.isSlow ? defaults.speed : defaults.interval);
			}
		});
		
		if (defaults.isPagination && !defaults.isSlow) {
			defaults.points = $this.find("[role=points]").children();
			
			defaults.points.each(function(i) {
				$(this).on("click", function() {
					move(true, defaults, i);
				});
			});
		}
		
		timer = setInterval(function() {
			move(defaults.direction, defaults);
		}, defaults.isSlow ? defaults.speed : defaults.interval);
	};
	
	function move(mark, args, index) {
		if (!args.isSlow) {
			if (args.isMove) {
				args.isMove = false;
			} else {
				return false;
			}
		}
		var $this = args.self,
			$content = args.content,
			subDis = args.isSlow ? 1 : args.distance,
			directionXY = args.directionXY ? "left" : "top",
			curPos = parseInt($content.css(directionXY)),
			destination = mark ? curPos - subDis : curPos + subDis;
		
		if (!args.isLoop) {
			if (destination > args.contentXY * -1) {
				destination = args.contentXY * -2 + subDis;
			}else if (destination < args.contentXY * -2 + subDis) {
				destination = args.contentXY * -1;
			}
		}
		
		if (!args.isSlow && args.isPagination) {
			args.points.removeClass(args.curClass);
			
			if (typeof index == "number") {
				destination = args.contentXY * -1 - index * subDis;
			} else {
				index = Math.abs((destination + args.contentXY)/subDis);
			}
			if (index >= args.points.length) index = 0;
			args.points.eq(index).addClass(args.curClass);
		}
		
		if (args.isSlow) {
			$content.css(directionXY, destination);
			moveComplete();
		} else {
			if (args.directionXY) {
				$content.animate({left: destination}, args.speed, function() {
					moveComplete();
				});
			} else {
				console.log(destination);
				$content.animate({top: destination}, args.speed, function() {
					moveComplete();
				});
			}
		}
		
		function moveComplete() {
			curPos = parseInt($content.css(directionXY));
			
			if ((curPos <= args.contentXY * -2 || curPos >= 0) && args.isLoop) {
				args.content.css(directionXY, args.contentXY * -1);
			}
			
			args.isMove = true;
		}
	}
	//集成他们插件  end
	
})(jQuery);






$(function(){
	//左右滑动 start----------
	var conf={//可配置项
		
		'btn_l':$("#left"),		//左单击按钮
		'btn_r':$("#right"),		//右单击按钮
		'content':$('.content'),		//一屏容器
		'middle':$("#middle")		//可视区域或移动目标
		//'minW':10090		//内容最小宽度

	}
	
	var ali={//不可配置项
		'flag':0,		//浏览器改变标志位
		'count':0,		//第几屏，记录当前屏标号，默认第一屏
		'width':903,		//当前屏宽
		'height':100		//当前屏高
	}
	
	//根据窗口改变重新初始化
	function setwindow(){
		conf.content.width(ali.width);
		conf.middle.width(conf.content.length*ali.width);
		
	}
	setwindow();
	
	function move_left(){
		var left_site=conf.middle.css("left");
		if(!(conf.middle.position().left==(-(conf.content.length-1)*ali.width))){
			conf.middle.not(':animated').animate({left:"-="+ali.width},500);
			ali.count++;
		}
	}
	
	function move_right(){
		var left_site=conf.middle.css("left");
		if(!(conf.middle.position().left>=0)){
			conf.middle.not(':animated').animate({left:"+="+ali.width},500);
			ali.count--;
		}
	}
	
	//obo判断移动方向  传参数1：left或0：right
	function move(obo){
		setwindow();
		if(obo){
			move_left();
		}else{
			move_right();
		}
	}
	
	conf.btn_l.bind("click",function(){move(1)});
	conf.btn_r.bind("click",function(){move()});
	//左右滑动 start----------
	//banner  start----------

	  $("#banner2").carousel({
		   isButton: true,
		   isPagination: true,
		   curClass: "FocusCur1"
	  });
	  //banner  end----------
	  //banner  start----------
	  //tab switch start----------
	  $('#tab').tab({
		  myevent:'mouseover',
		  titleId:'#tab',
		  contentId:'#zr_r_content',
		  contentCss:'.zr_r_content',
		  titleOff:'',
		  titleOn:'zr_r_on'
	  });
	  //tab switch end----------
	  //nav start
	  function active(this_ele,index){
		  var mouseover_tid = [];
		  var mouseout_tid = [];
		  $(this_ele).hover(
			  function(){
				  var _self = this;
				  clearTimeout(mouseout_tid[index]);
				  mouseover_tid[index] = setTimeout(function() { 
					   $(_self).children('ul:eq(1)').slideDown(200); 
				  }, 200);
			  },function(){
				  var _self = this;
				  clearTimeout(mouseover_tid[index]);
				  mouseout_tid[index] = setTimeout(function() { 
					 $(_self).children('ul:eq(1)').slideUp(100); 
				  }, 200);
			  }
		  );	 
		}
		active('#mainNav',0);
		//nav end
	
});