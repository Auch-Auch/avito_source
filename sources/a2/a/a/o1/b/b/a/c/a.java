package a2.a.a.o1.b.b.a.c;

import com.avito.android.messenger.channels.mvi.common.v3.BaseEvent;
import com.avito.android.messenger.channels.mvi.common.v3.EventQueue;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Action {
    public final /* synthetic */ EventQueue.a a;
    public final /* synthetic */ BaseEvent b;

    public a(EventQueue.a aVar, BaseEvent baseEvent) {
        this.a = aVar;
        this.b = baseEvent;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        EventQueue eventQueue = this.a.a;
        BaseEvent baseEvent = this.b;
        Intrinsics.checkNotNullExpressionValue(baseEvent, "event");
        EventQueue.access$remove(eventQueue, baseEvent);
        Relay relay = this.a.b;
        BaseEvent baseEvent2 = this.b;
        Intrinsics.checkNotNullExpressionValue(baseEvent2, "event");
        relay.accept(baseEvent2);
    }
}
