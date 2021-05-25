package a2.a.a.l0.a.b;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FrameLayout.LayoutParams a;
    public final /* synthetic */ View b;

    public c(FrameLayout.LayoutParams layoutParams, View view) {
        this.a = layoutParams;
        this.b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.leftMargin = ((Integer) a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Int")).intValue();
        this.b.setLayoutParams(this.a);
    }
}
