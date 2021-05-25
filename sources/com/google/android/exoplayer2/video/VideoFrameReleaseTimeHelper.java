package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Util;
public final class VideoFrameReleaseTimeHelper {
    @Nullable
    public final WindowManager a;
    @Nullable
    public final b b;
    @Nullable
    public final a c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public long j;
    public long k;
    public long l;

    @RequiresApi(17)
    public final class a implements DisplayManager.DisplayListener {
        public final DisplayManager a;

        public a(DisplayManager displayManager) {
            this.a = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                VideoFrameReleaseTimeHelper.this.b();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public static final class b implements Choreographer.FrameCallback, Handler.Callback {
        public static final b f = new b();
        public volatile long a = C.TIME_UNSET;
        public final Handler b;
        public final HandlerThread c;
        public Choreographer d;
        public int e;

        public b() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.c = handlerThread;
            handlerThread.start();
            Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.b = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.a = j;
            this.d.postFrameCallbackDelayed(this, 500);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.d = Choreographer.getInstance();
                return true;
            } else if (i == 1) {
                int i2 = this.e + 1;
                this.e = i2;
                if (i2 == 1) {
                    this.d.postFrameCallback(this);
                }
                return true;
            } else if (i != 2) {
                return false;
            } else {
                int i3 = this.e - 1;
                this.e = i3;
                if (i3 == 0) {
                    this.d.removeFrameCallback(this);
                    this.a = C.TIME_UNSET;
                }
                return true;
            }
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    public final boolean a(long j2, long j3) {
        return Math.abs((j3 - this.j) - (j2 - this.k)) > 20000000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long adjustReleaseTime(long r9, long r11) {
        /*
            r8 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r9
            boolean r2 = r8.i
            if (r2 == 0) goto L_0x0042
            long r2 = r8.f
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r8.l
            r4 = 1
            long r2 = r2 + r4
            r8.l = r2
            long r2 = r8.h
            r8.g = r2
        L_0x0019:
            long r2 = r8.l
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r8.k
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r8.g
            long r2 = r2 + r4
            boolean r4 = r8.a(r2, r11)
            if (r4 == 0) goto L_0x0033
            r8.i = r6
            goto L_0x0042
        L_0x0033:
            long r4 = r8.j
            long r4 = r4 + r2
            long r6 = r8.k
            long r4 = r4 - r6
            goto L_0x0044
        L_0x003a:
            boolean r2 = r8.a(r0, r11)
            if (r2 == 0) goto L_0x0042
            r8.i = r6
        L_0x0042:
            r4 = r11
            r2 = r0
        L_0x0044:
            boolean r6 = r8.i
            if (r6 != 0) goto L_0x0053
            r8.k = r0
            r8.j = r11
            r11 = 0
            r8.l = r11
            r11 = 1
            r8.i = r11
        L_0x0053:
            r8.f = r9
            r8.h = r2
            com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper$b r9 = r8.b
            if (r9 == 0) goto L_0x008d
            long r10 = r8.d
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r12 != 0) goto L_0x0067
            goto L_0x008d
        L_0x0067:
            long r9 = r9.a
            int r11 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r11 != 0) goto L_0x006e
            return r4
        L_0x006e:
            long r11 = r8.d
            long r0 = r4 - r9
            long r0 = r0 / r11
            long r0 = r0 * r11
            long r0 = r0 + r9
            int r9 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r9 > 0) goto L_0x007d
            long r9 = r0 - r11
            goto L_0x0080
        L_0x007d:
            long r11 = r11 + r0
            r9 = r0
            r0 = r11
        L_0x0080:
            long r11 = r0 - r4
            long r4 = r4 - r9
            int r2 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r0 = r9
        L_0x0089:
            long r9 = r8.e
            long r0 = r0 - r9
            return r0
        L_0x008d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseTimeHelper.adjustReleaseTime(long, long):long");
    }

    public final void b() {
        Display defaultDisplay = this.a.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
            this.d = refreshRate;
            this.e = (refreshRate * 80) / 100;
        }
    }

    @TargetApi(17)
    public void disable() {
        if (this.a != null) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a.unregisterDisplayListener(aVar);
            }
            this.b.b.sendEmptyMessage(2);
        }
    }

    @TargetApi(17)
    public void enable() {
        this.i = false;
        if (this.a != null) {
            this.b.b.sendEmptyMessage(1);
            a aVar = this.c;
            if (aVar != null) {
                aVar.a.registerDisplayListener(aVar, null);
            }
            b();
        }
    }

    public VideoFrameReleaseTimeHelper(@Nullable Context context) {
        DisplayManager displayManager;
        a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.a = (WindowManager) context.getSystemService("window");
        } else {
            this.a = null;
        }
        if (this.a != null) {
            if (Util.SDK_INT >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                aVar = new a(displayManager);
            }
            this.c = aVar;
            this.b = b.f;
        } else {
            this.c = null;
            this.b = null;
        }
        this.d = C.TIME_UNSET;
        this.e = C.TIME_UNSET;
    }
}
