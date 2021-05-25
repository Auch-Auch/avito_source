package a7.a.b.a;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.MessengerClientImpl;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
public final class c<T, R> implements Function<Throwable, SingleSource<? extends Unit>> {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Unit> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        return ((MessengerConnectionHolder) MessengerClientImpl.access$getConnectionHolder$p(this.a.a).get()).getStateObservable().firstOrError().flatMap(new b(this, th2));
    }
}
