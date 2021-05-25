package com.google.maps.android.data;

import a2.b.a.a.a;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;
public class LineString implements Geometry<List<LatLng>> {
    public final List<LatLng> a;

    public LineString(List<LatLng> list) {
        if (list != null) {
            this.a = list;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return "LineString";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LineString");
        sb.append("{");
        sb.append("\n coordinates=");
        return a.w(sb, this.a, "\n}\n");
    }

    @Override // com.google.maps.android.data.Geometry
    public List<LatLng> getGeometryObject() {
        return this.a;
    }
}
