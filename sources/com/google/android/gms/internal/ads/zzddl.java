package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
public final class zzddl implements zzden<zzdek<Bundle>> {
    private final String zzfsk;
    private final Context zzvr;

    public zzddl(Context context, @Nullable String str) {
        this.zzvr = context;
        this.zzfsk = str;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        zzddk zzddk;
        if (this.zzfsk == null) {
            zzddk = null;
        } else {
            zzddk = new zzdek(this) { // from class: com.google.android.gms.internal.ads.zzddk
                private final zzddl zzguj;

                {
                    this.zzguj = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdek
                public final void zzs(Object obj) {
                    this.zzguj.zzq((Bundle) obj);
                }
            };
        }
        return zzdvl.zzaf(zzddk);
    }

    public final /* synthetic */ void zzq(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzvr.getPackageName());
    }
}
