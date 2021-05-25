package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.model.AnimatedModelProvider;
import com.yandex.runtime.ui_view.ViewProvider;
import java.util.List;
public interface ClusterizedPlacemarkCollection extends MapObject {
    @NonNull
    PlacemarkMapObject addEmptyPlacemark(@NonNull Point point);

    @NonNull
    List<PlacemarkMapObject> addEmptyPlacemarks(@NonNull List<Point> list);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ImageProvider imageProvider);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ViewProvider viewProvider);

    @NonNull
    PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle);

    @NonNull
    List<PlacemarkMapObject> addPlacemarks(@NonNull List<Point> list, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    void clear();

    void clusterPlacemarks(double d, int i);
}
