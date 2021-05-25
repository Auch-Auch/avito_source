package a2.a.a.n1.w0;

import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import io.reactivex.rxjava3.functions.Function;
public final class c<T, R> implements Function<Throwable, AddressByCoordinatesResult> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public AddressByCoordinatesResult apply(Throwable th) {
        return new AddressByCoordinatesResult.NetworkError();
    }
}
