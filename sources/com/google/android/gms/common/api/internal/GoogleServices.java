package com.google.android.gms.common.api.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
@Deprecated
public final class GoogleServices {
    private static final Object zza = new Object();
    @Nullable
    @GuardedBy("sLock")
    private static GoogleServices zzb;
    @Nullable
    private final String zzc;
    private final Status zzd;
    private final boolean zze;
    private final boolean zzf;

    @VisibleForTesting
    @KeepForSdk
    public GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z = false;
        boolean z2 = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) != 0 ? true : z;
            this.zzf = !z;
            z2 = z;
        } else {
            this.zzf = false;
        }
        this.zze = z2;
        String zza2 = zzt.zza(context);
        zza2 = zza2 == null ? new StringResourceValueReader(context).getString("google_app_id") : zza2;
        if (TextUtils.isEmpty(zza2)) {
            this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzc = null;
            return;
        }
        this.zzc = zza2;
        this.zzd = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (zza) {
            googleServices = zzb;
            if (googleServices == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }

    @VisibleForTesting
    @KeepForSdk
    public static void clearInstanceForTest() {
        synchronized (zza) {
            zzb = null;
        }
    }

    @RecentlyNullable
    @KeepForSdk
    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzc;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Status initialize(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (zza) {
            GoogleServices googleServices = zzb;
            if (googleServices != null) {
                return googleServices.checkGoogleAppId(str);
            }
            GoogleServices googleServices2 = new GoogleServices(str, z);
            zzb = googleServices2;
            return googleServices2.zzd;
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        return checkInitialized.zzd.isSuccess() && checkInitialized.zze;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzf;
    }

    @VisibleForTesting
    @KeepForSdk
    public final Status checkGoogleAppId(String str) {
        String str2 = this.zzc;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.zzc;
        return new Status(10, a.s2(a.q0(str3, 97), "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '", str3, "'."));
    }

    @RecentlyNonNull
    @KeepForSdk
    public static Status initialize(@RecentlyNonNull Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (zza) {
            if (zzb == null) {
                zzb = new GoogleServices(context);
            }
            status = zzb.zzd;
        }
        return status;
    }

    @VisibleForTesting
    @KeepForSdk
    public GoogleServices(String str, boolean z) {
        this.zzc = str;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = z;
        this.zzf = !z;
    }
}
