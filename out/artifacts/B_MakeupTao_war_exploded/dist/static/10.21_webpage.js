// JavaScript Document
$("ul").html($("ul").html()+$("ul").html()).css("width",$("li").outerWidth()*$("li").length+"px");
var i=0;
function toL(){
	if(i==$("li").length/2){
		i=0;
		$("ul").css("left",0);
	}
	i++;
	$("ul").animate({"left":-i*$("li").outerWidth()+"px"},2500,"linear");
}
function toR(){
	if(i==0){
		i=$("li").length/2;
		$("ul").css("left",-i*$("li").outerWidth()+"px");
	}
	i--;
	$("ul").animate({"left":-i*$("li").outerWidth()+"px"},2500,"linear");
}
var timer=setInterval(toL,1500);
$("div").on({"mouseover":function(){clearInterval(timer);},"mouseout":function(){clearInterval(timer);timer=setInterval(toL,1500);}
})
