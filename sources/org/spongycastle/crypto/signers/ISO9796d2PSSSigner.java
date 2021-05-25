package org.spongycastle.crypto.signers;

import a2.b.a.a.a;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSalt;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;
public class ISO9796d2PSSSigner implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    public Digest a;
    public AsymmetricBlockCipher b;
    public SecureRandom c;
    public byte[] d;
    public int e;
    public int f;
    public int g;
    public byte[] h;
    public byte[] i;
    public int j;
    public int k;
    public boolean l;
    public byte[] m;
    public byte[] n;
    public byte[] o;
    public int p;
    public int q;

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i2, boolean z) {
        this.b = asymmetricBlockCipher;
        this.a = digest;
        this.e = digest.getDigestSize();
        this.k = i2;
        if (z) {
            this.f = 188;
            return;
        }
        Integer trailer = ISOTrailers.getTrailer(digest);
        if (trailer != null) {
            this.f = trailer.intValue();
            return;
        }
        StringBuilder L = a.L("no valid trailer for digest: ");
        L.append(digest.getAlgorithmName());
        throw new IllegalArgumentException(L.toString());
    }

    public final void a(int i2, byte[] bArr) {
        bArr[0] = (byte) (i2 >>> 24);
        bArr[1] = (byte) (i2 >>> 16);
        bArr[2] = (byte) (i2 >>> 8);
        bArr[3] = (byte) (i2 >>> 0);
    }

    public final void b(long j2, byte[] bArr) {
        bArr[0] = (byte) ((int) (j2 >>> 56));
        bArr[1] = (byte) ((int) (j2 >>> 48));
        bArr[2] = (byte) ((int) (j2 >>> 40));
        bArr[3] = (byte) ((int) (j2 >>> 32));
        bArr[4] = (byte) ((int) (j2 >>> 24));
        bArr[5] = (byte) ((int) (j2 >>> 16));
        bArr[6] = (byte) ((int) (j2 >>> 8));
        bArr[7] = (byte) ((int) (j2 >>> 0));
    }

    public final void c(byte[] bArr) {
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr[i2] = 0;
        }
    }

    public final byte[] d(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        byte[] bArr2 = new byte[i4];
        byte[] bArr3 = new byte[this.e];
        byte[] bArr4 = new byte[4];
        this.a.reset();
        int i6 = 0;
        while (true) {
            i5 = this.e;
            if (i6 >= i4 / i5) {
                break;
            }
            a(i6, bArr4);
            this.a.update(bArr, i2, i3);
            this.a.update(bArr4, 0, 4);
            this.a.doFinal(bArr3, 0);
            int i7 = this.e;
            System.arraycopy(bArr3, 0, bArr2, i6 * i7, i7);
            i6++;
        }
        if (i5 * i6 < i4) {
            a(i6, bArr4);
            this.a.update(bArr, i2, i3);
            this.a.update(bArr4, 0, 4);
            this.a.doFinal(bArr3, 0);
            int i8 = i6 * this.e;
            System.arraycopy(bArr3, 0, bArr2, i8, i4 - i8);
        }
        return bArr2;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        int digestSize = this.a.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.a.doFinal(bArr, 0);
        byte[] bArr2 = new byte[8];
        b((long) (this.j * 8), bArr2);
        this.a.update(bArr2, 0, 8);
        this.a.update(this.i, 0, this.j);
        this.a.update(bArr, 0, digestSize);
        byte[] bArr3 = this.d;
        if (bArr3 == null) {
            bArr3 = new byte[this.k];
            this.c.nextBytes(bArr3);
        }
        this.a.update(bArr3, 0, bArr3.length);
        int digestSize2 = this.a.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.a.doFinal(bArr4, 0);
        boolean z = true;
        int i2 = this.f == 188 ? 1 : 2;
        byte[] bArr5 = this.h;
        int length = bArr5.length;
        int i3 = this.j;
        int length2 = ((((length - i3) - bArr3.length) - this.e) - i2) - 1;
        bArr5[length2] = 1;
        int i4 = length2 + 1;
        System.arraycopy(this.i, 0, bArr5, i4, i3);
        System.arraycopy(bArr3, 0, this.h, i4 + this.j, bArr3.length);
        byte[] d2 = d(bArr4, 0, digestSize2, (this.h.length - this.e) - i2);
        for (int i5 = 0; i5 != d2.length; i5++) {
            byte[] bArr6 = this.h;
            bArr6[i5] = (byte) (bArr6[i5] ^ d2[i5]);
        }
        byte[] bArr7 = this.h;
        int length3 = bArr7.length;
        int i6 = this.e;
        System.arraycopy(bArr4, 0, bArr7, (length3 - i6) - i2, i6);
        int i7 = this.f;
        if (i7 == 188) {
            byte[] bArr8 = this.h;
            bArr8[bArr8.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr9 = this.h;
            bArr9[bArr9.length - 2] = (byte) (i7 >>> 8);
            bArr9[bArr9.length - 1] = (byte) i7;
        }
        byte[] bArr10 = this.h;
        bArr10[0] = (byte) (bArr10[0] & Byte.MAX_VALUE);
        byte[] processBlock = this.b.processBlock(bArr10, 0, bArr10.length);
        int i8 = this.j;
        byte[] bArr11 = new byte[i8];
        this.m = bArr11;
        byte[] bArr12 = this.i;
        if (i8 > bArr12.length) {
            z = false;
        }
        this.l = z;
        System.arraycopy(bArr12, 0, bArr11, 0, bArr11.length);
        c(this.i);
        c(this.h);
        this.j = 0;
        return processBlock;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.m;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.l;
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters;
        int i2 = this.k;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            rSAKeyParameters = (RSAKeyParameters) parametersWithRandom.getParameters();
            if (z) {
                this.c = parametersWithRandom.getRandom();
            }
        } else if (cipherParameters instanceof ParametersWithSalt) {
            ParametersWithSalt parametersWithSalt = (ParametersWithSalt) cipherParameters;
            rSAKeyParameters = (RSAKeyParameters) parametersWithSalt.getParameters();
            byte[] salt = parametersWithSalt.getSalt();
            this.d = salt;
            i2 = salt.length;
            if (salt.length != this.k) {
                throw new IllegalArgumentException("Fixed salt is of wrong length");
            }
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters;
            if (z) {
                this.c = new SecureRandom();
            }
        }
        this.b.init(z, rSAKeyParameters);
        int bitLength = rSAKeyParameters.getModulus().bitLength();
        this.g = bitLength;
        byte[] bArr = new byte[((bitLength + 7) / 8)];
        this.h = bArr;
        if (this.f == 188) {
            this.i = new byte[((((bArr.length - this.a.getDigestSize()) - i2) - 1) - 1)];
        } else {
            this.i = new byte[((((bArr.length - this.a.getDigestSize()) - i2) - 1) - 2)];
        }
        reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.a.reset();
        this.j = 0;
        byte[] bArr = this.i;
        if (bArr != null) {
            c(bArr);
        }
        byte[] bArr2 = this.m;
        if (bArr2 != null) {
            c(bArr2);
            this.m = null;
        }
        this.l = false;
        if (this.n != null) {
            this.n = null;
            c(this.o);
            this.o = null;
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        if (this.n == null) {
            int i2 = this.j;
            byte[] bArr = this.i;
            if (i2 < bArr.length) {
                this.j = i2 + 1;
                bArr[i2] = b2;
                return;
            }
        }
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.b.processBlock(bArr, 0, bArr.length);
        int length = processBlock.length;
        int i2 = this.g;
        if (length < (i2 + 7) / 8) {
            int i3 = (i2 + 7) / 8;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(processBlock, 0, bArr2, i3 - processBlock.length, processBlock.length);
            c(processBlock);
            processBlock = bArr2;
        }
        boolean z = true;
        int i4 = 2;
        if (((processBlock[processBlock.length - 1] & 255) ^ 188) == 0) {
            i4 = 1;
        } else {
            int i5 = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
            Integer trailer = ISOTrailers.getTrailer(this.a);
            if (trailer == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            } else if (i5 != trailer.intValue()) {
                throw new IllegalStateException(a.M2("signer initialised with wrong digest for trailer ", i5));
            }
        }
        this.a.doFinal(new byte[this.e], 0);
        int length2 = processBlock.length;
        int i6 = this.e;
        byte[] d2 = d(processBlock, (length2 - i6) - i4, i6, (processBlock.length - i6) - i4);
        for (int i7 = 0; i7 != d2.length; i7++) {
            processBlock[i7] = (byte) (processBlock[i7] ^ d2[i7]);
        }
        processBlock[0] = (byte) (processBlock[0] & Byte.MAX_VALUE);
        int i8 = 0;
        while (i8 != processBlock.length && processBlock[i8] != 1) {
            i8++;
        }
        int i9 = i8 + 1;
        if (i9 >= processBlock.length) {
            c(processBlock);
        }
        if (i9 <= 1) {
            z = false;
        }
        this.l = z;
        byte[] bArr3 = new byte[((d2.length - i9) - this.k)];
        this.m = bArr3;
        System.arraycopy(processBlock, i9, bArr3, 0, bArr3.length);
        byte[] bArr4 = this.m;
        System.arraycopy(bArr4, 0, this.i, 0, bArr4.length);
        this.n = bArr;
        this.o = processBlock;
        this.p = i9;
        this.q = i4;
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        int i2 = this.e;
        byte[] bArr2 = new byte[i2];
        this.a.doFinal(bArr2, 0);
        byte[] bArr3 = this.n;
        if (bArr3 == null) {
            try {
                updateWithRecoveredMessage(bArr);
            } catch (Exception unused) {
                return false;
            }
        } else if (!Arrays.areEqual(bArr3, bArr)) {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        byte[] bArr4 = this.o;
        int i3 = this.p;
        int i4 = this.q;
        this.n = null;
        this.o = null;
        byte[] bArr5 = new byte[8];
        b((long) (this.m.length * 8), bArr5);
        this.a.update(bArr5, 0, 8);
        byte[] bArr6 = this.m;
        if (bArr6.length != 0) {
            this.a.update(bArr6, 0, bArr6.length);
        }
        this.a.update(bArr2, 0, i2);
        byte[] bArr7 = this.d;
        if (bArr7 != null) {
            this.a.update(bArr7, 0, bArr7.length);
        } else {
            this.a.update(bArr4, i3 + this.m.length, this.k);
        }
        int digestSize = this.a.getDigestSize();
        byte[] bArr8 = new byte[digestSize];
        this.a.doFinal(bArr8, 0);
        int length = (bArr4.length - i4) - digestSize;
        boolean z = true;
        for (int i5 = 0; i5 != digestSize; i5++) {
            if (bArr8[i5] != bArr4[length + i5]) {
                z = false;
            }
        }
        c(bArr4);
        c(bArr8);
        if (!z) {
            this.l = false;
            this.j = 0;
            c(this.m);
            return false;
        }
        int i6 = this.j;
        if (i6 != 0) {
            byte[] bArr9 = this.i;
            byte[] bArr10 = this.m;
            boolean z2 = i6 == bArr10.length;
            for (int i7 = 0; i7 != bArr10.length; i7++) {
                if (bArr9[i7] != bArr10[i7]) {
                    z2 = false;
                }
            }
            if (!z2) {
                this.j = 0;
                c(this.i);
                return false;
            }
        }
        this.j = 0;
        c(this.i);
        return true;
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i2, int i3) {
        if (this.n == null) {
            while (i3 > 0 && this.j < this.i.length) {
                update(bArr[i2]);
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.a.update(bArr, i2, i3);
        }
    }

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i2) {
        this(asymmetricBlockCipher, digest, i2, false);
    }
}
