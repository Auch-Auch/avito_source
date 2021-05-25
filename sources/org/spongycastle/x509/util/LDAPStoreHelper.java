package org.spongycastle.x509.util;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
import org.spongycastle.jce.provider.X509AttrCertParser;
import org.spongycastle.jce.provider.X509CRLParser;
import org.spongycastle.jce.provider.X509CertParser;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CRLStoreSelector;
import org.spongycastle.x509.X509CertPairStoreSelector;
import org.spongycastle.x509.X509CertStoreSelector;
public class LDAPStoreHelper {
    public X509LDAPCertStoreParameters a;
    public Map b = new HashMap(32);

    public LDAPStoreHelper(X509LDAPCertStoreParameters x509LDAPCertStoreParameters) {
        this.a = x509LDAPCertStoreParameters;
    }

    public final synchronized void a(String str, List list) {
        Date date = new Date(System.currentTimeMillis());
        ArrayList arrayList = new ArrayList();
        arrayList.add(date);
        arrayList.add(list);
        if (this.b.containsKey(str)) {
            this.b.put(str, arrayList);
        } else {
            if (this.b.size() >= 32) {
                long time = date.getTime();
                Object obj = null;
                for (Map.Entry entry : this.b.entrySet()) {
                    long time2 = ((Date) ((List) entry.getValue()).get(0)).getTime();
                    if (time2 < time) {
                        obj = entry.getKey();
                        time = time2;
                    }
                }
                this.b.remove(obj);
            }
            this.b.put(str, arrayList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c A[LOOP:0: B:26:0x009c->B:28:0x009f, LOOP_START, PHI: r4 
      PHI: (r4v5 int) = (r4v1 int), (r4v6 int) binds: [B:25:0x009a, B:28:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb A[LOOP:1: B:34:0x00c5->B:36:0x00cb, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List b(org.spongycastle.x509.X509AttributeCertStoreSelector r6, java.lang.String[] r7, java.lang.String[] r8, java.lang.String[] r9) throws org.spongycastle.util.StoreException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            org.spongycastle.x509.AttributeCertificateHolder r2 = r6.getHolder()
            r3 = 0
            if (r2 == 0) goto L_0x003d
            org.spongycastle.x509.AttributeCertificateHolder r2 = r6.getHolder()
            java.math.BigInteger r2 = r2.getSerialNumber()
            if (r2 == 0) goto L_0x002a
            org.spongycastle.x509.AttributeCertificateHolder r2 = r6.getHolder()
            java.math.BigInteger r2 = r2.getSerialNumber()
            java.lang.String r2 = r2.toString()
            r1.add(r2)
        L_0x002a:
            org.spongycastle.x509.AttributeCertificateHolder r2 = r6.getHolder()
            java.security.Principal[] r2 = r2.getEntityNames()
            if (r2 == 0) goto L_0x003d
            org.spongycastle.x509.AttributeCertificateHolder r2 = r6.getHolder()
            java.security.Principal[] r2 = r2.getEntityNames()
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            org.spongycastle.x509.X509AttributeCertificate r4 = r6.getAttributeCert()
            if (r4 == 0) goto L_0x006d
            org.spongycastle.x509.X509AttributeCertificate r4 = r6.getAttributeCert()
            org.spongycastle.x509.AttributeCertificateHolder r4 = r4.getHolder()
            java.security.Principal[] r4 = r4.getEntityNames()
            if (r4 == 0) goto L_0x005e
            org.spongycastle.x509.X509AttributeCertificate r2 = r6.getAttributeCert()
            org.spongycastle.x509.AttributeCertificateHolder r2 = r2.getHolder()
            java.security.Principal[] r2 = r2.getEntityNames()
        L_0x005e:
            org.spongycastle.x509.X509AttributeCertificate r4 = r6.getAttributeCert()
            java.math.BigInteger r4 = r4.getSerialNumber()
            java.lang.String r4 = r4.toString()
            r1.add(r4)
        L_0x006d:
            r4 = 0
            if (r2 == 0) goto L_0x0087
            r3 = r2[r4]
            boolean r3 = r3 instanceof javax.security.auth.x500.X500Principal
            if (r3 == 0) goto L_0x0081
            r2 = r2[r4]
            javax.security.auth.x500.X500Principal r2 = (javax.security.auth.x500.X500Principal) r2
            java.lang.String r3 = "RFC1779"
            java.lang.String r3 = r2.getName(r3)
            goto L_0x0087
        L_0x0081:
            r2 = r2[r4]
            java.lang.String r3 = r2.getName()
        L_0x0087:
            java.math.BigInteger r2 = r6.getSerialNumber()
            if (r2 == 0) goto L_0x0098
            java.math.BigInteger r6 = r6.getSerialNumber()
            java.lang.String r6 = r6.toString()
            r1.add(r6)
        L_0x0098:
            java.lang.String r6 = "*"
            if (r3 == 0) goto L_0x00b3
        L_0x009c:
            int r2 = r9.length
            if (r4 >= r2) goto L_0x00b3
            r2 = r9[r4]
            java.lang.String r2 = r5.l(r3, r2)
            java.lang.String r2 = a2.b.a.a.a.e3(r6, r2, r6)
            java.util.List r2 = r5.m(r8, r2, r7)
            r0.addAll(r2)
            int r4 = r4 + 1
            goto L_0x009c
        L_0x00b3:
            int r9 = r1.size()
            if (r9 <= 0) goto L_0x00e3
            org.spongycastle.jce.X509LDAPCertStoreParameters r9 = r5.a
            java.lang.String r9 = r9.getSearchForSerialNumberIn()
            if (r9 == 0) goto L_0x00e3
            java.util.Iterator r9 = r1.iterator()
        L_0x00c5:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00e3
            java.lang.Object r2 = r9.next()
            java.lang.String r2 = (java.lang.String) r2
            org.spongycastle.jce.X509LDAPCertStoreParameters r4 = r5.a
            java.lang.String r4 = r4.getSearchForSerialNumberIn()
            java.lang.String[] r4 = r5.n(r4)
            java.util.List r2 = r5.m(r4, r2, r7)
            r0.addAll(r2)
            goto L_0x00c5
        L_0x00e3:
            int r9 = r1.size()
            if (r9 != 0) goto L_0x00f2
            if (r3 != 0) goto L_0x00f2
            java.util.List r6 = r5.m(r8, r6, r7)
            r0.addAll(r6)
        L_0x00f2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.b(org.spongycastle.x509.X509AttributeCertStoreSelector, java.lang.String[], java.lang.String[], java.lang.String[]):java.util.List");
    }

    public final List c(X509CRLStoreSelector x509CRLStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (x509CRLStoreSelector.getIssuers() != null) {
            hashSet.addAll(x509CRLStoreSelector.getIssuers());
        }
        if (x509CRLStoreSelector.getCertificateChecking() != null) {
            hashSet.add(x509CRLStoreSelector.getCertificateChecking().getIssuerX500Principal());
        }
        if (x509CRLStoreSelector.getAttrCertificateChecking() != null) {
            Principal[] principals = x509CRLStoreSelector.getAttrCertificateChecking().getIssuer().getPrincipals();
            for (int i = 0; i < principals.length; i++) {
                if (principals[i] instanceof X500Principal) {
                    hashSet.add(principals[i]);
                }
            }
        }
        Iterator it = hashSet.iterator();
        String str = null;
        while (it.hasNext()) {
            str = ((X500Principal) it.next()).getName("RFC1779");
            for (String str2 : strArr3) {
                arrayList.addAll(m(strArr2, a.e3("*", l(str, str2), "*"), strArr));
            }
        }
        if (str == null) {
            arrayList.addAll(m(strArr2, "*", strArr));
        }
        return arrayList;
    }

    public final List d(X509CertStoreSelector x509CertStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        String k = k(x509CertStoreSelector);
        String bigInteger = x509CertStoreSelector.getSerialNumber() != null ? x509CertStoreSelector.getSerialNumber().toString() : null;
        if (x509CertStoreSelector.getCertificate() != null) {
            k = x509CertStoreSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
            bigInteger = x509CertStoreSelector.getCertificate().getSerialNumber().toString();
        }
        if (k != null) {
            for (String str : strArr3) {
                arrayList.addAll(m(strArr2, a.e3("*", l(k, str), "*"), strArr));
            }
        }
        if (!(bigInteger == null || this.a.getSearchForSerialNumberIn() == null)) {
            arrayList.addAll(m(n(this.a.getSearchForSerialNumberIn()), bigInteger, strArr));
        }
        if (bigInteger == null && k == null) {
            arrayList.addAll(m(strArr2, "*", strArr));
        }
        return arrayList;
    }

    public final DirContext e() throws NamingException {
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        properties.setProperty("java.naming.batchsize", "0");
        properties.setProperty("java.naming.provider.url", this.a.getLdapURL());
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
        properties.setProperty("java.naming.referral", "ignore");
        properties.setProperty("java.naming.security.authentication", "none");
        return new InitialDirContext(properties);
    }

    public final Set f(List list, X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        X509AttrCertParser x509AttrCertParser = new X509AttrCertParser();
        while (it.hasNext()) {
            try {
                x509AttrCertParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) x509AttrCertParser.engineRead();
                if (x509AttributeCertStoreSelector.match(x509AttributeCertificate)) {
                    hashSet.add(x509AttributeCertificate);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    public final Set g(List list, X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        X509CRLParser x509CRLParser = new X509CRLParser();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                x509CRLParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509CRL x509crl = (X509CRL) x509CRLParser.engineRead();
                if (x509CRLStoreSelector.match((Object) x509crl)) {
                    hashSet.add(x509crl);
                }
            } catch (StreamParsingException unused) {
            }
        }
        return hashSet;
    }

    public Collection getAACertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        String[] n = n(this.a.getAACertificateAttribute());
        String[] n2 = n(this.a.getLdapAACertificateAttributeName());
        String[] n3 = n(this.a.getAACertificateSubjectAttributeName());
        Set f = f(b(x509AttributeCertStoreSelector, n, n2, n3), x509AttributeCertStoreSelector);
        if (((HashSet) f).size() == 0) {
            f.addAll(f(b(new X509AttributeCertStoreSelector(), n, n2, n3), x509AttributeCertStoreSelector));
        }
        return f;
    }

    public Collection getAttributeAuthorityRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] n = n(this.a.getAttributeAuthorityRevocationListAttribute());
        String[] n2 = n(this.a.getLdapAttributeAuthorityRevocationListAttributeName());
        String[] n3 = n(this.a.getAttributeAuthorityRevocationListIssuerAttributeName());
        Set g = g(c(x509CRLStoreSelector, n, n2, n3), x509CRLStoreSelector);
        if (((HashSet) g).size() == 0) {
            g.addAll(g(c(new X509CRLStoreSelector(), n, n2, n3), x509CRLStoreSelector));
        }
        return g;
    }

    public Collection getAttributeCertificateAttributes(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        String[] n = n(this.a.getAttributeCertificateAttributeAttribute());
        String[] n2 = n(this.a.getLdapAttributeCertificateAttributeAttributeName());
        String[] n3 = n(this.a.getAttributeCertificateAttributeSubjectAttributeName());
        Set f = f(b(x509AttributeCertStoreSelector, n, n2, n3), x509AttributeCertStoreSelector);
        if (((HashSet) f).size() == 0) {
            f.addAll(f(b(new X509AttributeCertStoreSelector(), n, n2, n3), x509AttributeCertStoreSelector));
        }
        return f;
    }

    public Collection getAttributeCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] n = n(this.a.getAttributeCertificateRevocationListAttribute());
        String[] n2 = n(this.a.getLdapAttributeCertificateRevocationListAttributeName());
        String[] n3 = n(this.a.getAttributeCertificateRevocationListIssuerAttributeName());
        Set g = g(c(x509CRLStoreSelector, n, n2, n3), x509CRLStoreSelector);
        if (((HashSet) g).size() == 0) {
            g.addAll(g(c(new X509CRLStoreSelector(), n, n2, n3), x509CRLStoreSelector));
        }
        return g;
    }

    public Collection getAttributeDescriptorCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector) throws StoreException {
        String[] n = n(this.a.getAttributeDescriptorCertificateAttribute());
        String[] n2 = n(this.a.getLdapAttributeDescriptorCertificateAttributeName());
        String[] n3 = n(this.a.getAttributeDescriptorCertificateSubjectAttributeName());
        Set f = f(b(x509AttributeCertStoreSelector, n, n2, n3), x509AttributeCertStoreSelector);
        if (((HashSet) f).size() == 0) {
            f.addAll(f(b(new X509AttributeCertStoreSelector(), n, n2, n3), x509AttributeCertStoreSelector));
        }
        return f;
    }

    public Collection getAuthorityRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] n = n(this.a.getAuthorityRevocationListAttribute());
        String[] n2 = n(this.a.getLdapAuthorityRevocationListAttributeName());
        String[] n3 = n(this.a.getAuthorityRevocationListIssuerAttributeName());
        Set g = g(c(x509CRLStoreSelector, n, n2, n3), x509CRLStoreSelector);
        if (((HashSet) g).size() == 0) {
            g.addAll(g(c(new X509CRLStoreSelector(), n, n2, n3), x509CRLStoreSelector));
        }
        return g;
    }

    public Collection getCACertificates(X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        String[] n = n(this.a.getCACertificateAttribute());
        String[] n2 = n(this.a.getLdapCACertificateAttributeName());
        String[] n3 = n(this.a.getCACertificateSubjectAttributeName());
        Set h = h(d(x509CertStoreSelector, n, n2, n3), x509CertStoreSelector);
        if (((HashSet) h).size() == 0) {
            h.addAll(h(d(new X509CertStoreSelector(), n, n2, n3), x509CertStoreSelector));
        }
        return h;
    }

    public Collection getCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] n = n(this.a.getCertificateRevocationListAttribute());
        String[] n2 = n(this.a.getLdapCertificateRevocationListAttributeName());
        String[] n3 = n(this.a.getCertificateRevocationListIssuerAttributeName());
        Set g = g(c(x509CRLStoreSelector, n, n2, n3), x509CRLStoreSelector);
        if (((HashSet) g).size() == 0) {
            g.addAll(g(c(new X509CRLStoreSelector(), n, n2, n3), x509CRLStoreSelector));
        }
        return g;
    }

    public Collection getCrossCertificatePairs(X509CertPairStoreSelector x509CertPairStoreSelector) throws StoreException {
        String[] n = n(this.a.getCrossCertificateAttribute());
        String[] n2 = n(this.a.getLdapCrossCertificateAttributeName());
        String[] n3 = n(this.a.getCrossCertificateSubjectAttributeName());
        Set i = i(j(x509CertPairStoreSelector, n, n2, n3), x509CertPairStoreSelector);
        if (((HashSet) i).size() == 0) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            X509CertPairStoreSelector x509CertPairStoreSelector2 = new X509CertPairStoreSelector();
            x509CertPairStoreSelector2.setForwardSelector(x509CertStoreSelector);
            x509CertPairStoreSelector2.setReverseSelector(x509CertStoreSelector);
            i.addAll(i(j(x509CertPairStoreSelector2, n, n2, n3), x509CertPairStoreSelector));
        }
        return i;
    }

    public Collection getDeltaCertificateRevocationLists(X509CRLStoreSelector x509CRLStoreSelector) throws StoreException {
        String[] n = n(this.a.getDeltaRevocationListAttribute());
        String[] n2 = n(this.a.getLdapDeltaRevocationListAttributeName());
        String[] n3 = n(this.a.getDeltaRevocationListIssuerAttributeName());
        Set g = g(c(x509CRLStoreSelector, n, n2, n3), x509CRLStoreSelector);
        if (((HashSet) g).size() == 0) {
            g.addAll(g(c(new X509CRLStoreSelector(), n, n2, n3), x509CRLStoreSelector));
        }
        return g;
    }

    public Collection getUserCertificates(X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        String[] n = n(this.a.getUserCertificateAttribute());
        String[] n2 = n(this.a.getLdapUserCertificateAttributeName());
        String[] n3 = n(this.a.getUserCertificateSubjectAttributeName());
        Set h = h(d(x509CertStoreSelector, n, n2, n3), x509CertStoreSelector);
        if (((HashSet) h).size() == 0) {
            h.addAll(h(d(new X509CertStoreSelector(), n, n2, n3), x509CertStoreSelector));
        }
        return h;
    }

    public final Set h(List list, X509CertStoreSelector x509CertStoreSelector) throws StoreException {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        X509CertParser x509CertParser = new X509CertParser();
        while (it.hasNext()) {
            try {
                x509CertParser.engineInit(new ByteArrayInputStream((byte[]) it.next()));
                X509Certificate x509Certificate = (X509Certificate) x509CertParser.engineRead();
                if (x509CertStoreSelector.match((Object) x509Certificate)) {
                    hashSet.add(x509Certificate);
                }
            } catch (Exception unused) {
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ExcHandler: IOException | CertificateParsingException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:5:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Set i(java.util.List r9, org.spongycastle.x509.X509CertPairStoreSelector r10) throws org.spongycastle.util.StoreException {
        /*
            r8 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r9.size()
            if (r1 >= r2) goto L_0x0066
            org.spongycastle.jce.provider.X509CertPairParser r2 = new org.spongycastle.jce.provider.X509CertPairParser     // Catch:{ StreamParsingException -> 0x0026 }
            r2.<init>()     // Catch:{ StreamParsingException -> 0x0026 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ StreamParsingException -> 0x0026 }
            java.lang.Object r4 = r9.get(r1)     // Catch:{ StreamParsingException -> 0x0026 }
            byte[] r4 = (byte[]) r4     // Catch:{ StreamParsingException -> 0x0026 }
            r3.<init>(r4)     // Catch:{ StreamParsingException -> 0x0026 }
            r2.engineInit(r3)     // Catch:{ StreamParsingException -> 0x0026 }
            java.lang.Object r2 = r2.engineRead()     // Catch:{ StreamParsingException -> 0x0026 }
            org.spongycastle.x509.X509CertificatePair r2 = (org.spongycastle.x509.X509CertificatePair) r2     // Catch:{ StreamParsingException -> 0x0026 }
            goto L_0x005a
        L_0x0026:
            java.lang.Object r2 = r9.get(r1)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            byte[] r2 = (byte[]) r2     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            int r3 = r1 + 1
            java.lang.Object r4 = r9.get(r3)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            byte[] r4 = (byte[]) r4     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.x509.X509CertificatePair r5 = new org.spongycastle.x509.X509CertificatePair     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.x509.CertificatePair r6 = new org.spongycastle.asn1.x509.CertificatePair     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.ASN1InputStream r7 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r7.<init>(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.ASN1Primitive r2 = r7.readObject()     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.x509.Certificate r2 = org.spongycastle.asn1.x509.Certificate.getInstance(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.ASN1InputStream r7 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r7.<init>(r4)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.ASN1Primitive r4 = r7.readObject()     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            org.spongycastle.asn1.x509.Certificate r4 = org.spongycastle.asn1.x509.Certificate.getInstance(r4)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r6.<init>(r2, r4)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r5.<init>(r6)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            r1 = r3
            r2 = r5
        L_0x005a:
            boolean r3 = r10.match(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
            if (r3 == 0) goto L_0x0063
            r0.add(r2)     // Catch:{ IOException | CertificateParsingException -> 0x0063, IOException | CertificateParsingException -> 0x0063 }
        L_0x0063:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.i(java.util.List, org.spongycastle.x509.X509CertPairStoreSelector):java.util.Set");
    }

    public final List j(X509CertPairStoreSelector x509CertPairStoreSelector, String[] strArr, String[] strArr2, String[] strArr3) throws StoreException {
        ArrayList arrayList = new ArrayList();
        String k = x509CertPairStoreSelector.getForwardSelector() != null ? k(x509CertPairStoreSelector.getForwardSelector()) : null;
        if (!(x509CertPairStoreSelector.getCertPair() == null || x509CertPairStoreSelector.getCertPair().getForward() == null)) {
            k = x509CertPairStoreSelector.getCertPair().getForward().getSubjectX500Principal().getName("RFC1779");
        }
        if (k != null) {
            for (String str : strArr3) {
                arrayList.addAll(m(strArr2, a.e3("*", l(k, str), "*"), strArr));
            }
        }
        if (k == null) {
            arrayList.addAll(m(strArr2, "*", strArr));
        }
        return arrayList;
    }

    public final String k(X509CertStoreSelector x509CertStoreSelector) {
        try {
            byte[] subjectAsBytes = x509CertStoreSelector.getSubjectAsBytes();
            if (subjectAsBytes != null) {
                return new X500Principal(subjectAsBytes).getName("RFC1779");
            }
            return null;
        } catch (IOException e) {
            throw new StoreException(a.A2(e, a.L("exception processing name: ")), e);
        }
    }

    public final String l(String str, String str2) {
        String lowerCase = str.toLowerCase();
        int indexOf = lowerCase.indexOf(str2.toLowerCase() + "=");
        if (indexOf == -1) {
            return "";
        }
        String substring = str.substring(str2.length() + indexOf);
        int indexOf2 = substring.indexOf(44);
        if (indexOf2 == -1) {
            indexOf2 = substring.length();
        }
        while (substring.charAt(indexOf2 - 1) == '\\') {
            indexOf2 = substring.indexOf(44, indexOf2 + 1);
            if (indexOf2 == -1) {
                indexOf2 = substring.length();
            }
        }
        String N2 = a.N2(substring.substring(0, indexOf2), 61, 1);
        if (N2.charAt(0) == ' ') {
            N2 = N2.substring(1);
        }
        if (N2.startsWith("\"")) {
            N2 = N2.substring(1);
        }
        return N2.endsWith("\"") ? N2.substring(0, N2.length() - 1) : N2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00db, code lost:
        if (0 == 0) goto L_0x00e0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List m(java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13) throws org.spongycastle.util.StoreException {
        /*
            r10 = this;
            java.lang.String r0 = "("
            java.lang.String r1 = "(|"
            r2 = 0
            r3 = 0
            java.lang.String r4 = ""
            java.lang.String r5 = ")"
            if (r11 != 0) goto L_0x000e
            r11 = r3
            goto L_0x0030
        L_0x000e:
            java.lang.String r6 = "**"
            boolean r6 = r12.equals(r6)
            if (r6 == 0) goto L_0x0018
            java.lang.String r12 = "*"
        L_0x0018:
            r6 = 0
            r7 = r4
        L_0x001a:
            int r8 = r11.length
            if (r6 >= r8) goto L_0x002c
            java.lang.StringBuilder r7 = a2.b.a.a.a.Q(r7, r0)
            r8 = r11[r6]
            java.lang.String r9 = "="
            java.lang.String r7 = a2.b.a.a.a.v(r7, r8, r9, r12, r5)
            int r6 = r6 + 1
            goto L_0x001a
        L_0x002c:
            java.lang.String r11 = a2.b.a.a.a.e3(r1, r7, r5)
        L_0x0030:
            r12 = 0
            r6 = r4
        L_0x0032:
            int r7 = r13.length
            if (r12 >= r7) goto L_0x0044
            java.lang.StringBuilder r6 = a2.b.a.a.a.Q(r6, r0)
            r7 = r13[r12]
            java.lang.String r8 = "=*)"
            java.lang.String r6 = a2.b.a.a.a.t(r6, r7, r8)
            int r12 = r12 + 1
            goto L_0x0032
        L_0x0044:
            java.lang.String r12 = a2.b.a.a.a.e3(r1, r6, r5)
            java.lang.String r0 = "(&"
            java.lang.String r0 = a2.b.a.a.a.f(r0, r11, r4, r12, r5)
            if (r11 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r12 = r0
        L_0x0052:
            java.util.Map r11 = r10.b
            java.lang.Object r11 = r11.get(r12)
            java.util.List r11 = (java.util.List) r11
            long r0 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x007b
            java.lang.Object r2 = r11.get(r2)
            java.sql.Date r2 = (java.sql.Date) r2
            long r4 = r2.getTime()
            r6 = 60000(0xea60, double:2.9644E-319)
            long r0 = r0 - r6
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0073
            goto L_0x007b
        L_0x0073:
            r0 = 1
            java.lang.Object r11 = r11.get(r0)
            java.util.List r11 = (java.util.List) r11
            goto L_0x007c
        L_0x007b:
            r11 = r3
        L_0x007c:
            if (r11 == 0) goto L_0x007f
            return r11
        L_0x007f:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            javax.naming.directory.DirContext r3 = r10.e()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.directory.SearchControls r0 = new javax.naming.directory.SearchControls     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            r0.<init>()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            r1 = 2
            r0.setSearchScope(r1)     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            r1 = 0
            r0.setCountLimit(r1)     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            r0.setReturningAttributes(r13)     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            org.spongycastle.jce.X509LDAPCertStoreParameters r13 = r10.a     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            java.lang.String r13 = r13.getBaseDN()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.NamingEnumeration r13 = r3.search(r13, r12, r0)     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
        L_0x00a3:
            boolean r0 = r13.hasMoreElements()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            if (r0 == 0) goto L_0x00cf
            java.lang.Object r0 = r13.next()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.directory.SearchResult r0 = (javax.naming.directory.SearchResult) r0     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.directory.Attributes r0 = r0.getAttributes()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.NamingEnumeration r0 = r0.getAll()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            java.lang.Object r0 = r0.next()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.directory.Attribute r0 = (javax.naming.directory.Attribute) r0     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            javax.naming.NamingEnumeration r0 = r0.getAll()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
        L_0x00c1:
            boolean r1 = r0.hasMore()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r0.next()     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            r11.add(r1)     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            goto L_0x00c1
        L_0x00cf:
            r10.a(r12, r11)     // Catch:{ NamingException -> 0x00da, all -> 0x00d3 }
            goto L_0x00dd
        L_0x00d3:
            r11 = move-exception
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ Exception -> 0x00d9 }
        L_0x00d9:
            throw r11
        L_0x00da:
            if (r3 == 0) goto L_0x00e0
        L_0x00dd:
            r3.close()     // Catch:{ Exception -> 0x00e0 }
        L_0x00e0:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.util.LDAPStoreHelper.m(java.lang.String[], java.lang.String, java.lang.String[]):java.util.List");
    }

    public final String[] n(String str) {
        return str.split("\\s+");
    }
}
