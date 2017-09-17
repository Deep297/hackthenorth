package project.hackthenorth.com.hackthenorth;

/**
 * Created by Yuyang on 2017-09-16.
 */

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class loading extends AppCompatActivity{

    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);

       imageView = (ImageView)findViewById(R.id.imageView);
        if(imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
               // anim = (AnimationDrawable) imageView.getBackground();
                //anim.start();
                Intent intent = new Intent(loading.this, MainActivity.class);
                startActivity(intent);
            }
            },2000);
            }
        }



