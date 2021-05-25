package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;
public class Point implements Geometry {
    public final LatLng a;

    public Point(LatLng latLng) {
        if (latLng != null) {
            this.a = latLng;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return "Point";
    }

    public String toString() {
        return "Point{\n coordinates=" + this.a + "\n}\n";
    }

    @Override // com.google.maps.android.data.Geometry
    public LatLng getGeometryObject() {
        return this.a;
    }
}
