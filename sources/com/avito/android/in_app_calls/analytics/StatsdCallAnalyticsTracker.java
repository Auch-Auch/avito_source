package com.avito.android.in_app_calls.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\nR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/in_app_calls/analytics/StatsdCallAnalyticsTracker;", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "", "permissionState", "", "trackPermissionState", "(Ljava/lang/String;)V", "", "isIncoming", "trackCallInitiated", "(Z)V", "result", "trackCallEnded", "(ZLjava/lang/String;)V", "trackReconnectStarted", "()V", "error", "trackReconnectError", "action", "trackCallUiShown", "trackLoginSuccess", "trackLoginError", "trackRefreshTokenSuccess", "trackRefreshTokenError", "trackError", "trackTokenUpdated", "trackTokenRegister", "trackTokenUnregister", "isSuccessful", "trackTokenRegistered", "trackTokenUnregistered", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class StatsdCallAnalyticsTracker implements CallAnalyticsTracker {
    public final Analytics a;

    @Inject
    public StatsdCallAnalyticsTracker(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackCallEnded(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        if (z) {
            this.a.track(new StatsdEvent.CountEvent(a.c3("calls.in.end.", str), 0, 2, null));
        } else {
            this.a.track(new StatsdEvent.CountEvent(a.c3("calls.out.end.", str), 0, 2, null));
        }
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackCallInitiated(boolean z) {
        if (z) {
            this.a.track(new StatsdEvent.CountEvent("calls.in.start", 0, 2, null));
        } else {
            this.a.track(new StatsdEvent.CountEvent("calls.out.start", 0, 2, null));
        }
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackCallUiShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.ui_shown.", str), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackError(boolean z, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        if (z) {
            this.a.track(new StatsdEvent.CountEvent(a.c3("calls.in.error.", str), 0, 2, null));
        } else {
            this.a.track(new StatsdEvent.CountEvent(a.c3("calls.out.error.", str), 0, 2, null));
        }
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackLoginError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.login.error.", str), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackLoginSuccess() {
        this.a.track(new StatsdEvent.CountEvent("calls.login.success", 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackPermissionState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permissionState");
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.permission.", str), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackReconnectError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.reconnect.", str), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackReconnectStarted() {
        this.a.track(new StatsdEvent.CountEvent("calls.reconnect.start", 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackRefreshTokenError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.refresh_token.error.", str), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackRefreshTokenSuccess() {
        this.a.track(new StatsdEvent.CountEvent("calls.refresh_token.success", 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackTokenRegister() {
        this.a.track(new StatsdEvent.CountEvent("calls.token.reg.start", 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackTokenRegistered(boolean z) {
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.token.reg.", z ? "success" : PaymentStateKt.PAYMENT_STATE_FAILED), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackTokenUnregister() {
        this.a.track(new StatsdEvent.CountEvent("calls.token.unreg.start", 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackTokenUnregistered(boolean z) {
        this.a.track(new StatsdEvent.CountEvent(a.c3("calls.token.unreg.", z ? "success" : PaymentStateKt.PAYMENT_STATE_FAILED), 0, 2, null));
    }

    @Override // com.avito.android.calls.analytics.CallAnalyticsTracker
    public void trackTokenUpdated() {
        this.a.track(new StatsdEvent.CountEvent("calls.token.refreshed", 0, 2, null));
    }
}
