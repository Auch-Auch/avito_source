package com.google.android.gms.common.api.internal;
public final class zat implements Runnable {
    private final /* synthetic */ zaq zaa;

    public zat(zaq zaq) {
        this.zaa = zaq;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zam.lock();
        try {
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
