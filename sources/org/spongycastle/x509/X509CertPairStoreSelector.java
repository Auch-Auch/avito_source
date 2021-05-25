package org.spongycastle.x509;

import org.spongycastle.util.Selector;
public class X509CertPairStoreSelector implements Selector {
    public X509CertStoreSelector a;
    public X509CertStoreSelector b;
    public X509CertificatePair c;

    @Override // org.spongycastle.util.Selector, java.lang.Object
    public Object clone() {
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.c = this.c;
        X509CertStoreSelector x509CertStoreSelector = this.a;
        if (x509CertStoreSelector != null) {
            x509CertPairStoreSelector.setForwardSelector((X509CertStoreSelector) x509CertStoreSelector.clone());
        }
        X509CertStoreSelector x509CertStoreSelector2 = this.b;
        if (x509CertStoreSelector2 != null) {
            x509CertPairStoreSelector.setReverseSelector((X509CertStoreSelector) x509CertStoreSelector2.clone());
        }
        return x509CertPairStoreSelector;
    }

    public X509CertificatePair getCertPair() {
        return this.c;
    }

    public X509CertStoreSelector getForwardSelector() {
        return this.a;
    }

    public X509CertStoreSelector getReverseSelector() {
        return this.b;
    }

    @Override // org.spongycastle.util.Selector
    public boolean match(Object obj) {
        try {
            if (!(obj instanceof X509CertificatePair)) {
                return false;
            }
            X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
            X509CertStoreSelector x509CertStoreSelector = this.a;
            if (x509CertStoreSelector != null && !x509CertStoreSelector.match((Object) x509CertificatePair.getForward())) {
                return false;
            }
            X509CertStoreSelector x509CertStoreSelector2 = this.b;
            if (x509CertStoreSelector2 != null && !x509CertStoreSelector2.match((Object) x509CertificatePair.getReverse())) {
                return false;
            }
            X509CertificatePair x509CertificatePair2 = this.c;
            if (x509CertificatePair2 != null) {
                return x509CertificatePair2.equals(obj);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setCertPair(X509CertificatePair x509CertificatePair) {
        this.c = x509CertificatePair;
    }

    public void setForwardSelector(X509CertStoreSelector x509CertStoreSelector) {
        this.a = x509CertStoreSelector;
    }

    public void setReverseSelector(X509CertStoreSelector x509CertStoreSelector) {
        this.b = x509CertStoreSelector;
    }
}
