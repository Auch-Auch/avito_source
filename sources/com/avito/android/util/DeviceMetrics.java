package com.avito.android.util;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/util/DeviceMetrics;", "", "", "getDensityDpi", "()I", "getDensityDpi$annotations", "()V", "densityDpi", "getDisplayHeightDp", "displayHeightDp", "", "getDisplayScaleFactor", "()F", "displayScaleFactor", "getDisplayHeight", "displayHeight", "getDisplayRealHeightDp", "displayRealHeightDp", "getTextScaleFactor", "textScaleFactor", "getDisplayWidthDp", "displayWidthDp", "getDisplayRealWidthDp", "displayRealWidthDp", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "buildInfo", "getDisplayWidth", "displayWidth", "config_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"SupportAnnotationUsage"})
public interface DeviceMetrics {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @DensityDpi
        public static /* synthetic */ void getDensityDpi$annotations() {
        }
    }

    @NotNull
    BuildInfo getBuildInfo();

    int getDensityDpi();

    int getDisplayHeight();

    int getDisplayHeightDp();

    int getDisplayRealHeightDp();

    int getDisplayRealWidthDp();

    float getDisplayScaleFactor();

    int getDisplayWidth();

    int getDisplayWidthDp();

    float getTextScaleFactor();
}
