package a2.a.a.n1;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class n0<T, R> implements Function<AvitoMapBounds, ObservableSource<? extends AddressSuggestionResult>> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;
    public final /* synthetic */ LocationPickerState b;

    public n0(LocationPickerBinderImpl.a aVar, LocationPickerState locationPickerState) {
        this.a = aVar;
        this.b = locationPickerState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends AddressSuggestionResult> apply(AvitoMapBounds avitoMapBounds) {
        AvitoMapBounds avitoMapBounds2 = avitoMapBounds;
        AddressGeoCoder addressGeoCoder = this.a.a.h;
        String addressString = this.b.getAddressString();
        Intrinsics.checkNotNullExpressionValue(avitoMapBounds2, "visibleRegion");
        return addressGeoCoder.getSuggestions(addressString, avitoMapBounds2).subscribeOn(this.a.a.j.io()).toObservable();
    }
}
