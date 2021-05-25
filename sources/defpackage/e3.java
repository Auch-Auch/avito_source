package defpackage;

import android.animation.ValueAnimator;
import com.avito.android.design.widget.circular_progress.DefaultCircularProgressDrawableDelegate;
import com.avito.android.design.widget.circular_progress.DefaultCircularProgressDrawableDelegateKt;
import com.avito.android.design.widget.circular_progress.UtilsKt;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: e3  reason: default package */
public final class e3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public e3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
            ((DefaultCircularProgressDrawableDelegate) this.b).setCurrentRotationAngle(UtilsKt.getAnimatedFraction(valueAnimator, true) * 360.0f);
        } else if (i == 1) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
            float animatedFraction = UtilsKt.getAnimatedFraction(valueAnimator, false);
            if (((DefaultCircularProgressDrawableDelegate) this.b).o) {
                f = ((DefaultCircularProgressDrawableDelegate) this.b).g * animatedFraction;
            } else {
                f = ((DefaultCircularProgressDrawableDelegate) this.b).f + ((((DefaultCircularProgressDrawableDelegate) this.b).g - ((DefaultCircularProgressDrawableDelegate) this.b).f) * animatedFraction);
            }
            ((DefaultCircularProgressDrawableDelegate) this.b).setCurrentSweepAngle(f);
        } else if (i == 2) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
            float animatedFraction2 = UtilsKt.getAnimatedFraction(valueAnimator, false);
            DefaultCircularProgressDrawableDelegate defaultCircularProgressDrawableDelegate = (DefaultCircularProgressDrawableDelegate) this.b;
            defaultCircularProgressDrawableDelegate.setCurrentSweepAngle(defaultCircularProgressDrawableDelegate.g - ((((DefaultCircularProgressDrawableDelegate) this.b).g - ((DefaultCircularProgressDrawableDelegate) this.b).f) * animatedFraction2));
            float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration());
            if (((DefaultCircularProgressDrawableDelegate) this.b).c.length > 1 && currentPlayTime > 0.7f) {
                Object evaluate = DefaultCircularProgressDrawableDelegateKt.a.evaluate((currentPlayTime - 0.7f) / 0.3f, Integer.valueOf(((DefaultCircularProgressDrawableDelegate) this.b).i), Integer.valueOf(((DefaultCircularProgressDrawableDelegate) this.b).c[(((DefaultCircularProgressDrawableDelegate) this.b).j + 1) % ((DefaultCircularProgressDrawableDelegate) this.b).c.length]));
                Objects.requireNonNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
                ((DefaultCircularProgressDrawableDelegate) this.b).u.getCurrentPaint().setColor(((Integer) evaluate).intValue());
            }
        } else if (i == 3) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
            DefaultCircularProgressDrawableDelegate.access$setEndRatio((DefaultCircularProgressDrawableDelegate) this.b, 1.0f - UtilsKt.getAnimatedFraction(valueAnimator, false));
        } else {
            throw null;
        }
    }
}
