package org.spongycastle.jce.netscape;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jce.provider.BouncyCastleProvider;
public class NetscapeCertRequest extends ASN1Object {
    public AlgorithmIdentifier a;
    public AlgorithmIdentifier b;
    public byte[] c;
    public String d;
    public DERBitString e;
    public PublicKey f;

    public NetscapeCertRequest(byte[] bArr) throws IOException {
        this(ASN1Sequence.getInstance(new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject()));
    }

    public final ASN1Primitive a() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f.getEncoded());
            byteArrayOutputStream.close();
            return new ASN1InputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (IOException e2) {
            throw new InvalidKeySpecException(e2.getMessage());
        }
    }

    public String getChallenge() {
        return this.d;
    }

    public AlgorithmIdentifier getKeyAlgorithm() {
        return this.b;
    }

    public PublicKey getPublicKey() {
        return this.f;
    }

    public AlgorithmIdentifier getSigningAlgorithm() {
        return this.a;
    }

    public void setChallenge(String str) {
        this.d = str;
    }

    public void setKeyAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.b = algorithmIdentifier;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.f = publicKey;
    }

    public void setSigningAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.a = algorithmIdentifier;
    }

    public void sign(PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException, InvalidKeySpecException {
        sign(privateKey, null);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        try {
            aSN1EncodableVector2.add(a());
        } catch (Exception unused) {
        }
        aSN1EncodableVector2.add(new DERIA5String(this.d));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new DERBitString(this.c));
        return new DERSequence(aSN1EncodableVector);
    }

    public boolean verify(String str) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException {
        if (!str.equals(this.d)) {
            return false;
        }
        Signature instance = Signature.getInstance(this.a.getAlgorithm().getId(), BouncyCastleProvider.PROVIDER_NAME);
        instance.initVerify(this.f);
        instance.update(this.e.getBytes());
        return instance.verify(this.c);
    }

    public void sign(PrivateKey privateKey, SecureRandom secureRandom) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException, InvalidKeySpecException {
        Signature instance = Signature.getInstance(this.a.getAlgorithm().getId(), BouncyCastleProvider.PROVIDER_NAME);
        if (secureRandom != null) {
            instance.initSign(privateKey, secureRandom);
        } else {
            instance.initSign(privateKey);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(a());
        aSN1EncodableVector.add(new DERIA5String(this.d));
        try {
            instance.update(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER));
            this.c = instance.sign();
        } catch (IOException e2) {
            throw new SignatureException(e2.getMessage());
        }
    }

    public NetscapeCertRequest(ASN1Sequence aSN1Sequence) {
        try {
            if (aSN1Sequence.size() == 3) {
                this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
                this.c = ((DERBitString) aSN1Sequence.getObjectAt(2)).getOctets();
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
                if (aSN1Sequence2.size() == 2) {
                    this.d = ((DERIA5String) aSN1Sequence2.getObjectAt(1)).getString();
                    this.e = new DERBitString(aSN1Sequence2);
                    SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(aSN1Sequence2.getObjectAt(0));
                    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new DERBitString(instance).getBytes());
                    AlgorithmIdentifier algorithm = instance.getAlgorithm();
                    this.b = algorithm;
                    this.f = KeyFactory.getInstance(algorithm.getAlgorithm().getId(), BouncyCastleProvider.PROVIDER_NAME).generatePublic(x509EncodedKeySpec);
                    return;
                }
                throw new IllegalArgumentException("invalid PKAC (len): " + aSN1Sequence2.size());
            }
            throw new IllegalArgumentException("invalid SPKAC (size):" + aSN1Sequence.size());
        } catch (Exception e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    public NetscapeCertRequest(String str, AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        this.d = str;
        this.a = algorithmIdentifier;
        this.f = publicKey;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(a());
        aSN1EncodableVector.add(new DERIA5String(str));
        try {
            this.e = new DERBitString(new DERSequence(aSN1EncodableVector));
        } catch (IOException e2) {
            StringBuilder L = a.L("exception encoding key: ");
            L.append(e2.toString());
            throw new InvalidKeySpecException(L.toString());
        }
    }
}
