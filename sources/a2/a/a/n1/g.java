package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.AddressValidationResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class g<T, R> implements Function<Unit, ObservableSource<? extends AddressValidationResult>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ LocationPickerState b;

    public g(LocationPickerBinderImpl.a aVar, LocationPickerState locationPickerState) {
        this.a = aVar;
        this.b = locationPickerState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends AddressValidationResult> apply(Unit unit) {
        if (this.b.getJsonWebToken() == null || this.b.getAddressValidationState().getValidationRules() == null) {
            return Observable.empty();
        }
        return this.a.a.q.validateAddress(this.b.getJsonWebToken(), this.b.getAddressValidationState().getValidationRules()).subscribeOn(this.a.a.j.io()).toObservable();
    }
}
