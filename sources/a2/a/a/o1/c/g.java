package a2.a.a.o1.c;

import a2.b.a.a.a;
import com.avito.android.messenger.connection.AvitoMessengerKeepConnectionProvider;
import com.avito.android.util.Logs;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<Triple<? extends Boolean, ? extends Boolean, ? extends Boolean>, ObservableSource<? extends Boolean>> {
    public final /* synthetic */ AvitoMessengerKeepConnectionProvider.a a;

    public g(AvitoMessengerKeepConnectionProvider.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Boolean> apply(Triple<? extends Boolean, ? extends Boolean, ? extends Boolean> triple) {
        Triple<? extends Boolean, ? extends Boolean, ? extends Boolean> triple2 = triple;
        Intrinsics.checkNotNullParameter(triple2, "<name for destructuring parameter 0>");
        Boolean bool = (Boolean) triple2.component1();
        Boolean bool2 = (Boolean) triple2.component2();
        Boolean bool3 = (Boolean) triple2.component3();
        Intrinsics.checkNotNullExpressionValue(bool2, "isForeground");
        if (!bool2.booleanValue()) {
            Intrinsics.checkNotNullExpressionValue(bool3, "hasUnprocessedRequests");
            if (!bool3.booleanValue()) {
                Intrinsics.checkNotNullExpressionValue(bool, "hasPendingMessages");
                long j = bool.booleanValue() ? 60 : 5;
                Logs.verbose$default("KeepConnectionProvider", a.V2("App is in background. Disconnect in ", j, " min"), null, 4, null);
                return Observable.timer(j, TimeUnit.MINUTES, this.a.a.e.computation()).doOnNext(e.a).map(f.a).startWith((Observable<R>) ((R) Boolean.valueOf(bool.booleanValue() || this.a.a.b.get())));
            }
        }
        Logs.verbose$default("KeepConnectionProvider", "App is in foreground or ChannelSyncOnPushAgent has unprocessed requests", null, 4, null);
        return Observable.just(Boolean.TRUE);
    }
}
