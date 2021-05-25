package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class PolicyConstraints extends ASN1Object {
    public BigInteger a;
    public BigInteger b;

    public PolicyConstraints(BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = bigInteger;
        this.b = bigInteger2;
    }

    public static PolicyConstraints fromExtensions(Extensions extensions) {
        return getInstance(extensions.getExtensionParsedValue(Extension.policyConstraints));
    }

    public static PolicyConstraints getInstance(Object obj) {
        if (obj instanceof PolicyConstraints) {
            return (PolicyConstraints) obj;
        }
        if (obj != null) {
            return new PolicyConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getInhibitPolicyMapping() {
        return this.b;
    }

    public BigInteger getRequireExplicitPolicyMapping() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        BigInteger bigInteger = this.a;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, new ASN1Integer(bigInteger)));
        }
        BigInteger bigInteger2 = this.b;
        if (bigInteger2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, new ASN1Integer(bigInteger2)));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PolicyConstraints(ASN1Sequence aSN1Sequence) {
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            if (instance.getTagNo() == 0) {
                this.a = ASN1Integer.getInstance(instance, false).getValue();
            } else if (instance.getTagNo() == 1) {
                this.b = ASN1Integer.getInstance(instance, false).getValue();
            } else {
                throw new IllegalArgumentException("Unknown tag encountered.");
            }
        }
    }
}
