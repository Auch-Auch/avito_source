package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;
public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public boolean a = false;
    public SecureRandom b;
    public RainbowKeyGenerationParameters c;
    public short[][] d;
    public short[][] e;
    public short[] f;
    public short[][] g;
    public short[][] h;
    public short[] i;
    public int j;
    public Layer[] k;
    public int[] l;
    public short[][] m;
    public short[][] n;
    public short[] o;

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.a) {
            initialize(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
        }
        Class<short> cls = short.class;
        int[] iArr = this.l;
        int i2 = 0;
        int i3 = iArr[iArr.length - 1] - iArr[0];
        int[] iArr2 = new int[2];
        iArr2[1] = i3;
        iArr2[0] = i3;
        this.d = (short[][]) Array.newInstance((Class<?>) cls, iArr2);
        this.e = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.e == null) {
            for (int i4 = 0; i4 < i3; i4++) {
                for (int i5 = 0; i5 < i3; i5++) {
                    this.d[i4][i5] = (short) (this.b.nextInt() & 255);
                }
            }
            this.e = computeInField.inverse(this.d);
        }
        this.f = new short[i3];
        for (int i6 = 0; i6 < i3; i6++) {
            this.f[i6] = (short) (this.b.nextInt() & 255);
        }
        int[] iArr3 = this.l;
        int i7 = iArr3[iArr3.length - 1];
        int[] iArr4 = new int[2];
        iArr4[1] = i7;
        iArr4[0] = i7;
        this.g = (short[][]) Array.newInstance((Class<?>) cls, iArr4);
        this.h = null;
        ComputeInField computeInField2 = new ComputeInField();
        while (this.h == null) {
            for (int i8 = 0; i8 < i7; i8++) {
                for (int i9 = 0; i9 < i7; i9++) {
                    this.g[i8][i9] = (short) (this.b.nextInt() & 255);
                }
            }
            this.h = computeInField2.inverse(this.g);
        }
        this.i = new short[i7];
        for (int i10 = 0; i10 < i7; i10++) {
            this.i[i10] = (short) (this.b.nextInt() & 255);
        }
        this.k = new Layer[this.j];
        int i11 = 0;
        while (i11 < this.j) {
            Layer[] layerArr = this.k;
            int[] iArr5 = this.l;
            int i12 = i11 + 1;
            layerArr[i11] = new Layer(iArr5[i11], iArr5[i12], this.b);
            i11 = i12;
        }
        ComputeInField computeInField3 = new ComputeInField();
        int[] iArr6 = this.l;
        int i13 = iArr6[iArr6.length - 1] - iArr6[0];
        int i14 = iArr6[iArr6.length - 1];
        int[] iArr7 = new int[3];
        iArr7[2] = i14;
        iArr7[1] = i14;
        iArr7[0] = i13;
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) cls, iArr7);
        int[] iArr8 = new int[2];
        iArr8[1] = i14;
        iArr8[0] = i13;
        this.n = (short[][]) Array.newInstance((Class<?>) cls, iArr8);
        this.o = new short[i13];
        short[] sArr2 = new short[i14];
        int i15 = 0;
        int i16 = 0;
        while (true) {
            Layer[] layerArr2 = this.k;
            if (i15 >= layerArr2.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr2[i15].getCoeffAlpha();
            short[][][] coeffBeta = this.k[i15].getCoeffBeta();
            short[][] coeffGamma = this.k[i15].getCoeffGamma();
            short[] coeffEta = this.k[i15].getCoeffEta();
            int length = coeffAlpha[i2].length;
            int length2 = coeffBeta[i2].length;
            while (i2 < length) {
                int i17 = 0;
                while (i17 < length) {
                    int i18 = 0;
                    while (i18 < length2) {
                        int i19 = i17 + length2;
                        short[] multVect = computeInField3.multVect(coeffAlpha[i2][i17][i18], this.g[i19]);
                        int i20 = i16 + i2;
                        sArr[i20] = computeInField3.addSquareMatrix(sArr[i20], computeInField3.multVects(multVect, this.g[i18]));
                        short[] multVect2 = computeInField3.multVect(this.i[i18], multVect);
                        short[][] sArr3 = this.n;
                        sArr3[i20] = computeInField3.addVect(multVect2, sArr3[i20]);
                        short[] multVect3 = computeInField3.multVect(this.i[i19], computeInField3.multVect(coeffAlpha[i2][i17][i18], this.g[i18]));
                        short[][] sArr4 = this.n;
                        sArr4[i20] = computeInField3.addVect(multVect3, sArr4[i20]);
                        short multElem = GF2Field.multElem(coeffAlpha[i2][i17][i18], this.i[i19]);
                        short[] sArr5 = this.o;
                        sArr5[i20] = GF2Field.addElem(sArr5[i20], GF2Field.multElem(multElem, this.i[i18]));
                        i18++;
                        i14 = i14;
                        i13 = i13;
                        coeffAlpha = coeffAlpha;
                        i15 = i15;
                        coeffEta = coeffEta;
                    }
                    i17++;
                    cls = cls;
                }
                for (int i21 = 0; i21 < length2; i21++) {
                    for (int i22 = 0; i22 < length2; i22++) {
                        short[] multVect4 = computeInField3.multVect(coeffBeta[i2][i21][i22], this.g[i21]);
                        int i23 = i16 + i2;
                        sArr[i23] = computeInField3.addSquareMatrix(sArr[i23], computeInField3.multVects(multVect4, this.g[i22]));
                        short[] multVect5 = computeInField3.multVect(this.i[i22], multVect4);
                        short[][] sArr6 = this.n;
                        sArr6[i23] = computeInField3.addVect(multVect5, sArr6[i23]);
                        short[] multVect6 = computeInField3.multVect(this.i[i21], computeInField3.multVect(coeffBeta[i2][i21][i22], this.g[i22]));
                        short[][] sArr7 = this.n;
                        sArr7[i23] = computeInField3.addVect(multVect6, sArr7[i23]);
                        short multElem2 = GF2Field.multElem(coeffBeta[i2][i21][i22], this.i[i21]);
                        short[] sArr8 = this.o;
                        sArr8[i23] = GF2Field.addElem(sArr8[i23], GF2Field.multElem(multElem2, this.i[i22]));
                    }
                }
                for (int i24 = 0; i24 < length2 + length; i24++) {
                    short[] multVect7 = computeInField3.multVect(coeffGamma[i2][i24], this.g[i24]);
                    short[][] sArr9 = this.n;
                    int i25 = i16 + i2;
                    sArr9[i25] = computeInField3.addVect(multVect7, sArr9[i25]);
                    short[] sArr10 = this.o;
                    sArr10[i25] = GF2Field.addElem(sArr10[i25], GF2Field.multElem(coeffGamma[i2][i24], this.i[i24]));
                }
                short[] sArr11 = this.o;
                int i26 = i16 + i2;
                sArr11[i26] = GF2Field.addElem(sArr11[i26], coeffEta[i2]);
                i2++;
                cls = cls;
                i14 = i14;
                i13 = i13;
                coeffAlpha = coeffAlpha;
                i15 = i15;
                coeffEta = coeffEta;
            }
            i16 += length;
            i15++;
            i2 = 0;
        }
        int[] iArr9 = new int[3];
        iArr9[2] = i14;
        iArr9[1] = i14;
        iArr9[0] = i13;
        short[][][] sArr12 = (short[][][]) Array.newInstance((Class<?>) cls, iArr9);
        int[] iArr10 = new int[2];
        iArr10[1] = i14;
        iArr10[0] = i13;
        short[][] sArr13 = (short[][]) Array.newInstance((Class<?>) cls, iArr10);
        short[] sArr14 = new short[i13];
        for (int i27 = 0; i27 < i13; i27++) {
            int i28 = 0;
            while (true) {
                short[][] sArr15 = this.d;
                if (i28 >= sArr15.length) {
                    break;
                }
                sArr12[i27] = computeInField3.addSquareMatrix(sArr12[i27], computeInField3.multMatrix(sArr15[i27][i28], sArr[i28]));
                sArr13[i27] = computeInField3.addVect(sArr13[i27], computeInField3.multVect(this.d[i27][i28], this.n[i28]));
                sArr14[i27] = GF2Field.addElem(sArr14[i27], GF2Field.multElem(this.d[i27][i28], this.o[i28]));
                i28++;
            }
            sArr14[i27] = GF2Field.addElem(sArr14[i27], this.f[i27]);
        }
        this.n = sArr13;
        this.o = sArr14;
        int length3 = sArr12.length;
        int length4 = sArr12[0].length;
        int[] iArr11 = new int[2];
        iArr11[1] = ((length4 + 1) * length4) / 2;
        iArr11[0] = length3;
        this.m = (short[][]) Array.newInstance((Class<?>) cls, iArr11);
        for (int i29 = 0; i29 < length3; i29++) {
            int i30 = 0;
            for (int i31 = 0; i31 < length4; i31++) {
                for (int i32 = i31; i32 < length4; i32++) {
                    if (i32 == i31) {
                        this.m[i29][i30] = sArr12[i29][i31][i32];
                    } else {
                        this.m[i29][i30] = GF2Field.addElem(sArr12[i29][i31][i32], sArr12[i29][i32][i31]);
                    }
                    i30++;
                }
            }
        }
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.e, this.f, this.h, this.i, this.l, this.k);
        int[] iArr12 = this.l;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr12[iArr12.length - 1] - iArr12[0], this.m, this.n, this.o), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.c = rainbowKeyGenerationParameters;
        this.b = rainbowKeyGenerationParameters.getRandom();
        this.l = this.c.getParameters().getVi();
        this.j = this.c.getParameters().getNumOfLayers();
        this.a = true;
    }
}
