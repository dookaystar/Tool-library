package com.toollibrary.viewutil.dialogutil;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;

import com.toollibrary.R;


/**
 * Created by 李双 on 2017/1/10.
 * 选择对话框
 */

public abstract class DilogChooseHelper {
    Dialog myDialog;
    public DilogChooseHelper(Activity context, String titlename) {
        myDialog = new Dialog(context, R.style.loading_dialog);
        myDialog.getWindow().setContentView(R.layout.chooseviewdilog);
        myDialog.setCanceledOnTouchOutside(false);
        myDialog.show();
        TextView settext = (TextView) myDialog.getWindow().findViewById(R.id.txt_content);
        settext.setText(titlename);
        myDialog.getWindow().findViewById(R.id.txt_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnclikOK();
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().findViewById(R.id.txt_over).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

    }
    public abstract void OnclikOK();

    public Dialog GetDialog() {
        return myDialog;
    }
   /* public abstract void OnclikClose();*/
}
