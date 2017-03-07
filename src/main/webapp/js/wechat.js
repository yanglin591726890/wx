/**
 * Created by yanglin on 2017/1/7.
 */

var baseUrl = $("base").attr("href");
var title = $("#title").val();
var desc = $("#desc").val();
var pageId = $("#pageid").val()
var link = baseUrl+"/share/pageShare?id="+pageId;
var imgUrl = baseUrl+$("#imgUrl").val();
var openid =$("#openid").val();



// 1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
wechatonMenuShareAppMessage = function (title,link,imgUrl,desc) {
    wx.onMenuShareAppMessage({
        title: title,
        desc: desc,
        link: link,
        imgUrl: imgUrl,
        trigger: function (res) {
            console.log('用户点击发送给朋友');
        },
        success: function (res) {
            alert("分享成功");
            sharePageAdapter("appMessage");
        },
        cancel: function (res) {
            console.log('已取消');
        },
        fail: function (res) {
            alert("操作失败");
        }
    });
}
// 2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
wechatonMenuShareTimeline = function (title,link,imgUrl,desc) {
    wx.onMenuShareTimeline({
        title: title,
        desc: desc,
        link: link,
        imgUrl: imgUrl,
        trigger: function (res) {
            console.log('分享到朋友圈');
        },
        success: function (res) {
            alert("分享成功");
            sharePageAdapter("timeLine");
        },
        cancel: function (res) {
            console.log('已取消');
        },
        fail: function (res) {
            alert("操作失败");
        }
    });
}

// 3 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口
wechatonMenuShareQQ = function (title,link,imgUrl,desc) {
    wx.onMenuShareQQ({
        title: title,
        desc: desc,
        link: link,
        imgUrl: imgUrl,
        trigger: function (res) {
            console.log('用户点击分享到QQ');
        },
        success: function (res) {
            sharePageAdapter("QQ");
        },
        cancel: function (res) {
            console.log('已取消');
        },
        fail: function (res) {
            alert("操作失败");
        }
    });
}
// 4 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口
wechatonMenuShareWeibo = function (title,link,imgUrl,desc) {
    wx.onMenuShareWeibo({
        title: title,
        desc: desc,
        link: link,
        imgUrl: imgUrl,
        trigger: function (res) {
            console.log('用户点击分享到微博');
        },
        success: function (res) {
            sharePageAdapter("weibo");
        },
        cancel: function (res) {
            console.log('已取消');
        },
        fail: function (res) {
            alert("操作失败");
        }
    });
}
// 5 监听“分享到qq空间”按钮点击、自定义分享内容及分享结果接口
wechatonMenuShareQZone = function (title,link,imgUrl,desc) {
    wx.onMenuShareQZone({
        title: title,
        desc: desc,
        link: link,
        imgUrl: imgUrl,
        trigger: function (res) {
            console.log('用户点击分享到qq空间');
        },
        success: function (res) {
            sharePageAdapter("QZone");
        },
        cancel: function (res) {
            console.log('已取消');
        },
        fail: function (res) {
            alert("操作失败");
        }
    });
}

$(document).ready(function () {
    //文档加载成功后使用ajax来获取配置参数
    $.ajax({
        url: baseUrl+'/ticket/signature',
        async: true,
        type: 'POST',
        data : {
            "url" : window.location.href
        },
        cache : false,
        dataType : 'json',
        success: function (data) {
            console.log(data)
            wx.config({
                debug: false,
                appId: data.appid,
                timestamp: data.timestamp,
                nonceStr: data.noncestr,
                signature: data.signature,
                jsApiList: [
                    'checkJsApi',
                    'onMenuShareTimeline',
                    'onMenuShareAppMessage',
                    'onMenuShareQQ',
                    'onMenuShareWeibo',
                    'onMenuShareQZone',
                    'chooseImage',
                    'previewImage',
                    'uploadImage',
                    'downloadImage',
                ]
            });
            wx.error(function (res) {
                console.log(res.errMsg);
            });

            wx.ready(function () {
                wx.checkJsApi({
                    jsApiList: [
                        'checkJsApi',
                        'previewImage',
                        'onMenuShareTimeline',
                        'onMenuShareAppMessage',
                        'onMenuShareQQ',
                        'onMenuShareWeibo',
                        'onMenuShareQZone'
                    ],
                    success: function (res) {
                        // 分享接口
                        wechatonMenuShareAppMessage(title,link,imgUrl,desc);
                        wechatonMenuShareTimeline(title,link,imgUrl,desc);
                        wechatonMenuShareQQ(title,link,imgUrl,desc);
                        wechatonMenuShareWeibo(title,link,imgUrl,desc);
                        wechatonMenuShareQZone(title,link,imgUrl,desc);
                    }
                });
                // 5 图片接口
                // 5.1 拍照、本地选图
                var images = {
                    localId: [],//本地，可以用于在页面上显示
                    serverId: []//服务器上的，上传之后才有
                };
                document.querySelector('#chooseImage').onclick = function () {
                    wx.chooseImage({
                        count:3,//上传3张
                        success: function (res) {
                            images.localId = res.localIds;
                            alert('已选择 ' + res.localIds.length + ' 张图片');
                            $("#img1").attr("src",images.localId[0]);
                            $("#img2").attr("src",images.localId[1]);
                            $("#img3").attr("src",images.localId[2]);

                        }
                    });
                };

                // 5.3 上传图片
                document.querySelector('#uploadImage').onclick = function () {
                    if (images.localId.length == 0) {
                        alert('请先使用 chooseImage 接口选择图片');
                        return;
                    }
                    var i = 0, length = images.localId.length;
                    images.serverId = [];

                    function upload() {
                        wx.uploadImage({
                            localId: images.localId[i],
                            success: function (res) {
                                i++;
                                images.serverId.push(res.serverId);
                                if (i < length) {
                                    upload();
                                }else {
                                    var data =JSON.stringify({
                                        imgs:images.serverId,
                                        mediaType:'image',
                                        openid:openid
                                    });
                                    console.log(data);
                                    $.ajax({
                                        url:baseUrl+'/media/add',
                                        type: 'POST',
                                        contentType:'application/json;charset=utf-8',
                                        data : data,
                                        dataType : 'json',
                                        success:function (data) {
                                            console.log(data)
                                        },
                                        error:function (res) {
                                            console.log(res)
                                        }
                                    })
                                }
                            },
                            fail: function (res) {
                                alert(JSON.stringify(res));
                            }
                        });
                    }
                    upload();
                };
                // 5.4 下载图片
                document.querySelector('#downloadImage').onclick = function () {
                    if (images.serverId.length === 0) {
                        alert('请先使用 uploadImage 上传图片');
                        return;
                    }
                    var i = 0, length = images.serverId.length;
                    images.localId = [];
                    function download() {
                        wx.downloadImage({
                            serverId: images.serverId[i],
                            success: function (res) {
                                i++;
                                alert('已下载：' + i + '/' + length);
                                images.localId.push(res.localId);
                                if (i < length) {
                                    download();
                                }
                            }
                        });
                    }
                    download();
                };

            });
        },
        error: function (e) {
            alert("错误");
            console.log(e);
        }
    });

});

//统计分享
sharePage = function (contentId,shareType) {
    var s = JSON.stringify({
        sharetype:shareType,
        pageid:contentId
    });
    console.log(s);
    $.ajax({
        url: baseUrl+'/shareCount/count',
        type: 'POST',
        contentType:'application/json;charset=utf-8',
        data : s,
        dataType : 'json',
        success:function (data) {
            console.log(data)
        },
        error:function (res) {
            console.log(res)
        }
    })
}

sharePageAdapter = function (shareType) {

    sharePage(pageId,shareType);
}