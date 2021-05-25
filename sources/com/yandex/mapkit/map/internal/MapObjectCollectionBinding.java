package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.geometry.Polygon;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.map.CircleMapObject;
import com.yandex.mapkit.map.ClusterListener;
import com.yandex.mapkit.map.ClusterizedPlacemarkCollection;
import com.yandex.mapkit.map.ColoredPolylineMapObject;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectCollectionListener;
import com.yandex.mapkit.map.MapObjectVisitor;
import com.yandex.mapkit.map.ModelStyle;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.map.PlacemarksStyler;
import com.yandex.mapkit.map.PolygonMapObject;
import com.yandex.mapkit.map.PolylineMapObject;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.model.AnimatedModelProvider;
import com.yandex.runtime.subscription.Subscription;
import com.yandex.runtime.ui_view.ViewProvider;
import java.util.List;
public class MapObjectCollectionBinding extends MapObjectBinding implements MapObjectCollection {
    private Subscription<ClusterListener> clusterListenerSubscription = new Subscription<ClusterListener>() { // from class: com.yandex.mapkit.map.internal.MapObjectCollectionBinding.1
        public NativeObject createNativeListener(ClusterListener clusterListener) {
            return MapObjectCollectionBinding.createClusterListener(clusterListener);
        }
    };
    private Subscription<MapObjectCollectionListener> mapObjectCollectionListenerSubscription = new Subscription<MapObjectCollectionListener>() { // from class: com.yandex.mapkit.map.internal.MapObjectCollectionBinding.2
        public NativeObject createNativeListener(MapObjectCollectionListener mapObjectCollectionListener) {
            return MapObjectCollectionBinding.createMapObjectCollectionListener(mapObjectCollectionListener);
        }
    };
    private Subscription<MapObjectVisitor> mapObjectVisitorSubscription = new Subscription<MapObjectVisitor>() { // from class: com.yandex.mapkit.map.internal.MapObjectCollectionBinding.3
        public NativeObject createNativeListener(MapObjectVisitor mapObjectVisitor) {
            return MapObjectCollectionBinding.createMapObjectVisitor(mapObjectVisitor);
        }
    };

    public MapObjectCollectionBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    /* access modifiers changed from: private */
    public static native NativeObject createClusterListener(ClusterListener clusterListener);

    /* access modifiers changed from: private */
    public static native NativeObject createMapObjectCollectionListener(MapObjectCollectionListener mapObjectCollectionListener);

    /* access modifiers changed from: private */
    public static native NativeObject createMapObjectVisitor(MapObjectVisitor mapObjectVisitor);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native CircleMapObject addCircle(@NonNull Circle circle, int i, float f, int i2);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native ClusterizedPlacemarkCollection addClusterizedPlacemarkCollection(@NonNull ClusterListener clusterListener);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native MapObjectCollection addCollection();

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native ColoredPolylineMapObject addColoredPolyline();

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native ColoredPolylineMapObject addColoredPolyline(@NonNull Polyline polyline);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addEmptyPlacemark(@NonNull Point point);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native List<PlacemarkMapObject> addEmptyPlacemarks(@NonNull List<Point> list);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    public native void addListener(@NonNull MapObjectCollectionListener mapObjectCollectionListener);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ImageProvider imageProvider);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ViewProvider viewProvider);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarkMapObject addPlacemark(@NonNull Point point, @NonNull ViewProvider viewProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native List<PlacemarkMapObject> addPlacemarks(@NonNull List<Point> list, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PolygonMapObject addPolygon(@NonNull Polygon polygon);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PolylineMapObject addPolyline(@NonNull Polyline polyline);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    public native void clear();

    @Override // com.yandex.mapkit.map.MapObjectCollection
    @NonNull
    public native PlacemarksStyler placemarksStyler();

    @Override // com.yandex.mapkit.map.MapObjectCollection
    public native void remove(@NonNull MapObject mapObject);

    @Override // com.yandex.mapkit.map.MapObjectCollection
    public native void traverse(@NonNull MapObjectVisitor mapObjectVisitor);
}
