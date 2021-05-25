package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.geometry.Polygon;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.model.AnimatedModelProvider;
import com.yandex.runtime.ui_view.ViewProvider;
import java.util.List;
public interface MapObjectCollection extends MapObject {
    @NonNull
    CircleMapObject addCircle(@NonNull Circle circle, int i, float f, int i2);

    @NonNull
    ClusterizedPlacemarkCollection addClusterizedPlacemarkCollection(@NonNull ClusterListener clusterListener);

    @NonNull
    MapObjectCollection addCollection();

    @NonNull
    ColoredPolylineMapObject addColoredPolyline();

    @NonNull
    ColoredPolylineMapObject addColoredPolyline(@NonNull Polyline polyline);

    @NonNull
    PlacemarkMapObject addEmptyPlacemark(@NonNull Point point);

    @NonNull
    List<PlacemarkMapObject> addEmptyPlacemarks(@NonNull List<Point> list);

    void addListener(@NonNull MapObjectCollectionListener mapObjectCollectionListener);

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

    @NonNull
    PolygonMapObject addPolygon(@NonNull Polygon polygon);

    @NonNull
    PolylineMapObject addPolyline(@NonNull Polyline polyline);

    void clear();

    @NonNull
    PlacemarksStyler placemarksStyler();

    void remove(@NonNull MapObject mapObject);

    void traverse(@NonNull MapObjectVisitor mapObjectVisitor);
}
