package org.spongycastle.pqc.crypto.mceliece;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.prng.DigestRandomGenerator;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.ByteUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import x6.e.f.a.a.a;
public class McElieceFujisakiCipher implements MessageEncryptor {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.1";
    public Digest a;
    public SecureRandom b;
    public int c;
    public int d;
    public int e;
    public McElieceCCA2KeyParameters f;
    public boolean g;

    public final void a(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        SecureRandom secureRandom = this.b;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        this.b = secureRandom;
        this.a = AppCompatDelegateImpl.i.v0(mcElieceCCA2PublicKeyParameters.getDigest());
        this.c = mcElieceCCA2PublicKeyParameters.getN();
        this.d = mcElieceCCA2PublicKeyParameters.getK();
        this.e = mcElieceCCA2PublicKeyParameters.getT();
    }

    public int getKeySize(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) throws IllegalArgumentException {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public void init(boolean z, CipherParameters cipherParameters) {
        this.g = z;
        if (!z) {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            this.f = mcElieceCCA2PrivateKeyParameters;
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters2 = mcElieceCCA2PrivateKeyParameters;
            this.a = AppCompatDelegateImpl.i.v0(mcElieceCCA2PrivateKeyParameters2.getDigest());
            this.c = mcElieceCCA2PrivateKeyParameters2.getN();
            this.e = mcElieceCCA2PrivateKeyParameters2.getT();
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.b = parametersWithRandom.getRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = (McElieceCCA2PublicKeyParameters) parametersWithRandom.getParameters();
            this.f = mcElieceCCA2PublicKeyParameters;
            a(mcElieceCCA2PublicKeyParameters);
        } else {
            this.b = new SecureRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = (McElieceCCA2PublicKeyParameters) cipherParameters;
            this.f = mcElieceCCA2PublicKeyParameters2;
            a(mcElieceCCA2PublicKeyParameters2);
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public byte[] messageDecrypt(byte[] bArr) throws InvalidCipherTextException {
        if (!this.g) {
            int i = (this.c + 7) >> 3;
            int length = bArr.length - i;
            byte[][] split = ByteUtils.split(bArr, i);
            byte[] bArr2 = split[0];
            byte[] bArr3 = split[1];
            GF2Vector[] c0 = AppCompatDelegateImpl.i.c0((McElieceCCA2PrivateKeyParameters) this.f, GF2Vector.OS2VP(this.c, bArr2));
            byte[] encoded = c0[0].getEncoded();
            GF2Vector gF2Vector = c0[1];
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.addSeedMaterial(encoded);
            byte[] bArr4 = new byte[length];
            digestRandomGenerator.nextBytes(bArr4);
            for (int i2 = 0; i2 < length; i2++) {
                bArr4[i2] = (byte) (bArr4[i2] ^ bArr3[i2]);
            }
            byte[] concatenate = ByteUtils.concatenate(encoded, bArr4);
            byte[] bArr5 = new byte[this.a.getDigestSize()];
            this.a.update(concatenate, 0, concatenate.length);
            this.a.doFinal(bArr5, 0);
            if (a.a(this.c, this.e, bArr5).equals(gF2Vector)) {
                return bArr4;
            }
            throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public byte[] messageEncrypt(byte[] bArr) {
        if (this.g) {
            GF2Vector gF2Vector = new GF2Vector(this.d, this.b);
            byte[] encoded = gF2Vector.getEncoded();
            byte[] concatenate = ByteUtils.concatenate(encoded, bArr);
            this.a.update(concatenate, 0, concatenate.length);
            byte[] bArr2 = new byte[this.a.getDigestSize()];
            this.a.doFinal(bArr2, 0);
            byte[] encoded2 = AppCompatDelegateImpl.i.i0((McElieceCCA2PublicKeyParameters) this.f, gF2Vector, a.a(this.c, this.e, bArr2)).getEncoded();
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.addSeedMaterial(encoded);
            byte[] bArr3 = new byte[bArr.length];
            digestRandomGenerator.nextBytes(bArr3);
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr[i]);
            }
            return ByteUtils.concatenate(encoded2, bArr3);
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
