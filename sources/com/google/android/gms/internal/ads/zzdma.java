package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;
public final class zzdma<T> {
    private final zzdvw zzgay;
    @GuardedBy("this")
    private final Deque<zzdvt<T>> zzhck = new LinkedBlockingDeque();
    private final Callable<T> zzhcl;

    public zzdma(Callable<T> callable, zzdvw zzdvw) {
        this.zzhcl = callable;
        this.zzgay = zzdvw;
    }

    public final synchronized zzdvt<T> zzasz() {
        zzed(1);
        return this.zzhck.poll();
    }

    public final synchronized void zzd(zzdvt<T> zzdvt) {
        this.zzhck.addFirst(zzdvt);
    }

    public final synchronized void zzed(int i) {
        int size = i - this.zzhck.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzhck.add(this.zzgay.zze(this.zzhcl));
        }
    }
}
