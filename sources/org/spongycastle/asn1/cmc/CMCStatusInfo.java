package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
public class CMCStatusInfo extends ASN1Object {
    public final CMCStatus a;
    public final ASN1Sequence b;
    public final DERUTF8String c;
    public final OtherInfo d;

    public CMCStatusInfo(CMCStatus cMCStatus, ASN1Sequence aSN1Sequence, DERUTF8String dERUTF8String, OtherInfo otherInfo) {
        this.a = cMCStatus;
        this.b = aSN1Sequence;
        this.c = dERUTF8String;
        this.d = otherInfo;
    }

    public static CMCStatusInfo getInstance(Object obj) {
        if (obj instanceof CMCStatusInfo) {
            return (CMCStatusInfo) obj;
        }
        if (obj != null) {
            return new CMCStatusInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID[] getBodyList() {
        return AppCompatDelegateImpl.i.Y1(this.b);
    }

    public CMCStatus getCMCStatus() {
        return this.a;
    }

    public OtherInfo getOtherInfo() {
        return this.d;
    }

    public DERUTF8String getStatusString() {
        return this.c;
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
        OtherInfo otherInfo = this.d;
        if (otherInfo != null) {
            aSN1EncodableVector.add(otherInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static class OtherInfo extends ASN1Object implements ASN1Choice {
        public final CMCFailInfo a;
        public final PendInfo b;

        public OtherInfo(CMCFailInfo cMCFailInfo) {
            this.a = cMCFailInfo;
            this.b = null;
        }

        public static OtherInfo a(Object obj) {
            if (obj instanceof OtherInfo) {
                return (OtherInfo) obj;
            }
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Integer) {
                    return new OtherInfo(CMCFailInfo.getInstance(aSN1Primitive));
                }
                if (aSN1Primitive instanceof ASN1Sequence) {
                    return new OtherInfo(PendInfo.getInstance(aSN1Primitive));
                }
            }
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
        }

        public boolean isFailInfo() {
            return this.a != null;
        }

        @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            PendInfo pendInfo = this.b;
            if (pendInfo != null) {
                return pendInfo.toASN1Primitive();
            }
            return this.a.toASN1Primitive();
        }

        public OtherInfo(PendInfo pendInfo) {
            this.a = null;
            this.b = pendInfo;
        }
    }

    public CMCStatusInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 2 || aSN1Sequence.size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.a = CMCStatus.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 3) {
            this.c = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = OtherInfo.a(aSN1Sequence.getObjectAt(3));
        } else if (aSN1Sequence.size() <= 2) {
            this.c = null;
            this.d = null;
        } else if (aSN1Sequence.getObjectAt(2) instanceof DERUTF8String) {
            this.c = DERUTF8String.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = null;
        } else {
            this.c = null;
            this.d = OtherInfo.a(aSN1Sequence.getObjectAt(2));
        }
    }
}
