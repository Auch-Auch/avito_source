package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.GeneralName;
public class DVCSRequest extends ASN1Object {
    public DVCSRequestInformation a;
    public Data b;
    public GeneralName c;

    public DVCSRequest(DVCSRequestInformation dVCSRequestInformation, Data data) {
        this(dVCSRequestInformation, data, null);
    }

    public static DVCSRequest getInstance(Object obj) {
        if (obj instanceof DVCSRequest) {
            return (DVCSRequest) obj;
        }
        if (obj != null) {
            return new DVCSRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Data getData() {
        return this.b;
    }

    public DVCSRequestInformation getRequestInformation() {
        return this.a;
    }

    public GeneralName getTransactionIdentifier() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        GeneralName generalName = this.c;
        if (generalName != null) {
            aSN1EncodableVector.add(generalName);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String str;
        StringBuilder L = a.L("DVCSRequest {\nrequestInformation: ");
        L.append(this.a);
        L.append("\ndata: ");
        L.append(this.b);
        L.append("\n");
        if (this.c != null) {
            StringBuilder L2 = a.L("transactionIdentifier: ");
            L2.append(this.c);
            L2.append("\n");
            str = L2.toString();
        } else {
            str = "";
        }
        return a.t(L, str, "}\n");
    }

    public DVCSRequest(DVCSRequestInformation dVCSRequestInformation, Data data, GeneralName generalName) {
        this.a = dVCSRequestInformation;
        this.b = data;
        this.c = generalName;
    }

    public static DVCSRequest getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DVCSRequest(ASN1Sequence aSN1Sequence) {
        this.a = DVCSRequestInformation.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = Data.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.c = GeneralName.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }
}
