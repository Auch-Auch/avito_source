package a2.a.a.n2;

import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.SerpParameters;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<SearchParams, SerpParameters> {
    public static final h a = new h();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SerpParameters apply(SearchParams searchParams) {
        SearchParams searchParams2 = searchParams;
        Intrinsics.checkNotNullExpressionValue(searchParams2, "it");
        return new SerpParameters(searchParams2, null);
    }
}
