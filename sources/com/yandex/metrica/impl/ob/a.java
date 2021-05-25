package com.yandex.metrica.impl.ob;

import com.google.common.base.Ascii;
import java.io.IOException;
public final class a {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = Integer.MAX_VALUE;
    private int h;
    private int i = 64;
    private int j = 67108864;

    private a(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.b = i2;
        this.c = i3 + i2;
        this.e = i2;
    }

    public static long a(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static a a(byte[] bArr, int i2, int i3) {
        return new a(bArr, i2, i3);
    }

    public static int c(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    private void v() {
        int i2 = this.c + this.d;
        this.c = i2;
        int i3 = this.g;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.d = i4;
            this.c = i2 - i4;
            return;
        }
        this.d = 0;
    }

    public boolean b(int i2) throws IOException {
        int a3 = g.a(i2);
        if (a3 == 0) {
            g();
            return true;
        } else if (a3 == 1) {
            q();
            return true;
        } else if (a3 == 2) {
            h(n());
            return true;
        } else if (a3 == 3) {
            b();
            a(g.a(g.b(i2), 4));
            return true;
        } else if (a3 == 4) {
            return false;
        } else {
            if (a3 == 5) {
                p();
                return true;
            }
            throw d.f();
        }
    }

    public double c() throws IOException {
        return Double.longBitsToDouble(q());
    }

    public float d() throws IOException {
        return Float.intBitsToFloat(p());
    }

    public long e() throws IOException {
        return o();
    }

    public long f() throws IOException {
        return o();
    }

    public int g() throws IOException {
        return n();
    }

    public boolean h() throws IOException {
        return n() != 0;
    }

    public String i() throws IOException {
        int n = n();
        if (n > this.c - this.e || n <= 0) {
            return new String(g(n), "UTF-8");
        }
        String str = new String(this.a, this.e, n, "UTF-8");
        this.e += n;
        return str;
    }

    public byte[] j() throws IOException {
        int n = n();
        int i2 = this.c;
        int i3 = this.e;
        if (n > i2 - i3 || n <= 0) {
            return g(n);
        }
        byte[] bArr = new byte[n];
        System.arraycopy(this.a, i3, bArr, 0, n);
        this.e += n;
        return bArr;
    }

    public int k() throws IOException {
        return n();
    }

    public int l() throws IOException {
        return c(n());
    }

    public long m() throws IOException {
        return a(o());
    }

    public int n() throws IOException {
        int i2;
        byte u = u();
        if (u >= 0) {
            return u;
        }
        int i3 = u & Byte.MAX_VALUE;
        byte u2 = u();
        if (u2 >= 0) {
            i2 = u2 << 7;
        } else {
            i3 |= (u2 & Byte.MAX_VALUE) << 7;
            byte u3 = u();
            if (u3 >= 0) {
                i2 = u3 << Ascii.SO;
            } else {
                i3 |= (u3 & Byte.MAX_VALUE) << 14;
                byte u4 = u();
                if (u4 >= 0) {
                    i2 = u4 << Ascii.NAK;
                } else {
                    int i4 = i3 | ((u4 & Byte.MAX_VALUE) << 21);
                    byte u5 = u();
                    int i5 = i4 | (u5 << Ascii.FS);
                    if (u5 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (u() >= 0) {
                            return i5;
                        }
                    }
                    throw d.c();
                }
            }
        }
        return i3 | i2;
    }

    public long o() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte u = u();
            j2 |= ((long) (u & Byte.MAX_VALUE)) << i2;
            if ((u & 128) == 0) {
                return j2;
            }
        }
        throw d.c();
    }

    public int p() throws IOException {
        return (u() & 255) | ((u() & 255) << 8) | ((u() & 255) << 16) | ((u() & 255) << 24);
    }

    public long q() throws IOException {
        byte u = u();
        byte u2 = u();
        return ((((long) u2) & 255) << 8) | (((long) u) & 255) | ((((long) u()) & 255) << 16) | ((((long) u()) & 255) << 24) | ((((long) u()) & 255) << 32) | ((((long) u()) & 255) << 40) | ((((long) u()) & 255) << 48) | ((((long) u()) & 255) << 56);
    }

    public int r() {
        int i2 = this.g;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - this.e;
    }

    public boolean s() {
        return this.e == this.c;
    }

    public int t() {
        return this.e - this.b;
    }

    public byte u() throws IOException {
        int i2 = this.e;
        if (i2 != this.c) {
            byte[] bArr = this.a;
            this.e = i2 + 1;
            return bArr[i2];
        }
        throw d.a();
    }

    public int a() throws IOException {
        if (s()) {
            this.f = 0;
            return 0;
        }
        int n = n();
        this.f = n;
        if (n != 0) {
            return n;
        }
        throw d.d();
    }

    public int d(int i2) throws d {
        if (i2 >= 0) {
            int i3 = i2 + this.e;
            int i4 = this.g;
            if (i3 <= i4) {
                this.g = i3;
                v();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    public void e(int i2) {
        this.g = i2;
        v();
    }

    public void f(int i2) {
        int i3 = this.e;
        int i4 = this.b;
        if (i2 > i3 - i4) {
            StringBuilder M = a2.b.a.a.a.M("Position ", i2, " is beyond current ");
            M.append(this.e - this.b);
            throw new IllegalArgumentException(M.toString());
        } else if (i2 >= 0) {
            this.e = i4 + i2;
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Bad position ", i2));
        }
    }

    public byte[] g(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.e;
            int i4 = i3 + i2;
            int i5 = this.g;
            if (i4 > i5) {
                h(i5 - i3);
                throw d.a();
            } else if (i2 <= this.c - i3) {
                byte[] bArr = new byte[i2];
                System.arraycopy(this.a, i3, bArr, 0, i2);
                this.e += i2;
                return bArr;
            } else {
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }

    public void h(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.e;
            int i4 = i3 + i2;
            int i5 = this.g;
            if (i4 > i5) {
                h(i5 - i3);
                throw d.a();
            } else if (i2 <= this.c - i3) {
                this.e = i3 + i2;
            } else {
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }

    public void a(int i2) throws d {
        if (this.f != i2) {
            throw d.e();
        }
    }

    public void a(e eVar) throws IOException {
        int n = n();
        if (this.h < this.i) {
            int d2 = d(n);
            this.h++;
            eVar.a(this);
            a(0);
            this.h--;
            e(d2);
            return;
        }
        throw d.g();
    }

    public void b() throws IOException {
        int a3;
        do {
            a3 = a();
            if (a3 == 0) {
                return;
            }
        } while (b(a3));
    }
}
