package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.functions.Function1;
public final class s<T, R> implements Function<Throwable, Function1<? super LocationPickerState, ? extends LocationPickerState>> {
    public static final s a = new s();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Function1<? super LocationPickerState, ? extends LocationPickerState> apply(Throwable th) {
        return new r(th);
    }
}
