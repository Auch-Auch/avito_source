package a2.a.a.o1.b.b.a.d;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<StateT, Pair<? extends StateT, ? extends StateT>> {
    public final /* synthetic */ Object a;

    public c(Object obj) {
        this.a = obj;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "newState");
        return TuplesKt.to(this.a, obj);
    }
}
