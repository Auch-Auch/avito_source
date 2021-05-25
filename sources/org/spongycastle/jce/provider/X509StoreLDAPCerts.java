package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.Selector;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509CertPairStoreSelector;
import org.spongycastle.x509.X509CertStoreSelector;
import org.spongycastle.x509.X509CertificatePair;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;
public class X509StoreLDAPCerts extends X509StoreSpi {
    public LDAPStoreHelper a;

    public final Collection a(X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.setForwardSelector(x509CertStoreSelector);
        x509CertPairStoreSelector.setReverseSelector(new X509CertStoreSelector());
        HashSet hashSet2 = new HashSet(this.a.getCrossCertificatePairs(x509CertPairStoreSelector));
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            X509CertificatePair x509CertificatePair = (X509CertificatePair) it.next();
            if (x509CertificatePair.getForward() != null) {
                hashSet3.add(x509CertificatePair.getForward());
            }
            if (x509CertificatePair.getReverse() != null) {
                hashSet4.add(x509CertificatePair.getReverse());
            }
        }
        hashSet.addAll(hashSet3);
        hashSet.addAll(hashSet4);
        return hashSet;
    }

    @Override // org.spongycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) throws StoreException {
        if (!(selector instanceof X509CertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CertStoreSelector x509CertStoreSelector = (X509CertStoreSelector) selector;
        HashSet hashSet = new HashSet();
        if (x509CertStoreSelector.getBasicConstraints() > 0) {
            hashSet.addAll(this.a.getCACertificates(x509CertStoreSelector));
            hashSet.addAll(a(x509CertStoreSelector));
        } else if (x509CertStoreSelector.getBasicConstraints() == -2) {
            hashSet.addAll(this.a.getUserCertificates(x509CertStoreSelector));
        } else {
            hashSet.addAll(this.a.getUserCertificates(x509CertStoreSelector));
            hashSet.addAll(this.a.getCACertificates(x509CertStoreSelector));
            hashSet.addAll(a(x509CertStoreSelector));
        }
        return hashSet;
    }

    @Override // org.spongycastle.x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (x509StoreParameters instanceof X509LDAPCertStoreParameters) {
            this.a = new LDAPStoreHelper((X509LDAPCertStoreParameters) x509StoreParameters);
            return;
        }
        throw new IllegalArgumentException(a.D2(X509LDAPCertStoreParameters.class, a.L("Initialization parameters must be an instance of "), "."));
    }
}
