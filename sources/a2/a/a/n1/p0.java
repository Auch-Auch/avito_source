package a2.a.a.n1;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class p0 extends Lambda implements Function2<LocationPickerState, AvitoMapBounds, LocationPickerState> {
    public static final p0 a = new p0();

    public p0() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AvitoMapBounds avitoMapBounds) {
        LocationPickerState locationPickerState2 = locationPickerState;
        AvitoMapBounds avitoMapBounds2 = avitoMapBounds;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullParameter(avitoMapBounds2, "bounds");
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(locationPickerState2.getRadiusState(), null, null, false, false, null, 0, avitoMapBounds2, locationPickerState2.getRadiusState().getDistanceInMeters() != 0 && !locationPickerState2.getCameraMoving(), false, 0, null, false, null, 7999, null), false, null, null, 3932159, null);
    }
}
