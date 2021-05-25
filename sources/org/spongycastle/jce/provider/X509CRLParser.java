package org.spongycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.util.ArrayList;
import java.util.Collection;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.x509.X509StreamParserSpi;
import org.spongycastle.x509.util.StreamParsingException;
public class X509CRLParser extends X509StreamParserSpi {
    public static final PEMUtil d = new PEMUtil("CRL");
    public ASN1Set a = null;
    public int b = 0;
    public InputStream c = null;

    public final CRL a() throws CRLException {
        ASN1Set aSN1Set = this.a;
        if (aSN1Set == null || this.b >= aSN1Set.size()) {
            return null;
        }
        ASN1Set aSN1Set2 = this.a;
        int i = this.b;
        this.b = i + 1;
        return new X509CRLObject(CertificateList.getInstance(aSN1Set2.getObjectAt(i)));
    }

    public final CRL b(InputStream inputStream) throws IOException, CRLException {
        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(inputStream).readObject();
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509CRLObject(CertificateList.getInstance(aSN1Sequence));
        }
        this.a = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCRLs();
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
                        return new X509CRLObject(CertificateList.getInstance(b2));
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
            CRL crl = (CRL) engineRead();
            if (crl == null) {
                return arrayList;
            }
            arrayList.add(crl);
        }
    }
}
