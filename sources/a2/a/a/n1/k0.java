package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.AddressValidationState;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class k0 extends Lambda implements Function2<LocationPickerState, AddressSuggestion, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AddressSuggestion addressSuggestion) {
        LocationPickerState locationPickerState2;
        LocationPickerState locationPickerState3 = locationPickerState;
        AddressSuggestion addressSuggestion2 = addressSuggestion;
        Intrinsics.checkNotNullParameter(locationPickerState3, "state");
        Intrinsics.checkNotNullParameter(addressSuggestion2, "suggestion");
        Coordinates coordinates = addressSuggestion2.getCoordinates();
        if (coordinates == null) {
            locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, addressSuggestion2.getAddressStringOneLine(), false, null, false, false, false, "", CollectionsKt__CollectionsKt.emptyList(), null, false, false, false, null, false, null, false, addressSuggestion2.getJsonWebToken(), AddressValidationState.copy$default(locationPickerState3.getAddressValidationState(), null, false, true, "", 1, null), 1045455, null);
        } else {
            locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, LocationPickerBinderImpl.access$toAvitoMapPoint(this.a.a, coordinates), false, LocationPickerBinderImpl.access$shouldSaveZoomLevel(this.a.a, locationPickerState3) ? locationPickerState3.getZoom() : 17.0f, addressSuggestion2.getAddressStringOneLine(), true, null, false, false, false, "", CollectionsKt__CollectionsKt.emptyList(), UtilsKt.emptyErrors(), false, false, false, null, false, null, false, addressSuggestion2.getJsonWebToken(), AddressValidationState.copy$default(locationPickerState3.getAddressValidationState(), null, false, true, "", 1, null), 1040837, null);
        }
        this.a.a.l.trackAddressSuggestionSelected(locationPickerState2);
        return locationPickerState2;
    }
}
