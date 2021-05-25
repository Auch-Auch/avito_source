package org.spongycastle.asn1.x509.qualified;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class MonetaryValue extends ASN1Object {
    public Iso4217CurrencyCode a;
    public ASN1Integer b;
    public ASN1Integer c;

    public MonetaryValue(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = Iso4217CurrencyCode.getInstance(objects.nextElement());
        this.b = ASN1Integer.getInstance(objects.nextElement());
        this.c = ASN1Integer.getInstance(objects.nextElement());
    }

    public static MonetaryValue getInstance(Object obj) {
        if (obj instanceof MonetaryValue) {
            return (MonetaryValue) obj;
        }
        if (obj != null) {
            return new MonetaryValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getAmount() {
        return this.b.getValue();
    }

    public Iso4217CurrencyCode getCurrency() {
        return this.a;
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

    public MonetaryValue(Iso4217CurrencyCode iso4217CurrencyCode, int i, int i2) {
        this.a = iso4217CurrencyCode;
        this.b = new ASN1Integer((long) i);
        this.c = new ASN1Integer((long) i2);
    }
}
