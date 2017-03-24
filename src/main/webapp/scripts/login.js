function userLogin(){
		//获取数据	
	 var username=$("#count").val().trim();
	 var pwd=$("#password").val().trim();
	 //每次置空提示
	 console.log(username,pwd);
	 $("#count_span").html("");
	 $("#password_span").html("");
	 var status=true;
	 if(username==""){
		 $("#count_span").html("用户名不能为空");
		 status=false;
	 }
	 if(pwd==""){
		 
		 $("#password_span").html("密码不能为空");
		 status=false;
	 }
	 
	 if(status==true){
		 $.ajax({
			 url:path+"/user/login.do",
			 type:"post",
			 data:{"username":username,"pwd":pwd},
			 dataType:"json",
			 success:function(result){
				 if(result.status==0){
					 //登录成功,先保存cookie再跳转页面
					 var userId=result.data.cn_user_id;
					 addCookie("userId",userId,2);
					 window.location.href="edit.html";
				 };
				 if(result.status==2){
					 $("#count_span").html("用户名不存在")
				 };
				 if(result.status==1){
					 $("password").val("");
					 $("#password_span").html("密码错误，请重新输入");
				 };

				
				 
				 
			 },
			 error:function(){
				 alert("登录中遇到了未知的问题，请稍后再试");
			 }
		 })
			 
		 
	 }
	 
		};
		
		
		
function register(){
	//获取数据
	var name=$("#regist_username").val().trim();
	var pwd=$("#regist_password").val().trim();
	var nick=$("#nickname").val().trim();
	var fpwd=$("#final_password").val().trim();
	$("#warning_1").hide();
	$("#warning_2").hide();
	
	var ok =true;
	//处理逻辑
	if(name==null||name.length<6){
		ok=false;
		$("#warning_1").show();
		$("#warning_1").html("用户名不能少于6位");
		
	}
	if(pwd==null||pwd.length<8){
		ok=false;
		$("#warning_2").show();
		$("#warning_2").html("密码不能少于8位");
	}
	if(pwd!=fpwd){
		ok=false;
	}
	
	
	//发送请求
	if(ok){
		$.ajax({
			url:path+"/user/regist.do",
			Type:"post",
			data:{"name":name,"pwd":pwd,"nick":nick},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert("注册成功，请登陆")
					$("#back").click();
				}
				if(result.status==1){
					$("#warning_1").html("用户名已被使用");
					$("#warning_1").show();
				}
			},
			error:function(){
				alert("注册遇到问题")
			}	
		})
		
	}
	
}		