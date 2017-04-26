package com.toollibrary.tool;

import android.content.Context;
import android.content.Intent;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.toollibrary.tool.imagviewpagershow.ImagePagerActivity;


import java.util.ArrayList;

/**
 * Created by 李双 on 2017/1/19.
 * <p>
 * 图片查看器
 */

public class ImgShowHelper {
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";


    /**
     * 显示多个  图片
     *
     * @param context  上下文
     * @param position 最开始显示第几个
     * @param urls2    图片的集合
     */
    public static void imageBrower(Context context, int position, ArrayList<String> urls2) {   // 用于更新点击
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        Intent intent = new Intent(context, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(EXTRA_IMAGE_URLS, urls2);
        intent.putExtra(EXTRA_IMAGE_INDEX, position);
        context.startActivity(intent);
    }

    /**
     * 单张图片
     * 需要添加 UrlHead
     *
     * @param context
     * @param position
     * @param imgurl
     */
    public static void imageBrower(Context context, int position, String imgurl) {   // 用于更新点击
        ArrayList<String> strings = new ArrayList<>();
        strings.add(imgurl);
        Intent intent = new Intent(context, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(EXTRA_IMAGE_URLS, strings);
        intent.putExtra(EXTRA_IMAGE_INDEX, position);
        context.startActivity(intent);
    }

}
