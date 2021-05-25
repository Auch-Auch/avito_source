package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class k extends Lambda implements Function2<LocationPickerState, Throwable, LocationPickerState> {
    public static final k a = new k();

    public k() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, Throwable th) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullParameter(th2, "error");
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, th2.getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4189951, null);
    }
}
