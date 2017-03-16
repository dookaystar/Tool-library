package com.toollibrary.viewutil.TostUtil;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.toollibrary.R;
import com.toollibrary.finalutil.Finalnt;

/**
 * Created by 李双 on 2017/3/16.
 * <p>
 * Tost 工具类
 */


public class TostUtilView {

    private static Toast toast;
    private static View view;
    private static Context context;
    private static LayoutInflater layoutInflater;
    private static ImageView ivShowPic;
    private static TextView tvShowContent;

    /**
     * 默认的提示信息
     * 用于弹出提示消息
     *
     * @param context 上下文
     * @param content 提示内容
     * @param type    正确  or  错误
     */
    public static void showShortToast(Context context, String content, boolean type) {
        if (layoutInflater == null || view == null) {
            layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.toastview, null);
            ivShowPic = (ImageView) view.findViewById(R.id.iv_show);
            tvShowContent = (TextView) view.findViewById(R.id.tv_prompt);
        }
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER, Finalnt.ZERO, Finalnt.ZERO);
            toast.setDuration(Toast.LENGTH_SHORT);
            tvShowContent.setText(content);
        } else {
            tvShowContent.setText(content);
        }
        if (type) {
            ivShowPic.setImageResource(R.mipmap.ic_toast_ok);
        } else {
            ivShowPic.setImageResource(R.mipmap.ic_toast_error);
        }
        toast.show();
    }


    static LinearLayout linearLayout;

    /***
     * * 自定义的消息提示
     * 可以修改 提示的图片
     *
     * @param context
     * @param content
     * @param icCorrect        图片
     * @param txtcolor         字体的颜色
     * @param layoutbroudcolor 背景颜色
     * @param alpha            透明度
     */
    public static void showShortToast(Context context, String content, int icCorrect, int txtcolor, int layoutbroudcolor, float alpha) {
        if (layoutInflater == null || view == null) {
            layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.toastview, null);
            linearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);
            linearLayout.setBackgroundColor(layoutbroudcolor);
            linearLayout.setAlpha(alpha);
            ivShowPic = (ImageView) view.findViewById(R.id.iv_show);
            tvShowContent = (TextView) view.findViewById(R.id.tv_prompt);
            tvShowContent.setTextColor(txtcolor);
        }
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER, Finalnt.ZERO, Finalnt.ZERO);
            toast.setDuration(Toast.LENGTH_SHORT);
            tvShowContent.setText(content);
        } else {
            tvShowContent.setText(content);
        }
        ivShowPic.setImageResource(icCorrect);
        toast.show();
    }


}
