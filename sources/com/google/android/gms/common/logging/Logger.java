package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
@KeepForSdk
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Logger(@androidx.annotation.RecentlyNonNull java.lang.String r7, @androidx.annotation.RecentlyNonNull java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L_0x0006
            java.lang.String r8 = ""
            goto L_0x0032
        L_0x0006:
            r0 = 91
            java.lang.StringBuilder r0 = a2.b.a.a.a.I(r0)
            int r1 = r8.length
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x0024
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L_0x001e
            java.lang.String r4 = ","
            r0.append(r4)
        L_0x001e:
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0024:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0032:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    @KeepForSdk
    public void d(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    public void e(@RecentlyNonNull String str, @Nullable Object... objArr) {
        format(str, objArr);
    }

    @RecentlyNonNull
    @KeepForSdk
    public String format(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getTag() {
        return this.zza;
    }

    @KeepForSdk
    public void i(@RecentlyNonNull String str, @Nullable Object... objArr) {
        format(str, objArr);
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isLoggable(@RecentlyNonNull int i) {
        return this.zzd <= i;
    }

    @KeepForSdk
    public void v(@RecentlyNonNull String str, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    public void w(@RecentlyNonNull String str, @Nullable Object... objArr) {
        format(str, objArr);
    }

    @KeepForSdk
    public void wtf(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    @KeepForSdk
    public void e(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        format(str, objArr);
    }

    @KeepForSdk
    public void wtf(@RecentlyNonNull Throwable th) {
        Log.wtf(this.zza, th);
    }

    @KeepForSdk
    public void d(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    public void v(@RecentlyNonNull String str, @RecentlyNonNull Throwable th, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            format(str, objArr);
        }
    }

    private Logger(String str, String str2) {
        this.zzb = str2;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }
}
