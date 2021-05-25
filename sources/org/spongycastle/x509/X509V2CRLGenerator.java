package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.asn1.x509.V2TBSCertListGenerator;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.asn1.x509.X509ExtensionsGenerator;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.X509CRLObject;
import x6.e.g.e;
public class X509V2CRLGenerator {
    public V2TBSCertListGenerator a = new V2TBSCertListGenerator();
    public ASN1ObjectIdentifier b;
    public AlgorithmIdentifier c;
    public String d;
    public X509ExtensionsGenerator e = new X509ExtensionsGenerator();

    public static class a extends CRLException {
        public Throwable a;

        public a(String str, Throwable th) {
            super(str);
            this.a = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.a;
        }
    }

    public X509V2CRLGenerator() {
        new BCJcaJceHelper();
    }

    public final TBSCertList a() {
        if (!this.e.isEmpty()) {
            this.a.setExtensions(this.e.generate());
        }
        return this.a.generateTBSCertList();
    }

    public void addCRL(X509CRL x509crl) throws CRLException {
        Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
        if (revokedCertificates != null) {
            for (X509CRLEntry x509CRLEntry : revokedCertificates) {
                try {
                    this.a.addCRLEntry(ASN1Sequence.getInstance(new ASN1InputStream(x509CRLEntry.getEncoded()).readObject()));
                } catch (IOException e2) {
                    StringBuilder L = a2.b.a.a.a.L("exception processing encoding of CRL: ");
                    L.append(e2.toString());
                    throw new CRLException(L.toString());
                }
            }
        }
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i) {
        this.a.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), i);
    }

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) {
        addExtension(new ASN1ObjectIdentifier(str), z, aSN1Encodable);
    }

    public final X509CRL b(TBSCertList tBSCertList, byte[] bArr) throws CRLException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertList);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return new X509CRLObject(new CertificateList(new DERSequence(aSN1EncodableVector)));
    }

    public X509CRL generate(PrivateKey privateKey) throws CRLException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509CRL(privateKey, BouncyCastleProvider.PROVIDER_NAME, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator getSignatureAlgNames() {
        return e.d();
    }

    public void reset() {
        this.a = new V2TBSCertListGenerator();
        this.e.reset();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.a.setIssuer(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e2) {
            throw new IllegalArgumentException(a2.b.a.a.a.Z2("can't process principal: ", e2));
        }
    }

    public void setNextUpdate(Date date) {
        this.a.setNextUpdate(new Time(date));
    }

    public void setSignatureAlgorithm(String str) {
        this.d = str;
        try {
            ASN1ObjectIdentifier e2 = e.e(str);
            this.b = e2;
            AlgorithmIdentifier i = e.i(e2, str);
            this.c = i;
            this.a.setSignature(i);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void setThisUpdate(Date date) {
        this.a.setThisUpdate(new Time(date));
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i, Date date2) {
        this.a.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), i, new ASN1GeneralizedTime(date2));
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.e.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId()), z, aSN1Encodable);
    }

    public X509CRL generate(PrivateKey privateKey, SecureRandom secureRandom) throws CRLException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertList a3 = a();
        try {
            return b(a3, e.b(this.b, this.d, privateKey, secureRandom, a3));
        } catch (IOException e2) {
            throw new a("cannot generate CRL encoding", e2);
        }
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, X509Extensions x509Extensions) {
        this.a.addCRLEntry(new ASN1Integer(bigInteger), new Time(date), Extensions.getInstance(x509Extensions));
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        addExtension(new ASN1ObjectIdentifier(str), z, bArr);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, SecureRandom secureRandom) throws SecurityException, SignatureException, InvalidKeyException {
        try {
            return generateX509CRL(privateKey, BouncyCastleProvider.PROVIDER_NAME, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public void setIssuerDN(X509Name x509Name) {
        this.a.setIssuer(x509Name);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.e.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.getId()), z, bArr);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
        return generateX509CRL(privateKey, str, null);
    }

    public X509CRL generate(PrivateKey privateKey, String str) throws CRLException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return generate(privateKey, str, null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str, SecureRandom secureRandom) throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException {
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

    public X509CRL generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws CRLException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        TBSCertList a3 = a();
        try {
            return b(a3, e.a(this.b, this.d, str, privateKey, secureRandom, a3));
        } catch (IOException e2) {
            throw new a("cannot generate CRL encoding", e2);
        }
    }
}
