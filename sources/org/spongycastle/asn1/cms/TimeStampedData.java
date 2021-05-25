package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DERIA5String;
public class TimeStampedData extends ASN1Object {
    public ASN1Integer a;
    public DERIA5String b;
    public MetaData c;
    public ASN1OctetString d;
    public Evidence e;

    public TimeStampedData(DERIA5String dERIA5String, MetaData metaData, ASN1OctetString aSN1OctetString, Evidence evidence) {
        this.a = new ASN1Integer(1);
        this.b = dERIA5String;
        this.c = metaData;
        this.d = aSN1OctetString;
        this.e = evidence;
    }

    public static TimeStampedData getInstance(Object obj) {
        if (obj == null || (obj instanceof TimeStampedData)) {
            return (TimeStampedData) obj;
        }
        return new TimeStampedData(ASN1Sequence.getInstance(obj));
    }

    public ASN1OctetString getContent() {
        return this.d;
    }

    public DERIA5String getDataUri() {
        return this.b;
    }

    public MetaData getMetaData() {
        return this.c;
    }

    public Evidence getTemporalEvidence() {
        return this.e;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        DERIA5String dERIA5String = this.b;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        MetaData metaData = this.c;
        if (metaData != null) {
            aSN1EncodableVector.add(metaData);
        }
        ASN1OctetString aSN1OctetString = this.d;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        aSN1EncodableVector.add(this.e);
        return new BERSequence(aSN1EncodableVector);
    }

    public TimeStampedData(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        int i = 1;
        if (aSN1Sequence.getObjectAt(1) instanceof DERIA5String) {
            this.b = DERIA5String.getInstance(aSN1Sequence.getObjectAt(1));
            i = 2;
        }
        if ((aSN1Sequence.getObjectAt(i) instanceof MetaData) || (aSN1Sequence.getObjectAt(i) instanceof ASN1Sequence)) {
            this.c = MetaData.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (aSN1Sequence.getObjectAt(i) instanceof ASN1OctetString) {
            this.d = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        this.e = Evidence.getInstance(aSN1Sequence.getObjectAt(i));
    }
}
