package org.spongycastle.asn1.cms;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class CMSAlgorithmProtection extends ASN1Object {
    public static final int MAC = 2;
    public static final int SIGNATURE = 1;
    public final AlgorithmIdentifier a;
    public final AlgorithmIdentifier b;
    public final AlgorithmIdentifier c;

    public CMSAlgorithmProtection(AlgorithmIdentifier algorithmIdentifier, int i, AlgorithmIdentifier algorithmIdentifier2) {
        if (algorithmIdentifier == null || algorithmIdentifier2 == null) {
            throw new NullPointerException("AlgorithmIdentifiers cannot be null");
        }
        this.a = algorithmIdentifier;
        if (i == 1) {
            this.b = algorithmIdentifier2;
            this.c = null;
        } else if (i == 2) {
            this.b = null;
            this.c = algorithmIdentifier2;
        } else {
            throw new IllegalArgumentException(a.M2("Unknown type: ", i));
        }
    }

    public static CMSAlgorithmProtection getInstance(Object obj) {
        if (obj instanceof CMSAlgorithmProtection) {
            return (CMSAlgorithmProtection) obj;
        }
        if (obj != null) {
            return new CMSAlgorithmProtection(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.a;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.c;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        AlgorithmIdentifier algorithmIdentifier = this.b;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, algorithmIdentifier));
        }
        AlgorithmIdentifier algorithmIdentifier2 = this.c;
        if (algorithmIdentifier2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, algorithmIdentifier2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CMSAlgorithmProtection(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance.getTagNo() == 1) {
                this.b = AlgorithmIdentifier.getInstance(instance, false);
                this.c = null;
            } else if (instance.getTagNo() == 2) {
                this.b = null;
                this.c = AlgorithmIdentifier.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("Unknown tag found: ")));
            }
        } else {
            throw new IllegalArgumentException("Sequence wrong size: One of signatureAlgorithm or macAlgorithm must be present");
        }
    }
}
