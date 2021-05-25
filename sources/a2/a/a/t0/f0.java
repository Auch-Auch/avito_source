package a2.a.a.t0;

import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class f0<T> implements Predicate<List<? extends String>> {
    public static final f0 a = new f0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(List<? extends String> list) {
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        return !list2.isEmpty();
    }
}
