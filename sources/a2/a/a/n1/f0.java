package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f0 extends Lambda implements Function2<LocationPickerState, String, LocationPickerState> {
    public static final f0 a = new f0();

    public f0() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, String str) {
        LocationPickerState locationPickerState2 = locationPickerState;
        String str2 = str;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullExpressionValue(str2, "addressStringToSearchFor");
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, str2, false, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 4194239, null);
    }
}
