package com.google.android.gms.internal.ads;

import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Map;
public final class zzazz extends zzaa<zzy> {
    private final Map<String, String> zzam;
    private final zzbbq<zzy> zzecd;
    private final zzbax zzece;

    public zzazz(String str, zzbbq<zzy> zzbbq) {
        this(str, null, zzbbq);
    }

    @Override // com.google.android.gms.internal.ads.zzaa
    public final zzaj<zzy> zza(zzy zzy) {
        return zzaj.zza(zzy, zzbc.zzb(zzy));
    }

    private zzazz(String str, Map<String, String> map, zzbbq<zzy> zzbbq) {
        super(0, str, new zzazy(zzbbq));
        this.zzam = null;
        this.zzecd = zzbbq;
        zzbax zzbax = new zzbax();
        this.zzece = zzbax;
        zzbax.zza(str, ShareTarget.METHOD_GET, null, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzaa
    public final /* synthetic */ void zza(zzy zzy) {
        zzy zzy2 = zzy;
        this.zzece.zza(zzy2.zzam, zzy2.statusCode);
        zzbax zzbax = this.zzece;
        byte[] bArr = zzy2.data;
        if (zzbax.isEnabled() && bArr != null) {
            zzbax.zzi(bArr);
        }
        this.zzecd.set(zzy2);
    }
}
