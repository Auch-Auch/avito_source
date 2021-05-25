package a2.a.a.k1.a.g;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Function1 a;

    public b(long j, Function1 function1) {
        this.a = function1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.invoke((Float) a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float"));
    }
}
