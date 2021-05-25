package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;
public class EncryptedPOP extends ASN1Object {
    public final TaggedRequest a;
    public final ContentInfo b;
    public final AlgorithmIdentifier c;
    public final AlgorithmIdentifier d;
    public final byte[] e;

    public EncryptedPOP(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 5) {
            this.a = TaggedRequest.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
            this.e = a.x1(aSN1Sequence, 4);
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static EncryptedPOP getInstance(Object obj) {
        if (obj instanceof EncryptedPOP) {
            return (EncryptedPOP) obj;
        }
        if (obj != null) {
            return new EncryptedPOP(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContentInfo getCms() {
        return this.b;
    }

    public TaggedRequest getRequest() {
        return this.a;
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.c;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.e);
    }

    public AlgorithmIdentifier getWitnessAlgID() {
        return this.d;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(new DEROctetString(this.e));
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedPOP(TaggedRequest taggedRequest, ContentInfo contentInfo, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) {
        this.a = taggedRequest;
        this.b = contentInfo;
        this.c = algorithmIdentifier;
        this.d = algorithmIdentifier2;
        this.e = Arrays.clone(bArr);
    }
}
