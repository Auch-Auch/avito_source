package com.google.android.gms.internal.ads;
public final class zzavo implements zzdvi<Void> {
    private final /* synthetic */ zzdvt zzdwf;

    public zzavo(zzavl zzavl, zzdvt zzdvt) {
        this.zzdwf = zzdvt;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(Void r2) {
        zzavl.zzvt().remove(this.zzdwf);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        zzavl.zzvt().remove(this.zzdwf);
    }
}
