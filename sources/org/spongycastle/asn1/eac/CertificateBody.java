package org.spongycastle.asn1.eac;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1ApplicationSpecific;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;
public class CertificateBody extends ASN1Object {
    public static final int profileType = 127;
    public static final int requestType = 13;
    public DERApplicationSpecific a;
    public DERApplicationSpecific b;
    public PublicKeyDataObject c;
    public DERApplicationSpecific d;
    public CertificateHolderAuthorization e;
    public DERApplicationSpecific f;
    public DERApplicationSpecific g;
    public int h = 0;

    public CertificateBody(DERApplicationSpecific dERApplicationSpecific, CertificationAuthorityReference certificationAuthorityReference, PublicKeyDataObject publicKeyDataObject, CertificateHolderReference certificateHolderReference, CertificateHolderAuthorization certificateHolderAuthorization, PackedDate packedDate, PackedDate packedDate2) {
        e(dERApplicationSpecific);
        f(new DERApplicationSpecific(2, certificationAuthorityReference.getEncoded()));
        this.c = PublicKeyDataObject.getInstance(publicKeyDataObject);
        this.h |= 4;
        d(new DERApplicationSpecific(32, certificateHolderReference.getEncoded()));
        this.e = certificateHolderAuthorization;
        this.h |= 16;
        try {
            b(new DERApplicationSpecific(false, 37, (ASN1Encodable) new DEROctetString(packedDate.getEncoding())));
            c(new DERApplicationSpecific(false, 36, (ASN1Encodable) new DEROctetString(packedDate2.getEncoding())));
        } catch (IOException e2) {
            throw new IllegalArgumentException(a.A2(e2, a.L("unable to encode dates: ")));
        }
    }

    public static CertificateBody getInstance(Object obj) throws IOException {
        if (obj instanceof CertificateBody) {
            return (CertificateBody) obj;
        }
        if (obj != null) {
            return new CertificateBody(ASN1ApplicationSpecific.getInstance(obj));
        }
        return null;
    }

    public final ASN1Primitive a() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(new DERApplicationSpecific(false, 73, (ASN1Encodable) this.c));
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.e);
        aSN1EncodableVector.add(this.f);
        aSN1EncodableVector.add(this.g);
        return new DERApplicationSpecific(78, aSN1EncodableVector);
    }

    public final void b(DERApplicationSpecific dERApplicationSpecific) throws IllegalArgumentException {
        if (dERApplicationSpecific.getApplicationTag() == 37) {
            this.f = dERApplicationSpecific;
            this.h |= 32;
            return;
        }
        StringBuilder L = a.L("Not an Iso7816Tags.APPLICATION_EFFECTIVE_DATE tag :");
        L.append(EACTags.encodeTag(dERApplicationSpecific));
        throw new IllegalArgumentException(L.toString());
    }

    public final void c(DERApplicationSpecific dERApplicationSpecific) throws IllegalArgumentException {
        if (dERApplicationSpecific.getApplicationTag() == 36) {
            this.g = dERApplicationSpecific;
            this.h |= 64;
            return;
        }
        throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EXPIRATION_DATE tag");
    }

    public final void d(DERApplicationSpecific dERApplicationSpecific) throws IllegalArgumentException {
        if (dERApplicationSpecific.getApplicationTag() == 32) {
            this.d = dERApplicationSpecific;
            this.h |= 8;
            return;
        }
        throw new IllegalArgumentException("Not an Iso7816Tags.CARDHOLDER_NAME tag");
    }

    public final void e(DERApplicationSpecific dERApplicationSpecific) throws IllegalArgumentException {
        if (dERApplicationSpecific.getApplicationTag() == 41) {
            this.a = dERApplicationSpecific;
            this.h |= 1;
            return;
        }
        StringBuilder L = a.L("Not an Iso7816Tags.INTERCHANGE_PROFILE tag :");
        L.append(EACTags.encodeTag(dERApplicationSpecific));
        throw new IllegalArgumentException(L.toString());
    }

    public final void f(DERApplicationSpecific dERApplicationSpecific) throws IllegalArgumentException {
        if (dERApplicationSpecific.getApplicationTag() == 2) {
            this.b = dERApplicationSpecific;
            this.h |= 2;
            return;
        }
        throw new IllegalArgumentException("Not an Iso7816Tags.ISSUER_IDENTIFICATION_NUMBER tag");
    }

    public PackedDate getCertificateEffectiveDate() {
        if ((this.h & 32) == 32) {
            return new PackedDate(this.f.getContents());
        }
        return null;
    }

    public PackedDate getCertificateExpirationDate() throws IOException {
        if ((this.h & 64) == 64) {
            return new PackedDate(this.g.getContents());
        }
        throw new IOException("certificate Expiration Date not set");
    }

    public CertificateHolderAuthorization getCertificateHolderAuthorization() throws IOException {
        if ((this.h & 16) == 16) {
            return this.e;
        }
        throw new IOException("Certificate Holder Authorisation not set");
    }

    public CertificateHolderReference getCertificateHolderReference() {
        return new CertificateHolderReference(this.d.getContents());
    }

    public DERApplicationSpecific getCertificateProfileIdentifier() {
        return this.a;
    }

    public int getCertificateType() {
        return this.h;
    }

    public CertificationAuthorityReference getCertificationAuthorityReference() throws IOException {
        if ((this.h & 2) == 2) {
            return new CertificationAuthorityReference(this.b.getContents());
        }
        throw new IOException("Certification authority reference not set");
    }

    public PublicKeyDataObject getPublicKey() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            int i = this.h;
            if (i == 127) {
                return a();
            }
            if (i == 13) {
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(this.a);
                aSN1EncodableVector.add(new DERApplicationSpecific(false, 73, (ASN1Encodable) this.c));
                aSN1EncodableVector.add(this.d);
                return new DERApplicationSpecific(78, aSN1EncodableVector);
            }
            return null;
        } catch (IOException unused) {
        }
    }

    public CertificateBody(ASN1ApplicationSpecific aSN1ApplicationSpecific) throws IOException {
        if (aSN1ApplicationSpecific.getApplicationTag() == 78) {
            ASN1InputStream aSN1InputStream = new ASN1InputStream(aSN1ApplicationSpecific.getContents());
            while (true) {
                ASN1Primitive readObject = aSN1InputStream.readObject();
                if (readObject == null) {
                    aSN1InputStream.close();
                    return;
                } else if (readObject instanceof DERApplicationSpecific) {
                    DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) readObject;
                    int applicationTag = dERApplicationSpecific.getApplicationTag();
                    if (applicationTag == 2) {
                        f(dERApplicationSpecific);
                    } else if (applicationTag == 32) {
                        d(dERApplicationSpecific);
                    } else if (applicationTag == 41) {
                        e(dERApplicationSpecific);
                    } else if (applicationTag == 73) {
                        this.c = PublicKeyDataObject.getInstance(PublicKeyDataObject.getInstance(dERApplicationSpecific.getObject(16)));
                        this.h |= 4;
                    } else if (applicationTag == 76) {
                        this.e = new CertificateHolderAuthorization(dERApplicationSpecific);
                        this.h |= 16;
                    } else if (applicationTag == 36) {
                        c(dERApplicationSpecific);
                    } else if (applicationTag == 37) {
                        b(dERApplicationSpecific);
                    } else {
                        this.h = 0;
                        StringBuilder L = a.L("Not a valid iso7816 DERApplicationSpecific tag ");
                        L.append(dERApplicationSpecific.getApplicationTag());
                        throw new IOException(L.toString());
                    }
                } else {
                    StringBuilder L2 = a.L("Not a valid iso7816 content : not a DERApplicationSpecific Object :");
                    L2.append(EACTags.encodeTag(aSN1ApplicationSpecific));
                    L2.append(readObject.getClass());
                    throw new IOException(L2.toString());
                }
            }
        } else {
            throw new IOException("Bad tag : not an iso7816 CERTIFICATE_CONTENT_TEMPLATE");
        }
    }
}
