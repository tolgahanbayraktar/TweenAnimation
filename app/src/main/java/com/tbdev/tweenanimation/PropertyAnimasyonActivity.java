package com.tbdev.tweenanimation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by developer on 5.10.2017.
 */

public class PropertyAnimasyonActivity extends AppCompatActivity {
    ImageView mImageView;
    private RelativeLayout relativeLayout;
    int control = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertyanimation);

        mImageView = (ImageView) findViewById(R.id.image);
        relativeLayout = (RelativeLayout) findViewById(R.id.main_relative_layout);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator;

                if (control % 2 == 0) {
                    animator = ObjectAnimator.ofObject(relativeLayout, "backgroundColor", new ArgbEvaluator(), Color.GREEN, Color.RED);

                } else {
                    animator = ObjectAnimator.ofObject(relativeLayout, "backgroundColor", new ArgbEvaluator(), Color.RED, Color.GREEN);
                }

                animator.setDuration(3000);
                animator.start();
                control++;
            }
        });
    }

    public void rotateAnimation(View view) {

        /**
         * XML ile animasyon
         */
        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
            animator.setTarget(mImageView);
            animator.start();
        }*/
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
        animator.setDuration(500);
        animator.start();
    }

    public void scaleAnimation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, "scaleX", 1f, 1.5f);
        animator.setDuration(500);
        animator.start();
       /* if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale);
            animator.setTarget(mImageView);
            animator.start();
        }*/
    }

    public void translateAnimation(View view) {

        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            Animator animator = AnimatorInflater.loadAnimator(this, R.animator.translate);
            animator.setTarget(mImageView);
            animator.start();
        }*/

        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, "translationX", 0f, 360f);
        animator.setDuration(500);
        animator.start();
    }

    public void alphaAnimation(View view) {

      /*  if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            Animator animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
            animator.setTarget(mImageView);
            animator.start();
        }*/
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageView, "alpha", 1f, 0f);
        animator.setDuration(500);
        animator.start();
    }

    public void setAnimation(View view) {
        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            Animator animator = AnimatorInflater.loadAnimator(this, R.animator.set);
            animator.setTarget(mImageView);
            animator.start();
        }*/

        AnimatorSet rootSet = new AnimatorSet();

        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
        rotateAnim.setDuration(500);


        AnimatorSet childSet = new AnimatorSet();

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mImageView, "scaleX", 1f, 2f);
        scaleX.setDuration(300);
        scaleX.start();

        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mImageView, "scaleY", 1f, 2f);
        scaleY.setDuration(300);
        scaleY.start();

        rootSet.play(rotateAnim).before(childSet);
        childSet.play(scaleX).with(scaleY);
        rootSet.start();
    }
}
