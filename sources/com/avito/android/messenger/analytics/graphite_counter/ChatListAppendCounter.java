package com.avito.android.messenger.analytics.graphite_counter;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/analytics/graphite_counter/ChatListAppendCounter;", "Lcom/avito/android/messenger/analytics/graphite_counter/MessengerGraphiteCounter;", "", "trackError", "()V", "trackSuccess", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatListAppendCounter implements MessengerGraphiteCounter {
    public final /* synthetic */ MessengerGraphiteCounterImpl a;

    @Inject
    public ChatListAppendCounter(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = new MessengerGraphiteCounterImpl("chat-list-next", analytics);
    }

    @Override // com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter
    public void trackError() {
        this.a.trackError();
    }

    @Override // com.avito.android.messenger.analytics.graphite_counter.MessengerGraphiteCounter
    public void trackSuccess() {
        this.a.trackSuccess();
    }
}
