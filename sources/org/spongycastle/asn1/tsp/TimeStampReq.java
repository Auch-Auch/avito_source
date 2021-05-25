package org.spongycastle.asn1.tsp;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
public class TimeStampReq extends ASN1Object {
    public ASN1Integer a;
    public MessageImprint b;
    public ASN1ObjectIdentifier c;
    public ASN1Integer d;
    public ASN1Boolean e;
    public Extensions f;

    public TimeStampReq(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = MessageImprint.getInstance(aSN1Sequence.getObjectAt(1));
        for (int i = 2; i < size; i++) {
            if (aSN1Sequence.getObjectAt(i) instanceof ASN1ObjectIdentifier) {
                this.c = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Integer) {
                this.d = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Boolean) {
                this.e = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(i));
            } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
                if (aSN1TaggedObject.getTagNo() == 0) {
                    this.f = Extensions.getInstance(aSN1TaggedObject, false);
                }
            }
        }
    }

    public static TimeStampReq getInstance(Object obj) {
        if (obj instanceof TimeStampReq) {
            return (TimeStampReq) obj;
        }
        if (obj != null) {
            return new TimeStampReq(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Boolean getCertReq() {
        return this.e;
    }

    public Extensions getExtensions() {
        return this.f;
    }

    public MessageImprint getMessageImprint() {
        return this.b;
    }

    public ASN1Integer getNonce() {
        return this.d;
    }

    public ASN1ObjectIdentifier getReqPolicy() {
        return this.c;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.c;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        ASN1Integer aSN1Integer = this.d;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        ASN1Boolean aSN1Boolean = this.e;
        if (aSN1Boolean != null && aSN1Boolean.isTrue()) {
            aSN1EncodableVector.add(this.e);
        }
        Extensions extensions = this.f;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TimeStampReq(MessageImprint messageImprint, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Integer aSN1Integer, ASN1Boolean aSN1Boolean, Extensions extensions) {
        this.a = new ASN1Integer(1);
        this.b = messageImprint;
        this.c = aSN1ObjectIdentifier;
        this.d = aSN1Integer;
        this.e = aSN1Boolean;
        this.f = extensions;
    }
}
