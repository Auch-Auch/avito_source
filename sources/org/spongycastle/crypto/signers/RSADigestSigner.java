package org.spongycastle.crypto.signers;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;
import org.spongycastle.util.Arrays;
public class RSADigestSigner implements Signer {
    public static final Hashtable e;
    public final AsymmetricBlockCipher a;
    public final AlgorithmIdentifier b;
    public final Digest c;
    public boolean d;

    static {
        Hashtable hashtable = new Hashtable();
        e = hashtable;
        hashtable.put("RIPEMD128", TeleTrusTObjectIdentifiers.ripemd128);
        hashtable.put("RIPEMD160", TeleTrusTObjectIdentifiers.ripemd160);
        hashtable.put("RIPEMD256", TeleTrusTObjectIdentifiers.ripemd256);
        hashtable.put("SHA-1", X509ObjectIdentifiers.id_SHA1);
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA224, NISTObjectIdentifiers.id_sha224);
        hashtable.put("SHA-256", NISTObjectIdentifiers.id_sha256);
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA384, NISTObjectIdentifiers.id_sha384);
        hashtable.put(McElieceCCA2KeyGenParameterSpec.SHA512, NISTObjectIdentifiers.id_sha512);
        hashtable.put("SHA-512/224", NISTObjectIdentifiers.id_sha512_224);
        hashtable.put("SHA-512/256", NISTObjectIdentifiers.id_sha512_256);
        hashtable.put("SHA3-224", NISTObjectIdentifiers.id_sha3_224);
        hashtable.put(SPHINCS256KeyGenParameterSpec.SHA3_256, NISTObjectIdentifiers.id_sha3_256);
        hashtable.put("SHA3-384", NISTObjectIdentifiers.id_sha3_384);
        hashtable.put("SHA3-512", NISTObjectIdentifiers.id_sha3_512);
        hashtable.put("MD2", PKCSObjectIdentifiers.md2);
        hashtable.put("MD4", PKCSObjectIdentifiers.md4);
        hashtable.put(Constants.MD5, PKCSObjectIdentifiers.md5);
    }

    public RSADigestSigner(Digest digest) {
        this(digest, (ASN1ObjectIdentifier) e.get(digest.getAlgorithmName()));
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.d) {
            byte[] bArr = new byte[this.c.getDigestSize()];
            this.c.doFinal(bArr, 0);
            try {
                byte[] encoded = new DigestInfo(this.b, bArr).getEncoded(ASN1Encoding.DER);
                return this.a.processBlock(encoded, 0, encoded.length);
            } catch (IOException e2) {
                throw new CryptoException(a.A2(e2, a.L("unable to encode signature: ")), e2);
            }
        } else {
            throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
        }
    }

    public String getAlgorithmName() {
        return this.c.getAlgorithmName() + "withRSA";
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.d = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.a.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("verification requires public key");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.c.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.c.update(b2);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        if (!this.d) {
            int digestSize = this.c.getDigestSize();
            byte[] bArr2 = new byte[digestSize];
            this.c.doFinal(bArr2, 0);
            try {
                byte[] processBlock = this.a.processBlock(bArr, 0, bArr.length);
                byte[] encoded = new DigestInfo(this.b, bArr2).getEncoded(ASN1Encoding.DER);
                if (processBlock.length == encoded.length) {
                    return Arrays.constantTimeAreEqual(processBlock, encoded);
                }
                if (processBlock.length == encoded.length - 2) {
                    int length = (processBlock.length - digestSize) - 2;
                    int length2 = (encoded.length - digestSize) - 2;
                    encoded[1] = (byte) (encoded[1] - 2);
                    encoded[3] = (byte) (encoded[3] - 2);
                    int i = 0;
                    for (int i2 = 0; i2 < digestSize; i2++) {
                        i |= processBlock[length + i2] ^ encoded[length2 + i2];
                    }
                    for (int i3 = 0; i3 < length; i3++) {
                        i |= processBlock[i3] ^ encoded[i3];
                    }
                    if (i == 0) {
                        return true;
                    }
                    return false;
                }
                Arrays.constantTimeAreEqual(encoded, encoded);
                return false;
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("RSADigestSigner not initialised for verification");
        }
    }

    public RSADigestSigner(Digest digest, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.a = new PKCS1Encoding(new RSABlindedEngine());
        this.c = digest;
        this.b = new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.INSTANCE);
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.c.update(bArr, i, i2);
    }
}
