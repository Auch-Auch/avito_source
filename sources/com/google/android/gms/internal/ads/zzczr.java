package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzczr implements zzden<Object> {
    private final Executor executor;
    private final zzdvt<String> zzgsj;

    public zzczr(zzdvt<String> zzdvt, Executor executor2) {
        this.zzgsj = zzdvt;
        this.executor = executor2;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<Object> zzaqs() {
        return zzdvl.zzb(this.zzgsj, zzczq.zzbok, this.executor);
    }
}
