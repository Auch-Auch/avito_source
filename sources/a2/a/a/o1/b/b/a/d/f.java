package a2.a.a.o1.b.b.a.d;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Pair<? extends StateT, ? extends StateT>, Unit> {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.jakewharton.rxrelay2.Relay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public Unit apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        Object component2 = pair.component2();
        Function1 function1 = this.a.a.o;
        function1.invoke("New State: " + component2);
        this.a.a.c.accept(component2);
        return Unit.INSTANCE;
    }
}
