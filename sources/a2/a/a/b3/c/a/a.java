package a2.a.a.b3.c.a;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Predicate<Boolean> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "it");
        return bool2.booleanValue();
    }
}
