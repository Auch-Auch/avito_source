package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TextBlock implements Text {
    private Point[] cornerPoints;
    private zzah[] zzeh;
    private List<Line> zzei;
    private String zzej;
    private Rect zzek;

    public TextBlock(SparseArray<zzah> sparseArray) {
        this.zzeh = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahArr = this.zzeh;
            if (i < zzahArr.length) {
                zzahArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zzek == null) {
            this.zzek = zzc.zza(this);
        }
        return this.zzek;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zzeh.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzei == null) {
            this.zzei = new ArrayList(this.zzeh.length);
            for (zzah zzah : this.zzeh) {
                this.zzei.add(new Line(zzah));
            }
        }
        return this.zzei;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzah[] zzahArr;
        TextBlock textBlock2 = this;
        if (textBlock2.cornerPoints == null) {
            char c = 0;
            if (textBlock2.zzeh.length == 0) {
                textBlock2.cornerPoints = new Point[0];
            } else {
                int i = Integer.MIN_VALUE;
                int i2 = Integer.MIN_VALUE;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MAX_VALUE;
                int i5 = 0;
                while (true) {
                    zzahArr = textBlock2.zzeh;
                    if (i5 >= zzahArr.length) {
                        break;
                    }
                    zzab zzab = zzahArr[i5].zzep;
                    zzab zzab2 = zzahArr[c].zzep;
                    double sin = Math.sin(Math.toRadians((double) zzab2.zzen));
                    double cos = Math.cos(Math.toRadians((double) zzab2.zzen));
                    Point[] pointArr = new Point[4];
                    pointArr[c] = new Point(zzab.left, zzab.top);
                    pointArr[c].offset(-zzab2.left, -zzab2.top);
                    int i6 = (int) ((((double) pointArr[c].y) * sin) + (((double) pointArr[c].x) * cos));
                    int i7 = (int) ((((double) pointArr[0].y) * cos) + (((double) (-pointArr[0].x)) * sin));
                    pointArr[0].x = i6;
                    pointArr[0].y = i7;
                    pointArr[1] = new Point(zzab.width + i6, i7);
                    pointArr[2] = new Point(zzab.width + i6, zzab.height + i7);
                    pointArr[3] = new Point(i6, i7 + zzab.height);
                    i2 = i2;
                    for (int i8 = 0; i8 < 4; i8++) {
                        Point point = pointArr[i8];
                        i3 = Math.min(i3, point.x);
                        i = Math.max(i, point.x);
                        i4 = Math.min(i4, point.y);
                        i2 = Math.max(i2, point.y);
                    }
                    i5++;
                    c = 0;
                    textBlock2 = this;
                }
                zzab zzab3 = zzahArr[0].zzep;
                int i9 = zzab3.left;
                int i10 = zzab3.top;
                double sin2 = Math.sin(Math.toRadians((double) zzab3.zzen));
                double cos2 = Math.cos(Math.toRadians((double) zzab3.zzen));
                Point[] pointArr2 = {new Point(i3, i4), new Point(i, i4), new Point(i, i2), new Point(i3, i2)};
                for (int i11 = 0; i11 < 4; i11++) {
                    int i12 = (int) ((((double) pointArr2[i11].x) * cos2) - (((double) pointArr2[i11].y) * sin2));
                    double d = ((double) pointArr2[i11].y) * cos2;
                    pointArr2[i11].x = i12;
                    pointArr2[i11].y = (int) (d + (((double) pointArr2[i11].x) * sin2));
                    pointArr2[i11].offset(i9, i10);
                }
                textBlock = this;
                textBlock.cornerPoints = pointArr2;
                return textBlock.cornerPoints;
            }
        }
        textBlock = textBlock2;
        return textBlock.cornerPoints;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        String str = this.zzej;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        zzah[] zzahArr = this.zzeh;
        for (zzah zzah : zzahArr) {
            hashMap.put(zzah.zzej, Integer.valueOf((hashMap.containsKey(zzah.zzej) ? ((Integer) hashMap.get(zzah.zzej)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzej = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzej = C.LANGUAGE_UNDETERMINED;
        }
        return this.zzej;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        zzah[] zzahArr = this.zzeh;
        if (zzahArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzahArr[0].zzes);
        for (int i = 1; i < this.zzeh.length; i++) {
            sb.append("\n");
            sb.append(this.zzeh[i].zzes);
        }
        return sb.toString();
    }
}
