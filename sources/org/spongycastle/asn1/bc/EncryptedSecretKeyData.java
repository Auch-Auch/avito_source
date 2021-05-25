package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;
public class EncryptedSecretKeyData extends ASN1Object {
    public final AlgorithmIdentifier a;
    public final ASN1OctetString b;

    public EncryptedSecretKeyData(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = algorithmIdentifier;
        this.b = new DEROctetString(Arrays.clone(bArr));
    }

    public static EncryptedSecretKeyData getInstance(Object obj) {
        if (obj instanceof EncryptedSecretKeyData) {
            return (EncryptedSecretKeyData) obj;
        }
        if (obj != null) {
            return new EncryptedSecretKeyData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getEncryptedKeyData() {
        return Arrays.clone(this.b.getOctets());
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedSecretKeyData(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
    }
}
