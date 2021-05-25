package org.spongycastle.asn1.cmc;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;
public class GetCert extends ASN1Object {
    public final GeneralName a;
    public final BigInteger b;

    public GetCert(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static GetCert getInstance(Object obj) {
        if (obj instanceof GetCert) {
            return (GetCert) obj;
        }
        if (obj != null) {
            return new GetCert(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getIssuerName() {
        return this.a;
    }

    public BigInteger getSerialNumber() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new ASN1Integer(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public GetCert(GeneralName generalName, BigInteger bigInteger) {
        this.a = generalName;
        this.b = bigInteger;
    }
}
