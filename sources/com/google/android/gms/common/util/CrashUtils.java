package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public final class CrashUtils {
    private static final String[] zza = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    @Nullable
    private static DropBoxManager zzb = null;
    private static boolean zzc = false;
    private static int zzd = -1;
    @GuardedBy("CrashUtils.class")
    private static int zze;
    @GuardedBy("CrashUtils.class")
    private static int zzf;

    @RecentlyNonNull
    @KeepForSdk
    public static boolean addDynamiteErrorToDropBox(@RecentlyNonNull Context context, @RecentlyNonNull Throwable th) {
        return zza(context, th, 536870912);
    }

    private static boolean zza(Context context, Throwable th, int i) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
        } catch (Exception unused) {
        }
        return false;
    }
}
