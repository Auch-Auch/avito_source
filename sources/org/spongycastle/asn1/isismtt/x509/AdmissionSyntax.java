package org.spongycastle.asn1.isismtt.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;
public class AdmissionSyntax extends ASN1Object {
    public GeneralName a;
    public ASN1Sequence b;

    public AdmissionSyntax(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        if (size == 1) {
            this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0));
        } else if (size == 2) {
            this.a = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
    }

    public static AdmissionSyntax getInstance(Object obj) {
        if (obj == null || (obj instanceof AdmissionSyntax)) {
            return (AdmissionSyntax) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new AdmissionSyntax((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public GeneralName getAdmissionAuthority() {
        return this.a;
    }

    public Admissions[] getContentsOfAdmissions() {
        Admissions[] admissionsArr = new Admissions[this.b.size()];
        Enumeration objects = this.b.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            admissionsArr[i] = Admissions.getInstance(objects.nextElement());
            i++;
        }
        return admissionsArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralName generalName = this.a;
        if (generalName != null) {
            aSN1EncodableVector.add(generalName);
        }
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public AdmissionSyntax(GeneralName generalName, ASN1Sequence aSN1Sequence) {
        this.a = generalName;
        this.b = aSN1Sequence;
    }
}
