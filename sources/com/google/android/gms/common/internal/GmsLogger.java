package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
public final class GmsLogger {
    private static final int zza = 15;
    @Nullable
    private static final String zzb = null;
    private final String zzc;
    @Nullable
    private final String zzd;

    public GmsLogger(@RecentlyNonNull String str, @Nullable String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zzc = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzd = null;
        } else {
            this.zzd = str2;
        }
    }

    private final String zza(String str) {
        String str2 = this.zzd;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }

    @RecentlyNonNull
    @KeepForSdk
    public final boolean canLog(@RecentlyNonNull int i) {
        return Log.isLoggable(this.zzc, i);
    }

    @RecentlyNonNull
    @KeepForSdk
    public final boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    public final void d(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void e(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (canLog(6)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void efmt(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object... objArr) {
        if (canLog(6)) {
            zza(str2, objArr);
        }
    }

    @KeepForSdk
    public final void i(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void pii(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            if (" PII_LOG".length() != 0) {
                valueOf.concat(" PII_LOG");
            } else {
                new String(valueOf);
            }
            zza(str2);
        }
    }

    @KeepForSdk
    public final void v(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void w(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        if (canLog(5)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void wfmt(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object... objArr) {
        if (canLog(5)) {
            zza(str2, objArr);
        }
    }

    @KeepForSdk
    public final void wtf(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLog(7)) {
            zza(str2);
            Log.wtf(str, zza(str2), th);
        }
    }

    private final String zza(String str, Object... objArr) {
        String format = String.format(str, objArr);
        String str2 = this.zzd;
        if (str2 == null) {
            return format;
        }
        return str2.concat(format);
    }

    @KeepForSdk
    public final void d(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void e(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLog(6)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void i(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void pii(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            if (" PII_LOG".length() != 0) {
                valueOf.concat(" PII_LOG");
            } else {
                new String(valueOf);
            }
            zza(str2);
        }
    }

    @KeepForSdk
    public final void v(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public final void w(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Throwable th) {
        if (canLog(5)) {
            zza(str2);
        }
    }

    public GmsLogger(@RecentlyNonNull String str) {
        this(str, null);
    }
}
