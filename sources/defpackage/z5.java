package defpackage;

import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: z5  reason: default package */
public final class z5 extends Lambda implements Function2<LocationPickerState, Unit, LocationPickerState> {
    public static final z5 b = new z5(0);
    public static final z5 c = new z5(1);
    public static final z5 d = new z5(2);
    public static final z5 e = new z5(3);
    public static final z5 f = new z5(4);
    public static final z5 g = new z5(5);
    public static final z5 h = new z5(6);
    public static final z5 i = new z5(7);
    public static final z5 j = new z5(8);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z5(int i2) {
        super(2);
        this.a = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final LocationPickerState invoke(LocationPickerState locationPickerState, Unit unit) {
        switch (this.a) {
            case 0:
                LocationPickerState locationPickerState2 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState2, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, CollectionsKt__CollectionsKt.emptyList(), null, false, false, false, null, false, null, false, null, null, 4191743, null);
            case 1:
                LocationPickerState locationPickerState3 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState3, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(locationPickerState3.getRadiusState(), null, null, false, false, null, 0, null, false, false, 0, null, false, null, 8063, null), false, null, null, 3932159, null);
            case 2:
                LocationPickerState locationPickerState4 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState4, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState4, null, null, false, 0.0f, null, false, null, false, true, false, null, null, null, false, false, false, null, false, null, false, null, null, 4194047, null);
            case 3:
                LocationPickerState locationPickerState5 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState5, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState5, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState5.getErrors(), false, false, null, null, false, false, false, false, false, false, 895, null), false, false, false, null, false, null, false, null, null, 4190207, null);
            case 4:
                LocationPickerState locationPickerState6 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState6, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState6, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, null, false, null, null, 4193791, null);
            case 5:
                LocationPickerState locationPickerState7 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState7, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState7, null, null, false, 0.0f, null, false, null, false, false, false, null, null, UtilsKt.emptyErrors(), false, false, false, null, false, null, false, null, null, 4190207, null);
            case 6:
                LocationPickerState locationPickerState8 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState8, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState8, null, null, false, 0.0f, "", false, null, false, false, true, "", CollectionsKt__CollectionsKt.emptyList(), LocationPickerErrors.copy$default(locationPickerState8.getErrors(), false, false, null, null, false, false, false, false, false, false, 927, null), false, false, false, null, false, null, false, null, null, 4186575, null);
            case 7:
                LocationPickerState locationPickerState9 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState9, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState9, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(locationPickerState9.getRadiusState(), null, null, false, true, null, 0, null, false, false, 0, null, false, null, 8183, null), false, null, null, 3932159, null);
            case 8:
                LocationPickerState locationPickerState10 = locationPickerState;
                Intrinsics.checkNotNullParameter(locationPickerState10, "state");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                return LocationPickerState.copy$default(locationPickerState10, null, null, false, 0.0f, null, false, null, false, false, false, null, null, UtilsKt.emptyErrors(), false, true, false, null, false, null, false, null, null, 4173823, null);
            default:
                throw null;
        }
    }
}
