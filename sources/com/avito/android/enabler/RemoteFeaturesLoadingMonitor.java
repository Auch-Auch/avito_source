package com.avito.android.enabler;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.util.BuildInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/enabler/RemoteFeaturesLoadingMonitor;", "", "", "reportLoadingFailed", "()V", "reportLoadingSuccess", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteFeaturesLoadingMonitor {
    private final Analytics analytics;
    private final BuildInfo buildInfo;

    @Inject
    public RemoteFeaturesLoadingMonitor(@NotNull Analytics analytics2, @NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.analytics = analytics2;
        this.buildInfo = buildInfo2;
    }

    public final void reportLoadingFailed() {
        this.analytics.track(new StatsdEvent.CountEvent(MonitorsKt.basePrefix(this.buildInfo) + ".startup.loading.error", 0, 2, null));
    }

    public final void reportLoadingSuccess() {
        this.analytics.track(new StatsdEvent.CountEvent(MonitorsKt.basePrefix(this.buildInfo) + ".startup.loading.success", 0, 2, null));
    }
}
