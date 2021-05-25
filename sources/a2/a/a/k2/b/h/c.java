package a2.a.a.k2.b.h;

import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Float, Boolean> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Boolean apply(Float f) {
        return Boolean.valueOf(Intrinsics.areEqual(f, 1.0f));
    }
}
