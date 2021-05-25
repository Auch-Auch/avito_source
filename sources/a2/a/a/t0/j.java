package a2.a.a.t0;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<List<? extends String>, Unit> {
    public static final j a = new j();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(List<? extends String> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return Unit.INSTANCE;
    }
}
