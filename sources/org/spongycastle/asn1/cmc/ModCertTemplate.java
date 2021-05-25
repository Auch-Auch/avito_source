package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.crmf.CertTemplate;
public class ModCertTemplate extends ASN1Object {
    public final BodyPartPath a;
    public final BodyPartList b;
    public final boolean c;
    public final CertTemplate d;

    public ModCertTemplate(BodyPartPath bodyPartPath, BodyPartList bodyPartList, boolean z, CertTemplate certTemplate) {
        this.a = bodyPartPath;
        this.b = bodyPartList;
        this.c = z;
        this.d = certTemplate;
    }

    public static ModCertTemplate getInstance(Object obj) {
        if (obj instanceof ModCertTemplate) {
            return (ModCertTemplate) obj;
        }
        if (obj != null) {
            return new ModCertTemplate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartList getCertReferences() {
        return this.b;
    }

    public CertTemplate getCertTemplate() {
        return this.d;
    }

    public BodyPartPath getPkiDataReference() {
        return this.a;
    }

    public boolean isReplacingFields() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        boolean z = this.c;
        if (!z) {
            aSN1EncodableVector.add(ASN1Boolean.getInstance(z));
        }
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public ModCertTemplate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 4 || aSN1Sequence.size() == 3) {
            this.a = BodyPartPath.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = BodyPartList.getInstance(aSN1Sequence.getObjectAt(1));
            if (aSN1Sequence.size() == 4) {
                this.c = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(2)).isTrue();
                this.d = CertTemplate.getInstance(aSN1Sequence.getObjectAt(3));
                return;
            }
            this.c = true;
            this.d = CertTemplate.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }
}
