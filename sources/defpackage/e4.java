package defpackage;

import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: e4  reason: default package */
public final class e4 extends Lambda implements Function2<LocationPickerState, Boolean, LocationPickerState> {
    public static final e4 b = new e4(0);
    public static final e4 c = new e4(1);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e4(int i) {
        super(2);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final LocationPickerState invoke(LocationPickerState locationPickerState, Boolean bool) {
        int i = this.a;
        if (i == 0) {
            LocationPickerState locationPickerState2 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, true, null, true, null, false, null, null, 4030463, null);
        } else if (i == 1) {
            LocationPickerState locationPickerState3 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState3, "state");
            return LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState3.getErrors(), false, false, null, null, true, false, false, false, false, false, 1007, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else {
            throw null;
        }
    }
}
