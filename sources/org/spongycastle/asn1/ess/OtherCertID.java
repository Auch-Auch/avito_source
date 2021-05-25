package org.spongycastle.asn1.ess;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.IssuerSerial;
public class OtherCertID extends ASN1Object {
    public ASN1Encodable a;
    public IssuerSerial b;

    public OtherCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        if (aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1OctetString) {
            this.a = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.a = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() > 1) {
            this.b = IssuerSerial.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static OtherCertID getInstance(Object obj) {
        if (obj instanceof OtherCertID) {
            return (OtherCertID) obj;
        }
        if (obj != null) {
            return new OtherCertID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithmHash() {
        if (this.a.toASN1Primitive() instanceof ASN1OctetString) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
        }
        return DigestInfo.getInstance(this.a).getAlgorithmId();
    }

    public byte[] getCertHash() {
        if (this.a.toASN1Primitive() instanceof ASN1OctetString) {
            return ((ASN1OctetString) this.a.toASN1Primitive()).getOctets();
        }
        return DigestInfo.getInstance(this.a).getDigest();
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

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = new DigestInfo(algorithmIdentifier, bArr);
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial) {
        this.a = new DigestInfo(algorithmIdentifier, bArr);
        this.b = issuerSerial;
    }
}
