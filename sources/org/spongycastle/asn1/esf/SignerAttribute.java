package org.spongycastle.asn1.esf;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Attribute;
import org.spongycastle.asn1.x509.AttributeCertificate;
public class SignerAttribute extends ASN1Object {
    public Object[] a;

    public SignerAttribute(ASN1Sequence aSN1Sequence) {
        this.a = new Object[aSN1Sequence.size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            if (instance.getTagNo() == 0) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance, true);
                int size = instance2.size();
                Attribute[] attributeArr = new Attribute[size];
                for (int i2 = 0; i2 != size; i2++) {
                    attributeArr[i2] = Attribute.getInstance(instance2.getObjectAt(i2));
                }
                this.a[i] = attributeArr;
            } else if (instance.getTagNo() == 1) {
                this.a[i] = AttributeCertificate.getInstance(ASN1Sequence.getInstance(instance, true));
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("illegal tag: ")));
            }
            i++;
        }
    }

    public static SignerAttribute getInstance(Object obj) {
        if (obj instanceof SignerAttribute) {
            return (SignerAttribute) obj;
        }
        if (obj != null) {
            return new SignerAttribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Object[] getValues() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            Object[] objArr = this.a;
            if (i == objArr.length) {
                return new DERSequence(aSN1EncodableVector);
            }
            if (objArr[i] instanceof Attribute[]) {
                aSN1EncodableVector.add(new DERTaggedObject(0, new DERSequence((Attribute[]) objArr[i])));
            } else {
                aSN1EncodableVector.add(new DERTaggedObject(1, (AttributeCertificate) objArr[i]));
            }
            i++;
        }
    }

    public SignerAttribute(Attribute[] attributeArr) {
        Object[] objArr = new Object[1];
        this.a = objArr;
        objArr[0] = attributeArr;
    }

    public SignerAttribute(AttributeCertificate attributeCertificate) {
        Object[] objArr = new Object[1];
        this.a = objArr;
        objArr[0] = attributeCertificate;
    }
}
