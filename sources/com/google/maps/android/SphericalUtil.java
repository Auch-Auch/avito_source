package com.google.maps.android;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;
public class SphericalUtil {
    public static double a(LatLng latLng, LatLng latLng2) {
        return b(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    public static double b(double d, double d2, double d3, double d4) {
        return Math.asin(Math.sqrt(AppCompatDelegateImpl.i.O0(d, d3, d2 - d4))) * 2.0d;
    }

    public static double computeArea(List<LatLng> list) {
        return Math.abs(computeSignedArea(list));
    }

    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return a(latLng, latLng2) * 6371009.0d;
    }

    public static double computeHeading(LatLng latLng, LatLng latLng2) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude) - radians2;
        double cos = Math.cos(radians3) * Math.sin(radians4);
        double cos2 = Math.cos(radians);
        double sin = Math.sin(radians);
        return AppCompatDelegateImpl.i.l2(Math.toDegrees(Math.atan2(cos, (Math.sin(radians3) * cos2) - (Math.cos(radians4) * (Math.cos(radians3) * sin)))), -180.0d, 180.0d);
    }

    public static double computeLength(List<LatLng> list) {
        double d = 0.0d;
        if (list.size() < 2) {
            return 0.0d;
        }
        LatLng latLng = list.get(0);
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        for (LatLng latLng2 : list) {
            double radians3 = Math.toRadians(latLng2.latitude);
            double radians4 = Math.toRadians(latLng2.longitude);
            d += b(radians, radians2, radians3, radians4);
            radians = radians3;
            radians2 = radians4;
        }
        return d * 6371009.0d;
    }

    public static LatLng computeOffset(LatLng latLng, double d, double d2) {
        double d3 = d / 6371009.0d;
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(latLng.latitude);
        double radians3 = Math.toRadians(latLng.longitude);
        double cos = Math.cos(d3);
        double sin = Math.sin(d3);
        double sin2 = Math.sin(radians2);
        double cos2 = sin * Math.cos(radians2);
        double cos3 = (Math.cos(radians) * cos2) + (cos * sin2);
        return new LatLng(Math.toDegrees(Math.asin(cos3)), Math.toDegrees(radians3 + Math.atan2(Math.sin(radians) * cos2, cos - (sin2 * cos3))));
    }

    public static LatLng computeOffsetOrigin(LatLng latLng, double d, double d2) {
        double radians = Math.toRadians(d2);
        double d3 = d / 6371009.0d;
        double cos = Math.cos(d3);
        double cos2 = Math.cos(radians) * Math.sin(d3);
        double sin = Math.sin(radians) * Math.sin(d3);
        double sin2 = Math.sin(Math.toRadians(latLng.latitude));
        double d4 = cos * cos;
        double d5 = cos2 * cos2;
        double d6 = ((d4 * d4) + (d5 * d4)) - ((d4 * sin2) * sin2);
        if (d6 < 0.0d) {
            return null;
        }
        double d7 = cos2 * sin2;
        double d8 = d4 + d5;
        double sqrt = (Math.sqrt(d6) + d7) / d8;
        double d9 = (sin2 - (cos2 * sqrt)) / cos;
        double atan2 = Math.atan2(d9, sqrt);
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            atan2 = Math.atan2(d9, (d7 - Math.sqrt(d6)) / d8);
        }
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            return null;
        }
        return new LatLng(Math.toDegrees(atan2), Math.toDegrees(Math.toRadians(latLng.longitude) - Math.atan2(sin, (Math.cos(atan2) * cos) - (Math.sin(atan2) * cos2))));
    }

    public static double computeSignedArea(List<LatLng> list) {
        int size = list.size();
        double d = 0.0d;
        if (size < 3) {
            return 0.0d;
        }
        LatLng latLng = list.get(size - 1);
        double d2 = 1.5707963267948966d;
        double tan = Math.tan((1.5707963267948966d - Math.toRadians(latLng.latitude)) / 2.0d);
        double radians = Math.toRadians(latLng.longitude);
        for (LatLng latLng2 : list) {
            double tan2 = Math.tan((d2 - Math.toRadians(latLng2.latitude)) / 2.0d);
            double radians2 = Math.toRadians(latLng2.longitude);
            double d3 = radians2 - radians;
            double d4 = tan * tan2;
            d += Math.atan2(Math.sin(d3) * d4, (Math.cos(d3) * d4) + 1.0d) * 2.0d;
            tan = tan2;
            radians = radians2;
            d2 = 1.5707963267948966d;
        }
        return d * 4.0589755678081E13d;
    }

    public static LatLng interpolate(LatLng latLng, LatLng latLng2, double d) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double cos = Math.cos(radians);
        double cos2 = Math.cos(radians3);
        double a = a(latLng, latLng2);
        double sin = Math.sin(a);
        if (sin < 1.0E-6d) {
            return latLng;
        }
        double sin2 = Math.sin((1.0d - d) * a) / sin;
        double sin3 = Math.sin(a * d) / sin;
        double d2 = cos * sin2;
        double d3 = cos2 * sin3;
        double cos3 = (Math.cos(radians4) * d3) + (Math.cos(radians2) * d2);
        double a3 = a.a(radians4, d3, Math.sin(radians2) * d2);
        return new LatLng(Math.toDegrees(Math.atan2(a.a(radians3, sin3, Math.sin(radians) * sin2), Math.sqrt((a3 * a3) + (cos3 * cos3)))), Math.toDegrees(Math.atan2(a3, cos3)));
    }
}
