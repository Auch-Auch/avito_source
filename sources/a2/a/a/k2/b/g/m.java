package a2.a.a.k2.b.g;

import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.search.map.action.LoadAction;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class m<T, R> implements Function<LoadingState<? super InlineFilters>, LoadAction.LoadInlineFilters> {
    public static final m a = new m();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadAction.LoadInlineFilters apply(LoadingState<? super InlineFilters> loadingState) {
        LoadingState<? super InlineFilters> loadingState2 = loadingState;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        return new LoadAction.LoadInlineFilters(loadingState2);
    }
}
