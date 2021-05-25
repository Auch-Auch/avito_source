package a2.a.a.z.a.g;

import a2.b.a.a.a;
import com.avito.android.calls.voximplant.rx.core.CallClientException;
import com.avito.android.calls.voximplant.rx.core.ConnectionState;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
public final class g<T, R> implements Function<ConnectionState, CompletableSource> {
    public final /* synthetic */ Throwable a;

    public g(Throwable th) {
        this.a = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(ConnectionState connectionState) {
        StringBuilder L = a.L("Connection: state=[");
        L.append(connectionState.getClass().getSimpleName());
        L.append("] error=[");
        L.append(this.a.getMessage());
        L.append(']');
        Logs.error(LogTagsKt.TAG_IAC, L.toString(), this.a);
        return Completable.error(new CallClientException.ConnectionException.CannotDisconnectException(true, this.a));
    }
}
