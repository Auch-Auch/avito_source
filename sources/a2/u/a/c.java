package a2.u.a;

import android.view.animation.AlphaAnimation;
import com.warkiz.widget.IndicatorSeekBar;
public class c implements Runnable {
    public final /* synthetic */ IndicatorSeekBar a;

    public c(IndicatorSeekBar indicatorSeekBar) {
        this.a = indicatorSeekBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(180);
        this.a.U.setAnimation(alphaAnimation);
        this.a.z();
        this.a.U.setVisibility(0);
    }
}
