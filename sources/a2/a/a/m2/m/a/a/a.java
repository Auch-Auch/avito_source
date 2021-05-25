package a2.a.a.m2.m.a.a;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemViewImpl;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MetroLineItemViewImpl a;

    public a(MetroLineItemViewImpl metroLineItemViewImpl) {
        this.a = metroLineItemViewImpl;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ImageView imageView = this.a.u;
        Intrinsics.checkNotNullExpressionValue(imageView, "lineExpandedIv");
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        imageView.setRotation(((Float) animatedValue).floatValue());
    }
}
