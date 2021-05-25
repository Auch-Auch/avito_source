package a7.a.b.a.o;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.internal.state_machine.SequentialStateMachine;
import ru.avito.messenger.internal.state_machine.StateMachine;
public final class b<T, R> implements Function<S, SingleSource<? extends S>> {
    public final /* synthetic */ SequentialStateMachine.a a;
    public final /* synthetic */ StateMachine.Mutator b;

    public b(SequentialStateMachine.a aVar, StateMachine.Mutator mutator) {
        this.a = aVar;
        this.b = mutator;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "state");
        return this.b.apply(obj).doOnSubscribe(new a(this, obj)).subscribeOn(SequentialStateMachine.access$getScheduler$p(this.a.a));
    }
}
