package com.toollibrary.viewutil.topview;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.toollibrary.R;

/**
 * User：Leo
 * Date：2016/11/17 0017
 * Time：14:14
 * Describe: 标题栏
 */
public class TitleBar extends RelativeLayout {
    private TextView tvMiddle, tvNext;
    private ImageView ivBack, ivNext;
    private ImageView img_point;
    private RelativeLayout relativeLayout;

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_top, this, true);
        tvMiddle = (TextView) findViewById(R.id.txt_toptitle);
        tvNext = (TextView) findViewById(R.id.txt_topnext);
        ivBack = (ImageView) findViewById(R.id.img_topback);
        ivNext = (ImageView) findViewById(R.id.img_topnext);
        img_point = (ImageView) findViewById(R.id.img_point2);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout_top);

        // 设置返回事件
        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).onBackPressed();
                }
            }
        });
    }

    // 设置标题
    public void setTitle(String titlename) {
        if (!TextUtils.isEmpty(titlename)) {
            tvMiddle.setText(titlename);
        }
    }

    // 获取NextTextView，可以进行自己的操作
    public TextView getNextTextView() {
        return tvNext;
    }

    // 获取NextImageView，可以进行自己的操作
    public ImageView getNextImageView() {
        return ivNext;
    }

    // 获取BackImageView，可以设置显示隐藏等操作
    public ImageView getBackImageView() {
        return ivBack;
    }

    // 获取BackImageView，可以设置显示隐藏等操作
    public ImageView getPointImageView() {
        return img_point;
    }

}