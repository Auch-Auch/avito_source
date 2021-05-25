package a2.a.a.k2.a;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.counter.ChangingParametersForButton;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<Map<String, ? extends String>, ObservableSource<? extends ChangingParametersForButton>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public f(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.remote.SearchApi */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends ChangingParametersForButton> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        SearchApi searchApi = this.a.n;
        Intrinsics.checkNotNullExpressionValue(map2, "it");
        return TypedObservablesKt.toTyped(searchApi.getCounterButton(map2));
    }
}
