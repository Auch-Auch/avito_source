package a2.a.a.g.g.a;

import android.content.Context;
import com.avito.android.advert_core.map.MapLiteModeViewKt;
import com.avito.android.advert_core.map.google.GoogleMapLiteModeViewImpl;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.google.AvitoGoogleMap;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.lib.design.R;
import com.avito.android.remote.model.Color;
import com.avito.android.util.Contexts;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Runnable {
    public final /* synthetic */ GoogleMapLiteModeViewImpl a;
    public final /* synthetic */ AvitoGoogleMap b;

    public a(GoogleMapLiteModeViewImpl googleMapLiteModeViewImpl, AvitoGoogleMap avitoGoogleMap) {
        this.a = googleMapLiteModeViewImpl;
        this.b = avitoGoogleMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        AmenityMarkerIconFactory amenityMarkerIconFactory = this.a.f;
        if (amenityMarkerIconFactory != null) {
            for (AmenityPin amenityPin : this.a.c) {
                AvitoMapPoint avitoMapPoint = MapLiteModeViewKt.toAvitoMapPoint(amenityPin.getCoordinates());
                AvitoGoogleMap avitoGoogleMap = this.b;
                String type = amenityPin.getType();
                Color color = amenityPin.getColor();
                if (color != null) {
                    i = color.getValue();
                } else {
                    Context context = this.a.e.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "mapView.context");
                    i = Contexts.getColorByAttr(context, R.attr.white);
                }
                avitoGoogleMap.addMarker(avitoMapPoint, amenityMarkerIconFactory.bitmap(type, i), AvitoMapMarker.Anchor.CENTER, Float.valueOf(0.0f), true);
            }
        }
    }
}
