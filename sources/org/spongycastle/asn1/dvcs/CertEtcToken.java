package org.spongycastle.asn1.dvcs;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.ess.ESSCertID;
import org.spongycastle.asn1.ocsp.CertID;
import org.spongycastle.asn1.ocsp.CertStatus;
import org.spongycastle.asn1.ocsp.OCSPResponse;
import org.spongycastle.asn1.smime.SMIMECapabilities;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
public class CertEtcToken extends ASN1Object implements ASN1Choice {
    public static final int TAG_ASSERTION = 3;
    public static final int TAG_CAPABILITIES = 8;
    public static final int TAG_CERTIFICATE = 0;
    public static final int TAG_CRL = 4;
    public static final int TAG_ESSCERTID = 1;
    public static final int TAG_OCSPCERTID = 6;
    public static final int TAG_OCSPCERTSTATUS = 5;
    public static final int TAG_OCSPRESPONSE = 7;
    public static final int TAG_PKISTATUS = 2;
    public static final boolean[] d = {false, true, false, true, false, true, false, false, true};
    public int a;
    public ASN1Encodable b;
    public Extension c;

    public CertEtcToken(int i, ASN1Encodable aSN1Encodable) {
        this.a = i;
        this.b = aSN1Encodable;
    }

    public static CertEtcToken[] arrayFromSequence(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        CertEtcToken[] certEtcTokenArr = new CertEtcToken[size];
        for (int i = 0; i != size; i++) {
            certEtcTokenArr[i] = getInstance(aSN1Sequence.getObjectAt(i));
        }
        return certEtcTokenArr;
    }

    public static CertEtcToken getInstance(Object obj) {
        if (obj instanceof CertEtcToken) {
            return (CertEtcToken) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertEtcToken((ASN1TaggedObject) obj);
        }
        if (obj != null) {
            return new CertEtcToken(Extension.getInstance(obj));
        }
        return null;
    }

    public Extension getExtension() {
        return this.c;
    }

    public int getTagNo() {
        return this.a;
    }

    public ASN1Encodable getValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        Extension extension = this.c;
        if (extension != null) {
            return extension.toASN1Primitive();
        }
        boolean[] zArr = d;
        int i = this.a;
        return new DERTaggedObject(zArr[i], i, this.b);
    }

    public String toString() {
        StringBuilder L = a.L("CertEtcToken {\n");
        L.append(this.b);
        L.append("}\n");
        return L.toString();
    }

    public CertEtcToken(Extension extension) {
        this.a = -1;
        this.c = extension;
    }

    public CertEtcToken(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.a = tagNo;
        switch (tagNo) {
            case 0:
                this.b = Certificate.getInstance(aSN1TaggedObject, false);
                return;
            case 1:
                this.b = ESSCertID.getInstance(aSN1TaggedObject.getObject());
                return;
            case 2:
                this.b = PKIStatusInfo.getInstance(aSN1TaggedObject, false);
                return;
            case 3:
                this.b = ContentInfo.getInstance(aSN1TaggedObject.getObject());
                return;
            case 4:
                this.b = CertificateList.getInstance(aSN1TaggedObject, false);
                return;
            case 5:
                this.b = CertStatus.getInstance(aSN1TaggedObject.getObject());
                return;
            case 6:
                this.b = CertID.getInstance(aSN1TaggedObject, false);
                return;
            case 7:
                this.b = OCSPResponse.getInstance(aSN1TaggedObject, false);
                return;
            case 8:
                this.b = SMIMECapabilities.getInstance(aSN1TaggedObject.getObject());
                return;
            default:
                StringBuilder L = a.L("Unknown tag: ");
                L.append(this.a);
                throw new IllegalArgumentException(L.toString());
        }
    }
}
