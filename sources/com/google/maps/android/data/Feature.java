package com.google.maps.android.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
public class Feature extends Observable {
    public final String a;
    public final Map<String, String> b;
    public Geometry c;

    public Feature(Geometry geometry, String str, Map<String, String> map) {
        this.c = geometry;
        this.a = str;
        if (map == null) {
            this.b = new HashMap();
        } else {
            this.b = map;
        }
    }

    public Geometry getGeometry() {
        return this.c;
    }

    public String getId() {
        return this.a;
    }

    public Iterable getProperties() {
        return this.b.entrySet();
    }

    public String getProperty(String str) {
        return this.b.get(str);
    }

    public Iterable<String> getPropertyKeys() {
        return this.b.keySet();
    }

    public boolean hasGeometry() {
        return this.c != null;
    }

    public boolean hasProperties() {
        return this.b.size() > 0;
    }

    public boolean hasProperty(String str) {
        return this.b.containsKey(str);
    }

    public String removeProperty(String str) {
        return this.b.remove(str);
    }

    public void setGeometry(Geometry geometry) {
        this.c = geometry;
    }

    public String setProperty(String str, String str2) {
        return this.b.put(str, str2);
    }
}
