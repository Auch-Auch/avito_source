package a2.a.a.n3;

import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class n<T, R> implements Function<T, Pair<? extends T, ? extends Long>> {
    public final /* synthetic */ Long a;

    public n(Long l) {
        this.a = l;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        return TuplesKt.to(obj, this.a);
    }
}
