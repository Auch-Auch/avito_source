package a2.a.a.k2.b.g;

import com.avito.android.search.map.action.MapViewAction;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class p<T, R> implements Function<Boolean, MapViewAction> {
    public static final p a = new p();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MapViewAction apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        if (bool2.booleanValue()) {
            return MapViewAction.FindMeButtonClicked.INSTANCE;
        }
        return MapViewAction.CheckLocationRationale.INSTANCE;
    }
}
