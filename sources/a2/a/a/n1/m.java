package a2.a.a.n1;

import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import com.avito.android.remote.model.location_picker.AdvertsCountResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class m extends Lambda implements Function2<LocationPickerState, AdvertsCountResult, LocationPickerState> {
    public static final m a = new m();

    public m() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AdvertsCountResult advertsCountResult) {
        LocationPickerState locationPickerState2 = locationPickerState;
        AdvertsCountResult advertsCountResult2 = advertsCountResult;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (advertsCountResult2 instanceof AdvertsCountResult.Ok) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(locationPickerState2.getRadiusState(), null, null, false, false, null, 0, null, false, false, ((AdvertsCountResult.Ok) advertsCountResult2).getAdvertCount(), null, false, null, 5631, null), false, null, null, 3932159, null);
        }
        if (advertsCountResult2 instanceof AdvertsCountResult.NetworkError) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, null, false, false, false, false, false, true, 511, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        }
        if (advertsCountResult2 instanceof AdvertsCountResult.Error) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, null, false, false, false, false, true, false, 767, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
