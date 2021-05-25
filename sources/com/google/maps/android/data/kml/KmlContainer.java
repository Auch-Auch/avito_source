package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.HashMap;
public class KmlContainer {
    public final HashMap<String, String> a;
    public final HashMap<KmlPlacemark, Object> b;
    public final ArrayList<KmlContainer> c;
    public final HashMap<KmlGroundOverlay, GroundOverlay> d;
    public final HashMap<String, String> e;
    public HashMap<String, KmlStyle> f;
    public String g;

    public KmlContainer(HashMap<String, String> hashMap, HashMap<String, KmlStyle> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, HashMap<String, String> hashMap4, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap5, String str) {
        this.a = hashMap;
        this.b = hashMap3;
        this.f = hashMap2;
        this.e = hashMap4;
        this.c = arrayList;
        this.d = hashMap5;
        this.g = str;
    }

    public String getContainerId() {
        return this.g;
    }

    public Iterable<KmlContainer> getContainers() {
        return this.c;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.d.keySet();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.b.keySet();
    }

    public Iterable<String> getProperties() {
        return this.a.keySet();
    }

    public String getProperty(String str) {
        return this.a.get(str);
    }

    public KmlStyle getStyle(String str) {
        return this.f.get(str);
    }

    public boolean hasContainers() {
        return this.c.size() > 0;
    }

    public boolean hasPlacemarks() {
        return this.b.size() > 0;
    }

    public boolean hasProperties() {
        return this.a.size() > 0;
    }

    public boolean hasProperty(String str) {
        return this.a.containsKey(str);
    }

    public String toString() {
        return "Container{\n properties=" + this.a + ",\n placemarks=" + this.b + ",\n containers=" + this.c + ",\n ground overlays=" + this.d + ",\n style maps=" + this.e + ",\n styles=" + this.f + "\n}\n";
    }
}
