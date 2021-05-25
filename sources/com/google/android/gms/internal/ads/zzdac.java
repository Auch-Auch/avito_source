package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;
public final class zzdac implements zzden<zzdaa> {
    private final String zzdpz;
    private final zzcji zzggg;
    private final zzdvw zzgse;

    public zzdac(String str, zzdvw zzdvw, zzcji zzcji) {
        this.zzdpz = str;
        this.zzgse = zzdvw;
        this.zzggg = zzcji;
    }

    private static Bundle zzb(zzdlx zzdlx) {
        Bundle bundle = new Bundle();
        try {
            if (zzdlx.zztx() != null) {
                bundle.putString("sdk_version", zzdlx.zztx().toString());
            }
        } catch (zzdlr unused) {
        }
        try {
            if (zzdlx.zztw() != null) {
                bundle.putString("adapter_version", zzdlx.zztw().toString());
            }
        } catch (zzdlr unused2) {
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdaa> zzaqs() {
        if (new BigInteger(this.zzdpz).equals(BigInteger.ONE)) {
            if (!zzdsw.zzas((String) zzwe.zzpu().zzd(zzaat.zzcpq))) {
                return this.zzgse.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdaf
                    private final zzdac zzgsw;

                    {
                        this.zzgsw = r1;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzgsw.zzaqu();
                    }
                });
            }
        }
        return zzdvl.zzaf(new zzdaa(new Bundle()));
    }

    public final /* synthetic */ zzdaa zzaqu() throws Exception {
        List<String> asList = Arrays.asList(((String) zzwe.zzpu().zzd(zzaat.zzcpq)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                bundle.putBundle(str, zzb(this.zzggg.zzd(str, new JSONObject())));
            } catch (zzdlr unused) {
            }
        }
        return new zzdaa(bundle);
    }
}
