package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import java.util.HashMap;
public class KmlPlacemark extends Feature {
    public final String d;
    public final KmlStyle e;

    public KmlPlacemark(Geometry geometry, String str, KmlStyle kmlStyle, HashMap<String, String> hashMap) {
        super(geometry, str, hashMap);
        this.d = str;
        this.e = kmlStyle;
    }

    public KmlStyle getInlineStyle() {
        return this.e;
    }

    public MarkerOptions getMarkerOptions() {
        return this.e.getMarkerOptions();
    }

    public PolygonOptions getPolygonOptions() {
        return this.e.getPolygonOptions();
    }

    public PolylineOptions getPolylineOptions() {
        return this.e.getPolylineOptions();
    }

    public String getStyleId() {
        return super.getId();
    }

    @Override // java.lang.Object
    public String toString() {
        return "Placemark{\n style id=" + this.d + ",\n inline style=" + this.e + "\n}\n";
    }
}
