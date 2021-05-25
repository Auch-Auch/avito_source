package com.avito.android.account;

import com.avito.android.Features;
import com.avito.android.account.analytics.event.LogoutDebugEvent;
import com.avito.android.account.analytics.event.SessionUpdateEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/account/SessionChangeTrackerImpl;", "Lcom/avito/android/account/SessionChangeTracker;", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "", "source", "", "trackSessionUpdate", "(Lcom/avito/android/remote/model/Session;Ljava/lang/String;)V", "trackLogout", "(Ljava/lang/String;)V", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class SessionChangeTrackerImpl implements SessionChangeTracker {
    public final Features a;
    public final Analytics b;

    @Inject
    public SessionChangeTrackerImpl(@NotNull Features features, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = features;
        this.b = analytics;
    }

    @Override // com.avito.android.account.SessionChangeTracker
    public void trackLogout(@Nullable String str) {
        if (str != null) {
            if ((this.a.getLogoutAnalytics().invoke().booleanValue() ? str : null) != null) {
                this.b.track(new LogoutDebugEvent(str));
            }
        }
    }

    @Override // com.avito.android.account.SessionChangeTracker
    public void trackSessionUpdate(@Nullable Session session, @Nullable String str) {
        if (str != null) {
            String str2 = null;
            if (!this.a.getLogoutAnalytics().invoke().booleanValue()) {
                str = null;
            }
            if (str != null) {
                Analytics analytics = this.b;
                boolean z = true;
                boolean z2 = session != null;
                if (session != null) {
                    str2 = session.getRefreshToken();
                }
                if (str2 == null) {
                    z = false;
                }
                analytics.track(new SessionUpdateEvent(z2, z, str));
            }
        }
    }
}
