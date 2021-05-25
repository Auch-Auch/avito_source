package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.spongycastle.jce.MultiCertStoreParameters;
public class MultiCertStoreSpi extends CertStoreSpi {
    public MultiCertStoreParameters a;

    public MultiCertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof MultiCertStoreParameters) {
            this.a = (MultiCertStoreParameters) certStoreParameters;
            return;
        }
        StringBuilder L = a.L("org.spongycastle.jce.provider.MultiCertStoreSpi: parameter must be a MultiCertStoreParameters object\n");
        L.append(certStoreParameters.toString());
        throw new InvalidAlgorithmParameterException(L.toString());
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        boolean searchAllStores = this.a.getSearchAllStores();
        List arrayList = searchAllStores ? new ArrayList() : Collections.EMPTY_LIST;
        for (CertStore certStore : this.a.getCertStores()) {
            Collection<? extends CRL> cRLs = certStore.getCRLs(cRLSelector);
            if (searchAllStores) {
                arrayList.addAll(cRLs);
            } else if (!cRLs.isEmpty()) {
                return cRLs;
            }
        }
        return arrayList;
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        boolean searchAllStores = this.a.getSearchAllStores();
        List arrayList = searchAllStores ? new ArrayList() : Collections.EMPTY_LIST;
        for (CertStore certStore : this.a.getCertStores()) {
            Collection<? extends Certificate> certificates = certStore.getCertificates(certSelector);
            if (searchAllStores) {
                arrayList.addAll(certificates);
            } else if (!certificates.isEmpty()) {
                return certificates;
            }
        }
        return arrayList;
    }
}
