package com.google.maps.android.data;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Observable;
public abstract class Style extends Observable {
    public MarkerOptions mMarkerOptions = new MarkerOptions();
    public PolygonOptions mPolygonOptions = new PolygonOptions();
    public PolylineOptions mPolylineOptions = new PolylineOptions();

    public float getRotation() {
        return this.mMarkerOptions.getRotation();
    }

    public void setLineStringWidth(float f) {
        this.mPolylineOptions.width(f);
    }

    public void setMarkerHotSpot(float f, float f2, String str, String str2) {
        if (!str.equals("fraction")) {
            f = 0.5f;
        }
        if (!str2.equals("fraction")) {
            f2 = 1.0f;
        }
        this.mMarkerOptions.anchor(f, f2);
    }

    public void setMarkerRotation(float f) {
        this.mMarkerOptions.rotation(f);
    }

    public void setPolygonFillColor(int i) {
        this.mPolygonOptions.fillColor(i);
    }

    public void setPolygonStrokeWidth(float f) {
        this.mPolygonOptions.strokeWidth(f);
    }
}
