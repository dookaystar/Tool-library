package com.toollib;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.toollibrary.viewutil.TostUtil.TostUtilView;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    boolean aBoolean;

    AlertDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   dialog=new Dialog(MainActivity.this);*/

        myDialog = new AlertDialog.Builder(MainActivity.this).create();

/*        myDialog.getWindow().setContentView(R.layout.dilogview);
        WindowManager.LayoutParams params = myDialog.getWindow().getAttributes();
        params.width = this.getWindowManager().getDefaultDisplay().getWidth();

  *//*      params.height = 50;*//*
        myDialog.getWindow().setAttributes(params);*/

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aBoolean = !aBoolean;

                if (aBoolean) {
                    myDialog.dismiss();
                } else {
                    myDialog.show();
                    myDialog.getWindow().setContentView(R.layout.dilogview);
                    WindowManager.LayoutParams params = myDialog.getWindow().getAttributes();
                    params.width = 200;
                    params.alpha = 0.3f;
  /*      params.height = 50;*/
                    myDialog.getWindow().setAttributes(params);

                }


            }
        });
    }
}
