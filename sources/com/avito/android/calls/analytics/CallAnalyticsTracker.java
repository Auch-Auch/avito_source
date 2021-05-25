package com.avito.android.calls.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u0019\u001a\u00020\u0004H&¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "", "", "permissionState", "", "trackPermissionState", "(Ljava/lang/String;)V", "", "isIncoming", "trackCallInitiated", "(Z)V", "trackReconnectStarted", "()V", "error", "trackReconnectError", "result", "trackCallEnded", "(ZLjava/lang/String;)V", "action", "trackCallUiShown", "trackLoginSuccess", "trackLoginError", "trackRefreshTokenSuccess", "trackRefreshTokenError", "trackError", "trackTokenUpdated", "trackTokenRegister", "trackTokenUnregister", "isSuccessful", "trackTokenRegistered", "trackTokenUnregistered", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallAnalyticsTracker {
    void trackCallEnded(boolean z, @NotNull String str);

    void trackCallInitiated(boolean z);

    void trackCallUiShown(@NotNull String str);

    void trackError(boolean z, @NotNull String str);

    void trackLoginError(@NotNull String str);

    void trackLoginSuccess();

    void trackPermissionState(@NotNull String str);

    void trackReconnectError(@NotNull String str);

    void trackReconnectStarted();

    void trackRefreshTokenError(@NotNull String str);

    void trackRefreshTokenSuccess();

    void trackTokenRegister();

    void trackTokenRegistered(boolean z);

    void trackTokenUnregister();

    void trackTokenUnregistered(boolean z);

    void trackTokenUpdated();
}
