package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.cmc.CMCStatusInfo;
public class CMCStatusInfoBuilder {
    public final CMCStatus a;
    public final ASN1Sequence b;
    public DERUTF8String c;
    public CMCStatusInfo.OtherInfo d;

    public CMCStatusInfoBuilder(CMCStatus cMCStatus, BodyPartID bodyPartID) {
        this.a = cMCStatus;
        this.b = new DERSequence(bodyPartID);
    }

    public CMCStatusInfo build() {
        return new CMCStatusInfo(this.a, this.b, this.c, this.d);
    }

    public CMCStatusInfoBuilder setOtherInfo(CMCFailInfo cMCFailInfo) {
        this.d = new CMCStatusInfo.OtherInfo(cMCFailInfo);
        return this;
    }

    public CMCStatusInfoBuilder setStatusString(String str) {
        this.c = new DERUTF8String(str);
        return this;
    }

    public CMCStatusInfoBuilder setOtherInfo(PendInfo pendInfo) {
        this.d = new CMCStatusInfo.OtherInfo(pendInfo);
        return this;
    }

    public CMCStatusInfoBuilder(CMCStatus cMCStatus, BodyPartID[] bodyPartIDArr) {
        this.a = cMCStatus;
        this.b = new DERSequence(bodyPartIDArr);
    }
}
