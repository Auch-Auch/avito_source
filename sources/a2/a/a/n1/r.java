package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class r extends Lambda implements Function1<LocationPickerState, LocationPickerState> {
    public final /* synthetic */ Throwable a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(Throwable th) {
        super(1);
        this.a = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public LocationPickerState invoke(LocationPickerState locationPickerState) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, this.a.getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
    }
}
