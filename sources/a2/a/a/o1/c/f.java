package a2.a.a.o1.c;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Long, Boolean> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        return Boolean.FALSE;
    }
}
