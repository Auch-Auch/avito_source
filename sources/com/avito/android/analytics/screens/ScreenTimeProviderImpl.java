package com.avito.android.analytics.screens;

import com.avito.android.app.StartupTime;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/analytics/screens/ScreenTimeProviderImpl;", "Lcom/avito/android/analytics/screens/ScreenTimeProvider;", "", "screenStartTimestamp", "()J", "timestampSince1970", "preInitTime", "lastClickTimestamp", "startupTimeTimestamp", "touchTimeDiff", AuthSource.SEND_ABUSE, "J", AuthSource.BOOKING_ORDER, "<init>", "()V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class ScreenTimeProviderImpl implements ScreenTimeProvider {
    public final long a = System.currentTimeMillis();
    public final long b;

    @Inject
    public ScreenTimeProviderImpl() {
        long currentTimeMillis;
        long timestamp = LastClick.getTimestamp();
        this.b = (timestamp == 0 || System.currentTimeMillis() - timestamp > 10000) ? 0 : currentTimeMillis;
    }

    @Override // com.avito.android.analytics.screens.ScreenTimeProvider
    public long lastClickTimestamp() {
        return LastClick.getTimestamp();
    }

    @Override // com.avito.android.analytics.screens.ScreenTimeProvider
    public long preInitTime() {
        return this.b;
    }

    @Override // com.avito.android.analytics.screens.ScreenTimeProvider
    public long screenStartTimestamp() {
        return this.a;
    }

    @Override // com.avito.android.analytics.screens.ScreenTimeProvider
    public long startupTimeTimestamp() {
        return StartupTime.getTimestamp();
    }

    @Override // com.avito.android.analytics.screens.ScreenTimeProvider
    public long timestampSince1970() {
        return System.currentTimeMillis();
    }

    @Override // com.avito.android.analytics.screens.ScreenTimeProvider
    public long touchTimeDiff() {
        return timestampSince1970() - lastClickTimestamp();
    }
}
