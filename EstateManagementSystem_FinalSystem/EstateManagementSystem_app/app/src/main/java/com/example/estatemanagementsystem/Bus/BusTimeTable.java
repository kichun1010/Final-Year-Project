package com.example.estatemanagementsystem.Bus;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.example.estatemanagementsystem.R;

public class BusTimeTable extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout simpleTableLayout1, simpleTableLayout2, simpleTableLayout3, simpleTableLayout4, simpleTableLayout5;
    Button viewmore1, viewmore2, viewmore3, viewmore4, viewmore5;
    int height1, height2, height3, height4, height5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_time_table);

        simpleTableLayout1 = findViewById(R.id.simpleTableLayout1);
        simpleTableLayout2 = findViewById(R.id.simpleTableLayout2);
        simpleTableLayout3 = findViewById(R.id.simpleTableLayout3);
        simpleTableLayout4 = findViewById(R.id.simpleTableLayout4);
        simpleTableLayout5 = findViewById(R.id.simpleTableLayout5);

        viewmore1 = findViewById(R.id.viewmore1);
        viewmore2 = findViewById(R.id.viewmore2);
        viewmore3 = findViewById(R.id.viewmore3);
        viewmore4 = findViewById(R.id.viewmore4);
        viewmore5 = findViewById(R.id.viewmore5);

        viewmore1.setOnClickListener(this);
        viewmore2.setOnClickListener(this);
        viewmore3.setOnClickListener(this);
        viewmore4.setOnClickListener(this);
        viewmore5.setOnClickListener(this);

        simpleTableLayout1.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {

                    @Override
                    public boolean onPreDraw() {
                        simpleTableLayout1.getViewTreeObserver().removeOnPreDrawListener(this);
                        simpleTableLayout1.setVisibility(View.GONE);
                        simpleTableLayout2.setVisibility(View.GONE);
                        simpleTableLayout3.setVisibility(View.GONE);
                        simpleTableLayout4.setVisibility(View.GONE);
                        simpleTableLayout5.setVisibility(View.GONE);

                        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        simpleTableLayout1.measure(widthSpec, heightSpec);
                        height1 = simpleTableLayout1.getMeasuredHeight();
                        simpleTableLayout2.measure(widthSpec, heightSpec);
                        height2 = simpleTableLayout1.getMeasuredHeight();
                        simpleTableLayout3.measure(widthSpec, heightSpec);
                        height3 = simpleTableLayout1.getMeasuredHeight();
                        simpleTableLayout4.measure(widthSpec, heightSpec);
                        height4 = simpleTableLayout1.getMeasuredHeight();
                        simpleTableLayout5.measure(widthSpec, heightSpec);
                        height5 = simpleTableLayout1.getMeasuredHeight();
                        return true;
                    }
                });
    }


    private void expand(RelativeLayout layout, int layoutHeight) {
        layout.setVisibility(View.VISIBLE);
        ValueAnimator animator = slideAnimator(layout, 0, layoutHeight);
        animator.start();
    }

    private void collapse(final RelativeLayout layout) {
        int finalHeight = layout.getHeight();
        ValueAnimator mAnimator = slideAnimator(layout, finalHeight, 0);

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animator) {
                //Height=0, but it set visibility to GONE
                layout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        mAnimator.start();
    }


    private ValueAnimator slideAnimator(final RelativeLayout layout, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
                layoutParams.height = value;
                layout.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewmore1:
                if (simpleTableLayout1.getVisibility() == View.GONE) {
                    expand(simpleTableLayout1, height1);
                } else {
                    collapse(simpleTableLayout1);
                }
                break;

            case R.id.viewmore2:
                if (simpleTableLayout2.getVisibility() == View.GONE) {
                    expand(simpleTableLayout2, height2);
                } else {
                    collapse(simpleTableLayout2);
                }
                break;

            case R.id.viewmore3:
                if (simpleTableLayout3.getVisibility() == View.GONE) {
                    expand(simpleTableLayout3, height3);
                } else {
                    collapse(simpleTableLayout3);
                }
                break;

            case R.id.viewmore4:
                if (simpleTableLayout4.getVisibility() == View.GONE) {
                    expand(simpleTableLayout4, height4);
                } else {
                    collapse(simpleTableLayout4);
                }
                break;

            case R.id.viewmore5:
                if (simpleTableLayout5.getVisibility() == View.GONE) {
                    expand(simpleTableLayout5, height5);
                } else {
                    collapse(simpleTableLayout5);
                }
                break;
        }
    }
}

