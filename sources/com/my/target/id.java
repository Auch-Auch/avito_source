package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
public class id {
    @NonNull
    public static float[] a(float f, @NonNull float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = (f / 100.0f) * fArr[i];
        }
        return fArr2;
    }

    @NonNull
    public static <T extends bt> float[] a(@NonNull cr<T> crVar, @Nullable float[] fArr, float f) {
        int i;
        float f2;
        float round;
        HashSet hashSet = new HashSet();
        if (fArr != null && fArr.length > 0) {
            Arrays.sort(fArr);
        }
        List<cf<T>> ca = crVar.ca();
        int i2 = 0;
        int i3 = 0;
        for (cf<T> cfVar : ca) {
            if (fArr == null) {
                round = ((float) Math.round((cfVar.getPointP() > 0.0f ? (cfVar.getPointP() / 100.0f) * f : (cfVar.getPoint() < 0.0f || cfVar.getPoint() > f) ? f / 2.0f : cfVar.getPoint()) * 10.0f)) / 10.0f;
                cfVar.setPoint(round);
            } else {
                if (i3 < fArr.length) {
                    float f3 = fArr[i3];
                    if (!cfVar.getType().equals("statistics")) {
                        i3++;
                    }
                    if (f3 > f) {
                        ae.a("Cannot set midroll position " + f3 + ": out of duration");
                    } else {
                        cfVar.setPoint(f3);
                        round = f3;
                    }
                }
                cfVar.setPoint(-1.0f);
            }
            hashSet.add(Float.valueOf(round));
        }
        if (fArr == null || fArr.length > ca.size()) {
            Iterator<bp> it = crVar.cb().iterator();
            while (it.hasNext()) {
                bp next = it.next();
                if (fArr == null) {
                    float round2 = ((float) Math.round((next.getPointP() >= 0.0f ? (next.getPointP() / 100.0f) * f : (next.getPoint() < 0.0f || next.getPoint() > f) ? f / 2.0f : next.getPoint()) * 10.0f)) / 10.0f;
                    next.setPoint(round2);
                    i = i3;
                    f2 = round2;
                    hashSet.add(Float.valueOf(f2));
                } else if (i3 < fArr.length) {
                    i = i3 + 1;
                    f2 = fArr[i3];
                    if (f2 > f) {
                        ae.a("Cannot set midroll position " + f2 + ": out of duration");
                        next.setPoint(-1.0f);
                    } else {
                        next.setPoint(f2);
                        hashSet.add(Float.valueOf(f2));
                    }
                } else {
                    next.setPoint(-1.0f);
                }
                i3 = i;
            }
        }
        float[] fArr2 = new float[hashSet.size()];
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            fArr2[i2] = ((Float) it2.next()).floatValue();
            i2++;
        }
        Arrays.sort(fArr2);
        return fArr2;
    }

    public static boolean eF() {
        try {
            Class.forName("com.google.android.exoplayer2.ExoPlayer");
            Class.forName(iu.class.getName());
            return true;
        } catch (Throwable unused) {
            ae.a("ExoPlayer doesn't exist, add ExoPlayer dependency to play video");
            return false;
        }
    }

    public static boolean eG() {
        try {
            Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
