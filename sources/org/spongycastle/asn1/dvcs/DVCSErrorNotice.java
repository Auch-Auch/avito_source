package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.x509.GeneralName;
public class DVCSErrorNotice extends ASN1Object {
    public PKIStatusInfo a;
    public GeneralName b;

    public DVCSErrorNotice(PKIStatusInfo pKIStatusInfo) {
        this(pKIStatusInfo, null);
    }

    public static DVCSErrorNotice getInstance(Object obj) {
        if (obj instanceof DVCSErrorNotice) {
            return (DVCSErrorNotice) obj;
        }
        if (obj != null) {
            return new DVCSErrorNotice(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getTransactionIdentifier() {
        return this.b;
    }

    public PKIStatusInfo getTransactionStatus() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        GeneralName generalName = this.b;
        if (generalName != null) {
            aSN1EncodableVector.add(generalName);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String str;
        StringBuilder L = a.L("DVCSErrorNotice {\ntransactionStatus: ");
        L.append(this.a);
        L.append("\n");
        if (this.b != null) {
            StringBuilder L2 = a.L("transactionIdentifier: ");
            L2.append(this.b);
            L2.append("\n");
            str = L2.toString();
        } else {
            str = "";
        }
        return a.t(L, str, "}\n");
    }

    public DVCSErrorNotice(PKIStatusInfo pKIStatusInfo, GeneralName generalName) {
        this.a = pKIStatusInfo;
        this.b = generalName;
    }

    public static DVCSErrorNotice getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DVCSErrorNotice(ASN1Sequence aSN1Sequence) {
        this.a = PKIStatusInfo.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.b = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }
}
