package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzdah implements zzdek<Bundle> {
    private final zzvm zzgsx;

    public zzdah(zzvm zzvm) {
        this.zzgsx = zzvm;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzvm zzvm = this.zzgsx;
        if (zzvm != null) {
            int i = zzvm.orientation;
            if (i == 1) {
                bundle2.putString("avo", "p");
            } else if (i == 2) {
                bundle2.putString("avo", "l");
            }
        }
    }
}
