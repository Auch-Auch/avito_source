package org.spongycastle.asn1.tsp;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
public class TSTInfo extends ASN1Object {
    public ASN1Integer a;
    public ASN1ObjectIdentifier b;
    public MessageImprint c;
    public ASN1Integer d;
    public ASN1GeneralizedTime e;
    public Accuracy f;
    public ASN1Boolean g;
    public ASN1Integer h;
    public GeneralName i;
    public Extensions j;

    public TSTInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1Integer.getInstance(objects.nextElement());
        this.b = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        this.c = MessageImprint.getInstance(objects.nextElement());
        this.d = ASN1Integer.getInstance(objects.nextElement());
        this.e = ASN1GeneralizedTime.getInstance(objects.nextElement());
        this.g = ASN1Boolean.getInstance(false);
        while (objects.hasMoreElements()) {
            ASN1Object aSN1Object = (ASN1Object) objects.nextElement();
            if (aSN1Object instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Object;
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.i = GeneralName.getInstance(aSN1TaggedObject, true);
                } else if (tagNo == 1) {
                    this.j = Extensions.getInstance(aSN1TaggedObject, false);
                } else {
                    throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Unknown tag value ")));
                }
            } else if ((aSN1Object instanceof ASN1Sequence) || (aSN1Object instanceof Accuracy)) {
                this.f = Accuracy.getInstance(aSN1Object);
            } else if (aSN1Object instanceof ASN1Boolean) {
                this.g = ASN1Boolean.getInstance(aSN1Object);
            } else if (aSN1Object instanceof ASN1Integer) {
                this.h = ASN1Integer.getInstance(aSN1Object);
            }
        }
    }

    public static TSTInfo getInstance(Object obj) {
        if (obj instanceof TSTInfo) {
            return (TSTInfo) obj;
        }
        if (obj != null) {
            return new TSTInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Accuracy getAccuracy() {
        return this.f;
    }

    public Extensions getExtensions() {
        return this.j;
    }

    public ASN1GeneralizedTime getGenTime() {
        return this.e;
    }

    public MessageImprint getMessageImprint() {
        return this.c;
    }

    public ASN1Integer getNonce() {
        return this.h;
    }

    public ASN1Boolean getOrdering() {
        return this.g;
    }

    public ASN1ObjectIdentifier getPolicy() {
        return this.b;
    }

    public ASN1Integer getSerialNumber() {
        return this.d;
    }

    public GeneralName getTsa() {
        return this.i;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.e);
        Accuracy accuracy = this.f;
        if (accuracy != null) {
            aSN1EncodableVector.add(accuracy);
        }
        ASN1Boolean aSN1Boolean = this.g;
        if (aSN1Boolean != null && aSN1Boolean.isTrue()) {
            aSN1EncodableVector.add(this.g);
        }
        ASN1Integer aSN1Integer = this.h;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        GeneralName generalName = this.i;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, generalName));
        }
        Extensions extensions = this.j;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TSTInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, MessageImprint messageImprint, ASN1Integer aSN1Integer, ASN1GeneralizedTime aSN1GeneralizedTime, Accuracy accuracy, ASN1Boolean aSN1Boolean, ASN1Integer aSN1Integer2, GeneralName generalName, Extensions extensions) {
        this.a = new ASN1Integer(1);
        this.b = aSN1ObjectIdentifier;
        this.c = messageImprint;
        this.d = aSN1Integer;
        this.e = aSN1GeneralizedTime;
        this.f = accuracy;
        this.g = aSN1Boolean;
        this.h = aSN1Integer2;
        this.i = generalName;
        this.j = extensions;
    }
}
