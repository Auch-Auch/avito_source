package org.spongycastle.asn1.cryptopro;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.util.Arrays;
public class GostR3410TransportParameters extends ASN1Object {
    public final ASN1ObjectIdentifier a;
    public final SubjectPublicKeyInfo b;
    public final byte[] c;

    public GostR3410TransportParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, SubjectPublicKeyInfo subjectPublicKeyInfo, byte[] bArr) {
        this.a = aSN1ObjectIdentifier;
        this.b = subjectPublicKeyInfo;
        this.c = Arrays.clone(bArr);
    }

    public static GostR3410TransportParameters getInstance(Object obj) {
        if (obj instanceof GostR3410TransportParameters) {
            return (GostR3410TransportParameters) obj;
        }
        if (obj != null) {
            return new GostR3410TransportParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.a;
    }

    public SubjectPublicKeyInfo getEphemeralPublicKey() {
        return this.b;
    }

    public byte[] getUkm() {
        return Arrays.clone(this.c);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.b;
        if (subjectPublicKeyInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, subjectPublicKeyInfo));
        }
        aSN1EncodableVector.add(new DEROctetString(this.c));
        return new DERSequence(aSN1EncodableVector);
    }

    public static GostR3410TransportParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GostR3410TransportParameters(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GostR3410TransportParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
            this.b = null;
        } else if (aSN1Sequence.size() == 3) {
            this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = SubjectPublicKeyInfo.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)), false);
            this.c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets();
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("unknown sequence length: ")));
        }
    }
}
