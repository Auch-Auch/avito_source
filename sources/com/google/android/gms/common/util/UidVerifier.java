package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;
@KeepForSdk
public final class UidVerifier {
    private UidVerifier() {
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isGooglePlayServicesUid(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        if (!uidHasPackageName(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    @TargetApi(19)
    public static boolean uidHasPackageName(@RecentlyNonNull Context context, @RecentlyNonNull int i, @RecentlyNonNull String str) {
        return Wrappers.packageManager(context).zza(i, str);
    }
}
