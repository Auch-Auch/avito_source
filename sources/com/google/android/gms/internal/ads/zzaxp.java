package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
public final class zzaxp {
    private final Object lock;
    private volatile int zzdys;
    private volatile long zzdyt;

    private zzaxp() {
        this.lock = new Object();
        this.zzdys = zzaxo.zzdyo;
        this.zzdyt = 0;
    }

    public final void zzwf() {
        int i;
        long currentTimeMillis = zzp.zzkw().currentTimeMillis();
        synchronized (this.lock) {
            int i2 = this.zzdys;
            i = zzaxo.zzdyq;
            if (i2 == i) {
                if (this.zzdyt + ((Long) zzwe.zzpu().zzd(zzaat.zzcvk)).longValue() <= currentTimeMillis) {
                    this.zzdys = zzaxo.zzdyo;
                }
            }
        }
        long currentTimeMillis2 = zzp.zzkw().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzdys == 2) {
                this.zzdys = 3;
                if (this.zzdys == i) {
                    this.zzdyt = currentTimeMillis2;
                }
            }
        }
    }

    public /* synthetic */ zzaxp(zzaxm zzaxm) {
        this();
    }
}
