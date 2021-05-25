package com.google.maps.android.data.geojson;

import a2.j.g.a.a.a.b;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;
public class GeoJsonPointStyle extends Style implements b {
    public static final String[] a = {"Point", "MultiPoint", "GeometryCollection"};

    public GeoJsonPointStyle() {
        this.mMarkerOptions = new MarkerOptions();
    }

    public float getAlpha() {
        return this.mMarkerOptions.getAlpha();
    }

    public float getAnchorU() {
        return this.mMarkerOptions.getAnchorU();
    }

    public float getAnchorV() {
        return this.mMarkerOptions.getAnchorV();
    }

    @Override // a2.j.g.a.a.a.b
    public String[] getGeometryType() {
        return a;
    }

    public BitmapDescriptor getIcon() {
        return this.mMarkerOptions.getIcon();
    }

    public float getInfoWindowAnchorU() {
        return this.mMarkerOptions.getInfoWindowAnchorU();
    }

    public float getInfoWindowAnchorV() {
        return this.mMarkerOptions.getInfoWindowAnchorV();
    }

    @Override // com.google.maps.android.data.Style
    public float getRotation() {
        return this.mMarkerOptions.getRotation();
    }

    public String getSnippet() {
        return this.mMarkerOptions.getSnippet();
    }

    public String getTitle() {
        return this.mMarkerOptions.getTitle();
    }

    public boolean isDraggable() {
        return this.mMarkerOptions.isDraggable();
    }

    public boolean isFlat() {
        return this.mMarkerOptions.isFlat();
    }

    public boolean isVisible() {
        return this.mMarkerOptions.isVisible();
    }

    public void setAlpha(float f) {
        this.mMarkerOptions.alpha(f);
        setChanged();
        notifyObservers();
    }

    public void setAnchor(float f, float f2) {
        setMarkerHotSpot(f, f2, "fraction", "fraction");
        setChanged();
        notifyObservers();
    }

    public void setDraggable(boolean z) {
        this.mMarkerOptions.draggable(z);
        setChanged();
        notifyObservers();
    }

    public void setFlat(boolean z) {
        this.mMarkerOptions.flat(z);
        setChanged();
        notifyObservers();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.mMarkerOptions.icon(bitmapDescriptor);
        setChanged();
        notifyObservers();
    }

    public void setInfoWindowAnchor(float f, float f2) {
        this.mMarkerOptions.infoWindowAnchor(f, f2);
        setChanged();
        notifyObservers();
    }

    public void setRotation(float f) {
        setMarkerRotation(f);
        setChanged();
        notifyObservers();
    }

    public void setSnippet(String str) {
        this.mMarkerOptions.snippet(str);
        setChanged();
        notifyObservers();
    }

    public void setTitle(String str) {
        this.mMarkerOptions.title(str);
        setChanged();
        notifyObservers();
    }

    public void setVisible(boolean z) {
        this.mMarkerOptions.visible(z);
        setChanged();
        notifyObservers();
    }

    public MarkerOptions toMarkerOptions() {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.alpha(this.mMarkerOptions.getAlpha());
        markerOptions.anchor(this.mMarkerOptions.getAnchorU(), this.mMarkerOptions.getAnchorV());
        markerOptions.draggable(this.mMarkerOptions.isDraggable());
        markerOptions.flat(this.mMarkerOptions.isFlat());
        markerOptions.icon(this.mMarkerOptions.getIcon());
        markerOptions.infoWindowAnchor(this.mMarkerOptions.getInfoWindowAnchorU(), this.mMarkerOptions.getInfoWindowAnchorV());
        markerOptions.rotation(this.mMarkerOptions.getRotation());
        markerOptions.snippet(this.mMarkerOptions.getSnippet());
        markerOptions.title(this.mMarkerOptions.getTitle());
        markerOptions.visible(this.mMarkerOptions.isVisible());
        return markerOptions;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PointStyle{\n geometry type=" + Arrays.toString(a) + ",\n alpha=" + getAlpha() + ",\n anchor U=" + getAnchorU() + ",\n anchor V=" + getAnchorV() + ",\n draggable=" + isDraggable() + ",\n flat=" + isFlat() + ",\n info window anchor U=" + getInfoWindowAnchorU() + ",\n info window anchor V=" + getInfoWindowAnchorV() + ",\n rotation=" + getRotation() + ",\n snippet=" + getSnippet() + ",\n title=" + getTitle() + ",\n visible=" + isVisible() + "\n}\n";
    }
}
