package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.remote.model.location_picker.CoordinatesVerificationResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class j extends Lambda implements Function2<LocationPickerState, CoordinatesVerificationResult, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, CoordinatesVerificationResult coordinatesVerificationResult) {
        LocationPickerState locationPickerState2;
        LocationPickerState locationPickerState3 = locationPickerState;
        CoordinatesVerificationResult coordinatesVerificationResult2 = coordinatesVerificationResult;
        Intrinsics.checkNotNullParameter(locationPickerState3, "state");
        if (coordinatesVerificationResult2 instanceof CoordinatesVerificationResult.Ok) {
            SendLocationToJobAssistant sendLocationToJobAssistant = this.a.a.v;
            if (sendLocationToJobAssistant instanceof SendLocationToJobAssistant.ShouldSend) {
                locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, null, true, null, null, 3670015, null);
            } else if (sendLocationToJobAssistant instanceof SendLocationToJobAssistant.Default) {
                locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, true, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 4194175, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (coordinatesVerificationResult2 instanceof CoordinatesVerificationResult.NetworkError) {
            locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState3.getErrors(), true, false, null, null, false, false, false, false, false, false, 1022, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else if (coordinatesVerificationResult2 instanceof CoordinatesVerificationResult.UnknownError) {
            locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState3.getErrors(), false, false, null, ((CoordinatesVerificationResult.UnknownError) coordinatesVerificationResult2).getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else if (coordinatesVerificationResult2 instanceof CoordinatesVerificationResult.Failure) {
            locationPickerState2 = LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState3.getErrors(), false, false, null, ((CoordinatesVerificationResult.Failure) coordinatesVerificationResult2).getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 4194047, null);
    }
}
