package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SendLocationResponse;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class j0 extends Lambda implements Function2<LocationPickerState, SendLocationResponse, LocationPickerState> {
    public static final j0 a = new j0();

    public j0() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, SendLocationResponse sendLocationResponse) {
        LocationPickerState copy$default;
        LocationPickerState locationPickerState2 = locationPickerState;
        SendLocationResponse sendLocationResponse2 = sendLocationResponse;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (sendLocationResponse2 instanceof SendLocationResponse.Success) {
            copy$default = LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, true, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 4194175, null);
        } else if (sendLocationResponse2 instanceof SendLocationResponse.Error) {
            copy$default = LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((SendLocationResponse.Error) sendLocationResponse2).getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return LocationPickerState.copy$default(copy$default, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 3670015, null);
    }
}
