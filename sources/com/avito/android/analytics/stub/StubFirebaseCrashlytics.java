package com.avito.android.analytics.stub;

import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/analytics/stub/StubFirebaseCrashlytics;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "", "message", "", "log", "(Ljava/lang/String;)V", "", "cause", "trackException", "(Ljava/lang/Throwable;)V", "identifier", "setUserIdentifier", "key", "", "value", "setInt", "(Ljava/lang/String;I)V", "setString", "(Ljava/lang/String;Ljava/lang/String;)V", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "onInitialized", "initialize", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class StubFirebaseCrashlytics implements FirebaseCrashlytics {
    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    @Nullable
    public String getString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return null;
    }

    @Override // com.avito.android.util.Initializable
    public void initialize(@Nullable Function0<Unit> function0) {
    }

    @Override // com.avito.android.util.Initializable
    public boolean isInitialized() {
        return true;
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void log(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Logs.debug$default("StubFirebaseCrashlytics", "log: " + str, null, 4, null);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void setInt(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Logs.debug$default("StubFirebaseCrashlytics", "setInt: " + str + ", " + i, null, 4, null);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void setString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        Logs.debug$default("StubFirebaseCrashlytics", "setInt: " + str + ", " + str2, null, 4, null);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void setUserIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Logs.debug$default("StubFirebaseCrashlytics", "setUserIdentifier: " + str, null, 4, null);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics
    public void trackException(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Logs.debug$default("StubFirebaseCrashlytics", "log: " + th, null, 4, null);
    }
}
