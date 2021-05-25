package org.spongycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
public class PKIXExtendedParameters implements CertPathParameters {
    public static final int CHAIN_VALIDITY_MODEL = 1;
    public static final int PKIX_VALIDITY_MODEL = 0;
    public final PKIXParameters a;
    public final PKIXCertStoreSelector b;
    public final Date c;
    public final List<PKIXCertStore> d;
    public final Map<GeneralName, PKIXCertStore> e;
    public final List<PKIXCRLStore> f;
    public final Map<GeneralName, PKIXCRLStore> g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final Set<TrustAnchor> k;

    public PKIXExtendedParameters(Builder builder, a aVar) {
        this.a = builder.a;
        this.c = builder.b;
        this.d = Collections.unmodifiableList(builder.d);
        this.e = Collections.unmodifiableMap(new HashMap(builder.e));
        this.f = Collections.unmodifiableList(builder.f);
        this.g = Collections.unmodifiableMap(new HashMap(builder.g));
        this.b = builder.c;
        this.h = builder.h;
        this.i = builder.j;
        this.j = builder.i;
        this.k = Collections.unmodifiableSet(builder.k);
    }

    @Override // java.security.cert.CertPathParameters, java.lang.Object
    public Object clone() {
        return this;
    }

    public List<PKIXCRLStore> getCRLStores() {
        return this.f;
    }

    public List getCertPathCheckers() {
        return this.a.getCertPathCheckers();
    }

    public List<CertStore> getCertStores() {
        return this.a.getCertStores();
    }

    public List<PKIXCertStore> getCertificateStores() {
        return this.d;
    }

    public Date getDate() {
        return new Date(this.c.getTime());
    }

    public Set getInitialPolicies() {
        return this.a.getInitialPolicies();
    }

    public Map<GeneralName, PKIXCRLStore> getNamedCRLStoreMap() {
        return this.g;
    }

    public Map<GeneralName, PKIXCertStore> getNamedCertificateStoreMap() {
        return this.e;
    }

    public String getSigProvider() {
        return this.a.getSigProvider();
    }

    public PKIXCertStoreSelector getTargetConstraints() {
        return this.b;
    }

    public Set getTrustAnchors() {
        return this.k;
    }

    public int getValidityModel() {
        return this.j;
    }

    public boolean isAnyPolicyInhibited() {
        return this.a.isAnyPolicyInhibited();
    }

    public boolean isExplicitPolicyRequired() {
        return this.a.isExplicitPolicyRequired();
    }

    public boolean isPolicyMappingInhibited() {
        return this.a.isPolicyMappingInhibited();
    }

    public boolean isRevocationEnabled() {
        return this.h;
    }

    public boolean isUseDeltasEnabled() {
        return this.i;
    }

    public static class Builder {
        public final PKIXParameters a;
        public final Date b;
        public PKIXCertStoreSelector c;
        public List<PKIXCertStore> d = new ArrayList();
        public Map<GeneralName, PKIXCertStore> e = new HashMap();
        public List<PKIXCRLStore> f = new ArrayList();
        public Map<GeneralName, PKIXCRLStore> g = new HashMap();
        public boolean h;
        public int i = 0;
        public boolean j = false;
        public Set<TrustAnchor> k;

        public Builder(PKIXParameters pKIXParameters) {
            this.a = (PKIXParameters) pKIXParameters.clone();
            CertSelector targetCertConstraints = pKIXParameters.getTargetCertConstraints();
            if (targetCertConstraints != null) {
                this.c = new PKIXCertStoreSelector.Builder(targetCertConstraints).build();
            }
            Date date = pKIXParameters.getDate();
            this.b = date == null ? new Date() : date;
            this.h = pKIXParameters.isRevocationEnabled();
            this.k = pKIXParameters.getTrustAnchors();
        }

        public Builder addCRLStore(PKIXCRLStore pKIXCRLStore) {
            this.f.add(pKIXCRLStore);
            return this;
        }

        public Builder addCertificateStore(PKIXCertStore pKIXCertStore) {
            this.d.add(pKIXCertStore);
            return this;
        }

        public Builder addNamedCRLStore(GeneralName generalName, PKIXCRLStore pKIXCRLStore) {
            this.g.put(generalName, pKIXCRLStore);
            return this;
        }

        public Builder addNamedCertificateStore(GeneralName generalName, PKIXCertStore pKIXCertStore) {
            this.e.put(generalName, pKIXCertStore);
            return this;
        }

        public PKIXExtendedParameters build() {
            return new PKIXExtendedParameters(this, null);
        }

        public void setRevocationEnabled(boolean z) {
            this.h = z;
        }

        public Builder setTargetConstraints(PKIXCertStoreSelector pKIXCertStoreSelector) {
            this.c = pKIXCertStoreSelector;
            return this;
        }

        public Builder setTrustAnchor(TrustAnchor trustAnchor) {
            this.k = Collections.singleton(trustAnchor);
            return this;
        }

        public Builder setTrustAnchors(Set<TrustAnchor> set) {
            this.k = set;
            return this;
        }

        public Builder setUseDeltasEnabled(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setValidityModel(int i2) {
            this.i = i2;
            return this;
        }

        public Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.a = pKIXExtendedParameters.a;
            this.b = pKIXExtendedParameters.c;
            this.c = pKIXExtendedParameters.b;
            this.d = new ArrayList(pKIXExtendedParameters.d);
            this.e = new HashMap(pKIXExtendedParameters.e);
            this.f = new ArrayList(pKIXExtendedParameters.f);
            this.g = new HashMap(pKIXExtendedParameters.g);
            this.j = pKIXExtendedParameters.i;
            this.i = pKIXExtendedParameters.j;
            this.h = pKIXExtendedParameters.isRevocationEnabled();
            this.k = pKIXExtendedParameters.getTrustAnchors();
        }
    }
}
