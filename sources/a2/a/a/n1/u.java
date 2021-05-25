package a2.a.a.n1;

import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
public final class u<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public u(LocationPickerBinderImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Boolean> apply(Boolean bool) {
        this.a.a.i.setActivity(this.a.a.x);
        return FusedLocationInteractor.DefaultImpls.isDeviceLocationEnabled$default(this.a.a.i, false, 1, null);
    }
}
