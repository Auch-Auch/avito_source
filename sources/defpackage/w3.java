package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import com.avito.android.user_adverts.root_screen.adverts_host.header.menu_panel.CollapsingProgressView;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: w3  reason: default package */
public final class w3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public w3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        if (i == 0) {
            Paint access$getTickPaint$p = CollapsingProgressView.access$getTickPaint$p((CollapsingProgressView) this.b);
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            access$getTickPaint$p.setAlpha(((Integer) animatedValue).intValue());
            CollapsingProgressView collapsingProgressView = (CollapsingProgressView) this.b;
            CollapsingProgressView.access$calculateSingleCircle(collapsingProgressView, CollapsingProgressView.access$getSingleCircleRadius$p(collapsingProgressView), true);
            ((CollapsingProgressView) this.b).invalidate();
        } else if (i == 1) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            CollapsingProgressView.access$setSingleCircleRadius$p((CollapsingProgressView) this.b, ((Float) animatedValue2).floatValue());
            CollapsingProgressView collapsingProgressView2 = (CollapsingProgressView) this.b;
            CollapsingProgressView.access$calculateSingleCircle(collapsingProgressView2, CollapsingProgressView.access$getSingleCircleRadius$p(collapsingProgressView2), false);
            ((CollapsingProgressView) this.b).invalidate();
        } else if (i == 2) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            Object animatedValue3 = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
            CollapsingProgressView.access$setSpiralRadius$p((CollapsingProgressView) this.b, ((Float) animatedValue3).floatValue());
            CollapsingProgressView.access$setRadiusChanged$p((CollapsingProgressView) this.b, true);
            CollapsingProgressView.access$invalidateSpiral((CollapsingProgressView) this.b);
        } else if (i == 3) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
            Object animatedValue4 = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue4, "null cannot be cast to non-null type kotlin.Float");
            CollapsingProgressView.access$setRotationAngle$p((CollapsingProgressView) this.b, ((Float) animatedValue4).floatValue());
            CollapsingProgressView.access$setAngleChanged$p((CollapsingProgressView) this.b, true);
            CollapsingProgressView.access$invalidateSpiral((CollapsingProgressView) this.b);
        } else {
            throw null;
        }
    }
}
