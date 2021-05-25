package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
public final class zzdco implements zzden<zzdcp> {
    private final PackageInfo zzdpx;
    private final zzaya zzdza;
    private final zzdln zzfqn;
    private final zzdvw zzgay;

    public zzdco(zzdvw zzdvw, zzdln zzdln, @Nullable PackageInfo packageInfo, zzaya zzaya) {
        this.zzgay = zzdvw;
        this.zzfqn = zzdln;
        this.zzdpx = packageInfo;
        this.zzdza = zzaya;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        if (r9 == 3) goto L_0x011a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdco.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdcp> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcr
            private final zzdco zzguc;

            {
                this.zzguc = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguc.zzara();
            }
        });
    }

    public final /* synthetic */ zzdcp zzara() throws Exception {
        ArrayList<String> arrayList = this.zzfqn.zzhbw;
        if (arrayList == null) {
            return zzdcq.zzgub;
        }
        if (arrayList.isEmpty()) {
            return zzdct.zzgub;
        }
        return new zzdcp(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzdcs
            private final zzdco zzguc;
            private final ArrayList zzgud;

            {
                this.zzguc = r1;
                this.zzgud = r2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.android.gms.internal.ads.zzdek
            public final void zzs(Bundle bundle) {
                this.zzguc.zza(this.zzgud, bundle);
            }
        };
    }
}
