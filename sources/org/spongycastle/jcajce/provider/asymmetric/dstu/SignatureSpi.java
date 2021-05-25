package org.spongycastle.jcajce.provider.asymmetric.dstu;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSTU4145Signer;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECKey;
public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public static byte[] c = {10, 9, Ascii.CR, 6, Ascii.SO, Ascii.VT, 4, 5, Ascii.SI, 1, 3, Ascii.FF, 7, 0, 8, 2, 8, 0, Ascii.FF, 4, 9, 6, 7, Ascii.VT, 2, 3, 1, Ascii.SI, 5, Ascii.SO, 10, Ascii.CR, Ascii.SI, 6, 5, 8, Ascii.SO, Ascii.VT, 10, 4, Ascii.FF, 0, 3, 7, 2, 9, 1, Ascii.CR, 3, 8, Ascii.CR, 9, 6, Ascii.VT, Ascii.SI, 0, 2, 5, Ascii.FF, 10, 4, Ascii.SO, 1, 7, Ascii.SI, 8, Ascii.SO, 9, 7, 2, 0, Ascii.CR, Ascii.FF, 6, 1, 5, Ascii.VT, 4, 3, 10, 2, 8, 9, 7, 5, Ascii.SI, 0, Ascii.VT, Ascii.FF, 1, Ascii.CR, Ascii.SO, 10, 3, 6, 4, 3, 8, Ascii.VT, 5, 6, 4, Ascii.SO, 10, 2, Ascii.FF, 1, 7, 9, Ascii.SI, Ascii.CR, 0, 1, 2, 3, Ascii.SO, 6, Ascii.CR, Ascii.VT, 8, Ascii.SI, 10, Ascii.FF, 5, 7, 9, 0, 4};
    public Digest a;
    public DSA b = new DSTU4145Signer();

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        AsymmetricKeyParameter generatePrivateKeyParameter = privateKey instanceof ECKey ? ECUtil.generatePrivateKeyParameter(privateKey) : null;
        this.a = new GOST3411Digest(c);
        SecureRandom secureRandom = ((java.security.SignatureSpi) this).appRandom;
        if (secureRandom != null) {
            this.b.init(true, new ParametersWithRandom(generatePrivateKeyParameter, secureRandom));
        } else {
            this.b.init(true, generatePrivateKeyParameter);
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters cipherParameters;
        if (publicKey instanceof BCDSTU4145PublicKey) {
            cipherParameters = ((BCDSTU4145PublicKey) publicKey).c;
        } else {
            cipherParameters = ECUtil.generatePublicKeyParameter(publicKey);
        }
        byte[] sbox = ((BCDSTU4145PublicKey) publicKey).getSbox();
        byte[] bArr = new byte[128];
        for (int i = 0; i < sbox.length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) ((sbox[i] >> 4) & 15);
            bArr[i2 + 1] = (byte) (sbox[i] & Ascii.SI);
        }
        this.a = new GOST3411Digest(bArr);
        this.b.init(false, cipherParameters);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.a.getDigestSize()];
        this.a.doFinal(bArr, 0);
        try {
            BigInteger[] generateSignature = this.b.generateSignature(bArr);
            byte[] byteArray = generateSignature[0].toByteArray();
            byte[] byteArray2 = generateSignature[1].toByteArray();
            int length = (byteArray.length > byteArray2.length ? byteArray.length : byteArray2.length) * 2;
            byte[] bArr2 = new byte[length];
            System.arraycopy(byteArray2, 0, bArr2, (length / 2) - byteArray2.length, byteArray2.length);
            System.arraycopy(byteArray, 0, bArr2, length - byteArray.length, byteArray.length);
            return new DEROctetString(bArr2).getEncoded();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b2) throws SignatureException {
        this.a.update(b2);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.a.getDigestSize()];
        this.a.doFinal(bArr2, 0);
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(bArr)).getOctets();
            byte[] bArr3 = new byte[(octets.length / 2)];
            byte[] bArr4 = new byte[(octets.length / 2)];
            System.arraycopy(octets, 0, bArr4, 0, octets.length / 2);
            System.arraycopy(octets, octets.length / 2, bArr3, 0, octets.length / 2);
            BigInteger[] bigIntegerArr = {new BigInteger(1, bArr3), new BigInteger(1, bArr4)};
            return this.b.verifySignature(bArr2, bigIntegerArr[0], bigIntegerArr[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.a.update(bArr, i, i2);
    }
}
