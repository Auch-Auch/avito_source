package org.spongycastle.asn1.esf;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CrlListID extends ASN1Object {
    public ASN1Sequence a;

    public CrlListID(ASN1Sequence aSN1Sequence) {
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
        this.a = aSN1Sequence2;
        Enumeration objects = aSN1Sequence2.getObjects();
        while (objects.hasMoreElements()) {
            CrlValidatedID.getInstance(objects.nextElement());
        }
    }

    public static CrlListID getInstance(Object obj) {
        if (obj instanceof CrlListID) {
            return (CrlListID) obj;
        }
        if (obj != null) {
            return new CrlListID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CrlValidatedID[] getCrls() {
        int size = this.a.size();
        CrlValidatedID[] crlValidatedIDArr = new CrlValidatedID[size];
        for (int i = 0; i < size; i++) {
            crlValidatedIDArr[i] = CrlValidatedID.getInstance(this.a.getObjectAt(i));
        }
        return crlValidatedIDArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.a);
    }

    public CrlListID(CrlValidatedID[] crlValidatedIDArr) {
        this.a = new DERSequence(crlValidatedIDArr);
    }
}
