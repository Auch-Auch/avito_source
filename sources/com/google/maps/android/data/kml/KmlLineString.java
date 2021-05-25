package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.LineString;
import java.util.ArrayList;
import java.util.List;
public class KmlLineString extends LineString {
    public KmlLineString(ArrayList<LatLng> arrayList) {
        super(arrayList);
    }

    /* Return type fixed from 'java.util.ArrayList<com.google.android.gms.maps.model.LatLng>' to match base method */
    @Override // com.google.maps.android.data.LineString, com.google.maps.android.data.Geometry
    public List<LatLng> getGeometryObject() {
        return new ArrayList(super.getGeometryObject());
    }
}
