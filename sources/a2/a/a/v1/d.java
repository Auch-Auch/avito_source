package a2.a.a.v1;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Predicate<Long> {
    public static final d a = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Long l) {
        Long l2 = l;
        Intrinsics.checkNotNullParameter(l2, "it");
        return l2.longValue() < 0;
    }
}
