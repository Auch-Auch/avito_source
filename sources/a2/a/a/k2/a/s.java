package a2.a.a.k2.a;

import com.avito.android.remote.model.Location;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.LocationInfo;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class s<T, R> implements Function<Location, ObservableSource<? extends LocationInfo>> {
    public final /* synthetic */ FiltersInteractorImpl a;

    public s(FiltersInteractorImpl filtersInteractorImpl) {
        this.a = filtersInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LocationInfo> apply(Location location) {
        Location location2 = location;
        FiltersInteractorImpl filtersInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(location2, "it");
        return FiltersInteractorImpl.access$toLocationInfo(filtersInteractorImpl, location2);
    }
}
