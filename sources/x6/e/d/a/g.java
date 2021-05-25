package x6.e.d.a;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.PKIXCertPathBuilderSpi;
import org.spongycastle.util.Arrays;
public class g {
    public static final String a = Extension.certificatePolicies.getId();
    public static final String b = Extension.policyMappings.getId();
    public static final String c = Extension.inhibitAnyPolicy.getId();
    public static final String d = Extension.issuingDistributionPoint.getId();
    public static final String e = Extension.deltaCRLIndicator.getId();
    public static final String f = Extension.policyConstraints.getId();
    public static final String g = Extension.basicConstraints.getId();
    public static final String h = Extension.cRLDistributionPoints.getId();
    public static final String i = Extension.subjectAlternativeName.getId();
    public static final String j = Extension.nameConstraints.getId();
    public static final String k = Extension.authorityKeyIdentifier.getId();
    public static final String l = Extension.keyUsage.getId();
    public static final String[] m = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    static {
        Extension.freshestCRL.getId();
        Extension.cRLNumber.getId();
    }

    public static void a(DistributionPoint distributionPoint, PKIXExtendedParameters pKIXExtendedParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, c cVar, i iVar, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        Iterator it;
        Date date2;
        Set<String> criticalExtensionOIDs;
        Date date3 = new Date(System.currentTimeMillis());
        if (date.getTime() <= date3.getTime()) {
            Iterator it2 = ((HashSet) b.i(distributionPoint, x509Certificate, date3, pKIXExtendedParameters)).iterator();
            AnnotatedException e2 = null;
            boolean z = false;
            while (it2.hasNext() && cVar.a == 11 && !iVar.a()) {
                try {
                    X509CRL x509crl = (X509CRL) it2.next();
                    i p = p(x509crl, distributionPoint);
                    int i2 = p.a;
                    if (!((i2 | (iVar.a ^ i2)) != 0)) {
                        continue;
                    } else {
                        date2 = date3;
                        it = it2;
                        try {
                            X509CRL s = pKIXExtendedParameters.isUseDeltasEnabled() ? s(b.j(pKIXExtendedParameters.getDate() != null ? pKIXExtendedParameters.getDate() : date2, x509crl, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores()), r(x509crl, q(x509crl, x509Certificate2, publicKey, pKIXExtendedParameters, list, jcaJceHelper))) : null;
                            if (pKIXExtendedParameters.getValidityModel() != 1) {
                                if (x509Certificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                                    throw new AnnotatedException("No valid CRL for current time found.");
                                }
                            }
                            m(distributionPoint, x509Certificate, x509crl);
                            n(distributionPoint, x509Certificate, x509crl);
                            o(s, x509crl, pKIXExtendedParameters);
                            if (pKIXExtendedParameters.isUseDeltasEnabled() && s != null) {
                                b.h(date, s, x509Certificate, cVar);
                            }
                            if (cVar.a == 11) {
                                b.h(date, x509crl, x509Certificate, cVar);
                            }
                            if (cVar.a == 8) {
                                cVar.a = 11;
                            }
                            iVar.a |= p.a;
                            Set<String> criticalExtensionOIDs2 = x509crl.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs2 != null) {
                                HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                                hashSet.remove(Extension.issuingDistributionPoint.getId());
                                hashSet.remove(Extension.deltaCRLIndicator.getId());
                                if (!hashSet.isEmpty()) {
                                    throw new AnnotatedException("CRL contains unsupported critical extensions.");
                                }
                            }
                            if (!(s == null || (criticalExtensionOIDs = s.getCriticalExtensionOIDs()) == null)) {
                                HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                                hashSet2.remove(Extension.issuingDistributionPoint.getId());
                                hashSet2.remove(Extension.deltaCRLIndicator.getId());
                                if (!hashSet2.isEmpty()) {
                                    throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                                }
                            }
                            date3 = date2;
                            it2 = it;
                            z = true;
                        } catch (AnnotatedException e3) {
                            e2 = e3;
                            date3 = date2;
                            it2 = it;
                        }
                    }
                } catch (AnnotatedException e4) {
                    e2 = e4;
                    date2 = date3;
                    it = it2;
                    date3 = date2;
                    it2 = it;
                }
            }
            if (!z) {
                throw e2;
            }
            return;
        }
        throw new AnnotatedException("Validation time is in future.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(org.spongycastle.jcajce.PKIXExtendedParameters r20, java.security.cert.X509Certificate r21, java.util.Date r22, java.security.cert.X509Certificate r23, java.security.PublicKey r24, java.util.List r25, org.spongycastle.jcajce.util.JcaJceHelper r26) throws org.spongycastle.jce.provider.AnnotatedException {
        /*
        // Method dump skipped, instructions count: 373
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.e.d.a.g.b(org.spongycastle.jcajce.PKIXExtendedParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List, org.spongycastle.jcajce.util.JcaJceHelper):void");
    }

    public static int c(CertPath certPath, int i2, int i3) {
        return (b.o((X509Certificate) certPath.getCertificates().get(i2)) || i3 == 0) ? i3 : i3 - 1;
    }

    public static int d(CertPath certPath, int i2, int i3) {
        return (b.o((X509Certificate) certPath.getCertificates().get(i2)) || i3 == 0) ? i3 : i3 - 1;
    }

    public static int e(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(b.k((X509Certificate) certPath.getCertificates().get(i2), f));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (instance2.getTagNo() == 0) {
                            int intValue = ASN1Integer.getInstance(instance2, false).getValue().intValue();
                            if (intValue < i3) {
                                return intValue;
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e2, certPath, i2);
                    }
                }
            }
            return i3;
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e3, certPath, i2);
        }
    }

    public static int f(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(b.k((X509Certificate) certPath.getCertificates().get(i2), f));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (instance2.getTagNo() == 1) {
                            int intValue = ASN1Integer.getInstance(instance2, false).getValue().intValue();
                            if (intValue < i3) {
                                return intValue;
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e2, certPath, i2);
                    }
                }
            }
            return i3;
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e3, certPath, i2);
        }
    }

    public static int g(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        int intValue;
        try {
            ASN1Integer instance = ASN1Integer.getInstance(b.k((X509Certificate) certPath.getCertificates().get(i2), c));
            return (instance == null || (intValue = instance.getValue().intValue()) >= i3) ? i3 : intValue;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", e2, certPath, i2);
        }
    }

    public static void h(CertPath certPath, int i2) throws CertPathValidatorException {
        try {
            BasicConstraints instance = BasicConstraints.getInstance(b.k((X509Certificate) certPath.getCertificates().get(i2), g));
            if (instance == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
            } else if (!instance.isCA()) {
                throw new CertPathValidatorException("Not a CA certificate");
            }
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e2, certPath, i2);
        }
    }

    public static int i(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        if (b.o((X509Certificate) certPath.getCertificates().get(i2))) {
            return i3;
        }
        if (i3 > 0) {
            return i3 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certPath, i2);
    }

    public static int j(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        BigInteger pathLenConstraint;
        int intValue;
        try {
            BasicConstraints instance = BasicConstraints.getInstance(b.k((X509Certificate) certPath.getCertificates().get(i2), g));
            return (instance == null || (pathLenConstraint = instance.getPathLenConstraint()) == null || (intValue = pathLenConstraint.intValue()) >= i3) ? i3 : intValue;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e2, certPath, i2);
        }
    }

    public static void k(CertPath certPath, int i2) throws CertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i2)).getKeyUsage();
        if (keyUsage != null && !keyUsage[5]) {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certPath, i2);
        }
    }

    public static void l(CertPath certPath, int i2, Set set, List list) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e2) {
                throw new CertPathValidatorException(e2.getMessage(), e2.getCause(), certPath, i2);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, null, certPath, i2);
        }
    }

    public static void m(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        ASN1Primitive k2 = b.k(x509crl, d);
        int i2 = 0;
        boolean z = k2 != null && IssuingDistributionPoint.getInstance(k2).isIndirectCRL();
        try {
            byte[] encoded = X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded()).getEncoded();
            if (distributionPoint.getCRLIssuer() != null) {
                GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
                int i3 = 0;
                while (i2 < names.length) {
                    if (names[i2].getTagNo() == 4) {
                        try {
                            if (Arrays.areEqual(names[i2].getName().toASN1Primitive().getEncoded(), encoded)) {
                                i3 = 1;
                            }
                        } catch (IOException e2) {
                            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e2);
                        }
                    }
                    i2++;
                }
                if (i3 != 0 && !z) {
                    throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
                } else if (i3 != 0) {
                    i2 = i3;
                } else {
                    throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
                }
            } else if (X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded()).equals(AppCompatDelegateImpl.i.B0(obj))) {
                i2 = 1;
            }
            if (i2 == 0) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
            }
        } catch (IOException e3) {
            throw new AnnotatedException(a.A2(e3, a.L("Exception encoding CRL issuer: ")), e3);
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00d8: APUT  
      (r9v20 org.spongycastle.asn1.x509.GeneralName[])
      (0 ??[int, short, byte, char])
      (wrap: org.spongycastle.asn1.x509.GeneralName : 0x00d5: CONSTRUCTOR  (r3v9 org.spongycastle.asn1.x509.GeneralName) = 
      (wrap: org.spongycastle.asn1.x500.X500Name : 0x00d1: INVOKE  (r6v4 org.spongycastle.asn1.x500.X500Name) = 
      (wrap: byte[] : 0x00cd: INVOKE  (r6v3 byte[]) = 
      (wrap: org.spongycastle.asn1.x500.X500Name : 0x00c9: INVOKE  (r6v2 org.spongycastle.asn1.x500.X500Name) = (r10v0 java.lang.Object) type: STATIC call: androidx.appcompat.app.AppCompatDelegateImpl.i.B0(java.lang.Object):org.spongycastle.asn1.x500.X500Name)
     type: VIRTUAL call: org.spongycastle.asn1.ASN1Object.getEncoded():byte[])
     type: STATIC call: org.spongycastle.asn1.x500.X500Name.getInstance(java.lang.Object):org.spongycastle.asn1.x500.X500Name)
     call: org.spongycastle.asn1.x509.GeneralName.<init>(org.spongycastle.asn1.x500.X500Name):void type: CONSTRUCTOR)
     */
    public static void n(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        GeneralName[] generalNameArr;
        GeneralName[] names;
        try {
            IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(b.k(x509crl, d));
            if (instance != null) {
                if (instance.getDistributionPoint() != null) {
                    DistributionPointName distributionPoint2 = IssuingDistributionPoint.getInstance(instance).getDistributionPoint();
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    if (distributionPoint2.getType() == 0) {
                        for (GeneralName generalName : GeneralNames.getInstance(distributionPoint2.getName()).getNames()) {
                            arrayList.add(generalName);
                        }
                    }
                    if (distributionPoint2.getType() == 1) {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        try {
                            Enumeration objects = ASN1Sequence.getInstance(X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded())).getObjects();
                            while (objects.hasMoreElements()) {
                                aSN1EncodableVector.add((ASN1Encodable) objects.nextElement());
                            }
                            aSN1EncodableVector.add(distributionPoint2.getName());
                            arrayList.add(new GeneralName(X500Name.getInstance(new DERSequence(aSN1EncodableVector))));
                        } catch (Exception e2) {
                            throw new AnnotatedException("Could not read CRL issuer.", e2);
                        }
                    }
                    if (distributionPoint.getDistributionPoint() != null) {
                        DistributionPointName distributionPoint3 = distributionPoint.getDistributionPoint();
                        GeneralName[] generalNameArr2 = null;
                        if (distributionPoint3.getType() == 0) {
                            generalNameArr2 = GeneralNames.getInstance(distributionPoint3.getName()).getNames();
                        }
                        if (distributionPoint3.getType() == 1) {
                            if (distributionPoint.getCRLIssuer() != null) {
                                generalNameArr = distributionPoint.getCRLIssuer().getNames();
                            } else {
                                generalNameArr = new GeneralName[1];
                                try {
                                    generalNameArr[0] = new GeneralName(X500Name.getInstance(AppCompatDelegateImpl.i.B0(obj).getEncoded()));
                                } catch (Exception e3) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e3);
                                }
                            }
                            generalNameArr2 = generalNameArr;
                            for (int i2 = 0; i2 < generalNameArr2.length; i2++) {
                                Enumeration objects2 = ASN1Sequence.getInstance(generalNameArr2[i2].getName().toASN1Primitive()).getObjects();
                                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                                while (objects2.hasMoreElements()) {
                                    aSN1EncodableVector2.add((ASN1Encodable) objects2.nextElement());
                                }
                                aSN1EncodableVector2.add(distributionPoint3.getName());
                                generalNameArr2[i2] = new GeneralName(X500Name.getInstance(new DERSequence(aSN1EncodableVector2)));
                            }
                        }
                        if (generalNameArr2 != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= generalNameArr2.length) {
                                    break;
                                } else if (arrayList.contains(generalNameArr2[i3])) {
                                    z = true;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else if (distributionPoint.getCRLIssuer() != null) {
                        GeneralName[] names2 = distributionPoint.getCRLIssuer().getNames();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= names2.length) {
                                break;
                            } else if (arrayList.contains(names2[i4])) {
                                z = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                    }
                }
                try {
                    BasicConstraints instance2 = BasicConstraints.getInstance(b.k((X509Extension) obj, g));
                    if (obj instanceof X509Certificate) {
                        if (instance.onlyContainsUserCerts() && instance2 != null && instance2.isCA()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        } else if (instance.onlyContainsCACerts() && (instance2 == null || !instance2.isCA())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (instance.onlyContainsAttributeCerts()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e4) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e4);
                }
            }
        } catch (Exception e5) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e5);
        }
    }

    public static void o(X509CRL x509crl, X509CRL x509crl2, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException {
        if (x509crl != null) {
            try {
                String str = d;
                IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(b.k(x509crl2, str));
                if (!pKIXExtendedParameters.isUseDeltasEnabled()) {
                    return;
                }
                if (X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded()).equals(X500Name.getInstance(x509crl2.getIssuerX500Principal().getEncoded()))) {
                    try {
                        IssuingDistributionPoint instance2 = IssuingDistributionPoint.getInstance(b.k(x509crl, str));
                        boolean z = false;
                        if (instance != null ? instance.equals(instance2) : instance2 == null) {
                            z = true;
                        }
                        if (z) {
                            try {
                                String str2 = k;
                                ASN1Primitive k2 = b.k(x509crl2, str2);
                                try {
                                    ASN1Primitive k3 = b.k(x509crl, str2);
                                    if (k2 == null) {
                                        throw new AnnotatedException("CRL authority key identifier is null.");
                                    } else if (k3 == null) {
                                        throw new AnnotatedException("Delta CRL authority key identifier is null.");
                                    } else if (!k2.equals(k3)) {
                                        throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e2);
                                }
                            } catch (AnnotatedException e3) {
                                throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e3);
                            }
                        } else {
                            throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                        }
                    } catch (Exception e4) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e4);
                    }
                } else {
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                }
            } catch (Exception e5) {
                throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e5);
            }
        }
    }

    public static i p(X509CRL x509crl, DistributionPoint distributionPoint) throws AnnotatedException {
        i iVar;
        i iVar2;
        try {
            IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(b.k(x509crl, d));
            if (instance != null && instance.getOnlySomeReasons() != null && distributionPoint.getReasons() != null) {
                int intValue = distributionPoint.getReasons().intValue();
                int intValue2 = instance.getOnlySomeReasons().intValue();
                i iVar3 = new i();
                iVar3.a = (intValue2 & intValue) | iVar3.a;
                return iVar3;
            } else if ((instance == null || instance.getOnlySomeReasons() == null) && distributionPoint.getReasons() == null) {
                return i.b;
            } else {
                if (distributionPoint.getReasons() == null) {
                    iVar = i.b;
                } else {
                    iVar = new i(distributionPoint.getReasons());
                }
                if (instance == null) {
                    iVar2 = i.b;
                } else {
                    iVar2 = new i(instance.getOnlySomeReasons());
                }
                i iVar4 = new i();
                iVar4.a = (iVar2.a & iVar.a) | iVar4.a;
                return iVar4;
            }
        } catch (Exception e2) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e2);
        }
    }

    public static Set q(X509CRL x509crl, X509Certificate x509Certificate, PublicKey publicKey, PKIXExtendedParameters pKIXExtendedParameters, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        int i2;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(X500Name.getInstance(x509crl.getIssuerX500Principal().getEncoded()).getEncoded());
            PKIXCertStoreSelector<? extends Certificate> build = new PKIXCertStoreSelector.Builder(x509CertSelector).build();
            try {
                Collection a3 = b.a(build, pKIXExtendedParameters.getCertificateStores());
                a3.addAll(b.a(build, pKIXExtendedParameters.getCertStores()));
                a3.add(x509Certificate);
                Iterator it = a3.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            PKIXCertPathBuilderSpi pKIXCertPathBuilderSpi = new PKIXCertPathBuilderSpi();
                            X509CertSelector x509CertSelector2 = new X509CertSelector();
                            x509CertSelector2.setCertificate(x509Certificate2);
                            PKIXExtendedParameters.Builder targetConstraints = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).setTargetConstraints(new PKIXCertStoreSelector.Builder(x509CertSelector2).build());
                            if (list.contains(x509Certificate2)) {
                                targetConstraints.setRevocationEnabled(false);
                            } else {
                                targetConstraints.setRevocationEnabled(true);
                            }
                            List<? extends Certificate> certificates = pKIXCertPathBuilderSpi.engineBuild(new PKIXExtendedBuilderParameters.Builder(targetConstraints.build()).build()).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(b.l(certificates, 0, jcaJceHelper));
                        } catch (CertPathBuilderException e2) {
                            throw new AnnotatedException("CertPath for CRL signer failed to validate.", e2);
                        } catch (CertPathValidatorException e3) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e3);
                        } catch (Exception e4) {
                            throw new AnnotatedException(e4.getMessage());
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i2)).getKeyUsage();
                    if (keyUsage == null || (keyUsage.length >= 7 && keyUsage[6])) {
                        hashSet.add(arrayList2.get(i2));
                    } else {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                } else if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                } else {
                    throw annotatedException;
                }
            } catch (AnnotatedException e5) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e5);
            }
        } catch (IOException e6) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e6);
        }
    }

    public static PublicKey r(X509CRL x509crl, Set set) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e2 = null;
        while (it.hasNext()) {
            PublicKey publicKey = (PublicKey) it.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e2);
    }

    public static X509CRL s(Set set, PublicKey publicKey) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e2 = null;
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e2);
    }
}
