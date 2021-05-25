package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.PolicyInformation;
public class DVCSCertInfo extends ASN1Object {
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

    public DVCSCertInfo(DVCSRequestInformation dVCSRequestInformation, DigestInfo digestInfo, ASN1Integer aSN1Integer, DVCSTime dVCSTime) {
        this.b = dVCSRequestInformation;
        this.c = digestInfo;
        this.d = aSN1Integer;
        this.e = dVCSTime;
    }

    public static DVCSCertInfo getInstance(Object obj) {
        if (obj instanceof DVCSCertInfo) {
            return (DVCSCertInfo) obj;
        }
        if (obj != null) {
            return new DVCSCertInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence aSN1Sequence = this.i;
        if (aSN1Sequence != null) {
            return TargetEtcChain.arrayFromSequence(aSN1Sequence);
        }
        return null;
    }

    public DVCSRequestInformation getDvReqInfo() {
        return this.b;
    }

    public PKIStatusInfo getDvStatus() {
        return this.f;
    }

    public Extensions getExtensions() {
        return this.j;
    }

    public DigestInfo getMessageImprint() {
        return this.c;
    }

    public PolicyInformation getPolicy() {
        return this.g;
    }

    public ASN1Set getReqSignature() {
        return this.h;
    }

    public DVCSTime getResponseTime() {
        return this.e;
    }

    public ASN1Integer getSerialNumber() {
        return this.d;
    }

    public int getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
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
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSCertInfo {\n");
        if (this.a != 1) {
            StringBuilder L = a.L("version: ");
            L.append(this.a);
            L.append("\n");
            stringBuffer.append(L.toString());
        }
        StringBuilder L2 = a.L("dvReqInfo: ");
        L2.append(this.b);
        L2.append("\n");
        stringBuffer.append(L2.toString());
        stringBuffer.append("messageImprint: " + this.c + "\n");
        stringBuffer.append("serialNumber: " + this.d + "\n");
        stringBuffer.append("responseTime: " + this.e + "\n");
        if (this.f != null) {
            StringBuilder L3 = a.L("dvStatus: ");
            L3.append(this.f);
            L3.append("\n");
            stringBuffer.append(L3.toString());
        }
        if (this.g != null) {
            StringBuilder L4 = a.L("policy: ");
            L4.append(this.g);
            L4.append("\n");
            stringBuffer.append(L4.toString());
        }
        if (this.h != null) {
            StringBuilder L5 = a.L("reqSignature: ");
            L5.append(this.h);
            L5.append("\n");
            stringBuffer.append(L5.toString());
        }
        if (this.i != null) {
            StringBuilder L6 = a.L("certs: ");
            L6.append(this.i);
            L6.append("\n");
            stringBuffer.append(L6.toString());
        }
        if (this.j != null) {
            StringBuilder L7 = a.L("extensions: ");
            L7.append(this.j);
            L7.append("\n");
            stringBuffer.append(L7.toString());
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public static DVCSCertInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DVCSCertInfo(ASN1Sequence aSN1Sequence) {
        int i2;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        try {
            this.a = ASN1Integer.getInstance(objectAt).getValue().intValue();
            try {
                objectAt = aSN1Sequence.getObjectAt(1);
            } catch (IllegalArgumentException unused) {
            }
            i2 = 2;
        } catch (IllegalArgumentException unused2) {
            i2 = 1;
        }
        this.b = DVCSRequestInformation.getInstance(objectAt);
        int i3 = i2 + 1;
        this.c = DigestInfo.getInstance(aSN1Sequence.getObjectAt(i2));
        int i4 = i3 + 1;
        this.d = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i3));
        int i5 = i4 + 1;
        this.e = DVCSTime.getInstance(aSN1Sequence.getObjectAt(i4));
        while (i5 < aSN1Sequence.size()) {
            int i6 = i5 + 1;
            ASN1Encodable objectAt2 = aSN1Sequence.getObjectAt(i5);
            if (objectAt2 instanceof ASN1TaggedObject) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objectAt2);
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.f = PKIStatusInfo.getInstance(instance, false);
                } else if (tagNo == 1) {
                    this.g = PolicyInformation.getInstance(ASN1Sequence.getInstance(instance, false));
                } else if (tagNo == 2) {
                    this.h = ASN1Set.getInstance(instance, false);
                } else if (tagNo == 3) {
                    this.i = ASN1Sequence.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException(a.M2("Unknown tag encountered: ", tagNo));
                }
            } else {
                try {
                    this.j = Extensions.getInstance(objectAt2);
                } catch (IllegalArgumentException unused3) {
                }
            }
            i5 = i6;
        }
    }
}
