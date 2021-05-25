package a2.a.a.a1.c0;

import android.location.Location;
import com.avito.android.remote.model.Coordinates;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<Location, Coordinates> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Coordinates apply(Location location) {
        Location location2 = location;
        Intrinsics.checkNotNullExpressionValue(location2, "it");
        return new Coordinates(location2.getLatitude(), location2.getLongitude());
    }
}
