package com.avito.android.messenger.analytics.graphite_counter;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounterImpl;", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "", "trackSuccess", "()V", "trackError", "", "outcome", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", "Ljava/lang/String;", "key", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerGraphiteCounterImpl implements MessengerGraphiteCounter {
    public final String a;
    public final Analytics b;

    public MessengerGraphiteCounterImpl(@NotNull String str, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = str;
        this.b = analytics;
    }

    public final void a(String str) {
        StringBuilder L = a.L("messenger.");
        L.append(this.a);
        L.append(FormatterType.defaultDecimalSeparator);
        L.append(str);
        StatsdEvent.CountEvent countEvent = new StatsdEvent.CountEvent(L.toString(), 0, 2, null);
        Logs.debug$default("graphite", a.u(a.L("counter hit: key="), this.a, ", outcome=", str), null, 4, null);
        this.b.track(countEvent);
    }

    @Override // com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter
    public void trackError() {
        a("error");
    }

    @Override // com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter
    public void trackSuccess() {
        a("success");
    }
}
