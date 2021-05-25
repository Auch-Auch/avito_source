package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.util.io.Streams;
import x6.e.c.a.a.a.b;
import x6.e.c.a.a.a.d;
import x6.e.c.a.a.a.e;
public class CertificateFactory extends CertificateFactorySpi {
    public static final b h = new b("CERTIFICATE");
    public static final b i = new b("CRL");
    public final JcaJceHelper a = new BCJcaJceHelper();
    public ASN1Set b = null;
    public int c = 0;
    public InputStream d = null;
    public ASN1Set e = null;
    public int f = 0;
    public InputStream g = null;

    public class a extends CertificateException {
        public Throwable a;

        public a(CertificateFactory certificateFactory, String str, Throwable th) {
            super(str);
            this.a = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.a;
        }
    }

    static {
        String str = "-----BEGIN PKCS7-----";
        String str2 = "-----BEGIN X509 PKCS7-----";
        String str3 = "-----END PKCS7-----";
        String str4 = "-----END X509 PKCS7-----";
    }

    public final CRL a() throws CRLException {
        ASN1Set aSN1Set = this.e;
        if (aSN1Set == null || this.f >= aSN1Set.size()) {
            return null;
        }
        ASN1Set aSN1Set2 = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        return createCRL(CertificateList.getInstance(aSN1Set2.getObjectAt(i2)));
    }

    public final CRL b(ASN1Sequence aSN1Sequence) throws CRLException {
        if (aSN1Sequence == null) {
            return null;
        }
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return createCRL(CertificateList.getInstance(aSN1Sequence));
        }
        this.e = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCRLs();
        return a();
    }

    public final Certificate c() throws CertificateParsingException {
        if (this.b == null) {
            return null;
        }
        while (this.c < this.b.size()) {
            ASN1Set aSN1Set = this.b;
            int i2 = this.c;
            this.c = i2 + 1;
            ASN1Encodable objectAt = aSN1Set.getObjectAt(i2);
            if (objectAt instanceof ASN1Sequence) {
                return new e(this.a, org.spongycastle.asn1.x509.Certificate.getInstance(objectAt));
            }
        }
        return null;
    }

    public CRL createCRL(CertificateList certificateList) throws CRLException {
        return new d(this.a, certificateList);
    }

    public final Certificate d(ASN1Sequence aSN1Sequence) throws CertificateParsingException {
        if (aSN1Sequence == null) {
            return null;
        }
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new e(this.a, org.spongycastle.asn1.x509.Certificate.getInstance(aSN1Sequence));
        }
        this.b = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
        return c();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        InputStream inputStream2 = this.g;
        if (inputStream2 == null) {
            this.g = inputStream;
            this.e = null;
            this.f = 0;
        } else if (inputStream2 != inputStream) {
            this.g = inputStream;
            this.e = null;
            this.f = 0;
        }
        try {
            ASN1Set aSN1Set = this.e;
            if (aSN1Set == null) {
                if (!inputStream.markSupported()) {
                    inputStream = new ByteArrayInputStream(Streams.readAll(inputStream));
                }
                inputStream.mark(1);
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                inputStream.reset();
                if (read != 48) {
                    return b(i.b(inputStream));
                }
                return b(ASN1Sequence.getInstance(new ASN1InputStream(inputStream, true).readObject()));
            } else if (this.f != aSN1Set.size()) {
                return a();
            } else {
                this.e = null;
                this.f = 0;
                return null;
            }
        } catch (CRLException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new CRLException(e3.toString());
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCRLs(InputStream inputStream) throws CRLException {
        ArrayList arrayList = new ArrayList();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            CRL engineGenerateCRL = engineGenerateCRL(bufferedInputStream);
            if (engineGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCRL);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        InputStream inputStream2 = this.d;
        if (inputStream2 == null) {
            this.d = inputStream;
            this.b = null;
            this.c = 0;
        } else if (inputStream2 != inputStream) {
            this.d = inputStream;
            this.b = null;
            this.c = 0;
        }
        try {
            ASN1Set aSN1Set = this.b;
            if (aSN1Set == null) {
                if (!inputStream.markSupported()) {
                    inputStream = new ByteArrayInputStream(Streams.readAll(inputStream));
                }
                inputStream.mark(1);
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                inputStream.reset();
                if (read != 48) {
                    return d(h.b(inputStream));
                }
                return d(ASN1Sequence.getInstance(new ASN1InputStream(inputStream).readObject()));
            } else if (this.c != aSN1Set.size()) {
                return c();
            } else {
                this.b = null;
                this.c = 0;
                return null;
            }
        } catch (Exception e2) {
            throw new a(this, a2.b.a.a.a.F2(e2, a2.b.a.a.a.L("parsing issue: ")), e2);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate engineGenerateCertificate = engineGenerateCertificate(bufferedInputStream);
            if (engineGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCertificate);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.c.iterator();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return new PKIXCertPath(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List list) throws CertificateException {
        for (Object obj : list) {
            if (!(obj == null || (obj instanceof X509Certificate))) {
                StringBuilder L = a2.b.a.a.a.L("list contains non X509Certificate object while creating CertPath\n");
                L.append(obj.toString());
                throw new CertificateException(L.toString());
            }
        }
        return new PKIXCertPath(list);
    }
}
