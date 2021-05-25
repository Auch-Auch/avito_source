package a2.a.a.o1.b.b.a.a;

import io.reactivex.functions.Predicate;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Predicate<Pair<? extends StateT, ? extends StateT>> {
    public static final c a = new c();

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return pair.component2() != pair.component1();
    }
}
