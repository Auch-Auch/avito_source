package l6.t.a;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
public final class a {
    public static final Comparator<b> f = new C0536a();
    public final int[] a;
    public final int[] b;
    public final List<Palette.Swatch> c;
    public final Palette.Filter[] d;
    public final float[] e = new float[3];

    /* renamed from: l6.t.a.a$a  reason: collision with other inner class name */
    public static class C0536a implements Comparator<b> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar2.b() - bVar.b();
        }
    }

    public class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public b(int i2, int i3) {
            this.a = i2;
            this.b = i3;
            a();
        }

        public final void a() {
            a aVar = a.this;
            int[] iArr = aVar.a;
            int[] iArr2 = aVar.b;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.a; i9 <= this.b; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int i11 = (i10 >> 10) & 31;
                int i12 = (i10 >> 5) & 31;
                int i13 = i10 & 31;
                if (i11 > i5) {
                    i5 = i11;
                }
                if (i11 < i2) {
                    i2 = i11;
                }
                if (i12 > i6) {
                    i6 = i12;
                }
                if (i12 < i3) {
                    i3 = i12;
                }
                if (i13 > i7) {
                    i7 = i13;
                }
                if (i13 < i4) {
                    i4 = i13;
                }
            }
            this.d = i2;
            this.e = i5;
            this.f = i3;
            this.g = i6;
            this.h = i4;
            this.i = i7;
            this.c = i8;
        }

        public final int b() {
            return ((this.i - this.h) + 1) * ((this.g - this.f) + 1) * ((this.e - this.d) + 1);
        }
    }

    public a(int[] iArr, int i, Palette.Filter[] filterArr) {
        b bVar;
        int i2;
        this.d = filterArr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            int c2 = c(Color.blue(i4), 8, 5) | (c(Color.red(i4), 8, 5) << 10) | (c(Color.green(i4), 8, 5) << 5);
            iArr[i3] = c2;
            iArr2[c2] = iArr2[c2] + 1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0) {
                int a3 = a((i6 >> 10) & 31, (i6 >> 5) & 31, i6 & 31);
                ColorUtils.colorToHSL(a3, this.e);
                if (d(a3, this.e)) {
                    iArr2[i6] = 0;
                }
            }
            if (iArr2[i6] > 0) {
                i5++;
            }
        }
        int[] iArr3 = new int[i5];
        this.a = iArr3;
        int i7 = 0;
        for (int i8 = 0; i8 < 32768; i8++) {
            if (iArr2[i8] > 0) {
                iArr3[i7] = i8;
                i7++;
            }
        }
        if (i5 <= i) {
            this.c = new ArrayList();
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = iArr3[i9];
                this.c.add(new Palette.Swatch(a((i10 >> 10) & 31, (i10 >> 5) & 31, i10 & 31), iArr2[i10]));
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i, f);
        priorityQueue.offer(new b(0, this.a.length - 1));
        while (priorityQueue.size() < i && (bVar = (b) priorityQueue.poll()) != null) {
            int i11 = bVar.b;
            int i12 = bVar.a;
            int i13 = (i11 + 1) - i12;
            if (!(i13 > 1)) {
                break;
            }
            if (i13 > 1) {
                int i14 = bVar.e - bVar.d;
                int i15 = bVar.g - bVar.f;
                int i16 = bVar.i - bVar.h;
                int i17 = (i14 < i15 || i14 < i16) ? (i15 < i14 || i15 < i16) ? -1 : -2 : -3;
                a aVar = a.this;
                int[] iArr4 = aVar.a;
                int[] iArr5 = aVar.b;
                b(iArr4, i17, i12, i11);
                Arrays.sort(iArr4, bVar.a, bVar.b + 1);
                b(iArr4, i17, bVar.a, bVar.b);
                int i18 = bVar.c / 2;
                int i19 = bVar.a;
                int i20 = 0;
                while (true) {
                    int i21 = bVar.b;
                    if (i19 > i21) {
                        i2 = bVar.a;
                        break;
                    }
                    i20 += iArr5[iArr4[i19]];
                    if (i20 >= i18) {
                        i2 = Math.min(i21 - 1, i19);
                        break;
                    }
                    i19++;
                }
                b bVar2 = new b(i2 + 1, bVar.b);
                bVar.b = i2;
                bVar.a();
                priorityQueue.offer(bVar2);
                priorityQueue.offer(bVar);
            } else {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            b bVar3 = (b) it.next();
            a aVar2 = a.this;
            int[] iArr6 = aVar2.a;
            int[] iArr7 = aVar2.b;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            for (int i26 = bVar3.a; i26 <= bVar3.b; i26++) {
                int i27 = iArr6[i26];
                int i28 = iArr7[i27];
                i23 += i28;
                i22 += ((i27 >> 10) & 31) * i28;
                i24 += ((i27 >> 5) & 31) * i28;
                i25 += i28 * (i27 & 31);
            }
            float f2 = (float) i23;
            Palette.Swatch swatch = new Palette.Swatch(a(Math.round(((float) i22) / f2), Math.round(((float) i24) / f2), Math.round(((float) i25) / f2)), i23);
            if (!d(swatch.getRgb(), swatch.getHsl())) {
                arrayList.add(swatch);
            }
        }
        this.c = arrayList;
    }

    public static int a(int i, int i2, int i3) {
        return Color.rgb(c(i, 5, 8), c(i2, 5, 8), c(i3, 5, 8));
    }

    public static void b(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = (i4 & 31) | (((i4 >> 5) & 31) << 10) | (((i4 >> 10) & 31) << 5);
                i2++;
            }
        } else if (i == -1) {
            while (i2 <= i3) {
                int i5 = iArr[i2];
                iArr[i2] = ((i5 >> 10) & 31) | ((i5 & 31) << 10) | (((i5 >> 5) & 31) << 5);
                i2++;
            }
        }
    }

    public static int c(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    public final boolean d(int i, float[] fArr) {
        Palette.Filter[] filterArr = this.d;
        if (filterArr != null && filterArr.length > 0) {
            int length = filterArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.d[i2].isAllowed(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
