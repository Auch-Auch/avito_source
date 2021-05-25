package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import com.avito.android.remote.model.location_picker.RadiusListResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a0 extends Lambda implements Function2<LocationPickerState, RadiusListResult, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, RadiusListResult radiusListResult) {
        LocationPickerState locationPickerState2 = locationPickerState;
        RadiusListResult radiusListResult2 = radiusListResult;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (radiusListResult2 instanceof RadiusListResult.Ok) {
            RadiusListResult.Ok ok = (RadiusListResult.Ok) radiusListResult2;
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(locationPickerState2.getRadiusState(), ok.getSelectedValue(), LocationPickerBinderImpl.access$setSelected(this.a.a, ok.getValues(), ok.getSelectedValue()), false, false, ok.getSelectedValue(), 0, null, false, false, 0, null, false, null, 7912, null), false, null, null, 3932159, null);
        } else if (radiusListResult2 instanceof RadiusListResult.NetworkError) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), true, false, null, null, false, false, false, false, false, false, 1022, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        } else {
            if (radiusListResult2 instanceof RadiusListResult.Error) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((RadiusListResult.Error) radiusListResult2).getErrorMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
