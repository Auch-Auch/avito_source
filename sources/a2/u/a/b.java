package a2.u.a;

import android.animation.ValueAnimator;
import com.warkiz.widget.Indicator;
import com.warkiz.widget.IndicatorSeekBar;
public class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IndicatorSeekBar c;

    public b(IndicatorSeekBar indicatorSeekBar, float f, int i) {
        this.c = indicatorSeekBar;
        this.a = f;
        this.b = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IndicatorSeekBar indicatorSeekBar = this.c;
        indicatorSeekBar.g = indicatorSeekBar.u;
        float f = this.a;
        if (f - indicatorSeekBar.A[this.b] > 0.0f) {
            indicatorSeekBar.u = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } else {
            indicatorSeekBar.u = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
        }
        IndicatorSeekBar indicatorSeekBar2 = this.c;
        indicatorSeekBar2.y(indicatorSeekBar2.u);
        this.c.setSeekListener(false);
        IndicatorSeekBar indicatorSeekBar3 = this.c;
        Indicator indicator = indicatorSeekBar3.P;
        if (indicator != null && indicatorSeekBar3.S) {
            indicator.d();
            this.c.z();
        }
        this.c.invalidate();
    }
}
