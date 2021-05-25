package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class GeneralSubtree extends ASN1Object {
    public static final BigInteger d = BigInteger.valueOf(0);
    public GeneralName a;
    public ASN1Integer b;
    public ASN1Integer c;

    public GeneralSubtree(ASN1Sequence aSN1Sequence) {
        this.a = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        int size = aSN1Sequence.size();
        if (size == 1) {
            return;
        }
        if (size == 2) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.b = ASN1Integer.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.c = ASN1Integer.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("Bad tag number: ")));
            }
        } else if (size == 3) {
            ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance2.getTagNo() == 0) {
                this.b = ASN1Integer.getInstance(instance2, false);
                ASN1TaggedObject instance3 = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2));
                if (instance3.getTagNo() == 1) {
                    this.c = ASN1Integer.getInstance(instance3, false);
                    return;
                }
                throw new IllegalArgumentException(a.D(instance3, a.L("Bad tag number for 'maximum': ")));
            }
            throw new IllegalArgumentException(a.D(instance2, a.L("Bad tag number for 'minimum': ")));
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralSubtree(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralName getBase() {
        return this.a;
    }

    public BigInteger getMaximum() {
        ASN1Integer aSN1Integer = this.c;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    public BigInteger getMinimum() {
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer == null) {
            return d;
        }
        return aSN1Integer.getValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer != null && !aSN1Integer.getValue().equals(d)) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.b));
        }
        ASN1Integer aSN1Integer2 = this.c;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Integer2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static GeneralSubtree getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof GeneralSubtree) {
            return (GeneralSubtree) obj;
        }
        return new GeneralSubtree(ASN1Sequence.getInstance(obj));
    }

    public GeneralSubtree(GeneralName generalName, BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = generalName;
        if (bigInteger2 != null) {
            this.c = new ASN1Integer(bigInteger2);
        }
        if (bigInteger == null) {
            this.b = null;
        } else {
            this.b = new ASN1Integer(bigInteger);
        }
    }

    public GeneralSubtree(GeneralName generalName) {
        this(generalName, null, null);
    }
}
