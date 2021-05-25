package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class zzcud {
    private final Clock zzbpw;
    private final zzcuf zzgnc;
    private final List<String> zzgnd = Collections.synchronizedList(new ArrayList());
    private final boolean zzgne;

    public zzcud(Clock clock, zzcuf zzcuf) {
        this.zzbpw = clock;
        this.zzgnc = zzcuf;
        this.zzgne = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcxa)).booleanValue();
    }

    public final <T> zzdvt<T> zza(zzdkz zzdkz, zzdkx zzdkx, zzdvt<T> zzdvt) {
        long elapsedRealtime = this.zzbpw.elapsedRealtime();
        String str = zzdkx.zzdjo;
        if (str != null) {
            zzdvl.zza(zzdvt, new zzcug(this, str, elapsedRealtime, zzdkx, zzdkz), zzbbi.zzedz);
        }
        return zzdvt;
    }

    public final String zzapv() {
        return TextUtils.join("_", this.zzgnd);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(a.q0(str, 33));
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            sb2 = a.s2(a.q0(str2, a.q0(sb2, 1)), sb2, ".", str2);
        }
        this.zzgnd.add(sb2);
    }
}
