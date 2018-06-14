package com.southernslights.androidanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button myButton;
    Button myButtonUp;
    View myView;
    TextView textView1;
    TextView textView2;
    boolean isUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myView = findViewById(R.id.my_view);
        myButton = findViewById(R.id.my_button);
        myButtonUp = findViewById(R.id.my_button2);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);

        // initialize as invisible (could also do in xml)
        myView.setVisibility(View.INVISIBLE);
        myButton.setText("Slide up");

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


}
