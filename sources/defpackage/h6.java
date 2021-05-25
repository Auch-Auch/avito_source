package defpackage;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.y.m;
/* compiled from: kotlin-style lambda group */
/* renamed from: h6  reason: default package */
public final class h6 extends Lambda implements Function2<LocationPickerState, Unit, LocationPickerState> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h6(int i, Object obj) {
        super(2);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final LocationPickerState invoke(LocationPickerState locationPickerState, Unit unit) {
        int i = this.a;
        if (i == 0) {
            LocationPickerState locationPickerState2 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            if (m.isBlank(locationPickerState2.getAddressString())) {
                LocationPickerState copy$default = LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, null, false, false, false, true, false, false, 895, null), false, false, false, null, false, null, false, null, null, 4189951, null);
                ((LocationPickerBinderImpl.a) this.b).a.l.trackTryToSaveEmptyAddress(copy$default);
                return copy$default;
            } else if (!locationPickerState2.getAddressStringFitsCoords() && (!locationPickerState2.getSuggestionList().isEmpty())) {
                LocationPickerState copy$default2 = LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, null, false, true, false, false, false, false, 991, null), false, false, false, null, false, null, false, null, null, 4189951, null);
                ((LocationPickerBinderImpl.a) this.b).a.l.trackTryToSaveNotSuggestedAddress(copy$default2);
                return copy$default2;
            } else if (locationPickerState2.getAddressStringFitsCoords() || !locationPickerState2.getSuggestionList().isEmpty()) {
                return locationPickerState2;
            } else {
                LocationPickerState copy$default3 = LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, null, false, false, true, false, false, false, 959, null), false, false, false, null, false, null, false, null, null, 4189951, null);
                ((LocationPickerBinderImpl.a) this.b).a.l.trackTryToSaveNotSuggestedAddress(copy$default3);
                return copy$default3;
            }
        } else if (i == 1) {
            LocationPickerState locationPickerState3 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState3, "state");
            return LocationPickerState.copy$default(locationPickerState3, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, ((LocationPickerBinderImpl.a) this.b).a.k.isPermissionGranted(), null, false, null, false, null, null, 4145151, null);
        } else {
            throw null;
        }
    }
}
