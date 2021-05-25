package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.DigestInfo;
public class Data extends ASN1Object implements ASN1Choice {
    public ASN1OctetString a;
    public DigestInfo b;
    public ASN1Sequence c;

    public Data(byte[] bArr) {
        this.a = new DEROctetString(bArr);
    }

    public static Data getInstance(Object obj) {
        if (obj instanceof Data) {
            return (Data) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new Data((ASN1OctetString) obj);
        }
        if (obj instanceof ASN1Sequence) {
            return new Data(DigestInfo.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Data(ASN1Sequence.getInstance((ASN1TaggedObject) obj, false));
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Unknown object submitted to getInstance: ")));
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence aSN1Sequence = this.c;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        TargetEtcChain[] targetEtcChainArr = new TargetEtcChain[size];
        for (int i = 0; i != size; i++) {
            targetEtcChainArr[i] = TargetEtcChain.getInstance(this.c.getObjectAt(i));
        }
        return targetEtcChainArr;
    }

    public ASN1OctetString getMessage() {
        return this.a;
    }

    public DigestInfo getMessageImprint() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1OctetString aSN1OctetString = this.a;
        if (aSN1OctetString != null) {
            return aSN1OctetString.toASN1Primitive();
        }
        DigestInfo digestInfo = this.b;
        if (digestInfo != null) {
            return digestInfo.toASN1Primitive();
        }
        return new DERTaggedObject(false, 0, this.c);
    }

    public String toString() {
        if (this.a != null) {
            StringBuilder L = a.L("Data {\n");
            L.append(this.a);
            L.append("}\n");
            return L.toString();
        } else if (this.b != null) {
            StringBuilder L2 = a.L("Data {\n");
            L2.append(this.b);
            L2.append("}\n");
            return L2.toString();
        } else {
            StringBuilder L3 = a.L("Data {\n");
            L3.append(this.c);
            L3.append("}\n");
            return L3.toString();
        }
    }

    public Data(ASN1OctetString aSN1OctetString) {
        this.a = aSN1OctetString;
    }

    public Data(DigestInfo digestInfo) {
        this.b = digestInfo;
    }

    public Data(TargetEtcChain targetEtcChain) {
        this.c = new DERSequence(targetEtcChain);
    }

    public Data(TargetEtcChain[] targetEtcChainArr) {
        this.c = new DERSequence(targetEtcChainArr);
    }

    public static Data getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public Data(ASN1Sequence aSN1Sequence) {
        this.c = aSN1Sequence;
    }
}
