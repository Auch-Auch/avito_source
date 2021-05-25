package defpackage;

import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.AddressValidationState;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: g4  reason: default package */
public final class g4 extends Lambda implements Function2<LocationPickerState, Unit, LocationPickerState> {
    public static final g4 b = new g4(0);
    public static final g4 c = new g4(1);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g4(int i) {
        super(2);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final LocationPickerState invoke(LocationPickerState locationPickerState, Unit unit) {
        int i = this.a;
        if (i == 0) {
            LocationPickerState locationPickerState2 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, UtilsKt.emptyErrors(), true, false, false, null, false, null, false, null, AddressValidationState.copy$default(locationPickerState2.getAddressValidationState(), null, false, false, "", 5, null), 2051803, null);
        } else if (i == 1) {
            LocationPickerState locationPickerState3 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState3, "state");
            return LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, true, null, false, null, false, null, null, 4161535, null);
        } else {
            throw null;
        }
    }
}
