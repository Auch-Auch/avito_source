package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
public class McElieceCipher implements MessageEncryptor {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
    public SecureRandom a;
    public int b;
    public int c;
    public int cipherTextSize;
    public int d;
    public McElieceKeyParameters e;
    public boolean f;
    public int maxPlainTextSize;

    public final void a(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        SecureRandom secureRandom = this.a;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        this.a = secureRandom;
        this.b = mcEliecePublicKeyParameters.getN();
        this.c = mcEliecePublicKeyParameters.getK();
        this.d = mcEliecePublicKeyParameters.getT();
        this.cipherTextSize = this.b >> 3;
        this.maxPlainTextSize = this.c >> 3;
    }

    public int getKeySize(McElieceKeyParameters mcElieceKeyParameters) {
        if (mcElieceKeyParameters instanceof McEliecePublicKeyParameters) {
            return ((McEliecePublicKeyParameters) mcElieceKeyParameters).getN();
        }
        if (mcElieceKeyParameters instanceof McEliecePrivateKeyParameters) {
            return ((McEliecePrivateKeyParameters) mcElieceKeyParameters).getN();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public void init(boolean z, CipherParameters cipherParameters) {
        this.f = z;
        if (!z) {
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) cipherParameters;
            this.e = mcEliecePrivateKeyParameters;
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters2 = mcEliecePrivateKeyParameters;
            this.b = mcEliecePrivateKeyParameters2.getN();
            int k = mcEliecePrivateKeyParameters2.getK();
            this.c = k;
            this.maxPlainTextSize = k >> 3;
            this.cipherTextSize = this.b >> 3;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.getRandom();
            McEliecePublicKeyParameters mcEliecePublicKeyParameters = (McEliecePublicKeyParameters) parametersWithRandom.getParameters();
            this.e = mcEliecePublicKeyParameters;
            a(mcEliecePublicKeyParameters);
        } else {
            this.a = new SecureRandom();
            McEliecePublicKeyParameters mcEliecePublicKeyParameters2 = (McEliecePublicKeyParameters) cipherParameters;
            this.e = mcEliecePublicKeyParameters2;
            a(mcEliecePublicKeyParameters2);
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public byte[] messageDecrypt(byte[] bArr) throws InvalidCipherTextException {
        if (!this.f) {
            GF2Vector OS2VP = GF2Vector.OS2VP(this.b, bArr);
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) this.e;
            GF2mField field = mcEliecePrivateKeyParameters.getField();
            PolynomialGF2mSmallM goppaPoly = mcEliecePrivateKeyParameters.getGoppaPoly();
            GF2Matrix sInv = mcEliecePrivateKeyParameters.getSInv();
            Permutation p1 = mcEliecePrivateKeyParameters.getP1();
            Permutation p2 = mcEliecePrivateKeyParameters.getP2();
            GF2Matrix h = mcEliecePrivateKeyParameters.getH();
            PolynomialGF2mSmallM[] qInv = mcEliecePrivateKeyParameters.getQInv();
            Permutation rightMultiply = p1.rightMultiply(p2);
            GF2Vector gF2Vector = (GF2Vector) OS2VP.multiply(rightMultiply.computeInverse());
            GF2Vector syndromeDecode = GoppaCode.syndromeDecode((GF2Vector) h.rightMultiply(gF2Vector), field, goppaPoly, qInv);
            GF2Vector gF2Vector2 = (GF2Vector) syndromeDecode.multiply(rightMultiply);
            byte[] encoded = ((GF2Vector) sInv.leftMultiply(((GF2Vector) ((GF2Vector) gF2Vector.add(syndromeDecode)).multiply(p1)).extractRightVector(this.c))).getEncoded();
            int length = encoded.length - 1;
            while (length >= 0 && encoded[length] == 0) {
                length--;
            }
            if (length < 0 || encoded[length] != 1) {
                throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(encoded, 0, bArr2, 0, length);
            return bArr2;
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    @Override // org.spongycastle.pqc.crypto.MessageEncryptor
    public byte[] messageEncrypt(byte[] bArr) {
        if (this.f) {
            byte[] bArr2 = new byte[(this.maxPlainTextSize + ((this.c & 7) != 0 ? 1 : 0))];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[bArr.length] = 1;
            return ((GF2Vector) ((McEliecePublicKeyParameters) this.e).getG().leftMultiply(GF2Vector.OS2VP(this.c, bArr2)).add(new GF2Vector(this.b, this.d, this.a))).getEncoded();
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
