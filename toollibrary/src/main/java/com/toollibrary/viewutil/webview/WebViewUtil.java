package com.toollibrary.viewutil.webview;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.toollibrary.tool.httprequest.WangLuoUtil;

/**
 * Created by 李双 on 2017/3/19.
 */
public abstract class WebViewUtil {

    /**
     * @param context
     * @param mWebView    Webview
     * @param progressBar ProgressBar 进度条
     * @param urlstr      URL
     * @param b           true  如果 本地有网络就读取缓存的数据，缓存没有就读取
     */
    public WebViewUtil(Context context, WebView mWebView, final ProgressBar progressBar, String urlstr, boolean b) {
        WebSettings settings = mWebView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
/*
        缓存模式(5种)
        LOAD_CACHE_ONLY:  不使用网络，只读取本地缓存数据
        LOAD_DEFAULT:  根据cache-control决定是否从网络上取数据。
        LOAD_CACHE_NORMAL
        LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
       LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。*/

        if (b) {
            if (WangLuoUtil.isNetworkConnected(context)) {
                settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            } else {
                settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
            }
        } else {
            settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        }
        String cacheDirPath = context.getCacheDir().getAbsolutePath() + "/" + context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        settings.setJavaScriptEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // 开启 DOM storage API 功能
        settings.setDomStorageEnabled(true);
        //开启 database storage API 功能
        settings.setDatabaseEnabled(true);
        //设置数据库缓存路径
        settings.setDatabasePath(cacheDirPath);
        settings.setAppCacheMaxSize(1024 * 1024 * 5);  //设置 最大缓存长度
        //设置  Application Caches 缓存目录
        settings.setAppCachePath(cacheDirPath);
        //开启 Application Caches 功能
        settings.setAppCacheEnabled(true);

        mWebView.loadUrl(urlstr);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, final String url) {
                if (url.startsWith("tel:")) {
            /*        Intent intent = new Intent(Intent.ACTION_VIEW,  拨打电话
                            Uri.parse(url));
                    startActivity(intent);*/

                    DialNoPhon(url);
                } else if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                }
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setProgress(newProgress);//设置加载进度
                }
            }
        });
    }

    public abstract void DialNoPhon(String urlno);
}
