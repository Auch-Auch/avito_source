package a2.a.a.k1.a.e;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;
import com.avito.android.lib.design.page_indicator.PageIndicator;
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PageIndicator a;
    public final /* synthetic */ float b;

    public a(PageIndicator pageIndicator, float f) {
        this.a = pageIndicator;
        this.b = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.n = ((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        PageIndicator pageIndicator = this.a;
        pageIndicator.m = pageIndicator.n * this.b;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }
}
