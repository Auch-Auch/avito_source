package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.util.Arrays;
public class Layer {
    public int a;
    public int b;
    public int c;
    public short[][][] d;
    public short[][][] e;
    public short[][] f;
    public short[] g;

    public Layer(byte b2, byte b3, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        int i = b2 & 255;
        this.a = i;
        int i2 = b3 & 255;
        this.b = i2;
        this.c = i2 - i;
        this.d = sArr;
        this.e = sArr2;
        this.f = sArr3;
        this.g = sArr4;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Layer)) {
            return false;
        }
        Layer layer = (Layer) obj;
        if (this.a != layer.getVi() || this.b != layer.getViNext() || this.c != layer.getOi() || !RainbowUtil.equals(this.d, layer.getCoeffAlpha()) || !RainbowUtil.equals(this.e, layer.getCoeffBeta()) || !RainbowUtil.equals(this.f, layer.getCoeffGamma()) || !RainbowUtil.equals(this.g, layer.getCoeffEta())) {
            return false;
        }
        return true;
    }

    public short[][][] getCoeffAlpha() {
        return this.d;
    }

    public short[][][] getCoeffBeta() {
        return this.e;
    }

    public short[] getCoeffEta() {
        return this.g;
    }

    public short[][] getCoeffGamma() {
        return this.f;
    }

    public int getOi() {
        return this.c;
    }

    public int getVi() {
        return this.a;
    }

    public int getViNext() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.d);
        int hashCode2 = Arrays.hashCode(this.e);
        int hashCode3 = Arrays.hashCode(this.f);
        return Arrays.hashCode(this.g) + ((hashCode3 + ((hashCode2 + ((hashCode + (((((this.a * 37) + this.b) * 37) + this.c) * 37)) * 37)) * 37)) * 37);
    }

    public short[][] plugInVinegars(short[] sArr) {
        int i = this.c;
        int[] iArr = new int[2];
        iArr[1] = i + 1;
        int i2 = 0;
        iArr[0] = i;
        short[][] sArr2 = (short[][]) Array.newInstance(short.class, iArr);
        short[] sArr3 = new short[this.c];
        for (int i3 = 0; i3 < this.c; i3++) {
            for (int i4 = 0; i4 < this.a; i4++) {
                for (int i5 = 0; i5 < this.a; i5++) {
                    sArr3[i3] = GF2Field.addElem(sArr3[i3], GF2Field.multElem(GF2Field.multElem(this.e[i3][i4][i5], sArr[i4]), sArr[i5]));
                }
            }
        }
        for (int i6 = 0; i6 < this.c; i6++) {
            for (int i7 = 0; i7 < this.c; i7++) {
                for (int i8 = 0; i8 < this.a; i8++) {
                    sArr2[i6][i7] = GF2Field.addElem(sArr2[i6][i7], GF2Field.multElem(this.d[i6][i7][i8], sArr[i8]));
                }
            }
        }
        for (int i9 = 0; i9 < this.c; i9++) {
            for (int i10 = 0; i10 < this.a; i10++) {
                sArr3[i9] = GF2Field.addElem(sArr3[i9], GF2Field.multElem(this.f[i9][i10], sArr[i10]));
            }
        }
        for (int i11 = 0; i11 < this.c; i11++) {
            for (int i12 = this.a; i12 < this.b; i12++) {
                short[] sArr4 = sArr2[i11];
                int i13 = this.a;
                sArr4[i12 - i13] = GF2Field.addElem(this.f[i11][i12], sArr2[i11][i12 - i13]);
            }
        }
        for (int i14 = 0; i14 < this.c; i14++) {
            sArr3[i14] = GF2Field.addElem(sArr3[i14], this.g[i14]);
        }
        while (true) {
            int i15 = this.c;
            if (i2 >= i15) {
                return sArr2;
            }
            sArr2[i2][i15] = sArr3[i2];
            i2++;
        }
    }

    public Layer(int i, int i2, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        int i3 = i2 - i;
        this.c = i3;
        int[] iArr = new int[3];
        iArr[2] = i;
        iArr[1] = i3;
        iArr[0] = i3;
        this.d = (short[][][]) Array.newInstance(short.class, iArr);
        int i4 = this.c;
        int i5 = this.a;
        int[] iArr2 = new int[3];
        iArr2[2] = i5;
        iArr2[1] = i5;
        iArr2[0] = i4;
        this.e = (short[][][]) Array.newInstance(short.class, iArr2);
        int i6 = this.c;
        int[] iArr3 = new int[2];
        iArr3[1] = this.b;
        iArr3[0] = i6;
        this.f = (short[][]) Array.newInstance(short.class, iArr3);
        int i7 = this.c;
        this.g = new short[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            for (int i9 = 0; i9 < this.c; i9++) {
                for (int i10 = 0; i10 < this.a; i10++) {
                    this.d[i8][i9][i10] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < this.a; i12++) {
                for (int i13 = 0; i13 < this.a; i13++) {
                    this.e[i11][i12][i13] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i14 = 0; i14 < i7; i14++) {
            for (int i15 = 0; i15 < this.b; i15++) {
                this.f[i14][i15] = (short) (secureRandom.nextInt() & 255);
            }
        }
        for (int i16 = 0; i16 < i7; i16++) {
            this.g[i16] = (short) (secureRandom.nextInt() & 255);
        }
    }
}
