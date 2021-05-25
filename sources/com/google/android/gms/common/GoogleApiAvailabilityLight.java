package com.google.android.gms.common;

import a2.b.a.a.a;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
@ShowFirstParty
@KeepForSdk
public class GoogleApiAvailabilityLight {
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @RecentlyNonNull
    @KeepForSdk
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @KeepForSdk
    public static final String TRACKING_SOURCE_DIALOG = "d";
    @KeepForSdk
    public static final String TRACKING_SOURCE_NOTIFICATION = "n";
    private static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();

    @RecentlyNonNull
    @KeepForSdk
    public static GoogleApiAvailabilityLight getInstance() {
        return zza;
    }

    @VisibleForTesting
    private static String zza(@Nullable Context context, @Nullable String str) {
        StringBuilder L = a.L("gcore_");
        L.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        L.append("-");
        if (!TextUtils.isEmpty(str)) {
            L.append(str);
        }
        L.append("-");
        if (context != null) {
            L.append(context.getPackageName());
        }
        L.append("-");
        if (context != null) {
            try {
                L.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return L.toString();
    }

    @KeepForSdk
    public void cancelAvailabilityErrorNotifications(@RecentlyNonNull Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public int getApkVersion(@RecentlyNonNull Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(@RecentlyNonNull Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    @RecentlyNullable
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(@RecentlyNonNull int i) {
        return getErrorResolutionIntent(null, i, null);
    }

    @RecentlyNullable
    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(@RecentlyNonNull Context context, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        return getErrorResolutionPendingIntent(context, i, i2, null);
    }

    @NonNull
    @KeepForSdk
    public String getErrorString(@RecentlyNonNull int i) {
        return GooglePlayServicesUtilLight.getErrorString(i);
    }

    @RecentlyNonNull
    @HideFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public boolean isPlayServicesPossiblyUpdating(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i);
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public boolean isPlayStorePossiblyUpdating(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i);
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isUninstalledAppPossiblyUpdating(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
        return GooglePlayServicesUtilLight.zza(context, str);
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isUserResolvableError(@RecentlyNonNull int i) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i);
    }

    @KeepForSdk
    public void verifyGooglePlayServicesIsAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i);
    }

    @RecentlyNullable
    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(@Nullable Context context, @RecentlyNonNull int i, @Nullable String str) {
        if (i == 1 || i == 2) {
            if (context == null || !DeviceProperties.isWearableWithoutPlayStore(context)) {
                return zzj.zza("com.google.android.gms", zza(context, str));
            }
            return zzj.zza();
        } else if (i != 3) {
            return null;
        } else {
            return zzj.zza("com.google.android.gms");
        }
    }

    @RecentlyNullable
    @ShowFirstParty
    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(@RecentlyNonNull Context context, @RecentlyNonNull int i, @RecentlyNonNull int i2, @Nullable String str) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, errorResolutionIntent, 134217728);
    }

    @RecentlyNonNull
    @KeepForSdk
    public int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}
