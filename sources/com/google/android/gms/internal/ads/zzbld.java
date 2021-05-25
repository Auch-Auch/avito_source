package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzbld implements zzduv<zzdlj, zzdlj> {
    private Map<String, zzblg> zzflc;

    public zzbld(Map<String, zzblg> map) {
        this.zzflc = map;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvt' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduv
    public final /* synthetic */ zzdvt<zzdlj> zzf(zzdlj zzdlj) throws Exception {
        zzdlj zzdlj2 = zzdlj;
        for (zzdlg zzdlg : zzdlj2.zzhbq.zzhbo) {
            if (this.zzflc.containsKey(zzdlg.name)) {
                this.zzflc.get(zzdlg.name).zzl(zzdlg.zzhbl);
            }
        }
        return zzdvl.zzaf(zzdlj2);
    }
}
