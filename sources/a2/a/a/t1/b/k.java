package a2.a.a.t1.b;

import com.avito.android.payment.form.ScreenState;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<Unit, ScreenState.FullScreenLoading> {
    public static final k a = new k();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState.FullScreenLoading apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return new ScreenState.FullScreenLoading();
    }
}
