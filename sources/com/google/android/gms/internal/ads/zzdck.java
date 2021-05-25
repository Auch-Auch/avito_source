package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
public final class zzdck implements zzden<zzdcl> {
    private final zzdkv zzfld;
    private final zzdvw zzgay;

    public zzdck(zzdvw zzdvw, zzdkv zzdkv) {
        this.zzgay = zzdvw;
        this.zzfld = zzdkv;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdcl> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcn
            private final zzdck zzgua;

            {
                this.zzgua = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgua.zzaqz();
            }
        });
    }

    public final /* synthetic */ zzdcl zzaqz() throws Exception {
        return new zzdcl(this.zzfld);
    }
}
