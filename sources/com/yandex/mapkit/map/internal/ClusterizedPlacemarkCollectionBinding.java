package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.ModelStyle;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.model.AnimatedModelProvider;
import com.yandex.runtime.ui_view.ViewProvider;
import java.util.List;
public class ClusterizedPlacemarkCollectionBinding extends MapObjectBinding implements ClusterizedPlacemarkCollection {
    public ClusterizedPlacemarkCollectionBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addEmptyPlacemark(@NonNull Point point);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native List<PlacemarkMapObject> addEmptyPlacemarks(@NonNull List<Point> list);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ImageProvider imageProvider);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ViewProvider viewProvider);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    @NonNull
    public native List<PlacemarkMapObject> addPlacemarks(@NonNull List<Point> list, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    public native void clear();

    @Override // com.yandex.mapkit.map.ClusterizedPlacemarkCollection
    public native void clusterPlacemarks(double d, int i);
}
