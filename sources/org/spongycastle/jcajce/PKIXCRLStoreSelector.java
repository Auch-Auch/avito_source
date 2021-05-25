package org.spongycastle.jcajce;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;
public class PKIXCRLStoreSelector<T extends CRL> implements Selector<T> {
    public final CRLSelector a;
    public final boolean b;
    public final boolean c;
    public final BigInteger d;
    public final byte[] e;
    public final boolean f;

    public static class Builder {
        public final CRLSelector a;
        public boolean b = false;
        public boolean c = false;
        public BigInteger d = null;
        public byte[] e = null;
        public boolean f = false;

        public Builder(CRLSelector cRLSelector) {
            this.a = (CRLSelector) cRLSelector.clone();
        }

        public PKIXCRLStoreSelector<? extends CRL> build() {
            return new PKIXCRLStoreSelector<>(this, null);
        }

        public Builder setCompleteCRLEnabled(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setDeltaCRLIndicatorEnabled(boolean z) {
            this.b = z;
            return this;
        }

        public void setIssuingDistributionPoint(byte[] bArr) {
            this.e = Arrays.clone(bArr);
        }

        public void setIssuingDistributionPointEnabled(boolean z) {
            this.f = z;
        }

        public void setMaxBaseCRLNumber(BigInteger bigInteger) {
            this.d = bigInteger;
        }
    }

    public static class b extends X509CRLSelector {
        public final PKIXCRLStoreSelector a;

        public b(PKIXCRLStoreSelector pKIXCRLStoreSelector) {
            this.a = pKIXCRLStoreSelector;
            CRLSelector cRLSelector = pKIXCRLStoreSelector.a;
            if (cRLSelector instanceof X509CRLSelector) {
                X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
                setCertificateChecking(x509CRLSelector.getCertificateChecking());
                setDateAndTime(x509CRLSelector.getDateAndTime());
                setIssuers(x509CRLSelector.getIssuers());
                setMinCRLNumber(x509CRLSelector.getMinCRL());
                setMaxCRLNumber(x509CRLSelector.getMaxCRL());
            }
        }

        @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
        public boolean match(CRL crl) {
            PKIXCRLStoreSelector pKIXCRLStoreSelector = this.a;
            if (pKIXCRLStoreSelector == null) {
                return crl != null;
            }
            return pKIXCRLStoreSelector.match(crl);
        }
    }

    public PKIXCRLStoreSelector(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
    }

    public static Collection<? extends CRL> getCRLs(PKIXCRLStoreSelector pKIXCRLStoreSelector, CertStore certStore) throws CertStoreException {
        return certStore.getCRLs(new b(pKIXCRLStoreSelector));
    }

    @Override // org.spongycastle.util.Selector, java.lang.Object
    public Object clone() {
        return this;
    }

    public X509Certificate getCertificateChecking() {
        CRLSelector cRLSelector = this.a;
        if (cRLSelector instanceof X509CRLSelector) {
            return ((X509CRLSelector) cRLSelector).getCertificateChecking();
        }
        return null;
    }

    public byte[] getIssuingDistributionPoint() {
        return Arrays.clone(this.e);
    }

    public BigInteger getMaxBaseCRLNumber() {
        return this.d;
    }

    public boolean isCompleteCRLEnabled() {
        return this.c;
    }

    public boolean isDeltaCRLIndicatorEnabled() {
        return this.b;
    }

    public boolean isIssuingDistributionPointEnabled() {
        return this.f;
    }

    public boolean match(CRL crl) {
        if (!(crl instanceof X509CRL)) {
            return this.a.match(crl);
        }
        X509CRL x509crl = (X509CRL) crl;
        ASN1Integer aSN1Integer = null;
        try {
            byte[] extensionValue = x509crl.getExtensionValue(Extension.deltaCRLIndicator.getId());
            if (extensionValue != null) {
                aSN1Integer = ASN1Integer.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets());
            }
            if (isDeltaCRLIndicatorEnabled() && aSN1Integer == null) {
                return false;
            }
            if (isCompleteCRLEnabled() && aSN1Integer != null) {
                return false;
            }
            if (aSN1Integer != null && this.d != null && aSN1Integer.getPositiveValue().compareTo(this.d) == 1) {
                return false;
            }
            if (this.f) {
                byte[] extensionValue2 = x509crl.getExtensionValue(Extension.issuingDistributionPoint.getId());
                byte[] bArr = this.e;
                if (bArr == null) {
                    if (extensionValue2 != null) {
                        return false;
                    }
                } else if (!Arrays.areEqual(extensionValue2, bArr)) {
                    return false;
                }
            }
            return this.a.match(crl);
        } catch (Exception unused) {
            return false;
        }
    }
}
