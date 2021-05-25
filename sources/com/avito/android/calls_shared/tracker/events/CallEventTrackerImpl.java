package com.avito.android.calls_shared.tracker.events;

import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/calls_shared/tracker/events/CallEventTrackerImpl;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "Lcom/avito/android/calls_shared/tracker/events/CallEvent;", "event", "", "track", "(Lcom/avito/android/calls_shared/tracker/events/CallEvent;)V", "", "Lcom/avito/android/calls_shared/tracker/events/CallEventTrackerInterceptor;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "interceptors", "Lcom/avito/android/calls_shared/tracker/events/CallEventClickstreamInterceptor;", "clickstreamInterceptor", "Lcom/avito/android/calls_shared/tracker/events/CallEventStatsdInterceptor;", "statsdInterceptor", "<init>", "(Lcom/avito/android/calls_shared/tracker/events/CallEventClickstreamInterceptor;Lcom/avito/android/calls_shared/tracker/events/CallEventStatsdInterceptor;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallEventTrackerImpl implements CallEventTracker {
    public final List<CallEventTrackerInterceptor> a;

    @Inject
    public CallEventTrackerImpl(@NotNull CallEventClickstreamInterceptor callEventClickstreamInterceptor, @NotNull CallEventStatsdInterceptor callEventStatsdInterceptor) {
        Intrinsics.checkNotNullParameter(callEventClickstreamInterceptor, "clickstreamInterceptor");
        Intrinsics.checkNotNullParameter(callEventStatsdInterceptor, "statsdInterceptor");
        this.a = CollectionsKt__CollectionsKt.listOf((Object[]) new CallEventTrackerInterceptor[]{callEventClickstreamInterceptor, callEventStatsdInterceptor});
    }

    @Override // com.avito.android.calls_shared.tracker.events.CallEventTracker
    public void track(@NotNull CallEvent callEvent) {
        Intrinsics.checkNotNullParameter(callEvent, "event");
        Logs.debug$default(LogTagsKt.TAG_CALL_EVENT_TRACKER, "New call step: " + callEvent.getClass().getSimpleName() + ", callId=" + callEvent.getId(), null, 4, null);
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().process(callEvent);
        }
    }
}
