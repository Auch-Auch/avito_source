package com.avito.android.analytics.clickstream;

import a2.g.r.g;
import android.os.Looper;
import com.avito.android.analytics.clickstream.ClickStreamEventTracker;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Logs;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import proto.events.apps.EventOuterClass;
import t6.r.a.j;
@NotThreadSafe
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00017BY\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020100\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamEventTrackerImpl;", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "event", "", "trackEvent", "(Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;)V", "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/clickstream/AnalyticMetricsFormatter;", "metricsFormatter", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTrackerImpl$Config;", "i", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTrackerImpl$Config;", Navigation.CONFIG, "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "j", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;", "timer", "Lcom/avito/android/server_time/TimeSource;", "h", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "k", "Z", "validateThreadUsage", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lproto/events/apps/EventOuterClass$Event;", "d", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "storage", "", "c", "Ljava/lang/String;", "parentRefId", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "e", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;", "sender", "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", g.a, "Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;", "saturator", "Lcom/avito/android/analytics/clickstream/FieldConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/clickstream/FieldConverter;", "fieldConverter", "", "Lcom/avito/android/analytics/clickstream/EventValidator;", "f", "Ljava/util/Set;", "validators", "<init>", "(Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsFlushInteractor;Ljava/util/Set;Lcom/avito/android/analytics/clickstream/ClickStreamEventTracker$ClickStreamEventSaturator;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/analytics/clickstream/ClickStreamEventTrackerImpl$Config;Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsTimer;Z)V", "Config", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamEventTrackerImpl implements ClickStreamEventTracker {
    public final AnalyticMetricsFormatter a;
    public final FieldConverter b;
    public String c;
    public final InHouseEventStorage<EventOuterClass.Event> d;
    public final InHouseAnalyticsFlushInteractor e;
    public final Set<EventValidator> f;
    public final ClickStreamEventTracker.ClickStreamEventSaturator g;
    public final TimeSource h;
    public final Config i;
    public final InHouseAnalyticsTimer j;
    public final boolean k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/clickstream/ClickStreamEventTrackerImpl$Config;", "", "", "c", "J", "getEventTimeThresholdInMillis", "()J", "eventTimeThresholdInMillis", "", AuthSource.SEND_ABUSE, "I", "getEventCountThreshold", "()I", "eventCountThreshold", "", AuthSource.BOOKING_ORDER, "Z", "getLogEvents", "()Z", "logEvents", "<init>", "(IZJ)V", "analytics-clickstream_release"}, k = 1, mv = {1, 4, 2})
    public static final class Config {
        public final int a;
        public final boolean b;
        public final long c;

        public Config(int i, boolean z, long j) {
            this.a = i;
            this.b = z;
            this.c = j;
        }

        public final int getEventCountThreshold() {
            return this.a;
        }

        public final long getEventTimeThresholdInMillis() {
            return this.c;
        }

        public final boolean getLogEvents() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Config(int i, boolean z, long j, int i2, j jVar) {
            this(i, z, (i2 & 4) != 0 ? TimeUnit.SECONDS.toMillis(60) : j);
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ClickStreamEventTrackerImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ClickStreamEventTrackerImpl clickStreamEventTrackerImpl) {
            super(0);
            this.a = clickStreamEventTrackerImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.e.flush();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Set<? extends com.avito.android.analytics.clickstream.EventValidator> */
    /* JADX WARN: Multi-variable type inference failed */
    public ClickStreamEventTrackerImpl(@NotNull InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage, @NotNull InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, @NotNull Set<? extends EventValidator> set, @NotNull ClickStreamEventTracker.ClickStreamEventSaturator clickStreamEventSaturator, @NotNull TimeSource timeSource, @NotNull Config config, @Nullable InHouseAnalyticsTimer inHouseAnalyticsTimer, boolean z) {
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(inHouseAnalyticsFlushInteractor, "sender");
        Intrinsics.checkNotNullParameter(set, "validators");
        Intrinsics.checkNotNullParameter(clickStreamEventSaturator, "saturator");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(config, Navigation.CONFIG);
        this.d = inHouseEventStorage;
        this.e = inHouseAnalyticsFlushInteractor;
        this.f = set;
        this.g = clickStreamEventSaturator;
        this.h = timeSource;
        this.i = config;
        this.j = inHouseAnalyticsTimer;
        this.k = z;
        AnalyticMetricsFormatter analyticMetricsFormatter = new AnalyticMetricsFormatter();
        this.a = analyticMetricsFormatter;
        this.b = new FieldConverter(analyticMetricsFormatter);
    }

    @Override // com.avito.android.analytics.clickstream.ClickStreamEventTracker
    public void trackEvent(@NotNull ClickStreamEvent clickStreamEvent) {
        InHouseAnalyticsTimer inHouseAnalyticsTimer;
        Intrinsics.checkNotNullParameter(clickStreamEvent, "event");
        boolean z = true;
        if (!this.k || (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
            a aVar = new a(this);
            InHouseAnalyticsTimer inHouseAnalyticsTimer2 = this.j;
            if (!(inHouseAnalyticsTimer2 == null || inHouseAnalyticsTimer2.isRunning() || (inHouseAnalyticsTimer = this.j) == null)) {
                inHouseAnalyticsTimer.set(this.i.getEventTimeThresholdInMillis(), aVar);
            }
            Iterator<T> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().validateOrFail(clickStreamEvent);
            }
            int eventId = clickStreamEvent.getEventId();
            EventOuterClass.Event.Builder putAllParams = EventOuterClass.Event.newBuilder().setEventId(eventId).setVersion(clickStreamEvent.getVersion()).putAllParams(this.b.convertFields(clickStreamEvent.getParams()));
            Intrinsics.checkNotNullExpressionValue(putAllParams, "builder");
            putAllParams.putAllEnv(this.g.environment());
            String paramsOrDefault = putAllParams.getParamsOrDefault(ClickStreamEventTrackerImplKt.REF_ID, null);
            if (paramsOrDefault == null) {
                paramsOrDefault = a2.b.a.a.a.I2("UUID.randomUUID().toString()");
            }
            putAllParams.removeParams(ClickStreamEventTrackerImplKt.REF_ID);
            putAllParams.putEnv(ClickStreamEventTrackerImplKt.REF_ID, paramsOrDefault);
            String str = this.c;
            if (str != null) {
                putAllParams.putEnv("parent_ref_id", str);
            }
            this.c = paramsOrDefault;
            putAllParams.putEnv(ClickStreamEventTrackerImplKt.CLIENT_TIMESTAMP_MS, this.a.formatTime(this.h.now(), TimeUnit.MILLISECONDS));
            EventOuterClass.Event event = (EventOuterClass.Event) putAllParams.build();
            InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage = this.d;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            inHouseEventStorage.add(event);
            if (this.i.getLogEvents()) {
                StringBuilder L = a2.b.a.a.a.L("Event id: ");
                L.append(event.getEventId());
                L.append(' ');
                L.append("version: ");
                L.append(event.getVersion());
                L.append(" \n");
                L.append("Params: ");
                L.append(event.getParamsMap());
                L.append(" \n");
                L.append("Env: ");
                L.append(event.getEnvMap());
                Logs.debug$default(ClickStreamEventTrackerKt.CS_LOG_TAG, L.toString(), null, 4, null);
            }
            int eventCount = this.d.getEventCount();
            if (eventCount <= 0 || eventCount % this.i.getEventCountThreshold() != 0) {
                z = false;
            }
            if (z) {
                this.e.flush();
                InHouseAnalyticsTimer inHouseAnalyticsTimer3 = this.j;
                if (inHouseAnalyticsTimer3 != null) {
                    inHouseAnalyticsTimer3.reset();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Sending event on main thread. May cause ANR".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickStreamEventTrackerImpl(InHouseEventStorage inHouseEventStorage, InHouseAnalyticsFlushInteractor inHouseAnalyticsFlushInteractor, Set set, ClickStreamEventTracker.ClickStreamEventSaturator clickStreamEventSaturator, TimeSource timeSource, Config config, InHouseAnalyticsTimer inHouseAnalyticsTimer, boolean z, int i2, j jVar) {
        this(inHouseEventStorage, inHouseAnalyticsFlushInteractor, set, clickStreamEventSaturator, timeSource, config, (i2 & 64) != 0 ? null : inHouseAnalyticsTimer, (i2 & 128) != 0 ? false : z);
    }
}
