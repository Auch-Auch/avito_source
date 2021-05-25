package com.avito.android.avito_map.amenity;

import com.avito.android.avito_map.AvitoMapMarker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"", "Lcom/avito/android/avito_map/AvitoMapMarker$Type;", "toPinType", "(Ljava/lang/String;)Lcom/avito/android/avito_map/AvitoMapMarker$Type;", "AMENITY_TYPE_SCHOOL", "Ljava/lang/String;", "AMENITY_TYPE_SHOPS", "AMENITY_TYPE_SPORT", "AMENITY_TYPE_KINDERGARTEN", "AMENITY_TYPE_HOSPITAL", "avito-map_release"}, k = 2, mv = {1, 4, 2})
public final class AmenityMarkerIconFactoryKt {
    @NotNull
    public static final String AMENITY_TYPE_HOSPITAL = "hospital";
    @NotNull
    public static final String AMENITY_TYPE_KINDERGARTEN = "kindergarten";
    @NotNull
    public static final String AMENITY_TYPE_SCHOOL = "school";
    @NotNull
    public static final String AMENITY_TYPE_SHOPS = "shops";
    @NotNull
    public static final String AMENITY_TYPE_SPORT = "sport";

    @NotNull
    public static final AvitoMapMarker.Type toPinType(@Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -907977868:
                    if (str.equals("school")) {
                        return AvitoMapMarker.Type.MARKER_AMENITY_SCHOOL;
                    }
                    break;
                case -303628742:
                    if (str.equals(AMENITY_TYPE_HOSPITAL)) {
                        return AvitoMapMarker.Type.MARKER_AMENITY_HOSPITAL;
                    }
                    break;
                case 109413437:
                    if (str.equals(AMENITY_TYPE_SHOPS)) {
                        return AvitoMapMarker.Type.MARKER_AMENITY_SHOPS;
                    }
                    break;
                case 109651828:
                    if (str.equals(AMENITY_TYPE_SPORT)) {
                        return AvitoMapMarker.Type.MARKER_AMENITY_SPORT;
                    }
                    break;
                case 1795432646:
                    if (str.equals(AMENITY_TYPE_KINDERGARTEN)) {
                        return AvitoMapMarker.Type.MARKER_AMENITY_KINDERGARTEN;
                    }
                    break;
            }
        }
        return AvitoMapMarker.Type.MARKER_PIN_DEFAULT;
    }
}
