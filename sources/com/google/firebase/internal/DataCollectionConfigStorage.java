package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
public class DataCollectionConfigStorage {
    @VisibleForTesting
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
    public final Context a;
    public final SharedPreferences b;
    public final Publisher c;
    public boolean d;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        boolean z;
        context = Build.VERSION.SDK_INT >= 24 ? ContextCompat.createDeviceProtectedStorageContext(context) : context;
        this.a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.b = sharedPreferences;
        this.c = publisher;
        if (sharedPreferences.contains(DATA_COLLECTION_DEFAULT_ENABLED)) {
            z = sharedPreferences.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED, true);
        } else {
            z = a();
        }
        this.d = z;
    }

    public final boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(DATA_COLLECTION_DEFAULT_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public final synchronized void b(boolean z) {
        if (this.d != z) {
            this.d = z;
            this.c.publish(new Event<>(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
        }
    }

    public synchronized boolean isEnabled() {
        return this.d;
    }

    public synchronized void setEnabled(Boolean bool) {
        if (bool == null) {
            this.b.edit().remove(DATA_COLLECTION_DEFAULT_ENABLED).apply();
            b(a());
        } else {
            boolean equals = Boolean.TRUE.equals(bool);
            this.b.edit().putBoolean(DATA_COLLECTION_DEFAULT_ENABLED, equals).apply();
            b(equals);
        }
    }
}
