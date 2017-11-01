package com.toollibrary.viewutil.dialogutil;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.toollibrary.R;


/**
 * Created by 李双 on 2017/3/17.
 */

public class DialogUtil {

    private static Dialog mydialog;

    public static void ShowDialog(Context context) {
        if (mydialog == null) {
            mydialog = new Dialog(context, R.style.loading_dialog);
            mydialog.setContentView(R.layout.dilogview);
            mydialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        }
        mydialog.show();
    }

    private static ProgressBar progressBar;
    private static TextView textView;
/*
    private static LinearLayout.LayoutParams linearParams;
*/

    public static void ShowDialogCustom(Context context, Drawable progresbroud, int wide,
                                        int high, String txtname, int txtcolor, int txtsize) {
        if (mydialog == null) {
            mydialog = new Dialog(context, R.style.loading_dialog);
            mydialog.setContentView(R.layout.dilogview);
            progressBar = (ProgressBar) mydialog.findViewById(R.id.progressbar);
            textView = (TextView) mydialog.findViewById(R.id.txtview);
            //indeterminateDrawable
            progressBar.setIndeterminateDrawable(progresbroud);
/*            linearParams = (LinearLayout.LayoutParams) progressBar.getLayoutParams();
            linearParams.height = high; // 当控件的高强制设成365象素
            linearParams.width = wide;
            progressBar.setLayoutParams(linearParams); // 使设置好的布局参数应用到控件aaa*/

            textView.setText(txtname);
            textView.setTextColor(txtcolor);
            textView.setTextSize(txtsize);
            mydialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        }
        mydialog.show();
    }

    public static void DissDialog() {
        if (mydialog != null) {
            mydialog.dismiss();
        }
    }
}
