package com.google.android.gms.internal.ads;
public final class zzdod implements zzelo<zzdvw> {
    public static zzdod zzauj() {
        return zzdog.zzaun();
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        zzdvw zzdvw;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuu)).booleanValue()) {
            zzdvw = zzbbi.zzedw;
        } else {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcut)).booleanValue()) {
                zzdvw = zzbbi.zzedu;
            } else {
                zzdvw = zzbbi.zzedy;
            }
        }
        return (zzdvw) zzelu.zza(zzdvw, "Cannot return null from a non-@Nullable @Provides method");
    }
}
