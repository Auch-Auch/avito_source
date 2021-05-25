package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
public final class zzddf implements zzden<zzddc> {
    private final Bundle zzfsj;
    private final zzdvw zzgay;

    public zzddf(zzdvw zzdvw, @Nullable Bundle bundle) {
        this.zzgay = zzdvw;
        this.zzfsj = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzddc> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdde
            private final zzddf zzguh;

            {
                this.zzguh = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguh.zzarc();
            }
        });
    }

    public final /* synthetic */ zzddc zzarc() throws Exception {
        return new zzddc(this.zzfsj);
    }
}
