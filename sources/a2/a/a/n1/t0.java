package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.functions.BiFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class t0<T1, T2, R> implements BiFunction<LocationPickerState, Function1<? super LocationPickerState, ? extends LocationPickerState>, LocationPickerState> {
    public static final t0 a = new t0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.BiFunction
    public LocationPickerState apply(LocationPickerState locationPickerState, Function1<? super LocationPickerState, ? extends LocationPickerState> function1) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullExpressionValue(locationPickerState2, "state");
        return (LocationPickerState) function1.invoke(locationPickerState2);
    }
}
