package com.google.maps.android.data.geojson;

import a2.b.a.a.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.DataPolygon;
import com.google.maps.android.data.kml.KmlPolygon;
import java.util.ArrayList;
import java.util.List;
public class GeoJsonPolygon implements DataPolygon {
    public final List<? extends List<LatLng>> a;

    public GeoJsonPolygon(List<? extends List<LatLng>> list) {
        if (list != null) {
            this.a = list;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    public List<? extends List<LatLng>> getCoordinates() {
        return this.a;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return getType();
    }

    public String getType() {
        return KmlPolygon.GEOMETRY_TYPE;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(KmlPolygon.GEOMETRY_TYPE);
        sb.append("{");
        sb.append("\n coordinates=");
        return a.w(sb, this.a, "\n}\n");
    }

    @Override // com.google.maps.android.data.Geometry
    public List<? extends List<LatLng>> getGeometryObject() {
        return getCoordinates();
    }

    @Override // com.google.maps.android.data.DataPolygon
    public ArrayList<ArrayList<LatLng>> getInnerBoundaryCoordinates() {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList<>();
        for (int i = 1; i < getCoordinates().size(); i++) {
            arrayList.add((ArrayList) getCoordinates().get(i));
        }
        return arrayList;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public ArrayList<LatLng> getOuterBoundaryCoordinates() {
        return (ArrayList) getCoordinates().get(0);
    }
}
