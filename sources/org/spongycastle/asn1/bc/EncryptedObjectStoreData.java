package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class EncryptedObjectStoreData extends ASN1Object {
    public final AlgorithmIdentifier a;
    public final ASN1OctetString b;

    public EncryptedObjectStoreData(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = algorithmIdentifier;
        this.b = new DEROctetString(bArr);
    }

    public static EncryptedObjectStoreData getInstance(Object obj) {
        if (obj instanceof EncryptedObjectStoreData) {
            return (EncryptedObjectStoreData) obj;
        }
        if (obj != null) {
            return new EncryptedObjectStoreData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getEncryptedContent() {
        return this.b;
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedObjectStoreData(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
    }
}
