package a2.a.a.l0.a.b;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public b(View view) {
        this.a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Int")).intValue();
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.height = intValue;
        this.a.setLayoutParams(layoutParams);
    }
}
