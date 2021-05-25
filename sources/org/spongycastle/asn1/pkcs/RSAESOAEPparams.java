package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class RSAESOAEPparams extends ASN1Object {
    public static final AlgorithmIdentifier DEFAULT_HASH_ALGORITHM;
    public static final AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION;
    public static final AlgorithmIdentifier DEFAULT_P_SOURCE_ALGORITHM = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(new byte[0]));
    public AlgorithmIdentifier a;
    public AlgorithmIdentifier b;
    public AlgorithmIdentifier c;

    static {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        DEFAULT_HASH_ALGORITHM = algorithmIdentifier;
        DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, algorithmIdentifier);
    }

    public RSAESOAEPparams() {
        this.a = DEFAULT_HASH_ALGORITHM;
        this.b = DEFAULT_MASK_GEN_FUNCTION;
        this.c = DEFAULT_P_SOURCE_ALGORITHM;
    }

    public static RSAESOAEPparams getInstance(Object obj) {
        if (obj instanceof RSAESOAEPparams) {
            return (RSAESOAEPparams) obj;
        }
        if (obj != null) {
            return new RSAESOAEPparams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.a;
    }

    public AlgorithmIdentifier getMaskGenAlgorithm() {
        return this.b;
    }

    public AlgorithmIdentifier getPSourceAlgorithm() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.a.equals(DEFAULT_HASH_ALGORITHM)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.a));
        }
        if (!this.b.equals(DEFAULT_MASK_GEN_FUNCTION)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.b));
        }
        if (!this.c.equals(DEFAULT_P_SOURCE_ALGORITHM)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, this.c));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAESOAEPparams(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, AlgorithmIdentifier algorithmIdentifier3) {
        this.a = algorithmIdentifier;
        this.b = algorithmIdentifier2;
        this.c = algorithmIdentifier3;
    }

    public RSAESOAEPparams(ASN1Sequence aSN1Sequence) {
        this.a = DEFAULT_HASH_ALGORITHM;
        this.b = DEFAULT_MASK_GEN_FUNCTION;
        this.c = DEFAULT_P_SOURCE_ALGORITHM;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.a = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.b = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 2) {
                this.c = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else {
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }
}
