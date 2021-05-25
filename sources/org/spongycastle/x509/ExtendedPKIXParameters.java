package org.spongycastle.x509;

import a2.b.a.a.a;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.spongycastle.util.Selector;
import org.spongycastle.util.Store;
public class ExtendedPKIXParameters extends PKIXParameters {
    public static final int CHAIN_VALIDITY_MODEL = 1;
    public static final int PKIX_VALIDITY_MODEL = 0;
    public List a = new ArrayList();
    public Selector b;
    public boolean c;
    public List d = new ArrayList();
    public Set e = new HashSet();
    public Set f = new HashSet();
    public Set g = new HashSet();
    public Set h = new HashSet();
    public int i = 0;
    public boolean j = false;

    public ExtendedPKIXParameters(Set set) throws InvalidAlgorithmParameterException {
        super(set);
    }

    public static ExtendedPKIXParameters getInstance(PKIXParameters pKIXParameters) {
        try {
            ExtendedPKIXParameters extendedPKIXParameters = new ExtendedPKIXParameters(pKIXParameters.getTrustAnchors());
            extendedPKIXParameters.setParams(pKIXParameters);
            return extendedPKIXParameters;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public void addAddionalStore(Store store) {
        addAdditionalStore(store);
    }

    public void addAdditionalStore(Store store) {
        if (store != null) {
            this.d.add(store);
        }
    }

    public void addStore(Store store) {
        if (store != null) {
            this.a.add(store);
        }
    }

    @Override // java.security.cert.PKIXParameters, java.security.cert.CertPathParameters, java.lang.Object
    public Object clone() {
        try {
            ExtendedPKIXParameters extendedPKIXParameters = new ExtendedPKIXParameters(getTrustAnchors());
            extendedPKIXParameters.setParams(this);
            return extendedPKIXParameters;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public List getAdditionalStores() {
        return Collections.unmodifiableList(this.d);
    }

    public Set getAttrCertCheckers() {
        return Collections.unmodifiableSet(this.h);
    }

    public Set getNecessaryACAttributes() {
        return Collections.unmodifiableSet(this.f);
    }

    public Set getProhibitedACAttributes() {
        return Collections.unmodifiableSet(this.g);
    }

    public List getStores() {
        return Collections.unmodifiableList(new ArrayList(this.a));
    }

    public Selector getTargetConstraints() {
        Selector selector = this.b;
        if (selector != null) {
            return (Selector) selector.clone();
        }
        return null;
    }

    public Set getTrustedACIssuers() {
        return Collections.unmodifiableSet(this.e);
    }

    public int getValidityModel() {
        return this.i;
    }

    public boolean isAdditionalLocationsEnabled() {
        return this.c;
    }

    public boolean isUseDeltasEnabled() {
        return this.j;
    }

    public void setAdditionalLocationsEnabled(boolean z) {
        this.c = z;
    }

    public void setAttrCertCheckers(Set set) {
        if (set == null) {
            this.h.clear();
            return;
        }
        for (Object obj : set) {
            if (!(obj instanceof PKIXAttrCertChecker)) {
                throw new ClassCastException(a.D2(PKIXAttrCertChecker.class, a.L("All elements of set must be of type "), "."));
            }
        }
        this.h.clear();
        this.h.addAll(set);
    }

    @Override // java.security.cert.PKIXParameters
    public void setCertStores(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                addCertStore((CertStore) it.next());
            }
        }
    }

    public void setNecessaryACAttributes(Set set) {
        if (set == null) {
            this.f.clear();
            return;
        }
        for (Object obj : set) {
            if (!(obj instanceof String)) {
                throw new ClassCastException("All elements of set must be of type String.");
            }
        }
        this.f.clear();
        this.f.addAll(set);
    }

    public void setParams(PKIXParameters pKIXParameters) {
        Selector selector;
        setDate(pKIXParameters.getDate());
        setCertPathCheckers(pKIXParameters.getCertPathCheckers());
        setCertStores(pKIXParameters.getCertStores());
        setAnyPolicyInhibited(pKIXParameters.isAnyPolicyInhibited());
        setExplicitPolicyRequired(pKIXParameters.isExplicitPolicyRequired());
        setPolicyMappingInhibited(pKIXParameters.isPolicyMappingInhibited());
        setRevocationEnabled(pKIXParameters.isRevocationEnabled());
        setInitialPolicies(pKIXParameters.getInitialPolicies());
        setPolicyQualifiersRejected(pKIXParameters.getPolicyQualifiersRejected());
        setSigProvider(pKIXParameters.getSigProvider());
        setTargetCertConstraints(pKIXParameters.getTargetCertConstraints());
        try {
            setTrustAnchors(pKIXParameters.getTrustAnchors());
            if (pKIXParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) pKIXParameters;
                this.i = extendedPKIXParameters.i;
                this.j = extendedPKIXParameters.j;
                this.c = extendedPKIXParameters.c;
                Selector selector2 = extendedPKIXParameters.b;
                if (selector2 == null) {
                    selector = null;
                } else {
                    selector = (Selector) selector2.clone();
                }
                this.b = selector;
                this.a = new ArrayList(extendedPKIXParameters.a);
                this.d = new ArrayList(extendedPKIXParameters.d);
                this.e = new HashSet(extendedPKIXParameters.e);
                this.g = new HashSet(extendedPKIXParameters.g);
                this.f = new HashSet(extendedPKIXParameters.f);
                this.h = new HashSet(extendedPKIXParameters.h);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public void setProhibitedACAttributes(Set set) {
        if (set == null) {
            this.g.clear();
            return;
        }
        for (Object obj : set) {
            if (!(obj instanceof String)) {
                throw new ClassCastException("All elements of set must be of type String.");
            }
        }
        this.g.clear();
        this.g.addAll(set);
    }

    public void setStores(List list) {
        if (list == null) {
            this.a = new ArrayList();
            return;
        }
        for (Object obj : list) {
            if (!(obj instanceof Store)) {
                throw new ClassCastException("All elements of list must be of type org.spongycastle.util.Store.");
            }
        }
        this.a = new ArrayList(list);
    }

    @Override // java.security.cert.PKIXParameters
    public void setTargetCertConstraints(CertSelector certSelector) {
        super.setTargetCertConstraints(certSelector);
        if (certSelector != null) {
            this.b = X509CertStoreSelector.getInstance((X509CertSelector) certSelector);
        } else {
            this.b = null;
        }
    }

    public void setTargetConstraints(Selector selector) {
        if (selector != null) {
            this.b = (Selector) selector.clone();
        } else {
            this.b = null;
        }
    }

    public void setTrustedACIssuers(Set set) {
        if (set == null) {
            this.e.clear();
            return;
        }
        for (Object obj : set) {
            if (!(obj instanceof TrustAnchor)) {
                throw new ClassCastException(a.D2(TrustAnchor.class, a.L("All elements of set must be of type "), "."));
            }
        }
        this.e.clear();
        this.e.addAll(set);
    }

    public void setUseDeltasEnabled(boolean z) {
        this.j = z;
    }

    public void setValidityModel(int i2) {
        this.i = i2;
    }
}
