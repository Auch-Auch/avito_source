package com.google.maps.android.heatmaps;

import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;
    public static final int[] j;
    public static final float[] k;
    public PointQuadTree<WeightedLatLng> a;
    public Collection<WeightedLatLng> b;
    public Bounds c;
    public int d;
    public Gradient e;
    public int[] f;
    public double[] g;
    public double h;
    public double[] i;

    public static class Builder {
        public Collection<WeightedLatLng> a;
        public int b = 20;
        public Gradient c = HeatmapTileProvider.DEFAULT_GRADIENT;
        public double d = 0.7d;

        public HeatmapTileProvider build() {
            if (this.a != null) {
                return new HeatmapTileProvider(this, null);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.d(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.c = gradient;
            return this;
        }

        public Builder opacity(double d2) {
            this.d = d2;
            if (d2 >= 0.0d && d2 <= 1.0d) {
                return this;
            }
            throw new IllegalArgumentException("Opacity must be in range [0, 1]");
        }

        public Builder radius(int i) {
            this.b = i;
            if (i >= 10 && i <= 50) {
                return this;
            }
            throw new IllegalArgumentException("Radius not within bounds.");
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.a = collection;
            if (!collection.isEmpty()) {
                return this;
            }
            throw new IllegalArgumentException("No input points.");
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        j = iArr;
        float[] fArr = {0.2f, 1.0f};
        k = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public HeatmapTileProvider(Builder builder, a aVar) {
        this.b = builder.a;
        int i2 = builder.b;
        this.d = i2;
        this.e = builder.c;
        this.h = builder.d;
        this.g = a(i2, ((double) i2) / 3.0d);
        setGradient(this.e);
        setWeightedData(this.b);
    }

    public static double[] a(int i2, double d2) {
        double[] dArr = new double[((i2 * 2) + 1)];
        for (int i3 = -i2; i3 <= i2; i3++) {
            dArr[i3 + i2] = Math.exp(((double) ((-i3) * i3)) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    public static double c(Collection<WeightedLatLng> collection, Bounds bounds, int i2, int i3) {
        double d2 = bounds.minX;
        double d3 = bounds.maxX;
        double d4 = bounds.minY;
        double d5 = d3 - d2;
        double d6 = bounds.maxY - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = ((double) ((int) (((double) (i3 / (i2 * 2))) + 0.5d))) / d5;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d8 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d9 = weightedLatLng.getPoint().x;
            int i4 = (int) ((weightedLatLng.getPoint().y - d4) * d7);
            long j2 = (long) ((int) ((d9 - d2) * d7));
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j2);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j2, longSparseArray2);
            }
            long j3 = (long) i4;
            Double d10 = (Double) longSparseArray2.get(j3);
            if (d10 == null) {
                d10 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(weightedLatLng.getIntensity() + d10.doubleValue());
            longSparseArray2.put(j3, valueOf);
            if (valueOf.doubleValue() > d8) {
                d8 = valueOf.doubleValue();
            }
        }
        return d8;
    }

    public static Collection<WeightedLatLng> d(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }

    public final double[] b(int i2) {
        int i3;
        double[] dArr = new double[22];
        int i4 = 5;
        while (true) {
            if (i4 >= 11) {
                break;
            }
            dArr[i4] = c(this.b, this.c, i2, (int) (Math.pow(2.0d, (double) (i4 - 3)) * 1280.0d));
            if (i4 == 5) {
                for (int i5 = 0; i5 < i4; i5++) {
                    dArr[i5] = dArr[i4];
                }
            }
            i4++;
        }
        for (i3 = 11; i3 < 22; i3++) {
            dArr[i3] = dArr[10];
        }
        return dArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00b3  */
    @Override // com.google.android.gms.maps.model.TileProvider
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.maps.model.Tile getTile(int r45, int r46, int r47) {
        /*
        // Method dump skipped, instructions count: 577
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.heatmaps.HeatmapTileProvider.getTile(int, int, int):com.google.android.gms.maps.model.Tile");
    }

    public void setData(Collection<LatLng> collection) {
        setWeightedData(d(collection));
    }

    public void setGradient(Gradient gradient) {
        this.e = gradient;
        double d2 = this.h;
        Objects.requireNonNull(gradient);
        HashMap hashMap = new HashMap();
        if (gradient.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new Gradient.b(gradient, Color.argb(0, Color.red(gradient.mColors[0]), Color.green(gradient.mColors[0]), Color.blue(gradient.mColors[0])), gradient.mColors[0], ((float) gradient.mColorMapSize) * gradient.mStartPoints[0], null));
        }
        for (int i2 = 1; i2 < gradient.mColors.length; i2++) {
            int i3 = i2 - 1;
            Integer valueOf = Integer.valueOf((int) (((float) gradient.mColorMapSize) * gradient.mStartPoints[i3]));
            int[] iArr = gradient.mColors;
            int i4 = iArr[i3];
            int i5 = iArr[i2];
            float[] fArr = gradient.mStartPoints;
            hashMap.put(valueOf, new Gradient.b(gradient, i4, i5, (fArr[i2] - fArr[i3]) * ((float) gradient.mColorMapSize), null));
        }
        float[] fArr2 = gradient.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (((float) gradient.mColorMapSize) * fArr2[length]));
            int[] iArr2 = gradient.mColors;
            hashMap.put(valueOf2, new Gradient.b(gradient, iArr2[length], iArr2[length], (1.0f - gradient.mStartPoints[length]) * ((float) gradient.mColorMapSize), null));
        }
        int[] iArr3 = new int[gradient.mColorMapSize];
        Gradient.b bVar = (Gradient.b) hashMap.get(0);
        int i6 = 0;
        for (int i7 = 0; i7 < gradient.mColorMapSize; i7++) {
            if (hashMap.containsKey(Integer.valueOf(i7))) {
                bVar = (Gradient.b) hashMap.get(Integer.valueOf(i7));
                i6 = i7;
            }
            float f2 = ((float) (i7 - i6)) / bVar.c;
            int i8 = bVar.a;
            int i9 = bVar.b;
            int alpha = (int) ((((float) (Color.alpha(i9) - Color.alpha(i8))) * f2) + ((float) Color.alpha(i8)));
            float[] fArr3 = new float[3];
            Color.RGBToHSV(Color.red(i8), Color.green(i8), Color.blue(i8), fArr3);
            float[] fArr4 = new float[3];
            Color.RGBToHSV(Color.red(i9), Color.green(i9), Color.blue(i9), fArr4);
            if (fArr3[0] - fArr4[0] > 180.0f) {
                fArr4[0] = fArr4[0] + 360.0f;
            } else if (fArr4[0] - fArr3[0] > 180.0f) {
                fArr3[0] = fArr3[0] + 360.0f;
            }
            float[] fArr5 = new float[3];
            for (int i10 = 0; i10 < 3; i10++) {
                fArr5[i10] = ((fArr4[i10] - fArr3[i10]) * f2) + fArr3[i10];
            }
            iArr3[i7] = Color.HSVToColor(alpha, fArr5);
        }
        if (d2 != 1.0d) {
            for (int i11 = 0; i11 < gradient.mColorMapSize; i11++) {
                int i12 = iArr3[i11];
                iArr3[i11] = Color.argb((int) (((double) Color.alpha(i12)) * d2), Color.red(i12), Color.green(i12), Color.blue(i12));
            }
        }
        this.f = iArr3;
    }

    public void setOpacity(double d2) {
        this.h = d2;
        setGradient(this.e);
    }

    public void setRadius(int i2) {
        this.d = i2;
        this.g = a(i2, ((double) i2) / 3.0d);
        this.i = b(this.d);
    }

    public void setWeightedData(Collection<WeightedLatLng> collection) {
        this.b = collection;
        if (!collection.isEmpty()) {
            Iterator<WeightedLatLng> it = this.b.iterator();
            WeightedLatLng next = it.next();
            double d2 = next.getPoint().x;
            double d3 = next.getPoint().x;
            double d4 = next.getPoint().y;
            double d5 = next.getPoint().y;
            double d6 = d2;
            double d7 = d3;
            double d8 = d4;
            loop0:
            while (true) {
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    WeightedLatLng next2 = it.next();
                    double d9 = next2.getPoint().x;
                    d5 = next2.getPoint().y;
                    if (d9 < d6) {
                        d6 = d9;
                    }
                    if (d9 > d7) {
                        d7 = d9;
                    }
                    if (d5 < d8) {
                        d8 = d5;
                    }
                    if (d5 > d5) {
                    }
                }
            }
            Bounds bounds = new Bounds(d6, d7, d8, d5);
            this.c = bounds;
            this.a = new PointQuadTree<>(bounds);
            for (WeightedLatLng weightedLatLng : this.b) {
                this.a.add(weightedLatLng);
            }
            this.i = b(this.d);
            return;
        }
        throw new IllegalArgumentException("No input points.");
    }
}
