package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;
public final class zzdmk implements zzaxq, zzbsz {
    private final zzaxv zzdxp;
    @GuardedBy("this")
    private final HashSet<zzaxj> zzhdd = new HashSet<>();
    private final Context zzvr;

    public zzdmk(Context context, zzaxv zzaxv) {
        this.zzvr = context;
        this.zzdxp = zzaxv;
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final synchronized void zza(HashSet<zzaxj> hashSet) {
        this.zzhdd.clear();
        this.zzhdd.addAll(hashSet);
    }

    public final Bundle zzatb() {
        return this.zzdxp.zza(this.zzvr, this);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final synchronized void zzg(zzuw zzuw) {
        if (zzuw.errorCode != 3) {
            this.zzdxp.zzb(this.zzhdd);
        }
    }
}
