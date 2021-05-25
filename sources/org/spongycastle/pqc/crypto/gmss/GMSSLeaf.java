package org.spongycastle.pqc.crypto.gmss;

import a2.b.a.a.a;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;
public class GMSSLeaf {
    public Digest a;
    public int b;
    public int c;
    public GMSSRandom d;
    public byte[] e;
    public byte[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public byte[] l;
    public byte[] m;

    public GMSSLeaf(Digest digest, byte[][] bArr, int[] iArr) {
        this.g = iArr[0];
        this.h = iArr[1];
        this.k = iArr[2];
        this.j = iArr[3];
        this.a = digest;
        this.d = new GMSSRandom(digest);
        int digestSize = this.a.getDigestSize();
        this.b = digestSize;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / ((double) this.j));
        this.c = ceil + ((int) Math.ceil(((double) a((ceil << this.j) + 1)) / ((double) this.j)));
        this.i = 1 << this.j;
        this.m = bArr[0];
        this.l = bArr[1];
        this.f = bArr[2];
        this.e = bArr[3];
    }

    public final int a(int i2) {
        int i3 = 1;
        int i4 = 2;
        while (i4 < i2) {
            i4 <<= 1;
            i3++;
        }
        return i3;
    }

    public void b(byte[] bArr) {
        this.g = 0;
        this.h = 0;
        byte[] bArr2 = new byte[this.b];
        System.arraycopy(bArr, 0, bArr2, 0, this.l.length);
        this.l = this.d.nextSeed(bArr2);
    }

    public GMSSLeaf c() {
        GMSSLeaf gMSSLeaf = new GMSSLeaf(this);
        byte[] bArr = new byte[gMSSLeaf.a.getDigestSize()];
        for (int i2 = 0; i2 < gMSSLeaf.k + 10000; i2++) {
            int i3 = gMSSLeaf.g;
            if (i3 == gMSSLeaf.c && gMSSLeaf.h == gMSSLeaf.i - 1) {
                Digest digest = gMSSLeaf.a;
                byte[] bArr2 = gMSSLeaf.f;
                digest.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[gMSSLeaf.a.getDigestSize()];
                gMSSLeaf.e = bArr3;
                gMSSLeaf.a.doFinal(bArr3, 0);
                return gMSSLeaf;
            }
            if (i3 == 0 || gMSSLeaf.h == gMSSLeaf.i - 1) {
                gMSSLeaf.g = i3 + 1;
                gMSSLeaf.h = 0;
                gMSSLeaf.m = gMSSLeaf.d.nextSeed(gMSSLeaf.l);
            } else {
                Digest digest2 = gMSSLeaf.a;
                byte[] bArr4 = gMSSLeaf.m;
                digest2.update(bArr4, 0, bArr4.length);
                gMSSLeaf.m = bArr;
                gMSSLeaf.a.doFinal(bArr, 0);
                int i4 = gMSSLeaf.h + 1;
                gMSSLeaf.h = i4;
                if (i4 == gMSSLeaf.i - 1) {
                    byte[] bArr5 = gMSSLeaf.m;
                    byte[] bArr6 = gMSSLeaf.f;
                    int i5 = gMSSLeaf.b;
                    System.arraycopy(bArr5, 0, bArr6, (gMSSLeaf.g - 1) * i5, i5);
                }
            }
        }
        StringBuilder L = a.L("unable to updateLeaf in steps: ");
        L.append(gMSSLeaf.k);
        L.append(" ");
        L.append(gMSSLeaf.g);
        L.append(" ");
        L.append(gMSSLeaf.h);
        throw new IllegalStateException(L.toString());
    }

    public byte[] getLeaf() {
        return Arrays.clone(this.e);
    }

    public byte[][] getStatByte() {
        int i2 = this.b;
        byte[][] bArr = {new byte[i2], new byte[i2], new byte[(this.c * i2)], new byte[i2]};
        bArr[0] = this.m;
        bArr[1] = this.l;
        bArr[2] = this.f;
        bArr[3] = this.e;
        return bArr;
    }

    public int[] getStatInt() {
        return new int[]{this.g, this.h, this.k, this.j};
    }

    public String toString() {
        String str = "";
        for (int i2 = 0; i2 < 4; i2++) {
            str = a.j(a.L(str), getStatInt()[i2], " ");
        }
        StringBuilder Q = a.Q(str, " ");
        Q.append(this.b);
        Q.append(" ");
        Q.append(this.c);
        Q.append(" ");
        String j2 = a.j(Q, this.i, " ");
        byte[][] statByte = getStatByte();
        for (int i3 = 0; i3 < 4; i3++) {
            if (statByte[i3] != null) {
                j2 = a.t(a.L(j2), new String(Hex.encode(statByte[i3])), " ");
            } else {
                j2 = a.c3(j2, "null ");
            }
        }
        return j2;
    }

    public GMSSLeaf(Digest digest, int i2, int i3) {
        this.j = i2;
        this.a = digest;
        this.d = new GMSSRandom(digest);
        int digestSize = this.a.getDigestSize();
        this.b = digestSize;
        double d2 = (double) i2;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d2);
        int ceil2 = ceil + ((int) Math.ceil(((double) a((ceil << i2) + 1)) / d2));
        this.c = ceil2;
        int i4 = 1 << i2;
        this.i = i4;
        this.k = (int) Math.ceil(((double) ((((i4 - 1) * ceil2) + 1) + ceil2)) / ((double) i3));
        int i5 = this.b;
        this.l = new byte[i5];
        this.e = new byte[i5];
        this.m = new byte[i5];
        this.f = new byte[(i5 * this.c)];
    }

    public GMSSLeaf(Digest digest, int i2, int i3, byte[] bArr) {
        this.j = i2;
        this.a = digest;
        this.d = new GMSSRandom(digest);
        int digestSize = this.a.getDigestSize();
        this.b = digestSize;
        double d2 = (double) i2;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d2);
        int ceil2 = ceil + ((int) Math.ceil(((double) a((ceil << i2) + 1)) / d2));
        this.c = ceil2;
        int i4 = 1 << i2;
        this.i = i4;
        this.k = (int) Math.ceil(((double) ((((i4 - 1) * ceil2) + 1) + ceil2)) / ((double) i3));
        int i5 = this.b;
        this.l = new byte[i5];
        this.e = new byte[i5];
        this.m = new byte[i5];
        this.f = new byte[(i5 * this.c)];
        b(bArr);
    }

    public GMSSLeaf(GMSSLeaf gMSSLeaf) {
        this.a = gMSSLeaf.a;
        this.b = gMSSLeaf.b;
        this.c = gMSSLeaf.c;
        this.d = gMSSLeaf.d;
        this.e = Arrays.clone(gMSSLeaf.e);
        this.f = Arrays.clone(gMSSLeaf.f);
        this.g = gMSSLeaf.g;
        this.h = gMSSLeaf.h;
        this.i = gMSSLeaf.i;
        this.j = gMSSLeaf.j;
        this.k = gMSSLeaf.k;
        this.l = Arrays.clone(gMSSLeaf.l);
        this.m = Arrays.clone(gMSSLeaf.m);
    }
}
