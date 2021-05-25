package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;
public class DistributionPoint extends ASN1Object {
    public DistributionPointName a;
    public ReasonFlags b;
    public GeneralNames c;

    public DistributionPoint(ASN1Sequence aSN1Sequence) {
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.a = DistributionPointName.getInstance(instance, true);
            } else if (tagNo == 1) {
                this.b = new ReasonFlags(DERBitString.getInstance(instance, false));
            } else if (tagNo == 2) {
                this.c = GeneralNames.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("Unknown tag encountered in structure: ")));
            }
        }
    }

    public static DistributionPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public final void a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    public GeneralNames getCRLIssuer() {
        return this.c;
    }

    public DistributionPointName getDistributionPoint() {
        return this.a;
    }

    public ReasonFlags getReasons() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DistributionPointName distributionPointName = this.a;
        if (distributionPointName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, distributionPointName));
        }
        ReasonFlags reasonFlags = this.b;
        if (reasonFlags != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, reasonFlags));
        }
        GeneralNames generalNames = this.c;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, generalNames));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String lineSeparator = Strings.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPoint: [");
        stringBuffer.append(lineSeparator);
        DistributionPointName distributionPointName = this.a;
        if (distributionPointName != null) {
            a(stringBuffer, lineSeparator, "distributionPoint", distributionPointName.toString());
        }
        ReasonFlags reasonFlags = this.b;
        if (reasonFlags != null) {
            a(stringBuffer, lineSeparator, "reasons", reasonFlags.toString());
        }
        GeneralNames generalNames = this.c;
        if (generalNames != null) {
            a(stringBuffer, lineSeparator, "cRLIssuer", generalNames.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public static DistributionPoint getInstance(Object obj) {
        if (obj == null || (obj instanceof DistributionPoint)) {
            return (DistributionPoint) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DistributionPoint((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid DistributionPoint: ")));
    }

    public DistributionPoint(DistributionPointName distributionPointName, ReasonFlags reasonFlags, GeneralNames generalNames) {
        this.a = distributionPointName;
        this.b = reasonFlags;
        this.c = generalNames;
    }
}
