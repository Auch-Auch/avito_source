package a7.a.b.a.m;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.websocket.RxWebSocketState;
public final class c<T, R> implements Function<RxWebSocketState, Class<RxWebSocketState>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<ru.avito.websocket.RxWebSocketState> */
    @Override // io.reactivex.functions.Function
    public Class<RxWebSocketState> apply(RxWebSocketState rxWebSocketState) {
        RxWebSocketState rxWebSocketState2 = rxWebSocketState;
        Intrinsics.checkNotNullParameter(rxWebSocketState2, "wsState");
        return rxWebSocketState2.getClass();
    }
}
