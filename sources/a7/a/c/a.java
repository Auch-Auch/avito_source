package a7.a.c;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.websocket.RxWebSocketState;
public final class a<T> implements Predicate<RxWebSocketState> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(RxWebSocketState rxWebSocketState) {
        RxWebSocketState rxWebSocketState2 = rxWebSocketState;
        Intrinsics.checkNotNullParameter(rxWebSocketState2, "it");
        return !(rxWebSocketState2 instanceof RxWebSocketState.Connecting);
    }
}
