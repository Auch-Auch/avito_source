package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.MemoableResetException;
import org.spongycastle.util.Pack;
public class SHA512tDigest extends LongDigest {
    public int h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;

    public SHA512tDigest(int i2) {
        if (i2 >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        } else if (i2 % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        } else if (i2 != 384) {
            int i3 = i2 / 8;
            this.h = i3;
            int i4 = i3 * 8;
            this.H1 = -3482333909917012819L;
            this.H2 = 2216346199247487646L;
            this.H3 = -7364697282686394994L;
            this.H4 = 65953792586715988L;
            this.H5 = -816286391624063116L;
            this.H6 = 4512832404995164602L;
            this.H7 = -5033199132376557362L;
            this.H8 = -124578254951840548L;
            update((byte) 83);
            update((byte) 72);
            update((byte) 65);
            update((byte) 45);
            update((byte) 53);
            update((byte) 49);
            update((byte) 50);
            update((byte) 47);
            if (i4 > 100) {
                update((byte) ((i4 / 100) + 48));
                int i5 = i4 % 100;
                update((byte) ((i5 / 10) + 48));
                update((byte) ((i5 % 10) + 48));
            } else if (i4 > 10) {
                update((byte) ((i4 / 10) + 48));
                update((byte) ((i4 % 10) + 48));
            } else {
                update((byte) (i4 + 48));
            }
            finish();
            this.i = this.H1;
            this.j = this.H2;
            this.k = this.H3;
            this.l = this.H4;
            this.m = this.H5;
            this.n = this.H6;
            this.o = this.H7;
            this.p = this.H8;
            reset();
        } else {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
    }

    public static void f(int i2, byte[] bArr, int i3, int i4) {
        int min = Math.min(4, i4);
        while (true) {
            min--;
            if (min >= 0) {
                bArr[i3 + min] = (byte) (i2 >>> ((3 - min) * 8));
            } else {
                return;
            }
        }
    }

    public static void g(long j2, byte[] bArr, int i2, int i3) {
        if (i3 > 0) {
            f((int) (j2 >>> 32), bArr, i2, i3);
            if (i3 > 4) {
                f((int) (j2 & BodyPartID.bodyIdMax), bArr, i2 + 4, i3 - 4);
            }
        }
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA512tDigest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        g(this.H1, bArr, i2, this.h);
        g(this.H2, bArr, i2 + 8, this.h - 8);
        g(this.H3, bArr, i2 + 16, this.h - 16);
        g(this.H4, bArr, i2 + 24, this.h - 24);
        g(this.H5, bArr, i2 + 32, this.h - 32);
        g(this.H6, bArr, i2 + 40, this.h - 40);
        g(this.H7, bArr, i2 + 48, this.h - 48);
        g(this.H8, bArr, i2 + 56, this.h - 56);
        reset();
        return this.h;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        StringBuilder L = a.L("SHA-512/");
        L.append(Integer.toString(this.h * 8));
        return L.toString();
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.h;
    }

    @Override // org.spongycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        int encodedStateSize = getEncodedStateSize();
        byte[] bArr = new byte[(encodedStateSize + 4)];
        populateState(bArr);
        Pack.intToBigEndian(this.h * 8, bArr, encodedStateSize);
        return bArr;
    }

    @Override // org.spongycastle.crypto.digests.LongDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = this.i;
        this.H2 = this.j;
        this.H3 = this.k;
        this.H4 = this.l;
        this.H5 = this.m;
        this.H6 = this.n;
        this.H7 = this.o;
        this.H8 = this.p;
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA512tDigest sHA512tDigest = (SHA512tDigest) memoable;
        if (this.h == sHA512tDigest.h) {
            super.copyIn(sHA512tDigest);
            this.i = sHA512tDigest.i;
            this.j = sHA512tDigest.j;
            this.k = sHA512tDigest.k;
            this.l = sHA512tDigest.l;
            this.m = sHA512tDigest.m;
            this.n = sHA512tDigest.n;
            this.o = sHA512tDigest.o;
            this.p = sHA512tDigest.p;
            return;
        }
        throw new MemoableResetException("digestLength inappropriate in other");
    }

    public SHA512tDigest(SHA512tDigest sHA512tDigest) {
        super(sHA512tDigest);
        this.h = sHA512tDigest.h;
        reset(sHA512tDigest);
    }

    public SHA512tDigest(byte[] bArr) {
        this(Pack.bigEndianToInt(bArr, bArr.length - 4));
        restoreState(bArr);
    }
}
