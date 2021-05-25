package a2.a.a.k2.b.g;

import com.avito.android.search.map.action.MapViewAction;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class q<T, R> implements Function<Boolean, MapViewAction.LocationRationalResult> {
    public static final q a = new q();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MapViewAction.LocationRationalResult apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        return new MapViewAction.LocationRationalResult(bool2.booleanValue());
    }
}
