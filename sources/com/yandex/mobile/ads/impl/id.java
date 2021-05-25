package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.fz;
import java.util.Collection;
public final class id {
    public static boolean a(Collection... collectionArr) {
        Collection[] collectionArr2 = (Collection[]) a((Object[]) collectionArr);
        for (Collection collection : collectionArr2) {
            if (collection == null || collection.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static <T> T[] a(T[] tArr) {
        return tArr == null ? (T[]) new Object[0] : tArr;
    }

    @Nullable
    public static synchronized fz b(@NonNull Context context) {
        fz fzVar;
        synchronized (id.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("YadPreferenceFile", 0);
            long j = sharedPreferences.getLong("SdkConfigurationExpiredDate", 0);
            Boolean a = a(sharedPreferences, "SdkConfigurationVisibilityErrorIndicatorEnabled");
            fzVar = null;
            if (j != 0) {
                int i = sharedPreferences.getInt("AdIdsStorageSize", 0);
                Boolean a3 = a(sharedPreferences, "SdkConfigurationMediationSensitiveModeDisabled");
                boolean z = sharedPreferences.getBoolean("SdkConfigurationMrcVisibilityTrackingEnabled", false);
                boolean z2 = sharedPreferences.getBoolean("SdkConfigurationCustomUserAgentEnabled", false);
                boolean z3 = sharedPreferences.getBoolean("SdkConfigurationFusedLocationProviderDisabled", false);
                boolean z4 = sharedPreferences.getBoolean("SdkConfigurationLockScreenEnabled", false);
                boolean z5 = sharedPreferences.getBoolean("SdkConfigurationAutograbEnabled", false);
                Boolean a4 = a(sharedPreferences, "SdkConfigurationUserConsent");
                String string = sharedPreferences.getString("SdkConfigurationLibraryVersion", null);
                String string2 = sharedPreferences.getString("SdkConfigurationMraidUrl", null);
                boolean z7 = sharedPreferences.getBoolean("CustomClickHandlingEnabled", false);
                boolean z8 = sharedPreferences.getBoolean("SdkConfigurationSensitiveModeDisabled", false);
                boolean z9 = sharedPreferences.getBoolean("UrlCorrectionEnabled", false);
                fzVar = new fz.a().b(string).c(a4).a(j).a(i).b(a3).d(z).e(z2).f(z3).g(z4).h(z5).c(z8).a(string2).a(z7).a(a).b(z9).i(sharedPreferences.getBoolean("SdkConfigurationLegacyVisibilityLogicEnabled", false)).a();
            }
        }
        return fzVar;
    }

    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static synchronized void a(@NonNull Context context, @NonNull fz fzVar) {
        synchronized (id.class) {
            SharedPreferences.Editor putInt = context.getSharedPreferences("YadPreferenceFile", 0).edit().putString("SdkConfigurationLibraryVersion", fzVar.m()).putBoolean("SdkConfigurationSensitiveModeDisabled", fzVar.d()).putLong("SdkConfigurationExpiredDate", fzVar.b()).putString("SdkConfigurationMraidUrl", fzVar.f()).putBoolean("CustomClickHandlingEnabled", fzVar.c()).putBoolean("UrlCorrectionEnabled", fzVar.o()).putInt("AdIdsStorageSize", fzVar.a());
            Boolean n = fzVar.n();
            Boolean g = fzVar.g();
            Boolean valueOf = Boolean.valueOf(fzVar.h());
            Boolean valueOf2 = Boolean.valueOf(fzVar.i());
            Boolean valueOf3 = Boolean.valueOf(fzVar.j());
            Boolean valueOf4 = Boolean.valueOf(fzVar.k());
            Boolean valueOf5 = Boolean.valueOf(fzVar.l());
            Boolean e = fzVar.e();
            Boolean valueOf6 = Boolean.valueOf(fzVar.p());
            a(putInt, "SdkConfigurationVisibilityErrorIndicatorEnabled", n);
            a(putInt, "SdkConfigurationMediationSensitiveModeDisabled", g);
            a(putInt, "SdkConfigurationMrcVisibilityTrackingEnabled", valueOf);
            a(putInt, "SdkConfigurationCustomUserAgentEnabled", valueOf2);
            a(putInt, "SdkConfigurationFusedLocationProviderDisabled", valueOf3);
            a(putInt, "SdkConfigurationLockScreenEnabled", valueOf4);
            a(putInt, "SdkConfigurationAutograbEnabled", valueOf5);
            a(putInt, "SdkConfigurationUserConsent", e);
            a(putInt, "SdkConfigurationLegacyVisibilityLogicEnabled", valueOf6);
            putInt.apply();
        }
    }

    private static void a(@NonNull SharedPreferences.Editor editor, @NonNull String str, @Nullable Boolean bool) {
        if (bool != null) {
            editor.putBoolean(str, bool.booleanValue());
        } else {
            editor.remove(str);
        }
    }

    @Nullable
    private static Boolean a(@NonNull SharedPreferences sharedPreferences, @NonNull String str) {
        if (sharedPreferences.contains(str)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
        }
        return null;
    }
}
