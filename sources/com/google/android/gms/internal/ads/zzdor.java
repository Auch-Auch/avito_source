package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
public abstract class zzdor<E> {
    private static final zzdvt<?> zzhgo = zzdvl.zzaf(null);
    private final ScheduledExecutorService zzfnh;
    private final zzdvw zzgay;
    private final zzdpd<E> zzhgp;

    public zzdor(zzdvw zzdvw, ScheduledExecutorService scheduledExecutorService, zzdpd<E> zzdpd) {
        this.zzgay = zzdvw;
        this.zzfnh = scheduledExecutorService;
        this.zzhgp = zzdpd;
    }

    public final <I> zzdox<I> zza(E e, zzdvt<I> zzdvt) {
        return new zzdox<>(this, e, zzdvt, Collections.singletonList(zzdvt), zzdvt);
    }

    public final zzdov zzu(E e) {
        return new zzdov(this, e);
    }

    public abstract String zzv(E e);

    public final zzdot zza(E e, zzdvt<?>... zzdvtArr) {
        return new zzdot(this, e, Arrays.asList(zzdvtArr));
    }
}
