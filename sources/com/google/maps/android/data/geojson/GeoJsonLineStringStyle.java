package com.google.maps.android.data.geojson;

import a2.j.g.a.a.a.b;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;
public class GeoJsonLineStringStyle extends Style implements b {
    public static final String[] a = {"LineString", "MultiLineString", "GeometryCollection"};

    public GeoJsonLineStringStyle() {
        this.mPolylineOptions = new PolylineOptions();
    }

    public int getColor() {
        return this.mPolylineOptions.getColor();
    }

    @Override // a2.j.g.a.a.a.b
    public String[] getGeometryType() {
        return a;
    }

    public float getWidth() {
        return this.mPolylineOptions.getWidth();
    }

    public float getZIndex() {
        return this.mPolylineOptions.getZIndex();
    }

    public boolean isClickable() {
        return this.mPolylineOptions.isClickable();
    }

    public boolean isGeodesic() {
        return this.mPolylineOptions.isGeodesic();
    }

    public boolean isVisible() {
        return this.mPolylineOptions.isVisible();
    }

    public void setClickable(boolean z) {
        this.mPolylineOptions.clickable(z);
        setChanged();
        notifyObservers();
    }

    public void setColor(int i) {
        this.mPolylineOptions.color(i);
        setChanged();
        notifyObservers();
    }

    public void setGeodesic(boolean z) {
        this.mPolylineOptions.geodesic(z);
        setChanged();
        notifyObservers();
    }

    public void setVisible(boolean z) {
        this.mPolylineOptions.visible(z);
        setChanged();
        notifyObservers();
    }

    public void setWidth(float f) {
        setLineStringWidth(f);
        setChanged();
        notifyObservers();
    }

    public void setZIndex(float f) {
        this.mPolylineOptions.zIndex(f);
        setChanged();
        notifyObservers();
    }

    public PolylineOptions toPolylineOptions() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(this.mPolylineOptions.getColor());
        polylineOptions.clickable(this.mPolylineOptions.isClickable());
        polylineOptions.geodesic(this.mPolylineOptions.isGeodesic());
        polylineOptions.visible(this.mPolylineOptions.isVisible());
        polylineOptions.width(this.mPolylineOptions.getWidth());
        polylineOptions.zIndex(this.mPolylineOptions.getZIndex());
        return polylineOptions;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LineStringStyle{\n geometry type=" + Arrays.toString(a) + ",\n color=" + getColor() + ",\n clickable=" + isClickable() + ",\n geodesic=" + isGeodesic() + ",\n visible=" + isVisible() + ",\n width=" + getWidth() + ",\n z index=" + getZIndex() + "\n}\n";
    }
}
