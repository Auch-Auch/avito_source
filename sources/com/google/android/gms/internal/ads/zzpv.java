package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
public final class zzpv extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    private Handler handler;
    private final int[] zzbks = new int[1];
    private SurfaceTexture zzbkt;
    private Error zzbku;
    private RuntimeException zzbkv;
    private zzpt zzbkw;

    public zzpv() {
        super("dummySurface");
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.SurfaceTexture, com.google.android.gms.internal.ads.zzpt] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Handler.Callback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r24) {
        /*
        // Method dump skipped, instructions count: 395
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpv.handleMessage(android.os.Message):boolean");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.handler.sendEmptyMessage(2);
    }

    public final void release() {
        this.handler.sendEmptyMessage(3);
    }

    public final zzpt zzm(boolean z) {
        boolean z2;
        start();
        this.handler = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.zzbkw == null && this.zzbkv == null && this.zzbku == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzbkv;
        if (runtimeException == null) {
            Error error = this.zzbku;
            if (error == null) {
                return this.zzbkw;
            }
            throw error;
        }
        throw runtimeException;
    }
}
