package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
@CheckReturnValue
public class zzl {
    private static final zzl zzb = new zzl(true, null, null);
    public final boolean zza;
    @Nullable
    private final String zzc;
    @Nullable
    private final Throwable zzd;

    public zzl(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzc = str;
        this.zzd = th;
    }

    public static zzl zza() {
        return zzb;
    }

    @Nullable
    public String zzb() {
        return this.zzc;
    }

    public final void zzc() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzd != null) {
                zzb();
            } else {
                zzb();
            }
        }
    }

    public static zzl zza(Callable<String> callable) {
        return new zzn(callable);
    }

    public static zzl zza(@NonNull String str) {
        return new zzl(false, str, null);
    }

    public static zzl zza(@NonNull String str, @NonNull Throwable th) {
        return new zzl(false, str, th);
    }

    public static String zza(String str, zzd zzd2, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not allowed", str, Hex.bytesToStringLowercase(((MessageDigest) Preconditions.checkNotNull(AndroidUtilsLight.zza("SHA-1"))).digest(zzd2.zza())), Boolean.valueOf(z), "12451009.false");
    }
}
