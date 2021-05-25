package a2.a.a.h3.a;

import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class r0<T, R> implements Function<Boolean, Boolean> {
    public static final r0 a = new r0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Boolean apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        return Boolean.valueOf(!bool2.booleanValue());
    }
}
