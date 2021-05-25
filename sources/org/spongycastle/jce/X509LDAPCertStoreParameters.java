package org.spongycastle.jce;

import java.security.cert.CertStoreParameters;
import java.security.cert.LDAPCertStoreParameters;
import org.spongycastle.x509.X509StoreParameters;
public class X509LDAPCertStoreParameters implements X509StoreParameters, CertStoreParameters {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static class Builder {
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String F;
        public String G;
        public String H;
        public String I;
        public String J;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public Builder() {
            this("ldap://localhost:389", "");
        }

        public X509LDAPCertStoreParameters build() {
            if (this.n != null && this.o != null && this.p != null && this.q != null && this.r != null && this.s != null && this.t != null && this.u != null && this.v != null && this.w != null && this.x != null && this.y != null && this.z != null && this.A != null && this.B != null && this.C != null && this.D != null && this.E != null && this.F != null && this.G != null && this.H != null && this.I != null) {
                return new X509LDAPCertStoreParameters(this, null);
            }
            throw new IllegalArgumentException("Necessary parameters not specified.");
        }

        public Builder setAACertificateAttribute(String str) {
            this.j = str;
            return this;
        }

        public Builder setAACertificateSubjectAttributeName(String str) {
            this.F = str;
            return this;
        }

        public Builder setAttributeAuthorityRevocationListAttribute(String str) {
            this.m = str;
            return this;
        }

        public Builder setAttributeAuthorityRevocationListIssuerAttributeName(String str) {
            this.I = str;
            return this;
        }

        public Builder setAttributeCertificateAttributeAttribute(String str) {
            this.i = str;
            return this;
        }

        public Builder setAttributeCertificateAttributeSubjectAttributeName(String str) {
            this.E = str;
            return this;
        }

        public Builder setAttributeCertificateRevocationListAttribute(String str) {
            this.l = str;
            return this;
        }

        public Builder setAttributeCertificateRevocationListIssuerAttributeName(String str) {
            this.H = str;
            return this;
        }

        public Builder setAttributeDescriptorCertificateAttribute(String str) {
            this.k = str;
            return this;
        }

        public Builder setAttributeDescriptorCertificateSubjectAttributeName(String str) {
            this.G = str;
            return this;
        }

        public Builder setAuthorityRevocationListAttribute(String str) {
            this.h = str;
            return this;
        }

        public Builder setAuthorityRevocationListIssuerAttributeName(String str) {
            this.D = str;
            return this;
        }

        public Builder setCACertificateAttribute(String str) {
            this.d = str;
            return this;
        }

        public Builder setCACertificateSubjectAttributeName(String str) {
            this.z = str;
            return this;
        }

        public Builder setCertificateRevocationListAttribute(String str) {
            this.f = str;
            return this;
        }

        public Builder setCertificateRevocationListIssuerAttributeName(String str) {
            this.B = str;
            return this;
        }

        public Builder setCrossCertificateAttribute(String str) {
            this.e = str;
            return this;
        }

        public Builder setCrossCertificateSubjectAttributeName(String str) {
            this.A = str;
            return this;
        }

        public Builder setDeltaRevocationListAttribute(String str) {
            this.g = str;
            return this;
        }

        public Builder setDeltaRevocationListIssuerAttributeName(String str) {
            this.C = str;
            return this;
        }

        public Builder setLdapAACertificateAttributeName(String str) {
            this.u = str;
            return this;
        }

        public Builder setLdapAttributeAuthorityRevocationListAttributeName(String str) {
            this.x = str;
            return this;
        }

        public Builder setLdapAttributeCertificateAttributeAttributeName(String str) {
            this.t = str;
            return this;
        }

        public Builder setLdapAttributeCertificateRevocationListAttributeName(String str) {
            this.w = str;
            return this;
        }

        public Builder setLdapAttributeDescriptorCertificateAttributeName(String str) {
            this.v = str;
            return this;
        }

        public Builder setLdapAuthorityRevocationListAttributeName(String str) {
            this.s = str;
            return this;
        }

        public Builder setLdapCACertificateAttributeName(String str) {
            this.o = str;
            return this;
        }

        public Builder setLdapCertificateRevocationListAttributeName(String str) {
            this.q = str;
            return this;
        }

        public Builder setLdapCrossCertificateAttributeName(String str) {
            this.p = str;
            return this;
        }

        public Builder setLdapDeltaRevocationListAttributeName(String str) {
            this.r = str;
            return this;
        }

        public Builder setLdapUserCertificateAttributeName(String str) {
            this.n = str;
            return this;
        }

        public Builder setSearchForSerialNumberIn(String str) {
            this.J = str;
            return this;
        }

        public Builder setUserCertificateAttribute(String str) {
            this.c = str;
            return this;
        }

        public Builder setUserCertificateSubjectAttributeName(String str) {
            this.y = str;
            return this;
        }

        public Builder(String str, String str2) {
            this.a = str;
            if (str2 == null) {
                this.b = "";
            } else {
                this.b = str2;
            }
            this.c = "userCertificate";
            this.d = "cACertificate";
            this.e = "crossCertificatePair";
            this.f = "certificateRevocationList";
            this.g = "deltaRevocationList";
            this.h = "authorityRevocationList";
            this.i = "attributeCertificateAttribute";
            this.j = "aACertificate";
            this.k = "attributeDescriptorCertificate";
            this.l = "attributeCertificateRevocationList";
            this.m = "attributeAuthorityRevocationList";
            this.n = "cn";
            this.o = "cn ou o";
            this.p = "cn ou o";
            this.q = "cn ou o";
            this.r = "cn ou o";
            this.s = "cn ou o";
            this.t = "cn";
            this.u = "cn o ou";
            this.v = "cn o ou";
            this.w = "cn o ou";
            this.x = "cn o ou";
            this.y = "cn";
            this.z = "o ou";
            this.A = "o ou";
            this.B = "o ou";
            this.C = "o ou";
            this.D = "o ou";
            this.E = "cn";
            this.F = "o ou";
            this.G = "o ou";
            this.H = "o ou";
            this.I = "o ou";
            this.J = "uid serialNumber cn";
        }
    }

    public X509LDAPCertStoreParameters(Builder builder, a aVar) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = builder.A;
        this.B = builder.B;
        this.C = builder.C;
        this.D = builder.D;
        this.E = builder.E;
        this.F = builder.F;
        this.G = builder.G;
        this.H = builder.H;
        this.I = builder.I;
        this.J = builder.J;
    }

    public static X509LDAPCertStoreParameters getInstance(LDAPCertStoreParameters lDAPCertStoreParameters) {
        StringBuilder L = a2.b.a.a.a.L("ldap://");
        L.append(lDAPCertStoreParameters.getServerName());
        L.append(":");
        L.append(lDAPCertStoreParameters.getPort());
        return new Builder(L.toString(), "").build();
    }

    public final int a(int i2, Object obj) {
        return (i2 * 29) + (obj == null ? 0 : obj.hashCode());
    }

    public final boolean b(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    @Override // java.security.cert.CertStoreParameters, java.lang.Object
    public Object clone() {
        return this;
    }

    public boolean equal(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509LDAPCertStoreParameters)) {
            return false;
        }
        X509LDAPCertStoreParameters x509LDAPCertStoreParameters = (X509LDAPCertStoreParameters) obj;
        if (!b(this.a, x509LDAPCertStoreParameters.a) || !b(this.b, x509LDAPCertStoreParameters.b) || !b(this.c, x509LDAPCertStoreParameters.c) || !b(this.d, x509LDAPCertStoreParameters.d) || !b(this.e, x509LDAPCertStoreParameters.e) || !b(this.f, x509LDAPCertStoreParameters.f) || !b(this.g, x509LDAPCertStoreParameters.g) || !b(this.h, x509LDAPCertStoreParameters.h) || !b(this.i, x509LDAPCertStoreParameters.i) || !b(this.j, x509LDAPCertStoreParameters.j) || !b(this.k, x509LDAPCertStoreParameters.k) || !b(this.l, x509LDAPCertStoreParameters.l) || !b(this.m, x509LDAPCertStoreParameters.m) || !b(this.n, x509LDAPCertStoreParameters.n) || !b(this.o, x509LDAPCertStoreParameters.o) || !b(this.p, x509LDAPCertStoreParameters.p) || !b(this.q, x509LDAPCertStoreParameters.q) || !b(this.r, x509LDAPCertStoreParameters.r) || !b(this.s, x509LDAPCertStoreParameters.s) || !b(this.t, x509LDAPCertStoreParameters.t) || !b(this.u, x509LDAPCertStoreParameters.u) || !b(this.v, x509LDAPCertStoreParameters.v) || !b(this.w, x509LDAPCertStoreParameters.w) || !b(this.x, x509LDAPCertStoreParameters.x) || !b(this.y, x509LDAPCertStoreParameters.y) || !b(this.z, x509LDAPCertStoreParameters.z) || !b(this.A, x509LDAPCertStoreParameters.A) || !b(this.B, x509LDAPCertStoreParameters.B) || !b(this.C, x509LDAPCertStoreParameters.C) || !b(this.D, x509LDAPCertStoreParameters.D) || !b(this.E, x509LDAPCertStoreParameters.E) || !b(this.F, x509LDAPCertStoreParameters.F) || !b(this.G, x509LDAPCertStoreParameters.G) || !b(this.H, x509LDAPCertStoreParameters.H) || !b(this.I, x509LDAPCertStoreParameters.I) || !b(this.J, x509LDAPCertStoreParameters.J)) {
            return false;
        }
        return true;
    }

    public String getAACertificateAttribute() {
        return this.j;
    }

    public String getAACertificateSubjectAttributeName() {
        return this.F;
    }

    public String getAttributeAuthorityRevocationListAttribute() {
        return this.m;
    }

    public String getAttributeAuthorityRevocationListIssuerAttributeName() {
        return this.I;
    }

    public String getAttributeCertificateAttributeAttribute() {
        return this.i;
    }

    public String getAttributeCertificateAttributeSubjectAttributeName() {
        return this.E;
    }

    public String getAttributeCertificateRevocationListAttribute() {
        return this.l;
    }

    public String getAttributeCertificateRevocationListIssuerAttributeName() {
        return this.H;
    }

    public String getAttributeDescriptorCertificateAttribute() {
        return this.k;
    }

    public String getAttributeDescriptorCertificateSubjectAttributeName() {
        return this.G;
    }

    public String getAuthorityRevocationListAttribute() {
        return this.h;
    }

    public String getAuthorityRevocationListIssuerAttributeName() {
        return this.D;
    }

    public String getBaseDN() {
        return this.b;
    }

    public String getCACertificateAttribute() {
        return this.d;
    }

    public String getCACertificateSubjectAttributeName() {
        return this.z;
    }

    public String getCertificateRevocationListAttribute() {
        return this.f;
    }

    public String getCertificateRevocationListIssuerAttributeName() {
        return this.B;
    }

    public String getCrossCertificateAttribute() {
        return this.e;
    }

    public String getCrossCertificateSubjectAttributeName() {
        return this.A;
    }

    public String getDeltaRevocationListAttribute() {
        return this.g;
    }

    public String getDeltaRevocationListIssuerAttributeName() {
        return this.C;
    }

    public String getLdapAACertificateAttributeName() {
        return this.u;
    }

    public String getLdapAttributeAuthorityRevocationListAttributeName() {
        return this.x;
    }

    public String getLdapAttributeCertificateAttributeAttributeName() {
        return this.t;
    }

    public String getLdapAttributeCertificateRevocationListAttributeName() {
        return this.w;
    }

    public String getLdapAttributeDescriptorCertificateAttributeName() {
        return this.v;
    }

    public String getLdapAuthorityRevocationListAttributeName() {
        return this.s;
    }

    public String getLdapCACertificateAttributeName() {
        return this.o;
    }

    public String getLdapCertificateRevocationListAttributeName() {
        return this.q;
    }

    public String getLdapCrossCertificateAttributeName() {
        return this.p;
    }

    public String getLdapDeltaRevocationListAttributeName() {
        return this.r;
    }

    public String getLdapURL() {
        return this.a;
    }

    public String getLdapUserCertificateAttributeName() {
        return this.n;
    }

    public String getSearchForSerialNumberIn() {
        return this.J;
    }

    public String getUserCertificateAttribute() {
        return this.c;
    }

    public String getUserCertificateSubjectAttributeName() {
        return this.y;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(0, this.c), this.d), this.e), this.f), this.g), this.h), this.i), this.j), this.k), this.l), this.m), this.n), this.o), this.p), this.q), this.r), this.s), this.t), this.u), this.v), this.w), this.x), this.y), this.z), this.A), this.B), this.C), this.D), this.E), this.F), this.G), this.H), this.I), this.J);
    }
}
