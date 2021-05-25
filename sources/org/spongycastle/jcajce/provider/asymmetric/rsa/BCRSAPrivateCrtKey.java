package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.util.Strings;
public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    public static final long serialVersionUID = 7834723820638524718L;
    public BigInteger c;
    public BigInteger d;
    public BigInteger e;
    public BigInteger f;
    public BigInteger g;
    public BigInteger h;

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters) {
        super(rSAPrivateCrtKeyParameters);
        this.c = rSAPrivateCrtKeyParameters.getPublicExponent();
        this.d = rSAPrivateCrtKeyParameters.getP();
        this.e = rSAPrivateCrtKeyParameters.getQ();
        this.f = rSAPrivateCrtKeyParameters.getDP();
        this.g = rSAPrivateCrtKeyParameters.getDQ();
        this.h = rSAPrivateCrtKeyParameters.getQInv();
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey)) {
            return false;
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
        if (!getModulus().equals(rSAPrivateCrtKey.getModulus()) || !getPublicExponent().equals(rSAPrivateCrtKey.getPublicExponent()) || !getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) || !getPrimeP().equals(rSAPrivateCrtKey.getPrimeP()) || !getPrimeQ().equals(rSAPrivateCrtKey.getPrimeQ()) || !getPrimeExponentP().equals(rSAPrivateCrtKey.getPrimeExponentP()) || !getPrimeExponentQ().equals(rSAPrivateCrtKey.getPrimeExponentQ()) || !getCrtCoefficient().equals(rSAPrivateCrtKey.getCrtCoefficient())) {
            return false;
        }
        return true;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        return this.h;
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        return this.f;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        return this.g;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        return this.d;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        return this.e;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        return this.c;
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.lang.Object
    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("RSA Private CRT Key [");
        stringBuffer.append(RSAUtil.a(getModulus(), getPublicExponent()));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        this.modulus = rSAPrivateCrtKeySpec.getModulus();
        this.c = rSAPrivateCrtKeySpec.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.d = rSAPrivateCrtKeySpec.getPrimeP();
        this.e = rSAPrivateCrtKeySpec.getPrimeQ();
        this.f = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.g = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.h = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        this.modulus = rSAPrivateCrtKey.getModulus();
        this.c = rSAPrivateCrtKey.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        this.d = rSAPrivateCrtKey.getPrimeP();
        this.e = rSAPrivateCrtKey.getPrimeQ();
        this.f = rSAPrivateCrtKey.getPrimeExponentP();
        this.g = rSAPrivateCrtKey.getPrimeExponentQ();
        this.h = rSAPrivateCrtKey.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(RSAPrivateKey rSAPrivateKey) {
        this.modulus = rSAPrivateKey.getModulus();
        this.c = rSAPrivateKey.getPublicExponent();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
        this.d = rSAPrivateKey.getPrime1();
        this.e = rSAPrivateKey.getPrime2();
        this.f = rSAPrivateKey.getExponent1();
        this.g = rSAPrivateKey.getExponent2();
        this.h = rSAPrivateKey.getCoefficient();
    }
}
