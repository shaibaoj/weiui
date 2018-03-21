package vip.kuaifan.weex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import vip.kuaifan.weiui.extend.bean.OpenWinBean;
import vip.kuaifan.weiui.ui.module.weiuiModule;


public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View textView = findViewById(R.id.fullscreen_content);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(1500);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                OpenWinBean mBean = new OpenWinBean();
                mBean.setUrl("http://192.168.2.125:8081/dist/index.js");
                mBean.setUrl("http://192.168.2.134:8081/dist/index.js");
                mBean.setUrl("http://192.168.1.8:8081/dist/index.js");
                mBean.setPageType("weex");
                weiuiModule.openWin(WelcomeActivity.this, mBean);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.startAnimation(animationSet);
    }
}