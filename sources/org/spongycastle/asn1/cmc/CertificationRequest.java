package org.spongycastle.asn1.cmc;

import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class CertificationRequest extends ASN1Object {
    public static final ASN1Integer d = new ASN1Integer(0);
    public final b a;
    public final AlgorithmIdentifier b;
    public final DERBitString c;

    public CertificationRequest(X500Name x500Name, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString, ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier2, DERBitString dERBitString2) {
        this.a = new b(this, x500Name, algorithmIdentifier, dERBitString, aSN1Set, null);
        this.b = algorithmIdentifier2;
        this.c = dERBitString2;
    }

    public static CertificationRequest getInstance(Object obj) {
        if (obj instanceof CertificationRequest) {
            return (CertificationRequest) obj;
        }
        if (obj != null) {
            return new CertificationRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Set getAttributes() {
        return this.a.d;
    }

    public DERBitString getSignature() {
        return this.c;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.b;
    }

    public X500Name getSubject() {
        return this.a.b;
    }

    public DERBitString getSubjectPublicKey() {
        return DERBitString.getInstance(this.a.c.getObjectAt(1));
    }

    public AlgorithmIdentifier getSubjectPublicKeyAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.a.c.getObjectAt(0));
    }

    public BigInteger getVersion() {
        return this.a.a.getValue();
    }

    public ASN1Primitive parsePublicKey() throws IOException {
        return ASN1Primitive.fromByteArray(getSubjectPublicKey().getOctets());
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificationRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = new b(this, ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0)), null);
            this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public class b extends ASN1Object {
        public final ASN1Integer a;
        public final X500Name b;
        public final ASN1Sequence c;
        public final ASN1Set d;

        public b(CertificationRequest certificationRequest, ASN1Sequence aSN1Sequence, a aVar) {
            if (aSN1Sequence.size() == 4) {
                this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
                this.b = X500Name.getInstance(aSN1Sequence.getObjectAt(1));
                ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2));
                this.c = instance;
                if (instance.size() == 2) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(3);
                    if (aSN1TaggedObject.getTagNo() == 0) {
                        this.d = ASN1Set.getInstance(aSN1TaggedObject, false);
                        return;
                    }
                    throw new IllegalArgumentException("incorrect tag number on attributes for CertificationRequestInfo");
                }
                throw new IllegalArgumentException("incorrect subjectPublicKeyInfo size for CertificationRequestInfo");
            }
            throw new IllegalArgumentException("incorrect sequence size for CertificationRequestInfo");
        }

        @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(this.a);
            aSN1EncodableVector.add(this.b);
            aSN1EncodableVector.add(this.c);
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.d));
            return new DERSequence(aSN1EncodableVector);
        }

        public b(CertificationRequest certificationRequest, X500Name x500Name, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString, ASN1Set aSN1Set, a aVar) {
            this.a = CertificationRequest.d;
            this.b = x500Name;
            this.c = new DERSequence(new ASN1Encodable[]{algorithmIdentifier, dERBitString});
            this.d = aSN1Set;
        }
    }
}
