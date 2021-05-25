package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbtl extends zzbxe<zzbtm> {
    private boolean zzfsw = false;

    public zzbtl(Set<zzbys<zzbtm>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzfsw) {
            zza(zzbtk.zzfst);
            this.zzfsw = true;
        }
    }
}
