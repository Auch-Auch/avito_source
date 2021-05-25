package a7.a.b.a;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.MessengerClientImpl;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
public final class d<T, R> implements Function<Boolean, SingleSource<? extends Unit>> {
    public final /* synthetic */ MessengerClientImpl a;
    public final /* synthetic */ long b;

    public d(MessengerClientImpl messengerClientImpl, long j) {
        this.a = messengerClientImpl;
        this.b = j;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Unit> apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "isNetworkAvailable");
        if (bool2.booleanValue()) {
            return ((MessengerConnectionHolder) MessengerClientImpl.access$getConnectionHolder$p(this.a).get()).getStateObservable().ofType(MessengerConnectionHolder.State.Connected.class).firstOrError().map(a.a).timeout(this.b, TimeUnit.MILLISECONDS, MessengerClientImpl.access$getSchedulers$p(this.a).computation()).onErrorResumeNext(new c(this));
        }
        return Single.error(new IOException("Network is not available"));
    }
}
