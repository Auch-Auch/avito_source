package a7.a.b.a.m;

import a2.b.a.a.a;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.ReconnectIntervalGenerator;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.websocket.RxWebSocketState;
public final class e<T, R> implements Function<RxWebSocketState.Disconnected, ObservableSource<Long>> {
    public final /* synthetic */ g a;
    public final /* synthetic */ AtomicInteger b;

    public e(g gVar, AtomicInteger atomicInteger) {
        this.a = gVar;
        this.b = atomicInteger;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<Long> apply(RxWebSocketState.Disconnected disconnected) {
        Intrinsics.checkNotNullParameter(disconnected, "it");
        int andIncrement = this.b.getAndIncrement();
        ReconnectIntervalGenerator reconnectIntervalGenerator = this.a.a.g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long intervalForAttempt = reconnectIntervalGenerator.getIntervalForAttempt(andIncrement, timeUnit);
        Logger logger = this.a.a.h;
        StringBuilder L = a.L("Reconnect after ");
        L.append(((double) intervalForAttempt) / 1000.0d);
        L.append(" seconds");
        Logger.DefaultImpls.v$default(logger, "ConnectionHolder", L.toString(), null, 4, null);
        return Observable.timer(intervalForAttempt, timeUnit, this.a.a.i.computation());
    }
}
