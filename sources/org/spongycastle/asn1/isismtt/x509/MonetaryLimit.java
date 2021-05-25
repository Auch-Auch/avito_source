package org.spongycastle.asn1.isismtt.x509;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
public class MonetaryLimit extends ASN1Object {
    public DERPrintableString a;
    public ASN1Integer b;
    public ASN1Integer c;

    public MonetaryLimit(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.a = DERPrintableString.getInstance(objects.nextElement());
            this.b = ASN1Integer.getInstance(objects.nextElement());
            this.c = ASN1Integer.getInstance(objects.nextElement());
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static MonetaryLimit getInstance(Object obj) {
        if (obj == null || (obj instanceof MonetaryLimit)) {
            return (MonetaryLimit) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new MonetaryLimit(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public BigInteger getAmount() {
        return this.b.getValue();
    }

    public String getCurrency() {
        return this.a.getString();
    }

    public BigInteger getExponent() {
        return this.c.getValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public MonetaryLimit(String str, int i, int i2) {
        this.a = new DERPrintableString(str, true);
        this.b = new ASN1Integer((long) i);
        this.c = new ASN1Integer((long) i2);
    }
}
