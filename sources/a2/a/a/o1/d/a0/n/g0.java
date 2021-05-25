package a2.a.a.o1.d.a0.n;

import io.reactivex.functions.Function;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class g0<T, R> implements Function<Pair<? extends String, ? extends Set<? extends String>>, Set<? extends String>> {
    public static final g0 a = new g0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Set<? extends String> apply(Pair<? extends String, ? extends Set<? extends String>> pair) {
        Pair<? extends String, ? extends Set<? extends String>> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
        return (Set) pair2.component2();
    }
}
