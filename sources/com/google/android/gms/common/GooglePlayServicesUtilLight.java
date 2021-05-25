package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;
@ShowFirstParty
@KeepForSdk
public class GooglePlayServicesUtilLight {
    @KeepForSdk
    public static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    @KeepForSdk
    public static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @RecentlyNonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @VisibleForTesting
    @KeepForSdk
    public static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    @VisibleForTesting
    private static boolean zza = false;
    @VisibleForTesting
    private static boolean zzb = false;
    private static boolean zzc = false;
    @VisibleForTesting
    private static boolean zzd = false;
    private static final AtomicBoolean zze = new AtomicBoolean();

    @KeepForSdk
    @Deprecated
    public static void cancelAvailabilityErrorNotifications(@RecentlyNonNull Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void enableUsingApkIndependentContext() {
        zze.set(true);
    }

    @KeepForSdk
    @Deprecated
    public static void ensurePlayServicesAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @RecentlyNonNull
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static int getApkVersion(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @RecentlyNonNull
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static int getClientVersion(@RecentlyNonNull Context context) {
        Preconditions.checkState(true);
        return ClientLibraryUtils.getClientVersion(context, context.getPackageName());
    }

    @RecentlyNullable
    @KeepForSdk
    @Deprecated
    public static PendingIntent getErrorPendingIntent(@RecentlyNonNull int i, @RecentlyNonNull Context context, @RecentlyNonNull int i2) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2);
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    @KeepForSdk
    public static String getErrorString(@RecentlyNonNull int i) {
        return ConnectionResult.zza(i);
    }

    @RecentlyNullable
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(@RecentlyNonNull int i) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, i, null);
    }

    @RecentlyNullable
    @KeepForSdk
    public static Context getRemoteContext(@RecentlyNonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RecentlyNullable
    @KeepForSdk
    public static Resources getRemoteResource(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public static boolean honorsDebugCertificates(@RecentlyNonNull Context context) {
        boolean z = true;
        if (!zzd) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || GoogleSignatureVerifier.zza(packageInfo, false) || !GoogleSignatureVerifier.zza(packageInfo, true)) {
                    zzc = false;
                } else {
                    zzc = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } finally {
                zzd = z;
            }
        }
        return zzc || !DeviceProperties.isUserBuild();
    }

    @RecentlyNonNull
    @Deprecated
    @HideFirstParty
    @KeepForSdk
    public static int isGooglePlayServicesAvailable(@RecentlyNonNull Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static boolean isGooglePlayServicesUid(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        return UidVerifier.isGooglePlayServicesUid(context, i);
    }

    @RecentlyNonNull
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static boolean isPlayServicesPossiblyUpdating(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @RecentlyNonNull
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static boolean isPlayStorePossiblyUpdating(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        if (i == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    @TargetApi(18)
    public static boolean isRestrictedUserProfile(@RecentlyNonNull Context context) {
        Bundle applicationRestrictions;
        return PlatformVersion.isAtLeastJellyBeanMR2() && (applicationRestrictions = ((UserManager) Preconditions.checkNotNull(context.getSystemService("user"))).getApplicationRestrictions(context.getPackageName())) != null && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile"));
    }

    @RecentlyNonNull
    @VisibleForTesting
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static boolean isSidewinderDevice(@RecentlyNonNull Context context) {
        return DeviceProperties.isSidewinder(context);
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static boolean isUserRecoverableError(@RecentlyNonNull int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @RecentlyNonNull
    @Deprecated
    @KeepForSdk
    @TargetApi(19)
    public static boolean uidHasPackageName(@RecentlyNonNull Context context, @RecentlyNonNull int i, @RecentlyNonNull String str) {
        return UidVerifier.uidHasPackageName(context, i, str);
    }

    @VisibleForTesting
    private static int zza(Context context, boolean z, int i) {
        Preconditions.checkArgument(i >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier.getInstance(context);
            if (!GoogleSignatureVerifier.zza(packageInfo2, true)) {
                String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid.");
                return 9;
            } else if (z && (!GoogleSignatureVerifier.zza((PackageInfo) Preconditions.checkNotNull(packageInfo), true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid.");
                return 9;
            } else if (zza.zza(packageInfo2.versionCode) < zza.zza(i)) {
                String.valueOf(packageName).length();
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                        return 1;
                    }
                }
                if (!applicationInfo.enabled) {
                    return 3;
                }
                return 0;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            String.valueOf(packageName).concat(" requires Google Play services, but they are missing.");
            return 1;
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zze.get()) {
            int zzb2 = zzt.zzb(context);
            if (zzb2 != 0) {
                int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                if (zzb2 != i2) {
                    StringBuilder sb = new StringBuilder(320);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i2);
                    sb.append(" but found ");
                    sb.append(zzb2);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return zza(context, !DeviceProperties.isWearableWithoutPlayStore(context) && !DeviceProperties.zza(context), i);
    }

    @TargetApi(21)
    public static boolean zza(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !isRestrictedUserProfile(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }
}
