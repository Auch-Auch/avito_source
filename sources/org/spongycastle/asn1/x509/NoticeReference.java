package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class NoticeReference extends ASN1Object {
    public DisplayText a;
    public ASN1Sequence b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NoticeReference(java.lang.String r6, java.util.Vector r7) {
        /*
            r5 = this;
            org.spongycastle.asn1.ASN1EncodableVector r0 = new org.spongycastle.asn1.ASN1EncodableVector
            r0.<init>()
            java.util.Enumeration r7 = r7.elements()
        L_0x0009:
            boolean r1 = r7.hasMoreElements()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r7.nextElement()
            boolean r2 = r1 instanceof java.math.BigInteger
            if (r2 == 0) goto L_0x001f
            org.spongycastle.asn1.ASN1Integer r2 = new org.spongycastle.asn1.ASN1Integer
            java.math.BigInteger r1 = (java.math.BigInteger) r1
            r2.<init>(r1)
            goto L_0x002f
        L_0x001f:
            boolean r2 = r1 instanceof java.lang.Integer
            if (r2 == 0) goto L_0x0033
            org.spongycastle.asn1.ASN1Integer r2 = new org.spongycastle.asn1.ASN1Integer
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            long r3 = (long) r1
            r2.<init>(r3)
        L_0x002f:
            r0.add(r2)
            goto L_0x0009
        L_0x0033:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>()
            throw r6
        L_0x0039:
            r5.<init>(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.NoticeReference.<init>(java.lang.String, java.util.Vector):void");
    }

    public static NoticeReference getInstance(Object obj) {
        if (obj instanceof NoticeReference) {
            return (NoticeReference) obj;
        }
        if (obj != null) {
            return new NoticeReference(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer[] getNoticeNumbers() {
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[this.b.size()];
        for (int i = 0; i != this.b.size(); i++) {
            aSN1IntegerArr[i] = ASN1Integer.getInstance(this.b.getObjectAt(i));
        }
        return aSN1IntegerArr;
    }

    public DisplayText getOrganization() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public NoticeReference(String str, ASN1EncodableVector aSN1EncodableVector) {
        this(new DisplayText(str), aSN1EncodableVector);
    }

    public NoticeReference(DisplayText displayText, ASN1EncodableVector aSN1EncodableVector) {
        this.a = displayText;
        this.b = new DERSequence(aSN1EncodableVector);
    }

    public NoticeReference(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = DisplayText.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }
}
