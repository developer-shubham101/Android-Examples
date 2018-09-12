package com.arka.shubhamsharma.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

import com.arka.shubhamsharma.R;

public class AnimationActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        constraintLayout = findViewById(R.id.main);
        resetConstraintSet.clone(constraintLayout);
        applyConstraintSet.clone(constraintLayout);
    }

    public void onApplyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        applyConstraintSet.centerHorizontally(R.id.button1, R.id.main);
        applyConstraintSet.centerHorizontally(R.id.button2, R.id.main);
        applyConstraintSet.centerHorizontally(R.id.button3, R.id.main);
        applyConstraintSet.applyTo(constraintLayout);
    }

    public void onResetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }
}
