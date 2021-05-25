package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.CertReqMsg;
public class TaggedRequest extends ASN1Object implements ASN1Choice {
    public static final int CRM = 1;
    public static final int ORM = 2;
    public static final int TCR = 0;
    public final int a = 2;
    public final ASN1Encodable b;

    public TaggedRequest(TaggedCertificationRequest taggedCertificationRequest) {
        this.b = taggedCertificationRequest;
    }

    public static TaggedRequest getInstance(Object obj) {
        if (obj instanceof TaggedRequest) {
            return (TaggedRequest) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(((ASN1Encodable) obj).toASN1Primitive());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                return new TaggedRequest(TaggedCertificationRequest.getInstance(instance, false));
            }
            if (tagNo == 1) {
                return new TaggedRequest(CertReqMsg.getInstance(instance, false));
            }
            if (tagNo == 2) {
                return new TaggedRequest(ASN1Sequence.getInstance(instance, false));
            }
            throw new IllegalArgumentException(a.D(instance, a.L("unknown tag in getInstance(): ")));
        } else if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        } else {
            throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
        }
    }

    public int getTagNo() {
        return this.a;
    }

    public ASN1Encodable getValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.a, this.b);
    }

    public TaggedRequest(CertReqMsg certReqMsg) {
        this.b = certReqMsg;
    }

    public TaggedRequest(ASN1Sequence aSN1Sequence) {
        this.b = aSN1Sequence;
    }
}
