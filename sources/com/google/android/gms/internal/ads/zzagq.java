package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
public final class zzagq implements zzahf<zzbfq> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        zzbfq zzbfq2 = zzbfq;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzbbd.zzfe("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzbbd.zzfe("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str4) - zzp.zzkw().currentTimeMillis()) + zzp.zzkw().elapsedRealtime();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbfq2.zzzs().zzb(str2, str3, parseLong);
                } catch (NumberFormatException e) {
                    zzbbd.zzd("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzbbd.zzfe("No value given for CSI experiment.");
                return;
            }
            zzabk zzrm = zzbfq2.zzzs().zzrm();
            if (zzrm == null) {
                zzbbd.zzfe("No ticker for WebView, dropping experiment ID.");
            } else {
                zzrm.zzh("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzbbd.zzfe("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzbbd.zzfe("No name given for CSI extra.");
            } else {
                zzabk zzrm2 = zzbfq2.zzzs().zzrm();
                if (zzrm2 == null) {
                    zzbbd.zzfe("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzrm2.zzh(str6, str7);
                }
            }
        }
    }
}
