package v6.b.a;

import android.animation.ValueAnimator;
import v6.b.a.f;
public class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ f.b.a a;

    public g(h hVar, f.b.a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a();
    }
}
