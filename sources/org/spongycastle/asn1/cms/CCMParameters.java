package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
public class CCMParameters extends ASN1Object {
    public byte[] a;
    public int b;

    public CCMParameters(ASN1Sequence aSN1Sequence) {
        this.a = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets();
        if (aSN1Sequence.size() == 2) {
            this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue().intValue();
        } else {
            this.b = 12;
        }
    }

    public static CCMParameters getInstance(Object obj) {
        if (obj instanceof CCMParameters) {
            return (CCMParameters) obj;
        }
        if (obj != null) {
            return new CCMParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getIcvLen() {
        return this.b;
    }

    public byte[] getNonce() {
        return Arrays.clone(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DEROctetString(this.a));
        int i = this.b;
        if (i != 12) {
            aSN1EncodableVector.add(new ASN1Integer((long) i));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CCMParameters(byte[] bArr, int i) {
        this.a = Arrays.clone(bArr);
        this.b = i;
    }
}
