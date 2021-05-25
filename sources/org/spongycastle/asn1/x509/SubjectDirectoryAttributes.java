package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class SubjectDirectoryAttributes extends ASN1Object {
    public Vector a = new Vector();

    public SubjectDirectoryAttributes(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            this.a.addElement(Attribute.getInstance(ASN1Sequence.getInstance(objects.nextElement())));
        }
    }

    public static SubjectDirectoryAttributes getInstance(Object obj) {
        if (obj instanceof SubjectDirectoryAttributes) {
            return (SubjectDirectoryAttributes) obj;
        }
        if (obj != null) {
            return new SubjectDirectoryAttributes(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Vector getAttributes() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.a.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.add((Attribute) elements.nextElement());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SubjectDirectoryAttributes(Vector vector) {
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            this.a.addElement(elements.nextElement());
        }
    }
}
