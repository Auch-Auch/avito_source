package org.spongycastle.crypto.signers;

import a2.b.a.a.a;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
public class PSSSigner implements Signer {
    public static final byte TRAILER_IMPLICIT = -68;
    public Digest a;
    public Digest b;
    public AsymmetricBlockCipher c;
    public SecureRandom d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public byte m;

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i2) {
        this(asymmetricBlockCipher, digest, i2, (byte) TRAILER_IMPLICIT);
    }

    public final void a(int i2, byte[] bArr) {
        bArr[0] = (byte) (i2 >>> 24);
        bArr[1] = (byte) (i2 >>> 16);
        bArr[2] = (byte) (i2 >>> 8);
        bArr[3] = (byte) (i2 >>> 0);
    }

    public final void b(byte[] bArr) {
        for (int i2 = 0; i2 != bArr.length; i2++) {
            bArr[i2] = 0;
        }
    }

    public final byte[] c(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        byte[] bArr2 = new byte[i4];
        byte[] bArr3 = new byte[this.f];
        byte[] bArr4 = new byte[4];
        this.b.reset();
        int i6 = 0;
        while (true) {
            i5 = this.f;
            if (i6 >= i4 / i5) {
                break;
            }
            a(i6, bArr4);
            this.b.update(bArr, i2, i3);
            this.b.update(bArr4, 0, 4);
            this.b.doFinal(bArr3, 0);
            int i7 = this.f;
            System.arraycopy(bArr3, 0, bArr2, i6 * i7, i7);
            i6++;
        }
        if (i5 * i6 < i4) {
            a(i6, bArr4);
            this.b.update(bArr, i2, i3);
            this.b.update(bArr4, 0, 4);
            this.b.doFinal(bArr3, 0);
            int i8 = this.f;
            System.arraycopy(bArr3, 0, bArr2, i6 * i8, i4 - (i6 * i8));
        }
        return bArr2;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        Digest digest = this.a;
        byte[] bArr = this.k;
        digest.doFinal(bArr, (bArr.length - this.e) - this.h);
        if (this.h != 0) {
            if (!this.g) {
                this.d.nextBytes(this.j);
            }
            byte[] bArr2 = this.j;
            byte[] bArr3 = this.k;
            int length = bArr3.length;
            int i2 = this.h;
            System.arraycopy(bArr2, 0, bArr3, length - i2, i2);
        }
        int i3 = this.e;
        byte[] bArr4 = new byte[i3];
        Digest digest2 = this.a;
        byte[] bArr5 = this.k;
        digest2.update(bArr5, 0, bArr5.length);
        this.a.doFinal(bArr4, 0);
        byte[] bArr6 = this.l;
        int length2 = bArr6.length;
        int i4 = this.h;
        int i5 = this.e;
        bArr6[(((length2 - i4) - 1) - i5) - 1] = 1;
        System.arraycopy(this.j, 0, bArr6, ((bArr6.length - i4) - i5) - 1, i4);
        byte[] c2 = c(bArr4, 0, i3, (this.l.length - this.e) - 1);
        for (int i6 = 0; i6 != c2.length; i6++) {
            byte[] bArr7 = this.l;
            bArr7[i6] = (byte) (bArr7[i6] ^ c2[i6]);
        }
        byte[] bArr8 = this.l;
        bArr8[0] = (byte) (bArr8[0] & (255 >> ((bArr8.length * 8) - this.i)));
        int length3 = bArr8.length;
        int i7 = this.e;
        System.arraycopy(bArr4, 0, bArr8, (length3 - i7) - 1, i7);
        byte[] bArr9 = this.l;
        bArr9[bArr9.length - 1] = this.m;
        byte[] processBlock = this.c.processBlock(bArr9, 0, bArr9.length);
        b(this.l);
        return processBlock;
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        CipherParameters cipherParameters2;
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            cipherParameters2 = parametersWithRandom.getParameters();
            this.d = parametersWithRandom.getRandom();
        } else {
            if (z) {
                this.d = new SecureRandom();
            }
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof RSABlindingParameters) {
            rSAKeyParameters = ((RSABlindingParameters) cipherParameters2).getPublicKey();
            this.c.init(z, cipherParameters);
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters2;
            this.c.init(z, cipherParameters2);
        }
        int bitLength = rSAKeyParameters.getModulus().bitLength() - 1;
        this.i = bitLength;
        if (bitLength >= a.c2(this.h, 8, this.e * 8, 9)) {
            this.l = new byte[((bitLength + 7) / 8)];
            reset();
            return;
        }
        throw new IllegalArgumentException("key too small for specified hash and salt lengths");
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        Digest digest = this.a;
        byte[] bArr2 = this.k;
        digest.doFinal(bArr2, (bArr2.length - this.e) - this.h);
        try {
            byte[] processBlock = this.c.processBlock(bArr, 0, bArr.length);
            byte[] bArr3 = this.l;
            System.arraycopy(processBlock, 0, bArr3, bArr3.length - processBlock.length, processBlock.length);
            byte[] bArr4 = this.l;
            if (bArr4[bArr4.length - 1] != this.m) {
                b(bArr4);
                return false;
            }
            int length = bArr4.length;
            int i2 = this.e;
            byte[] c2 = c(bArr4, (length - i2) - 1, i2, (bArr4.length - i2) - 1);
            for (int i3 = 0; i3 != c2.length; i3++) {
                byte[] bArr5 = this.l;
                bArr5[i3] = (byte) (bArr5[i3] ^ c2[i3]);
            }
            byte[] bArr6 = this.l;
            bArr6[0] = (byte) (bArr6[0] & (255 >> ((bArr6.length * 8) - this.i)));
            int i4 = 0;
            while (true) {
                byte[] bArr7 = this.l;
                int length2 = bArr7.length;
                int i5 = this.e;
                int i6 = this.h;
                if (i4 != ((length2 - i5) - i6) - 2) {
                    if (bArr7[i4] != 0) {
                        b(bArr7);
                        return false;
                    }
                    i4++;
                } else if (bArr7[((bArr7.length - i5) - i6) - 2] != 1) {
                    b(bArr7);
                    return false;
                } else {
                    if (this.g) {
                        byte[] bArr8 = this.j;
                        byte[] bArr9 = this.k;
                        System.arraycopy(bArr8, 0, bArr9, bArr9.length - i6, i6);
                    } else {
                        byte[] bArr10 = this.k;
                        System.arraycopy(bArr7, ((bArr7.length - i6) - i5) - 1, bArr10, bArr10.length - i6, i6);
                    }
                    Digest digest2 = this.a;
                    byte[] bArr11 = this.k;
                    digest2.update(bArr11, 0, bArr11.length);
                    Digest digest3 = this.a;
                    byte[] bArr12 = this.k;
                    digest3.doFinal(bArr12, bArr12.length - this.e);
                    int length3 = this.l.length;
                    int i7 = this.e;
                    int i8 = (length3 - i7) - 1;
                    int length4 = this.k.length - i7;
                    while (true) {
                        byte[] bArr13 = this.k;
                        if (length4 == bArr13.length) {
                            b(bArr13);
                            b(this.l);
                            return true;
                        } else if ((this.l[i8] ^ bArr13[length4]) != 0) {
                            b(bArr13);
                            b(this.l);
                            return false;
                        } else {
                            i8++;
                            length4++;
                        }
                    }
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i2) {
        this(asymmetricBlockCipher, digest, digest2, i2, (byte) TRAILER_IMPLICIT);
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i2, int i3) {
        this.a.update(bArr, i2, i3);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, int i2, byte b2) {
        this(asymmetricBlockCipher, digest, digest, i2, b2);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, int i2, byte b2) {
        this.c = asymmetricBlockCipher;
        this.a = digest;
        this.b = digest2;
        this.e = digest.getDigestSize();
        this.f = digest2.getDigestSize();
        this.g = false;
        this.h = i2;
        this.j = new byte[i2];
        this.k = new byte[(i2 + 8 + this.e)];
        this.m = b2;
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr, (byte) TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest2, bArr, (byte) TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr, byte b2) {
        this.c = asymmetricBlockCipher;
        this.a = digest;
        this.b = digest2;
        this.e = digest.getDigestSize();
        this.f = digest2.getDigestSize();
        this.g = true;
        int length = bArr.length;
        this.h = length;
        this.j = bArr;
        this.k = new byte[(length + 8 + this.e)];
        this.m = b2;
    }
}
