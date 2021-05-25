package com.avito.android.service.short_task.metrics;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.FontStyleKt;
import com.avito.android.util.Contexts;
import com.google.android.gms.ads.AdError;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/service/short_task/metrics/DarkThemeDetectionProvider;", "Lcom/avito/android/service/short_task/metrics/MetricProvider;", "", "primaryColor", "secondaryColor", "tertiaryColor", "Landroid/graphics/Bitmap;", "generateBitmapFromColors", "(III)Landroid/graphics/Bitmap;", AuthSource.SEND_ABUSE, "I", "hintSupportsDarkTheme", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/metrics/Metric;", "getMetricStream", "()Lio/reactivex/Observable;", "metricStream", "<init>", "(Lcom/avito/android/analytics/Analytics;Landroid/content/Context;)V", "DarkThemeCheckResult", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DarkThemeDetectionProvider implements MetricProvider {
    public final int a = 2;
    @NotNull
    public final Analytics b;
    @NotNull
    public final Context c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/service/short_task/metrics/DarkThemeDetectionProvider$DarkThemeCheckResult;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "VERSION_BEFORE_THEMES", "LIGHT", "DARK", "PROBABLY_DARK", "PROBABLY_LIGHT", "UNDEFINED", "application_release"}, k = 1, mv = {1, 4, 2})
    public enum DarkThemeCheckResult {
        VERSION_BEFORE_THEMES("version_before_themes"),
        LIGHT("light_theme"),
        DARK("dark_theme"),
        PROBABLY_DARK("probably_dark_theme"),
        PROBABLY_LIGHT("probably_light_theme"),
        UNDEFINED(AdError.UNDEFINED_DOMAIN);
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        DarkThemeCheckResult(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    @Inject
    public DarkThemeDetectionProvider(@NotNull Analytics analytics, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = analytics;
        this.c = context;
    }

    @NotNull
    public final Bitmap generateBitmapFromColors(@ColorInt int i, @ColorInt int i2, @ColorInt int i3) {
        int[] iArr = {i, i2, i3};
        Bitmap createBitmap = Bitmap.createBitmap(6, 1, Bitmap.Config.ARGB_8888);
        for (int i4 = 0; i4 < 3; i4++) {
            createBitmap.setPixel(i4, 0, iArr[0]);
        }
        for (int i5 = 3; i5 < 5; i5++) {
            createBitmap.setPixel(i5, 0, iArr[1]);
        }
        for (int i6 = 5; i6 < 6; i6++) {
            createBitmap.setPixel(i6, 0, iArr[2]);
        }
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    @NotNull
    public final Analytics getAnalytics() {
        return this.b;
    }

    @NotNull
    public final Context getContext() {
        return this.c;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x012d: APUT  
      (r2v1 com.avito.android.service.short_task.metrics.Metric[])
      (1 ??[boolean, int, float, short, byte, char])
      (wrap: com.avito.android.service.short_task.metrics.Metric : 0x0129: CONSTRUCTOR  (r1v3 com.avito.android.service.short_task.metrics.Metric) = ("app_ui_theme"), (r3v4 java.lang.String) call: com.avito.android.service.short_task.metrics.Metric.<init>(java.lang.String, java.lang.Object):void type: CONSTRUCTOR)
     */
    @Override // com.avito.android.service.short_task.metrics.MetricProvider
    @NotNull
    public Observable<Metric> getMetricStream() {
        DarkThemeCheckResult darkThemeCheckResult;
        int i;
        Context context = this.c;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 26) {
            darkThemeCheckResult = DarkThemeCheckResult.VERSION_BEFORE_THEMES;
        } else if (i2 <= 28) {
            WallpaperColors wallpaperColors = WallpaperManager.getInstance(context).getWallpaperColors(1);
            if (wallpaperColors != null) {
                Intrinsics.checkNotNullExpressionValue(wallpaperColors, "wallpaperManager.getWall…hemeCheckResult.UNDEFINED");
                int argb = wallpaperColors.getPrimaryColor().toArgb();
                Color secondaryColor = wallpaperColors.getSecondaryColor();
                int argb2 = secondaryColor != null ? secondaryColor.toArgb() : argb;
                Color tertiaryColor = wallpaperColors.getTertiaryColor();
                Bitmap generateBitmapFromColors = generateBitmapFromColors(argb, argb2, tertiaryColor != null ? tertiaryColor.toArgb() : argb2);
                if (generateBitmapFromColors == null) {
                    i = 0;
                } else {
                    int height = generateBitmapFromColors.getHeight() * generateBitmapFromColors.getWidth();
                    int[] iArr = new int[height];
                    double d = 0.0d;
                    int roundToInt = c.roundToInt(((float) height) * 0.025f);
                    generateBitmapFromColors.getPixels(iArr, 0, generateBitmapFromColors.getWidth(), 0, 0, generateBitmapFromColors.getWidth(), generateBitmapFromColors.getHeight());
                    float[] fArr = new float[3];
                    int i3 = 0;
                    for (int i4 = 0; i4 < height; i4++) {
                        ColorUtils.colorToHSL(iArr[i4], fArr);
                        float f = fArr[2];
                        int alpha = Color.alpha(iArr[i4]);
                        if (!(ColorUtils.calculateContrast(iArr[i4], ViewCompat.MEASURED_STATE_MASK) > ((double) 6.0f)) && alpha != 0) {
                            i3++;
                        }
                        d += (double) f;
                    }
                    double d2 = d / ((double) height);
                    i = (d2 <= ((double) 0.75f) || i3 >= roundToInt) ? 0 : 1;
                    if (d2 < ((double) 0.25f)) {
                        i |= this.a;
                    }
                }
                boolean z = (i & this.a) != 0;
                if (Build.VERSION.SDK_INT == 27) {
                    if (z) {
                        darkThemeCheckResult = DarkThemeCheckResult.PROBABLY_DARK;
                    } else {
                        darkThemeCheckResult = DarkThemeCheckResult.PROBABLY_LIGHT;
                    }
                } else if (z) {
                    darkThemeCheckResult = DarkThemeCheckResult.PROBABLY_DARK;
                } else {
                    darkThemeCheckResult = DarkThemeCheckResult.PROBABLY_LIGHT;
                }
            } else {
                darkThemeCheckResult = DarkThemeCheckResult.UNDEFINED;
            }
        } else {
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            int i5 = resources.getConfiguration().uiMode & 48;
            if (i5 == 16) {
                darkThemeCheckResult = DarkThemeCheckResult.LIGHT;
            } else if (i5 != 32) {
                darkThemeCheckResult = DarkThemeCheckResult.PROBABLY_LIGHT;
            } else {
                darkThemeCheckResult = DarkThemeCheckResult.DARK;
            }
        }
        Metric[] metricArr = new Metric[2];
        metricArr[0] = new Metric("color_theme_status", darkThemeCheckResult.getValue());
        metricArr[1] = new Metric("app_ui_theme", Contexts.checkTargetDarkTheme$default(this.c, 0, null, 3, null) ? "dark" : FontStyleKt.LIGHT);
        Observable<Metric> fromIterable = Observable.fromIterable(CollectionsKt__CollectionsKt.mutableListOf(metricArr));
        Intrinsics.checkNotNullExpressionValue(fromIterable, "Observable.fromIterable(metrics)");
        return fromIterable;
    }
}
