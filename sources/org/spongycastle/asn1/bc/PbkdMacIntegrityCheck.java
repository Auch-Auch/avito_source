package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.KeyDerivationFunc;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;
public class PbkdMacIntegrityCheck extends ASN1Object {
    public final AlgorithmIdentifier a;
    public final KeyDerivationFunc b;
    public final ASN1OctetString c;

    public PbkdMacIntegrityCheck(AlgorithmIdentifier algorithmIdentifier, KeyDerivationFunc keyDerivationFunc, byte[] bArr) {
        this.a = algorithmIdentifier;
        this.b = keyDerivationFunc;
        this.c = new DEROctetString(Arrays.clone(bArr));
    }

    public static PbkdMacIntegrityCheck getInstance(Object obj) {
        if (obj instanceof PbkdMacIntegrityCheck) {
            return (PbkdMacIntegrityCheck) obj;
        }
        if (obj != null) {
            return new PbkdMacIntegrityCheck(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getMac() {
        return Arrays.clone(this.c.getOctets());
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.a;
    }

    public KeyDerivationFunc getPbkdAlgorithm() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public PbkdMacIntegrityCheck(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = KeyDerivationFunc.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2));
    }
}
