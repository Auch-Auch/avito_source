package org.spongycastle.jce.provider;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.x509.CertificatePair;
import org.spongycastle.jce.X509LDAPCertStoreParameters;
public class X509LDAPCertStoreSpi extends CertStoreSpi {
    public X509LDAPCertStoreParameters a;

    public X509LDAPCertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof X509LDAPCertStoreParameters) {
            this.a = (X509LDAPCertStoreParameters) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException(X509LDAPCertStoreSpi.class.getName() + ": parameter must be a " + X509LDAPCertStoreParameters.class.getName() + " object\n" + certStoreParameters.toString());
    }

    public final Set a(X509CertSelector x509CertSelector, String[] strArr, String str, String str2) throws CertStoreException {
        String str3;
        String str4;
        String str5;
        HashSet hashSet = new HashSet();
        try {
            if (x509CertSelector.getSubjectAsBytes() == null && x509CertSelector.getSubjectAsString() == null && x509CertSelector.getCertificate() == null) {
                hashSet.addAll(d(str, "*", strArr));
            } else {
                if (x509CertSelector.getCertificate() != null) {
                    str4 = x509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
                    str3 = x509CertSelector.getCertificate().getSerialNumber().toString();
                } else {
                    if (x509CertSelector.getSubjectAsBytes() != null) {
                        str5 = new X500Principal(x509CertSelector.getSubjectAsBytes()).getName("RFC1779");
                    } else {
                        str5 = x509CertSelector.getSubjectAsString();
                    }
                    str4 = str5;
                    str3 = null;
                }
                hashSet.addAll(d(str, "*" + c(str4, str2) + "*", strArr));
                if (!(str3 == null || this.a.getSearchForSerialNumberIn() == null)) {
                    hashSet.addAll(d(this.a.getSearchForSerialNumberIn(), "*" + str3 + "*", strArr));
                }
            }
            return hashSet;
        } catch (IOException e) {
            throw new CertStoreException(a.Z2("exception processing selector: ", e));
        }
    }

    public final DirContext b() throws NamingException {
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        properties.setProperty("java.naming.batchsize", "0");
        properties.setProperty("java.naming.provider.url", this.a.getLdapURL());
        properties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
        properties.setProperty("java.naming.referral", "ignore");
        properties.setProperty("java.naming.security.authentication", "none");
        return new InitialDirContext(properties);
    }

    public final String c(String str, String str2) {
        String substring = str.substring(str2.length() + str.toLowerCase().indexOf(str2.toLowerCase()));
        int indexOf = substring.indexOf(44);
        if (indexOf == -1) {
            indexOf = substring.length();
        }
        while (substring.charAt(indexOf - 1) == '\\') {
            indexOf = substring.indexOf(44, indexOf + 1);
            if (indexOf == -1) {
                indexOf = substring.length();
            }
        }
        String N2 = a.N2(substring.substring(0, indexOf), 61, 1);
        if (N2.charAt(0) == ' ') {
            N2 = N2.substring(1);
        }
        if (N2.startsWith("\"")) {
            N2 = N2.substring(1);
        }
        return N2.endsWith("\"") ? N2.substring(0, N2.length() - 1) : N2;
    }

    public final Set d(String str, String str2, String[] strArr) throws CertStoreException {
        String e3 = a.e3(str, "=", str2);
        DirContext dirContext = null;
        if (str == null) {
            e3 = null;
        }
        HashSet hashSet = new HashSet();
        try {
            DirContext b = b();
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(2);
            searchControls.setCountLimit(0);
            for (int i = 0; i < strArr.length; i++) {
                String[] strArr2 = {strArr[i]};
                searchControls.setReturningAttributes(strArr2);
                String str3 = "(&(" + e3 + ")(" + strArr2[0] + "=*))";
                if (e3 == null) {
                    str3 = "(" + strArr2[0] + "=*)";
                }
                NamingEnumeration search = b.search(this.a.getBaseDN(), str3, searchControls);
                while (search.hasMoreElements()) {
                    NamingEnumeration all = ((Attribute) ((SearchResult) search.next()).getAttributes().getAll().next()).getAll();
                    while (all.hasMore()) {
                        hashSet.add(all.next());
                    }
                }
            }
            try {
                b.close();
            } catch (Exception unused) {
            }
            return hashSet;
        } catch (Exception e) {
            throw new CertStoreException("Error getting results from LDAP directory " + e);
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    dirContext.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        String str;
        String[] strArr = {this.a.getCertificateRevocationListAttribute()};
        if (cRLSelector instanceof X509CRLSelector) {
            X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
            HashSet hashSet = new HashSet();
            String ldapCertificateRevocationListAttributeName = this.a.getLdapCertificateRevocationListAttributeName();
            HashSet hashSet2 = new HashSet();
            if (x509CRLSelector.getIssuerNames() != null) {
                for (Object obj : x509CRLSelector.getIssuerNames()) {
                    if (obj instanceof String) {
                        str = c((String) obj, this.a.getCertificateRevocationListIssuerAttributeName());
                    } else {
                        str = c(new X500Principal((byte[]) obj).getName("RFC1779"), this.a.getCertificateRevocationListIssuerAttributeName());
                    }
                    hashSet2.addAll(d(ldapCertificateRevocationListAttributeName, a.e3("*", str, "*"), strArr));
                }
            } else {
                hashSet2.addAll(d(ldapCertificateRevocationListAttributeName, "*", strArr));
            }
            hashSet2.addAll(d(null, "*", strArr));
            Iterator it = hashSet2.iterator();
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
                while (it.hasNext()) {
                    CRL generateCRL = instance.generateCRL(new ByteArrayInputStream((byte[]) it.next()));
                    if (x509CRLSelector.match(generateCRL)) {
                        hashSet.add(generateCRL);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                throw new CertStoreException(a.a3("CRL cannot be constructed from LDAP result ", e));
            }
        } else {
            throw new CertStoreException("selector is not a X509CRLSelector");
        }
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        if (certSelector instanceof X509CertSelector) {
            X509CertSelector x509CertSelector = (X509CertSelector) certSelector;
            HashSet hashSet = new HashSet();
            Set a3 = a(x509CertSelector, new String[]{this.a.getUserCertificateAttribute()}, this.a.getLdapUserCertificateAttributeName(), this.a.getUserCertificateSubjectAttributeName());
            String[] strArr = {this.a.getCACertificateAttribute()};
            Set a4 = a(x509CertSelector, strArr, this.a.getLdapCACertificateAttributeName(), this.a.getCACertificateSubjectAttributeName());
            if (((HashSet) a4).isEmpty()) {
                a4.addAll(d(null, "*", strArr));
            }
            a3.addAll(a4);
            String[] strArr2 = {this.a.getCrossCertificateAttribute()};
            Set a5 = a(x509CertSelector, strArr2, this.a.getLdapCrossCertificateAttributeName(), this.a.getCrossCertificateSubjectAttributeName());
            if (((HashSet) a5).isEmpty()) {
                a5.addAll(d(null, "*", strArr2));
            }
            a3.addAll(a5);
            Iterator it = ((HashSet) a3).iterator();
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME);
                while (it.hasNext()) {
                    byte[] bArr = (byte[]) it.next();
                    if (bArr != null) {
                        if (bArr.length != 0) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(bArr);
                            try {
                                CertificatePair instance2 = CertificatePair.getInstance(new ASN1InputStream(bArr).readObject());
                                arrayList.clear();
                                if (instance2.getForward() != null) {
                                    arrayList.add(instance2.getForward().getEncoded());
                                }
                                if (instance2.getReverse() != null) {
                                    arrayList.add(instance2.getReverse().getEncoded());
                                }
                            } catch (IOException | IllegalArgumentException unused) {
                            }
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                try {
                                    Certificate generateCertificate = instance.generateCertificate(new ByteArrayInputStream((byte[]) it2.next()));
                                    if (x509CertSelector.match(generateCertificate)) {
                                        hashSet.add(generateCertificate);
                                    }
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                }
                return hashSet;
            } catch (Exception e) {
                throw new CertStoreException(a.a3("certificate cannot be constructed from LDAP result: ", e));
            }
        } else {
            throw new CertStoreException("selector is not a X509CertSelector");
        }
    }
}
