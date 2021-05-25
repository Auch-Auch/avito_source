package com.avito.android.analytics.statsd;

import a2.b.a.a.a;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB5\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEventTrackerImpl;", "Lcom/avito/android/analytics/statsd/StatsdEventTracker;", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "event", "", "trackEvent", "(Lcom/avito/android/analytics/statsd/StatsdEvent;)V", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lcom/avito/android/analytics/statsd/StatsdRecord;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "storage", "Lcom/avito/android/analytics/statsd/StatsdEventTrackerImpl$Config;", "d", "Lcom/avito/android/analytics/statsd/StatsdEventTrackerImpl$Config;", Navigation.CONFIG, "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "e", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "c", "Lcom/avito/android/analytics/statsd/StatsdEventValidator;", "validator", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "sender", "<init>", "(Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;Lcom/avito/android/analytics/statsd/StatsdEventValidator;Lcom/avito/android/analytics/statsd/StatsdEventTrackerImpl$Config;Lcom/avito/android/analytics/grafana/GraphitePrefix;)V", "Config", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public final class StatsdEventTrackerImpl implements StatsdEventTracker {
    public final InHouseEventStorage<StatsdRecord> a;
    public final InHouseAnalyticsFlushInteractor b;
    public final StatsdEventValidator c;
    public final Config d;
    public final GraphitePrefix e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEventTrackerImpl$Config;", "", "", AuthSource.BOOKING_ORDER, "Z", "getLogEvents", "()Z", "logEvents", "", AuthSource.SEND_ABUSE, "I", "getEventCountThreshold", "()I", "eventCountThreshold", "<init>", "(IZ)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class Config {
        public final int a;
        public final boolean b;

        public Config(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public final int getEventCountThreshold() {
            return this.a;
        }

        public final boolean getLogEvents() {
            return this.b;
        }
    }

    public StatsdEventTrackerImpl(@NotNull InHouseEventStorage<StatsdRecord> inHouseEventStorage, @NotNull InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, @NotNull StatsdEventValidator statsdEventValidator, @NotNull Config config, @NotNull GraphitePrefix graphitePrefix) {
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsFlushInteractor, "sender");
        Intrinsics.checkNotNullParameter(statsdEventValidator, "validator");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        Intrinsics.checkNotNullParameter(graphitePrefix, "graphitePrefix");
        this.a = inHouseEventStorage;
        this.b = inHouseAnalyticsFlushInteractor;
        this.c = statsdEventValidator;
        this.d = config;
        this.e = graphitePrefix;
    }

    @Override // com.avito.android.analytics.statsd.StatsdEventTracker
    public void trackEvent(@NotNull StatsdEvent statsdEvent) {
        StatsdType statsdType;
        Intrinsics.checkNotNullParameter(statsdEvent, "event");
        this.c.validateOrFail(statsdEvent);
        String str = this.e.getAppType() + FormatterType.defaultDecimalSeparator + statsdEvent.getKey();
        Number value = statsdEvent.getValue();
        if (statsdEvent instanceof StatsdEvent.TimeEvent) {
            statsdType = StatsdType.TIME;
        } else if (statsdEvent instanceof StatsdEvent.CountEvent) {
            statsdType = StatsdType.COUNT;
        } else if (statsdEvent instanceof StatsdEvent.GaugeEvent) {
            statsdType = StatsdType.GAUGE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        StatsdRecord statsdRecord = new StatsdRecord(str, statsdType, value);
        this.a.add(statsdRecord);
        if (this.d.getLogEvents()) {
            StringBuilder L = a.L("Event: ");
            L.append(statsdRecord.getType());
            L.append(':');
            L.append(statsdRecord.getKey());
            L.append(':');
            L.append(statsdRecord.getValue());
            Logs.debug$default(StatsdEventTrackerKt.LOG_TAG, L.toString(), null, 4, null);
        }
        int eventCount = this.a.getEventCount();
        if (eventCount > 0 && eventCount % this.d.getEventCountThreshold() == 0) {
            this.b.flush();
        }
    }
}
