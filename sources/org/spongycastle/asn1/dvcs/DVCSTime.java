package org.spongycastle.asn1.dvcs;

import java.util.Date;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.cms.ContentInfo;
public class DVCSTime extends ASN1Object implements ASN1Choice {
    public final ASN1GeneralizedTime a;
    public final ContentInfo b;

    public DVCSTime(Date date) {
        this(new ASN1GeneralizedTime(date));
    }

    public static DVCSTime getInstance(Object obj) {
        if (obj instanceof DVCSTime) {
            return (DVCSTime) obj;
        }
        if (obj instanceof ASN1GeneralizedTime) {
            return new DVCSTime(ASN1GeneralizedTime.getInstance(obj));
        }
        if (obj != null) {
            return new DVCSTime(ContentInfo.getInstance(obj));
        }
        return null;
    }

    public ASN1GeneralizedTime getGenTime() {
        return this.a;
    }

    public ContentInfo getTimeStampToken() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1GeneralizedTime aSN1GeneralizedTime = this.a;
        if (aSN1GeneralizedTime != null) {
            return aSN1GeneralizedTime;
        }
        return this.b.toASN1Primitive();
    }

    public String toString() {
        ASN1GeneralizedTime aSN1GeneralizedTime = this.a;
        if (aSN1GeneralizedTime != null) {
            return aSN1GeneralizedTime.toString();
        }
        return this.b.toString();
    }

    public DVCSTime(ASN1GeneralizedTime aSN1GeneralizedTime) {
        this.a = aSN1GeneralizedTime;
        this.b = null;
    }

    public DVCSTime(ContentInfo contentInfo) {
        this.a = null;
        this.b = contentInfo;
    }

    public static DVCSTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }
}
