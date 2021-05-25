package a2.a.a.o1.c;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Throwable, Boolean> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Boolean.FALSE;
    }
}
