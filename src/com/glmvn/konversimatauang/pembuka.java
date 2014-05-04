package com.glmvn.konversimatauang;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class pembuka extends Activity {
	private ImageView su;
	private TimerTask local1;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembuka);
        su=(ImageView)findViewById(R.id.imageView1);
        Animation lcAnimation = AnimationUtils.loadAnimation(this,R.anim.myanim);
        su.startAnimation(lcAnimation);
        lcAnimation.setAnimationListener(new Animation.AnimationListener() {
			
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				local1= new TimerTask()
				{
					public void run()
					{
						pembuka.this.startActivity( new Intent(pembuka.this,MainActivity.class));
						pembuka.this.finish();
					}
				};
				
				new Timer(false).schedule(local1, 700L);
			}
		});
    }   
}
