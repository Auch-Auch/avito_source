package a2.a.a.n3.z;

import io.reactivex.rxjava3.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class e<T, R> implements Function<T, Pair<? extends T, ? extends Long>> {
    public final /* synthetic */ Long a;

    public e(Long l) {
        this.a = l;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public Object apply(Object obj) {
        return TuplesKt.to(obj, this.a);
    }
}
