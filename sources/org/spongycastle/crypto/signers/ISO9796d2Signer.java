package org.spongycastle.crypto.signers;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;
public class ISO9796d2Signer implements SignerWithRecovery {
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
    public int c;
    public int d;
    public byte[] e;
    public byte[] f;
    public int g;
    public boolean h;
    public byte[] i;
    public byte[] j;
    public byte[] k;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        this.b = asymmetricBlockCipher;
        this.a = digest;
        if (z) {
            this.c = 188;
            return;
        }
        Integer trailer = ISOTrailers.getTrailer(digest);
        if (trailer != null) {
            this.c = trailer.intValue();
            return;
        }
        StringBuilder L = a.L("no valid trailer for digest: ");
        L.append(digest.getAlgorithmName());
        throw new IllegalArgumentException(L.toString());
    }

    public final void a(byte[] bArr) {
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr[i2] = 0;
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        int i2;
        int i3;
        int i4;
        byte b2;
        int digestSize = this.a.getDigestSize();
        boolean z = true;
        if (this.c == 188) {
            byte[] bArr = this.e;
            i2 = (bArr.length - digestSize) - 1;
            this.a.doFinal(bArr, i2);
            byte[] bArr2 = this.e;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i3 = 8;
        } else {
            i3 = 16;
            byte[] bArr3 = this.e;
            int length = (bArr3.length - digestSize) - 2;
            this.a.doFinal(bArr3, length);
            byte[] bArr4 = this.e;
            int i5 = this.c;
            bArr4[bArr4.length - 2] = (byte) (i5 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i5;
            i2 = length;
        }
        int i6 = this.g;
        int i7 = ((((digestSize + i6) * 8) + i3) + 4) - this.d;
        if (i7 > 0) {
            int i8 = i6 - ((i7 + 7) / 8);
            b2 = 96;
            i4 = i2 - i8;
            System.arraycopy(this.f, 0, this.e, i4, i8);
            this.i = new byte[i8];
        } else {
            b2 = SignedBytes.MAX_POWER_OF_TWO;
            i4 = i2 - i6;
            System.arraycopy(this.f, 0, this.e, i4, i6);
            this.i = new byte[this.g];
        }
        int i9 = i4 - 1;
        if (i9 > 0) {
            for (int i10 = i9; i10 != 0; i10--) {
                this.e[i10] = -69;
            }
            byte[] bArr5 = this.e;
            bArr5[i9] = (byte) (bArr5[i9] ^ 1);
            bArr5[0] = Ascii.VT;
            bArr5[0] = (byte) (bArr5[0] | b2);
        } else {
            byte[] bArr6 = this.e;
            bArr6[0] = 10;
            bArr6[0] = (byte) (bArr6[0] | b2);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.b;
        byte[] bArr7 = this.e;
        byte[] processBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        if ((b2 & 32) != 0) {
            z = false;
        }
        this.h = z;
        byte[] bArr8 = this.f;
        byte[] bArr9 = this.i;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.g = 0;
        a(this.f);
        a(this.e);
        return processBlock;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.i;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.h;
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.b.init(z, rSAKeyParameters);
        int bitLength = rSAKeyParameters.getModulus().bitLength();
        this.d = bitLength;
        byte[] bArr = new byte[((bitLength + 7) / 8)];
        this.e = bArr;
        if (this.c == 188) {
            this.f = new byte[((bArr.length - this.a.getDigestSize()) - 2)];
        } else {
            this.f = new byte[((bArr.length - this.a.getDigestSize()) - 3)];
        }
        reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.a.reset();
        this.g = 0;
        a(this.f);
        byte[] bArr = this.i;
        if (bArr != null) {
            a(bArr);
        }
        this.i = null;
        this.h = false;
        if (this.j != null) {
            this.j = null;
            a(this.k);
            this.k = null;
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.a.update(b2);
        int i2 = this.g;
        byte[] bArr = this.f;
        if (i2 < bArr.length) {
            bArr[i2] = b2;
        }
        this.g = i2 + 1;
    }

    @Override // org.spongycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.b.processBlock(bArr, 0, bArr.length);
        if (((processBlock[0] & 192) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        } else if (((processBlock[processBlock.length - 1] & Ascii.SI) ^ 12) == 0) {
            int i2 = 2;
            if (((processBlock[processBlock.length - 1] & 255) ^ 188) == 0) {
                i2 = 1;
            } else {
                int i3 = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                Integer trailer = ISOTrailers.getTrailer(this.a);
                if (trailer == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                } else if (i3 != trailer.intValue()) {
                    throw new IllegalStateException(a.M2("signer initialised with wrong digest for trailer ", i3));
                }
            }
            int i4 = 0;
            while (i4 != processBlock.length && ((processBlock[i4] & Ascii.SI) ^ 10) != 0) {
                i4++;
            }
            int i5 = i4 + 1;
            int length = ((processBlock.length - i2) - this.a.getDigestSize()) - i5;
            if (length > 0) {
                if ((processBlock[0] & 32) == 0) {
                    this.h = true;
                    byte[] bArr2 = new byte[length];
                    this.i = bArr2;
                    System.arraycopy(processBlock, i5, bArr2, 0, bArr2.length);
                } else {
                    this.h = false;
                    byte[] bArr3 = new byte[length];
                    this.i = bArr3;
                    System.arraycopy(processBlock, i5, bArr3, 0, bArr3.length);
                }
                this.j = bArr;
                this.k = processBlock;
                Digest digest = this.a;
                byte[] bArr4 = this.i;
                digest.update(bArr4, 0, bArr4.length);
                byte[] bArr5 = this.i;
                this.g = bArr5.length;
                System.arraycopy(bArr5, 0, this.f, 0, bArr5.length);
                return;
            }
            throw new InvalidCipherTextException("malformed block");
        } else {
            throw new InvalidCipherTextException("malformed signature");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        boolean z;
        byte[] bArr3 = this.j;
        if (bArr3 == null) {
            try {
                bArr2 = this.b.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else if (Arrays.areEqual(bArr3, bArr)) {
            bArr2 = this.k;
            this.j = null;
            this.k = null;
        } else {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        if (((bArr2[0] & 192) ^ 64) != 0) {
            this.g = 0;
            a(this.f);
            a(bArr2);
            return false;
        } else if (((bArr2[bArr2.length - 1] & Ascii.SI) ^ 12) != 0) {
            this.g = 0;
            a(this.f);
            a(bArr2);
            return false;
        } else {
            int i2 = 2;
            if (((bArr2[bArr2.length - 1] & 255) ^ 188) == 0) {
                i2 = 1;
            } else {
                int i3 = ((bArr2[bArr2.length - 2] & 255) << 8) | (bArr2[bArr2.length - 1] & 255);
                Integer trailer = ISOTrailers.getTrailer(this.a);
                if (trailer == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                } else if (i3 != trailer.intValue()) {
                    throw new IllegalStateException(a.M2("signer initialised with wrong digest for trailer ", i3));
                }
            }
            int i4 = 0;
            while (i4 != bArr2.length && ((bArr2[i4] & Ascii.SI) ^ 10) != 0) {
                i4++;
            }
            int i5 = i4 + 1;
            int digestSize = this.a.getDigestSize();
            byte[] bArr4 = new byte[digestSize];
            int length = (bArr2.length - i2) - digestSize;
            int i6 = length - i5;
            if (i6 <= 0) {
                this.g = 0;
                a(this.f);
                a(bArr2);
                return false;
            }
            if ((bArr2[0] & 32) == 0) {
                this.h = true;
                if (this.g > i6) {
                    this.g = 0;
                    a(this.f);
                    a(bArr2);
                    return false;
                }
                this.a.reset();
                this.a.update(bArr2, i5, i6);
                this.a.doFinal(bArr4, 0);
                boolean z2 = true;
                for (int i7 = 0; i7 != digestSize; i7++) {
                    int i8 = length + i7;
                    bArr2[i8] = (byte) (bArr2[i8] ^ bArr4[i7]);
                    if (bArr2[i8] != 0) {
                        z2 = false;
                    }
                }
                if (!z2) {
                    this.g = 0;
                    a(this.f);
                    a(bArr2);
                    return false;
                }
                byte[] bArr5 = new byte[i6];
                this.i = bArr5;
                System.arraycopy(bArr2, i5, bArr5, 0, bArr5.length);
            } else {
                this.h = false;
                this.a.doFinal(bArr4, 0);
                boolean z3 = true;
                for (int i9 = 0; i9 != digestSize; i9++) {
                    int i10 = length + i9;
                    bArr2[i10] = (byte) (bArr2[i10] ^ bArr4[i9]);
                    if (bArr2[i10] != 0) {
                        z3 = false;
                    }
                }
                if (!z3) {
                    this.g = 0;
                    a(this.f);
                    a(bArr2);
                    return false;
                }
                byte[] bArr6 = new byte[i6];
                this.i = bArr6;
                System.arraycopy(bArr2, i5, bArr6, 0, bArr6.length);
            }
            int i11 = this.g;
            if (i11 != 0) {
                byte[] bArr7 = this.f;
                byte[] bArr8 = this.i;
                if (i11 > bArr7.length) {
                    z = bArr7.length <= bArr8.length;
                    for (int i12 = 0; i12 != this.f.length; i12++) {
                        if (bArr7[i12] != bArr8[i12]) {
                            z = false;
                        }
                    }
                } else {
                    z = i11 == bArr8.length;
                    for (int i13 = 0; i13 != bArr8.length; i13++) {
                        if (bArr7[i13] != bArr8[i13]) {
                            z = false;
                        }
                    }
                }
                if (!z) {
                    this.g = 0;
                    a(this.f);
                    a(bArr2);
                    return false;
                }
            }
            a(this.f);
            a(bArr2);
            this.g = 0;
            return true;
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i2, int i3) {
        while (i3 > 0 && this.g < this.f.length) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
        this.a.update(bArr, i2, i3);
        this.g += i3;
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }
}
