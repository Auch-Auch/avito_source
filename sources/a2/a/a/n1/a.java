package a2.a.a.n1;

import a2.a.a.n1.b;
import android.location.Location;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.entities.LocationPickerState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<LocationPickerState, LocationPickerState> {
    public final /* synthetic */ b.a a;
    public final /* synthetic */ Location b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b.a aVar, Location location) {
        super(1);
        this.a = aVar;
        this.b = location;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public LocationPickerState invoke(LocationPickerState locationPickerState) {
        LocationPickerState locationPickerState2 = locationPickerState;
        Intrinsics.checkNotNullParameter(locationPickerState2, "state");
        AvitoMapPoint avitoMapPoint = new AvitoMapPoint(this.b.getLatitude(), this.b.getLongitude());
        LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.a.a.a.m, this.b, null, 2, null);
        if (this.a.a.b.getShouldRequestAddressByGPSCoords()) {
            LocationPickerState copy$default = LocationPickerState.copy$default(locationPickerState2, null, avitoMapPoint, false, locationPickerState2.getZoom() > 11.0f ? locationPickerState2.getZoom() : 17.0f, null, false, null, false, false, false, null, null, UtilsKt.emptyErrors(), false, false, false, null, false, null, false, null, null, 4157393, null);
            this.a.a.a.a.l.trackDevicePositionUsed(copy$default);
            return copy$default;
        }
        LocationPickerState copy$default2 = LocationPickerState.copy$default(locationPickerState2, null, avitoMapPoint, true, 11.0f, null, false, null, false, false, false, null, null, UtilsKt.emptyErrors(), false, false, false, null, false, null, false, null, null, 4157393, null);
        this.a.a.a.a.l.trackDevicePositionUsed(copy$default2);
        return copy$default2;
    }
}
