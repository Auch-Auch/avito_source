package a2.a.a.o1.b.b.a.d;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Throwable, StateT> {
    public final /* synthetic */ Object a;

    public b(Object obj) {
        this.a = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Object apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return this.a;
    }
}
