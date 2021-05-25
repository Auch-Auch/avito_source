package a2.a.a.k2.a;

import com.avito.android.remote.model.Direction;
import com.avito.android.remote.model.District;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.remote.model.metro_lines.MetroStation;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.LocationInfo;
import io.reactivex.rxjava3.functions.Function4;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class q<T1, T2, T3, T4, R> implements Function4<Location, MetroResponseBody, List<? extends District>, List<? extends Direction>, LocationInfo> {
    public final /* synthetic */ FiltersInteractorImpl a;
    public final /* synthetic */ Location b;

    public q(FiltersInteractorImpl filtersInteractorImpl, Location location) {
        this.a = filtersInteractorImpl;
        this.b = location;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function4
    public LocationInfo apply(Location location, MetroResponseBody metroResponseBody, List<? extends District> list, List<? extends Direction> list2) {
        Location location2 = location;
        MetroResponseBody metroResponseBody2 = metroResponseBody;
        List<? extends District> list3 = list;
        List<? extends Direction> list4 = list2;
        Intrinsics.checkNotNullParameter(location2, "topLocation");
        Intrinsics.checkNotNullParameter(metroResponseBody2, "metro");
        Intrinsics.checkNotNullParameter(list3, "districts");
        Intrinsics.checkNotNullParameter(list4, "directions");
        Location location3 = this.b;
        List<MetroStation> stations = metroResponseBody2.getStations();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(stations, 10));
        for (T t : stations) {
            arrayList.add(new Metro(String.valueOf(t.getId()), t.getName(), null));
        }
        return new LocationInfo(location3, location2, arrayList, metroResponseBody2, list3, list4, this.a.hasSearchArea());
    }
}
