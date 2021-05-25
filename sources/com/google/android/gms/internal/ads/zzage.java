package com.google.android.gms.internal.ads;
public final class zzage extends zzafb {
    private final /* synthetic */ zzagc zzddm;

    private zzage(zzagc zzagc) {
        this.zzddm = zzagc;
    }

    @Override // com.google.android.gms.internal.ads.zzafc
    public final void zza(zzaes zzaes, String str) {
        if (this.zzddm.zzddk != null) {
            this.zzddm.zzddk.onCustomClick(this.zzddm.zzb(zzaes), str);
        }
    }
}
