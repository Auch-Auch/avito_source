package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.Selector;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509CRLStoreSelector;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;
public class X509StoreLDAPCRLs extends X509StoreSpi {
    public LDAPStoreHelper a;

    @Override // org.spongycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) throws StoreException {
        if (!(selector instanceof X509CRLStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509CRLStoreSelector x509CRLStoreSelector = (X509CRLStoreSelector) selector;
        HashSet hashSet = new HashSet();
        if (x509CRLStoreSelector.isDeltaCRLIndicatorEnabled()) {
            hashSet.addAll(this.a.getDeltaCertificateRevocationLists(x509CRLStoreSelector));
        } else {
            hashSet.addAll(this.a.getDeltaCertificateRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.a.getAttributeAuthorityRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.a.getAttributeCertificateRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.a.getAuthorityRevocationLists(x509CRLStoreSelector));
            hashSet.addAll(this.a.getCertificateRevocationLists(x509CRLStoreSelector));
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
