package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzp;
@TargetApi(26)
public class zzayu extends zzayv {
    @Override // com.google.android.gms.internal.ads.zzaym
    public final zzug zza(Context context, TelephonyManager telephonyManager) {
        zzp.zzkp();
        if (zzayh.zzr(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzug.ENUM_TRUE : zzug.ENUM_FALSE;
        }
        return zzug.ENUM_FALSE;
    }
}
