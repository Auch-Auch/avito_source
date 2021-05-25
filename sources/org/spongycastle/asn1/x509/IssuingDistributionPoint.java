package org.spongycastle.asn1.x509;

import com.facebook.internal.ServerProtocol;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;
public class IssuingDistributionPoint extends ASN1Object {
    public DistributionPointName a;
    public boolean b;
    public boolean c;
    public ReasonFlags d;
    public boolean e;
    public boolean f;
    public ASN1Sequence g;

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2, ReasonFlags reasonFlags, boolean z3, boolean z4) {
        this.a = distributionPointName;
        this.e = z3;
        this.f = z4;
        this.c = z2;
        this.b = z;
        this.d = reasonFlags;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (distributionPointName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, distributionPointName));
        }
        if (z) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(true)));
        }
        if (z2) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, ASN1Boolean.getInstance(true)));
        }
        if (reasonFlags != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, reasonFlags));
        }
        if (z3) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 4, ASN1Boolean.getInstance(true)));
        }
        if (z4) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 5, ASN1Boolean.getInstance(true)));
        }
        this.g = new DERSequence(aSN1EncodableVector);
    }

    public static IssuingDistributionPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
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

    public final String b(boolean z) {
        return z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    public DistributionPointName getDistributionPoint() {
        return this.a;
    }

    public ReasonFlags getOnlySomeReasons() {
        return this.d;
    }

    public boolean isIndirectCRL() {
        return this.e;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.f;
    }

    public boolean onlyContainsCACerts() {
        return this.c;
    }

    public boolean onlyContainsUserCerts() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.g;
    }

    public String toString() {
        String lineSeparator = Strings.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(lineSeparator);
        DistributionPointName distributionPointName = this.a;
        if (distributionPointName != null) {
            a(stringBuffer, lineSeparator, "distributionPoint", distributionPointName.toString());
        }
        boolean z = this.b;
        if (z) {
            a(stringBuffer, lineSeparator, "onlyContainsUserCerts", b(z));
        }
        boolean z2 = this.c;
        if (z2) {
            a(stringBuffer, lineSeparator, "onlyContainsCACerts", b(z2));
        }
        ReasonFlags reasonFlags = this.d;
        if (reasonFlags != null) {
            a(stringBuffer, lineSeparator, "onlySomeReasons", reasonFlags.toString());
        }
        boolean z3 = this.f;
        if (z3) {
            a(stringBuffer, lineSeparator, "onlyContainsAttributeCerts", b(z3));
        }
        boolean z4 = this.e;
        if (z4) {
            a(stringBuffer, lineSeparator, "indirectCRL", b(z4));
        }
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public static IssuingDistributionPoint getInstance(Object obj) {
        if (obj instanceof IssuingDistributionPoint) {
            return (IssuingDistributionPoint) obj;
        }
        if (obj != null) {
            return new IssuingDistributionPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2) {
        this(distributionPointName, false, false, null, z, z2);
    }

    public IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        this.g = aSN1Sequence;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.a = DistributionPointName.getInstance(instance, true);
            } else if (tagNo == 1) {
                this.b = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 2) {
                this.c = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 3) {
                this.d = new ReasonFlags(DERBitString.getInstance(instance, false));
            } else if (tagNo == 4) {
                this.e = ASN1Boolean.getInstance(instance, false).isTrue();
            } else if (tagNo == 5) {
                this.f = ASN1Boolean.getInstance(instance, false).isTrue();
            } else {
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }
    }
}
