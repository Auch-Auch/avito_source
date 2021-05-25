package org.spongycastle.asn1.eac;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1ApplicationSpecific;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1ParsingException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.util.Arrays;
public class CVCertificate extends ASN1Object {
    public CertificateBody a;
    public byte[] b;
    public int c;

    public CVCertificate(ASN1InputStream aSN1InputStream) throws IOException {
        while (true) {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject == null) {
                return;
            }
            if (readObject instanceof DERApplicationSpecific) {
                a((DERApplicationSpecific) readObject);
            } else {
                throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
            }
        }
    }

    public static CVCertificate getInstance(Object obj) {
        if (obj instanceof CVCertificate) {
            return (CVCertificate) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new CVCertificate(ASN1ApplicationSpecific.getInstance(obj));
        } catch (IOException e) {
            throw new ASN1ParsingException(a.A2(e, a.L("unable to parse data: ")), e);
        }
    }

    public final void a(ASN1ApplicationSpecific aSN1ApplicationSpecific) throws IOException {
        this.c = 0;
        if (aSN1ApplicationSpecific.getApplicationTag() == 33) {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(aSN1ApplicationSpecific.getContents());
            while (true) {
                ASN1Primitive readObject = aSN1InputStream.readObject();
                if (readObject == null) {
                    aSN1InputStream.close();
                    if (this.c != 3) {
                        StringBuilder L = a.L("invalid CARDHOLDER_CERTIFICATE :");
                        L.append(aSN1ApplicationSpecific.getApplicationTag());
                        throw new IOException(L.toString());
                    }
                    return;
                } else if (readObject instanceof DERApplicationSpecific) {
                    DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) readObject;
                    int applicationTag = dERApplicationSpecific.getApplicationTag();
                    if (applicationTag == 55) {
                        this.b = dERApplicationSpecific.getContents();
                        this.c |= 2;
                    } else if (applicationTag == 78) {
                        this.a = CertificateBody.getInstance(dERApplicationSpecific);
                        this.c |= 1;
                    } else {
                        StringBuilder L2 = a.L("Invalid tag, not an Iso7816CertificateStructure :");
                        L2.append(dERApplicationSpecific.getApplicationTag());
                        throw new IOException(L2.toString());
                    }
                } else {
                    throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
                }
            }
        } else {
            StringBuilder L3 = a.L("not a CARDHOLDER_CERTIFICATE :");
            L3.append(aSN1ApplicationSpecific.getApplicationTag());
            throw new IOException(L3.toString());
        }
    }

    public CertificationAuthorityReference getAuthorityReference() throws IOException {
        return this.a.getCertificationAuthorityReference();
    }

    public CertificateBody getBody() {
        return this.a;
    }

    public int getCertificateType() {
        return this.a.getCertificateType();
    }

    public PackedDate getEffectiveDate() throws IOException {
        return this.a.getCertificateEffectiveDate();
    }

    public PackedDate getExpirationDate() throws IOException {
        return this.a.getCertificateExpirationDate();
    }

    public ASN1ObjectIdentifier getHolderAuthorization() throws IOException {
        return this.a.getCertificateHolderAuthorization().getOid();
    }

    public Flags getHolderAuthorizationRights() throws IOException {
        return new Flags(this.a.getCertificateHolderAuthorization().getAccessRights() & 31);
    }

    public int getHolderAuthorizationRole() throws IOException {
        return this.a.getCertificateHolderAuthorization().getAccessRights() & 192;
    }

    public CertificateHolderReference getHolderReference() throws IOException {
        return this.a.getCertificateHolderReference();
    }

    public int getRole() throws IOException {
        return this.a.getCertificateHolderAuthorization().getAccessRights();
    }

    public byte[] getSignature() {
        return Arrays.clone(this.b);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, (ASN1Encodable) new DEROctetString(this.b)));
            return new DERApplicationSpecific(33, aSN1EncodableVector);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }

    public CVCertificate(ASN1ApplicationSpecific aSN1ApplicationSpecific) throws IOException {
        a(aSN1ApplicationSpecific);
    }

    public CVCertificate(CertificateBody certificateBody, byte[] bArr) throws IOException {
        this.a = certificateBody;
        this.b = Arrays.clone(bArr);
        int i = this.c | 1;
        this.c = i;
        this.c = i | 2;
    }
}
