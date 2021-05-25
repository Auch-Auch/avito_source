package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.PolicyInformation;
public class DVCSCertInfoBuilder {
    public int a = 1;
    public DVCSRequestInformation b;
    public DigestInfo c;
    public ASN1Integer d;
    public DVCSTime e;
    public PKIStatusInfo f;
    public PolicyInformation g;
    public ASN1Set h;
    public ASN1Sequence i;
    public Extensions j;

    public DVCSCertInfoBuilder(DVCSRequestInformation dVCSRequestInformation, DigestInfo digestInfo, ASN1Integer aSN1Integer, DVCSTime dVCSTime) {
        this.b = dVCSRequestInformation;
        this.c = digestInfo;
        this.d = aSN1Integer;
        this.e = dVCSTime;
    }

    public DVCSCertInfo build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i2 = this.a;
        if (i2 != 1) {
            aSN1EncodableVector.add(new ASN1Integer((long) i2));
        }
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.e);
        PKIStatusInfo pKIStatusInfo = this.f;
        if (pKIStatusInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, pKIStatusInfo));
        }
        PolicyInformation policyInformation = this.g;
        if (policyInformation != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, policyInformation));
        }
        ASN1Set aSN1Set = this.h;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, aSN1Set));
        }
        ASN1Sequence aSN1Sequence = this.i;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, aSN1Sequence));
        }
        Extensions extensions = this.j;
        if (extensions != null) {
            aSN1EncodableVector.add(extensions);
        }
        return DVCSCertInfo.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public void setCerts(TargetEtcChain[] targetEtcChainArr) {
        this.i = new DERSequence(targetEtcChainArr);
    }

    public void setDvReqInfo(DVCSRequestInformation dVCSRequestInformation) {
        this.b = dVCSRequestInformation;
    }

    public void setDvStatus(PKIStatusInfo pKIStatusInfo) {
        this.f = pKIStatusInfo;
    }

    public void setExtensions(Extensions extensions) {
        this.j = extensions;
    }

    public void setMessageImprint(DigestInfo digestInfo) {
        this.c = digestInfo;
    }

    public void setPolicy(PolicyInformation policyInformation) {
        this.g = policyInformation;
    }

    public void setReqSignature(ASN1Set aSN1Set) {
        this.h = aSN1Set;
    }

    public void setResponseTime(DVCSTime dVCSTime) {
        this.e = dVCSTime;
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.d = aSN1Integer;
    }

    public void setVersion(int i2) {
        this.a = i2;
    }
}
