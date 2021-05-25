package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class NameConstraints extends ASN1Object {
    public GeneralSubtree[] a;
    public GeneralSubtree[] b;

    public NameConstraints(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.a = b(ASN1Sequence.getInstance(instance, false));
            } else if (tagNo == 1) {
                this.b = b(ASN1Sequence.getInstance(instance, false));
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("Unknown tag encountered: ")));
            }
        }
    }

    public static GeneralSubtree[] a(GeneralSubtree[] generalSubtreeArr) {
        if (generalSubtreeArr == null) {
            return null;
        }
        int length = generalSubtreeArr.length;
        GeneralSubtree[] generalSubtreeArr2 = new GeneralSubtree[length];
        System.arraycopy(generalSubtreeArr, 0, generalSubtreeArr2, 0, length);
        return generalSubtreeArr2;
    }

    public static NameConstraints getInstance(Object obj) {
        if (obj instanceof NameConstraints) {
            return (NameConstraints) obj;
        }
        if (obj != null) {
            return new NameConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public final GeneralSubtree[] b(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        GeneralSubtree[] generalSubtreeArr = new GeneralSubtree[size];
        for (int i = 0; i != size; i++) {
            generalSubtreeArr[i] = GeneralSubtree.getInstance(aSN1Sequence.getObjectAt(i));
        }
        return generalSubtreeArr;
    }

    public GeneralSubtree[] getExcludedSubtrees() {
        return a(this.b);
    }

    public GeneralSubtree[] getPermittedSubtrees() {
        return a(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralSubtree[] generalSubtreeArr = this.a;
        if (generalSubtreeArr != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, new DERSequence(generalSubtreeArr)));
        }
        GeneralSubtree[] generalSubtreeArr2 = this.b;
        if (generalSubtreeArr2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, new DERSequence(generalSubtreeArr2)));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public NameConstraints(GeneralSubtree[] generalSubtreeArr, GeneralSubtree[] generalSubtreeArr2) {
        this.a = a(generalSubtreeArr);
        this.b = a(generalSubtreeArr2);
    }
}
