package a2.a.a.n2;

import com.avito.android.serp.SerpInlineFilters;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class g<T, R> implements Function<Throwable, LoadingState.Loaded<SerpInlineFilters>> {
    public static final g a = new g();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState.Loaded<SerpInlineFilters> apply(Throwable th) {
        return new LoadingState.Loaded<>(new SerpInlineFilters(null));
    }
}
