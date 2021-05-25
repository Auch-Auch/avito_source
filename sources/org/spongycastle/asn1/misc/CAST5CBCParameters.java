package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
public class CAST5CBCParameters extends ASN1Object {
    public ASN1Integer a;
    public ASN1OctetString b;

    public CAST5CBCParameters(byte[] bArr, int i) {
        this.b = new DEROctetString(Arrays.clone(bArr));
        this.a = new ASN1Integer((long) i);
    }

    public static CAST5CBCParameters getInstance(Object obj) {
        if (obj instanceof CAST5CBCParameters) {
            return (CAST5CBCParameters) obj;
        }
        if (obj != null) {
            return new CAST5CBCParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getIV() {
        return Arrays.clone(this.b.getOctets());
    }

    public int getKeyLength() {
        return this.a.getValue().intValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public CAST5CBCParameters(ASN1Sequence aSN1Sequence) {
        this.b = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }
}
