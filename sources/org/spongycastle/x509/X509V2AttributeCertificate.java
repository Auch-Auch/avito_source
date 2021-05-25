package org.spongycastle.x509;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.util.Arrays;
public class X509V2AttributeCertificate implements X509AttributeCertificate {
    public AttributeCertificate a;
    public Date b;
    public Date c;

    public X509V2AttributeCertificate(InputStream inputStream) throws IOException {
        try {
            AttributeCertificate instance = AttributeCertificate.getInstance(new ASN1InputStream(inputStream).readObject());
            this.a = instance;
            try {
                this.c = instance.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime().getDate();
                this.b = instance.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime().getDate();
            } catch (ParseException unused) {
                throw new IOException("invalid data structure in certificate!");
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException(a.G2(e2, a.L("exception decoding certificate structure: ")));
        }
    }

    public final Set a(boolean z) {
        Extensions extensions = this.a.getAcinfo().getExtensions();
        if (extensions == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (extensions.getExtension(aSN1ObjectIdentifier).isCritical() == z) {
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509AttributeCertificate)) {
            return false;
        }
        try {
            return Arrays.areEqual(getEncoded(), ((X509AttributeCertificate) obj).getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public X509Attribute[] getAttributes() {
        ASN1Sequence attributes = this.a.getAcinfo().getAttributes();
        X509Attribute[] x509AttributeArr = new X509Attribute[attributes.size()];
        for (int i = 0; i != attributes.size(); i++) {
            x509AttributeArr[i] = new X509Attribute(attributes.getObjectAt(i));
        }
        return x509AttributeArr;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return a(true);
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public byte[] getEncoded() throws IOException {
        return this.a.getEncoded();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        Extension extension;
        Extensions extensions = this.a.getAcinfo().getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getExtnValue().getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new RuntimeException(a.G2(e, a.L("error encoding ")));
        }
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public AttributeCertificateHolder getHolder() {
        return new AttributeCertificateHolder((ASN1Sequence) this.a.getAcinfo().getHolder().toASN1Primitive());
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public AttributeCertificateIssuer getIssuer() {
        return new AttributeCertificateIssuer(this.a.getAcinfo().getIssuer());
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public boolean[] getIssuerUniqueID() {
        DERBitString issuerUniqueID = this.a.getAcinfo().getIssuerUniqueID();
        if (issuerUniqueID == null) {
            return null;
        }
        byte[] bytes = issuerUniqueID.getBytes();
        int length = (bytes.length * 8) - issuerUniqueID.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (bytes[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return a(false);
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public Date getNotAfter() {
        return this.c;
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public Date getNotBefore() {
        return this.b;
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public BigInteger getSerialNumber() {
        return this.a.getAcinfo().getSerialNumber().getValue();
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public byte[] getSignature() {
        return this.a.getSignatureValue().getOctets();
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public int getVersion() {
        return this.a.getAcinfo().getVersion().getValue().intValue() + 1;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }

    @Override // java.lang.Object
    public int hashCode() {
        try {
            return Arrays.hashCode(getEncoded());
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (this.a.getSignatureAlgorithm().equals(this.a.getAcinfo().getSignature())) {
            Signature instance = Signature.getInstance(this.a.getSignatureAlgorithm().getAlgorithm().getId(), str);
            instance.initVerify(publicKey);
            try {
                instance.update(this.a.getAcinfo().getEncoded());
                if (!instance.verify(getSignature())) {
                    throw new InvalidKeyException("Public key presented not for certificate signature");
                }
            } catch (IOException unused) {
                throw new SignatureException("Exception encoding certificate info object");
            }
        } else {
            throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
        }
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.after(getNotAfter())) {
            StringBuilder L = a.L("certificate expired on ");
            L.append(getNotAfter());
            throw new CertificateExpiredException(L.toString());
        } else if (date.before(getNotBefore())) {
            StringBuilder L2 = a.L("certificate not valid till ");
            L2.append(getNotBefore());
            throw new CertificateNotYetValidException(L2.toString());
        }
    }

    @Override // org.spongycastle.x509.X509AttributeCertificate
    public X509Attribute[] getAttributes(String str) {
        ASN1Sequence attributes = this.a.getAcinfo().getAttributes();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != attributes.size(); i++) {
            X509Attribute x509Attribute = new X509Attribute(attributes.getObjectAt(i));
            if (x509Attribute.getOID().equals(str)) {
                arrayList.add(x509Attribute);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (X509Attribute[]) arrayList.toArray(new X509Attribute[arrayList.size()]);
    }

    public X509V2AttributeCertificate(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }
}
