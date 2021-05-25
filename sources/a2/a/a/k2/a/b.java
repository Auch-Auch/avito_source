package a2.a.a.k2.a;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.LocationInfo;
import com.avito.android.search.filter.ParametersTreeWithAdditional;
import com.avito.android.search.filter.ParametersTreeWithAdditionalImpl;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<LocationInfo, ParametersTreeWithAdditional> {
    public final /* synthetic */ c a;
    public final /* synthetic */ ParametersTreeWithAdditionalImpl b;

    public b(c cVar, ParametersTreeWithAdditionalImpl parametersTreeWithAdditionalImpl) {
        this.a = cVar;
        this.b = parametersTreeWithAdditionalImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ParametersTreeWithAdditional apply(LocationInfo locationInfo) {
        LocationInfo locationInfo2 = locationInfo;
        FiltersInteractorImpl filtersInteractorImpl = this.a.a;
        ParametersTreeWithAdditionalImpl parametersTreeWithAdditionalImpl = this.b;
        Intrinsics.checkNotNullExpressionValue(parametersTreeWithAdditionalImpl, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intrinsics.checkNotNullExpressionValue(locationInfo2, "it");
        return FiltersInteractorImpl.access$wrapWithLocationInfo(filtersInteractorImpl, parametersTreeWithAdditionalImpl, locationInfo2);
    }
}
