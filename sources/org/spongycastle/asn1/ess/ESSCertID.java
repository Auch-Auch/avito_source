package org.spongycastle.asn1.ess;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.IssuerSerial;
public class ESSCertID extends ASN1Object {
    public ASN1OctetString a;
    public IssuerSerial b;

    public ESSCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        this.a = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.b = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static ESSCertID getInstance(Object obj) {
        if (obj instanceof ESSCertID) {
            return (ESSCertID) obj;
        }
        if (obj != null) {
            return new ESSCertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getCertHash() {
        return this.a.getOctets();
    }

    public IssuerSerial getIssuerSerial() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        IssuerSerial issuerSerial = this.b;
        if (issuerSerial != null) {
            aSN1EncodableVector.add(issuerSerial);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ESSCertID(byte[] bArr) {
        this.a = new DEROctetString(bArr);
    }

    public ESSCertID(byte[] bArr, IssuerSerial issuerSerial) {
        this.a = new DEROctetString(bArr);
        this.b = issuerSerial;
    }
}
