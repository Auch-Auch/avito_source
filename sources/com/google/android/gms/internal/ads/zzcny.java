package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
public final class zzcny implements zzdvi<zzdlj> {
    private final /* synthetic */ zzcnt zzghu;

    public zzcny(zzcnt zzcnt) {
        this.zzghu = zzcnt;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzdlj zzdlj) {
        zzdlj zzdlj2 = zzdlj;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue()) {
            this.zzghu.zzghq.zzdz(zzdlj2.zzhbq.zzhbn.responseCode);
            this.zzghu.zzghq.zzeo(zzdlj2.zzhbq.zzhbn.zzgjr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue()) {
            Matcher matcher = zzcnt.zzghr.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzghu.zzghq.zzdz(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
