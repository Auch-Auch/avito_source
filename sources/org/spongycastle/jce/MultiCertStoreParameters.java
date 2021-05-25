package org.spongycastle.jce;

import java.security.cert.CertStoreParameters;
import java.util.Collection;
public class MultiCertStoreParameters implements CertStoreParameters {
    public Collection a;
    public boolean b;

    public MultiCertStoreParameters(Collection collection) {
        this(collection, true);
    }

    @Override // java.security.cert.CertStoreParameters, java.lang.Object
    public Object clone() {
        return this;
    }

    public Collection getCertStores() {
        return this.a;
    }

    public boolean getSearchAllStores() {
        return this.b;
    }

    public MultiCertStoreParameters(Collection collection, boolean z) {
        this.a = collection;
        this.b = z;
    }
}
