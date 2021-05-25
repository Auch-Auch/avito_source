package org.spongycastle.asn1.x9;

import a2.b.a.a.a;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
public class ValidationParams extends ASN1Object {
    public DERBitString a;
    public ASN1Integer b;

    public ValidationParams(byte[] bArr, int i) {
        if (bArr != null) {
            this.a = new DERBitString(bArr);
            this.b = new ASN1Integer((long) i);
            return;
        }
        throw new IllegalArgumentException("'seed' cannot be null");
    }

    public static ValidationParams getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getPgenCounter() {
        return this.b.getPositiveValue();
    }

    public byte[] getSeed() {
        return this.a.getBytes();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public static ValidationParams getInstance(Object obj) {
        if (obj instanceof ValidationParams) {
            return (ValidationParams) obj;
        }
        if (obj != null) {
            return new ValidationParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ValidationParams(DERBitString dERBitString, ASN1Integer aSN1Integer) {
        if (dERBitString == null) {
            throw new IllegalArgumentException("'seed' cannot be null");
        } else if (aSN1Integer != null) {
            this.a = dERBitString;
            this.b = aSN1Integer;
        } else {
            throw new IllegalArgumentException("'pgenCounter' cannot be null");
        }
    }

    public ValidationParams(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = DERBitString.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }
}
