package a2.a.a.k2.a;

import com.avito.android.search.filter.ParametersTreeWithAdditional;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class d<T, R> implements Function<ParametersTreeWithAdditional, LoadingState.Loaded<ParametersTreeWithAdditional>> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState.Loaded<ParametersTreeWithAdditional> apply(ParametersTreeWithAdditional parametersTreeWithAdditional) {
        return new LoadingState.Loaded<>(parametersTreeWithAdditional);
    }
}
