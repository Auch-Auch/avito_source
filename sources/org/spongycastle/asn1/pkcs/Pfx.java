package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;
public class Pfx extends ASN1Object implements PKCSObjectIdentifiers {
    public ContentInfo a;
    public MacData b = null;

    public Pfx(ASN1Sequence aSN1Sequence) {
        if (((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().intValue() == 3) {
            this.a = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
            if (aSN1Sequence.size() == 3) {
                this.b = MacData.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for PFX PDU");
    }

    public static Pfx getInstance(Object obj) {
        if (obj instanceof Pfx) {
            return (Pfx) obj;
        }
        if (obj != null) {
            return new Pfx(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContentInfo getAuthSafe() {
        return this.a;
    }

    public MacData getMacData() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(3));
        aSN1EncodableVector.add(this.a);
        MacData macData = this.b;
        if (macData != null) {
            aSN1EncodableVector.add(macData);
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public Pfx(ContentInfo contentInfo, MacData macData) {
        this.a = contentInfo;
        this.b = macData;
    }
}
