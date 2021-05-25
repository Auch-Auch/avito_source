package org.spongycastle.x509;

import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.x509.AccessDescription;
import org.spongycastle.asn1.x509.AuthorityInformationAccess;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.asn1.x509.qualified.ETSIQCObjectIdentifiers;
import org.spongycastle.asn1.x509.qualified.MonetaryValue;
import org.spongycastle.asn1.x509.qualified.QCStatement;
import org.spongycastle.asn1.x509.qualified.RFC3739QCObjectIdentifiers;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.filter.TrustedInput;
import org.spongycastle.i18n.filter.UntrustedInput;
import org.spongycastle.jce.provider.AnnotatedException;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.PKIXPolicyNode;
import org.spongycastle.util.Integers;
import x6.e.g.a;
public class PKIXCertPathReviewer extends a {
    public static final String b = Extension.qCStatements.getId();
    public static final String c = Extension.cRLDistributionPoints.getId();
    public static final String d = Extension.authorityInfoAccess.getId();
    public boolean a;
    public CertPath certPath;
    public List certs;
    public List[] errors;
    public int n;
    public List[] notifications;
    public PKIXParameters pkixParams;
    public PolicyNode policyTree;
    public PublicKey subjectPublicKey;
    public TrustAnchor trustAnchor;
    public Date validDate;

    public PKIXCertPathReviewer(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath2, pKIXParameters);
    }

    public void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    public final void c() {
        int i;
        int i2;
        int i3;
        int i4;
        PKIXPolicyNode pKIXPolicyNode;
        int i5;
        int i6;
        String str;
        Set<String> set;
        HashSet hashSet;
        String str2;
        int i7;
        int intValue;
        String str3;
        HashSet hashSet2;
        HashSet hashSet3;
        String str4;
        int i8;
        String str5 = "CertPathReviewer.policyExtError";
        Set<String> initialPolicies = this.pkixParams.getInitialPolicies();
        int i9 = this.n + 1;
        ArrayList[] arrayListArr = new ArrayList[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            arrayListArr[i10] = new ArrayList();
        }
        HashSet hashSet4 = new HashSet();
        hashSet4.add(a.ANY_POLICY);
        PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), 0, hashSet4, null, new HashSet(), a.ANY_POLICY, false);
        arrayListArr[0].add(pKIXPolicyNode2);
        if (this.pkixParams.isExplicitPolicyRequired()) {
            i2 = 0;
            i = 1;
        } else {
            i = 1;
            i2 = this.n + 1;
        }
        if (this.pkixParams.isAnyPolicyInhibited()) {
            i3 = 0;
        } else {
            i3 = this.n + i;
        }
        if (this.pkixParams.isPolicyMappingInhibited()) {
            i4 = 0;
        } else {
            i4 = this.n + i;
        }
        try {
            int size = this.certs.size() - i;
            PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNode2;
            X509Certificate x509Certificate = null;
            HashSet hashSet5 = null;
            while (size >= 0) {
                int i11 = this.n - size;
                X509Certificate x509Certificate2 = (X509Certificate) this.certs.get(size);
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) a.getExtensionValue(x509Certificate2, a.CERTIFICATE_POLICIES);
                    if (aSN1Sequence == null || pKIXPolicyNode3 == null) {
                        set = initialPolicies;
                        str = str5;
                        i6 = i3;
                        i5 = i4;
                        pKIXPolicyNode3 = pKIXPolicyNode3;
                    } else {
                        Enumeration objects = aSN1Sequence.getObjects();
                        set = initialPolicies;
                        HashSet hashSet6 = new HashSet();
                        while (objects.hasMoreElements()) {
                            PolicyInformation instance = PolicyInformation.getInstance(objects.nextElement());
                            ASN1ObjectIdentifier policyIdentifier = instance.getPolicyIdentifier();
                            hashSet6.add(policyIdentifier.getId());
                            if (!a.ANY_POLICY.equals(policyIdentifier.getId())) {
                                try {
                                    Set qualifierSet = a.getQualifierSet(instance.getPolicyQualifiers());
                                    if (!a.processCertD1i(i11, arrayListArr, policyIdentifier, qualifierSet)) {
                                        a.processCertD1ii(i11, arrayListArr, policyIdentifier, qualifierSet);
                                    }
                                } catch (CertPathValidatorException e) {
                                    throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyQualifierError"), e, this.certPath, size);
                                }
                            }
                            pKIXPolicyNode3 = pKIXPolicyNode3;
                            str5 = str5;
                        }
                        str = str5;
                        if (hashSet5 == null || hashSet5.contains(a.ANY_POLICY)) {
                            hashSet2 = hashSet6;
                        } else {
                            hashSet2 = new HashSet();
                            for (Object obj : hashSet5) {
                                if (hashSet6.contains(obj)) {
                                    hashSet2.add(obj);
                                }
                            }
                        }
                        if (i3 > 0 || (i11 < this.n && a.isSelfIssued(x509Certificate2))) {
                            Enumeration objects2 = aSN1Sequence.getObjects();
                            while (true) {
                                if (!objects2.hasMoreElements()) {
                                    break;
                                }
                                PolicyInformation instance2 = PolicyInformation.getInstance(objects2.nextElement());
                                if (a.ANY_POLICY.equals(instance2.getPolicyIdentifier().getId())) {
                                    try {
                                        Set qualifierSet2 = a.getQualifierSet(instance2.getPolicyQualifiers());
                                        ArrayList arrayList = arrayListArr[i11 - 1];
                                        hashSet3 = hashSet2;
                                        for (int i12 = 0; i12 < arrayList.size(); i12++) {
                                            PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) arrayList.get(i12);
                                            for (Object obj2 : pKIXPolicyNode4.getExpectedPolicies()) {
                                                if (obj2 instanceof String) {
                                                    str4 = (String) obj2;
                                                } else if (obj2 instanceof ASN1ObjectIdentifier) {
                                                    str4 = ((ASN1ObjectIdentifier) obj2).getId();
                                                } else {
                                                    arrayList = arrayList;
                                                    i3 = i3;
                                                }
                                                boolean z = false;
                                                for (Iterator children = pKIXPolicyNode4.getChildren(); children.hasNext(); children = children) {
                                                    if (str4.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                                        z = true;
                                                    }
                                                }
                                                if (!z) {
                                                    HashSet hashSet7 = new HashSet();
                                                    hashSet7.add(str4);
                                                    i8 = i4;
                                                    PKIXPolicyNode pKIXPolicyNode5 = new PKIXPolicyNode(new ArrayList(), i11, hashSet7, pKIXPolicyNode4, qualifierSet2, str4, false);
                                                    pKIXPolicyNode4.addChild(pKIXPolicyNode5);
                                                    arrayListArr[i11].add(pKIXPolicyNode5);
                                                } else {
                                                    i8 = i4;
                                                }
                                                arrayList = arrayList;
                                                i3 = i3;
                                                i4 = i8;
                                            }
                                        }
                                        i6 = i3;
                                        i5 = i4;
                                    } catch (CertPathValidatorException e2) {
                                        throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyQualifierError"), e2, this.certPath, size);
                                    }
                                }
                            }
                        }
                        i6 = i3;
                        i5 = i4;
                        hashSet3 = hashSet2;
                        pKIXPolicyNode3 = pKIXPolicyNode3;
                        for (int i13 = i11 - 1; i13 >= 0; i13--) {
                            ArrayList arrayList2 = arrayListArr[i13];
                            for (int i14 = 0; i14 < arrayList2.size(); i14++) {
                                PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) arrayList2.get(i14);
                                if (!pKIXPolicyNode6.hasChildren()) {
                                    PKIXPolicyNode removePolicyNode = a.removePolicyNode(pKIXPolicyNode3, arrayListArr, pKIXPolicyNode6);
                                    pKIXPolicyNode3 = removePolicyNode;
                                    if (removePolicyNode == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs != null) {
                            boolean contains = criticalExtensionOIDs.contains(a.CERTIFICATE_POLICIES);
                            ArrayList arrayList3 = arrayListArr[i11];
                            for (int i15 = 0; i15 < arrayList3.size(); i15++) {
                                ((PKIXPolicyNode) arrayList3.get(i15)).setCritical(contains);
                            }
                        }
                        hashSet5 = hashSet3;
                    }
                    if (aSN1Sequence == null) {
                        pKIXPolicyNode3 = null;
                    }
                    if (i2 > 0 || pKIXPolicyNode3 != null) {
                        if (i11 != this.n) {
                            try {
                                ASN1Primitive extensionValue = a.getExtensionValue(x509Certificate2, a.POLICY_MAPPINGS);
                                if (extensionValue != null) {
                                    int i16 = 0;
                                    for (ASN1Sequence aSN1Sequence2 = (ASN1Sequence) extensionValue; i16 < aSN1Sequence2.size(); aSN1Sequence2 = aSN1Sequence2) {
                                        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(i16);
                                        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence3.getObjectAt(1);
                                        if (a.ANY_POLICY.equals(((ASN1ObjectIdentifier) aSN1Sequence3.getObjectAt(0)).getId())) {
                                            throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                        } else if (!a.ANY_POLICY.equals(aSN1ObjectIdentifier.getId())) {
                                            i16++;
                                        } else {
                                            throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                        }
                                    }
                                }
                                if (extensionValue != null) {
                                    ASN1Sequence aSN1Sequence4 = (ASN1Sequence) extensionValue;
                                    HashMap hashMap = new HashMap();
                                    HashSet hashSet8 = new HashSet();
                                    int i17 = 0;
                                    while (i17 < aSN1Sequence4.size()) {
                                        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence4.getObjectAt(i17);
                                        String id = ((ASN1ObjectIdentifier) aSN1Sequence5.getObjectAt(0)).getId();
                                        String id2 = ((ASN1ObjectIdentifier) aSN1Sequence5.getObjectAt(1)).getId();
                                        if (!hashMap.containsKey(id)) {
                                            HashSet hashSet9 = new HashSet();
                                            hashSet9.add(id2);
                                            hashMap.put(id, hashSet9);
                                            hashSet8.add(id);
                                        } else {
                                            ((Set) hashMap.get(id)).add(id2);
                                        }
                                        i17++;
                                        aSN1Sequence4 = aSN1Sequence4;
                                        hashSet5 = hashSet5;
                                    }
                                    hashSet = hashSet5;
                                    Iterator it = hashSet8.iterator();
                                    while (it.hasNext()) {
                                        String str6 = (String) it.next();
                                        if (i5 > 0) {
                                            try {
                                                a.prepareNextCertB1(i11, arrayListArr, str6, hashMap, x509Certificate2);
                                                str3 = str;
                                            } catch (AnnotatedException e3) {
                                                throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", str), e3, this.certPath, size);
                                            } catch (CertPathValidatorException e4) {
                                                throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyQualifierError"), e4, this.certPath, size);
                                            }
                                        } else {
                                            str3 = str;
                                            if (i5 <= 0) {
                                                pKIXPolicyNode3 = a.prepareNextCertB2(i11, arrayListArr, str6, pKIXPolicyNode3);
                                            }
                                        }
                                        str = str3;
                                    }
                                } else {
                                    hashSet = hashSet5;
                                }
                                str2 = str;
                                if (!a.isSelfIssued(x509Certificate2)) {
                                    if (i2 != 0) {
                                        i2--;
                                    }
                                    i4 = i5 != 0 ? i5 - 1 : i5;
                                    i7 = i6 != 0 ? i6 - 1 : i6;
                                } else {
                                    i7 = i6;
                                    i4 = i5;
                                }
                                try {
                                    ASN1Sequence aSN1Sequence6 = (ASN1Sequence) a.getExtensionValue(x509Certificate2, a.POLICY_CONSTRAINTS);
                                    if (aSN1Sequence6 != null) {
                                        Enumeration objects3 = aSN1Sequence6.getObjects();
                                        while (objects3.hasMoreElements()) {
                                            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects3.nextElement();
                                            int tagNo = aSN1TaggedObject.getTagNo();
                                            if (tagNo == 0) {
                                                int intValue2 = ASN1Integer.getInstance(aSN1TaggedObject, false).getValue().intValue();
                                                if (intValue2 < i2) {
                                                    i2 = intValue2;
                                                }
                                            } else if (tagNo == 1) {
                                                int intValue3 = ASN1Integer.getInstance(aSN1TaggedObject, false).getValue().intValue();
                                                if (intValue3 < i4) {
                                                    i4 = intValue3;
                                                }
                                            }
                                        }
                                    }
                                    try {
                                        ASN1Integer aSN1Integer = (ASN1Integer) a.getExtensionValue(x509Certificate2, a.INHIBIT_ANY_POLICY);
                                        if (aSN1Integer != null && (intValue = aSN1Integer.getValue().intValue()) < i7) {
                                            i7 = intValue;
                                        }
                                    } catch (AnnotatedException unused) {
                                        throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyInhibitExtError"), this.certPath, size);
                                    }
                                } catch (AnnotatedException unused2) {
                                    throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyConstExtError"), this.certPath, size);
                                }
                            } catch (AnnotatedException e5) {
                                throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyMapExtError"), e5, this.certPath, size);
                            }
                        } else {
                            hashSet = hashSet5;
                            str2 = str;
                            i7 = i6;
                            i4 = i5;
                        }
                        size--;
                        x509Certificate = x509Certificate2;
                        str5 = str2;
                        hashSet5 = hashSet;
                        i9 = i9;
                        i3 = i7;
                        initialPolicies = set;
                    } else {
                        throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.noValidPolicyTree"));
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", str5), e6, this.certPath, size);
                }
            }
            Set<String> set2 = initialPolicies;
            int i18 = i9;
            if (!a.isSelfIssued(x509Certificate) && i2 > 0) {
                i2--;
            }
            try {
                ASN1Sequence aSN1Sequence7 = (ASN1Sequence) a.getExtensionValue(x509Certificate, a.POLICY_CONSTRAINTS);
                if (aSN1Sequence7 != null) {
                    Enumeration objects4 = aSN1Sequence7.getObjects();
                    int i19 = i2;
                    while (objects4.hasMoreElements()) {
                        ASN1TaggedObject aSN1TaggedObject2 = (ASN1TaggedObject) objects4.nextElement();
                        if (aSN1TaggedObject2.getTagNo() == 0) {
                            if (ASN1Integer.getInstance(aSN1TaggedObject2, false).getValue().intValue() == 0) {
                                i19 = 0;
                            }
                        }
                    }
                    i2 = i19;
                }
                if (pKIXPolicyNode3 == null) {
                    if (!this.pkixParams.isExplicitPolicyRequired()) {
                        pKIXPolicyNode = null;
                    } else {
                        throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.explicitPolicy"), this.certPath, size);
                    }
                } else if (!a.isAnyPolicy(set2)) {
                    HashSet hashSet10 = new HashSet();
                    for (int i20 = 0; i20 < i18; i20++) {
                        ArrayList arrayList4 = arrayListArr[i20];
                        for (int i21 = 0; i21 < arrayList4.size(); i21++) {
                            PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) arrayList4.get(i21);
                            if (a.ANY_POLICY.equals(pKIXPolicyNode7.getValidPolicy())) {
                                Iterator children2 = pKIXPolicyNode7.getChildren();
                                while (children2.hasNext()) {
                                    PKIXPolicyNode pKIXPolicyNode8 = (PKIXPolicyNode) children2.next();
                                    if (!a.ANY_POLICY.equals(pKIXPolicyNode8.getValidPolicy())) {
                                        hashSet10.add(pKIXPolicyNode8);
                                    }
                                }
                            }
                        }
                    }
                    Iterator it2 = hashSet10.iterator();
                    pKIXPolicyNode = pKIXPolicyNode3;
                    while (it2.hasNext()) {
                        PKIXPolicyNode pKIXPolicyNode9 = (PKIXPolicyNode) it2.next();
                        if (!set2.contains(pKIXPolicyNode9.getValidPolicy())) {
                            pKIXPolicyNode = a.removePolicyNode(pKIXPolicyNode, arrayListArr, pKIXPolicyNode9);
                        }
                        set2 = set2;
                    }
                    if (pKIXPolicyNode != null) {
                        for (int i22 = this.n - 1; i22 >= 0; i22--) {
                            ArrayList arrayList5 = arrayListArr[i22];
                            for (int i23 = 0; i23 < arrayList5.size(); i23++) {
                                PKIXPolicyNode pKIXPolicyNode10 = (PKIXPolicyNode) arrayList5.get(i23);
                                if (!pKIXPolicyNode10.hasChildren()) {
                                    pKIXPolicyNode = a.removePolicyNode(pKIXPolicyNode, arrayListArr, pKIXPolicyNode10);
                                }
                            }
                        }
                    }
                } else if (!this.pkixParams.isExplicitPolicyRequired()) {
                    pKIXPolicyNode = pKIXPolicyNode3;
                } else if (!hashSet5.isEmpty()) {
                    HashSet hashSet11 = new HashSet();
                    int i24 = 0;
                    while (i24 < i18) {
                        ArrayList arrayList6 = arrayListArr[i24];
                        for (int i25 = 0; i25 < arrayList6.size(); i25++) {
                            PKIXPolicyNode pKIXPolicyNode11 = (PKIXPolicyNode) arrayList6.get(i25);
                            if (a.ANY_POLICY.equals(pKIXPolicyNode11.getValidPolicy())) {
                                Iterator children3 = pKIXPolicyNode11.getChildren();
                                while (children3.hasNext()) {
                                    hashSet11.add(children3.next());
                                }
                            }
                        }
                        i24++;
                        i18 = i18;
                    }
                    Iterator it3 = hashSet11.iterator();
                    while (it3.hasNext()) {
                        hashSet5.contains(((PKIXPolicyNode) it3.next()).getValidPolicy());
                    }
                    pKIXPolicyNode = pKIXPolicyNode3;
                    for (int i26 = this.n - 1; i26 >= 0; i26--) {
                        ArrayList arrayList7 = arrayListArr[i26];
                        for (int i27 = 0; i27 < arrayList7.size(); i27++) {
                            PKIXPolicyNode pKIXPolicyNode12 = (PKIXPolicyNode) arrayList7.get(i27);
                            if (!pKIXPolicyNode12.hasChildren()) {
                                pKIXPolicyNode = a.removePolicyNode(pKIXPolicyNode, arrayListArr, pKIXPolicyNode12);
                            }
                        }
                    }
                } else {
                    throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.explicitPolicy"), this.certPath, size);
                }
                if (i2 <= 0 && pKIXPolicyNode == null) {
                    throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.invalidPolicy"));
                }
            } catch (AnnotatedException unused3) {
                throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyConstExtError"), this.certPath, size);
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x01d1: APUT  
      (r15v8 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: org.spongycastle.i18n.filter.TrustedInput : 0x01cd: CONSTRUCTOR  (r12v35 org.spongycastle.i18n.filter.TrustedInput) = 
      (wrap: java.util.Date : 0x01c9: INVOKE  (r13v19 java.util.Date) = (r14v6 java.security.cert.X509CRL) type: VIRTUAL call: java.security.cert.X509CRL.getThisUpdate():java.util.Date)
     call: org.spongycastle.i18n.filter.TrustedInput.<init>(java.lang.Object):void type: CONSTRUCTOR)
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03af, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x010b, code lost:
        addNotification(new org.spongycastle.i18n.ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.localValidCRL", new java.lang.Object[]{new org.spongycastle.i18n.filter.TrustedInput(r0.getThisUpdate()), new org.spongycastle.i18n.filter.TrustedInput(r0.getNextUpdate())}), r28);
        r11 = r0;
        r0 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkCRLs(java.security.cert.PKIXParameters r22, java.security.cert.X509Certificate r23, java.util.Date r24, java.security.cert.X509Certificate r25, java.security.PublicKey r26, java.util.Vector r27, int r28) throws org.spongycastle.x509.CertPathReviewerException {
        /*
        // Method dump skipped, instructions count: 1197
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws CertPathReviewerException {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    public final X509CRL d(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals(UriUtil.HTTP_SCHEME)) {
                if (!url.getProtocol().equals("https")) {
                    return null;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00eb, code lost:
        addError(new org.spongycastle.i18n.ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.trustButInvalidCert"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02dd A[Catch:{ AnnotatedException -> 0x02e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02ff A[LOOP:2: B:109:0x02f9->B:111:0x02ff, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0328 A[LOOP:3: B:113:0x0322->B:115:0x0328, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0440 A[Catch:{ CertPathReviewerException -> 0x0551 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x056a  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x05d7 A[Catch:{ CertPathValidatorException -> 0x06b7 }, LOOP:8: B:236:0x05d1->B:239:0x05d7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x05ec A[Catch:{ CertPathReviewerException -> 0x06b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:18:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doChecks() {
        /*
        // Method dump skipped, instructions count: 1777
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.PKIXCertPathReviewer.doChecks():void");
    }

    public final boolean e(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) a.getExtensionValue(x509Certificate, b);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                QCStatement instance = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.equals(instance.getStatementId())) {
                    addNotification(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcEuCompliance"), i);
                } else if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.equals(instance.getStatementId())) {
                    if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.equals(instance.getStatementId())) {
                        addNotification(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcSSCD"), i);
                    } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.equals(instance.getStatementId())) {
                        MonetaryValue instance2 = MonetaryValue.getInstance(instance.getStatementInfo());
                        instance2.getCurrency();
                        double doubleValue = instance2.getAmount().doubleValue() * Math.pow(10.0d, instance2.getExponent().doubleValue());
                        if (instance2.getCurrency().isAlphabetic()) {
                            errorBundle = new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcLimitValueAlpha", new Object[]{instance2.getCurrency().getAlphabetic(), new TrustedInput(new Double(doubleValue)), instance2});
                        } else {
                            errorBundle = new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(instance2.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), instance2});
                        }
                        addNotification(errorBundle, i);
                    } else {
                        addNotification(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcUnknownStatement", new Object[]{instance.getStatementId(), new UntrustedInput(instance)}), i);
                        z = true;
                    }
                }
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        DistributionPoint[] distributionPoints;
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(a.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(instance.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = instance.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor2 = (TrustAnchor) it.next();
                if (trustAnchor2.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor2.getTrustedCert())) {
                        arrayList.add(trustAnchor2);
                    }
                } else if (!(trustAnchor2.getCAName() == null || trustAnchor2.getCAPublicKey() == null || !a.getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor2.getCAName())))) {
                    arrayList.add(trustAnchor2);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (!this.a) {
            this.a = true;
            Objects.requireNonNull(certPath2, "certPath was null");
            this.certPath = certPath2;
            List<? extends Certificate> certificates = certPath2.getCertificates();
            this.certs = certificates;
            this.n = certificates.size();
            if (!this.certs.isEmpty()) {
                PKIXParameters pKIXParameters2 = (PKIXParameters) pKIXParameters.clone();
                this.pkixParams = pKIXParameters2;
                this.validDate = a.getValidDate(pKIXParameters2);
                this.notifications = null;
                this.errors = null;
                this.trustAnchor = null;
                this.subjectPublicKey = null;
                this.policyTree = null;
                return;
            }
            throw new CertPathReviewerException(new ErrorBundle("org.spongycastle.x509.CertPathReviewerMessages", "CertPathReviewer.emptyCertPath"));
        }
        throw new IllegalStateException("object is already initialized!");
    }

    public boolean isValidCertPath() {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }

    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    public PKIXCertPathReviewer() {
    }

    public List getErrors(int i) {
        doChecks();
        return this.errors[i + 1];
    }

    public List getNotifications(int i) {
        doChecks();
        return this.notifications[i + 1];
    }
}
