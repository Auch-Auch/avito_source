package a2.a.a.j.a;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class p0<T> implements Predicate<Boolean> {
    public static final p0 a = new p0();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "it");
        return bool2.booleanValue();
    }
}
