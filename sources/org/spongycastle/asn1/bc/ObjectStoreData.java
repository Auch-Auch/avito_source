package org.spongycastle.asn1.bc;

import java.math.BigInteger;
import java.util.Date;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class ObjectStoreData extends ASN1Object {
    public final BigInteger a;
    public final AlgorithmIdentifier b;
    public final ASN1GeneralizedTime c;
    public final ASN1GeneralizedTime d;
    public final ObjectDataSequence e;
    public final String f;

    public ObjectStoreData(AlgorithmIdentifier algorithmIdentifier, Date date, Date date2, ObjectDataSequence objectDataSequence, String str) {
        this.a = BigInteger.valueOf(1);
        this.b = algorithmIdentifier;
        this.c = new DERGeneralizedTime(date);
        this.d = new DERGeneralizedTime(date2);
        this.e = objectDataSequence;
        this.f = str;
    }

    public static ObjectStoreData getInstance(Object obj) {
        if (obj instanceof ObjectStoreData) {
            return (ObjectStoreData) obj;
        }
        if (obj != null) {
            return new ObjectStoreData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public String getComment() {
        return this.f;
    }

    public ASN1GeneralizedTime getCreationDate() {
        return this.c;
    }

    public AlgorithmIdentifier getIntegrityAlgorithm() {
        return this.b;
    }

    public ASN1GeneralizedTime getLastModifiedDate() {
        return this.d;
    }

    public ObjectDataSequence getObjectDataSequence() {
        return this.e;
    }

    public BigInteger getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(this.a));
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.e);
        String str = this.f;
        if (str != null) {
            aSN1EncodableVector.add(new DERUTF8String(str));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ObjectStoreData(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue();
        this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(2));
        this.d = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
        this.e = ObjectDataSequence.getInstance(aSN1Sequence.getObjectAt(4));
        this.f = aSN1Sequence.size() == 6 ? DERUTF8String.getInstance(aSN1Sequence.getObjectAt(5)).getString() : null;
    }
}
