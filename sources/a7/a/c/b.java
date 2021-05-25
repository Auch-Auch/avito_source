package a7.a.c;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.websocket.RxWebSocketState;
public final class b<T, R> implements Function<RxWebSocketState, SingleSource<? extends Unit>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Unit> apply(RxWebSocketState rxWebSocketState) {
        RxWebSocketState rxWebSocketState2 = rxWebSocketState;
        Intrinsics.checkNotNullParameter(rxWebSocketState2, "it");
        if (rxWebSocketState2 instanceof RxWebSocketState.Connected) {
            return Single.just(Unit.INSTANCE);
        }
        return Single.error(new IOException());
    }
}
