package a2.a.a.k2.b.g;

import android.location.Location;
import com.avito.android.search.map.action.MapViewAction;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class n<T, R> implements Function<Location, MapViewAction.AddMyLocation> {
    public static final n a = new n();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MapViewAction.AddMyLocation apply(Location location) {
        Location location2 = location;
        Intrinsics.checkNotNullExpressionValue(location2, "it");
        return new MapViewAction.AddMyLocation(location2);
    }
}
