package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class ExtendedFailInfo extends ASN1Object {
    public final ASN1ObjectIdentifier a;
    public final ASN1Encodable b;

    public ExtendedFailInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.a = aSN1ObjectIdentifier;
        this.b = aSN1Encodable;
    }

    public static ExtendedFailInfo getInstance(Object obj) {
        if (obj instanceof ExtendedFailInfo) {
            return (ExtendedFailInfo) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new ExtendedFailInfo((ASN1Sequence) aSN1Primitive);
            }
            return null;
        } else if (obj instanceof byte[]) {
            return getInstance(ASN1Sequence.getInstance(obj));
        } else {
            return null;
        }
    }

    public ASN1ObjectIdentifier getFailInfoOID() {
        return this.a;
    }

    public ASN1Encodable getFailInfoValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.a, this.b});
    }

    public ExtendedFailInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = aSN1Sequence.getObjectAt(1);
            return;
        }
        throw new IllegalArgumentException("Sequence must be 2 elements.");
    }
}
