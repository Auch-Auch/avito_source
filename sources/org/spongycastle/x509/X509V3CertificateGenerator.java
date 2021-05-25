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
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.asn1.x509.V3TBSCertificateGenerator;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.x509.extension.X509ExtensionUtil;
import x6.e.g.c;
import x6.e.g.e;
public class X509V3CertificateGenerator {
    public final CertificateFactory a = new CertificateFactory();
    public V3TBSCertificateGenerator b = new V3TBSCertificateGenerator();
    public ASN1ObjectIdentifier c;
    public AlgorithmIdentifier d;
    public String e;
    public X509ExtensionsGenerator f = new X509ExtensionsGenerator();

    public X509V3CertificateGenerator() {
        new BCJcaJceHelper();
    }

    public final DERBitString a(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i != zArr.length; i++) {
            int i2 = i / 8;
            bArr[i2] = (byte) (bArr[i2] | (zArr[i] ? 1 << (7 - (i % 8)) : 0));
        }
        int length = zArr.length % 8;
        if (length == 0) {
            return new DERBitString(bArr);
        }
        return new DERBitString(bArr, 8 - length);
    }

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) {
        addExtension(new ASN1ObjectIdentifier(str), z, aSN1Encodable);
    }

    public final X509Certificate b(TBSCertificate tBSCertificate, byte[] bArr) throws Exception {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertificate);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return (X509Certificate) this.a.engineGenerateCertificate(new ByteArrayInputStream(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER)));
    }

    public final TBSCertificate c() {
        if (!this.f.isEmpty()) {
            this.b.setExtensions(this.f.generate());
        }
        return this.b.generateTBSCertificate();
    }

    public void copyAndAddExtension(String str, boolean z, X509Certificate x509Certificate) throws CertificateParsingException {
        byte[] extensionValue = x509Certificate.getExtensionValue(str);
        if (extensionValue != null) {
            try {
                addExtension(str, z, X509ExtensionUtil.fromExtensionValue(extensionValue));
            } catch (IOException e2) {
                throw new CertificateParsingException(e2.toString());
            }
        } else {
            throw new CertificateParsingException(a.e3("extension ", str, " not present"));
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
        this.b = new V3TBSCertificateGenerator();
        this.f.reset();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.b.setIssuer(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.Z2("can't process principal: ", e2));
        }
    }

    public void setIssuerUniqueID(boolean[] zArr) {
        this.b.setIssuerUniqueID(a(zArr));
    }

    public void setNotAfter(Date date) {
        this.b.setEndDate(new Time(date));
    }

    public void setNotBefore(Date date) {
        this.b.setStartDate(new Time(date));
    }

    public void setPublicKey(PublicKey publicKey) throws IllegalArgumentException {
        try {
            this.b.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()));
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
            throw new IllegalArgumentException(a.c3("Unknown signature type requested: ", str));
        }
    }

    public void setSubjectDN(X500Principal x500Principal) {
        try {
            this.b.setSubject(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.Z2("can't process principal: ", e2));
        }
    }

    public void setSubjectUniqueID(boolean[] zArr) {
        this.b.setSubjectUniqueID(a(zArr));
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.f.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId()), z, aSN1Encodable);
    }

    public X509Certificate generate(PrivateKey privateKey, SecureRandom secureRandom) throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificate c2 = c();
        try {
            try {
                return b(c2, e.b(this.c, this.e, privateKey, secureRandom, c2));
            } catch (Exception e2) {
                throw new c("exception producing certificate object", e2);
            }
        } catch (IOException e3) {
            throw new c("exception encoding TBS cert", e3);
        }
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        addExtension(new ASN1ObjectIdentifier(str), z, bArr);
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

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.f.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId()), z, bArr);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        return generateX509Certificate(privateKey, str, null);
    }

    public void copyAndAddExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, X509Certificate x509Certificate) throws CertificateParsingException {
        copyAndAddExtension(aSN1ObjectIdentifier.getId(), z, x509Certificate);
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

    public X509Certificate generate(PrivateKey privateKey, String str) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, str, null);
    }

    public X509Certificate generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertificate c2 = c();
        try {
            try {
                return b(c2, e.a(this.c, this.e, str, privateKey, secureRandom, c2));
            } catch (Exception e2) {
                throw new c("exception producing certificate object", e2);
            }
        } catch (IOException e3) {
            throw new c("exception encoding TBS cert", e3);
        }
    }
}
