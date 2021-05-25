package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class TargetInformation extends ASN1Object {
    public ASN1Sequence a;

    public TargetInformation(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static TargetInformation getInstance(Object obj) {
        if (obj instanceof TargetInformation) {
            return (TargetInformation) obj;
        }
        if (obj != null) {
            return new TargetInformation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Targets[] getTargetsObjects() {
        Targets[] targetsArr = new Targets[this.a.size()];
        Enumeration objects = this.a.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            targetsArr[i] = Targets.getInstance(objects.nextElement());
            i++;
        }
        return targetsArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public TargetInformation(Targets targets) {
        this.a = new DERSequence(targets);
    }

    public TargetInformation(Target[] targetArr) {
        this(new Targets(targetArr));
    }
}
