package org.spongycastle.crypto.modes;

import a2.b.a.a.a;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.gcm.GCMExponentiator;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.modes.gcm.GCMUtil;
import org.spongycastle.crypto.modes.gcm.Tables1kGCMExponentiator;
import org.spongycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
public class GCMBlockCipher implements AEADBlockCipher {
    public BlockCipher a;
    public GCMMultiplier b;
    public GCMExponentiator c;
    public boolean d;
    public boolean e;
    public int f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public byte[] m;
    public byte[] n;
    public byte[] o;
    public byte[] p;
    public byte[] q;
    public int r;
    public int s;
    public long t;
    public byte[] u;
    public int v;
    public long w;
    public long x;

    public GCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, null);
    }

    public final void a() {
        if (this.e) {
            return;
        }
        if (this.d) {
            throw new IllegalStateException("GCM cipher cannot be reused for encryption");
        }
        throw new IllegalStateException("GCM cipher needs to be initialised");
    }

    public final void b(byte[] bArr, byte[] bArr2) {
        GCMUtil.xor(bArr, bArr2);
        this.b.multiplyH(bArr);
    }

    public final void c(byte[] bArr, byte[] bArr2, int i2, int i3) {
        GCMUtil.xor(bArr, bArr2, i2, i3);
        this.b.multiplyH(bArr);
    }

    public final byte[] d() {
        int i2 = this.r;
        if (i2 != 0) {
            this.r = i2 - 1;
            byte[] bArr = this.q;
            int i3 = (bArr[15] & 255) + 1;
            bArr[15] = (byte) i3;
            int i4 = (i3 >>> 8) + (bArr[14] & 255);
            bArr[14] = (byte) i4;
            int i5 = (i4 >>> 8) + (bArr[13] & 255);
            bArr[13] = (byte) i5;
            bArr[12] = (byte) ((i5 >>> 8) + (bArr[12] & 255));
            byte[] bArr2 = new byte[16];
            this.a.processBlock(bArr, 0, bArr2, 0);
            return bArr2;
        }
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i2) throws IllegalStateException, InvalidCipherTextException {
        a();
        if (this.t == 0) {
            e();
        }
        int i3 = this.s;
        if (!this.d) {
            int i4 = this.f;
            if (i3 >= i4) {
                i3 -= i4;
                if (bArr.length < i2 + i3) {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else if (bArr.length < i2 + i3 + this.f) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i3 > 0) {
            byte[] bArr2 = this.l;
            byte[] d2 = d();
            GCMUtil.xor(d2, bArr2, 0, i3);
            System.arraycopy(d2, 0, bArr, i2, i3);
            byte[] bArr3 = this.n;
            if (this.d) {
                bArr2 = d2;
            }
            c(bArr3, bArr2, 0, i3);
            this.t += (long) i3;
        }
        long j2 = this.w;
        int i5 = this.v;
        long j3 = j2 + ((long) i5);
        this.w = j3;
        if (j3 > this.x) {
            if (i5 > 0) {
                c(this.o, this.u, 0, i5);
            }
            if (this.x > 0) {
                GCMUtil.xor(this.o, this.p);
            }
            long j4 = ((this.t * 8) + 127) >>> 7;
            byte[] bArr4 = new byte[16];
            if (this.c == null) {
                Tables1kGCMExponentiator tables1kGCMExponentiator = new Tables1kGCMExponentiator();
                this.c = tables1kGCMExponentiator;
                tables1kGCMExponentiator.init(this.j);
            }
            this.c.exponentiateX(j4, bArr4);
            GCMUtil.multiply(this.o, bArr4);
            GCMUtil.xor(this.n, this.o);
        }
        byte[] bArr5 = new byte[16];
        Pack.longToBigEndian(this.w * 8, bArr5, 0);
        Pack.longToBigEndian(this.t * 8, bArr5, 8);
        b(this.n, bArr5);
        byte[] bArr6 = new byte[16];
        this.a.processBlock(this.k, 0, bArr6, 0);
        GCMUtil.xor(bArr6, this.n);
        int i6 = this.f;
        byte[] bArr7 = new byte[i6];
        this.m = bArr7;
        System.arraycopy(bArr6, 0, bArr7, 0, i6);
        if (this.d) {
            System.arraycopy(this.m, 0, bArr, i2 + this.s, this.f);
            i3 += this.f;
        } else {
            int i7 = this.f;
            byte[] bArr8 = new byte[i7];
            System.arraycopy(this.l, i3, bArr8, 0, i7);
            if (!Arrays.constantTimeAreEqual(this.m, bArr8)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        g(false);
        return i3;
    }

    public final void e() {
        if (this.w > 0) {
            System.arraycopy(this.o, 0, this.p, 0, 16);
            this.x = this.w;
        }
        int i2 = this.v;
        if (i2 > 0) {
            c(this.p, this.u, 0, i2);
            this.x += (long) this.v;
        }
        if (this.x > 0) {
            System.arraycopy(this.p, 0, this.n, 0, 16);
        }
    }

    public final void f(byte[] bArr, int i2) {
        if (bArr.length >= i2 + 16) {
            if (this.t == 0) {
                e();
            }
            byte[] bArr2 = this.l;
            byte[] d2 = d();
            GCMUtil.xor(d2, bArr2);
            System.arraycopy(d2, 0, bArr, i2, 16);
            byte[] bArr3 = this.n;
            if (this.d) {
                bArr2 = d2;
            }
            b(bArr3, bArr2);
            this.t += 16;
            if (this.d) {
                this.s = 0;
                return;
            }
            byte[] bArr4 = this.l;
            System.arraycopy(bArr4, 16, bArr4, 0, this.f);
            this.s = this.f;
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    public final void g(boolean z) {
        this.a.reset();
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.q = Arrays.clone(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0;
        byte[] bArr = this.l;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        if (z) {
            this.m = null;
        }
        if (this.d) {
            this.e = false;
            return;
        }
        byte[] bArr2 = this.i;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/GCM";
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        byte[] bArr = this.m;
        if (bArr == null) {
            return new byte[this.f];
        }
        return Arrays.clone(bArr);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i2) {
        int i3 = i2 + this.s;
        if (this.d) {
            return i3 + this.f;
        }
        int i4 = this.f;
        if (i3 < i4) {
            return 0;
        }
        return i3 - i4;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i2) {
        int i3 = i2 + this.s;
        if (!this.d) {
            int i4 = this.f;
            if (i3 < i4) {
                return 0;
            }
            i3 -= i4;
        }
        return i3 - (i3 % 16);
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        this.d = z;
        this.m = null;
        this.e = true;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.i = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 32 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException(a.M2("Invalid value for MAC size: ", macSize));
            }
            this.f = macSize / 8;
            keyParameter = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            this.i = null;
            this.f = 16;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        if (z) {
            i2 = 16;
        } else {
            i2 = this.f + 16;
        }
        this.l = new byte[i2];
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z && (bArr2 = this.h) != null && Arrays.areEqual(bArr2, bArr)) {
            if (keyParameter != null) {
                byte[] bArr3 = this.g;
                if (bArr3 != null && Arrays.areEqual(bArr3, keyParameter.getKey())) {
                    throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
                }
            } else {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.h = bArr;
        if (keyParameter != null) {
            this.g = keyParameter.getKey();
        }
        if (keyParameter != null) {
            this.a.init(true, keyParameter);
            byte[] bArr4 = new byte[16];
            this.j = bArr4;
            this.a.processBlock(bArr4, 0, bArr4, 0);
            this.b.init(this.j);
            this.c = null;
        } else if (this.j == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr5 = new byte[16];
        this.k = bArr5;
        byte[] bArr6 = this.h;
        if (bArr6.length == 12) {
            System.arraycopy(bArr6, 0, bArr5, 0, bArr6.length);
            this.k[15] = 1;
        } else {
            int length = bArr6.length;
            for (int i3 = 0; i3 < length; i3 += 16) {
                c(bArr5, bArr6, i3, Math.min(length - i3, 16));
            }
            byte[] bArr7 = new byte[16];
            Pack.longToBigEndian(((long) this.h.length) * 8, bArr7, 8);
            b(this.k, bArr7);
        }
        this.n = new byte[16];
        this.o = new byte[16];
        this.p = new byte[16];
        this.u = new byte[16];
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.q = Arrays.clone(this.k);
        this.r = -2;
        this.s = 0;
        this.t = 0;
        byte[] bArr8 = this.i;
        if (bArr8 != null) {
            processAADBytes(bArr8, 0, bArr8.length);
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b2) {
        a();
        byte[] bArr = this.u;
        int i2 = this.v;
        bArr[i2] = b2;
        int i3 = i2 + 1;
        this.v = i3;
        if (i3 == 16) {
            b(this.o, bArr);
            this.v = 0;
            this.w += 16;
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i2, int i3) {
        a();
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.u;
            int i5 = this.v;
            bArr2[i5] = bArr[i2 + i4];
            int i6 = i5 + 1;
            this.v = i6;
            if (i6 == 16) {
                b(this.o, bArr2);
                this.v = 0;
                this.w += 16;
            }
        }
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b2, byte[] bArr, int i2) throws DataLengthException {
        a();
        byte[] bArr2 = this.l;
        int i3 = this.s;
        bArr2[i3] = b2;
        int i4 = i3 + 1;
        this.s = i4;
        if (i4 != bArr2.length) {
            return 0;
        }
        f(bArr, i2);
        return 16;
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        a();
        if (bArr.length >= i2 + i3) {
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                byte[] bArr3 = this.l;
                int i7 = this.s;
                bArr3[i7] = bArr[i2 + i6];
                int i8 = i7 + 1;
                this.s = i8;
                if (i8 == bArr3.length) {
                    f(bArr2, i4 + i5);
                    i5 += 16;
                }
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.spongycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        g(true);
    }

    public GCMBlockCipher(BlockCipher blockCipher, GCMMultiplier gCMMultiplier) {
        if (blockCipher.getBlockSize() == 16) {
            gCMMultiplier = gCMMultiplier == null ? new Tables8kGCMMultiplier() : gCMMultiplier;
            this.a = blockCipher;
            this.b = gCMMultiplier;
            return;
        }
        throw new IllegalArgumentException("cipher required with a block size of 16.");
    }
}
