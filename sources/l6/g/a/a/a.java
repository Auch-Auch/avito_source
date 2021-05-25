package l6.g.a.a;

import androidx.constraintlayout.motion.utils.CurveFit;
import java.util.Arrays;
public class a extends CurveFit {
    public final double[] a;
    public C0524a[] b;

    /* renamed from: l6.g.a.a.a$a  reason: collision with other inner class name */
    public static class C0524a {
        public static double[] s = new double[91];
        public double[] a;
        public double b;
        public double c;
        public double d;
        public double e;
        public double f;
        public double g;
        public double h;
        public double i;
        public double j;
        public double k;
        public double l;
        public double m;
        public double n;
        public double o;
        public double p;
        public boolean q;
        public boolean r = false;

        public C0524a(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            double d8 = d4;
            boolean z = false;
            int i3 = 1;
            this.q = i2 == 1 ? true : z;
            this.c = d2;
            this.d = d3;
            this.i = 1.0d / (d3 - d2);
            if (3 == i2) {
                this.r = true;
            }
            double d9 = d6 - d8;
            double d10 = d7 - d5;
            if (this.r || Math.abs(d9) < 0.001d || Math.abs(d10) < 0.001d) {
                this.r = true;
                this.e = d8;
                this.f = d6;
                this.g = d5;
                this.h = d7;
                double hypot = Math.hypot(d10, d9);
                this.b = hypot;
                this.n = hypot * this.i;
                double d11 = this.d;
                double d12 = this.c;
                this.l = d9 / (d11 - d12);
                this.m = d10 / (d11 - d12);
                return;
            }
            this.a = new double[101];
            boolean z2 = this.q;
            this.j = ((double) (z2 ? -1 : i3)) * d9;
            this.k = d10 * ((double) (z2 ? 1 : -1));
            this.l = z2 ? d6 : d8;
            this.m = z2 ? d5 : d7;
            double d13 = d5 - d7;
            int i4 = 0;
            double d14 = 0.0d;
            double d15 = 0.0d;
            double d16 = 0.0d;
            while (true) {
                double[] dArr = s;
                if (i4 >= dArr.length) {
                    break;
                }
                double radians = Math.toRadians((((double) i4) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d9;
                double cos = Math.cos(radians) * d13;
                if (i4 > 0) {
                    d14 += Math.hypot(sin - d15, cos - d16);
                    s[i4] = d14;
                }
                i4++;
                d16 = cos;
                d15 = sin;
            }
            this.b = d14;
            int i5 = 0;
            while (true) {
                double[] dArr2 = s;
                if (i5 >= dArr2.length) {
                    break;
                }
                dArr2[i5] = dArr2[i5] / d14;
                i5++;
            }
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.a;
                if (i6 < dArr3.length) {
                    double length = ((double) i6) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(s, length);
                    if (binarySearch >= 0) {
                        this.a[i6] = (double) (binarySearch / (s.length - 1));
                    } else if (binarySearch == -1) {
                        this.a[i6] = 0.0d;
                    } else {
                        int i7 = -binarySearch;
                        int i8 = i7 - 2;
                        double[] dArr4 = s;
                        this.a[i6] = (((length - dArr4[i8]) / (dArr4[i7 - 1] - dArr4[i8])) + ((double) i8)) / ((double) (dArr4.length - 1));
                    }
                    i6++;
                } else {
                    this.n = this.b * this.i;
                    return;
                }
            }
        }

        public double a() {
            double d2 = this.j * this.p;
            double hypot = this.n / Math.hypot(d2, (-this.k) * this.o);
            if (this.q) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        public double b() {
            double d2 = this.j * this.p;
            double d3 = (-this.k) * this.o;
            double hypot = this.n / Math.hypot(d2, d3);
            return this.q ? (-d3) * hypot : d3 * hypot;
        }

        public double c(double d2) {
            double d3 = (d2 - this.c) * this.i;
            double d4 = this.e;
            return ((this.f - d4) * d3) + d4;
        }

        public double d(double d2) {
            double d3 = (d2 - this.c) * this.i;
            double d4 = this.g;
            return ((this.h - d4) * d3) + d4;
        }

        public double e() {
            return (this.j * this.o) + this.l;
        }

        public double f() {
            return (this.k * this.p) + this.m;
        }

        public void g(double d2) {
            double d3 = (this.q ? this.d - d2 : d2 - this.c) * this.i;
            double d4 = 0.0d;
            if (d3 > 0.0d) {
                d4 = 1.0d;
                if (d3 < 1.0d) {
                    double[] dArr = this.a;
                    double length = d3 * ((double) (dArr.length - 1));
                    int i2 = (int) length;
                    d4 = ((dArr[i2 + 1] - dArr[i2]) * (length - ((double) i2))) + dArr[i2];
                }
            }
            double d5 = d4 * 1.5707963267948966d;
            this.o = Math.sin(d5);
            this.p = Math.cos(d5);
        }
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.a = dArr;
        this.b = new C0524a[(dArr.length - 1)];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            C0524a[] aVarArr = this.b;
            if (i < aVarArr.length) {
                int i4 = iArr[i];
                if (i4 == 0) {
                    i3 = 3;
                } else if (i4 == 1) {
                    i2 = 1;
                    i3 = 1;
                } else if (i4 == 2) {
                    i2 = 2;
                    i3 = 2;
                } else if (i4 == 3) {
                    i2 = i2 == 1 ? 2 : 1;
                    i3 = i2;
                }
                int i5 = i + 1;
                aVarArr[i] = new C0524a(i3, dArr[i], dArr[i5], dArr2[i][0], dArr2[i][1], dArr2[i5][0], dArr2[i5][1]);
                i = i5;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        C0524a[] aVarArr = this.b;
        if (d < aVarArr[0].c) {
            d = aVarArr[0].c;
        }
        if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        int i = 0;
        while (true) {
            C0524a[] aVarArr2 = this.b;
            if (i >= aVarArr2.length) {
                return;
            }
            if (d > aVarArr2[i].d) {
                i++;
            } else if (aVarArr2[i].r) {
                dArr[0] = aVarArr2[i].c(d);
                dArr[1] = this.b[i].d(d);
                return;
            } else {
                aVarArr2[i].g(d);
                dArr[0] = this.b[i].e();
                dArr[1] = this.b[i].f();
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        C0524a[] aVarArr = this.b;
        if (d < aVarArr[0].c) {
            d = aVarArr[0].c;
        } else if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        int i = 0;
        while (true) {
            C0524a[] aVarArr2 = this.b;
            if (i >= aVarArr2.length) {
                return;
            }
            if (d > aVarArr2[i].d) {
                i++;
            } else if (aVarArr2[i].r) {
                dArr[0] = aVarArr2[i].l;
                dArr[1] = aVarArr2[i].m;
                return;
            } else {
                aVarArr2[i].g(d);
                dArr[0] = this.b[i].a();
                dArr[1] = this.b[i].b();
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.a;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        C0524a[] aVarArr = this.b;
        if (d < aVarArr[0].c) {
            d = aVarArr[0].c;
        } else if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        int i = 0;
        while (true) {
            C0524a[] aVarArr2 = this.b;
            if (i >= aVarArr2.length) {
                return;
            }
            if (d > aVarArr2[i].d) {
                i++;
            } else if (aVarArr2[i].r) {
                fArr[0] = (float) aVarArr2[i].c(d);
                fArr[1] = (float) this.b[i].d(d);
                return;
            } else {
                aVarArr2[i].g(d);
                fArr[0] = (float) this.b[i].e();
                fArr[1] = (float) this.b[i].f();
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        C0524a[] aVarArr = this.b;
        int i2 = 0;
        if (d < aVarArr[0].c) {
            d = aVarArr[0].c;
        }
        if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        while (true) {
            C0524a[] aVarArr2 = this.b;
            if (i2 >= aVarArr2.length) {
                return Double.NaN;
            }
            if (d > aVarArr2[i2].d) {
                i2++;
            } else if (!aVarArr2[i2].r) {
                aVarArr2[i2].g(d);
                if (i == 0) {
                    return this.b[i2].a();
                }
                return this.b[i2].b();
            } else if (i == 0) {
                return aVarArr2[i2].l;
            } else {
                return aVarArr2[i2].m;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i) {
        C0524a[] aVarArr = this.b;
        int i2 = 0;
        if (d < aVarArr[0].c) {
            d = aVarArr[0].c;
        } else if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        while (true) {
            C0524a[] aVarArr2 = this.b;
            if (i2 >= aVarArr2.length) {
                return Double.NaN;
            }
            if (d > aVarArr2[i2].d) {
                i2++;
            } else if (!aVarArr2[i2].r) {
                aVarArr2[i2].g(d);
                if (i == 0) {
                    return this.b[i2].e();
                }
                return this.b[i2].f();
            } else if (i == 0) {
                return aVarArr2[i2].c(d);
            } else {
                return aVarArr2[i2].d(d);
            }
        }
    }
}
