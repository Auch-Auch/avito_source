package com.avito.android.advert_core.map;

import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.model.Coordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/Coordinates;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "toAvitoMapPoint", "(Lcom/avito/android/remote/model/Coordinates;)Lcom/avito/android/avito_map/AvitoMapPoint;", "", "ZOOM_DELTA", "F", "ZINDEX_AMENITY", "DEFAULT_ZOOM", "", "ZOOM_PADDING", "I", "ZINDEX_DEFAULT", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class MapLiteModeViewKt {
    public static final float DEFAULT_ZOOM = 16.0f;
    public static final float ZINDEX_AMENITY = 0.0f;
    public static final float ZINDEX_DEFAULT = 1.0f;
    public static final float ZOOM_DELTA = 1.0f;
    public static final int ZOOM_PADDING = 0;

    @NotNull
    public static final AvitoMapPoint toAvitoMapPoint(@NotNull Coordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "$this$toAvitoMapPoint");
        return new AvitoMapPoint(coordinates.getLatitude(), coordinates.getLongitude());
    }
}
