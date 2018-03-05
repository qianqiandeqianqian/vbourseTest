$.include(['/js/layer.v3.1.0/layer.js'],function(){
    ~(function(win){
        var LJsWindow={
            msg:function(msg){
                layer.msg(msg);
            },
            success:function(msg){
                layer.alert(msg,{icon: 1});
            },
            err:function(msg){
                layer.alert(msg,{icon: 5});
            },
            check:function(msg){
                layer.alert(msg,{icon: 3});
            },
            confirm:function(msg,suc,err){
                layer.confirm(msg , {
                    btn: ['确定','取消'], //按钮
                    shade: [0.4, '#393D49'] //不显示遮罩
                }, function(index){
                    typeof suc =='function' && suc();
                    layer.close(index);
                }, function(){
                    typeof err =='function' && err();
                });
            },
            open:function(title, w, h , content){
                w = w || "300px";
                h = h || "240px";
                layer.open({
                    type: 1,
                    title:title,
                    skin: 'layui-layer-rim', //加上边框
                    area: [w, h], //宽高
                    content: content
                });
            },
            openWinId:null,
            openWin:function(title,id,w,h){
                this.openWinId = layer.open({
                    type: 1,
                    anim: -1,
                    shade: [0.4, '#393D49'],
                    title: title, //不显示标题
                    area: [w, h], //宽高
                    zIndex:200,
                    content: $(id), //捕获的元素
                    cancel: function(index){
                        layer.close(index);
                        // this.content.show();
                    }
                });
            },
            closeWin:function(){
                layer.close(this.openWinId );
                //$(".xubox_close").trigger("click");
            },
            loadId:null,
            loading:function(){
                this.loadId =layer.load(1, {time: 10*1000,shade:[0.1,'#393D49']});
            },
            uloading:function(){
                layer.close(this.loadId);
            }
        }
        win.W=LJsWindow;

    })(window);
});

