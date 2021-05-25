package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import java.util.Arrays;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.PolicyInformation;
public class PathProcInput extends ASN1Object {
    public PolicyInformation[] a;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;

    public PathProcInput(PolicyInformation[] policyInformationArr) {
        this.a = policyInformationArr;
    }

    public static PathProcInput getInstance(Object obj) {
        if (obj instanceof PathProcInput) {
            return (PathProcInput) obj;
        }
        if (obj == null) {
            return null;
        }
        ASN1Sequence instance = ASN1Sequence.getInstance(obj);
        ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(0));
        int size = instance2.size();
        PolicyInformation[] policyInformationArr = new PolicyInformation[size];
        for (int i = 0; i != size; i++) {
            policyInformationArr[i] = PolicyInformation.getInstance(instance2.getObjectAt(i));
        }
        PathProcInput pathProcInput = new PathProcInput(policyInformationArr);
        for (int i2 = 1; i2 < instance.size(); i2++) {
            ASN1Encodable objectAt = instance.getObjectAt(i2);
            if (objectAt instanceof ASN1Boolean) {
                pathProcInput.b = ASN1Boolean.getInstance(objectAt).isTrue();
            } else if (!(objectAt instanceof ASN1TaggedObject)) {
                continue;
            } else {
                ASN1TaggedObject instance3 = ASN1TaggedObject.getInstance(objectAt);
                int tagNo = instance3.getTagNo();
                if (tagNo == 0) {
                    pathProcInput.c = ASN1Boolean.getInstance(instance3, false).isTrue();
                } else if (tagNo == 1) {
                    pathProcInput.d = ASN1Boolean.getInstance(instance3, false).isTrue();
                } else {
                    throw new IllegalArgumentException(a.D(instance3, a.L("Unknown tag encountered: ")));
                }
            }
        }
        return pathProcInput;
    }

    public PolicyInformation[] getAcceptablePolicySet() {
        return this.a;
    }

    public boolean isExplicitPolicyReqd() {
        return this.c;
    }

    public boolean isInhibitAnyPolicy() {
        return this.d;
    }

    public boolean isInhibitPolicyMapping() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            PolicyInformation[] policyInformationArr = this.a;
            if (i == policyInformationArr.length) {
                break;
            }
            aSN1EncodableVector2.add(policyInformationArr[i]);
            i++;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        boolean z = this.b;
        if (z) {
            aSN1EncodableVector.add(ASN1Boolean.getInstance(z));
        }
        boolean z2 = this.c;
        if (z2) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, ASN1Boolean.getInstance(z2)));
        }
        boolean z3 = this.d;
        if (z3) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(z3)));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder L = a.L("PathProcInput: {\nacceptablePolicySet: ");
        L.append(Arrays.asList(this.a));
        L.append("\ninhibitPolicyMapping: ");
        L.append(this.b);
        L.append("\nexplicitPolicyReqd: ");
        L.append(this.c);
        L.append("\ninhibitAnyPolicy: ");
        return a.B(L, this.d, "\n}\n");
    }

    public PathProcInput(PolicyInformation[] policyInformationArr, boolean z, boolean z2, boolean z3) {
        this.a = policyInformationArr;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public static PathProcInput getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
