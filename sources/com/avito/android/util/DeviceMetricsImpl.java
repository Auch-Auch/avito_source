package com.avito.android.util;

import android.annotation.SuppressLint;
import android.util.DisplayMetrics;
import android.view.Display;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\t\u0010\n\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u001c\u0010$\u001a\u00020\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0007R\u0016\u0010,\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0007¨\u00061"}, d2 = {"Lcom/avito/android/util/DeviceMetricsImpl;", "Lcom/avito/android/util/DeviceMetrics;", "", "px", AuthSource.SEND_ABUSE, "(I)I", "getDisplayRealWidthDp", "()I", "displayRealWidthDp", "c", "I", "getDensityDpi", "setDensityDpi", "(I)V", "getDensityDpi$annotations", "()V", "densityDpi", "getDisplayHeightDp", "displayHeightDp", "Lcom/avito/android/util/BuildInfo;", "d", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "buildInfo", "getDisplayRealHeightDp", "displayRealHeightDp", "", AuthSource.BOOKING_ORDER, "F", "getTextScaleFactor", "()F", "textScaleFactor", "getDisplayWidthDp", "displayWidthDp", "getDisplayScaleFactor", "displayScaleFactor", "Landroid/view/Display;", "e", "Landroid/view/Display;", "display", "getDisplayWidth", "displayWidth", "getDisplayHeight", "displayHeight", "Landroid/util/DisplayMetrics;", "displayMetrics", "<init>", "(Lcom/avito/android/util/BuildInfo;Landroid/view/Display;Landroid/util/DisplayMetrics;)V", "config_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"SupportAnnotationUsage"})
public final class DeviceMetricsImpl implements DeviceMetrics {
    public final float a;
    public final float b;
    public int c;
    @NotNull
    public final BuildInfo d;
    public final Display e;

    public DeviceMetricsImpl(@NotNull BuildInfo buildInfo, @NotNull Display display, @NotNull DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        this.d = buildInfo;
        this.e = display;
        this.a = displayMetrics.density;
        this.b = displayMetrics.scaledDensity;
        this.c = displayMetrics.densityDpi;
    }

    @DensityDpi
    public static /* synthetic */ void getDensityDpi$annotations() {
    }

    public final int a(int i) {
        return (int) (((float) i) / getDisplayScaleFactor());
    }

    @Override // com.avito.android.util.DeviceMetrics
    @NotNull
    public BuildInfo getBuildInfo() {
        return this.d;
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDensityDpi() {
        return this.c;
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDisplayHeight() {
        return Displays.getSizePoint(this.e).y;
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDisplayHeightDp() {
        return a(getDisplayHeight());
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDisplayRealHeightDp() {
        return a(Displays.getRealSizePoint(this.e).y);
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDisplayRealWidthDp() {
        return a(Displays.getRealSizePoint(this.e).x);
    }

    @Override // com.avito.android.util.DeviceMetrics
    public float getDisplayScaleFactor() {
        return this.a;
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDisplayWidth() {
        return Displays.getSizePoint(this.e).x;
    }

    @Override // com.avito.android.util.DeviceMetrics
    public int getDisplayWidthDp() {
        return a(getDisplayWidth());
    }

    @Override // com.avito.android.util.DeviceMetrics
    public float getTextScaleFactor() {
        return this.b;
    }

    public void setDensityDpi(int i) {
        this.c = i;
    }
}
