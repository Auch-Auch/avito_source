package com.avito.android.enabler;

import com.avito.android.RemoteToggles;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.util.BuildInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/enabler/RemoteFeaturesStartupMonitor;", "", "", "checkMonitorToggle", "()V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/RemoteToggles;", "remoteToggles", "Lcom/avito/android/RemoteToggles;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/RemoteToggles;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public class RemoteFeaturesStartupMonitor {
    private final Analytics analytics;
    private final BuildInfo buildInfo;
    private final RemoteToggles remoteToggles;

    @Inject
    public RemoteFeaturesStartupMonitor(@NotNull RemoteToggles remoteToggles2, @NotNull Analytics analytics2, @NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(remoteToggles2, "remoteToggles");
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.remoteToggles = remoteToggles2;
        this.analytics = analytics2;
        this.buildInfo = buildInfo2;
    }

    public final void checkMonitorToggle() {
        String str = this.remoteToggles.getRemoteTogglesMonitor().invoke().booleanValue() ? "enabled" : "disabled";
        this.analytics.track(new StatsdEvent.CountEvent(MonitorsKt.basePrefix(this.buildInfo) + ".startup-monitor." + str, 0, 2, null));
    }
}
