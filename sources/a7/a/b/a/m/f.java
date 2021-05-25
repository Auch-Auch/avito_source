package a7.a.b.a.m;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.state_machine.StateMachine;
import ru.avito.websocket.RxWebSocketState;
public final class f<T, R> implements Function<RxWebSocketState.Disconnected, StateMachine.Mutator<MessengerConnectionHolder.State>> {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public StateMachine.Mutator<MessengerConnectionHolder.State> apply(RxWebSocketState.Disconnected disconnected) {
        Intrinsics.checkNotNullParameter(disconnected, "it");
        g gVar = this.a;
        return new MessengerConnectionHolderImpl.PerformConnectMutator(gVar.a, gVar.b, true);
    }
}
