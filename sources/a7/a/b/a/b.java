package a7.a.b.a;

import com.avito.android.communications_common.analytics.ErrorTracker;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerSocketCallAwaitingConnectionTimeoutException;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import t6.n.q;
public final class b<T, R> implements Function<MessengerConnectionHolder.State, SingleSource<? extends Unit>> {
    public final /* synthetic */ c a;
    public final /* synthetic */ Throwable b;

    public b(c cVar, Throwable th) {
        this.a = cVar;
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Unit> apply(MessengerConnectionHolder.State state) {
        Throwable th;
        MessengerConnectionHolder.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "state");
        Throwable th2 = null;
        MessengerConnectionHolder.State.Disconnected disconnected = (MessengerConnectionHolder.State.Disconnected) (!(state2 instanceof MessengerConnectionHolder.State.Disconnected) ? null : state2);
        TerminationEvent terminationEvent = disconnected != null ? disconnected.getTerminationEvent() : null;
        if (terminationEvent instanceof TerminationEvent.UnauthorizedError) {
            TerminationEvent.UnauthorizedError unauthorizedError = (TerminationEvent.UnauthorizedError) terminationEvent;
            th2 = new MessengerJsonRpcCallException(unauthorizedError.getCode().intValue(), null, unauthorizedError.getError(), null, null, null, 56, null);
        } else if (terminationEvent instanceof TerminationEvent.NetworkError) {
            th2 = ((TerminationEvent.NetworkError) terminationEvent).getError();
        } else if ((terminationEvent instanceof TerminationEvent.Unknown) && !(terminationEvent.getCode() == null && ((TerminationEvent.Unknown) terminationEvent).getError() == null)) {
            Integer code = terminationEvent.getCode();
            th2 = new MessengerJsonRpcCallException(code != null ? code.intValue() : -1, null, ((TerminationEvent.Unknown) terminationEvent).getError(), null, null, null, 56, null);
        }
        ErrorTracker errorTracker = this.a.a.a.f;
        if (th2 != null) {
            th = th2;
        } else {
            th = this.b;
            Intrinsics.checkNotNullExpressionValue(th, "error");
        }
        ErrorTracker.DefaultImpls.track$default(errorTracker, new MessengerSocketCallAwaitingConnectionTimeoutException(th), null, q.mapOf(TuplesKt.to("connectionHolderState", state2)), 2, null);
        if (th2 == null) {
            th2 = this.b;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
        }
        return Single.error(th2);
    }
}
