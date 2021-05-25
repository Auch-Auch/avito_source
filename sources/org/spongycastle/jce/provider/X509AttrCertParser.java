package org.spongycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.X509V2AttributeCertificate;
import org.spongycastle.x509.util.StreamParsingException;
public class X509AttrCertParser extends X509StreamParserSpi {
    public static final PEMUtil d = new PEMUtil("ATTRIBUTE CERTIFICATE");
    public ASN1Set a = null;
    public int b = 0;
    public InputStream c = null;

    public final X509AttributeCertificate a() throws IOException {
        if (this.a == null) {
            return null;
        }
        while (this.b < this.a.size()) {
            ASN1Set aSN1Set = this.a;
            int i = this.b;
            this.b = i + 1;
            ASN1Encodable objectAt = aSN1Set.getObjectAt(i);
            if (objectAt instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objectAt;
                if (aSN1TaggedObject.getTagNo() == 2) {
                    return new X509V2AttributeCertificate(ASN1Sequence.getInstance(aSN1TaggedObject, false).getEncoded());
                }
            }
        }
        return null;
    }

    public final X509AttributeCertificate b(InputStream inputStream) throws IOException {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).readObject();
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509V2AttributeCertificate(aSN1Sequence.getEncoded());
        }
        this.a = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
        return a();
    }

    @Override // org.spongycastle.x509.X509StreamParserSpi
    public void engineInit(InputStream inputStream) {
        this.c = inputStream;
        this.a = null;
        this.b = 0;
        if (!inputStream.markSupported()) {
            this.c = new BufferedInputStream(this.c);
        }
    }

    @Override // org.spongycastle.x509.X509StreamParserSpi
    public Object engineRead() throws StreamParsingException {
        try {
            ASN1Set aSN1Set = this.a;
            if (aSN1Set == null) {
                this.c.mark(10);
                int read = this.c.read();
                if (read == -1) {
                    return null;
                }
                if (read != 48) {
                    this.c.reset();
                    ASN1Sequence b2 = d.b(this.c);
                    if (b2 != null) {
                        return new X509V2AttributeCertificate(b2.getEncoded());
                    }
                    return null;
                }
                this.c.reset();
                return b(this.c);
            } else if (this.b != aSN1Set.size()) {
                return a();
            } else {
                this.a = null;
                this.b = 0;
                return null;
            }
        } catch (Exception e) {
            throw new StreamParsingException(e.toString(), e);
        }
    }

    @Override // org.spongycastle.x509.X509StreamParserSpi
    public Collection engineReadAll() throws StreamParsingException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            X509AttributeCertificate x509AttributeCertificate = (X509AttributeCertificate) engineRead();
            if (x509AttributeCertificate == null) {
                return arrayList;
            }
            arrayList.add(x509AttributeCertificate);
        }
    }
}
