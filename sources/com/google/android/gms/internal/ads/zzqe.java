package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
public final class zzqe implements Handler.Callback, Choreographer.FrameCallback {
    private static final zzqe zzbmp = new zzqe();
    private final Handler handler;
    public volatile long zzbmo;
    private final HandlerThread zzbmq;
    private Choreographer zzbmr;
    private int zzbms;

    private zzqe() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.zzbmq = handlerThread;
        handlerThread.start();
        Handler handler2 = new Handler(handlerThread.getLooper(), this);
        this.handler = handler2;
        handler2.sendEmptyMessage(0);
    }

    public static zzqe zzjn() {
        return zzbmp;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.zzbmo = j;
        this.zzbmr.postFrameCallbackDelayed(this, 500);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.zzbmr = Choreographer.getInstance();
            return true;
        } else if (i == 1) {
            int i2 = this.zzbms + 1;
            this.zzbms = i2;
            if (i2 == 1) {
                this.zzbmr.postFrameCallback(this);
            }
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.zzbms - 1;
            this.zzbms = i3;
            if (i3 == 0) {
                this.zzbmr.removeFrameCallback(this);
                this.zzbmo = 0;
            }
            return true;
        }
    }

    public final void zzjo() {
        this.handler.sendEmptyMessage(1);
    }

    public final void zzjp() {
        this.handler.sendEmptyMessage(2);
    }
}
