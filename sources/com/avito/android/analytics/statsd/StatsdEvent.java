package com.avito.android.analytics.statsd;

import com.avito.android.analytics.Event;
import com.avito.android.analytics.GraphiteEvent;
import com.avito.android.remote.auth.AuthSource;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0010\u0011\u0012R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEvent;", "Lcom/avito/android/analytics/Event;", "Lcom/avito/android/analytics/GraphiteEvent;", "Ljava/io/Serializable;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Number;", "getValue", "()Ljava/lang/Number;", "value", "CountEvent", "GaugeEvent", "TimeEvent", "Lcom/avito/android/analytics/statsd/StatsdEvent$GaugeEvent;", "Lcom/avito/android/analytics/statsd/StatsdEvent$CountEvent;", "Lcom/avito/android/analytics/statsd/StatsdEvent$TimeEvent;", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public abstract class StatsdEvent implements Event, GraphiteEvent, Serializable {
    @NotNull
    public final String a;
    @NotNull
    public final Number b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEvent$CountEvent;", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "", "key", "", "value", "<init>", "(Ljava/lang/String;J)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class CountEvent extends StatsdEvent {
        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CountEvent(String str, long j, int i, j jVar) {
            this(str, (i & 2) != 0 ? 1 : j);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CountEvent(@NotNull String str, long j) {
            super(str, Long.valueOf(j), null);
            Intrinsics.checkNotNullParameter(str, "key");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEvent$GaugeEvent;", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "", "key", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Number;)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class GaugeEvent extends StatsdEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GaugeEvent(@NotNull String str, @NotNull Number number) {
            super(str, number, null);
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(number, "value");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdEvent$TimeEvent;", "Lcom/avito/android/analytics/statsd/StatsdEvent;", "", "key", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Number;)V", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class TimeEvent extends StatsdEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeEvent(@NotNull String str, @NotNull Number number) {
            super(str, number, null);
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(number, "value");
        }
    }

    public StatsdEvent(String str, Number number, j jVar) {
        this.a = str;
        this.b = number;
    }

    @NotNull
    public final String getKey() {
        return this.a;
    }

    @NotNull
    public final Number getValue() {
        return this.b;
    }
}
