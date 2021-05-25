package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
public class MetaData extends ASN1Object {
    public ASN1Boolean a;
    public DERUTF8String b;
    public DERIA5String c;
    public Attributes d;

    public MetaData(ASN1Boolean aSN1Boolean, DERUTF8String dERUTF8String, DERIA5String dERIA5String, Attributes attributes) {
        this.a = aSN1Boolean;
        this.b = dERUTF8String;
        this.c = dERIA5String;
        this.d = attributes;
    }

    public static MetaData getInstance(Object obj) {
        if (obj instanceof MetaData) {
            return (MetaData) obj;
        }
        if (obj != null) {
            return new MetaData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTF8String getFileName() {
        return this.b;
    }

    public DERIA5String getMediaType() {
        return this.c;
    }

    public Attributes getOtherMetaData() {
        return this.d;
    }

    public boolean isHashProtected() {
        return this.a.isTrue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        DERUTF8String dERUTF8String = this.b;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        DERIA5String dERIA5String = this.c;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(dERIA5String);
        }
        Attributes attributes = this.d;
        if (attributes != null) {
            aSN1EncodableVector.add(attributes);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public MetaData(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(0));
        int i = 1;
        if (1 < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(1) instanceof DERUTF8String)) {
            this.b = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(1));
            i = 2;
        }
        if (i < aSN1Sequence.size() && (aSN1Sequence.getObjectAt(i) instanceof DERIA5String)) {
            this.c = DERIA5String.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (i < aSN1Sequence.size()) {
            this.d = Attributes.getInstance(aSN1Sequence.getObjectAt(i));
        }
    }
}
