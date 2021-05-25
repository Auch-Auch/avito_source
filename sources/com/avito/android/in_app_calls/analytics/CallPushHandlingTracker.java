package com.avito.android.in_app_calls.analytics;

import com.avito.android.push.Push;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;", "", "Lcom/avito/android/push/Push;", "push", "", "trackNewPush", "(Lcom/avito/android/push/Push;)Ljava/lang/String;", "pushId", "", "connected", "", "trackPushHandlingFailed", "(Ljava/lang/String;Z)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallPushHandlingTracker {
    @NotNull
    String trackNewPush(@NotNull Push push);

    void trackPushHandlingFailed(@NotNull String str, boolean z);
}
