package org.spongycastle.jcajce;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.jcajce.PKIXExtendedParameters;
public class PKIXExtendedBuilderParameters implements CertPathParameters {
    public final PKIXExtendedParameters a;
    public final Set<X509Certificate> b;
    public final int c;

    public PKIXExtendedBuilderParameters(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = Collections.unmodifiableSet(builder.c);
        this.c = builder.b;
    }

    @Override // java.security.cert.CertPathParameters, java.lang.Object
    public Object clone() {
        return this;
    }

    public PKIXExtendedParameters getBaseParameters() {
        return this.a;
    }

    public Set getExcludedCerts() {
        return this.b;
    }

    public int getMaxPathLength() {
        return this.c;
    }

    public static class Builder {
        public final PKIXExtendedParameters a;
        public int b = 5;
        public Set<X509Certificate> c = new HashSet();

        public Builder(PKIXBuilderParameters pKIXBuilderParameters) {
            this.a = new PKIXExtendedParameters.Builder(pKIXBuilderParameters).build();
            this.b = pKIXBuilderParameters.getMaxPathLength();
        }

        public Builder addExcludedCerts(Set<X509Certificate> set) {
            this.c.addAll(set);
            return this;
        }

        public PKIXExtendedBuilderParameters build() {
            return new PKIXExtendedBuilderParameters(this, null);
        }

        public Builder setMaxPathLength(int i) {
            if (i >= -1) {
                this.b = i;
                return this;
            }
            throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
        }

        public Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.a = pKIXExtendedParameters;
        }
    }
}
