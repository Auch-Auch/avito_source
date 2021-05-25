package com.google.android.gms.internal.ads;

import org.json.JSONException;
public final class zzbsp extends zzye {
    private final String zzfso;
    private final String zzfsp;

    public zzbsp(zzdkx zzdkx, String str) {
        String str2;
        String str3 = null;
        if (zzdkx == null) {
            str2 = null;
        } else {
            str2 = zzdkx.zzfsp;
        }
        this.zzfsp = str2;
        str3 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzc(zzdkx) : str3;
        this.zzfso = str3 != null ? str3 : str;
    }

    private static String zzc(zzdkx zzdkx) {
        try {
            return zzdkx.zzhar.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyf
    public final String getMediationAdapterClassName() {
        return this.zzfso;
    }

    @Override // com.google.android.gms.internal.ads.zzyf
    public final String getResponseId() {
        return this.zzfsp;
    }
}
