package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/event/TabSelectedEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "tab", "<init>", "(Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class TabSelectedEvent implements FirebaseCrashlyticsEvent {
    public final String a;

    public TabSelectedEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tab");
        this.a = str;
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
    public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
        firebaseCrashlyticsEventTracker.trackEvent(this.a + " selected");
    }
}
