package a2.a.a.o1.b.b.e;

import com.jakewharton.rxbinding3.recyclerview.RecyclerViewScrollEvent;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<RecyclerViewScrollEvent, Unit> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(RecyclerViewScrollEvent recyclerViewScrollEvent) {
        Intrinsics.checkNotNullParameter(recyclerViewScrollEvent, "it");
        return Unit.INSTANCE;
    }
}
