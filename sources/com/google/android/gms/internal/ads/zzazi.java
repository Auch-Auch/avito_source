package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;
public final class zzazi extends zzau {
    private final Context zzvr;

    private zzazi(Context context, zzar zzar) {
        super(zzar);
        this.zzvr = context;
    }

    public static zzae zzbj(Context context) {
        zzae zzae = new zzae(new zzav(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzazi(context, new zzbd()));
        zzae.start();
        return zzae;
    }

    @Override // com.google.android.gms.internal.ads.zzau, com.google.android.gms.internal.ads.zzx
    public final zzy zzc(zzaa<?> zzaa) throws zzao {
        if (zzaa.zzh() && zzaa.getMethod() == 0) {
            if (Pattern.matches((String) zzwe.zzpu().zzd(zzaat.zzcsv), zzaa.getUrl())) {
                zzwe.zzpq();
                if (zzbat.zzd(this.zzvr, 13400000)) {
                    zzy zzc = new zzahz(this.zzvr).zzc(zzaa);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzaa.getUrl());
                        zzaxy.zzei(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzaa.getUrl());
                    zzaxy.zzei(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzaa);
    }
}
