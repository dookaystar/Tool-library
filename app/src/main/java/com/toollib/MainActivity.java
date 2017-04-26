package com.toollib;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.toollibrary.tool.*;
import com.toollibrary.viewutil.dialogutil.CustomDialog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    boolean aBoolean;
    Button button;

    private static final long cacheSize = 1024 * 1024 * 20;//缓存文件最大限制大小20M
    private static String cachedirectory = "" + "/caches";  //设置缓存文件路径
    private static Cache cache = new Cache(new File(cachedirectory), cacheSize);  //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {  //测试缓存

                                          CustomDialog customDialog = new CustomDialog(MainActivity.this);
                                          customDialog.show();
                                    /*      OkHttpClient okHttpClient = new OkHttpClient();
                                          OkHttpClient okHttpClient1 = okHttpClient.newBuilder().addInterceptor(new CacheInterceptor()).cache(new Cache(getCacheDir(), 10240 * 1024)).connectTimeout(20, TimeUnit.SECONDS)
                                                  .readTimeout(20, TimeUnit.SECONDS)
                                                  .build();*/
                                       /*   OkHttpUtils okHttpClient2 = OkHttpUtils.initClient(okHttpClient1);
                                          okHttpClient2.getOkHttpClient().newBuilder().addInterceptor();*/

                                          //     OkHttpUtils.initClient(new OkHttpClient()).getOkHttpClient().newBuilder().addInterceptor(new CacheInterceptor()).cache(new Cache(getCacheDir(), 10240 * 1024)).connectTimeout(20, TimeUnit.SECONDS).build().newCall();

                                          /*      OkHttpUtils.get().build().buildCall()*/


                                    /*     OkHttpUtils.get().build().writeTimeOut(1000).getRequest().newBuilder().cacheControl(new CacheInterceptor())*/

                                          //     OkHttpUtils.get().build().writeTimeOut(1000).getRequest().newBuilder().cacheControl(new Cache(getCacheDir(), 10240 * 1024)).c

                                      }
                                  }

        );
    }

    public class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
            return response1;
        }
    }

}
