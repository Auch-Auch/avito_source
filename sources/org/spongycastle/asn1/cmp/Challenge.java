package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class Challenge extends ASN1Object {
    public AlgorithmIdentifier a;
    public ASN1OctetString b;
    public ASN1OctetString c;

    public Challenge(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence.size() == 3) {
            this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        }
        this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
        this.c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i + 1));
    }

    public static Challenge getInstance(Object obj) {
        if (obj instanceof Challenge) {
            return (Challenge) obj;
        }
        if (obj != null) {
            return new Challenge(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getChallenge() {
        return this.c.getOctets();
    }

    public AlgorithmIdentifier getOwf() {
        return this.a;
    }

    public byte[] getWitness() {
        return this.b.getOctets();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        AlgorithmIdentifier algorithmIdentifier = this.a;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.add(algorithmIdentifier);
        }
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public Challenge(byte[] bArr, byte[] bArr2) {
        this(null, bArr, bArr2);
    }

    public Challenge(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
        this.a = algorithmIdentifier;
        this.b = new DEROctetString(bArr);
        this.c = new DEROctetString(bArr2);
    }
}
