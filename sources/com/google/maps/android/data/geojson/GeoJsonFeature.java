package com.google.maps.android.data.geojson;

import a2.j.g.a.a.a.b;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
public class GeoJsonFeature extends Feature implements Observer {
    public final String d;
    public final LatLngBounds e;
    public GeoJsonPointStyle f;
    public GeoJsonLineStringStyle g;
    public GeoJsonPolygonStyle h;

    public GeoJsonFeature(Geometry geometry, String str, HashMap<String, String> hashMap, LatLngBounds latLngBounds) {
        super(geometry, str, hashMap);
        this.d = str;
        this.e = latLngBounds;
    }

    public final void a(b bVar) {
        if (hasGeometry() && Arrays.asList(bVar.getGeometryType()).contains(getGeometry().getGeometryType())) {
            setChanged();
            notifyObservers();
        }
    }

    public LatLngBounds getBoundingBox() {
        return this.e;
    }

    public GeoJsonLineStringStyle getLineStringStyle() {
        return this.g;
    }

    public MarkerOptions getMarkerOptions() {
        return this.f.toMarkerOptions();
    }

    public GeoJsonPointStyle getPointStyle() {
        return this.f;
    }

    public PolygonOptions getPolygonOptions() {
        return this.h.toPolygonOptions();
    }

    public GeoJsonPolygonStyle getPolygonStyle() {
        return this.h;
    }

    public PolylineOptions getPolylineOptions() {
        return this.g.toPolylineOptions();
    }

    @Override // com.google.maps.android.data.Feature
    public String removeProperty(String str) {
        return super.removeProperty(str);
    }

    @Override // com.google.maps.android.data.Feature
    public void setGeometry(Geometry geometry) {
        super.setGeometry(geometry);
        setChanged();
        notifyObservers();
    }

    public void setLineStringStyle(GeoJsonLineStringStyle geoJsonLineStringStyle) {
        if (geoJsonLineStringStyle != null) {
            GeoJsonLineStringStyle geoJsonLineStringStyle2 = this.g;
            if (geoJsonLineStringStyle2 != null) {
                geoJsonLineStringStyle2.deleteObserver(this);
            }
            this.g = geoJsonLineStringStyle;
            geoJsonLineStringStyle.addObserver(this);
            a(this.g);
            return;
        }
        throw new IllegalArgumentException("Line string style cannot be null");
    }

    public void setPointStyle(GeoJsonPointStyle geoJsonPointStyle) {
        if (geoJsonPointStyle != null) {
            GeoJsonPointStyle geoJsonPointStyle2 = this.f;
            if (geoJsonPointStyle2 != null) {
                geoJsonPointStyle2.deleteObserver(this);
            }
            this.f = geoJsonPointStyle;
            geoJsonPointStyle.addObserver(this);
            a(this.f);
            return;
        }
        throw new IllegalArgumentException("Point style cannot be null");
    }

    public void setPolygonStyle(GeoJsonPolygonStyle geoJsonPolygonStyle) {
        if (geoJsonPolygonStyle != null) {
            GeoJsonPolygonStyle geoJsonPolygonStyle2 = this.h;
            if (geoJsonPolygonStyle2 != null) {
                geoJsonPolygonStyle2.deleteObserver(this);
            }
            this.h = geoJsonPolygonStyle;
            geoJsonPolygonStyle.addObserver(this);
            a(this.h);
            return;
        }
        throw new IllegalArgumentException("Polygon style cannot be null");
    }

    @Override // com.google.maps.android.data.Feature
    public String setProperty(String str, String str2) {
        return super.setProperty(str, str2);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Feature{\n bounding box=" + this.e + ",\n geometry=" + getGeometry() + ",\n point style=" + this.f + ",\n line string style=" + this.g + ",\n polygon style=" + this.h + ",\n id=" + this.d + ",\n properties=" + getProperties() + "\n}\n";
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable instanceof b) {
            a((b) observable);
        }
    }
}
