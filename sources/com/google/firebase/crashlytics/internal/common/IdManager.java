package com.google.firebase.crashlytics.internal.common;

import a2.j.e.d.d.a.k0;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    public static final Pattern f = Pattern.compile("[^\\p{Alnum}]");
    public static final String g = Pattern.quote("/");
    public final k0 a;
    public final Context b;
    public final String c;
    public final FirebaseInstallationsApi d;
    public String e;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.b = context;
            this.c = str;
            this.d = firebaseInstallationsApi;
            this.a = new k0();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    public final synchronized String a(String str, SharedPreferences sharedPreferences) {
        String str2;
        String uuid = UUID.randomUUID().toString();
        if (uuid == null) {
            str2 = null;
        } else {
            str2 = f.matcher(uuid).replaceAll("").toLowerCase(Locale.US);
        }
        Logger logger = Logger.getLogger();
        logger.d("Created new Crashlytics IID: " + str2);
        sharedPreferences.edit().putString("crashlytics.installation.id", str2).putString("firebase.installation.id", str).apply();
        return str2;
    }

    public final synchronized void b(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        Logger logger = Logger.getLogger();
        logger.d("Migrating legacy Crashlytics IID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
    }

    public final String c(String str) {
        return str.replaceAll(g, "");
    }

    public String getAppIdentifier() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    @NonNull
    public synchronized String getCrashlyticsInstallId() {
        String str;
        String str2 = this.e;
        if (str2 != null) {
            return str2;
        }
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.b);
        Task<String> id = this.d.getId();
        String string = sharedPrefs.getString("firebase.installation.id", null);
        try {
            str = (String) Utils.awaitEvenIfOnMainThread(id);
        } catch (Exception e2) {
            Logger.getLogger().d("Failed to retrieve installation id", e2);
            str = string != 0 ? string : null;
        }
        if (string == null) {
            SharedPreferences legacySharedPrefs = CommonUtils.getLegacySharedPrefs(this.b);
            String string2 = legacySharedPrefs.getString("crashlytics.installation.id", null);
            Logger logger = Logger.getLogger();
            logger.d("No cached FID; legacy id is " + string2);
            if (string2 == null) {
                this.e = a(str, sharedPrefs);
            } else {
                this.e = string2;
                b(string2, str, sharedPrefs, legacySharedPrefs);
            }
            return this.e;
        }
        if (string.equals(str)) {
            this.e = sharedPrefs.getString("crashlytics.installation.id", null);
            Logger logger2 = Logger.getLogger();
            logger2.d("Found matching FID, using Crashlytics IID: " + this.e);
            if (this.e == null) {
                this.e = a(str, sharedPrefs);
            }
        } else {
            this.e = a(str, sharedPrefs);
        }
        return this.e;
    }

    public String getInstallerPackageName() {
        String str;
        k0 k0Var = this.a;
        Context context = this.b;
        synchronized (k0Var) {
            if (k0Var.a == null) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                k0Var.a = installerPackageName;
            }
            str = "".equals(k0Var.a) ? null : k0Var.a;
        }
        return str;
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", c(Build.MANUFACTURER), c(Build.MODEL));
    }

    public String getOsBuildVersionString() {
        return c(Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return c(Build.VERSION.RELEASE);
    }
}
