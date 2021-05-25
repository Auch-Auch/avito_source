package a2.a.a.t2;

import com.jakewharton.rxbinding3.view.ViewLayoutChangeEvent;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<ViewLayoutChangeEvent, Unit> {
    public static final i a = new i();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Unit apply(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        Intrinsics.checkNotNullParameter(viewLayoutChangeEvent, "it");
        return Unit.INSTANCE;
    }
}
