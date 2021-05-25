package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class Accuracy extends ASN1Object {
    public static final int MAX_MICROS = 999;
    public static final int MAX_MILLIS = 999;
    public static final int MIN_MICROS = 1;
    public static final int MIN_MILLIS = 1;
    public ASN1Integer a;
    public ASN1Integer b;
    public ASN1Integer c;

    public Accuracy() {
    }

    public static Accuracy getInstance(Object obj) {
        if (obj instanceof Accuracy) {
            return (Accuracy) obj;
        }
        if (obj != null) {
            return new Accuracy(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getMicros() {
        return this.c;
    }

    public ASN1Integer getMillis() {
        return this.b;
    }

    public ASN1Integer getSeconds() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        ASN1Integer aSN1Integer2 = this.b;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Integer2));
        }
        ASN1Integer aSN1Integer3 = this.c;
        if (aSN1Integer3 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Integer3));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public Accuracy(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3) {
        this.a = aSN1Integer;
        if (aSN1Integer2 == null || (aSN1Integer2.getValue().intValue() >= 1 && aSN1Integer2.getValue().intValue() <= 999)) {
            this.b = aSN1Integer2;
            if (aSN1Integer3 == null || (aSN1Integer3.getValue().intValue() >= 1 && aSN1Integer3.getValue().intValue() <= 999)) {
                this.c = aSN1Integer3;
                return;
            }
            throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
        }
        throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
    }

    public Accuracy(ASN1Sequence aSN1Sequence) {
        this.a = null;
        this.b = null;
        this.c = null;
        for (int i = 0; i < aSN1Sequence.size(); i++) {
            if (aSN1Sequence.getObjectAt(i) instanceof ASN1Integer) {
                this.a = (ASN1Integer) aSN1Sequence.getObjectAt(i);
            } else if (!(aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject)) {
                continue;
            } else {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    ASN1Integer instance = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    this.b = instance;
                    if (instance.getValue().intValue() < 1 || this.b.getValue().intValue() > 999) {
                        throw new IllegalArgumentException("Invalid millis field : not in (1..999).");
                    }
                } else if (tagNo == 1) {
                    ASN1Integer instance2 = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    this.c = instance2;
                    if (instance2.getValue().intValue() < 1 || this.c.getValue().intValue() > 999) {
                        throw new IllegalArgumentException("Invalid micros field : not in (1..999).");
                    }
                } else {
                    throw new IllegalArgumentException("Invalig tag number");
                }
            }
        }
    }
}
