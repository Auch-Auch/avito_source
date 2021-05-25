package a2.a.a.b2.e1;

import com.avito.android.profile.edit.LocationInteractor;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class n<T, R> implements Function<Unit, LocationInteractor.Event> {
    public static final n a = new n();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LocationInteractor.Event apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return new LocationInteractor.Event.Loaded();
    }
}
