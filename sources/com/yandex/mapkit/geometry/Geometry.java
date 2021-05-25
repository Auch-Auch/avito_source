package com.yandex.mapkit.geometry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class Geometry {
    private BoundingBox boundingBox;
    private Circle circle;
    private MultiPolygon multiPolygon;
    private Point point;
    private Polygon polygon;
    private Polyline polyline;

    @NonNull
    public static Geometry fromBoundingBox(@NonNull BoundingBox boundingBox2) {
        if (boundingBox2 != null) {
            Geometry geometry = new Geometry();
            geometry.boundingBox = boundingBox2;
            return geometry;
        }
        throw new IllegalArgumentException("Variant value \"boundingBox\" cannot be null");
    }

    @NonNull
    public static Geometry fromCircle(@NonNull Circle circle2) {
        if (circle2 != null) {
            Geometry geometry = new Geometry();
            geometry.circle = circle2;
            return geometry;
        }
        throw new IllegalArgumentException("Variant value \"circle\" cannot be null");
    }

    @NonNull
    public static Geometry fromMultiPolygon(@NonNull MultiPolygon multiPolygon2) {
        if (multiPolygon2 != null) {
            Geometry geometry = new Geometry();
            geometry.multiPolygon = multiPolygon2;
            return geometry;
        }
        throw new IllegalArgumentException("Variant value \"multiPolygon\" cannot be null");
    }

    @NonNull
    public static Geometry fromPoint(@NonNull Point point2) {
        if (point2 != null) {
            Geometry geometry = new Geometry();
            geometry.point = point2;
            return geometry;
        }
        throw new IllegalArgumentException("Variant value \"point\" cannot be null");
    }

    @NonNull
    public static Geometry fromPolygon(@NonNull Polygon polygon2) {
        if (polygon2 != null) {
            Geometry geometry = new Geometry();
            geometry.polygon = polygon2;
            return geometry;
        }
        throw new IllegalArgumentException("Variant value \"polygon\" cannot be null");
    }

    @NonNull
    public static Geometry fromPolyline(@NonNull Polyline polyline2) {
        if (polyline2 != null) {
            Geometry geometry = new Geometry();
            geometry.polyline = polyline2;
            return geometry;
        }
        throw new IllegalArgumentException("Variant value \"polyline\" cannot be null");
    }

    @Nullable
    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    @Nullable
    public Circle getCircle() {
        return this.circle;
    }

    @Nullable
    public MultiPolygon getMultiPolygon() {
        return this.multiPolygon;
    }

    @Nullable
    public Point getPoint() {
        return this.point;
    }

    @Nullable
    public Polygon getPolygon() {
        return this.polygon;
    }

    @Nullable
    public Polyline getPolyline() {
        return this.polyline;
    }
}
