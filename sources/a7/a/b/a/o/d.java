package a7.a.b.a.o;

import a2.b.a.a.a;
import io.reactivex.functions.Consumer;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.state_machine.SequentialStateMachine;
public final class d<T> implements Consumer<S> {
    public final /* synthetic */ SequentialStateMachine.a a;

    public d(SequentialStateMachine.a aVar) {
        this.a = aVar;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(S s) {
        Logger.DefaultImpls.d$default(this.a.a.c, this.a.a.f, a.b3("New state: ", s), null, 4, null);
    }
}
