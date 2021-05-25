package a7.a.c;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.websocket.RxWebSocketState;
public final class f<T> implements Predicate<RxWebSocketState> {
    public static final f a = new f();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(RxWebSocketState rxWebSocketState) {
        RxWebSocketState rxWebSocketState2 = rxWebSocketState;
        Intrinsics.checkNotNullParameter(rxWebSocketState2, "it");
        return !(rxWebSocketState2 instanceof RxWebSocketState.Connecting);
    }
}
