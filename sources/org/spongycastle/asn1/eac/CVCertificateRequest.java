package org.spongycastle.asn1.eac;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1ApplicationSpecific;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ParsingException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.util.Arrays;
public class CVCertificateRequest extends ASN1Object {
    public final ASN1ApplicationSpecific a;
    public CertificateBody b;
    public byte[] c = null;
    public byte[] d = null;

    public CVCertificateRequest(ASN1ApplicationSpecific aSN1ApplicationSpecific) throws IOException {
        this.a = aSN1ApplicationSpecific;
        if (!aSN1ApplicationSpecific.isConstructed() || aSN1ApplicationSpecific.getApplicationTag() != 7) {
            a(aSN1ApplicationSpecific);
            return;
        }
        ASN1Sequence instance = ASN1Sequence.getInstance(aSN1ApplicationSpecific.getObject(16));
        a(ASN1ApplicationSpecific.getInstance(instance.getObjectAt(0)));
        this.d = ASN1ApplicationSpecific.getInstance(instance.getObjectAt(instance.size() - 1)).getContents();
    }

    public static CVCertificateRequest getInstance(Object obj) {
        if (obj instanceof CVCertificateRequest) {
            return (CVCertificateRequest) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new CVCertificateRequest(ASN1ApplicationSpecific.getInstance(obj));
        } catch (IOException e) {
            throw new ASN1ParsingException(a.A2(e, a.L("unable to parse data: ")), e);
        }
    }

    public final void a(ASN1ApplicationSpecific aSN1ApplicationSpecific) throws IOException {
        if (aSN1ApplicationSpecific.getApplicationTag() == 33) {
            boolean z = false;
            Enumeration objects = ASN1Sequence.getInstance(aSN1ApplicationSpecific.getObject(16)).getObjects();
            while (objects.hasMoreElements()) {
                ASN1ApplicationSpecific instance = ASN1ApplicationSpecific.getInstance(objects.nextElement());
                int applicationTag = instance.getApplicationTag();
                if (applicationTag == 55) {
                    this.c = instance.getContents();
                    z |= true;
                } else if (applicationTag == 78) {
                    this.b = CertificateBody.getInstance(instance);
                    z |= true;
                } else {
                    StringBuilder L = a.L("Invalid tag, not an CV Certificate Request element:");
                    L.append(instance.getApplicationTag());
                    throw new IOException(L.toString());
                }
            }
            if (!z || !true) {
                StringBuilder L2 = a.L("Invalid CARDHOLDER_CERTIFICATE in request:");
                L2.append(aSN1ApplicationSpecific.getApplicationTag());
                throw new IOException(L2.toString());
            }
            return;
        }
        StringBuilder L3 = a.L("not a CARDHOLDER_CERTIFICATE in request:");
        L3.append(aSN1ApplicationSpecific.getApplicationTag());
        throw new IOException(L3.toString());
    }

    public CertificateBody getCertificateBody() {
        return this.b;
    }

    public byte[] getInnerSignature() {
        return Arrays.clone(this.c);
    }

    public byte[] getOuterSignature() {
        return Arrays.clone(this.d);
    }

    public PublicKeyDataObject getPublicKey() {
        return this.b.getPublicKey();
    }

    public boolean hasOuterSignature() {
        return this.d != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1ApplicationSpecific aSN1ApplicationSpecific = this.a;
        if (aSN1ApplicationSpecific != null) {
            return aSN1ApplicationSpecific;
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.b);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, (ASN1Encodable) new DEROctetString(this.c)));
            return new DERApplicationSpecific(33, aSN1EncodableVector);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }
}
