package com.otaliastudios.cameraview.internal;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
public class OrientationHelper {
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Context b;
    public final Callback c;
    @VisibleForTesting
    public final OrientationEventListener d;
    public int e = -1;
    @VisibleForTesting
    public final DisplayManager.DisplayListener f;
    public int g = -1;
    public boolean h;

    public interface Callback {
        void onDeviceOrientationChanged(int i);

        void onDisplayOffsetChanged(int i, boolean z);
    }

    public class a extends OrientationEventListener {
        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
            if (r4 != -1) goto L_0x002d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // android.view.OrientationEventListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onOrientationChanged(int r4) {
            /*
                r3 = this;
                r0 = -1
                if (r4 != r0) goto L_0x000a
                com.otaliastudios.cameraview.internal.OrientationHelper r4 = com.otaliastudios.cameraview.internal.OrientationHelper.this
                int r4 = r4.e
                if (r4 == r0) goto L_0x002c
                goto L_0x002d
            L_0x000a:
                r0 = 315(0x13b, float:4.41E-43)
                if (r4 >= r0) goto L_0x002c
                r1 = 45
                if (r4 >= r1) goto L_0x0013
                goto L_0x002c
            L_0x0013:
                r2 = 135(0x87, float:1.89E-43)
                if (r4 < r1) goto L_0x001c
                if (r4 >= r2) goto L_0x001c
                r4 = 90
                goto L_0x002d
            L_0x001c:
                r1 = 225(0xe1, float:3.15E-43)
                if (r4 < r2) goto L_0x0025
                if (r4 >= r1) goto L_0x0025
                r4 = 180(0xb4, float:2.52E-43)
                goto L_0x002d
            L_0x0025:
                if (r4 < r1) goto L_0x002c
                if (r4 >= r0) goto L_0x002c
                r4 = 270(0x10e, float:3.78E-43)
                goto L_0x002d
            L_0x002c:
                r4 = 0
            L_0x002d:
                com.otaliastudios.cameraview.internal.OrientationHelper r0 = com.otaliastudios.cameraview.internal.OrientationHelper.this
                int r1 = r0.e
                if (r4 == r1) goto L_0x003a
                r0.e = r4
                com.otaliastudios.cameraview.internal.OrientationHelper$Callback r0 = r0.c
                r0.onDeviceOrientationChanged(r4)
            L_0x003a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.OrientationHelper.a.onOrientationChanged(int):void");
        }
    }

    public class b implements DisplayManager.DisplayListener {
        public b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            OrientationHelper orientationHelper = OrientationHelper.this;
            int i2 = orientationHelper.g;
            int a3 = orientationHelper.a();
            if (a3 != i2) {
                OrientationHelper.this.g = a3;
                OrientationHelper.this.c.onDisplayOffsetChanged(a3, Math.abs(a3 - i2) != 180);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public OrientationHelper(@NonNull Context context, @NonNull Callback callback) {
        this.b = context;
        this.c = callback;
        this.d = new a(context.getApplicationContext(), 3);
        this.f = new b();
    }

    public final int a() {
        int rotation = ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public void disable() {
        if (this.h) {
            this.h = false;
            this.d.disable();
            ((DisplayManager) this.b.getSystemService("display")).unregisterDisplayListener(this.f);
            this.g = -1;
            this.e = -1;
        }
    }

    public void enable() {
        if (!this.h) {
            this.h = true;
            this.g = a();
            ((DisplayManager) this.b.getSystemService("display")).registerDisplayListener(this.f, this.a);
            this.d.enable();
        }
    }

    public int getLastDeviceOrientation() {
        return this.e;
    }

    public int getLastDisplayOffset() {
        return this.g;
    }
}
