package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class EncryptedValue extends ASN1Object {
    public AlgorithmIdentifier a;
    public AlgorithmIdentifier b;
    public DERBitString c;
    public AlgorithmIdentifier d;
    public ASN1OctetString e;
    public DERBitString f;

    public EncryptedValue(ASN1Sequence aSN1Sequence) {
        int i = 0;
        while (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.a = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 1) {
                this.b = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 2) {
                this.c = DERBitString.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 3) {
                this.d = AlgorithmIdentifier.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 4) {
                this.e = ASN1OctetString.getInstance(aSN1TaggedObject, false);
            } else {
                throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Unknown tag encountered: ")));
            }
            i++;
        }
        this.f = DERBitString.getInstance(aSN1Sequence.getObjectAt(i));
    }

    public static EncryptedValue getInstance(Object obj) {
        if (obj instanceof EncryptedValue) {
            return (EncryptedValue) obj;
        }
        if (obj != null) {
            return new EncryptedValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public final void a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, i, aSN1Encodable));
        }
    }

    public DERBitString getEncSymmKey() {
        return this.c;
    }

    public DERBitString getEncValue() {
        return this.f;
    }

    public AlgorithmIdentifier getIntendedAlg() {
        return this.a;
    }

    public AlgorithmIdentifier getKeyAlg() {
        return this.d;
    }

    public AlgorithmIdentifier getSymmAlg() {
        return this.b;
    }

    public ASN1OctetString getValueHint() {
        return this.e;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        a(aSN1EncodableVector, 0, this.a);
        a(aSN1EncodableVector, 1, this.b);
        a(aSN1EncodableVector, 2, this.c);
        a(aSN1EncodableVector, 3, this.d);
        a(aSN1EncodableVector, 4, this.e);
        aSN1EncodableVector.add(this.f);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedValue(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, DERBitString dERBitString, AlgorithmIdentifier algorithmIdentifier3, ASN1OctetString aSN1OctetString, DERBitString dERBitString2) {
        if (dERBitString2 != null) {
            this.a = algorithmIdentifier;
            this.b = algorithmIdentifier2;
            this.c = dERBitString;
            this.d = algorithmIdentifier3;
            this.e = aSN1OctetString;
            this.f = dERBitString2;
            return;
        }
        throw new IllegalArgumentException("'encValue' cannot be null");
    }
}
