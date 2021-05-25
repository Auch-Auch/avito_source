package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.remote.model.location_picker.AddressCoordinatesByQueryResult;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class x<T, R> implements Function<String, ObservableSource<? extends AddressCoordinatesByQueryResult>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    public x(LocationPickerBinderImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends AddressCoordinatesByQueryResult> apply(String str) {
        String str2 = str;
        AddressGeoCoder addressGeoCoder = this.a.a.h;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        return addressGeoCoder.getCoordinatesByAddress(str2).subscribeOn(this.a.a.j.io()).toObservable();
    }
}
