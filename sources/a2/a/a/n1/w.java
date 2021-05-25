package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class w<T, R> implements Function<Unit, SingleSource<? extends Boolean>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public w(LocationPickerBinderImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Boolean> apply(Unit unit) {
        this.a.a.m.trackResolveCoordinates(null, "PERMISSION DENIED");
        return this.a.a.k.isRequestRationale();
    }
}
