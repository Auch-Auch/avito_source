package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
public class DataCollectionArbiter {
    public final SharedPreferences a;
    public final FirebaseApp b;
    public final Object c;
    public TaskCompletionSource<Void> d = new TaskCompletionSource<>();
    public boolean e = false;
    public boolean f = false;
    @Nullable
    public Boolean g;
    public TaskCompletionSource<Void> h = new TaskCompletionSource<>();

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Boolean bool;
        Object obj = new Object();
        this.c = obj;
        Context applicationContext = firebaseApp.getApplicationContext();
        this.b = firebaseApp;
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(applicationContext);
        this.a = sharedPrefs;
        if (sharedPrefs.contains("firebase_crashlytics_collection_enabled")) {
            this.f = false;
            bool = Boolean.valueOf(sharedPrefs.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            bool = null;
        }
        this.g = bool == null ? a(applicationContext) : bool;
        synchronized (obj) {
            if (isAutomaticDataCollectionEnabled()) {
                this.d.trySetResult(null);
                this.e = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean a(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "firebase_crashlytics_collection_enabled"
            r1 = 0
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x002a }
            if (r2 == 0) goto L_0x0034
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x002a }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r2.getApplicationInfo(r5, r3)     // Catch:{ NameNotFoundException -> 0x002a }
            if (r5 == 0) goto L_0x0034
            android.os.Bundle r2 = r5.metaData     // Catch:{ NameNotFoundException -> 0x002a }
            if (r2 == 0) goto L_0x0034
            boolean r2 = r2.containsKey(r0)     // Catch:{ NameNotFoundException -> 0x002a }
            if (r2 == 0) goto L_0x0034
            android.os.Bundle r5 = r5.metaData     // Catch:{ NameNotFoundException -> 0x002a }
            boolean r5 = r5.getBoolean(r0)     // Catch:{ NameNotFoundException -> 0x002a }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ NameNotFoundException -> 0x002a }
            goto L_0x0035
        L_0x002a:
            r5 = move-exception
            com.google.firebase.crashlytics.internal.Logger r0 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r2 = "Unable to get PackageManager. Falling through"
            r0.d(r2, r5)
        L_0x0034:
            r5 = r1
        L_0x0035:
            if (r5 != 0) goto L_0x003b
            r5 = 0
            r4.f = r5
            return r1
        L_0x003b:
            r0 = 1
            r4.f = r0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r5 = r0.equals(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.DataCollectionArbiter.a(android.content.Context):java.lang.Boolean");
    }

    public void grantDataCollectionPermission(boolean z) {
        if (z) {
            this.h.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean z;
        String str;
        Boolean bool = this.g;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = this.b.isDataCollectionDefaultEnabled();
        }
        String str2 = z ? "ENABLED" : "DISABLED";
        if (this.g == null) {
            str = "global Firebase setting";
        } else {
            str = this.f ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", str2, str));
        return z;
    }

    public synchronized void setCrashlyticsDataCollectionEnabled(@Nullable Boolean bool) {
        this.g = bool != null ? bool : a(this.b.getApplicationContext());
        SharedPreferences.Editor edit = this.a.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.commit();
        synchronized (this.c) {
            if (isAutomaticDataCollectionEnabled()) {
                if (!this.e) {
                    this.d.trySetResult(null);
                    this.e = true;
                }
            } else if (this.e) {
                this.d = new TaskCompletionSource<>();
                this.e = false;
            }
        }
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.c) {
            task = this.d.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission() {
        return Utils.race(this.h.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
