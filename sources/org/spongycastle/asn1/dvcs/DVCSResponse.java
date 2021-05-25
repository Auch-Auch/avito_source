package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
public class DVCSResponse extends ASN1Object implements ASN1Choice {
    public DVCSCertInfo a;
    public DVCSErrorNotice b;

    public DVCSResponse(DVCSCertInfo dVCSCertInfo) {
        this.a = dVCSCertInfo;
    }

    public static DVCSResponse getInstance(Object obj) {
        if (obj == null || (obj instanceof DVCSResponse)) {
            return (DVCSResponse) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a.A2(e, a.L("failed to construct sequence from byte[]: ")));
            }
        } else if (obj instanceof ASN1Sequence) {
            return new DVCSResponse(DVCSCertInfo.getInstance(obj));
        } else {
            if (obj instanceof ASN1TaggedObject) {
                return new DVCSResponse(DVCSErrorNotice.getInstance(ASN1TaggedObject.getInstance(obj), false));
            }
            throw new IllegalArgumentException(a.H2(obj, a.L("Couldn't convert from object to DVCSResponse: ")));
        }
    }

    public DVCSCertInfo getCertInfo() {
        return this.a;
    }

    public DVCSErrorNotice getErrorNotice() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        DVCSCertInfo dVCSCertInfo = this.a;
        if (dVCSCertInfo != null) {
            return dVCSCertInfo.toASN1Primitive();
        }
        return new DERTaggedObject(false, 0, this.b);
    }

    public String toString() {
        if (this.a != null) {
            StringBuilder L = a.L("DVCSResponse {\ndvCertInfo: ");
            L.append(this.a.toString());
            L.append("}\n");
            return L.toString();
        }
        StringBuilder L2 = a.L("DVCSResponse {\ndvErrorNote: ");
        L2.append(this.b.toString());
        L2.append("}\n");
        return L2.toString();
    }

    public DVCSResponse(DVCSErrorNotice dVCSErrorNotice) {
        this.b = dVCSErrorNotice;
    }

    public static DVCSResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
