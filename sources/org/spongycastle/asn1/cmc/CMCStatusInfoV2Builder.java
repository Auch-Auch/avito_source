package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
public class CMCStatusInfoV2Builder {
    public final CMCStatus a;
    public final ASN1Sequence b;
    public DERUTF8String c;
    public OtherStatusInfo d;

    public CMCStatusInfoV2Builder(CMCStatus cMCStatus, BodyPartID bodyPartID) {
        this.a = cMCStatus;
        this.b = new DERSequence(bodyPartID);
    }

    public CMCStatusInfoV2 build() {
        return new CMCStatusInfoV2(this.a, this.b, this.c, this.d);
    }

    public CMCStatusInfoV2Builder setOtherInfo(CMCFailInfo cMCFailInfo) {
        this.d = new OtherStatusInfo(cMCFailInfo);
        return this;
    }

    public CMCStatusInfoV2Builder setStatusString(String str) {
        this.c = new DERUTF8String(str);
        return this;
    }

    public CMCStatusInfoV2Builder setOtherInfo(ExtendedFailInfo extendedFailInfo) {
        this.d = new OtherStatusInfo(null, null, extendedFailInfo);
        return this;
    }

    public CMCStatusInfoV2Builder(CMCStatus cMCStatus, BodyPartID[] bodyPartIDArr) {
        this.a = cMCStatus;
        this.b = new DERSequence(bodyPartIDArr);
    }

    public CMCStatusInfoV2Builder setOtherInfo(PendInfo pendInfo) {
        this.d = new OtherStatusInfo(null, pendInfo, null);
        return this;
    }
}
