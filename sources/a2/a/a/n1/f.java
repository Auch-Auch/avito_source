package a2.a.a.n1;

import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.AddressValidationState;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import com.avito.android.remote.model.location_picker.AddressByCoordinatesResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function2<LocationPickerState, AddressByCoordinatesResult, LocationPickerState> {
    public static final f a = new f();

    public f() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AddressByCoordinatesResult addressByCoordinatesResult) {
        LocationPickerState locationPickerState2 = locationPickerState;
        AddressByCoordinatesResult addressByCoordinatesResult2 = addressByCoordinatesResult;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (addressByCoordinatesResult2 instanceof AddressByCoordinatesResult.Ok) {
            AddressByCoordinatesResult.Ok ok = (AddressByCoordinatesResult.Ok) addressByCoordinatesResult2;
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, ok.getFormattedAddress(), true, null, false, false, false, null, null, UtilsKt.emptyErrors(), false, false, false, null, false, null, false, ok.getJsonWebToken(), AddressValidationState.copy$default(locationPickerState2.getAddressValidationState(), null, false, true, "", 3, null), 1044431, null);
        } else if (addressByCoordinatesResult2 instanceof AddressByCoordinatesResult.NotFoundAddress) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, ((AddressByCoordinatesResult.NotFoundAddress) addressByCoordinatesResult2).getMessage(), null, false, false, false, false, false, false, 1019, null), false, false, false, null, false, null, false, null, null, 3141631, null);
        } else {
            if (addressByCoordinatesResult2 instanceof AddressByCoordinatesResult.NetworkError) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, true, null, null, false, false, false, false, false, false, 1021, null), false, false, false, null, false, SearchRadiusViewState.copy$default(locationPickerState2.getRadiusState(), null, null, false, false, null, 0, null, false, false, -1, null, false, null, 7679, null), false, null, null, 2879487, null);
            }
            if (addressByCoordinatesResult2 instanceof AddressByCoordinatesResult.Error) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((AddressByCoordinatesResult.Error) addressByCoordinatesResult2).getErrorMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 3141631, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
