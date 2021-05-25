package com.google.maps.android.data.kml;

import a2.b.a.a.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.DataPolygon;
import java.util.ArrayList;
import java.util.List;
public class KmlPolygon implements DataPolygon<ArrayList<ArrayList<LatLng>>> {
    public static final String GEOMETRY_TYPE = "Polygon";
    public final List<LatLng> a;
    public final List<List<LatLng>> b;

    public KmlPolygon(List<LatLng> list, List<List<LatLng>> list2) {
        if (list != null) {
            this.a = list;
            this.b = list2;
            return;
        }
        throw new IllegalArgumentException("Outer boundary coordinates cannot be null");
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public List<List<LatLng>> getInnerBoundaryCoordinates() {
        return this.b;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public List<LatLng> getOuterBoundaryCoordinates() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE);
        sb.append("{");
        sb.append("\n outer coordinates=");
        sb.append(this.a);
        sb.append(",\n inner coordinates=");
        return a.w(sb, this.b, "\n}\n");
    }

    @Override // com.google.maps.android.data.Geometry
    public List<List<LatLng>> getGeometryObject() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        List<List<LatLng>> list = this.b;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }
}
