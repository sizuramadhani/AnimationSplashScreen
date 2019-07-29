package com.sizura.animsplashadakita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgcloud1,imgcloud2,imgcloud3,imgcar;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgcloud1 = findViewById(R.id.imgcloud1);
        imgcloud2 = findViewById(R.id.imgcloud2);
        imgcloud3 = findViewById(R.id.imgcloud3);
          imgcar = findViewById(R.id.car);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_left);
        imgcloud2.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_rightt);
        imgcloud3.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_right);
        imgcar.setAnimation(animation);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }
}
