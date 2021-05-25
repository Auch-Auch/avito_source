package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.CoordinatesVerificationResult;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class i<T, R> implements Function<Unit, ObservableSource<? extends CoordinatesVerificationResult>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ LocationPickerState b;

    public i(LocationPickerBinderImpl.a aVar, LocationPickerState locationPickerState) {
        this.a = aVar;
        this.b = locationPickerState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends CoordinatesVerificationResult> apply(Unit unit) {
        return this.a.a.h.verifyCoordinates(this.b.getLatLng(), this.b.getItemId()).subscribeOn(this.a.a.j.io()).toObservable();
    }
}
