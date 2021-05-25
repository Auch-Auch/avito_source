package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.yandex.mobile.ads.impl.gf;
import java.util.concurrent.Callable;
public final class ge {
    @NonNull
    private final ig a = new ig();
    @NonNull
    private final gf b = new gf();

    @NonNull
    public final gd a(@NonNull Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        gf gfVar = this.b;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display display = (Display) gg.a(new Callable<Display>(windowManager) { // from class: com.yandex.mobile.ads.impl.gf.1
            public final /* synthetic */ WindowManager a;

            {
                this.a = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            @Nullable
            public final /* synthetic */ Display call() throws Exception {
                return this.a.getDefaultDisplay();
            }
        }, windowManager);
        gf.AnonymousClass2 r3 = new Callable<Point>(display) { // from class: com.yandex.mobile.ads.impl.gf.2
            public final /* synthetic */ Display a;

            {
                this.a = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            @NonNull
            public final /* synthetic */ Point call() throws Exception {
                return gf.a(this.a);
            }
        };
        boolean z = false;
        Object point = new Point(0, 0);
        Object a3 = gg.a(r3, display);
        if (a3 != null) {
            point = a3;
        }
        Point point2 = (Point) point;
        int i = point2.x;
        int i2 = point2.y;
        float f = displayMetrics.density;
        float f2 = (float) i;
        float f3 = (float) i2;
        float min = Math.min(f2 / f, f3 / f);
        float f4 = f * 160.0f;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        double sqrt = Math.sqrt((double) ((f6 * f6) + (f5 * f5)));
        if (sqrt >= 15.0d && !ig.a(context, "android.hardware.touchscreen")) {
            z = true;
        }
        if (z) {
            return gd.TV;
        }
        if (sqrt >= 7.0d || min >= 600.0f) {
            return gd.TABLET;
        }
        return gd.PHONE;
    }
}
