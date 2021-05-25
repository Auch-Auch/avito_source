package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.util.Initializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "Lcom/avito/android/util/Initializable;", "", "message", "", "log", "(Ljava/lang/String;)V", "", "cause", "trackException", "(Ljava/lang/Throwable;)V", "identifier", "setUserIdentifier", "key", "", "value", "setInt", "(Ljava/lang/String;I)V", "setString", "(Ljava/lang/String;Ljava/lang/String;)V", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public interface FirebaseCrashlytics extends Initializable {
    @Nullable
    String getString(@NotNull String str);

    void log(@NotNull String str);

    void setInt(@NotNull String str, int i);

    void setString(@NotNull String str, @NotNull String str2);

    void setUserIdentifier(@NotNull String str);

    void trackException(@NotNull Throwable th);
}
