package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzf {
    private final String zza;
    private final zze zzb;
    private zze zzc;
    private boolean zzd;

    private zzf(String str) {
        zze zze = new zze();
        this.zzb = zze;
        this.zzc = zze;
        this.zzd = false;
        this.zza = (String) zzj.zza(str);
    }

    private final zzf zzb(String str, @NullableDecl Object obj) {
        zze zze = new zze();
        this.zzc.zzc = zze;
        this.zzc = zze;
        zze.zzb = obj;
        zze.zza = (String) zzj.zza(str);
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zze zze = this.zzb.zzc;
        String str = "";
        while (zze != null) {
            Object obj = zze.zzb;
            sb.append(str);
            String str2 = zze.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            zze = zze.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzf zza(String str, @NullableDecl Object obj) {
        return zzb(str, obj);
    }

    public final zzf zza(String str, boolean z) {
        return zzb(str, String.valueOf(z));
    }

    public final zzf zza(String str, float f) {
        return zzb(str, String.valueOf(f));
    }

    public final zzf zza(String str, int i) {
        return zzb(str, String.valueOf(i));
    }
}
