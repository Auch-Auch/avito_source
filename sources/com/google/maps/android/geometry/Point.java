package com.google.maps.android.geometry;

import a2.b.a.a.a;
public class Point {
    public final double x;
    public final double y;

    public Point(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public String toString() {
        StringBuilder L = a.L("Point{x=");
        L.append(this.x);
        L.append(", y=");
        L.append(this.y);
        L.append('}');
        return L.toString();
    }
}
