package a7.a.b.a.m;

import io.reactivex.functions.Consumer;
import ru.avito.messenger.internal.connection.MessengerConnectionHolder;
import ru.avito.messenger.internal.connection.MessengerConnectionHolderImpl;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.state_machine.StateMachine;
public final class h<T> implements Consumer<StateMachine.Mutator<MessengerConnectionHolder.State>> {
    public final /* synthetic */ MessengerConnectionHolderImpl a;

    public h(MessengerConnectionHolderImpl messengerConnectionHolderImpl) {
        this.a = messengerConnectionHolderImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(StateMachine.Mutator<MessengerConnectionHolder.State> mutator) {
        Logger.DefaultImpls.v$default(this.a.h, "ConnectionHolder", "Reconnect triggered", null, 4, null);
    }
}
