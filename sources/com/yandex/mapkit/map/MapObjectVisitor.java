package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
public interface MapObjectVisitor {
    void onCircleVisited(@NonNull CircleMapObject circleMapObject);

    void onCollectionVisitEnd(@NonNull MapObjectCollection mapObjectCollection);

    boolean onCollectionVisitStart(@NonNull MapObjectCollection mapObjectCollection);

    void onColoredPolylineVisited(@NonNull ColoredPolylineMapObject coloredPolylineMapObject);

    void onPlacemarkVisited(@NonNull PlacemarkMapObject placemarkMapObject);

    void onPolygonVisited(@NonNull PolygonMapObject polygonMapObject);

    void onPolylineVisited(@NonNull PolylineMapObject polylineMapObject);
}
