package org.spongycastle.asn1.mozilla;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class SignedPublicKeyAndChallenge extends ASN1Object {
    public final PublicKeyAndChallenge a;
    public final ASN1Sequence b;

    public SignedPublicKeyAndChallenge(ASN1Sequence aSN1Sequence) {
        this.b = aSN1Sequence;
        this.a = PublicKeyAndChallenge.getInstance(aSN1Sequence.getObjectAt(0));
    }

    public static SignedPublicKeyAndChallenge getInstance(Object obj) {
        if (obj instanceof SignedPublicKeyAndChallenge) {
            return (SignedPublicKeyAndChallenge) obj;
        }
        if (obj != null) {
            return new SignedPublicKeyAndChallenge(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PublicKeyAndChallenge getPublicKeyAndChallenge() {
        return this.a;
    }

    public DERBitString getSignature() {
        return DERBitString.getInstance(this.b.getObjectAt(2));
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.b.getObjectAt(1));
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.b;
    }
}
