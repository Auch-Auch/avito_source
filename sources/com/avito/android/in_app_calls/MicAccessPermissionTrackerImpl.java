package com.avito.android.in_app_calls;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.analytics.events.MicAccessStateEvent;
import com.avito.android.calls_shared.di.CallsModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/MicAccessPermissionTrackerImpl;", "Lcom/avito/android/in_app_calls/MicAccessPermissionTracker;", "", "hasAccess", "", "trackMicAccessChange", "(Z)V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/analytics/Analytics;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class MicAccessPermissionTrackerImpl implements MicAccessPermissionTracker {
    public final Preferences a;
    public final Analytics b;

    @Inject
    public MicAccessPermissionTrackerImpl(@CallsModule.InAppCallsPreferences @NotNull Preferences preferences, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = preferences;
        this.b = analytics;
    }

    @Override // com.avito.android.in_app_calls.MicAccessPermissionTracker
    public void trackMicAccessChange(boolean z) {
        if (z != this.a.getBoolean("calls.has_mic_access", false)) {
            this.a.putBoolean("calls.has_mic_access", z);
            this.b.track(new MicAccessStateEvent(z));
        }
    }
}
