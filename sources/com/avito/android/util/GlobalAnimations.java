package com.avito.android.util;

import android.content.Context;
import android.provider.Settings;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\tR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0013\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/util/GlobalAnimations;", "", "Landroid/content/Context;", "context", "", "initialize", "(Landroid/content/Context;)V", "", "areSystemAnimationsEnabled", "()Z", "", "value", AuthSource.SEND_ABUSE, "(Ljava/lang/Float;)F", "isWindowAnimationEnabled", "Ljava/lang/Float;", "animatorScale", AuthSource.BOOKING_ORDER, "transitionAnimationScale", "isTransitionAnimationEnabled", "isAnimatorEnabled", "c", "windowAnimationScale", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class GlobalAnimations {
    @NotNull
    public static final GlobalAnimations INSTANCE = new GlobalAnimations();
    public static Float a;
    public static Float b;
    public static Float c;

    public final float a(Float f) {
        if (f != null) {
            return f.floatValue();
        }
        throw new IllegalArgumentException("Animations settings must be initialized before usage".toString());
    }

    public final boolean areSystemAnimationsEnabled() {
        return isAnimatorEnabled() || isTransitionAnimationEnabled() || isWindowAnimationEnabled();
    }

    public final void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a = Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f));
        b = Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "transition_animation_scale", 1.0f));
        c = Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "window_animation_scale", 1.0f));
    }

    public final boolean isAnimatorEnabled() {
        return a(a) > 0.0f;
    }

    public final boolean isTransitionAnimationEnabled() {
        return a(b) > 0.0f;
    }

    public final boolean isWindowAnimationEnabled() {
        return a(c) > 0.0f;
    }
}
