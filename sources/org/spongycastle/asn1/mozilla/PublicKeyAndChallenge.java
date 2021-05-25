package org.spongycastle.asn1.mozilla;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
public class PublicKeyAndChallenge extends ASN1Object {
    public ASN1Sequence a;
    public SubjectPublicKeyInfo b;
    public DERIA5String c;

    public PublicKeyAndChallenge(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
        this.b = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.c = DERIA5String.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static PublicKeyAndChallenge getInstance(Object obj) {
        if (obj instanceof PublicKeyAndChallenge) {
            return (PublicKeyAndChallenge) obj;
        }
        if (obj != null) {
            return new PublicKeyAndChallenge(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERIA5String getChallenge() {
        return this.c;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }
}
