package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;
public final class zzc {
    public static Rect zza(Text text) {
        Point[] cornerPoints = text.getCornerPoints();
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Point point : cornerPoints) {
            i3 = Math.min(i3, point.x);
            i = Math.max(i, point.x);
            i4 = Math.min(i4, point.y);
            i2 = Math.max(i2, point.y);
        }
        return new Rect(i3, i4, i, i2);
    }

    public static Point[] zza(zzab zzab) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzab.zzen));
        double cos = Math.cos(Math.toRadians((double) zzab.zzen));
        pointArr[0] = new Point(zzab.left, zzab.top);
        int i = zzab.width;
        pointArr[1] = new Point((int) ((((double) i) * cos) + ((double) zzab.left)), (int) ((((double) i) * sin) + ((double) zzab.top)));
        int i2 = zzab.height;
        pointArr[2] = new Point((int) (((double) pointArr[1].x) - (((double) i2) * sin)), (int) ((((double) i2) * cos) + ((double) pointArr[1].y)));
        pointArr[3] = new Point((pointArr[2].x - pointArr[1].x) + pointArr[0].x, (pointArr[2].y - pointArr[1].y) + pointArr[0].y);
        return pointArr;
    }
}
