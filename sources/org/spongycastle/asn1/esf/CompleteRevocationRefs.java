package org.spongycastle.asn1.esf;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CompleteRevocationRefs extends ASN1Object {
    public ASN1Sequence a;

    public CompleteRevocationRefs(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            CrlOcspRef.getInstance(objects.nextElement());
        }
        this.a = aSN1Sequence;
    }

    public static CompleteRevocationRefs getInstance(Object obj) {
        if (obj instanceof CompleteRevocationRefs) {
            return (CompleteRevocationRefs) obj;
        }
        if (obj != null) {
            return new CompleteRevocationRefs(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CrlOcspRef[] getCrlOcspRefs() {
        int size = this.a.size();
        CrlOcspRef[] crlOcspRefArr = new CrlOcspRef[size];
        for (int i = 0; i < size; i++) {
            crlOcspRefArr[i] = CrlOcspRef.getInstance(this.a.getObjectAt(i));
        }
        return crlOcspRefArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public CompleteRevocationRefs(CrlOcspRef[] crlOcspRefArr) {
        this.a = new DERSequence(crlOcspRefArr);
    }
}
