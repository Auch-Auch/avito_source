package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class OCSPResponse extends ASN1Object {
    public OCSPResponseStatus a;
    public ResponseBytes b;

    public OCSPResponse(OCSPResponseStatus oCSPResponseStatus, ResponseBytes responseBytes) {
        this.a = oCSPResponseStatus;
        this.b = responseBytes;
    }

    public static OCSPResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ResponseBytes getResponseBytes() {
        return this.b;
    }

    public OCSPResponseStatus getResponseStatus() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ResponseBytes responseBytes = this.b;
        if (responseBytes != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, responseBytes));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static OCSPResponse getInstance(Object obj) {
        if (obj instanceof OCSPResponse) {
            return (OCSPResponse) obj;
        }
        if (obj != null) {
            return new OCSPResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OCSPResponse(ASN1Sequence aSN1Sequence) {
        this.a = OCSPResponseStatus.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.b = ResponseBytes.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        }
    }
}
