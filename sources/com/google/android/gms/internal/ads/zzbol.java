package com.google.android.gms.internal.ads;
public final class zzbol implements zzelo<Boolean> {
    private final zzelx<zzdln> zzfos;

    public zzbol(zzelx<zzdln> zzelx) {
        this.zzfos = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        boolean z;
        if (this.zzfos.get().zzasp() != null) {
            z = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcos)).booleanValue();
        } else {
            z = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcup)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
