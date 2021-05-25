package com.avito.android.calls_shared.tracker.events;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.calls_shared.CallSide;
import com.avito.android.calls_shared.analytics.events.AppCallEventType;
import com.avito.android.calls_shared.analytics.mapping.AppCallResultMappersKt;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEventStatsdInterceptor;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTrackerInterceptor;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "event", "", "process", "(Lcom/avito/android/calls_shared/tracker/events/CallEvent;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallEventStatsdInterceptor implements CallEventTrackerInterceptor {
    public final Analytics a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            CallSide.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            CallSide callSide = CallSide.OUTGOING;
            iArr[0] = 1;
            CallSide callSide2 = CallSide.INCOMING;
            iArr[1] = 2;
            CallSide.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
        }
    }

    @Inject
    public CallEventStatsdInterceptor(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = analytics;
    }

    @Override // com.avito.android.calls_shared.tracker.events.CallEventTrackerInterceptor
    public void process(@NotNull CallEvent callEvent) {
        Intrinsics.checkNotNullParameter(callEvent, "event");
        if (callEvent instanceof CallEvent.Connected) {
            CallSide side = callEvent.getSide();
            if (((CallEvent.Connected) callEvent).isReconnect()) {
                this.a.track(new StatsdEvent.CountEvent("calls.reconnect.success", 0, 2, null));
                return;
            }
            int ordinal = side.ordinal();
            if (ordinal == 0) {
                this.a.track(new StatsdEvent.CountEvent("calls.out.connect", 0, 2, null));
            } else if (ordinal == 1) {
                this.a.track(new StatsdEvent.CountEvent("calls.in.connect", 0, 2, null));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (callEvent instanceof CallEvent.Disconnected) {
            CallSide side2 = callEvent.getSide();
            AppCallEventType.Disconnected mapForEvent = AppCallResultMappersKt.mapForEvent(((CallEvent.Disconnected) callEvent).getResult());
            int ordinal2 = side2.ordinal();
            if (ordinal2 == 0) {
                Analytics analytics = this.a;
                analytics.track(new StatsdEvent.CountEvent("calls.out.end." + mapForEvent, 0, 2, null));
            } else if (ordinal2 == 1) {
                Analytics analytics2 = this.a;
                analytics2.track(new StatsdEvent.CountEvent("calls.in.end." + mapForEvent, 0, 2, null));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
