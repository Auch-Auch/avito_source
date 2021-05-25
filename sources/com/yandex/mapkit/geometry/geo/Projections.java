package com.yandex.mapkit.geometry.geo;

import com.yandex.mapkit.geometry.Point;
import com.yandex.runtime.NativeObject;
public class Projections {

    public static class ProjectionBinding implements Projection {
        private final NativeObject nativeObject;

        private ProjectionBinding(NativeObject nativeObject2) {
            this.nativeObject = nativeObject2;
        }

        @Override // com.yandex.mapkit.geometry.geo.Projection
        public native XYPoint worldToXY(Point point, int i);

        @Override // com.yandex.mapkit.geometry.geo.Projection
        public native Point xyToWorld(XYPoint xYPoint, int i);
    }

    public static native Projection createSphericalMercator();

    public static native Projection createWgs84Mercator();
}
