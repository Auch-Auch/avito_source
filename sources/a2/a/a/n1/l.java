package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.location_picker.AdvertsCountResult;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class l<T, R> implements Function<Unit, ObservableSource<? extends AdvertsCountResult>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ LocationPickerState b;

    public l(LocationPickerBinderImpl.a aVar, LocationPickerState locationPickerState) {
        this.a = aVar;
        this.b = locationPickerState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends AdvertsCountResult> apply(Unit unit) {
        SearchParams searchParams = this.b.getRadiusState().getSearchParams();
        if (searchParams == null) {
            searchParams = new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        }
        String radiusId = this.b.getRadiusState().getRadiusId();
        if (radiusId.length() > 0) {
            searchParams.setRadius(Integer.valueOf(Integer.parseInt(radiusId)));
        }
        return this.a.a.p.getAdvertsCount(SearchParamsConverter.DefaultImpls.convertToMap$default(this.a.a.r, searchParams, null, false, false, 14, null), String.valueOf(searchParams.getRadius()), searchParams.getGeoCoords()).subscribeOn(this.a.a.j.io()).toObservable();
    }
}
