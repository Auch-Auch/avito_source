package ru.avito.messenger;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "T", "Lru/avito/messenger/MessengerEventObserver;", "Lio/reactivex/Observable;", "observeChatEvents", "(Lru/avito/messenger/MessengerEventObserver;)Lio/reactivex/Observable;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessengerEventObserverKt {
    public static final /* synthetic */ <T> Observable<T> observeChatEvents(MessengerEventObserver messengerEventObserver) {
        Intrinsics.checkNotNullParameter(messengerEventObserver, "$this$observeChatEvents");
        Intrinsics.reifiedOperationMarker(4, "T");
        return messengerEventObserver.observeChatEvents(Object.class);
    }
}
