package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
public final class zzded implements zzden<zzdek<Bundle>> {
    private final boolean zzgva;

    public zzded(@Nullable zzdjf zzdjf) {
        if (zzdjf != null) {
            this.zzgva = true;
        } else {
            this.zzgva = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        return zzdvl.zzaf(this.zzgva ? zzdec.zzguz : null);
    }
}
