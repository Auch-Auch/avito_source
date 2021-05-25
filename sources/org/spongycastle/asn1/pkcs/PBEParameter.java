package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
public class PBEParameter extends ASN1Object {
    public ASN1Integer a;
    public ASN1OctetString b;

    public PBEParameter(byte[] bArr, int i) {
        if (bArr.length == 8) {
            this.b = new DEROctetString(bArr);
            this.a = new ASN1Integer((long) i);
            return;
        }
        throw new IllegalArgumentException("salt length must be 8");
    }

    public static PBEParameter getInstance(Object obj) {
        if (obj instanceof PBEParameter) {
            return (PBEParameter) obj;
        }
        if (obj != null) {
            return new PBEParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.a.getValue();
    }

    public byte[] getSalt() {
        return this.b.getOctets();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public PBEParameter(ASN1Sequence aSN1Sequence) {
        this.b = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }
}
