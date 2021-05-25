package m6.a;

import android.animation.ValueAnimator;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
public class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CircularProgressIndicator a;

    public b(CircularProgressIndicator circularProgressIndicator) {
        this.a = circularProgressIndicator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.f = ((Integer) valueAnimator.getAnimatedValue("angle")).intValue();
        this.a.invalidate();
    }
}
