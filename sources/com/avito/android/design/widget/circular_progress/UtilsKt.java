package com.avito.android.design.widget.circular_progress;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.PowerManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0015\u0010 \u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!\u001a\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b\u001f\u0010$¨\u0006%"}, d2 = {"", "speed", "", "checkSpeed", "(F)V", "", "colors", "checkColors", "([I)V", "", "angle", "checkAngle", "(I)V", "number", "", "name", "checkPositiveOrZero", "(FLjava/lang/String;)V", "checkPositive", "(ILjava/lang/String;)V", "", "o", "checkNotNull", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroid/animation/ValueAnimator;", "animator", "", "isInfinite", "getAnimatedFraction", "(Landroid/animation/ValueAnimator;Z)F", "Landroid/os/PowerManager;", "powerManager", "isPowerSaveModeEnabled", "(Landroid/os/PowerManager;)Z", "Landroid/content/Context;", "context", "(Landroid/content/Context;)Landroid/os/PowerManager;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class UtilsKt {
    public static final void checkAngle(int i) {
        if (i < 0 || i > 360) {
            throw new IllegalArgumentException(a.H(new Object[]{Integer.valueOf(i)}, 1, "Illegal angle %d: must be >=0 and <=360", "java.lang.String.format(format, *args)"));
        }
    }

    public static final void checkColors(@Nullable int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("You must provide at least 1 color");
        }
    }

    public static final void checkNotNull(@Nullable Object obj, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (obj == null) {
            throw new IllegalArgumentException(a.H(new Object[]{str}, 1, "%s must be not null", "java.lang.String.format(format, *args)"));
        }
    }

    public static final void checkPositive(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (i <= 0) {
            throw new IllegalArgumentException(a.H(new Object[]{str}, 1, "%s must not be null", "java.lang.String.format(format, *args)"));
        }
    }

    public static final void checkPositiveOrZero(float f, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (f < ((float) 0)) {
            throw new IllegalArgumentException(a.H(new Object[]{str, Float.valueOf(f)}, 2, "%s %f must be positive", "java.lang.String.format(format, *args)"));
        }
    }

    public static final void checkSpeed(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    public static final float getAnimatedFraction(@NotNull ValueAnimator valueAnimator, boolean z) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        float currentPlayTime = valueAnimator.getDuration() > 0 ? ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration()) : 0.0f;
        if (z && valueAnimator.getCurrentPlayTime() > valueAnimator.getDuration()) {
            currentPlayTime -= (float) Math.floor((double) currentPlayTime);
        }
        return valueAnimator.getInterpolator().getInterpolation(Math.min(currentPlayTime, 1.0f));
    }

    public static final boolean isPowerSaveModeEnabled(@NotNull PowerManager powerManager) {
        Intrinsics.checkNotNullParameter(powerManager, "powerManager");
        try {
            return powerManager.isPowerSaveMode();
        } catch (Exception unused) {
            return false;
        }
    }

    @NotNull
    public static final PowerManager powerManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return (PowerManager) systemService;
    }
}
