package a2.j.k.c.a;

import com.google.zxing.common.reedsolomon.GenericGF;
import com.vk.sdk.api.model.VKApiPhotoSize;
import java.util.Objects;
public final class a {
    public final GenericGF a;
    public final int[] b;

    public a(GenericGF genericGF, int[] iArr) {
        if (iArr.length != 0) {
            this.a = genericGF;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public a a(a aVar) {
        if (!this.a.equals(aVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (e()) {
            return aVar;
        } else {
            if (aVar.e()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = aVar.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = iArr2[i - length] ^ iArr[i];
            }
            return new a(this.a, iArr3);
        }
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int[] iArr = this.b;
            int i2 = 0;
            for (int i3 : iArr) {
                GenericGF genericGF = GenericGF.AZTEC_DATA_12;
                i2 ^= i3;
            }
            return i2;
        }
        int[] iArr2 = this.b;
        int i4 = iArr2[0];
        int length = iArr2.length;
        for (int i5 = 1; i5 < length; i5++) {
            i4 = this.a.c(i, i4) ^ this.b[i5];
        }
        return i4;
    }

    public int c(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    public int d() {
        return this.b.length - 1;
    }

    public boolean e() {
        return this.b[0] == 0;
    }

    public a f(int i) {
        if (i == 0) {
            return this.a.c;
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.c(this.b[i2], i);
        }
        return new a(this.a, iArr);
    }

    public a g(a aVar) {
        if (!this.a.equals(aVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (e() || aVar.e()) {
            return this.a.c;
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = aVar.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = iArr3[i4] ^ this.a.c(i2, iArr2[i3]);
                }
            }
            return new a(this.a, iArr3);
        }
    }

    public a h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.a.c;
        } else {
            int length = this.b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.c(this.b[i3], i2);
            }
            return new a(this.a, iArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int d = d(); d >= 0; d--) {
            int c = c(d);
            if (c != 0) {
                if (c < 0) {
                    sb.append(" - ");
                    c = -c;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (d == 0 || c != 1) {
                    GenericGF genericGF = this.a;
                    Objects.requireNonNull(genericGF);
                    if (c != 0) {
                        int i = genericGF.b[c];
                        if (i == 0) {
                            sb.append('1');
                        } else if (i == 1) {
                            sb.append('a');
                        } else {
                            sb.append("a^");
                            sb.append(i);
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                if (d != 0) {
                    if (d == 1) {
                        sb.append(VKApiPhotoSize.X);
                    } else {
                        sb.append("x^");
                        sb.append(d);
                    }
                }
            }
        }
        return sb.toString();
    }
}
