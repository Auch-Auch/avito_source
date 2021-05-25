package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
public class SlidingPercentile {
    public static final /* synthetic */ int h = 0;
    public final int a;
    public final ArrayList<b> b = new ArrayList<>();
    public final b[] c = new b[5];
    public int d = -1;
    public int e;
    public int f;
    public int g;

    public static class b {
        public int a;
        public int b;
        public float c;

        public b() {
        }

        public b(a aVar) {
        }
    }

    public SlidingPercentile(int i) {
        this.a = i;
    }

    public void addSample(int i, float f2) {
        b bVar;
        if (this.d != 1) {
            Collections.sort(this.b, a2.j.b.b.e1.a.a);
            this.d = 1;
        }
        int i2 = this.g;
        if (i2 > 0) {
            b[] bVarArr = this.c;
            int i3 = i2 - 1;
            this.g = i3;
            bVar = bVarArr[i3];
        } else {
            bVar = new b(null);
        }
        int i4 = this.e;
        this.e = i4 + 1;
        bVar.a = i4;
        bVar.b = i;
        bVar.c = f2;
        this.b.add(bVar);
        this.f += i;
        while (true) {
            int i5 = this.f;
            int i6 = this.a;
            if (i5 > i6) {
                int i7 = i5 - i6;
                b bVar2 = this.b.get(0);
                int i8 = bVar2.b;
                if (i8 <= i7) {
                    this.f -= i8;
                    this.b.remove(0);
                    int i9 = this.g;
                    if (i9 < 5) {
                        b[] bVarArr2 = this.c;
                        this.g = i9 + 1;
                        bVarArr2[i9] = bVar2;
                    }
                } else {
                    bVar2.b = i8 - i7;
                    this.f -= i7;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f2) {
        if (this.d != 0) {
            Collections.sort(this.b, a2.j.b.b.e1.b.a);
            this.d = 0;
        }
        float f3 = f2 * ((float) this.f);
        int i = 0;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            b bVar = this.b.get(i2);
            i += bVar.b;
            if (((float) i) >= f3) {
                return bVar.c;
            }
        }
        if (this.b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.b;
        return arrayList.get(arrayList.size() - 1).c;
    }

    public void reset() {
        this.b.clear();
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
}
