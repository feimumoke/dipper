layui.define(['form', 'layer', 'jquery'], function (exports) {
        //顶层路径判断
        window.onload = function () {
            if (window.parent.window != window) {
                window.top.location = "/login";
            }
        };
        var form = layui.form, layer = parent.layer === undefined ? layui.layer : top.layer
        var $ = layui.jquery;
        // 字体动画
        $(".famous p").eq(0).animate({
            "left": "0%"
        }, 600);
        $(".famous p").eq(1).animate({
            "left": "0%"
        }, 400);

        /*$("#verify").click(function() {
            $(this).attr("src", "/getVerify?" + Math.random());
        })
        */
        function tog(v) {
            return v ? 'addClass' : 'removeClass';
        }

        // 添加区域点击事件
        $(document).on('mousemove', '.verify', function (e) {
            $(this)[tog(this.offsetWidth - 100 < e.clientX - this.getBoundingClientRect().left)]('onX');
        }).on('click', '.onX', function () {
            // 更换图片
            var b = $(this).css("background-image");
            console.log(b);
            $(this).css("background-image", b.replace(/[\d]{9,}/g, new Date().getTime()));// 添加随机数
        });

        document.onkeydown = function (event) {
            e = event ? event : (window.event ? window.event : null);
            if (e.keyCode == 13) {
                $("#submit").click();
            }
        };

        // 登录按钮
        form.on("submit(login)", function (data) {
            // 遍历input 判断是否为空
            var stop = false;
            $(".layui-form input").each(function () {
                if ($(this).val() == '') {
                    layer.tips("请输入" + $(this).attr("placeholder"), "." + $(this).prop("class"));
                    stop = true;
                    return false;// 退出
                }
            });
            // 停止
            if (stop) {
                return false;
            }
            $.ajax({
                type: "POST",
                url: "/login",
                data: $('form').serialize(),
                beforeSend: function () {
                    addDisabled();
                },
                success: function (r) {
                    if (r.resCode == '200') {
                        var index = layer.load(1, {
                            shade: [0.1, '#fff']
                            // 0.1透明度的白色背景
                        });
                        window.location.href = '/index';
                    } else {
                        layer.msg(r.retMsg);
                        removeDisabled();
                    }
                },
                error: function () {
                    alert("error")
                    removeDisabled();
                }
            });
            return false;
        });

        function removeDisabled() {
            $("#submit").text("Sign in").attr("disabled", false).removeClass("layui-disabled");
        }

        function addDisabled() {
            $("#submit").text("Sign in ...").attr("disabled", "disabled").addClass("layui-disabled");
        }

        //切换背景图
        var i = 0;
        $(".bgdiv img").fadeOut(0).eq(0).fadeIn(0);
        setInterval(function () {
            if ($(".bgdiv img").length > (i + 1)) {
                $(".bgdiv img").eq(i).fadeOut(1000).next("img").fadeIn(3000);
                i++;
            } else {
                $(".bgdiv img").eq(i).fadeOut(1000).siblings("img").eq(0).fadeIn(3000);
                i = 0;
            }
        }, 10000); //设定定时切换，单位为毫秒
        exports('login', {});
    }
);
