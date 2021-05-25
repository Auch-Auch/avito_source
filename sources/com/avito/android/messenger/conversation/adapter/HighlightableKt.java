package com.avito.android.messenger.conversation.adapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.AttrRes;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "context", "", "sourceColorAttr", "highlightedColorAttr", "Landroid/animation/ValueAnimator;", "animateColor", "(Landroid/graphics/drawable/Drawable;Landroid/content/Context;II)Landroid/animation/ValueAnimator;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class HighlightableKt {

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ Drawable a;

        public a(Drawable drawable, long j, int i) {
            this.a = drawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullExpressionValue(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Integer)) {
                animatedValue = null;
            }
            Integer num = (Integer) animatedValue;
            if (num != null) {
                DrawablesKt.applyColor(this.a, num.intValue());
            }
        }
    }

    @NotNull
    public static final ValueAnimator animateColor(@NotNull Drawable drawable, @NotNull Context context, @AttrRes int i, @AttrRes int i2) {
        Intrinsics.checkNotNullParameter(drawable, "$this$animateColor");
        Intrinsics.checkNotNullParameter(context, "context");
        long integer = (long) context.getResources().getInteger(17694722);
        int colorByAttr = Contexts.getColorByAttr(context, i);
        int colorByAttr2 = Contexts.getColorByAttr(context, i2);
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluatorCompat(), Integer.valueOf(colorByAttr), Integer.valueOf(colorByAttr2), Integer.valueOf(colorByAttr2), Integer.valueOf(colorByAttr2), Integer.valueOf(colorByAttr));
        ofObject.setStartDelay(integer);
        ofObject.setDuration(((long) 4) * integer);
        ofObject.addUpdateListener(new a(drawable, integer, colorByAttr));
        ofObject.addListener(new Animator.AnimatorListener(drawable, integer, colorByAttr) { // from class: com.avito.android.messenger.conversation.adapter.HighlightableKt$animateColor$$inlined$apply$lambda$2
            public final /* synthetic */ Drawable a;
            public final /* synthetic */ int b;

            {
                this.a = r1;
                this.b = r4;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animator) {
                DrawablesKt.applyColor(this.a, this.b);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animator) {
            }
        });
        ofObject.start();
        Intrinsics.checkNotNullExpressionValue(ofObject, "animation");
        return ofObject;
    }
}
