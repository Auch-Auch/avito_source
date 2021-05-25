package a2.a.a.m1;

import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationsResponse;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<LocationsResponse, List<? extends Location>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Location> apply(LocationsResponse locationsResponse) {
        LocationsResponse locationsResponse2 = locationsResponse;
        Intrinsics.checkNotNullParameter(locationsResponse2, "it");
        List<Location> locations = locationsResponse2.getLocations();
        Objects.requireNonNull(locations, "null cannot be cast to non-null type kotlin.collections.List<com.avito.android.remote.model.Location>");
        return locations;
    }
}
