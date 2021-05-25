package org.spongycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.CertificatePair;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.provider.X509CertificateObject;
import x6.e.g.c;
public class X509CertificatePair {
    public X509Certificate a;
    public X509Certificate b;

    public X509CertificatePair(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        new BCJcaJceHelper();
        this.a = x509Certificate;
        this.b = x509Certificate2;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == null || !(obj instanceof X509CertificatePair)) {
            return false;
        }
        X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
        X509Certificate x509Certificate = this.a;
        if (x509Certificate != null) {
            z = x509Certificate.equals(x509CertificatePair.a);
        } else {
            z = x509CertificatePair.a == null;
        }
        X509Certificate x509Certificate2 = this.b;
        if (x509Certificate2 != null) {
            z2 = x509Certificate2.equals(x509CertificatePair.b);
        } else {
            z2 = x509CertificatePair.b == null;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        Certificate certificate;
        try {
            Certificate certificate2 = null;
            if (this.a != null) {
                certificate = Certificate.getInstance(new ASN1InputStream(this.a.getEncoded()).readObject());
                if (certificate == null) {
                    throw new CertificateEncodingException("unable to get encoding for forward");
                }
            } else {
                certificate = null;
            }
            if (this.b != null) {
                certificate2 = Certificate.getInstance(new ASN1InputStream(this.b.getEncoded()).readObject());
                if (certificate2 == null) {
                    throw new CertificateEncodingException("unable to get encoding for reverse");
                }
            }
            return new CertificatePair(certificate, certificate2).getEncoded(ASN1Encoding.DER);
        } catch (IllegalArgumentException e) {
            throw new c(e.toString(), e);
        } catch (IOException e2) {
            throw new c(e2.toString(), e2);
        }
    }

    public X509Certificate getForward() {
        return this.a;
    }

    public X509Certificate getReverse() {
        return this.b;
    }

    public int hashCode() {
        X509Certificate x509Certificate = this.a;
        int i = -1;
        if (x509Certificate != null) {
            i = -1 ^ x509Certificate.hashCode();
        }
        X509Certificate x509Certificate2 = this.b;
        return x509Certificate2 != null ? (i * 17) ^ x509Certificate2.hashCode() : i;
    }

    public X509CertificatePair(CertificatePair certificatePair) throws CertificateParsingException {
        new BCJcaJceHelper();
        if (certificatePair.getForward() != null) {
            this.a = new X509CertificateObject(certificatePair.getForward());
        }
        if (certificatePair.getReverse() != null) {
            this.b = new X509CertificateObject(certificatePair.getReverse());
        }
    }
}
