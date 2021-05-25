package x6.e.d.a;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.PKIXCRLStore;
import org.spongycastle.jcajce.PKIXCRLStoreSelector;
import org.spongycastle.jcajce.PKIXCertStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.PKIXPolicyNode;
import org.spongycastle.jce.provider.X509CRLObject;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509AttributeCertificate;
public class b {
    public static final f a = new f();
    public static final String b = Extension.issuingDistributionPoint.getId();
    public static final String c = Extension.authorityKeyIdentifier.getId();
    public static final String d = Extension.cRLNumber.getId();

    static {
        Extension.certificatePolicies.getId();
        Extension.basicConstraints.getId();
        Extension.policyMappings.getId();
        Extension.subjectAlternativeName.getId();
        Extension.nameConstraints.getId();
        Extension.keyUsage.getId();
        Extension.inhibitAnyPolicy.getId();
        Extension.deltaCRLIndicator.getId();
        Extension.policyConstraints.getId();
        Extension.freshestCRL.getId();
        Extension.cRLDistributionPoints.getId();
    }

    public static Collection a(PKIXCertStoreSelector pKIXCertStoreSelector, List list) throws AnnotatedException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : list) {
            if (obj instanceof Store) {
                try {
                    linkedHashSet.addAll(((Store) obj).getMatches(pKIXCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            } else {
                try {
                    linkedHashSet.addAll(PKIXCertStoreSelector.getCertificates(pKIXCertStoreSelector, (CertStore) obj));
                } catch (CertStoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e2);
                }
            }
        }
        return linkedHashSet;
    }

    public static Collection b(X509Certificate x509Certificate, List<CertStore> list, List<PKIXCertStore> list2) throws AnnotatedException {
        byte[] keyIdentifier;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(X500Name.getInstance(x509Certificate.getIssuerX500Principal().getEncoded()).getEncoded());
            try {
                byte[] extensionValue = x509Certificate.getExtensionValue(c);
                if (!(extensionValue == null || (keyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getKeyIdentifier()) == null)) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            } catch (Exception unused) {
            }
            PKIXCertStoreSelector<? extends Certificate> build = new PKIXCertStoreSelector.Builder(x509CertSelector).build();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a(build, list));
                arrayList.addAll(a(build, list2));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add((X509Certificate) it.next());
                }
                return linkedHashSet;
            } catch (AnnotatedException e) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e);
            }
        } catch (IOException e2) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0018 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.TrustAnchor c(java.security.cert.X509Certificate r7, java.util.Set r8, java.lang.String r9) throws org.spongycastle.jce.provider.AnnotatedException {
        /*
            java.security.cert.X509CertSelector r0 = new java.security.cert.X509CertSelector
            r0.<init>()
            org.spongycastle.asn1.x500.X500Name r1 = androidx.appcompat.app.AppCompatDelegateImpl.i.B0(r7)
            byte[] r2 = r1.getEncoded()     // Catch:{ IOException -> 0x0082 }
            r0.setSubject(r2)     // Catch:{ IOException -> 0x0082 }
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x0018:
            boolean r6 = r8.hasNext()
            if (r6 == 0) goto L_0x0074
            if (r3 != 0) goto L_0x0074
            java.lang.Object r3 = r8.next()
            java.security.cert.TrustAnchor r3 = (java.security.cert.TrustAnchor) r3
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            if (r6 == 0) goto L_0x003f
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            boolean r6 = r0.match(r6)
            if (r6 == 0) goto L_0x0062
            java.security.cert.X509Certificate r5 = r3.getTrustedCert()
            java.security.PublicKey r5 = r5.getPublicKey()
            goto L_0x0063
        L_0x003f:
            java.lang.String r6 = r3.getCAName()
            if (r6 == 0) goto L_0x0062
            java.security.PublicKey r6 = r3.getCAPublicKey()
            if (r6 == 0) goto L_0x0062
            javax.security.auth.x500.X500Principal r6 = r3.getCA()     // Catch:{ IllegalArgumentException -> 0x0062 }
            byte[] r6 = r6.getEncoded()     // Catch:{ IllegalArgumentException -> 0x0062 }
            org.spongycastle.asn1.x500.X500Name r6 = org.spongycastle.asn1.x500.X500Name.getInstance(r6)     // Catch:{ IllegalArgumentException -> 0x0062 }
            boolean r6 = r1.equals(r6)     // Catch:{ IllegalArgumentException -> 0x0062 }
            if (r6 == 0) goto L_0x0062
            java.security.PublicKey r5 = r3.getCAPublicKey()     // Catch:{ IllegalArgumentException -> 0x0062 }
            goto L_0x0063
        L_0x0062:
            r3 = r2
        L_0x0063:
            if (r5 == 0) goto L_0x0018
            if (r9 != 0) goto L_0x006b
            r7.verify(r5)     // Catch:{ Exception -> 0x006f }
            goto L_0x0018
        L_0x006b:
            r7.verify(r5, r9)     // Catch:{ Exception -> 0x006f }
            goto L_0x0018
        L_0x006f:
            r3 = move-exception
            r4 = r3
            r3 = r2
            r5 = r3
            goto L_0x0018
        L_0x0074:
            if (r3 != 0) goto L_0x0081
            if (r4 != 0) goto L_0x0079
            goto L_0x0081
        L_0x0079:
            org.spongycastle.jce.provider.AnnotatedException r7 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r8 = "TrustAnchor found but certificate validation failed."
            r7.<init>(r8, r4)
            throw r7
        L_0x0081:
            return r3
        L_0x0082:
            r7 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r8 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r9 = "Cannot set subject search criteria for trust anchor."
            r8.<init>(r9, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.e.d.a.b.c(java.security.cert.X509Certificate, java.util.Set, java.lang.String):java.security.cert.TrustAnchor");
    }

    public static List<PKIXCertStore> d(byte[] bArr, Map<GeneralName, PKIXCertStore> map) throws CertificateParsingException {
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        GeneralName[] names = GeneralNames.getInstance(ASN1OctetString.getInstance(bArr).getOctets()).getNames();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != names.length; i++) {
            PKIXCertStore pKIXCertStore = map.get(names[i]);
            if (pKIXCertStore != null) {
                arrayList.add(pKIXCertStore);
            }
        }
        return arrayList;
    }

    public static List<PKIXCRLStore> e(CRLDistPoint cRLDistPoint, Map<GeneralName, PKIXCRLStore> map) throws AnnotatedException {
        GeneralName[] names;
        if (cRLDistPoint == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            ArrayList arrayList = new ArrayList();
            for (DistributionPoint distributionPoint : distributionPoints) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2 != null && distributionPoint2.getType() == 0) {
                    for (GeneralName generalName : GeneralNames.getInstance(distributionPoint2.getName()).getNames()) {
                        PKIXCRLStore pKIXCRLStore = map.get(generalName);
                        if (pKIXCRLStore != null) {
                            arrayList.add(pKIXCRLStore);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new AnnotatedException("Distribution points could not be read.", e);
        }
    }

    public static AlgorithmIdentifier f(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getAlgorithm();
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e);
        }
    }

    public static void g(DistributionPoint distributionPoint, Collection collection, X509CRLSelector x509CRLSelector) throws AnnotatedException {
        ArrayList arrayList = new ArrayList();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    try {
                        arrayList.add(X500Name.getInstance(names[i].getName().toASN1Primitive().getEncoded()));
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
            }
        } else if (distributionPoint.getDistributionPoint() != null) {
            for (Object obj : collection) {
                arrayList.add(obj);
            }
        } else {
            throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                x509CRLSelector.addIssuerName(((X500Name) it.next()).getEncoded());
            } catch (IOException e2) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e2);
            }
        }
    }

    public static void h(Date date, X509CRL x509crl, Object obj, c cVar) throws AnnotatedException {
        X509CRLEntry x509CRLEntry;
        X500Name x500Name;
        try {
            if (X509CRLObject.isIndirectCRL(x509crl)) {
                x509CRLEntry = x509crl.getRevokedCertificate(((X509Certificate) obj).getSerialNumber());
                if (x509CRLEntry != null) {
                    X500Principal certificateIssuer = x509CRLEntry.getCertificateIssuer();
                    if (certificateIssuer == null) {
                        x500Name = X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded());
                    } else {
                        x500Name = X500Name.getInstance(certificateIssuer.getEncoded());
                    }
                    if (!AppCompatDelegateImpl.i.B0(obj).equals(x500Name)) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!AppCompatDelegateImpl.i.B0(obj).equals(X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded())) || (x509CRLEntry = x509crl.getRevokedCertificate(((X509Certificate) obj).getSerialNumber())) == null) {
                return;
            }
            ASN1Enumerated aSN1Enumerated = null;
            if (x509CRLEntry.hasExtensions()) {
                try {
                    aSN1Enumerated = ASN1Enumerated.getInstance(k(x509CRLEntry, Extension.reasonCode.getId()));
                } catch (Exception e) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e);
                }
            }
            if (date.getTime() >= x509CRLEntry.getRevocationDate().getTime() || aSN1Enumerated == null || aSN1Enumerated.getValue().intValue() == 0 || aSN1Enumerated.getValue().intValue() == 1 || aSN1Enumerated.getValue().intValue() == 2 || aSN1Enumerated.getValue().intValue() == 8) {
                if (aSN1Enumerated != null) {
                    cVar.a = aSN1Enumerated.getValue().intValue();
                } else {
                    cVar.a = 0;
                }
                cVar.b = x509CRLEntry.getRevocationDate();
            }
        } catch (CRLException e2) {
            throw new AnnotatedException("Failed check for indirect CRL.", e2);
        }
    }

    public static Set i(DistributionPoint distributionPoint, Object obj, Date date, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(AppCompatDelegateImpl.i.B0(obj));
            g(distributionPoint, hashSet, x509CRLSelector);
            if (obj instanceof X509Certificate) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            PKIXCRLStoreSelector<? extends CRL> build = new PKIXCRLStoreSelector.Builder(x509CRLSelector).setCompleteCRLEnabled(true).build();
            if (pKIXExtendedParameters.getDate() != null) {
                date = pKIXExtendedParameters.getDate();
            }
            Set b2 = a.b(build, date, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores());
            if (!((HashSet) b2).isEmpty()) {
                return b2;
            }
            if (obj instanceof X509AttributeCertificate) {
                StringBuilder L = a.L("No CRLs found for issuer \"");
                L.append(((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0]);
                L.append("\"");
                throw new AnnotatedException(L.toString());
            }
            StringBuilder L2 = a.L("No CRLs found for issuer \"");
            L2.append(RFC4519Style.INSTANCE.toString(AppCompatDelegateImpl.i.E0((X509Certificate) obj)));
            L2.append("\"");
            throw new AnnotatedException(L2.toString());
        } catch (AnnotatedException e) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e);
        }
    }

    public static Set j(Date date, X509CRL x509crl, List<CertStore> list, List<PKIXCRLStore> list2) throws AnnotatedException {
        boolean z;
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded()).getEncoded());
            try {
                ASN1Primitive k = k(x509crl, d);
                BigInteger bigInteger = null;
                BigInteger positiveValue = k != null ? ASN1Integer.getInstance(k).getPositiveValue() : null;
                try {
                    byte[] extensionValue = x509crl.getExtensionValue(b);
                    if (positiveValue != null) {
                        bigInteger = positiveValue.add(BigInteger.valueOf(1));
                    }
                    x509CRLSelector.setMinCRLNumber(bigInteger);
                    PKIXCRLStoreSelector.Builder builder = new PKIXCRLStoreSelector.Builder(x509CRLSelector);
                    builder.setIssuingDistributionPoint(extensionValue);
                    builder.setIssuingDistributionPointEnabled(true);
                    builder.setMaxBaseCRLNumber(positiveValue);
                    Set b2 = a.b(builder.build(), date, list, list2);
                    HashSet hashSet = new HashSet();
                    Iterator it = ((HashSet) b2).iterator();
                    while (it.hasNext()) {
                        X509CRL x509crl2 = (X509CRL) it.next();
                        Set<String> criticalExtensionOIDs = x509crl2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs == null) {
                            z = false;
                        } else {
                            z = criticalExtensionOIDs.contains(g.e);
                        }
                        if (z) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e);
                }
            } catch (Exception e2) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e2);
            }
        } catch (IOException e3) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e3);
        }
    }

    public static ASN1Primitive k(X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        try {
            return new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(extensionValue).readObject()).getOctets()).readObject();
        } catch (Exception e) {
            throw new AnnotatedException(a.c3("exception processing extension ", str), e);
        }
    }

    public static PublicKey l(List list, int i, JcaJceHelper jcaJceHelper) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
        if (dSAPublicKey2.getParams() != null) {
            return dSAPublicKey2;
        }
        do {
            i++;
            if (i < list.size()) {
                PublicKey publicKey2 = ((X509Certificate) list.get(i)).getPublicKey();
                if (publicKey2 instanceof DSAPublicKey) {
                    dSAPublicKey = (DSAPublicKey) publicKey2;
                } else {
                    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
                }
            } else {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
        } while (dSAPublicKey.getParams() == null);
        DSAParams params = dSAPublicKey.getParams();
        try {
            return jcaJceHelper.createKeyFactory("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static final Set m(ASN1Sequence aSN1Sequence) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            try {
                aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e);
            }
        }
        return hashSet;
    }

    public static Date n(PKIXExtendedParameters pKIXExtendedParameters, CertPath certPath, int i) throws AnnotatedException {
        if (pKIXExtendedParameters.getValidityModel() != 1) {
            Date date = pKIXExtendedParameters.getDate();
            return date == null ? new Date() : date;
        } else if (i <= 0) {
            Date date2 = pKIXExtendedParameters.getDate();
            return date2 == null ? new Date() : date2;
        } else {
            int i2 = i - 1;
            if (i2 != 0) {
                return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
            }
            ASN1GeneralizedTime aSN1GeneralizedTime = null;
            try {
                byte[] extensionValue = ((X509Certificate) certPath.getCertificates().get(i2)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
                if (extensionValue != null) {
                    aSN1GeneralizedTime = ASN1GeneralizedTime.getInstance(ASN1Primitive.fromByteArray(extensionValue));
                }
                if (aSN1GeneralizedTime == null) {
                    return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
                }
                try {
                    return aSN1GeneralizedTime.getDate();
                } catch (ParseException e) {
                    throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e);
                }
            } catch (IOException unused) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            } catch (IllegalArgumentException unused2) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            }
        }
    }

    public static boolean o(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    public static PKIXPolicyNode p(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode == null) {
            return null;
        }
        if (pKIXPolicyNode3 == null) {
            for (int i = 0; i < listArr.length; i++) {
                listArr[i] = new ArrayList();
            }
            return null;
        }
        pKIXPolicyNode3.removeChild(pKIXPolicyNode2);
        q(listArr, pKIXPolicyNode2);
        return pKIXPolicyNode;
    }

    public static void q(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (pKIXPolicyNode.hasChildren()) {
            Iterator children = pKIXPolicyNode.getChildren();
            while (children.hasNext()) {
                q(listArr, (PKIXPolicyNode) children.next());
            }
        }
    }
}
