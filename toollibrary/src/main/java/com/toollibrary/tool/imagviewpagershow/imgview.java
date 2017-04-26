package com.toollibrary.tool.imagviewpagershow;/*
package com.example.administrator.mybeike.Utils.imagviewpagershow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.myapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

*/
/**
 * Created by Administrator on 2016/9/13.
 *//*

public class imgview extends Activity {
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";
    ImageLoader imageLoader = ImageLoader.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgvirew);
        //  imageLoader.init
        //  ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(getBaseContext()));
        imageLoader.init(ImageLoaderConfiguration.createDefault(imgview.this));

        ArrayList<String> arrlist = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            arrlist.add("https://gss0.bdstatic.com/5eR1dDebRNRTm2_p8IuM_a/res/img/richanglogo168_24.png");
        }
        imageBrower(1, arrlist);
    }

    */
/**
     * 打开图片查看器
     *
     * @param position
     * @param urls2
     *//*

    protected void imageBrower(int position, ArrayList<String> urls2) {
        Intent intent = new Intent(imgview.this, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(EXTRA_IMAGE_URLS, urls2);
        intent.putExtra(EXTRA_IMAGE_INDEX, position);
        startActivity(intent);
    }
}
*/
