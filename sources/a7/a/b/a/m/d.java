package a7.a.b.a.m;

import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import ru.avito.websocket.RxWebSocketState;
public final class d<T> implements Consumer<RxWebSocketState.Disconnected> {
    public final /* synthetic */ AtomicInteger a;

    public d(AtomicInteger atomicInteger) {
        this.a = atomicInteger;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(RxWebSocketState.Disconnected disconnected) {
        if (disconnected.getCode() == 3410) {
            this.a.set(0);
        }
    }
}
