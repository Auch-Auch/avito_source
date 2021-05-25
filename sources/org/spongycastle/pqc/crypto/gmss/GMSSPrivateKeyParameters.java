package org.spongycastle.pqc.crypto.gmss;

import a2.b.a.a.a;
import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.spongycastle.util.Arrays;
public class GMSSPrivateKeyParameters extends GMSSKeyParameters {
    public boolean A;
    public int[] B;
    public int[] C;
    public int[] D;
    public int E;
    public Digest F;
    public int G;
    public GMSSRandom H;
    public int[] I;
    public int[] c;
    public byte[][] d;
    public byte[][] e;
    public byte[][][] f;
    public byte[][][] g;
    public Treehash[][] i;
    public Treehash[][] j;
    public Vector[] k;
    public Vector[] l;
    public Vector[][] m;
    public Vector[][] n;
    public byte[][][] o;
    public GMSSLeaf[] p;
    public GMSSLeaf[] q;
    public GMSSLeaf[] r;
    public int[] s;
    public GMSSParameters u;
    public byte[][] v;
    public GMSSRootCalc[] w;
    public byte[][] x;
    public GMSSRootSig[] y;
    public GMSSDigestProvider z;

    public GMSSPrivateKeyParameters(byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][] bArr5, byte[][] bArr6, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        this(null, bArr, bArr2, bArr3, bArr4, null, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, null, null, null, null, bArr5, null, bArr6, null, gMSSParameters, gMSSDigestProvider);
    }

    public final int a(int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.B[i2] - this.D[i2]; i4++) {
            if (this.i[i2][i4].wasInitialized() && !this.i[i2][i4].wasFinished() && (i3 == -1 || this.i[i2][i4].getLowestNodeHeight() < this.i[i2][i3].getLowestNodeHeight())) {
                i3 = i4;
            }
        }
        return i3;
    }

    public final void b(int i2) {
        int i3;
        byte[] bArr;
        int i4 = this.E;
        if (i2 == i4 - 1) {
            int[] iArr = this.c;
            iArr[i2] = iArr[i2] + 1;
        }
        int[] iArr2 = this.c;
        int i5 = -1;
        if (iArr2[i2] != this.I[i2]) {
            int i6 = iArr2[i2];
            int i7 = this.B[i2];
            int i8 = this.D[i2];
            int i9 = 0;
            while (true) {
                i3 = i7 - i8;
                if (i9 >= i3) {
                    break;
                }
                this.i[i2][i9].updateNextSeed(this.H);
                i9++;
            }
            if (i6 != 0) {
                int i10 = 1;
                int i11 = 0;
                while (i6 % i10 == 0) {
                    i10 *= 2;
                    i11++;
                }
                i5 = -1 + i11;
            }
            byte[] bArr2 = new byte[this.G];
            byte[] nextSeed = this.H.nextSeed(this.d[i2]);
            int i12 = (i6 >>> (i5 + 1)) & 1;
            int i13 = this.G;
            byte[] bArr3 = new byte[i13];
            int i14 = i7 - 1;
            if (i5 < i14 && i12 == 0) {
                System.arraycopy(this.f[i2][i5], 0, bArr3, 0, i13);
            }
            int i15 = this.G;
            byte[] bArr4 = new byte[i15];
            if (i5 == 0) {
                if (i2 == this.E - 1) {
                    bArr = new WinternitzOTSignature(nextSeed, this.z.get(), this.C[i2]).getPublicKey();
                } else {
                    byte[] bArr5 = new byte[i15];
                    System.arraycopy(this.d[i2], 0, bArr5, 0, i15);
                    this.H.nextSeed(bArr5);
                    byte[] leaf = this.q[i2].getLeaf();
                    this.q[i2].b(bArr5);
                    bArr = leaf;
                }
                System.arraycopy(bArr, 0, this.f[i2][0], 0, this.G);
            } else {
                int i16 = i15 << 1;
                byte[] bArr6 = new byte[i16];
                int i17 = i5 - 1;
                System.arraycopy(this.f[i2][i17], 0, bArr6, 0, i15);
                byte[] bArr7 = this.o[i2][(int) Math.floor((double) (i17 / 2))];
                int i18 = this.G;
                System.arraycopy(bArr7, 0, bArr6, i18, i18);
                this.F.update(bArr6, 0, i16);
                this.f[i2][i5] = new byte[this.F.getDigestSize()];
                this.F.doFinal(this.f[i2][i5], 0);
                for (int i19 = 0; i19 < i5; i19++) {
                    if (i19 < i3) {
                        if (this.i[i2][i19].wasFinished()) {
                            System.arraycopy(this.i[i2][i19].getFirstNode(), 0, this.f[i2][i19], 0, this.G);
                            this.i[i2][i19].destroy();
                        } else {
                            System.err.println(a.S2("Treehash (", i2, ",", i19, ") not finished when needed in AuthPathComputation"));
                        }
                    }
                    if (i19 < i14 && i19 >= i3) {
                        int i20 = i19 - i3;
                        if (this.m[i2][i20].size() > 0) {
                            System.arraycopy(this.m[i2][i20].lastElement(), 0, this.f[i2][i19], 0, this.G);
                            Vector[][] vectorArr = this.m;
                            vectorArr[i2][i20].removeElementAt(vectorArr[i2][i20].size() - 1);
                        }
                    }
                    if (i19 < i3 && ((1 << i19) * 3) + i6 < this.I[i2]) {
                        this.i[i2][i19].initialize();
                    }
                }
            }
            if (i5 < i14 && i12 == 0) {
                System.arraycopy(bArr3, 0, this.o[i2][(int) Math.floor((double) (i5 / 2))], 0, this.G);
            }
            if (i2 == this.E - 1) {
                for (int i21 = 1; i21 <= i3 / 2; i21++) {
                    int a = a(i2);
                    if (a >= 0) {
                        try {
                            byte[] bArr8 = new byte[this.G];
                            System.arraycopy(this.i[i2][a].getSeedActive(), 0, bArr8, 0, this.G);
                            this.i[i2][a].update(this.H, new WinternitzOTSignature(this.H.nextSeed(bArr8), this.z.get(), this.C[i2]).getPublicKey());
                        } catch (Exception e2) {
                            System.out.println(e2);
                        }
                    }
                }
            } else {
                this.s[i2] = a(i2);
            }
            if (i2 > 0) {
                if (i2 > 1) {
                    GMSSLeaf[] gMSSLeafArr = this.p;
                    int i22 = (i2 - 1) - 1;
                    gMSSLeafArr[i22] = gMSSLeafArr[i22].c();
                }
                GMSSLeaf[] gMSSLeafArr2 = this.q;
                int i23 = i2 - 1;
                gMSSLeafArr2[i23] = gMSSLeafArr2[i23].c();
                int floor = (int) Math.floor(((double) (getNumLeafs(i2) * 2)) / ((double) (this.B[i23] - this.D[i23])));
                int[] iArr3 = this.c;
                if (iArr3[i2] % floor == 1) {
                    if (iArr3[i2] > 1 && this.s[i23] >= 0) {
                        try {
                            this.i[i23][this.s[i23]].update(this.H, this.r[i23].getLeaf());
                            this.i[i23][this.s[i23]].wasFinished();
                        } catch (Exception e3) {
                            System.out.println(e3);
                        }
                    }
                    this.s[i23] = a(i23);
                    int[] iArr4 = this.s;
                    if (iArr4[i23] >= 0) {
                        this.r[i23] = new GMSSLeaf(this.z.get(), this.C[i23], floor, this.i[i23][iArr4[i23]].getSeedActive());
                        GMSSLeaf[] gMSSLeafArr3 = this.r;
                        gMSSLeafArr3[i23] = gMSSLeafArr3[i23].c();
                    }
                } else if (this.s[i23] >= 0) {
                    GMSSLeaf[] gMSSLeafArr4 = this.r;
                    gMSSLeafArr4[i23] = gMSSLeafArr4[i23].c();
                }
                this.y[i23].updateSign();
                if (this.c[i2] == 1) {
                    this.w[i23].initialize(new Vector());
                }
                c(i2);
            }
        } else if (i4 != 1) {
            if (i2 > 0) {
                int i24 = i2 - 1;
                iArr2[i24] = iArr2[i24] + 1;
                boolean z2 = true;
                int i25 = i2;
                do {
                    i25--;
                    if (this.c[i25] < this.I[i25]) {
                        z2 = false;
                    }
                    if (!z2) {
                        break;
                    }
                } while (i25 > 0);
                if (!z2) {
                    this.H.nextSeed(this.d[i2]);
                    this.y[i24].updateSign();
                    if (i2 > 1) {
                        GMSSLeaf[] gMSSLeafArr5 = this.p;
                        int i26 = i24 - 1;
                        gMSSLeafArr5[i26] = gMSSLeafArr5[i26].c();
                    }
                    GMSSLeaf[] gMSSLeafArr6 = this.q;
                    gMSSLeafArr6[i24] = gMSSLeafArr6[i24].c();
                    if (this.s[i24] >= 0) {
                        GMSSLeaf[] gMSSLeafArr7 = this.r;
                        gMSSLeafArr7[i24] = gMSSLeafArr7[i24].c();
                        try {
                            this.i[i24][this.s[i24]].update(this.H, this.r[i24].getLeaf());
                            this.i[i24][this.s[i24]].wasFinished();
                        } catch (Exception e4) {
                            System.out.println(e4);
                        }
                    }
                    c(i2);
                    this.x[i24] = this.y[i24].getSig();
                    for (int i27 = 0; i27 < this.B[i2] - this.D[i2]; i27++) {
                        Treehash[] treehashArr = this.i[i2];
                        Treehash[][] treehashArr2 = this.j;
                        treehashArr[i27] = treehashArr2[i24][i27];
                        treehashArr2[i24][i27] = this.w[i24].getTreehash()[i27];
                    }
                    for (int i28 = 0; i28 < this.B[i2]; i28++) {
                        System.arraycopy(this.g[i24][i28], 0, this.f[i2][i28], 0, this.G);
                        System.arraycopy(this.w[i24].getAuthPath()[i28], 0, this.g[i24][i28], 0, this.G);
                    }
                    for (int i29 = 0; i29 < this.D[i2] - 1; i29++) {
                        Vector[] vectorArr2 = this.m[i2];
                        Vector[][] vectorArr3 = this.n;
                        vectorArr2[i29] = vectorArr3[i24][i29];
                        vectorArr3[i24][i29] = this.w[i24].getRetain()[i29];
                    }
                    Vector[] vectorArr4 = this.k;
                    Vector[] vectorArr5 = this.l;
                    vectorArr4[i2] = vectorArr5[i24];
                    vectorArr5[i24] = this.w[i24].getStack();
                    this.v[i24] = this.w[i24].getRoot();
                    int i30 = this.G;
                    byte[] bArr9 = new byte[i30];
                    byte[] bArr10 = new byte[i30];
                    System.arraycopy(this.d[i24], 0, bArr10, 0, i30);
                    this.H.nextSeed(bArr10);
                    this.H.nextSeed(bArr10);
                    this.y[i24].initSign(this.H.nextSeed(bArr10), this.v[i24]);
                    b(i24);
                }
            }
            this.c[i2] = 0;
        }
    }

    public final void c(int i2) {
        byte[] bArr = new byte[this.G];
        int i3 = i2 - 1;
        byte[] nextSeed = this.H.nextSeed(this.e[i3]);
        if (i2 == this.E - 1) {
            this.w[i3].update(this.e[i3], new WinternitzOTSignature(nextSeed, this.z.get(), this.C[i2]).getPublicKey());
            return;
        }
        this.w[i3].update(this.e[i3], this.p[i3].getLeaf());
        this.p[i3].b(this.e[i3]);
    }

    public byte[][][] getCurrentAuthPaths() {
        return Arrays.clone(this.f);
    }

    public byte[][] getCurrentSeeds() {
        return Arrays.clone(this.d);
    }

    public int[] getIndex() {
        return this.c;
    }

    public GMSSDigestProvider getName() {
        return this.z;
    }

    public int getNumLeafs(int i2) {
        return this.I[i2];
    }

    public byte[] getSubtreeRootSig(int i2) {
        return this.x[i2];
    }

    public boolean isUsed() {
        return this.A;
    }

    public void markUsed() {
        this.A = true;
    }

    public GMSSPrivateKeyParameters nextKey() {
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = new GMSSPrivateKeyParameters(this);
        gMSSPrivateKeyParameters.b(this.u.getNumOfLayers() - 1);
        return gMSSPrivateKeyParameters;
    }

    public GMSSPrivateKeyParameters(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        super(true, gMSSParameters);
        this.A = false;
        Digest digest = gMSSDigestProvider.get();
        this.F = digest;
        this.G = digest.getDigestSize();
        this.u = gMSSParameters;
        this.C = gMSSParameters.getWinternitzParameter();
        this.D = gMSSParameters.getK();
        this.B = gMSSParameters.getHeightOfTrees();
        int numOfLayers = this.u.getNumOfLayers();
        this.E = numOfLayers;
        if (iArr == null) {
            this.c = new int[numOfLayers];
            for (int i2 = 0; i2 < this.E; i2++) {
                this.c[i2] = 0;
            }
        } else {
            this.c = iArr;
        }
        this.d = bArr;
        this.e = bArr2;
        this.f = bArr3;
        this.g = bArr4;
        int i3 = 2;
        if (bArr5 == null) {
            this.o = new byte[this.E][][];
            int i4 = 0;
            while (i4 < this.E) {
                byte[][][] bArr8 = this.o;
                int[] iArr3 = new int[2];
                iArr3[1] = this.G;
                iArr3[0] = (int) Math.floor((double) (this.B[i4] / i3));
                bArr8[i4] = (byte[][]) Array.newInstance(byte.class, iArr3);
                i4++;
                i3 = 2;
            }
        } else {
            this.o = bArr5;
        }
        if (vectorArr == null) {
            this.k = new Vector[this.E];
            for (int i5 = 0; i5 < this.E; i5++) {
                this.k[i5] = new Vector();
            }
        } else {
            this.k = vectorArr;
        }
        if (vectorArr2 == null) {
            this.l = new Vector[(this.E - 1)];
            int i6 = 0;
            for (int i7 = 1; i6 < this.E - i7; i7 = 1) {
                this.l[i6] = new Vector();
                i6++;
            }
        } else {
            this.l = vectorArr2;
        }
        this.i = treehashArr;
        this.j = treehashArr2;
        this.m = vectorArr3;
        this.n = vectorArr4;
        this.v = bArr6;
        this.z = gMSSDigestProvider;
        if (gMSSRootCalcArr == null) {
            this.w = new GMSSRootCalc[(this.E - 1)];
            int i8 = 0;
            for (int i9 = 1; i8 < this.E - i9; i9 = 1) {
                int i10 = i8 + 1;
                this.w[i8] = new GMSSRootCalc(this.B[i10], this.D[i10], this.z);
                i8 = i10;
            }
        } else {
            this.w = gMSSRootCalcArr;
        }
        this.x = bArr7;
        this.I = new int[this.E];
        for (int i11 = 0; i11 < this.E; i11++) {
            this.I[i11] = 1 << this.B[i11];
        }
        this.H = new GMSSRandom(this.F);
        int i12 = this.E;
        if (i12 <= 1) {
            this.p = new GMSSLeaf[0];
        } else if (gMSSLeafArr == null) {
            this.p = new GMSSLeaf[(i12 - 2)];
            int i13 = 0;
            while (i13 < this.E - 2) {
                int i14 = i13 + 1;
                this.p[i13] = new GMSSLeaf(gMSSDigestProvider.get(), this.C[i14], this.I[i13 + 2], this.e[i13]);
                i13 = i14;
            }
        } else {
            this.p = gMSSLeafArr;
        }
        if (gMSSLeafArr2 == null) {
            this.q = new GMSSLeaf[(this.E - 1)];
            int i15 = 0;
            for (int i16 = 1; i15 < this.E - i16; i16 = 1) {
                int i17 = i15 + 1;
                this.q[i15] = new GMSSLeaf(gMSSDigestProvider.get(), this.C[i15], this.I[i17], this.d[i15]);
                i15 = i17;
            }
        } else {
            this.q = gMSSLeafArr2;
        }
        if (gMSSLeafArr3 == null) {
            this.r = new GMSSLeaf[(this.E - 1)];
            int i18 = 0;
            for (int i19 = 1; i18 < this.E - i19; i19 = 1) {
                int i20 = i18 + 1;
                this.r[i18] = new GMSSLeaf(gMSSDigestProvider.get(), this.C[i18], this.I[i20]);
                i18 = i20;
            }
        } else {
            this.r = gMSSLeafArr3;
        }
        if (iArr2 == null) {
            this.s = new int[(this.E - 1)];
            int i21 = 0;
            for (int i22 = 1; i21 < this.E - i22; i22 = 1) {
                this.s[i21] = -1;
                i21++;
            }
        } else {
            this.s = iArr2;
        }
        int i23 = this.G;
        byte[] bArr9 = new byte[i23];
        byte[] bArr10 = new byte[i23];
        if (gMSSRootSigArr == null) {
            this.y = new GMSSRootSig[(this.E - 1)];
            int i24 = 0;
            while (i24 < this.E - 1) {
                System.arraycopy(bArr[i24], 0, bArr9, 0, this.G);
                this.H.nextSeed(bArr9);
                byte[] nextSeed = this.H.nextSeed(bArr9);
                int i25 = i24 + 1;
                this.y[i24] = new GMSSRootSig(gMSSDigestProvider.get(), this.C[i24], this.B[i25]);
                this.y[i24].initSign(nextSeed, bArr6[i24]);
                i24 = i25;
            }
            return;
        }
        this.y = gMSSRootSigArr;
    }

    public int getIndex(int i2) {
        return this.c[i2];
    }

    public GMSSPrivateKeyParameters(GMSSPrivateKeyParameters gMSSPrivateKeyParameters) {
        super(true, gMSSPrivateKeyParameters.getParameters());
        this.A = false;
        this.c = Arrays.clone(gMSSPrivateKeyParameters.c);
        this.d = Arrays.clone(gMSSPrivateKeyParameters.d);
        this.e = Arrays.clone(gMSSPrivateKeyParameters.e);
        this.f = Arrays.clone(gMSSPrivateKeyParameters.f);
        this.g = Arrays.clone(gMSSPrivateKeyParameters.g);
        this.i = gMSSPrivateKeyParameters.i;
        this.j = gMSSPrivateKeyParameters.j;
        this.k = gMSSPrivateKeyParameters.k;
        this.l = gMSSPrivateKeyParameters.l;
        this.m = gMSSPrivateKeyParameters.m;
        this.n = gMSSPrivateKeyParameters.n;
        this.o = Arrays.clone(gMSSPrivateKeyParameters.o);
        this.p = gMSSPrivateKeyParameters.p;
        this.q = gMSSPrivateKeyParameters.q;
        this.r = gMSSPrivateKeyParameters.r;
        this.s = gMSSPrivateKeyParameters.s;
        this.u = gMSSPrivateKeyParameters.u;
        this.v = Arrays.clone(gMSSPrivateKeyParameters.v);
        this.w = gMSSPrivateKeyParameters.w;
        this.x = gMSSPrivateKeyParameters.x;
        this.y = gMSSPrivateKeyParameters.y;
        this.z = gMSSPrivateKeyParameters.z;
        this.B = gMSSPrivateKeyParameters.B;
        this.C = gMSSPrivateKeyParameters.C;
        this.D = gMSSPrivateKeyParameters.D;
        this.E = gMSSPrivateKeyParameters.E;
        this.F = gMSSPrivateKeyParameters.F;
        this.G = gMSSPrivateKeyParameters.G;
        this.H = gMSSPrivateKeyParameters.H;
        this.I = gMSSPrivateKeyParameters.I;
    }
}
