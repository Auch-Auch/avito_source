package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h0 extends Lambda implements Function2<LocationPickerState, String, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, String str) {
        LocationPickerState locationPickerState2 = locationPickerState;
        String str2 = str;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullParameter(str2, "text");
        if (locationPickerState2.getSearchHasFocus()) {
            locationPickerState2 = LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, str2, false, null, false, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 4194255, null);
        }
        this.a.a.l.trackSearchQueryChanged(locationPickerState2);
        return locationPickerState2;
    }
}
