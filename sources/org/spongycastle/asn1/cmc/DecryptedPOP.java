package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;
public class DecryptedPOP extends ASN1Object {
    public final BodyPartID a;
    public final AlgorithmIdentifier b;
    public final byte[] c;

    public DecryptedPOP(BodyPartID bodyPartID, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = bodyPartID;
        this.b = algorithmIdentifier;
        this.c = Arrays.clone(bArr);
    }

    public static DecryptedPOP getInstance(Object obj) {
        if (obj instanceof DecryptedPOP) {
            return (DecryptedPOP) obj;
        }
        if (obj != null) {
            return new DecryptedPOP(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID getBodyPartID() {
        return this.a;
    }

    public byte[] getThePOP() {
        return Arrays.clone(this.c);
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(new DEROctetString(this.c));
        return new DERSequence(aSN1EncodableVector);
    }

    public DecryptedPOP(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = a.x1(aSN1Sequence, 2);
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }
}
