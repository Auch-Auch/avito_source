package a2.a.a.k2.b.g;

import com.avito.android.search.map.PinAdverts;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<LoadingState<? super PinAdverts>, LoadAction.AppendPinAdverts> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadAction.AppendPinAdverts apply(LoadingState<? super PinAdverts> loadingState) {
        LoadingState<? super PinAdverts> loadingState2 = loadingState;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        return new LoadAction.AppendPinAdverts(loadingState2);
    }
}
