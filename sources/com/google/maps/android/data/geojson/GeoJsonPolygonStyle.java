package com.google.maps.android.data.geojson;

import a2.j.g.a.a.a.b;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.data.Style;
import com.google.maps.android.data.kml.KmlPolygon;
import java.util.Arrays;
public class GeoJsonPolygonStyle extends Style implements b {
    public static final String[] a = {KmlPolygon.GEOMETRY_TYPE, "MultiPolygon", "GeometryCollection"};

    public GeoJsonPolygonStyle() {
        this.mPolygonOptions = new PolygonOptions();
    }

    public int getFillColor() {
        return this.mPolygonOptions.getFillColor();
    }

    @Override // a2.j.g.a.a.a.b
    public String[] getGeometryType() {
        return a;
    }

    public int getStrokeColor() {
        return this.mPolygonOptions.getStrokeColor();
    }

    public float getStrokeWidth() {
        return this.mPolygonOptions.getStrokeWidth();
    }

    public float getZIndex() {
        return this.mPolygonOptions.getZIndex();
    }

    public boolean isGeodesic() {
        return this.mPolygonOptions.isGeodesic();
    }

    public boolean isVisible() {
        return this.mPolygonOptions.isVisible();
    }

    public void setFillColor(int i) {
        setPolygonFillColor(i);
        setChanged();
        notifyObservers();
    }

    public void setGeodesic(boolean z) {
        this.mPolygonOptions.geodesic(z);
        setChanged();
        notifyObservers();
    }

    public void setStrokeColor(int i) {
        this.mPolygonOptions.strokeColor(i);
        setChanged();
        notifyObservers();
    }

    public void setStrokeWidth(float f) {
        setPolygonStrokeWidth(f);
        setChanged();
        notifyObservers();
    }

    public void setVisible(boolean z) {
        this.mPolygonOptions.visible(z);
        setChanged();
        notifyObservers();
    }

    public void setZIndex(float f) {
        this.mPolygonOptions.zIndex(f);
        setChanged();
        notifyObservers();
    }

    public PolygonOptions toPolygonOptions() {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.fillColor(this.mPolygonOptions.getFillColor());
        polygonOptions.geodesic(this.mPolygonOptions.isGeodesic());
        polygonOptions.strokeColor(this.mPolygonOptions.getStrokeColor());
        polygonOptions.strokeWidth(this.mPolygonOptions.getStrokeWidth());
        polygonOptions.visible(this.mPolygonOptions.isVisible());
        polygonOptions.zIndex(this.mPolygonOptions.getZIndex());
        return polygonOptions;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PolygonStyle{\n geometry type=" + Arrays.toString(a) + ",\n fill color=" + getFillColor() + ",\n geodesic=" + isGeodesic() + ",\n stroke color=" + getStrokeColor() + ",\n stroke width=" + getStrokeWidth() + ",\n visible=" + isVisible() + ",\n z index=" + getZIndex() + "\n}\n";
    }
}
