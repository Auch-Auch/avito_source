package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class TargetEtcChain extends ASN1Object {
    public CertEtcToken a;
    public ASN1Sequence b;
    public PathProcInput c;

    public TargetEtcChain(CertEtcToken certEtcToken) {
        this(certEtcToken, null, null);
    }

    public static TargetEtcChain[] arrayFromSequence(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        TargetEtcChain[] targetEtcChainArr = new TargetEtcChain[size];
        for (int i = 0; i != size; i++) {
            targetEtcChainArr[i] = getInstance(aSN1Sequence.getObjectAt(i));
        }
        return targetEtcChainArr;
    }

    public static TargetEtcChain getInstance(Object obj) {
        if (obj instanceof TargetEtcChain) {
            return (TargetEtcChain) obj;
        }
        if (obj != null) {
            return new TargetEtcChain(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public final void a(ASN1Encodable aSN1Encodable) {
        ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Encodable);
        if (instance.getTagNo() == 0) {
            this.c = PathProcInput.getInstance(instance, false);
            return;
        }
        throw new IllegalArgumentException(a.D(instance, a.L("Unknown tag encountered: ")));
    }

    public CertEtcToken[] getChain() {
        ASN1Sequence aSN1Sequence = this.b;
        if (aSN1Sequence != null) {
            return CertEtcToken.arrayFromSequence(aSN1Sequence);
        }
        return null;
    }

    public PathProcInput getPathProcInput() {
        return this.c;
    }

    public CertEtcToken getTarget() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1Sequence aSN1Sequence = this.b;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        PathProcInput pathProcInput = this.c;
        if (pathProcInput != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, pathProcInput));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TargetEtcChain {\n");
        StringBuilder L = a.L("target: ");
        L.append(this.a);
        L.append("\n");
        stringBuffer.append(L.toString());
        if (this.b != null) {
            StringBuilder L2 = a.L("chain: ");
            L2.append(this.b);
            L2.append("\n");
            stringBuffer.append(L2.toString());
        }
        if (this.c != null) {
            StringBuilder L3 = a.L("pathProcInput: ");
            L3.append(this.c);
            L3.append("\n");
            stringBuffer.append(L3.toString());
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public TargetEtcChain(CertEtcToken certEtcToken, CertEtcToken[] certEtcTokenArr) {
        this(certEtcToken, certEtcTokenArr, null);
    }

    public TargetEtcChain(CertEtcToken certEtcToken, PathProcInput pathProcInput) {
        this(certEtcToken, null, pathProcInput);
    }

    public TargetEtcChain(CertEtcToken certEtcToken, CertEtcToken[] certEtcTokenArr, PathProcInput pathProcInput) {
        this.a = certEtcToken;
        if (certEtcTokenArr != null) {
            this.b = new DERSequence(certEtcTokenArr);
        }
        this.c = pathProcInput;
    }

    public static TargetEtcChain getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public TargetEtcChain(ASN1Sequence aSN1Sequence) {
        this.a = CertEtcToken.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
            if (objectAt instanceof ASN1TaggedObject) {
                a(objectAt);
                return;
            }
            this.b = ASN1Sequence.getInstance(objectAt);
            if (aSN1Sequence.size() > 2) {
                a(aSN1Sequence.getObjectAt(2));
            }
        }
    }
}
