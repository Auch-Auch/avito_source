package a2.a.a.o1.b.b.a.c;

import com.avito.android.messenger.channels.mvi.common.v3.BaseEvent;
import com.avito.android.messenger.channels.mvi.common.v3.EventQueue;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class b implements Action {
    public final /* synthetic */ EventQueue.c a;
    public final /* synthetic */ BaseEvent b;

    public b(EventQueue.c cVar, BaseEvent baseEvent) {
        this.a = cVar;
        this.b = baseEvent;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        EventQueue eventQueue = this.a.a;
        BaseEvent baseEvent = this.b;
        Intrinsics.checkNotNullExpressionValue(baseEvent, "event");
        EventQueue.access$remove(eventQueue, baseEvent);
    }
}
