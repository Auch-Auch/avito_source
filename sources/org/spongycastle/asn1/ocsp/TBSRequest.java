package org.spongycastle.asn1.ocsp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.X509Extensions;
public class TBSRequest extends ASN1Object {
    public static final ASN1Integer f = new ASN1Integer(0);
    public ASN1Integer a;
    public GeneralName b;
    public ASN1Sequence c;
    public Extensions d;
    public boolean e;

    public TBSRequest(GeneralName generalName, ASN1Sequence aSN1Sequence, X509Extensions x509Extensions) {
        this.a = f;
        this.b = generalName;
        this.c = aSN1Sequence;
        this.d = Extensions.getInstance(x509Extensions);
    }

    public static TBSRequest getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Extensions getRequestExtensions() {
        return this.d;
    }

    public ASN1Sequence getRequestList() {
        return this.c;
    }

    public GeneralName getRequestorName() {
        return this.b;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.a.equals(f) || this.e) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.a));
        }
        GeneralName generalName = this.b;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, generalName));
        }
        aSN1EncodableVector.add(this.c);
        Extensions extensions = this.d;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static TBSRequest getInstance(Object obj) {
        if (obj instanceof TBSRequest) {
            return (TBSRequest) obj;
        }
        if (obj != null) {
            return new TBSRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TBSRequest(GeneralName generalName, ASN1Sequence aSN1Sequence, Extensions extensions) {
        this.a = f;
        this.b = generalName;
        this.c = aSN1Sequence;
        this.d = extensions;
    }

    public TBSRequest(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) {
            this.a = f;
        } else if (((ASN1TaggedObject) aSN1Sequence.getObjectAt(0)).getTagNo() == 0) {
            this.e = true;
            this.a = ASN1Integer.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i = 1;
        } else {
            this.a = f;
        }
        if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
            this.b = GeneralName.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i), true);
            i++;
        }
        int i2 = i + 1;
        this.c = (ASN1Sequence) aSN1Sequence.getObjectAt(i);
        if (aSN1Sequence.size() == i2 + 1) {
            this.d = Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2), true);
        }
    }
}
