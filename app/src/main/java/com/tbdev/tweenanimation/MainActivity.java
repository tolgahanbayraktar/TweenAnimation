package com.tbdev.tweenanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView mImageView;

    private Animation mRotateAnim;
    private Animation mScaleAnim;
    private Animation mTranslateAnim;
    private Animation mAlphaAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.volleyball);
    }

    public void startFrameAnimation(View view) {
        ImageView dummyFrame = (ImageView) findViewById(R.id.imageFrame);
        dummyFrame.setBackgroundResource(R.drawable.frame);
        Toast.makeText(this, "Hiii", Toast.LENGTH_SHORT).show();


        AnimationDrawable frameAnimation = (AnimationDrawable) dummyFrame.getBackground();

        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        } else {
            frameAnimation.start();
        }
    }

    public void scaleAnimation(View view) {

        mScaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        mScaleAnim.setAnimationListener(this);
        mImageView.startAnimation(mScaleAnim);
    }

    public void translateAnimation(View view) {

        mTranslateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        mTranslateAnim.setAnimationListener(this);
        mImageView.startAnimation(mTranslateAnim);
    }

    public void alphaAnimation(View view) {
        mAlphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        mAlphaAnim.setAnimationListener(this);
        mImageView.startAnimation(mAlphaAnim);
    }

    public void rotateAnimation(View view) {

        mRotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        mRotateAnim.setAnimationListener(this);
        mImageView.startAnimation(mRotateAnim);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        //  if(animation==mRotateAnim)
        Toast.makeText(this, "Animasyon Başladı", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(this, "Animasyon Bitti", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(this, "Animasyon Tekrar Etti", Toast.LENGTH_LONG).show();
    }
}
