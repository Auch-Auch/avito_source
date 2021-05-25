package com.google.android.gms.internal.vision;

import android.content.Context;
public final class zzq {
    public static boolean zza(Context context, String str, String str2) {
        String zzl = zzdg.zzl(str2);
        if ("face".equals(str) || "ica".equals(str) || "ocr".equals(str) || "barcode".equals(str)) {
            int lastIndexOf = zzl.lastIndexOf(".so");
            if (lastIndexOf == zzl.length() - 3) {
                zzl = zzl.substring(0, lastIndexOf);
            }
            if (zzl.indexOf("lib") == 0) {
                zzl = zzl.substring(3);
            }
            boolean zza = zzr.zza(str, zzl);
            if (!zza) {
                String.format("%s engine not loaded with %s.", str, zzl);
            }
            return zza;
        }
        String.format("Unrecognized engine: %s", str);
        return false;
    }
}
