package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.util.Objects;
public class FirebaseCrashlytics {
    public final CrashlyticsCore a;

    public FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.a = crashlyticsCore;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.a.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.a.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.a.didCrashOnPreviousExecution();
    }

    public void log(@NonNull String str) {
        this.a.log(str);
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            Logger.getLogger().w("Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.a.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.a.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.a.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(@NonNull String str, boolean z) {
        this.a.setCustomKey(str, Boolean.toString(z));
    }

    public void setUserId(@NonNull String str) {
        this.a.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.a.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(@NonNull String str, double d) {
        this.a.setCustomKey(str, Double.toString(d));
    }

    public void setCustomKey(@NonNull String str, float f) {
        this.a.setCustomKey(str, Float.toString(f));
    }

    public void setCustomKey(@NonNull String str, int i) {
        this.a.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(@NonNull String str, long j) {
        this.a.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.a.setCustomKey(str, str2);
    }
}
