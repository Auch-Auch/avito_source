package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;
public final class zzda extends zzan {
    private String zzaau;
    private String zzaav;
    public int zzaax;
    private int zzacu;
    public boolean zzacv;
    private boolean zzacw;
    private boolean zzacx;

    public zzda(zzap zzap) {
        super(zzap);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        ApplicationInfo applicationInfo;
        int i;
        zzcc zzcc;
        int i2;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzt("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (zzcc = (zzcc) new zzca(zzcm()).zzq(i)) != null) {
            zzq("Loading global XML config values");
            String str = zzcc.zzaau;
            boolean z = false;
            if (str != null) {
                this.zzaau = str;
                zzb("XML config - app name", str);
            }
            String str2 = zzcc.zzaav;
            if (str2 != null) {
                this.zzaav = str2;
                zzb("XML config - app version", str2);
            }
            String str3 = zzcc.zzaaw;
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(Locale.US);
                if ("verbose".equals(lowerCase)) {
                    i2 = 0;
                } else if ("info".equals(lowerCase)) {
                    i2 = 1;
                } else if ("warning".equals(lowerCase)) {
                    i2 = 2;
                } else {
                    i2 = "error".equals(lowerCase) ? 3 : -1;
                }
                if (i2 >= 0) {
                    this.zzacu = i2;
                    zza("XML config - log level", Integer.valueOf(i2));
                }
            }
            int i3 = zzcc.zzaax;
            if (i3 >= 0) {
                this.zzaax = i3;
                this.zzacv = true;
                zzb("XML config - dispatch period (sec)", Integer.valueOf(i3));
            }
            int i4 = zzcc.zzaay;
            if (i4 != -1) {
                if (i4 == 1) {
                    z = true;
                }
                this.zzacx = z;
                this.zzacw = true;
                zzb("XML config - dry run", Boolean.valueOf(z));
            }
        }
    }

    public final String zzaz() {
        zzdb();
        return this.zzaau;
    }

    public final String zzba() {
        zzdb();
        return this.zzaav;
    }

    public final boolean zzgh() {
        zzdb();
        return false;
    }

    public final boolean zzgi() {
        zzdb();
        return this.zzacw;
    }

    public final boolean zzgj() {
        zzdb();
        return this.zzacx;
    }
}
