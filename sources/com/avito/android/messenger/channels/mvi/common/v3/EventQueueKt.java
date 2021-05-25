package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a,\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEvent;", "EventT", "Lcom/avito/android/messenger/channels/mvi/common/v3/EventQueue;", "event", "", "plusAssign", "(Lcom/avito/android/messenger/channels/mvi/common/v3/EventQueue;Lcom/avito/android/messenger/channels/mvi/common/v3/BaseEvent;)V", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class EventQueueKt {
    public static final <EventT extends BaseEvent> void plusAssign(@NotNull EventQueue<EventT> eventQueue, @NotNull EventT eventt) {
        Intrinsics.checkNotNullParameter(eventQueue, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(eventt, "event");
        eventQueue.add(eventt);
    }
}
