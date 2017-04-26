package com.toollib;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.toollibrary.R;
import com.toollibrary.viewutil.webview.WebViewUtil;

/**
 * Created by 李双 on 2017/3/19.
 */

public class WebviewActivity extends Activity {


    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        webView = (WebView) findViewById(R.id.web_view);

        new WebViewUtil(WebviewActivity.this, webView, progressBar, "https://www.hao123.com/?tn=95358957_hao_pg", true) {
            @Override
            public void DialNoPhon(String tellno) {


            }
        };

    }
}
