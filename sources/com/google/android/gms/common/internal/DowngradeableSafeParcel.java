package com.google.android.gms.common.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
@KeepForSdk
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zza = new Object();
    @Nullable
    private static ClassLoader zzb;
    @Nullable
    private static Integer zzc;
    private boolean zzd = false;

    @RecentlyNonNull
    @KeepForSdk
    public static boolean canUnparcelSafely(@RecentlyNonNull String str) {
        zza();
        return true;
    }

    @RecentlyNullable
    @KeepForSdk
    public static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    @Nullable
    private static ClassLoader zza() {
        synchronized (zza) {
        }
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public abstract boolean prepareForClientVersion(@RecentlyNonNull int i);

    @KeepForSdk
    public void setShouldDowngrade(@RecentlyNonNull boolean z) {
        this.zzd = z;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean shouldDowngrade() {
        return this.zzd;
    }
}
