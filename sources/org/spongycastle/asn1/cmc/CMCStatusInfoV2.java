package org.spongycastle.asn1.cmc;

import androidx.appcompat.app.AppCompatDelegateImpl;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
public class CMCStatusInfoV2 extends ASN1Object {
    public final CMCStatus a;
    public final ASN1Sequence b;
    public final DERUTF8String c;
    public final OtherStatusInfo d;

    public CMCStatusInfoV2(CMCStatus cMCStatus, ASN1Sequence aSN1Sequence, DERUTF8String dERUTF8String, OtherStatusInfo otherStatusInfo) {
        this.a = cMCStatus;
        this.b = aSN1Sequence;
        this.c = dERUTF8String;
        this.d = otherStatusInfo;
    }

    public static CMCStatusInfoV2 getInstance(Object obj) {
        if (obj instanceof CMCStatusInfoV2) {
            return (CMCStatusInfoV2) obj;
        }
        if (obj != null) {
            return new CMCStatusInfoV2(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID[] getBodyList() {
        return AppCompatDelegateImpl.i.Y1(this.b);
    }

    public OtherStatusInfo getOtherStatusInfo() {
        return this.d;
    }

    public DERUTF8String getStatusString() {
        return this.c;
    }

    public CMCStatus getcMCStatus() {
        return this.a;
    }

    public boolean hasOtherInfo() {
        return this.d != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        DERUTF8String dERUTF8String = this.c;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        OtherStatusInfo otherStatusInfo = this.d;
        if (otherStatusInfo != null) {
            aSN1EncodableVector.add(otherStatusInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CMCStatusInfoV2(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.a = CMCStatus.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() <= 2) {
            this.c = null;
            this.d = null;
        } else if (aSN1Sequence.size() == 4) {
            this.c = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = OtherStatusInfo.getInstance(aSN1Sequence.getObjectAt(3));
        } else if (aSN1Sequence.getObjectAt(2) instanceof DERUTF8String) {
            this.c = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = null;
        } else {
            this.c = null;
            this.d = OtherStatusInfo.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }
}
