package a7.a.b.a.o;

import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
public final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<S, Unit> {
    public c(Relay relay) {
        super(1, relay, Relay.class, "accept", "accept(Ljava/lang/Object;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Object obj) {
        ((Relay) this.receiver).accept(obj);
        return Unit.INSTANCE;
    }
}
