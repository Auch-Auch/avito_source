package a2.a.a.k2.a;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.ParametersTreeWithAdditional;
import com.avito.android.search.filter.ParametersTreeWithAdditionalImpl;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<ParametersTreeWithAdditionalImpl, ObservableSource<? extends ParametersTreeWithAdditional>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public c(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends ParametersTreeWithAdditional> apply(ParametersTreeWithAdditionalImpl parametersTreeWithAdditionalImpl) {
        ParametersTreeWithAdditionalImpl parametersTreeWithAdditionalImpl2 = parametersTreeWithAdditionalImpl;
        FiltersInteractorImpl filtersInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(parametersTreeWithAdditionalImpl2, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        return FiltersInteractorImpl.access$getLocationInfo(filtersInteractorImpl, parametersTreeWithAdditionalImpl2).map(new b(this, parametersTreeWithAdditionalImpl2));
    }
}
