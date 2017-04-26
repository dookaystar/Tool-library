package com.toollibrary.viewutil.dialogutil;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.toollibrary.R;


/**
 * User：Leo
 * Date：2017/3/27 0027
 * Time：18:07
 * Describe: 自定义对话框
 */
public class CustomDialog extends Dialog {

    private Button btnConfirm;//确定按钮
    private Button btnCancel;//取消按钮
    private TextView tvTitle;//消息标题文本
    private TextView tvMessage;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示内容
    private String confirmStr, cancelStr;

    private onCancelOnclickListener cancelOnclickListener;//取消按钮被点击了的监听器
    private onConfirmOnclickListener confirmOnclickListener;//确定按钮被点击了的监听器

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     */
    public void setCancelOnclickListener(String str, onCancelOnclickListener onCancelOnclickListener) {
        if (str != null) {
            cancelStr = str;
        }
        this.cancelOnclickListener = onCancelOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     */
    public void setConfirmOnclickListener(String str, onConfirmOnclickListener confirmOnclickListener) {
        if (str != null) {
            confirmStr = str;
        }
        this.confirmOnclickListener = confirmOnclickListener;
    }

    public CustomDialog(Context context) {
        super(context, R.style.custom_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(true);
        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (confirmOnclickListener != null) {
                    confirmOnclickListener.onConfirmClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelOnclickListener != null) {
                    cancelOnclickListener.onCancelClick();
                }
            }
        });
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            tvTitle.setText(titleStr);
        }
        if (messageStr != null) {
            tvMessage.setText(messageStr);
        }
        //如果设置按钮的文字
        if (confirmStr != null) {
            btnConfirm.setText(confirmStr);
        }
        if (cancelStr != null) {
            btnCancel.setText(cancelStr);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        btnConfirm = (Button) findViewById(R.id.btn_confirm);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvMessage = (TextView) findViewById(R.id.tv_message);
    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置dialog的message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onConfirmOnclickListener {
        public void onConfirmClick();
    }

    public interface onCancelOnclickListener {
        public void onCancelClick();
    }
}
