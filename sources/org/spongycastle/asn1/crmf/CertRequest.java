package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CertRequest extends ASN1Object {
    public ASN1Integer a;
    public CertTemplate b;
    public Controls c;

    public CertRequest(ASN1Sequence aSN1Sequence) {
        this.a = new ASN1Integer(ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue());
        this.b = CertTemplate.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.c = Controls.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static CertRequest getInstance(Object obj) {
        if (obj instanceof CertRequest) {
            return (CertRequest) obj;
        }
        if (obj != null) {
            return new CertRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertReqId() {
        return this.a;
    }

    public CertTemplate getCertTemplate() {
        return this.b;
    }

    public Controls getControls() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        Controls controls = this.c;
        if (controls != null) {
            aSN1EncodableVector.add(controls);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertRequest(int i, CertTemplate certTemplate, Controls controls) {
        this(new ASN1Integer((long) i), certTemplate, controls);
    }

    public CertRequest(ASN1Integer aSN1Integer, CertTemplate certTemplate, Controls controls) {
        this.a = aSN1Integer;
        this.b = certTemplate;
        this.c = controls;
    }
}
