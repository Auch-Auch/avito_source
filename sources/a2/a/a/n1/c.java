package a2.a.a.n1;

import a2.a.a.n1.d;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.CoordinatesCurrentResult;
import com.avito.android.remote.model.location_picker.CurrentCoordinates;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<LocationPickerState, LocationPickerState> {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ CoordinatesCurrentResult b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d.a aVar, CoordinatesCurrentResult coordinatesCurrentResult) {
        super(1);
        this.a = aVar;
        this.b = coordinatesCurrentResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public LocationPickerState invoke(LocationPickerState locationPickerState) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        CoordinatesCurrentResult coordinatesCurrentResult = this.b;
        if (coordinatesCurrentResult instanceof CoordinatesCurrentResult.Ok) {
            CurrentCoordinates currentCoordinates = ((CoordinatesCurrentResult.Ok) coordinatesCurrentResult).getCurrentCoordinates();
            return LocationPickerState.copy$default(locationPickerState2, null, LocationPickerBinderImpl.access$toAvitoMapPoint(this.a.a.a.a, currentCoordinates.getCoordinates()), true, 11.0f, "", false, null, false, false, false, null, null, UtilsKt.emptyErrors(), false, false, false, null, false, null, false, null, null, 4157377, null);
        } else if (coordinatesCurrentResult instanceof CoordinatesCurrentResult.NetWorkError) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), true, false, null, null, false, false, false, false, false, false, 1022, null), false, false, false, null, false, null, false, null, null, 4157439, null);
        } else {
            if (coordinatesCurrentResult instanceof CoordinatesCurrentResult.UnknownError) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((CoordinatesCurrentResult.UnknownError) this.b).getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4157439, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
