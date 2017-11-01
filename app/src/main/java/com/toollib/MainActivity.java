package com.toollib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {


    ImageView imageView;

    boolean aBoolean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);/* setContentView(R.la);*/
        setContentView(R.layout.show);

        imageView = (ImageView) findViewById(R.id.imgshowview);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   if (!aBoolean) {
//selectableItemBackgroundBorderless
                    imageView.setBackground(getDrawable(R.drawable.showbroud));
                } else {
                    imageView.setBackground(null);
                }
*/

                aBoolean = !aBoolean;

            }
        });


    }
/*

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
*/

}
