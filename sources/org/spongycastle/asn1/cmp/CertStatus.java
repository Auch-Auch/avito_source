package org.spongycastle.asn1.cmp;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
public class CertStatus extends ASN1Object {
    public ASN1OctetString a;
    public ASN1Integer b;
    public PKIStatusInfo c;

    public CertStatus(ASN1Sequence aSN1Sequence) {
        this.a = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.c = PKIStatusInfo.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static CertStatus getInstance(Object obj) {
        if (obj instanceof CertStatus) {
            return (CertStatus) obj;
        }
        if (obj != null) {
            return new CertStatus(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getCertHash() {
        return this.a;
    }

    public ASN1Integer getCertReqId() {
        return this.b;
    }

    public PKIStatusInfo getStatusInfo() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        PKIStatusInfo pKIStatusInfo = this.c;
        if (pKIStatusInfo != null) {
            aSN1EncodableVector.add(pKIStatusInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger) {
        this.a = new DEROctetString(bArr);
        this.b = new ASN1Integer(bigInteger);
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger, PKIStatusInfo pKIStatusInfo) {
        this.a = new DEROctetString(bArr);
        this.b = new ASN1Integer(bigInteger);
        this.c = pKIStatusInfo;
    }
}
