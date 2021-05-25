package org.spongycastle.asn1.isismtt.ocsp;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Certificate;
public class RequestedCertificate extends ASN1Object implements ASN1Choice {
    public static final int attributeCertificate = 1;
    public static final int certificate = -1;
    public static final int publicKeyCertificate = 0;
    public Certificate a;
    public byte[] b;
    public byte[] c;

    public RequestedCertificate(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.b = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.c = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else {
            throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("unknown tag number: ")));
        }
    }

    public static RequestedCertificate getInstance(Object obj) {
        if (obj == null || (obj instanceof RequestedCertificate)) {
            return (RequestedCertificate) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RequestedCertificate(Certificate.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            return new RequestedCertificate((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public byte[] getCertificateBytes() {
        Certificate certificate2 = this.a;
        if (certificate2 != null) {
            try {
                return certificate2.getEncoded();
            } catch (IOException e) {
                throw new IllegalStateException(a.Z2("can't decode certificate: ", e));
            }
        } else {
            byte[] bArr = this.b;
            if (bArr != null) {
                return bArr;
            }
            return this.c;
        }
    }

    public int getType() {
        if (this.a != null) {
            return -1;
        }
        return this.b != null ? 0 : 1;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return new DERTaggedObject(0, new DEROctetString(bArr));
        }
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            return new DERTaggedObject(1, new DEROctetString(bArr2));
        }
        return this.a.toASN1Primitive();
    }

    public RequestedCertificate(Certificate certificate2) {
        this.a = certificate2;
    }

    public RequestedCertificate(int i, byte[] bArr) {
        this(new DERTaggedObject(i, new DEROctetString(bArr)));
    }

    public static RequestedCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }
}
