package defpackage;

import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: f4  reason: default package */
public final class f4 extends Lambda implements Function2<LocationPickerState, Boolean, LocationPickerState> {
    public static final f4 b = new f4(0);
    public static final f4 c = new f4(1);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f4(int i) {
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
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            Intrinsics.checkNotNullExpressionValue(bool2, "locationEnabled");
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, bool2.booleanValue(), null, true, null, false, null, null, 4030463, null);
        } else if (i == 1) {
            LocationPickerState locationPickerState3 = locationPickerState;
            Boolean bool3 = bool;
            Intrinsics.checkNotNullParameter(locationPickerState3, "state");
            Intrinsics.checkNotNullExpressionValue(bool3, "isLocationEnabled");
            return LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, bool3.booleanValue(), null, false, null, false, null, null, 4145151, null);
        } else {
            throw null;
        }
    }
}
