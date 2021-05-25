package a2.a.a.n1;

import com.avito.android.location_picker.entities.AddressValidationState;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.AddressValidationResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function2<LocationPickerState, AddressValidationResult, LocationPickerState> {
    public static final h a = new h();

    public h() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AddressValidationResult addressValidationResult) {
        LocationPickerState locationPickerState2 = locationPickerState;
        AddressValidationResult addressValidationResult2 = addressValidationResult;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (addressValidationResult2 instanceof AddressValidationResult.Ok) {
            AddressValidationState addressValidationState = locationPickerState2.getAddressValidationState();
            AddressValidationResult.Ok ok = (AddressValidationResult.Ok) addressValidationResult2;
            boolean isValid = ok.isValid();
            String errorMessage = ok.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = "";
            }
            AddressValidationState copy$default = AddressValidationState.copy$default(addressValidationState, null, isValid, false, errorMessage, 1, null);
            String jsonWebToken = ok.getJsonWebToken();
            if (jsonWebToken == null) {
                jsonWebToken = locationPickerState2.getJsonWebToken();
            }
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, null, false, jsonWebToken, copy$default, 1048575, null);
        } else if (addressValidationResult2 instanceof AddressValidationResult.Error) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((AddressValidationResult.Error) addressValidationResult2).getErrorMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else {
            if (addressValidationResult2 instanceof AddressValidationResult.NetworkError) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), true, false, null, null, false, false, false, false, false, false, 1022, null), false, false, false, null, false, null, false, null, null, 4190207, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
