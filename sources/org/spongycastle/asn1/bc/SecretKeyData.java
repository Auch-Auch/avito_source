package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
public class SecretKeyData extends ASN1Object {
    public final ASN1ObjectIdentifier a;
    public final ASN1OctetString b;

    public SecretKeyData(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.a = aSN1ObjectIdentifier;
        this.b = new DEROctetString(Arrays.clone(bArr));
    }

    public static SecretKeyData getInstance(Object obj) {
        if (obj instanceof SecretKeyData) {
            return (SecretKeyData) obj;
        }
        if (obj != null) {
            return new SecretKeyData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getKeyAlgorithm() {
        return this.a;
    }

    public byte[] getKeyBytes() {
        return Arrays.clone(this.b.getOctets());
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public SecretKeyData(ASN1Sequence aSN1Sequence) {
        this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
    }
}
