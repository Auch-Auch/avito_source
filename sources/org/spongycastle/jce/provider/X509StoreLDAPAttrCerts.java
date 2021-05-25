package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.util.Selector;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509StoreParameters;
import org.spongycastle.x509.X509StoreSpi;
import org.spongycastle.x509.util.LDAPStoreHelper;
public class X509StoreLDAPAttrCerts extends X509StoreSpi {
    public LDAPStoreHelper a;

    @Override // org.spongycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) throws StoreException {
        if (!(selector instanceof X509AttributeCertStoreSelector)) {
            return Collections.EMPTY_SET;
        }
        X509AttributeCertStoreSelector x509AttributeCertStoreSelector = (X509AttributeCertStoreSelector) selector;
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.a.getAACertificates(x509AttributeCertStoreSelector));
        hashSet.addAll(this.a.getAttributeCertificateAttributes(x509AttributeCertStoreSelector));
        hashSet.addAll(this.a.getAttributeDescriptorCertificates(x509AttributeCertStoreSelector));
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
