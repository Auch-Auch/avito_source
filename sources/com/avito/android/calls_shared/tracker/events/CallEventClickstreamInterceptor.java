package com.avito.android.calls_shared.tracker.events;

import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.analytics.mapping.CallEventFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEventClickstreamInterceptor;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTrackerInterceptor;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "event", "", "process", "(Lcom/avito/android/calls_shared/tracker/events/CallEvent;)V", "Lcom/avito/android/calls_shared/analytics/mapping/CallEventFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls_shared/analytics/mapping/CallEventFactory;", "callEventFactory", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/calls_shared/analytics/mapping/CallEventFactory;Lcom/avito/android/analytics/Analytics;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallEventClickstreamInterceptor implements CallEventTrackerInterceptor {
    public final CallEventFactory a;
    public final Analytics b;

    @Inject
    public CallEventClickstreamInterceptor(@NotNull CallEventFactory callEventFactory, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(callEventFactory, "callEventFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = callEventFactory;
        this.b = analytics;
    }

    @Override // com.avito.android.calls_shared.tracker.events.CallEventTrackerInterceptor
    public void process(@NotNull CallEvent callEvent) {
        Intrinsics.checkNotNullParameter(callEvent, "event");
        this.b.track(this.a.createEvent(callEvent));
    }
}
