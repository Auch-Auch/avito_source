package org.spongycastle.x509.extension;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509Extension;
public class AuthorityKeyIdentifierStructure extends AuthorityKeyIdentifier {
    public AuthorityKeyIdentifierStructure(byte[] bArr) throws IOException {
        super((ASN1Sequence) X509ExtensionUtil.fromExtensionValue(bArr));
    }

    public AuthorityKeyIdentifierStructure(X509Extension x509Extension) {
        super((ASN1Sequence) x509Extension.getParsedValue());
    }

    public AuthorityKeyIdentifierStructure(Extension extension) {
        super((ASN1Sequence) extension.getParsedValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthorityKeyIdentifierStructure(java.security.cert.X509Certificate r5) throws java.security.cert.CertificateParsingException {
        /*
            r4 = this;
            int r0 = r5.getVersion()     // Catch:{ Exception -> 0x0089 }
            r1 = 3
            if (r0 == r1) goto L_0x0031
            org.spongycastle.asn1.x509.GeneralName r0 = new org.spongycastle.asn1.x509.GeneralName     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.jce.X509Principal r1 = org.spongycastle.jce.PrincipalUtil.getIssuerX509Principal(r5)     // Catch:{ Exception -> 0x0089 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0089 }
            java.security.PublicKey r1 = r5.getPublicKey()     // Catch:{ Exception -> 0x0089 }
            byte[] r1 = r1.getEncoded()     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r1 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.getInstance(r1)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r2 = new org.spongycastle.asn1.x509.AuthorityKeyIdentifier     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.GeneralNames r3 = new org.spongycastle.asn1.x509.GeneralNames     // Catch:{ Exception -> 0x0089 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0089 }
            java.math.BigInteger r5 = r5.getSerialNumber()     // Catch:{ Exception -> 0x0089 }
            r2.<init>(r1, r3, r5)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1Primitive r5 = r2.toASN1Primitive()     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5     // Catch:{ Exception -> 0x0089 }
            goto L_0x0085
        L_0x0031:
            org.spongycastle.asn1.x509.GeneralName r0 = new org.spongycastle.asn1.x509.GeneralName     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.jce.X509Principal r1 = org.spongycastle.jce.PrincipalUtil.getIssuerX509Principal(r5)     // Catch:{ Exception -> 0x0089 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.x509.Extension.subjectKeyIdentifier     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x0089 }
            byte[] r1 = r5.getExtensionValue(r1)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0065
            org.spongycastle.asn1.ASN1Primitive r1 = org.spongycastle.x509.extension.X509ExtensionUtil.fromExtensionValue(r1)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1OctetString r1 = (org.spongycastle.asn1.ASN1OctetString) r1     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r2 = new org.spongycastle.asn1.x509.AuthorityKeyIdentifier     // Catch:{ Exception -> 0x0089 }
            byte[] r1 = r1.getOctets()     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.GeneralNames r3 = new org.spongycastle.asn1.x509.GeneralNames     // Catch:{ Exception -> 0x0089 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0089 }
            java.math.BigInteger r5 = r5.getSerialNumber()     // Catch:{ Exception -> 0x0089 }
            r2.<init>(r1, r3, r5)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1Primitive r5 = r2.toASN1Primitive()     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5     // Catch:{ Exception -> 0x0089 }
            goto L_0x0085
        L_0x0065:
            java.security.PublicKey r1 = r5.getPublicKey()     // Catch:{ Exception -> 0x0089 }
            byte[] r1 = r1.getEncoded()     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r1 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.getInstance(r1)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r2 = new org.spongycastle.asn1.x509.AuthorityKeyIdentifier     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.x509.GeneralNames r3 = new org.spongycastle.asn1.x509.GeneralNames     // Catch:{ Exception -> 0x0089 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0089 }
            java.math.BigInteger r5 = r5.getSerialNumber()     // Catch:{ Exception -> 0x0089 }
            r2.<init>(r1, r3, r5)     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1Primitive r5 = r2.toASN1Primitive()     // Catch:{ Exception -> 0x0089 }
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5     // Catch:{ Exception -> 0x0089 }
        L_0x0085:
            r4.<init>(r5)
            return
        L_0x0089:
            r5 = move-exception
            java.security.cert.CertificateParsingException r0 = new java.security.cert.CertificateParsingException
            java.lang.String r1 = "Exception extracting certificate details: "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.String r5 = a2.b.a.a.a.G2(r5, r1)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.extension.AuthorityKeyIdentifierStructure.<init>(java.security.cert.X509Certificate):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthorityKeyIdentifierStructure(PublicKey publicKey) throws InvalidKeyException {
        super((ASN1Sequence) new AuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())).toASN1Primitive());
        try {
        } catch (Exception e) {
            throw new InvalidKeyException(a.a3("can't process key: ", e));
        }
    }
}
