package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;
public final class zzdkv {
    private final Object lock = new Object();
    private final Clock zzbpw;
    private volatile long zzdyt = 0;
    @GuardedBy("lock")
    private volatile int zzhad = zzdku.zzgzz;

    public zzdkv(Clock clock) {
        this.zzbpw = clock;
    }

    private final void zzasj() {
        long currentTimeMillis = this.zzbpw.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhad == zzdku.zzhab) {
                if (this.zzdyt + ((Long) zzwe.zzpu().zzd(zzaat.zzcvk)).longValue() <= currentTimeMillis) {
                    this.zzhad = zzdku.zzgzz;
                }
            }
        }
    }

    private final void zzr(int i, int i2) {
        zzasj();
        long currentTimeMillis = this.zzbpw.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhad == i) {
                this.zzhad = i2;
                if (this.zzhad == zzdku.zzhab) {
                    this.zzdyt = currentTimeMillis;
                }
            }
        }
    }

    public final boolean zzask() {
        boolean z;
        synchronized (this.lock) {
            zzasj();
            z = this.zzhad == zzdku.zzhaa;
        }
        return z;
    }

    public final boolean zzasl() {
        boolean z;
        synchronized (this.lock) {
            zzasj();
            z = this.zzhad == zzdku.zzhab;
        }
        return z;
    }

    public final void zzbn(boolean z) {
        if (z) {
            zzr(zzdku.zzgzz, zzdku.zzhaa);
        } else {
            zzr(zzdku.zzhaa, zzdku.zzgzz);
        }
    }

    public final void zzwf() {
        zzr(zzdku.zzhaa, zzdku.zzhab);
    }
}
