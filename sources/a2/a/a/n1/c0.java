package a2.a.a.n1;

import com.avito.android.location_picker.entities.ActivityResult;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c0 extends Lambda implements Function2<LocationPickerState, ActivityResult, LocationPickerState> {
    public static final c0 a = new c0();

    public c0() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, ActivityResult activityResult) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, true, null, false, null, false, null, null, 4030463, null);
    }
}
