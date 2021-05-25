package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.3";
    public GMSSRandom a;
    public Digest b;
    public byte[][] c;
    public byte[][] d;
    public byte[][] e;
    public GMSSDigestProvider f;
    public int g;
    public int h;
    public boolean i = false;
    public GMSSParameters j;
    public int[] k;
    public int[] l;
    public int[] m;
    public GMSSKeyGenerationParameters n;

    public GMSSKeyPairGenerator(GMSSDigestProvider gMSSDigestProvider) {
        this.f = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.b = digest;
        this.g = digest.getDigestSize();
        this.a = new GMSSRandom(this.b);
    }

    public final GMSSRootCalc a(byte[] bArr, Vector vector, byte[] bArr2, int i2) {
        byte[] bArr3;
        int i3 = this.g;
        byte[] bArr4 = new byte[i3];
        byte[] bArr5 = new byte[i3];
        byte[] nextSeed = this.a.nextSeed(bArr2);
        GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.k[i2], this.m[i2], this.f);
        gMSSRootCalc.initialize(vector);
        if (i2 == this.h - 1) {
            bArr3 = new WinternitzOTSignature(nextSeed, this.f.get(), this.l[i2]).getPublicKey();
        } else {
            this.e[i2] = new WinternitzOTSignature(nextSeed, this.f.get(), this.l[i2]).getSignature(bArr);
            bArr3 = new WinternitzOTSVerify(this.f.get(), this.l[i2]).Verify(bArr, this.e[i2]);
        }
        gMSSRootCalc.update(bArr3);
        int i4 = 3;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int[] iArr = this.k;
            if (i6 >= (1 << iArr[i2])) {
                break;
            }
            if (i6 == i4 && i5 < iArr[i2] - this.m[i2]) {
                gMSSRootCalc.initializeTreehashSeed(bArr2, i5);
                i4 *= 2;
                i5++;
            }
            gMSSRootCalc.update(new WinternitzOTSignature(this.a.nextSeed(bArr2), this.f.get(), this.l[i2]).getPublicKey());
            i6++;
        }
        if (gMSSRootCalc.wasFinished()) {
            return gMSSRootCalc;
        }
        System.err.println("Baum noch nicht fertig konstruiert!!!");
        return null;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        int i2;
        int i3;
        GMSSRootCalc a3;
        if (!this.i) {
            initialize(new GMSSKeyGenerationParameters(new SecureRandom(), new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2})));
        }
        int i4 = this.h;
        byte[][][] bArr = new byte[i4][][];
        int i5 = i4 - 1;
        byte[][][] bArr2 = new byte[i5][][];
        Treehash[][] treehashArr = new Treehash[i4][];
        Treehash[][] treehashArr2 = new Treehash[i5][];
        Vector[] vectorArr = new Vector[i4];
        Vector[] vectorArr2 = new Vector[i5];
        Vector[][] vectorArr3 = new Vector[i4][];
        int i6 = 1;
        Vector[][] vectorArr4 = new Vector[(i4 - 1)][];
        int i7 = 0;
        while (true) {
            i2 = this.h;
            if (i7 >= i2) {
                break;
            }
            int i8 = this.k[i7];
            int[] iArr = new int[2];
            iArr[1] = this.g;
            iArr[0] = i8;
            bArr[i7] = (byte[][]) Array.newInstance(byte.class, iArr);
            int[] iArr2 = this.k;
            treehashArr[i7] = new Treehash[(iArr2[i7] - this.m[i7])];
            if (i7 > 0) {
                int i9 = i7 - 1;
                int i10 = iArr2[i7];
                int[] iArr3 = new int[2];
                iArr3[1] = this.g;
                iArr3[0] = i10;
                bArr2[i9] = (byte[][]) Array.newInstance(byte.class, iArr3);
                treehashArr2[i9] = new Treehash[(this.k[i7] - this.m[i7])];
            }
            vectorArr[i7] = new Vector();
            if (i7 > 0) {
                vectorArr2[i7 - 1] = new Vector();
            }
            i7++;
            vectorArr4 = vectorArr4;
        }
        int[] iArr4 = new int[2];
        iArr4[1] = this.g;
        iArr4[0] = i2;
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = this.g;
        iArr5[0] = this.h - 1;
        byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, iArr5);
        int i11 = this.h;
        int[] iArr6 = new int[2];
        iArr6[1] = this.g;
        iArr6[0] = i11;
        byte[][] bArr5 = (byte[][]) Array.newInstance(byte.class, iArr6);
        int i12 = 0;
        while (true) {
            i3 = this.h;
            if (i12 >= i3) {
                break;
            }
            System.arraycopy(this.c[i12], 0, bArr5[i12], 0, this.g);
            i12++;
            i6 = 1;
        }
        int[] iArr7 = new int[2];
        iArr7[i6] = this.g;
        iArr7[0] = i3 - i6;
        this.e = (byte[][]) Array.newInstance(byte.class, iArr7);
        for (int i13 = this.h - i6; i13 >= 0; i13--) {
            GMSSRootCalc gMSSRootCalc = new GMSSRootCalc(this.k[i13], this.m[i13], this.f);
            try {
                if (i13 == this.h - 1) {
                    a3 = a(null, vectorArr[i13], bArr5[i13], i13);
                } else {
                    a3 = a(bArr3[i13 + 1], vectorArr[i13], bArr5[i13], i13);
                }
                gMSSRootCalc = a3;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            for (int i14 = 0; i14 < this.k[i13]; i14++) {
                System.arraycopy(gMSSRootCalc.getAuthPath()[i14], 0, bArr[i13][i14], 0, this.g);
            }
            vectorArr3[i13] = gMSSRootCalc.getRetain();
            treehashArr[i13] = gMSSRootCalc.getTreehash();
            System.arraycopy(gMSSRootCalc.getRoot(), 0, bArr3[i13], 0, this.g);
        }
        int i15 = this.h - 2;
        while (i15 >= 0) {
            Vector vector = vectorArr2[i15];
            int i16 = i15 + 1;
            byte[] bArr6 = bArr5[i16];
            byte[] bArr7 = new byte[this.h];
            GMSSRootCalc gMSSRootCalc2 = new GMSSRootCalc(this.k[i16], this.m[i16], this.f);
            gMSSRootCalc2.initialize(vector);
            int i17 = 3;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                int[] iArr8 = this.k;
                if (i18 >= (1 << iArr8[i16])) {
                    break;
                }
                if (i18 == i17 && i19 < iArr8[i16] - this.m[i16]) {
                    gMSSRootCalc2.initializeTreehashSeed(bArr6, i19);
                    i17 *= 2;
                    i19++;
                }
                gMSSRootCalc2.update(new WinternitzOTSignature(this.a.nextSeed(bArr6), this.f.get(), this.l[i16]).getPublicKey());
                i18++;
                i17 = i17;
                vectorArr2 = vectorArr2;
                i19 = i19;
            }
            if (!gMSSRootCalc2.wasFinished()) {
                System.err.println("N�chster Baum noch nicht fertig konstruiert!!!");
                gMSSRootCalc2 = null;
            }
            for (int i20 = 0; i20 < this.k[i16]; i20++) {
                System.arraycopy(gMSSRootCalc2.getAuthPath()[i20], 0, bArr2[i15][i20], 0, this.g);
            }
            vectorArr4[i15] = gMSSRootCalc2.getRetain();
            treehashArr2[i15] = gMSSRootCalc2.getTreehash();
            System.arraycopy(gMSSRootCalc2.getRoot(), 0, bArr4[i15], 0, this.g);
            System.arraycopy(bArr5[i16], 0, this.d[i15], 0, this.g);
            i15--;
            vectorArr3 = vectorArr3;
            vectorArr2 = vectorArr2;
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new GMSSPublicKeyParameters(bArr3[0], this.j), (AsymmetricKeyParameter) new GMSSPrivateKeyParameters(this.c, this.d, bArr, bArr2, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, bArr4, this.e, this.j, this.f));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(int i2, SecureRandom secureRandom) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters;
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters2;
        if (i2 <= 10) {
            gMSSKeyGenerationParameters = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(1, new int[]{10}, new int[]{3}, new int[]{2}));
        } else {
            if (i2 <= 20) {
                gMSSKeyGenerationParameters2 = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2}));
            } else {
                gMSSKeyGenerationParameters2 = new GMSSKeyGenerationParameters(secureRandom, new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2}));
            }
            gMSSKeyGenerationParameters = gMSSKeyGenerationParameters2;
        }
        initialize(gMSSKeyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        GMSSKeyGenerationParameters gMSSKeyGenerationParameters = (GMSSKeyGenerationParameters) keyGenerationParameters;
        this.n = gMSSKeyGenerationParameters;
        GMSSParameters gMSSParameters = new GMSSParameters(gMSSKeyGenerationParameters.getParameters().getNumOfLayers(), this.n.getParameters().getHeightOfTrees(), this.n.getParameters().getWinternitzParameter(), this.n.getParameters().getK());
        this.j = gMSSParameters;
        this.h = gMSSParameters.getNumOfLayers();
        this.k = this.j.getHeightOfTrees();
        this.l = this.j.getWinternitzParameter();
        this.m = this.j.getK();
        int i2 = this.h;
        int[] iArr = new int[2];
        iArr[1] = this.g;
        iArr[0] = i2;
        this.c = (byte[][]) Array.newInstance(byte.class, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = this.g;
        iArr2[0] = this.h - 1;
        this.d = (byte[][]) Array.newInstance(byte.class, iArr2);
        SecureRandom secureRandom = new SecureRandom();
        for (int i3 = 0; i3 < this.h; i3++) {
            secureRandom.nextBytes(this.c[i3]);
            this.a.nextSeed(this.c[i3]);
        }
        this.i = true;
    }
}
