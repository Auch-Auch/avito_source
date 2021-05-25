package a2.a.a.n1;

import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapPointKt;
import com.avito.android.location_picker.LocationPickerBinderImpl;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.entities.SearchRadiusViewState;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SearchParams;
import com.sumsub.sns.R2;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class t extends Lambda implements Function2<LocationPickerState, AvitoMapCameraPosition, LocationPickerState> {
    public final /* synthetic */ LocationPickerBinderImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(LocationPickerBinderImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public LocationPickerState invoke(LocationPickerState locationPickerState, AvitoMapCameraPosition avitoMapCameraPosition) {
        LocationPickerState locationPickerState2 = locationPickerState;
        AvitoMapCameraPosition avitoMapCameraPosition2 = avitoMapCameraPosition;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        Intrinsics.checkNotNullParameter(avitoMapCameraPosition2, "cameraPosition");
        SearchParams searchParams = null;
        if (!AvitoMapPointKt.almostEqual(avitoMapCameraPosition2.getMapPoint(), locationPickerState2.getLatLng())) {
            float zoomLevel = avitoMapCameraPosition2.getZoomLevel();
            AvitoMapPoint mapPoint = avitoMapCameraPosition2.getMapPoint();
            SearchRadiusViewState radiusState = locationPickerState2.getRadiusState();
            SearchParams searchParams2 = locationPickerState2.getRadiusState().getSearchParams();
            if (searchParams2 != null) {
                searchParams = SearchParams.copy$default(searchParams2, null, new Coordinates(avitoMapCameraPosition2.getMapPoint().getLatitude(), avitoMapCameraPosition2.getMapPoint().getLongitude()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388605, null);
            }
            LocationPickerState copy$default = LocationPickerState.copy$default(locationPickerState2, null, mapPoint, false, zoomLevel, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(radiusState, null, null, false, false, null, 0, null, false, false, 0, searchParams, true, null, R2.styleable.MockView_mock_label, null), false, null, null, 3907541, null);
            this.a.a.l.trackMapPositionChanged(copy$default);
            return copy$default;
        } else if (locationPickerState2.isInitialCoordinates()) {
            SearchRadiusViewState radiusState2 = locationPickerState2.getRadiusState();
            SearchParams searchParams3 = locationPickerState2.getRadiusState().getSearchParams();
            if (searchParams3 != null) {
                searchParams = SearchParams.copy$default(searchParams3, null, new Coordinates(avitoMapCameraPosition2.getMapPoint().getLatitude(), avitoMapCameraPosition2.getMapPoint().getLongitude()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388605, null);
            }
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(radiusState2, null, null, false, false, null, 0, null, false, false, 0, searchParams, true, null, R2.styleable.MockView_mock_label, null), false, null, null, 3907583, null);
        } else {
            float zoomLevel2 = avitoMapCameraPosition2.getZoomLevel();
            SearchRadiusViewState radiusState3 = locationPickerState2.getRadiusState();
            SearchParams searchParams4 = locationPickerState2.getRadiusState().getSearchParams();
            if (searchParams4 != null) {
                searchParams = SearchParams.copy$default(searchParams4, null, new Coordinates(avitoMapCameraPosition2.getMapPoint().getLatitude(), avitoMapCameraPosition2.getMapPoint().getLongitude()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388605, null);
            }
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, zoomLevel2, null, false, null, false, false, false, null, null, null, false, false, false, null, false, SearchRadiusViewState.copy$default(radiusState3, null, null, false, false, null, 0, null, false, false, 0, searchParams, true, null, R2.styleable.MockView_mock_label, null), false, null, null, 3907575, null);
        }
    }
}
