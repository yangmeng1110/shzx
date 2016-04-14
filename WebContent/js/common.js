
  /**ajax json拦截未登录*/
  function filterNoLogin(jsonData){
  	if(jsonData.noLogin=='noLogin'){
  		window.top.location.href=ctx+"/index.jsp";	
		return false;
  	}
  	return true;
  }
  
 /**ajax请求提交*/ 
  function CommonAjaxJson(url,param,callback,async){
  	if(async==undefined) async==true;
  	$.ajax({
  		type:"post",
  		async:async,
  		url:url,
  		data:param,
  		dataType:"json",
  		success:function(data){
  				callback(data);
  		}
  	});
  }
  

/*关闭Dialog*/
function closeDialog(){
	Dialog.close();
}  
  
/*消息提醒*/  
function messageTip(code){
	var msg;
	if(1 == code){
		$.messageTip.success({
			message:'操作成功',
			fadeInTimeOut : 1,   //滑入秒数
		    contentTimeOut : 2,  //内容停留秒数
		    fadeOutTimeOut : 1, ////滑出秒数
		    zIndex : 9999,
		    position:'top'
		});
	}else{
		$.messageTip.error({
			message:'操作失败',
			fadeInTimeOut : 1,   //滑入秒数
		    contentTimeOut : 2,  //内容停留秒数
		    fadeOutTimeOut : 1, ////滑出秒数
		    zIndex : 9999,
		    position:'top'
		});
	}
}
  
  
  