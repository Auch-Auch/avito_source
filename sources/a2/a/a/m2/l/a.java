package a2.a.a.m2.l;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.avito.android.select.group_select.GroupSelectItemViewImpl;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GroupSelectItemViewImpl a;

    public a(GroupSelectItemViewImpl groupSelectItemViewImpl) {
        this.a = groupSelectItemViewImpl;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.a.e.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this.a.e.requestLayout();
        this.a.getParent().requestLayout();
    }
}
