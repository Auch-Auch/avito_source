package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;
import java.util.Map;
public final class zzagy implements zzahf<zzbfq> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        zzbfq zzbfq2 = zzbfq;
        if (zzbfq2.zzabs() != null) {
            zzbfq2.zzabs().zzmr();
        }
        zzc zzaba = zzbfq2.zzaba();
        if (zzaba != null) {
            zzaba.close();
            return;
        }
        zzc zzabb = zzbfq2.zzabb();
        if (zzabb != null) {
            zzabb.close();
        } else {
            zzbbd.zzfe("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
