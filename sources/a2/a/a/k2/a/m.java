package a2.a.a.k2.a;

import com.avito.android.remote.model.Location;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.LocationInfo;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
public final class m<T, R> implements Function<Option<? extends Location>, ObservableSource<? extends LocationInfo>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public m(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LocationInfo> apply(Option<? extends Location> option) {
        Observable access$toLocationInfo;
        Location location = (Location) option.orNull();
        LocationInfo locationInfo = this.a.a;
        if (locationInfo != null) {
            if (Intrinsics.areEqual(locationInfo.getLocation().getId(), location != null ? location.getId() : null) && this.a.hasSearchArea()) {
                Observable just = Observable.just(locationInfo);
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            }
        }
        if (location != null && (access$toLocationInfo = FiltersInteractorImpl.access$toLocationInfo(this.a, location)) != null) {
            return access$toLocationInfo;
        }
        FiltersInteractorImpl filtersInteractorImpl = this.a;
        return FiltersInteractorImpl.access$toLocationInfo(filtersInteractorImpl, filtersInteractorImpl.d());
    }
}
