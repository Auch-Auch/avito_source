package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
public final class zzfu implements zzed {
    private final String zzabp;
    private final zzfx zzapo;
    private final zzfw zzapp;
    private final Context zzrm;

    @VisibleForTesting
    private zzfu(zzfx zzfx, Context context, zzfw zzfw) {
        this.zzapo = zzfx;
        this.zzrm = context.getApplicationContext();
        this.zzapp = zzfw;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str2 = null;
        if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            str2 = sb.toString();
        }
        this.zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "5.06", str, str2, Build.MODEL, Build.ID);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x013a: APUT  (r5v10 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r13v0 java.lang.String) */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x020b A[SYNTHETIC, Splitter:B:91:0x020b] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0216  */
    @Override // com.google.android.gms.internal.gtm.zzed
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.util.List<com.google.android.gms.internal.gtm.zzeh> r19) {
        /*
        // Method dump skipped, instructions count: 642
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfu.zzd(java.util.List):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzed
    public final boolean zzhy() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzrm.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzev.zzab("...no network connectivity");
        return false;
    }

    @VisibleForTesting
    public zzfu(Context context, zzfw zzfw) {
        this(new zzfv(), context, zzfw);
    }

    @VisibleForTesting
    private static URL zzd(zzeh zzeh) {
        try {
            return new URL(zzeh.zzij());
        } catch (MalformedURLException unused) {
            zzev.zzav("Error trying to parse the GTM url.");
            return null;
        }
    }
}
