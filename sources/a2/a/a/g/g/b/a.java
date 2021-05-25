package a2.a.a.g.g.b;

import android.content.Context;
import com.avito.android.advert_core.map.MapLiteModeViewKt;
import com.avito.android.advert_core.map.yandex.YandexMapLiteModeViewImpl;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.yandex.AvitoYandexMap;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.lib.design.R;
import com.avito.android.remote.model.Color;
import com.avito.android.util.Contexts;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Runnable {
    public final /* synthetic */ YandexMapLiteModeViewImpl a;
    public final /* synthetic */ AvitoYandexMap b;

    public a(YandexMapLiteModeViewImpl yandexMapLiteModeViewImpl, AvitoYandexMap avitoYandexMap) {
        this.a = yandexMapLiteModeViewImpl;
        this.b = avitoYandexMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        AmenityMarkerIconFactory amenityMarkerIconFactory = this.a.f;
        if (amenityMarkerIconFactory != null) {
            for (AmenityPin amenityPin : this.a.c) {
                AvitoMapPoint avitoMapPoint = MapLiteModeViewKt.toAvitoMapPoint(amenityPin.getCoordinates());
                AvitoYandexMap avitoYandexMap = this.b;
                String type = amenityPin.getType();
                Color color = amenityPin.getColor();
                if (color != null) {
                    i = color.getValue();
                } else {
                    Context context = this.a.e.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "mapView.context");
                    i = Contexts.getColorByAttr(context, R.attr.white);
                }
                avitoYandexMap.addMarker(avitoMapPoint, amenityMarkerIconFactory.bitmap(type, i), AvitoMapMarker.Anchor.CENTER, Float.valueOf(0.0f), true);
            }
        }
    }
}
