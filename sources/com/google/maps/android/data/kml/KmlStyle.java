package com.google.maps.android.data.kml;

import a2.b.a.a.a;
import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
public class KmlStyle extends Style {
    public final HashMap<String, String> a = new HashMap<>();
    public final HashSet<String> b = new HashSet<>();
    public boolean c = true;
    public boolean d = true;
    public String e;
    public double f = 1.0d;
    public String g = null;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public float k = 0.0f;

    public static String a(String str) {
        String str2;
        if (str.length() > 6) {
            str2 = str.substring(0, 2) + str.substring(6, 8) + str.substring(4, 6) + str.substring(2, 4);
        } else {
            str2 = str.substring(4, 6) + str.substring(2, 4) + str.substring(0, 2);
        }
        if (!str2.substring(0, 1).equals(" ")) {
            return str2;
        }
        StringBuilder L = a.L("0");
        L.append(str2.substring(1, str2.length()));
        return L.toString();
    }

    public static int computeRandomColor(int i2) {
        Random random = new Random();
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    public HashMap<String, String> getBalloonOptions() {
        return this.a;
    }

    public String getIconUrl() {
        return this.e;
    }

    public MarkerOptions getMarkerOptions() {
        MarkerOptions markerOptions = this.mMarkerOptions;
        boolean z = this.h;
        float f2 = this.k;
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.rotation(markerOptions.getRotation());
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        if (z) {
            float[] fArr = new float[3];
            Color.colorToHSV(computeRandomColor((int) f2), fArr);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(fArr[0]));
        }
        markerOptions2.icon(markerOptions.getIcon());
        return markerOptions2;
    }

    public PolygonOptions getPolygonOptions() {
        PolygonOptions polygonOptions = this.mPolygonOptions;
        boolean z = this.c;
        boolean z2 = this.d;
        PolygonOptions polygonOptions2 = new PolygonOptions();
        if (z) {
            polygonOptions2.fillColor(polygonOptions.getFillColor());
        }
        if (z2) {
            polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
            polygonOptions2.strokeWidth(polygonOptions.getStrokeWidth());
        }
        return polygonOptions2;
    }

    public PolylineOptions getPolylineOptions() {
        PolylineOptions polylineOptions = this.mPolylineOptions;
        PolylineOptions polylineOptions2 = new PolylineOptions();
        polylineOptions2.color(polylineOptions.getColor());
        polylineOptions2.width(polylineOptions.getWidth());
        return polylineOptions2;
    }

    public boolean hasBalloonStyle() {
        return this.a.size() > 0;
    }

    public boolean hasFill() {
        return this.c;
    }

    public boolean hasOutline() {
        return this.d;
    }

    public boolean isLineRandomColorMode() {
        return this.i;
    }

    public boolean isPolyRandomColorMode() {
        return this.j;
    }

    public boolean isStyleSet(String str) {
        return this.b.contains(str);
    }

    public void setFill(boolean z) {
        this.c = z;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("Style");
        sb.append("{");
        sb.append("\n balloon options=");
        sb.append(this.a);
        sb.append(",\n fill=");
        sb.append(this.c);
        sb.append(",\n outline=");
        sb.append(this.d);
        sb.append(",\n icon url=");
        sb.append(this.e);
        sb.append(",\n scale=");
        sb.append(this.f);
        sb.append(",\n style id=");
        return a.t(sb, this.g, "\n}\n");
    }
}
