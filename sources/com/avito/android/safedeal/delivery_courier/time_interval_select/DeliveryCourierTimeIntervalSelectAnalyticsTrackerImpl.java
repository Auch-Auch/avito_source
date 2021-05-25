package com.avito.android.safedeal.delivery_courier.time_interval_select;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectAnalyticsTracker;", "", "trackLoadTimeIntervalsFailed", "()V", "trackTimeIntervalSelectBadData", "trackTimeIntervalSelectFailed", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl implements DeliveryCourierTimeIntervalSelectAnalyticsTracker {
    public final Analytics a;

    @Inject
    public DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTracker
    public void trackLoadTimeIntervalsFailed() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..time_interval_select.load.error", 0, 2, null));
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTracker
    public void trackTimeIntervalSelectBadData() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..time_interval_select.select.bad_data", 0, 2, null));
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectAnalyticsTracker
    public void trackTimeIntervalSelectFailed() {
        this.a.track(new StatsdEvent.CountEvent("delivery-courier..time_interval_select.select.failed", 0, 2, null));
    }
}
