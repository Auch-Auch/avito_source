package com.avito.android.design.widget.circular_progress;

import a2.g.r.g;
import android.view.animation.Interpolator;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010%\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006¨\u0006+"}, d2 = {"Lcom/avito/android/design/widget/circular_progress/Options;", "", "", "i", "I", "getStyle", "()I", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroid/view/animation/Interpolator;", AuthSource.SEND_ABUSE, "Landroid/view/animation/Interpolator;", "getAngleInterpolator", "()Landroid/view/animation/Interpolator;", "angleInterpolator", "", "f", "F", "getRotationSpeed", "()F", "rotationSpeed", AuthSource.BOOKING_ORDER, "getSweepInterpolator", "sweepInterpolator", "", "d", "[I", "getColors", "()[I", "colors", "e", "getSweepSpeed", "sweepSpeed", "h", "getMaxSweepAngle", "maxSweepAngle", "c", "getBorderWidth", "borderWidth", g.a, "getMinSweepAngle", "minSweepAngle", "<init>", "(Landroid/view/animation/Interpolator;Landroid/view/animation/Interpolator;F[IFFIII)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class Options {
    @NotNull
    public final Interpolator a;
    @NotNull
    public final Interpolator b;
    public final float c;
    @NotNull
    public final int[] d;
    public final float e;
    public final float f;
    public final int g;
    public final int h;
    public final int i;

    public Options(@NotNull Interpolator interpolator, @NotNull Interpolator interpolator2, float f2, @NotNull int[] iArr, float f3, float f4, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(interpolator, "angleInterpolator");
        Intrinsics.checkNotNullParameter(interpolator2, "sweepInterpolator");
        Intrinsics.checkNotNullParameter(iArr, "colors");
        this.a = interpolator;
        this.b = interpolator2;
        this.c = f2;
        this.d = iArr;
        this.e = f3;
        this.f = f4;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    @NotNull
    public final Interpolator getAngleInterpolator() {
        return this.a;
    }

    public final float getBorderWidth() {
        return this.c;
    }

    @NotNull
    public final int[] getColors() {
        return this.d;
    }

    public final int getMaxSweepAngle() {
        return this.h;
    }

    public final int getMinSweepAngle() {
        return this.g;
    }

    public final float getRotationSpeed() {
        return this.f;
    }

    public final int getStyle() {
        return this.i;
    }

    @NotNull
    public final Interpolator getSweepInterpolator() {
        return this.b;
    }

    public final float getSweepSpeed() {
        return this.e;
    }
}
