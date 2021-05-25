package org.spongycastle.x509;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.asn1.x509.V1TBSCertificateGenerator;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import x6.e.g.c;
import x6.e.g.e;
public class X509V1CertificateGenerator {
    public final CertificateFactory a = new CertificateFactory();
    public V1TBSCertificateGenerator b = new V1TBSCertificateGenerator();
    public ASN1ObjectIdentifier c;
    public AlgorithmIdentifier d;
    public String e;

    public X509V1CertificateGenerator() {
        new BCJcaJceHelper();
    }

    public final X509Certificate a(TBSCertificate tBSCertificate, byte[] bArr) throws CertificateEncodingException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertificate);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(new DERBitString(bArr));
        try {
            return (X509Certificate) this.a.engineGenerateCertificate(new ByteArrayInputStream(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER)));
        } catch (Exception e2) {
            throw new c("exception producing certificate object", e2);
        }
    }

    public X509Certificate generate(PrivateKey privateKey) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509Certificate(privateKey, BouncyCastleProvider.PROVIDER_NAME, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator getSignatureAlgNames() {
        return e.d();
    }

    public void reset() {
        this.b = new V1TBSCertificateGenerator();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.b.setIssuer(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.Z2("can't process principal: ", e2));
        }
    }

    public void setNotAfter(Date date) {
        this.b.setEndDate(new Time(date));
    }

    public void setNotBefore(Date date) {
        this.b.setStartDate(new Time(date));
    }

    public void setPublicKey(PublicKey publicKey) {
        try {
            this.b.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
        } catch (Exception e2) {
            throw new IllegalArgumentException(a.G2(e2, a.L("unable to process key - ")));
        }
    }

    public void setSerialNumber(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) > 0) {
            this.b.setSerialNumber(new ASN1Integer(bigInteger));
            return;
        }
        throw new IllegalArgumentException("serial number must be a positive integer");
    }

    public void setSignatureAlgorithm(String str) {
        this.e = str;
        try {
            ASN1ObjectIdentifier e2 = e.e(str);
            this.c = e2;
            AlgorithmIdentifier i = e.i(e2, str);
            this.d = i;
            this.b.setSignature(i);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void setSubjectDN(X500Principal x500Principal) {
        try {
            this.b.setSubject(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.Z2("can't process principal: ", e2));
        }
    }

    public X509Certificate generate(PrivateKey privateKey, SecureRandom secureRandom) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificate generateTBSCertificate = this.b.generateTBSCertificate();
        try {
            return a(generateTBSCertificate, e.b(this.c, this.e, privateKey, secureRandom, generateTBSCertificate));
        } catch (IOException e2) {
            throw new c("exception encoding TBS cert", e2);
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, SecureRandom secureRandom) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509Certificate(privateKey, BouncyCastleProvider.PROVIDER_NAME, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public void setIssuerDN(X509Name x509Name) {
        this.b.setIssuer(x509Name);
    }

    public void setSubjectDN(X509Name x509Name) {
        this.b.setSubject(x509Name);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        return generateX509Certificate(privateKey, str, null);
    }

    public X509Certificate generate(PrivateKey privateKey, String str) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, str, null);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        try {
            return generate(privateKey, str, secureRandom);
        } catch (NoSuchProviderException e2) {
            throw e2;
        } catch (SignatureException e3) {
            throw e3;
        } catch (InvalidKeyException e4) {
            throw e4;
        } catch (GeneralSecurityException e5) {
            throw new SecurityException("exception: " + e5);
        }
    }

    public X509Certificate generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificate generateTBSCertificate = this.b.generateTBSCertificate();
        try {
            return a(generateTBSCertificate, e.a(this.c, this.e, str, privateKey, secureRandom, generateTBSCertificate));
        } catch (IOException e2) {
            throw new c("exception encoding TBS cert", e2);
        }
    }
}
