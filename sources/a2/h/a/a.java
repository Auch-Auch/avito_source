package a2.h.a;

import a2.h.a.b;
import android.animation.ValueAnimator;
public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b.c a;

    public a(b bVar, b.c cVar) {
        this.a = cVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
