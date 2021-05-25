package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class UserNotice extends ASN1Object {
    public final NoticeReference a;
    public final DisplayText b;

    public UserNotice(NoticeReference noticeReference, DisplayText displayText) {
        this.a = noticeReference;
        this.b = displayText;
    }

    public static UserNotice getInstance(Object obj) {
        if (obj instanceof UserNotice) {
            return (UserNotice) obj;
        }
        if (obj != null) {
            return new UserNotice(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DisplayText getExplicitText() {
        return this.b;
    }

    public NoticeReference getNoticeRef() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        NoticeReference noticeReference = this.a;
        if (noticeReference != null) {
            aSN1EncodableVector.add(noticeReference);
        }
        DisplayText displayText = this.b;
        if (displayText != null) {
            aSN1EncodableVector.add(displayText);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public UserNotice(NoticeReference noticeReference, String str) {
        this(noticeReference, new DisplayText(str));
    }

    public UserNotice(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = NoticeReference.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = DisplayText.getInstance(aSN1Sequence.getObjectAt(1));
        } else if (aSN1Sequence.size() == 1) {
            if (aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence) {
                this.a = NoticeReference.getInstance(aSN1Sequence.getObjectAt(0));
                this.b = null;
                return;
            }
            this.a = null;
            this.b = DisplayText.getInstance(aSN1Sequence.getObjectAt(0));
        } else if (aSN1Sequence.size() == 0) {
            this.a = null;
            this.b = null;
        } else {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
    }
}
