package org.spongycastle.asn1.cms;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class SignerInfo extends ASN1Object {
    public ASN1Integer a;
    public SignerIdentifier b;
    public AlgorithmIdentifier c;
    public ASN1Set d;
    public AlgorithmIdentifier e;
    public ASN1OctetString f;
    public ASN1Set g;

    public SignerInfo(SignerIdentifier signerIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier2, ASN1OctetString aSN1OctetString, ASN1Set aSN1Set2) {
        if (signerIdentifier.isTagged()) {
            this.a = new ASN1Integer(3);
        } else {
            this.a = new ASN1Integer(1);
        }
        this.b = signerIdentifier;
        this.c = algorithmIdentifier;
        this.d = aSN1Set;
        this.e = algorithmIdentifier2;
        this.f = aSN1OctetString;
        this.g = aSN1Set2;
    }

    public static SignerInfo getInstance(Object obj) throws IllegalArgumentException {
        if (obj instanceof SignerInfo) {
            return (SignerInfo) obj;
        }
        if (obj != null) {
            return new SignerInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Set getAuthenticatedAttributes() {
        return this.d;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.c;
    }

    public AlgorithmIdentifier getDigestEncryptionAlgorithm() {
        return this.e;
    }

    public ASN1OctetString getEncryptedDigest() {
        return this.f;
    }

    public SignerIdentifier getSID() {
        return this.b;
    }

    public ASN1Set getUnauthenticatedAttributes() {
        return this.g;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        ASN1Set aSN1Set = this.d;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        aSN1EncodableVector.add(this.e);
        aSN1EncodableVector.add(this.f);
        ASN1Set aSN1Set2 = this.g;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SignerInfo(SignerIdentifier signerIdentifier, AlgorithmIdentifier algorithmIdentifier, Attributes attributes, AlgorithmIdentifier algorithmIdentifier2, ASN1OctetString aSN1OctetString, Attributes attributes2) {
        if (signerIdentifier.isTagged()) {
            this.a = new ASN1Integer(3);
        } else {
            this.a = new ASN1Integer(1);
        }
        this.b = signerIdentifier;
        this.c = algorithmIdentifier;
        this.d = ASN1Set.getInstance(attributes);
        this.e = algorithmIdentifier2;
        this.f = aSN1OctetString;
        this.g = ASN1Set.getInstance(attributes2);
    }

    public SignerInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = (ASN1Integer) objects.nextElement();
        this.b = SignerIdentifier.getInstance(objects.nextElement());
        this.c = AlgorithmIdentifier.getInstance(objects.nextElement());
        Object nextElement = objects.nextElement();
        if (nextElement instanceof ASN1TaggedObject) {
            this.d = ASN1Set.getInstance((ASN1TaggedObject) nextElement, false);
            this.e = AlgorithmIdentifier.getInstance(objects.nextElement());
        } else {
            this.d = null;
            this.e = AlgorithmIdentifier.getInstance(nextElement);
        }
        this.f = ASN1OctetString.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.g = ASN1Set.getInstance((ASN1TaggedObject) objects.nextElement(), false);
        } else {
            this.g = null;
        }
    }
}
