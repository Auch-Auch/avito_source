package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509Name;
public class CertificationRequestInfo extends ASN1Object {
    public ASN1Integer a;
    public X500Name b;
    public SubjectPublicKeyInfo c;
    public ASN1Set d;

    public CertificationRequestInfo(X500Name x500Name, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1Set aSN1Set) {
        this.a = new ASN1Integer(0);
        this.d = null;
        if (x500Name == null || subjectPublicKeyInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
        a(aSN1Set);
        this.b = x500Name;
        this.c = subjectPublicKeyInfo;
        this.d = aSN1Set;
    }

    public static void a(ASN1Set aSN1Set) {
        if (aSN1Set != null) {
            Enumeration objects = aSN1Set.getObjects();
            while (objects.hasMoreElements()) {
                Attribute instance = Attribute.getInstance(objects.nextElement());
                if (instance.getAttrType().equals(PKCSObjectIdentifiers.pkcs_9_at_challengePassword) && instance.getAttrValues().size() != 1) {
                    throw new IllegalArgumentException("challengePassword attribute must have one value");
                }
            }
        }
    }

    public static CertificationRequestInfo getInstance(Object obj) {
        if (obj instanceof CertificationRequestInfo) {
            return (CertificationRequestInfo) obj;
        }
        if (obj != null) {
            return new CertificationRequestInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Set getAttributes() {
        return this.d;
    }

    public X500Name getSubject() {
        return this.b;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.c;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        ASN1Set aSN1Set = this.d;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificationRequestInfo(X509Name x509Name, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1Set aSN1Set) {
        this(X500Name.getInstance(x509Name.toASN1Primitive()), subjectPublicKeyInfo, aSN1Set);
    }

    public CertificationRequestInfo(ASN1Sequence aSN1Sequence) {
        this.a = new ASN1Integer(0);
        this.d = null;
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.b = X500Name.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(2));
        if (aSN1Sequence.size() > 3) {
            this.d = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(3), false);
        }
        a(this.d);
        if (this.b == null || this.a == null || this.c == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }
}
