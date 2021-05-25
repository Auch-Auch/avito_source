package a2.a.a.l1;

import com.avito.android.location.SavedLocation;
import com.avito.android.location.SavedLocationInteractorKt;
import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Location, SavedLocation> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SavedLocation apply(Location location) {
        Location location2 = location;
        Intrinsics.checkNotNullExpressionValue(location2, "it");
        return SavedLocationInteractorKt.access$toSavedLocation(location2, true);
    }
}
