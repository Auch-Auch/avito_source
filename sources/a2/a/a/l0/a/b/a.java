package a2.a.a.l0.a.b;

import android.animation.ValueAnimator;
import android.view.View;
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public a(View view) {
        this.a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.setAlpha(((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }
}
