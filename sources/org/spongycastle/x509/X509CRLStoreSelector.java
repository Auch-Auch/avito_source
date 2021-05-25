package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.extension.X509ExtensionUtil;
public class X509CRLStoreSelector extends X509CRLSelector implements Selector {
    public boolean a = false;
    public boolean b = false;
    public BigInteger c = null;
    public byte[] d = null;
    public boolean e = false;
    public X509AttributeCertificate f;

    public static X509CRLStoreSelector getInstance(X509CRLSelector x509CRLSelector) {
        if (x509CRLSelector != null) {
            X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
            x509CRLStoreSelector.setCertificateChecking(x509CRLSelector.getCertificateChecking());
            x509CRLStoreSelector.setDateAndTime(x509CRLSelector.getDateAndTime());
            try {
                x509CRLStoreSelector.setIssuerNames(x509CRLSelector.getIssuerNames());
                x509CRLStoreSelector.setIssuers(x509CRLSelector.getIssuers());
                x509CRLStoreSelector.setMaxCRLNumber(x509CRLSelector.getMaxCRL());
                x509CRLStoreSelector.setMinCRLNumber(x509CRLSelector.getMinCRL());
                return x509CRLStoreSelector;
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("cannot create from null selector");
        }
    }

    @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector, java.lang.Object, org.spongycastle.util.Selector
    public Object clone() {
        X509CRLStoreSelector instance = getInstance(this);
        instance.a = this.a;
        instance.b = this.b;
        instance.c = this.c;
        instance.f = this.f;
        instance.e = this.e;
        instance.d = Arrays.clone(this.d);
        return instance;
    }

    public X509AttributeCertificate getAttrCertificateChecking() {
        return this.f;
    }

    public byte[] getIssuingDistributionPoint() {
        return Arrays.clone(this.d);
    }

    public BigInteger getMaxBaseCRLNumber() {
        return this.c;
    }

    public boolean isCompleteCRLEnabled() {
        return this.b;
    }

    public boolean isDeltaCRLIndicatorEnabled() {
        return this.a;
    }

    public boolean isIssuingDistributionPointEnabled() {
        return this.e;
    }

    @Override // org.spongycastle.util.Selector
    public boolean match(Object obj) {
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        X509CRL x509crl = (X509CRL) obj;
        ASN1Integer aSN1Integer = null;
        try {
            byte[] extensionValue = x509crl.getExtensionValue(X509Extensions.DeltaCRLIndicator.getId());
            if (extensionValue != null) {
                aSN1Integer = ASN1Integer.getInstance(X509ExtensionUtil.fromExtensionValue(extensionValue));
            }
            if (isDeltaCRLIndicatorEnabled() && aSN1Integer == null) {
                return false;
            }
            if (isCompleteCRLEnabled() && aSN1Integer != null) {
                return false;
            }
            if (aSN1Integer != null && this.c != null && aSN1Integer.getPositiveValue().compareTo(this.c) == 1) {
                return false;
            }
            if (this.e) {
                byte[] extensionValue2 = x509crl.getExtensionValue(X509Extensions.IssuingDistributionPoint.getId());
                byte[] bArr = this.d;
                if (bArr == null) {
                    if (extensionValue2 != null) {
                        return false;
                    }
                } else if (!Arrays.areEqual(extensionValue2, bArr)) {
                    return false;
                }
            }
            return super.match((CRL) x509crl);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setAttrCertificateChecking(X509AttributeCertificate x509AttributeCertificate) {
        this.f = x509AttributeCertificate;
    }

    public void setCompleteCRLEnabled(boolean z) {
        this.b = z;
    }

    public void setDeltaCRLIndicatorEnabled(boolean z) {
        this.a = z;
    }

    public void setIssuingDistributionPoint(byte[] bArr) {
        this.d = Arrays.clone(bArr);
    }

    public void setIssuingDistributionPointEnabled(boolean z) {
        this.e = z;
    }

    public void setMaxBaseCRLNumber(BigInteger bigInteger) {
        this.c = bigInteger;
    }

    @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
    public boolean match(CRL crl) {
        return match((Object) crl);
    }
}
