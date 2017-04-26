package com.toollibrary.loginshareutil;

import android.content.Context;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by 李双 on 2017/3/19.
 * <p>
 * 用于分享的 方法
 * 使用此方法 必须先    ShareSDK.initSDK(WelcomActivity.this);
 */
public class MobShareUtil {

    /**
     *
     * qq 登录分享 还需要在 自己的 Mainfest 配置  activity
     * 用于分享
     *
     * @param context  上下文
     * @param platform Platform plat = ShareSDK.getPlatform(QQ.NAME);
     *                 plat.getName()
     * @param title    分享的 标题
     * @param content  分享的内容
     * @param imgurl   分享图片路径
     * @param url      分享的地址
     */
    public static void Show(Context context, String platform, String title, String content, String imgurl, String url) {
        final OnekeyShare oks = new OnekeyShare();
        //指定分享的平台，如果为空，还是会调用九宫格的平台列表界面
        if (platform != null) {
            oks.setPlatform(platform);
        }
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(content);
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(imgurl);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(content);
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(title);
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(url);
        //启动分享
        oks.show(context);
    }
}
