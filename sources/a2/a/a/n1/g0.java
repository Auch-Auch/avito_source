package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g0 extends Lambda implements Function2<LocationPickerState, Boolean, LocationPickerState> {
    public static final g0 a = new g0();

    public g0() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, Boolean bool) {
        LocationPickerState locationPickerState2 = locationPickerState;
        boolean booleanValue = bool.booleanValue();
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (booleanValue) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, true, null, null, null, false, false, false, null, false, null, false, null, null, 4161023, null);
        }
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, CollectionsKt__CollectionsKt.emptyList(), null, false, false, false, null, false, null, false, null, null, 4191743, null);
    }
}
