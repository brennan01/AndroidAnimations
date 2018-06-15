package com.southernslights.androidanimations;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button myButton;
    Button myButtonUp;
    TextView textView1;
    TextView textView2;
    View mLineView;
    Button mStretchButton;
    boolean isUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myButton = findViewById(R.id.my_button);
        myButtonUp = findViewById(R.id.my_button2);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);

        // initialize as invisible (could also do in xml)
        myButton.setText("Slide up");

        mLineView = findViewById(R.id.line);
        mStretchButton = findViewById(R.id.stretch);

        isUp = false;
    }

    // slide the view from below itself to the current position
    public void slideUp(View view, float toAlpha) {
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.animate().setDuration(500).alpha(toAlpha);

    }

    // slide the view from its current position to below itself
    public void slideDown(View view, float toAlpha) {
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.animate().setDuration(500).alpha(toAlpha);
    }

    // slide the view from below itself to the current position
    public void slideUpPlus(View view, float toAlpha) {
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,  // fromYDelta
                -view.getHeight());                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.animate().setDuration(500).alpha(toAlpha);


    }

    public void onSlideViewButtonClick(View view) {
        if (isUp) {
//            slideDown(myView);
            slideUp(textView1, 0);
            slideUp(textView2, 1);
            myButton.setText("Slide up");
        } else {
//            slideUp(myView);
            slideDown(textView1, 1);
            slideDown(textView2, 0);
            myButton.setText("Slide down");
        }
        isUp = !isUp;
    }

    public void onSlideUp(View view) {
        slideUpPlus(textView1, 0);
        slideUpPlus(textView2, 1);
        myButton.setText("Slide up");
    }

    public void onStretchProgrammatically(View view) {

//        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale_up);
//        mLineView.startAnimation(a);

//    public ScaleAnimation(float fromX, float toX, float fromY, float toY,
//        int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {

            Animation animation = new ScaleAnimation(0, 1, 1, 1,
                    Animation.RELATIVE_TO_SELF, (float) 0.5, Animation.RELATIVE_TO_SELF, 1);
            animation.setFillAfter(true);
            animation.setDuration(200);
            mLineView.startAnimation(animation);
//        TranslateAnimation animate = new TranslateAnimation(
//                0,                 // fromXDelta
//                0,                 // toXDelta
//                0,  // fromYDelta
//                -view.getHeight());                // toYDelta
//        animate.setDuration(500);
//        animate.setFillAfter(true);
//        view.startAnimation(animate);
//        view.animate().setDuration(500).alpha(toAlpha);


    }


    public void onCompress(View view) {

//        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale_up);
//        mLineView.startAnimation(a);

//    public ScaleAnimation(float fromX, float toX, float fromY, float toY,
//        int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {

        Animation animation = new ScaleAnimation(1, 0, 1, 1,
                Animation.RELATIVE_TO_SELF, (float) 0.5, Animation.RELATIVE_TO_SELF, 1);
        animation.setFillAfter(true);
        animation.setDuration(200);
        mLineView.startAnimation(animation);
//        TranslateAnimation animate = new TranslateAnimation(
//                0,                 // fromXDelta
//                0,                 // toXDelta
//                0,  // fromYDelta
//                -view.getHeight());                // toYDelta
//        animate.setDuration(500);
//        animate.setFillAfter(true);
//        view.startAnimation(animate);
//        view.animate().setDuration(500).alpha(toAlpha);


    }



}
