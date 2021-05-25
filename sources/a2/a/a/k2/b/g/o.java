package a2.a.a.k2.b.g;

import android.location.Location;
import com.avito.android.search.map.action.MapViewAction;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class o<T, R> implements Function<Location, MapViewAction.GoToLocation> {
    public static final o a = new o();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MapViewAction.GoToLocation apply(Location location) {
        Location location2 = location;
        Intrinsics.checkNotNullExpressionValue(location2, "it");
        return new MapViewAction.GoToLocation(location2);
    }
}
