package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
public final class zzcob implements zzdvi<zzdlj> {
    private final /* synthetic */ zzcoa zzghw;

    public zzcob(zzcoa zzcoa) {
        this.zzghw = zzcoa;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(zzdlj zzdlj) {
        zzdlj zzdlj2 = zzdlj;
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue()) {
            this.zzghw.zzghq.zzdz(zzdlj2.zzhbq.zzhbn.responseCode);
            this.zzghw.zzghq.zzeo(zzdlj2.zzhbq.zzhbn.zzgjr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvx)).booleanValue()) {
            Matcher matcher = zzcoa.zzghr.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzghw.zzghq.zzdz(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
