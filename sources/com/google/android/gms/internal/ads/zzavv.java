package com.google.android.gms.internal.ads;
public final class zzavv {
    public static boolean isEnabled() {
        return zzacu.zzdbp.get().booleanValue();
    }

    public static void zzef(String str) {
        if (zzacu.zzdbp.get().booleanValue()) {
            zzbbd.zzef(str);
        }
    }
}
