package x6.e.b.a;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
public class a {
    public RSAKeyParameters a;
    public boolean b;

    public BigInteger a(byte[] bArr, int i, int i2) {
        if (i2 > c() + 1) {
            throw new DataLengthException("input too large for RSA cipher.");
        } else if (i2 != c() + 1 || this.b) {
            if (!(i == 0 && i2 == bArr.length)) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                bArr = bArr2;
            }
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(this.a.getModulus()) < 0) {
                return bigInteger;
            }
            throw new DataLengthException("input too large for RSA cipher.");
        } else {
            throw new DataLengthException("input too large for RSA cipher.");
        }
    }

    public byte[] b(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (this.b) {
            if (byteArray[0] == 0 && byteArray.length > d()) {
                int length = byteArray.length - 1;
                byte[] bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
                return bArr;
            } else if (byteArray.length < d()) {
                int d = d();
                byte[] bArr2 = new byte[d];
                System.arraycopy(byteArray, 0, bArr2, d - byteArray.length, byteArray.length);
                return bArr2;
            }
        } else if (byteArray[0] == 0) {
            int length2 = byteArray.length - 1;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(byteArray, 1, bArr3, 0, length2);
            return bArr3;
        }
        return byteArray;
    }

    public int c() {
        int bitLength = this.a.getModulus().bitLength();
        if (this.b) {
            return ((bitLength + 7) / 8) - 1;
        }
        return (bitLength + 7) / 8;
    }

    public int d() {
        int bitLength = this.a.getModulus().bitLength();
        if (this.b) {
            return (bitLength + 7) / 8;
        }
        return ((bitLength + 7) / 8) - 1;
    }

    public void e(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.a = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            this.a = (RSAKeyParameters) cipherParameters;
        }
        this.b = z;
    }

    public BigInteger f(BigInteger bigInteger) {
        RSAKeyParameters rSAKeyParameters = this.a;
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters)) {
            return bigInteger.modPow(rSAKeyParameters.getExponent(), this.a.getModulus());
        }
        RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
        BigInteger p = rSAPrivateCrtKeyParameters.getP();
        BigInteger q = rSAPrivateCrtKeyParameters.getQ();
        BigInteger dp = rSAPrivateCrtKeyParameters.getDP();
        BigInteger dq = rSAPrivateCrtKeyParameters.getDQ();
        BigInteger qInv = rSAPrivateCrtKeyParameters.getQInv();
        BigInteger modPow = bigInteger.remainder(p).modPow(dp, p);
        BigInteger modPow2 = bigInteger.remainder(q).modPow(dq, q);
        return modPow.subtract(modPow2).multiply(qInv).mod(p).multiply(q).add(modPow2);
    }
}
