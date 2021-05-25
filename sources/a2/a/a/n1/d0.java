package a2.a.a.n1;

import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import com.avito.android.remote.model.SearchRadius;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d0 extends Lambda implements Function2<LocationPickerState, SearchRadius, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d0(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, SearchRadius searchRadius) {
        Long distanceInMeters;
        LocationPickerState locationPickerState2 = locationPickerState;
        SearchRadius searchRadius2 = searchRadius;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullParameter(searchRadius2, "item");
        SearchRadiusViewState radiusState = locationPickerState2.getRadiusState();
        String id = searchRadius2.getId();
        String str = "";
        String str2 = id != null ? id : str;
        LocationPickerBinderImpl locationPickerBinderImpl = this.a.a;
        List<SearchRadius> radiusList = locationPickerState2.getRadiusState().getRadiusList();
        String id2 = searchRadius2.getId();
        if (id2 != null) {
            str = id2;
        }
        List access$setSelected = LocationPickerBinderImpl.access$setSelected(locationPickerBinderImpl, radiusList, str);
        Long distanceInMeters2 = searchRadius2.getDistanceInMeters();
        return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(radiusState, str2, access$setSelected, false, false, null, distanceInMeters2 != null ? distanceInMeters2.longValue() : 0, null, Intrinsics.areEqual(searchRadius2.getId(), locationPickerState2.getRadiusState().getRadiusId()) && ((distanceInMeters = searchRadius2.getDistanceInMeters()) == null || distanceInMeters.longValue() != 0), false, 0, null, !Intrinsics.areEqual(searchRadius2.getId(), locationPickerState2.getRadiusState().getRadiusId()), null, 5980, null), false, null, null, 3932159, null);
    }
}
