package com.avito.android.util;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"(\u0010\u000b\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroid/animation/Animator;", "", "isEnabled", "(Landroid/animation/Animator;)Z", "Landroid/animation/ValueAnimator;", "", "value", "getSafeRepeatCount", "(Landroid/animation/ValueAnimator;)I", "setSafeRepeatCount", "(Landroid/animation/ValueAnimator;I)V", "safeRepeatCount", "android_release"}, k = 2, mv = {1, 4, 2})
public final class GlobalAnimationsKt {
    public static final int getSafeRepeatCount(@NotNull ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "$this$safeRepeatCount");
        return valueAnimator.getRepeatCount();
    }

    public static final boolean isEnabled(@NotNull Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "$this$isEnabled");
        return GlobalAnimations.INSTANCE.isAnimatorEnabled();
    }

    public static final void setSafeRepeatCount(@NotNull ValueAnimator valueAnimator, int i) {
        Intrinsics.checkNotNullParameter(valueAnimator, "$this$safeRepeatCount");
        if (!isEnabled(valueAnimator)) {
            i = 0;
        }
        valueAnimator.setRepeatCount(i);
    }
}
