package a2.a.a.n1;

import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.remote.model.location_picker.AddressSuggestionResult;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class o0 extends Lambda implements Function2<LocationPickerState, AddressSuggestionResult, LocationPickerState> {
    public final /* synthetic */ LocationPickerState a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(LocationPickerState locationPickerState) {
        super(2);
        this.a = locationPickerState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AddressSuggestionResult addressSuggestionResult) {
        LocationPickerErrors locationPickerErrors;
        LocationPickerState locationPickerState2 = locationPickerState;
        AddressSuggestionResult addressSuggestionResult2 = addressSuggestionResult;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (!Intrinsics.areEqual(this.a.getAddressString(), locationPickerState2.getAddressString())) {
            return locationPickerState2;
        }
        if (addressSuggestionResult2 instanceof AddressSuggestionResult.Ok) {
            AddressSuggestionResult.Ok ok = (AddressSuggestionResult.Ok) addressSuggestionResult2;
            List<AddressSuggestion> addressSuggestions = ok.getAddressSuggestions();
            String addressString = this.a.getAddressString();
            if (!Intrinsics.areEqual(locationPickerState2.getSuggestionList(), ok.getAddressSuggestions())) {
                locationPickerErrors = UtilsKt.emptyErrors();
            } else {
                locationPickerErrors = locationPickerState2.getErrors();
            }
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, addressString, addressSuggestions, locationPickerErrors, false, false, false, null, false, null, false, null, null, 4187135, null);
        } else if (addressSuggestionResult2 instanceof AddressSuggestionResult.Error) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((AddressSuggestionResult.Error) addressSuggestionResult2).getErrorMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else {
            if (addressSuggestionResult2 instanceof AddressSuggestionResult.NetworkError) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), true, false, null, null, false, false, false, false, false, false, 1022, null), false, false, false, null, false, null, false, null, null, 4190207, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
