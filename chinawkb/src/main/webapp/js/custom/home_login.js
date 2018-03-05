//********《版权归：903207003@qq.com所有》****************************/
window.Console={
    log:function(str){
        console.log(str);
    }
};
(function(win,$){
    var loginActive=false;
    function login(){
        if(!loginActive){
         return;
        }
        var phone=$("#phone").val();
        var phoneCode=$("#phoneCode").val();
        Console.log(LCombase.http.url.member_login);
        LCombase.http.post(LCombase.http.url.member_login,{"phone":phone,"code":phoneCode},function(responseData){
            Console.log(responseData);
            if(responseData.code==0){
                sessionStorage.revSends=0;
                window.location.href=contextPath+LCombase.http.url.member_main;
            }else{
                Console.log(responseData.message);
                alert(responseData.message);
            }
        });
    }

    //倒计时
    var JLTime={
        revTime:null,
        revSends:60,
        clearTime:function(){
            var _self=this;
            if( _self.revTime!=null){
               clearInterval(_self.revTime);
               _self.revTime=null;
            }
        },
        revTimeStart: function (id){
            var _self=this;
            var btnObj=$(id);
            btnObj.attr("disabled","true");
            _self.clearTime();
            _self.revTime=setInterval(function(){
               // console.log(_self.revSends);
                sessionStorage.revSends=_self.revSends;//放入缓存
                sessionStorage.revSendsTime=new Date().getTime();
                if(_self.revSends<=0){
                     _self.clearTime();
                     _self.revSends=60;
                    btnObj.removeAttr("disabled");
                    btnObj.text("发送验证码");
                    return;
                }

                btnObj.text("等待重发"+_self.revSends+"s");
                _self.revSends--;
            },1000);
        },
        ifTime:function(){
            var _self=this;
            var btime=sessionStorage.revSendsTime;
                if(btime && btime>0){
                var atime=new Date().getTime();
                var ctime=(atime-btime)/1000;
                if(ctime>=60){
                    sessionStorage.revSends=0;
                    _self.revSends=0;
                }
            }
        },
        cacheInterval:function(id){
            var _self=this;
            _self.ifTime();
            var revSends=sessionStorage.revSends;
            if(revSends && revSends>0){
                _self.revSends=revSends;
                _self.revTimeStart(id);
            }
        }
    }


    function colorset(){
        var phone=$("#phone").val();
        var phoneCode=$("#phoneCode").val();
        if(phone!="" && phoneCode!=""){
            $("#login_btn").addClass("activeBtn");
            loginActive=true;
        }else{
            $("#login_btn").removeClass("activeBtn");
            loginActive=false;
        }
    }

    function bind(){
        $("#login_btn").click(function(){
            login();
        });
        $("#phone,#phoneCode").keyup(function(event){
            event=event || window.event;
            var code=event.keyCode;
            if(code==13  && loginActive){
                login();
            }
            colorset();
        });
        //发送验证码
        JLTime.cacheInterval("#sendCodeBtn");//剩余时间倒计时
        $("#sendCodeBtn").click(function(){
            var phone=$("#phone").val();
            if(!phone || phone.length!=11){
                alert("请输入正确的手机号！");
                return;
            }
            JLTime.revTimeStart("#sendCodeBtn");
            LCombase.http.post(LCombase.http.url.member_sendCode,"phone="+phone,function(responseData){
                if(responseData.code==0){
                   setTimeout(function(){alert(responseData.message);},200);
                }else{
                    alert(responseData.message);
                }
            });
        });
    }

    $(function(){
        bind();
        if(true){//超时处理
            if(window.parent.length!=0){//检测父类是否有iframe
                window.parent.location.href="/?logout=true";
                return;
            }
            if(LCombase.http.getQueryString("logout")=="true"){
                //alert("登录超时,请重新登录！");
            }
        }
    });
})(window,jQuery);