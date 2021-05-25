package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
public class KeyAgreementSpi extends BaseAgreementSpi {
    public static final BigInteger l = BigInteger.valueOf(1);
    public static final BigInteger m = BigInteger.valueOf(2);
    public BigInteger h;
    public BigInteger i;
    public BigInteger j;
    public BigInteger k;

    public static class DHwithRFC2631KDF extends KeyAgreementSpi {
        public DHwithRFC2631KDF() {
            super("DHwithRFC2631KDF", new DHKEKGenerator(DigestFactory.createSHA1()));
        }
    }

    public KeyAgreementSpi() {
        super("Diffie-Hellman", null);
    }

    public byte[] bigIntToBytes(BigInteger bigInteger) {
        int bitLength = (this.i.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == bitLength) {
            return byteArray;
        }
        if (byteArray[0] == 0 && byteArray.length == bitLength + 1) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            return bArr;
        }
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(byteArray, 0, bArr2, bitLength - byteArray.length, byteArray.length);
        return bArr2;
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public byte[] calcSecret() {
        return bigIntToBytes(this.k);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.h == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.j) || !dHPublicKey.getParams().getP().equals(this.i)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            }
            BigInteger y = dHPublicKey.getY();
            if (y != null && y.compareTo(m) >= 0) {
                BigInteger bigInteger = this.i;
                BigInteger bigInteger2 = l;
                if (y.compareTo(bigInteger.subtract(bigInteger2)) < 0) {
                    BigInteger modPow = y.modPow(this.h, this.i);
                    this.k = modPow;
                    if (modPow.compareTo(bigInteger2) == 0) {
                        throw new InvalidKeyException("Shared key can't be 1");
                    } else if (z) {
                        return null;
                    } else {
                        return new BCDHPublicKey(this.k, dHPublicKey.getParams());
                    }
                }
            }
            throw new InvalidKeyException("Invalid DH PublicKey");
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.h != null) {
            return super.engineGenerateSecret();
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.i = dHPrivateKey.getParams().getP();
                this.j = dHPrivateKey.getParams().getG();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.i = dHParameterSpec.getP();
                this.j = dHParameterSpec.getG();
            } else if (algorithmParameterSpec instanceof UserKeyingMaterialSpec) {
                this.i = dHPrivateKey.getParams().getP();
                this.j = dHPrivateKey.getParams().getG();
                this.ukmParameters = ((UserKeyingMaterialSpec) algorithmParameterSpec).getUserKeyingMaterial();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            BigInteger x = dHPrivateKey.getX();
            this.k = x;
            this.h = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    public KeyAgreementSpi(String str, DerivationFunction derivationFunction) {
        super(str, derivationFunction);
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i2) throws IllegalStateException, ShortBufferException {
        if (this.h != null) {
            return super.engineGenerateSecret(bArr, i2);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        if (this.h != null) {
            byte[] bigIntToBytes = bigIntToBytes(this.k);
            if (str.equals("TlsPremasterSecret")) {
                return new SecretKeySpec(BaseAgreementSpi.trimZeroes(bigIntToBytes), str);
            }
            return super.engineGenerateSecret(str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.i = dHPrivateKey.getParams().getP();
            this.j = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.k = x;
            this.h = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
