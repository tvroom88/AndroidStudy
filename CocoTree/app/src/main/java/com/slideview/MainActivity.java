package com.slideview;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //아래 뷰 보이는 부분
    private LinearLayout mBottomView;
    private ImageView mArrowUpOnBottom;
    private View mView;
    private boolean isUpArrowOnBottom;

    //popup 뷰의 애니매이션 효과
    private ObjectAnimator mDownAnimation, mUpAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아래 숨겨진 뷰 부분
        mBottomView = findViewById(R.id.ll_bottom_view);
        mArrowUpOnBottom = findViewById(R.id.image_slide_up);
        mView = findViewById(R.id.view);
        isUpArrowOnBottom = true;

        // 위로 올라오고 내려오는 animation 효과 부분
        mDownAnimation = ObjectAnimator.ofFloat(mBottomView, "translationY", 600, 0F);
        mUpAnimation = ObjectAnimator.ofFloat(mBottomView, "translationY", 0F, 600);

        mArrowUpOnBottom.setOnClickListener(v -> {
            if (isUpArrowOnBottom) {
                mArrowUpOnBottom.setImageDrawable(getResources().getDrawable(R.drawable.main_arrow_down_24));
                mView.setVisibility(View.VISIBLE);
                mDownAnimation.start();
            } else {
                mArrowUpOnBottom.setImageDrawable(getResources().getDrawable(R.drawable.main_arrow_up_24));
                mUpAnimation.start();
            }
            isUpArrowOnBottom = !isUpArrowOnBottom;
        });
    }
}