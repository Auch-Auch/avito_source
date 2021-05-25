package com.avito.android.ab_tests;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.events.ConfigChangedEvent;
import com.avito.android.analytics.events.ConfigStartFetchingEvent;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/ab_tests/ABTestConfigTrackerImpl;", "Lcom/avito/android/ab_tests/ABTestConfigTracker;", "", "trackAbTestConfigStore", "()V", "trackAbTestConfigGsonFallback", "", "isChanged", "trackAbTestConfigChanged", "(Z)V", "trackAbTestConfigStartFetching", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/grafana/GraphitePrefix;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public final class ABTestConfigTrackerImpl implements ABTestConfigTracker {
    public final Analytics a;
    public final GraphitePrefix b;

    @Inject
    public ABTestConfigTrackerImpl(@NotNull Analytics analytics, @NotNull GraphitePrefix graphitePrefix) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        this.a = analytics;
        this.b = graphitePrefix;
    }

    @Override // com.avito.android.ab_tests.ABTestConfigTracker
    public void trackAbTestConfigChanged(boolean z) {
        this.a.track(new ConfigChangedEvent(z));
    }

    @Override // com.avito.android.ab_tests.ABTestConfigTracker
    public void trackAbTestConfigGsonFallback() {
        this.a.track(new StatsdEvent.CountEvent(this.b.getVersionsPrefix() + ".ab-test-config.absolute.gson-fallback", 1));
    }

    @Override // com.avito.android.ab_tests.ABTestConfigTracker
    public void trackAbTestConfigStartFetching() {
        this.a.track(new ConfigStartFetchingEvent());
    }

    @Override // com.avito.android.ab_tests.ABTestConfigTracker
    public void trackAbTestConfigStore() {
        this.a.track(new StatsdEvent.CountEvent(this.b.getVersionsPrefix() + ".ab-test-config.absolute.store", 1));
    }
}
