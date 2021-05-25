package org.spongycastle.asn1.cmp;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class ErrorMsgContent extends ASN1Object {
    public PKIStatusInfo a;
    public ASN1Integer b;
    public PKIFreeText c;

    public ErrorMsgContent(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = PKIStatusInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            Object nextElement = objects.nextElement();
            if (nextElement instanceof ASN1Integer) {
                this.b = ASN1Integer.getInstance(nextElement);
            } else {
                this.c = PKIFreeText.getInstance(nextElement);
            }
        }
    }

    public static ErrorMsgContent getInstance(Object obj) {
        if (obj instanceof ErrorMsgContent) {
            return (ErrorMsgContent) obj;
        }
        if (obj != null) {
            return new ErrorMsgContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getErrorCode() {
        return this.b;
    }

    public PKIFreeText getErrorDetails() {
        return this.c;
    }

    public PKIStatusInfo getPKIStatusInfo() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1Integer aSN1Integer = this.b;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        PKIFreeText pKIFreeText = this.c;
        if (pKIFreeText != null) {
            aSN1EncodableVector.add(pKIFreeText);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ErrorMsgContent(PKIStatusInfo pKIStatusInfo) {
        this(pKIStatusInfo, null, null);
    }

    public ErrorMsgContent(PKIStatusInfo pKIStatusInfo, ASN1Integer aSN1Integer, PKIFreeText pKIFreeText) {
        if (pKIStatusInfo != null) {
            this.a = pKIStatusInfo;
            this.b = aSN1Integer;
            this.c = pKIFreeText;
            return;
        }
        throw new IllegalArgumentException("'pkiStatusInfo' cannot be null");
    }
}
