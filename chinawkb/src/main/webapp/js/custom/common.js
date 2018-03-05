(function(doc,win,$){
    /*******tab切换页面跳转返回自动还原tab项插件**/
    /*******jquery ready之前加入执行方法*********/
    doc.ready = function (callback) {
        ///兼容FF,Google
        if (document.addEventListener) {
            document.addEventListener('DOMContentLoaded', function () {
                document.removeEventListener('DOMContentLoaded', arguments.callee, false);
                LJsReadyBefore.exec();
                callback();
            }, false)
        }
         //兼容IE
        else if (document.attachEvent) {
            document.attachEvent('onreadytstatechange', function () {
                  if (document.readyState == "complete") {
                            document.detachEvent("onreadystatechange", arguments.callee);
                            LJsReadyBefore.exec();
                            callback();
                   }
            })
        }
        else if (document.lastChild == document.body) {
            LJsReadyBefore.exec();
            callback();
        }
    }
    LJsReadyBefore={
        "before":{},
        "bind":function(name,func){
            this.before[name]=func;
        },
        "exec":function(){
            var beforeObj=this.before;
            for(var name in beforeObj){
                var func=beforeObj[name];
                typeof func =='function' && func();
            }
        }
    };

    $.fn.extend({
        ready:function(callback){
          document.ready(callback);
        }
    });

    $.extend({
        includePath: '',
        include: function(file,callback){
            var files = typeof file == "string" ? [file] : file;
            for (var i = 0; i < files.length; i++){
                var name = files[i].replace(/^\s|\s$/g, "");
                var att = name.split('.');
                var ext = att[att.length - 1].toLowerCase();
                var isCSS = ext == "css";
                var tag = isCSS ? "link" : "script";
                var attr = isCSS ? " type='text/css' rel='stylesheet' " : " language='javascript' type='text/javascript' ";
                var link = (isCSS ? "href" : "src") + "='" +  name + "'";
                if ($(tag + "[" + link + "]").length == 0){
                    document.write("<" + tag + attr + link + "></" + tag + ">");
                }
            }
            typeof callback =='function' && callback();
        }
    });

    //LJsReadyBefore.bind("bindEvent",bindEvent);
})(document,window,jQuery);
(function(win){
    var getRootPath=win.rootPath=function(){
        //获取当前网址，如： http://localhost:8088/test/test.jsp
        var curPath=window.document.location.href;
        //获取主机地址之后的目录，如： test/test.jsp
        var pathName=window.document.location.pathname;
        var pos=curPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8088
        var localhostPaht=curPath.substring(0,pos);
        //获取带"/"的项目名，如：/test
        var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
        return localhostPaht;
    }
    win.contextPath=getRootPath();
    win.LCombase={
       "http":{
           "url":{"login":"/admin/security_login","main_page":"/admin/security_main","login_page":"/admin/login"
           ,"login_member_page":"/","member_login":"/web/logincheck","member_sendCode":"/web/sendCode","member_main":"/web/member_main.html"},
           "getQueryString":function(name){
               var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
               var r = window.location.search.substr(1).match(reg);
               if (r != null) return unescape(r[2]); return null;
           },
           "post":function(url,params,callback){
               var _self=this;
               if(typeof callback =='undefined'){
                   callback=params;
                   params={};
               }
               $.post(contextPath+url,params,function(reponseData){
                   if(reponseData && reponseData.code==-1){
                       console.log("后台用户登录超时!!!!!!");
                       LCombase.toLoginPage();
                       return;
                   }else if(reponseData && reponseData.code==-2){
                       console.log("前台用户登录超时!!!!!!");
                       LCombase.toMemberLoginPage();
                       return;
                   }
                   callback && callback(reponseData);
               });
           },
           ajax:function(url,obj,callback){
                if(obj && obj.constructor== String){
                    obj=this.paramsToObj(obj);
                }
                var data=JSON.stringify(obj);
                if(typeof angular !='undefined'){//也可以使用 obj=angular.copy(obj); 代替，处理angular的$$hashKey的问题
                    data=angular.toJson(obj);
                }
                $.ajax({
                    url: url,
                    type: "POST",
                    contentType : 'application/json;charset=utf-8', //设置请求头信息
                    //dataType:"json",
                    data: data,
                    success: function(reponseData){
                       if(reponseData && reponseData.code==-1){
                           LCombase.toLoginPage();
                           return;
                       }
                       callback && callback(reponseData);
                    },
                    error: function(reponseData){
                       var path = window.location.pathname;
                       var status=reponseData.status;
                       var log=status+"|"+path+"|"+(JSON.stringify(data));
                       LCombase.http.post("/",{log:log},function(){});
                       alert("系统错误，请联系系统管理员!");
                       //callback && callback(reponseData);
                    }
                });

           },
           paramsToObj:function(params){
              if(typeof params=='undefined' || params==null || params==''){
                return {};
              }
                params=decodeURIComponent(params);
               var reg_para = /([^&=]+)=([\w\W]*?)(&|$|#)/g,
               ret = {};
               var result;
               while ((result = reg_para.exec(params)) != null) {
                    ret[result[1]] = result[2];
               }
               return ret;
           }

       },
        "toMainPage":function(){
            window.location.href=contextPath+LCombase.http.url.main_page;
        },
        "toLoginPage":function(params){
            if(params!="" && (typeof params !='undefined')){
                window.location.href=contextPath+LCombase.http.url.login_page+"?"+params;
            }else {
                window.location.href = contextPath + LCombase.http.url.login_page;
            }
        },
         "toMemberLoginPage":function(params){
                    if(params!="" && (typeof params !='undefined')){
                        window.location.href=contextPath+LCombase.http.url.login_member_page+"?"+params;
                    }else {
                        window.location.href = contextPath + LCombase.http.url.login_member_page;
                    }
                },
        "onReloadPage":function(){
            window.location.reload(true);
        },
        "goBack":function(){
            win.history.go(-1);
        },
       "constant":{
        },
        "strToObject":function(params){
            var obj={};
            if(params=="" ||(typeof params=='undefined')){
                return obj;
            }
            var arr=params.split("&");
            for(var i=0;i<arr.length;i++){
                var arr1=arr[i].split("=");
                obj[arr1[0]]=arr1[1];
            }
            return obj;
        },
        "mouseToggle":function(cls){
            $("."+cls).bind({"mouseenter":function(){
                $("."+cls+"_item",this).slideDown(200);
            },"mouseleave":function () {
                $("."+cls+"_item",this).hide();
            }})
        },
        bindScrollTop:function (cls) {
           $("."+cls).bind('click',function(){
                $(window).scrollTop(0);
            });
        },
        ajaxFileUpload:function(url,id,options) {
           options = options || {};
           var _proccess=$("#"+id).parent().find(".proccess");
           $("#"+id).fileupload({
                  url: url,
                  dataType: 'json',
                  //autoUpload: false,
                  //acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
                  maxFileSize: 5000000, // 5 MB
                  // Enable image resizing, except for Android and Opera,
                  // which actually support image resizing, but fail to
                  // send Blob objects via XHR requests:
                  disableImageResize: /Android(?!.*Chrome)|Opera/
                      .test(window.navigator.userAgent),
                  previewMaxWidth: 100,
                  previewMaxHeight: 100,
                  previewCrop: true
           }).on('fileuploadadd', function (e, data) {

           }).on('fileuploadprocessalways', function (e, data) {

           }).on('fileuploadprogressall', function (e, data) {
              var progress = parseInt(data.loaded / data.total * 100, 10);
               _proccess.css("display","block");
               if(progress>=100){
                    _proccess.animate({"width":progress+"%"},600,function(){
                        _proccess.hide();
                    });
                }else{
                    _proccess.animate({"width":progress+"%"},1000);
                }
              options.progress && options.progress(progress);
           }).on('fileuploaddone', function (e, data) {
               options.finish && options.finish(null,data);
           }).on('fileuploadfail', function (e, data) {
               options.finish && options.finish("error",data);
           }).prop('disabled', !$.support.fileInput)
           .parent().addClass($.support.fileInput ? undefined : 'disabled');
       },
       autoCacheObj:{},
       autoComplete:function(ele,callback){
            var _self=this;
            var  inputObj=$(ele);
            var  options=JSON.parse(inputObj.attr("auto-conf"));
            if(inputObj.length<=0){return;}
             inputObj.autocomplete({
                minChars:0,
                lookupLimit: 8,
                //serviceUrl:inputObj.attr("auto-url"),
                lookup: function (query, done) {
                        console.log(query);
                        var result = {
                            suggestions: [
                                { "value": "未找到匹配", "data": {} }
                            ]
                        };
                        var suggestions=[],url=options.url,paramObj={};
                        if(url.indexOf("?")!=-1){
                            var arra=url.split("?");
                            url=arra[0];
                            paramObj=_self.http.paramsToObj(arra[1]);
                        }
                        if(_self.autoCacheObj){
                            for(var name in _self.autoCacheObj){
                                paramObj[name]=_self.autoCacheObj[name];
                            }
                        }
                        paramObj.searchKey=query;
                        console.log(JSON.stringify(paramObj));
                        var label=options.label;
                        _self.http.post(url,paramObj ,function(res){
                            if(res.code==0){
                                var list=res.body;
                                if(list && list.length>0){
                                     result.suggestions=[];
                                    for(var i=0;i<list.length;i++){
                                        var obj={
                                            value:list[i][label],
                                            data: list[i]
                                        }
                                        result.suggestions.push(obj);
                                    }
                                }
                                done(result);
                            }
                        });
                    },
                onSelect: function (suggestion) {
                    var autoSet=options.setId;
                    var callback=options.call;
                    try{
                    eval(callback+"('"+autoSet+"',"+JSON.stringify(suggestion.data)+")");
                    }catch(e){console.log(e);}

                }
            });
            (typeof callback == 'function') && callback(win);
       }

}


Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
})(window);