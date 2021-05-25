package a2.a.a.n2;

import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.serp.SerpInlineFilters;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class f<T, R> implements Function<InlineFilters, LoadingState.Loaded<SerpInlineFilters>> {
    public static final f a = new f();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState.Loaded<SerpInlineFilters> apply(InlineFilters inlineFilters) {
        return new LoadingState.Loaded<>(new SerpInlineFilters(inlineFilters));
    }
}
