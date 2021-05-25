package a2.a.a.n1;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.AddressValidationState;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.remote.model.location_picker.AddressCoordinatesByQueryResult;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class y extends Lambda implements Function2<LocationPickerState, AddressCoordinatesByQueryResult, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AddressCoordinatesByQueryResult addressCoordinatesByQueryResult) {
        LocationPickerState locationPickerState2 = locationPickerState;
        AddressCoordinatesByQueryResult addressCoordinatesByQueryResult2 = addressCoordinatesByQueryResult;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        if (addressCoordinatesByQueryResult2 instanceof AddressCoordinatesByQueryResult.Ok) {
            float zoom = LocationPickerBinderImpl.access$shouldSaveZoomLevel(this.a.a, locationPickerState2) ? locationPickerState2.getZoom() : 17.0f;
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            AddressCoordinatesByQueryResult.Ok ok = (AddressCoordinatesByQueryResult.Ok) addressCoordinatesByQueryResult2;
            AvitoMapPoint access$toAvitoMapPoint = LocationPickerBinderImpl.access$toAvitoMapPoint(this.a.a, ok.getCoords());
            String jsonWebToken = ok.getJsonWebToken();
            AddressValidationState copy$default = AddressValidationState.copy$default(locationPickerState2.getAddressValidationState(), null, false, true, "", 1, null);
            String formattedAddress = ok.getFormattedAddress();
            if (formattedAddress == null) {
                formattedAddress = "";
            }
            String formattedAddress2 = ok.getFormattedAddress();
            return LocationPickerState.copy$default(locationPickerState2, null, access$toAvitoMapPoint, false, zoom, formattedAddress, !(formattedAddress2 == null || formattedAddress2.length() == 0), "", false, false, false, null, emptyList, UtilsKt.emptyErrors(), false, false, false, null, false, null, false, jsonWebToken, copy$default, 1041797, null);
        } else if (addressCoordinatesByQueryResult2 instanceof AddressCoordinatesByQueryResult.NotFoundError) {
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, "", false, false, false, null, CollectionsKt__CollectionsKt.emptyList(), LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, ((AddressCoordinatesByQueryResult.NotFoundError) addressCoordinatesByQueryResult2).getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4187583, null);
        } else {
            if (addressCoordinatesByQueryResult2 instanceof AddressCoordinatesByQueryResult.NetworkError) {
                return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, CollectionsKt__CollectionsKt.emptyList(), LocationPickerErrors.copy$default(locationPickerState2.getErrors(), true, false, null, null, false, false, false, false, false, false, 1022, null), false, false, false, null, false, null, false, null, null, 4187647, null);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
