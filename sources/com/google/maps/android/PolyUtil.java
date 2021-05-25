package com.google.maps.android;

import a2.b.a.a.a;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class PolyUtil {
    public static void a(long j, StringBuffer stringBuffer) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        long j2 = j << 1;
        if (i < 0) {
            j2 = ~j2;
        }
        while (j2 >= 32) {
            stringBuffer.append(Character.toChars((int) ((32 | (31 & j2)) + 63)));
            j2 >>= 5;
        }
        stringBuffer.append(Character.toChars((int) (j2 + 63)));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x01c9: APUT  (r11v1 double[]), (0 ??[int, short, byte, char]), (r14v6 double) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0156, code lost:
        if ((((r11 + r13) - (((r13 * r22) + (r11 * r24)) * 2.0d)) * 2.0d) > 0.0d) goto L_0x0158;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x015f A[LOOP:0: B:10:0x0049->B:34:0x015f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x022d A[LOOP:2: B:43:0x01dc->B:55:0x022d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x022b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(com.google.android.gms.maps.model.LatLng r44, java.util.List<com.google.android.gms.maps.model.LatLng> r45, boolean r46, boolean r47, double r48) {
        /*
        // Method dump skipped, instructions count: 576
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.PolyUtil.b(com.google.android.gms.maps.model.LatLng, java.util.List, boolean, boolean, double):boolean");
    }

    public static boolean containsLocation(LatLng latLng, List<LatLng> list, boolean z) {
        return containsLocation(latLng.latitude, latLng.longitude, list, z);
    }

    public static List<LatLng> decode(String str) {
        int i;
        int i2;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = 1;
            int i7 = 0;
            while (true) {
                i = i3 + 1;
                int charAt = (str.charAt(i3) - '?') - 1;
                i6 += charAt << i7;
                i7 += 5;
                if (charAt < 31) {
                    break;
                }
                i3 = i;
            }
            int i8 = ((i6 & 1) != 0 ? ~(i6 >> 1) : i6 >> 1) + i4;
            int i9 = 1;
            int i10 = 0;
            while (true) {
                i2 = i + 1;
                int charAt2 = (str.charAt(i) - '?') - 1;
                i9 += charAt2 << i10;
                i10 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i = i2;
            }
            int i11 = i9 & 1;
            int i12 = i9 >> 1;
            if (i11 != 0) {
                i12 = ~i12;
            }
            i5 += i12;
            arrayList.add(new LatLng(((double) i8) * 1.0E-5d, ((double) i5) * 1.0E-5d));
            i4 = i8;
            i3 = i2;
        }
        return arrayList;
    }

    public static double distanceToLine(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng2.equals(latLng3)) {
            return SphericalUtil.computeDistanceBetween(latLng3, latLng);
        }
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double radians5 = Math.toRadians(latLng3.latitude) - radians3;
        double radians6 = Math.toRadians(latLng3.longitude) - radians4;
        double d = (((radians2 - radians4) * radians6) + ((radians - radians3) * radians5)) / ((radians6 * radians6) + (radians5 * radians5));
        if (d <= 0.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng2);
        }
        if (d >= 1.0d) {
            return SphericalUtil.computeDistanceBetween(latLng, latLng3);
        }
        return SphericalUtil.computeDistanceBetween(new LatLng(latLng.latitude - latLng2.latitude, latLng.longitude - latLng2.longitude), new LatLng((latLng3.latitude - latLng2.latitude) * d, (latLng3.longitude - latLng2.longitude) * d));
    }

    public static String encode(List<LatLng> list) {
        StringBuffer stringBuffer = new StringBuffer();
        long j = 0;
        long j2 = 0;
        for (LatLng latLng : list) {
            long round = Math.round(latLng.latitude * 100000.0d);
            long round2 = Math.round(latLng.longitude * 100000.0d);
            a(round - j, stringBuffer);
            a(round2 - j2, stringBuffer);
            j = round;
            j2 = round2;
        }
        return stringBuffer.toString();
    }

    public static boolean isClosedPolygon(List<LatLng> list) {
        return list.get(0).equals((LatLng) a.j2(list, 1));
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z, double d) {
        return b(latLng, list, true, z, d);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z, double d) {
        return b(latLng, list, false, z, d);
    }

    public static List<LatLng> simplify(List<LatLng> list, double d) {
        int size = list.size();
        if (size >= 1) {
            double d2 = 0.0d;
            if (d > 0.0d) {
                boolean isClosedPolygon = isClosedPolygon(list);
                LatLng latLng = null;
                if (isClosedPolygon) {
                    latLng = (LatLng) a.j2(list, 1);
                    list.remove(list.size() - 1);
                    list.add(new LatLng(latLng.latitude + 1.0E-11d, latLng.longitude + 1.0E-11d));
                }
                Stack stack = new Stack();
                double[] dArr = new double[size];
                int i = 0;
                dArr[0] = 1.0d;
                int i2 = size - 1;
                dArr[i2] = 1.0d;
                if (size > 2) {
                    stack.push(new int[]{0, i2});
                    int i3 = 0;
                    while (stack.size() > 0) {
                        int[] iArr = (int[]) stack.pop();
                        for (int i4 = iArr[0] + 1; i4 < iArr[1]; i4++) {
                            double distanceToLine = distanceToLine(list.get(i4), list.get(iArr[0]), list.get(iArr[1]));
                            if (distanceToLine > d2) {
                                i3 = i4;
                                d2 = distanceToLine;
                            }
                        }
                        if (d2 > d) {
                            dArr[i3] = d2;
                            stack.push(new int[]{iArr[0], i3});
                            stack.push(new int[]{i3, iArr[1]});
                        }
                        d2 = 0.0d;
                    }
                }
                if (isClosedPolygon) {
                    list.remove(list.size() - 1);
                    list.add(latLng);
                }
                ArrayList arrayList = new ArrayList();
                for (LatLng latLng2 : list) {
                    if (dArr[i] != 0.0d) {
                        arrayList.add(latLng2);
                    }
                    i++;
                }
                return arrayList;
            }
            throw new IllegalArgumentException("Tolerance must be greater than zero");
        }
        throw new IllegalArgumentException("Polyline must have at least 1 point");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f8, code lost:
        if (java.lang.Math.tan(r1) >= (a2.b.a.a.a.a(r18, java.lang.Math.tan(r14), java.lang.Math.sin(r20) * java.lang.Math.tan(r7)) / java.lang.Math.sin(r9))) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0111, code lost:
        if (androidx.appcompat.app.AppCompatDelegateImpl.i.i1(r1) >= (((androidx.appcompat.app.AppCompatDelegateImpl.i.i1(r14) * r18) + (androidx.appcompat.app.AppCompatDelegateImpl.i.i1(r7) * r20)) / r9)) goto L_0x0113;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean containsLocation(double r26, double r28, java.util.List<com.google.android.gms.maps.model.LatLng> r30, boolean r31) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.PolyUtil.containsLocation(double, double, java.util.List, boolean):boolean");
    }

    public static boolean isLocationOnEdge(LatLng latLng, List<LatLng> list, boolean z) {
        return isLocationOnEdge(latLng, list, z, 0.1d);
    }

    public static boolean isLocationOnPath(LatLng latLng, List<LatLng> list, boolean z) {
        return isLocationOnPath(latLng, list, z, 0.1d);
    }
}
