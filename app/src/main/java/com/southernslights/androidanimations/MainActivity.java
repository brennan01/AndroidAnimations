package com.southernslights.androidanimations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup transitionsContainer = findViewById(R.id.transitions_container);
        final TextView text = transitionsContainer.findViewById(R.id.text);

        final Button button = transitionsContainer.findViewById(R.id.button);
        final Button main2button = transitionsContainer.findViewById(R.id.activity2);

        main2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);
            }

        });

        final Button button2 = transitionsContainer.findViewById(R.id.button2);
        final TextView text2 = transitionsContainer.findViewById(R.id.text2);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                TextScale textScale = new TextScale();
                TransitionSet transitionSet = new TransitionSet();
//                transitionSet.addTransition(textScale);
                transitionSet.addTransition(new Fade());
                transitionSet.addTransition(new ChangeBounds());
                transitionSet.addTransition(new Slide());
                TransitionManager.beginDelayedTransition(transitionsContainer, transitionSet);


//                transitionSet.addTransition(new Rotate());

//                ObjectAnimator anim = ObjectAnimator.ofFloat(text2, "ScaleY", 0, 1);
//                anim.setDuration(300);
//                anim.start();
//                TransitionManager.beginDelayedTransition(transitionsContainer);
//                visible = !visible;
//                text.setVisibility(visible ? View.VISIBLE : View.GONE);
            }

        });

        final Button button3 = transitionsContainer.findViewById(R.id.button3);
        final TextView text3 = transitionsContainer.findViewById(R.id.text3);
        final TextView text4 = transitionsContainer.findViewById(R.id.text4);

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                fadeOutToTop(text3, text4);
//                fadeOutToBottom(text3);
//                fadeInFromBottom(text4);
            }

        });

        final Button button4 = transitionsContainer.findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                fadeOutToBottom(text4);
                fadeInFromBottom(text3);            }



        });

    }

    private void fadeInFromBottom(TextView text) {
        final TextView view = text;
        // Prepare the View for the animation
        view.animate()
                .translationY(0)
                .alpha(1.0f)
                .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void fadeInFromTop(TextView text) {
        final TextView view = text;
        // Prepare the View for the animation
        view.animate()
                .translationY(0)
                .alpha(1.0f)
                .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void fadeOutToBottom(TextView text) {
        TextView view = text;
        // Prepare the View for the animation
        view.setVisibility(View.VISIBLE);
        view.setAlpha(1.0f);

// Start the animation
        view.animate()
                .translationY(view.getHeight())
                .setDuration(300)
                .alpha(0.0f)
                .setListener(null);
    }


    private void fadeOutToTop(TextView text, final TextView textNew) {
        TextView view = text;
        // Prepare the View for the animation
        view.setVisibility(View.VISIBLE);
        view.setAlpha(1.0f);


// Start the animation
        view.animate()
                .translationY(- view.getHeight())
                .setDuration(300)
                .alpha(0.0f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
//                        textNew.setVisibility(View.VISIBLE);
                        textNew.animate()
                                .translationY(textNew.getHeight())
                                .setDuration(300)
                        .alpha(1.0f);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
}
