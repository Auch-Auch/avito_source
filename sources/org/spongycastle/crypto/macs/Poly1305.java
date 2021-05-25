package org.spongycastle.crypto.macs;

import a2.b.a.a.a;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
public class Poly1305 implements Mac {
    public final BlockCipher a;
    public final byte[] b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final byte[] p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;

    public Poly1305() {
        this.b = new byte[1];
        this.p = new byte[16];
        this.q = 0;
        this.a = null;
    }

    public static final long a(int i2, int i3) {
        return (((long) i2) & BodyPartID.bodyIdMax) * ((long) i3);
    }

    public final void b() {
        int i2 = this.q;
        if (i2 < 16) {
            this.p[i2] = 1;
            for (int i3 = i2 + 1; i3 < 16; i3++) {
                this.p[i3] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.p, 0)) & BodyPartID.bodyIdMax;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.p, 4)) & BodyPartID.bodyIdMax;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.p, 8)) & BodyPartID.bodyIdMax;
        long littleEndianToInt4 = BodyPartID.bodyIdMax & ((long) Pack.littleEndianToInt(this.p, 12));
        int i4 = (int) (((long) this.r) + (littleEndianToInt & 67108863));
        this.r = i4;
        this.s = (int) (((long) this.s) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.t = (int) (((long) this.t) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.u = (int) (((long) this.u) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        int i5 = (int) (((long) this.v) + (littleEndianToInt4 >>> 8));
        this.v = i5;
        if (this.q == 16) {
            this.v = i5 + 16777216;
        }
        long a3 = a(this.v, this.h) + a(this.u, this.i) + a(this.t, this.j) + a(this.s, this.k) + a(i4, this.c);
        long a4 = a(this.v, this.i) + a(this.u, this.j) + a(this.t, this.k) + a(this.s, this.c) + a(this.r, this.d);
        long a5 = a(this.v, this.j) + a(this.u, this.k) + a(this.t, this.c) + a(this.s, this.d) + a(this.r, this.e);
        long a6 = a(this.v, this.k) + a(this.u, this.c) + a(this.t, this.d) + a(this.s, this.e) + a(this.r, this.f);
        long a8 = a(this.v, this.c) + a(this.u, this.d) + a(this.t, this.e) + a(this.s, this.f) + a(this.r, this.g);
        int i6 = ((int) a3) & 67108863;
        this.r = i6;
        long j2 = a4 + (a3 >>> 26);
        int i7 = ((int) j2) & 67108863;
        this.s = i7;
        long j3 = a5 + (j2 >>> 26);
        this.t = ((int) j3) & 67108863;
        long j4 = a6 + (j3 >>> 26);
        this.u = ((int) j4) & 67108863;
        long j5 = a8 + (j4 >>> 26);
        this.v = ((int) j5) & 67108863;
        int i8 = (((int) (j5 >>> 26)) * 5) + i6;
        this.r = i8;
        this.s = i7 + (i8 >>> 26);
        this.r = i8 & 67108863;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i2) throws DataLengthException, IllegalStateException {
        if (i2 + 16 <= bArr.length) {
            if (this.q > 0) {
                b();
            }
            int i3 = this.s;
            int i4 = this.r;
            int i5 = i3 + (i4 >>> 26);
            this.s = i5;
            int i6 = i4 & 67108863;
            this.r = i6;
            int i7 = this.t + (i5 >>> 26);
            this.t = i7;
            int i8 = i5 & 67108863;
            this.s = i8;
            int i9 = this.u + (i7 >>> 26);
            this.u = i9;
            int i10 = i7 & 67108863;
            this.t = i10;
            int i11 = this.v + (i9 >>> 26);
            this.v = i11;
            int i12 = i9 & 67108863;
            this.u = i12;
            int i13 = ((i11 >>> 26) * 5) + i6;
            this.r = i13;
            int i14 = i11 & 67108863;
            this.v = i14;
            int i15 = i8 + (i13 >>> 26);
            this.s = i15;
            int i16 = i13 & 67108863;
            this.r = i16;
            int i17 = i16 + 5;
            int i18 = (i17 >>> 26) + i15;
            int i19 = (i18 >>> 26) + i10;
            int i20 = (i19 >>> 26) + i12;
            int i21 = 67108863 & i20;
            int i22 = ((i20 >>> 26) + i14) - 67108864;
            int i23 = (i22 >>> 31) - 1;
            int i24 = ~i23;
            int i25 = (i16 & i24) | (i17 & 67108863 & i23);
            this.r = i25;
            int i26 = (i15 & i24) | (i18 & 67108863 & i23);
            this.s = i26;
            int i27 = (i10 & i24) | (i19 & 67108863 & i23);
            this.t = i27;
            int i28 = (i21 & i23) | (i12 & i24);
            this.u = i28;
            int i29 = (i14 & i24) | (i22 & i23);
            this.v = i29;
            long j2 = (((long) ((i26 << 26) | i25)) & BodyPartID.bodyIdMax) + (((long) this.l) & BodyPartID.bodyIdMax);
            long j3 = (((long) ((i26 >>> 6) | (i27 << 20))) & BodyPartID.bodyIdMax) + (((long) this.m) & BodyPartID.bodyIdMax);
            long j4 = (((long) ((i27 >>> 12) | (i28 << 14))) & BodyPartID.bodyIdMax) + (((long) this.n) & BodyPartID.bodyIdMax);
            long j5 = (((long) ((i28 >>> 18) | (i29 << 8))) & BodyPartID.bodyIdMax) + (((long) this.o) & BodyPartID.bodyIdMax);
            Pack.intToLittleEndian((int) j2, bArr, i2);
            long j6 = j3 + (j2 >>> 32);
            Pack.intToLittleEndian((int) j6, bArr, i2 + 4);
            long j7 = j4 + (j6 >>> 32);
            Pack.intToLittleEndian((int) j7, bArr, i2 + 8);
            Pack.intToLittleEndian((int) (j5 + (j7 >>> 32)), bArr, i2 + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        if (this.a == null) {
            return "Poly1305";
        }
        StringBuilder L = a.L("Poly1305-");
        L.append(this.a.getAlgorithmName());
        return L.toString();
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        if (this.a == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 32) {
                int i2 = 16;
                if (this.a == null || (bArr != null && bArr.length == 16)) {
                    int littleEndianToInt = Pack.littleEndianToInt(key, 0);
                    int littleEndianToInt2 = Pack.littleEndianToInt(key, 4);
                    int littleEndianToInt3 = Pack.littleEndianToInt(key, 8);
                    int littleEndianToInt4 = Pack.littleEndianToInt(key, 12);
                    this.c = 67108863 & littleEndianToInt;
                    int i3 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
                    this.d = i3;
                    int i4 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
                    this.e = i4;
                    int i5 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
                    this.f = i5;
                    int i6 = (littleEndianToInt4 >>> 8) & 1048575;
                    this.g = i6;
                    this.h = i3 * 5;
                    this.i = i4 * 5;
                    this.j = i5 * 5;
                    this.k = i6 * 5;
                    BlockCipher blockCipher = this.a;
                    if (blockCipher != null) {
                        byte[] bArr2 = new byte[16];
                        blockCipher.init(true, new KeyParameter(key, 16, 16));
                        this.a.processBlock(bArr, 0, bArr2, 0);
                        key = bArr2;
                        i2 = 0;
                    }
                    this.l = Pack.littleEndianToInt(key, i2 + 0);
                    this.m = Pack.littleEndianToInt(key, i2 + 4);
                    this.n = Pack.littleEndianToInt(key, i2 + 8);
                    this.o = Pack.littleEndianToInt(key, i2 + 12);
                    reset();
                    return;
                }
                throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
            }
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.q = 0;
        this.v = 0;
        this.u = 0;
        this.t = 0;
        this.s = 0;
        this.r = 0;
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        byte[] bArr = this.b;
        bArr[0] = b2;
        update(bArr, 0, 1);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        int i4 = 0;
        while (i3 > i4) {
            if (this.q == 16) {
                b();
                this.q = 0;
            }
            int min = Math.min(i3 - i4, 16 - this.q);
            System.arraycopy(bArr, i4 + i2, this.p, this.q, min);
            i4 += min;
            this.q += min;
        }
    }

    public Poly1305(BlockCipher blockCipher) {
        this.b = new byte[1];
        this.p = new byte[16];
        this.q = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.a = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }
}
