package a7.a.b.a.m;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.entity.messenger.TerminationEvent;
import ru.avito.messenger.internal.state_machine.StateMachine;
import ru.avito.websocket.RxWebSocketState;
public final class g<T, R> implements Function<MessengerConnectionHolder.State, ObservableSource<? extends StateMachine.Mutator<MessengerConnectionHolder.State>>> {
    public final /* synthetic */ MessengerConnectionHolderImpl a;
    public final /* synthetic */ String b;

    public g(MessengerConnectionHolderImpl messengerConnectionHolderImpl, String str) {
        this.a = messengerConnectionHolderImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends StateMachine.Mutator<MessengerConnectionHolder.State>> apply(MessengerConnectionHolder.State state) {
        MessengerConnectionHolder.State state2 = state;
        Intrinsics.checkNotNullParameter(state2, "state");
        if (!((state2 instanceof MessengerConnectionHolder.State.Disconnected) && state2.isAwaitingConnection() && !(((MessengerConnectionHolder.State.Disconnected) state2).getTerminationEvent() instanceof TerminationEvent.UnauthorizedError))) {
            return Observable.empty();
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Observable<RxWebSocketState> distinctUntilChanged = MessengerConnectionHolderImpl.access$getWebsocket$p(this.a).getStateObservable().observeOn(MessengerConnectionHolderImpl.access$getSchedulers$p(this.a).computation()).distinctUntilChanged(c.a);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "websocket.stateObservabl…te -> wsState.javaClass }");
        Observable<U> ofType = distinctUntilChanged.ofType(RxWebSocketState.Disconnected.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        return ofType.doOnNext(new d(atomicInteger)).debounce(new e(this, atomicInteger)).map(new f(this));
    }
}
