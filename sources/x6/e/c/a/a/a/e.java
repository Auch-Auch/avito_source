package x6.e.c.a.a.a;

import a2.b.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.misc.NetscapeCertType;
import org.spongycastle.asn1.misc.NetscapeRevocationURL;
import org.spongycastle.asn1.misc.VerisignCzagExtension;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
public class e extends X509Certificate implements PKCS12BagAttributeCarrier {
    public JcaJceHelper a;
    public Certificate b;
    public BasicConstraints c;
    public boolean[] d;
    public boolean e;
    public int f;
    public PKCS12BagAttributeCarrier g = new PKCS12BagAttributeCarrierImpl();

    public e(JcaJceHelper jcaJceHelper, Certificate certificate) throws CertificateParsingException {
        this.a = jcaJceHelper;
        this.b = certificate;
        try {
            byte[] c2 = c("2.5.29.19");
            if (c2 != null) {
                this.c = BasicConstraints.getInstance(ASN1Primitive.fromByteArray(c2));
            }
            try {
                byte[] c3 = c("2.5.29.15");
                if (c3 != null) {
                    DERBitString instance = DERBitString.getInstance(ASN1Primitive.fromByteArray(c3));
                    byte[] bytes = instance.getBytes();
                    int length = (bytes.length * 8) - instance.getPadBits();
                    int i = 9;
                    if (length >= 9) {
                        i = length;
                    }
                    this.d = new boolean[i];
                    for (int i2 = 0; i2 != length; i2++) {
                        this.d[i2] = (bytes[i2 / 8] & (128 >>> (i2 % 8))) != 0;
                    }
                    return;
                }
                this.d = null;
            } catch (Exception e2) {
                throw new CertificateParsingException(a.a3("cannot construct KeyUsage: ", e2));
            }
        } catch (Exception e3) {
            throw new CertificateParsingException(a.a3("cannot construct BasicConstraints: ", e3));
        }
    }

    public static Collection b(byte[] bArr) throws CertificateParsingException {
        if (bArr == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration objects = ASN1Sequence.getInstance(bArr).getObjects();
            while (objects.hasMoreElements()) {
                GeneralName instance = GeneralName.getInstance(objects.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integers.valueOf(instance.getTagNo()));
                switch (instance.getTagNo()) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(instance.getEncoded());
                        break;
                    case 1:
                    case 2:
                    case 6:
                        arrayList2.add(((ASN1String) instance.getName()).getString());
                        break;
                    case 4:
                        arrayList2.add(X500Name.getInstance(RFC4519Style.INSTANCE, instance.getName()).toString());
                        break;
                    case 7:
                        try {
                            arrayList2.add(InetAddress.getByAddress(ASN1OctetString.getInstance(instance.getName()).getOctets()).getHostAddress());
                            break;
                        } catch (UnknownHostException unused) {
                            break;
                        }
                    case 8:
                        arrayList2.add(ASN1ObjectIdentifier.getInstance(instance.getName()).getId());
                        break;
                    default:
                        throw new IOException("Bad tag number: " + instance.getTagNo());
                }
                arrayList.add(Collections.unmodifiableList(arrayList2));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e2) {
            throw new CertificateParsingException(e2.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r0.getParameters().equals(org.spongycastle.asn1.DERNull.INSTANCE) == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (r1.getParameters().equals(org.spongycastle.asn1.DERNull.INSTANCE) == false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.security.PublicKey r5, java.security.Signature r6) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.SignatureException, java.security.InvalidKeyException {
        /*
            r4 = this;
            org.spongycastle.asn1.x509.Certificate r0 = r4.b
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r0.getSignatureAlgorithm()
            org.spongycastle.asn1.x509.Certificate r1 = r4.b
            org.spongycastle.asn1.x509.TBSCertificate r1 = r1.getTBSCertificate()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r1.getSignature()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r0.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r1.getAlgorithm()
            boolean r2 = r2.equals(r3)
            r3 = 0
            if (r2 != 0) goto L_0x0020
            goto L_0x0060
        L_0x0020:
            org.spongycastle.asn1.ASN1Encodable r2 = r0.getParameters()
            if (r2 != 0) goto L_0x0039
            org.spongycastle.asn1.ASN1Encodable r0 = r1.getParameters()
            if (r0 == 0) goto L_0x0052
            org.spongycastle.asn1.ASN1Encodable r0 = r1.getParameters()
            org.spongycastle.asn1.DERNull r1 = org.spongycastle.asn1.DERNull.INSTANCE
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0052
            goto L_0x0060
        L_0x0039:
            org.spongycastle.asn1.ASN1Encodable r2 = r1.getParameters()
            if (r2 != 0) goto L_0x0054
            org.spongycastle.asn1.ASN1Encodable r1 = r0.getParameters()
            if (r1 == 0) goto L_0x0052
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.DERNull r1 = org.spongycastle.asn1.DERNull.INSTANCE
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0052
            goto L_0x0060
        L_0x0052:
            r3 = 1
            goto L_0x0060
        L_0x0054:
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1Encodable r1 = r1.getParameters()
            boolean r3 = r0.equals(r1)
        L_0x0060:
            if (r3 == 0) goto L_0x00eb
            org.spongycastle.asn1.x509.Certificate r0 = r4.b
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r0.getSignatureAlgorithm()
            org.spongycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.spongycastle.asn1.ASN1Null r1 = x6.e.c.a.a.a.f.a
            if (r0 == 0) goto L_0x00ce
            org.spongycastle.asn1.ASN1Null r1 = x6.e.c.a.a.a.f.a
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00ce
            java.lang.String r1 = r6.getAlgorithm()
            java.security.Provider r2 = r6.getProvider()
            java.security.AlgorithmParameters r1 = java.security.AlgorithmParameters.getInstance(r1, r2)
            org.spongycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()     // Catch:{ IOException -> 0x00bd }
            byte[] r0 = r0.getEncoded()     // Catch:{ IOException -> 0x00bd }
            r1.init(r0)     // Catch:{ IOException -> 0x00bd }
            java.lang.String r0 = r6.getAlgorithm()
            java.lang.String r2 = "MGF1"
            boolean r0 = r0.endsWith(r2)
            if (r0 == 0) goto L_0x00ce
            java.lang.Class<java.security.spec.PSSParameterSpec> r0 = java.security.spec.PSSParameterSpec.class
            java.security.spec.AlgorithmParameterSpec r0 = r1.getParameterSpec(r0)     // Catch:{ GeneralSecurityException -> 0x00a5 }
            r6.setParameter(r0)     // Catch:{ GeneralSecurityException -> 0x00a5 }
            goto L_0x00ce
        L_0x00a5:
            r5 = move-exception
            java.security.SignatureException r6 = new java.security.SignatureException
            java.lang.String r0 = "Exception extracting parameters: "
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x00bd:
            r5 = move-exception
            java.security.SignatureException r6 = new java.security.SignatureException
            java.lang.String r0 = "IOException decoding parameters: "
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            java.lang.String r5 = a2.b.a.a.a.A2(r5, r0)
            r6.<init>(r5)
            throw r6
        L_0x00ce:
            r6.initVerify(r5)
            byte[] r5 = r4.getTBSCertificate()
            r6.update(r5)
            byte[] r5 = r4.getSignature()
            boolean r5 = r6.verify(r5)
            if (r5 == 0) goto L_0x00e3
            return
        L_0x00e3:
            java.security.SignatureException r5 = new java.security.SignatureException
            java.lang.String r6 = "certificate does not verify with supplied key"
            r5.<init>(r6)
            throw r5
        L_0x00eb:
            java.security.cert.CertificateException r5 = new java.security.cert.CertificateException
            java.lang.String r6 = "signature algorithm in TBS cert not same as outer cert"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.e.c.a.a.a.e.a(java.security.PublicKey, java.security.Signature):void");
    }

    public final byte[] c(String str) {
        Extension extension;
        Extensions extensions = this.b.getTBSCertificate().getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        return extension.getExtnValue().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.Certificate, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        if (!this.e || !eVar.e || this.f == eVar.f) {
            return this.b.equals(eVar.b);
        }
        return false;
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.g.getBagAttribute(aSN1ObjectIdentifier);
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.g.getBagAttributeKeys();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        BasicConstraints basicConstraints = this.c;
        if (basicConstraints == null || !basicConstraints.isCA()) {
            return -1;
        }
        if (this.c.getPathLenConstraint() == null) {
            return Integer.MAX_VALUE;
        }
        return this.c.getPathLenConstraint().intValue();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.b.getTBSCertificate().getExtensions();
        if (extensions == null) {
            return null;
        }
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.b.getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] c2 = c("2.5.29.37");
        if (c2 == null) {
            return null;
        }
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(c2).readObject();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                arrayList.add(((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(i)).getId());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        Extension extension;
        Extensions extensions = this.b.getTBSCertificate().getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getExtnValue().getEncoded();
        } catch (Exception e2) {
            throw new IllegalStateException(a.G2(e2, a.L("error parsing ")));
        }
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return b(c(Extension.issuerAlternativeName.getId()));
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        try {
            return new X509Principal(X500Name.getInstance(this.b.getIssuer().getEncoded()));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        DERBitString issuerUniqueId = this.b.getTBSCertificate().getIssuerUniqueId();
        if (issuerUniqueId == null) {
            return null;
        }
        byte[] bytes = issuerUniqueId.getBytes();
        int length = (bytes.length * 8) - issuerUniqueId.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (bytes[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this.b.getIssuer());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.d;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.b.getTBSCertificate().getExtensions();
        if (extensions == null) {
            return null;
        }
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (!extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.b.getEndDate().getDate();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.b.getStartDate().getDate();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.getPublicKey(this.b.getSubjectPublicKeyInfo());
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.b.getSerialNumber().getValue();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return f.b(this.b.getSignatureAlgorithm());
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.b.getSignatureAlgorithm().getAlgorithm().getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        if (this.b.getSignatureAlgorithm().getParameters() != null) {
            try {
                return this.b.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded(ASN1Encoding.DER);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.b.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return b(c(Extension.subjectAlternativeName.getId()));
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new X509Principal(X500Name.getInstance(this.b.getSubject().toASN1Primitive()));
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        DERBitString subjectUniqueId = this.b.getTBSCertificate().getSubjectUniqueId();
        if (subjectUniqueId == null) {
            return null;
        }
        byte[] bytes = subjectUniqueId.getBytes();
        int length = (bytes.length * 8) - subjectUniqueId.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (bytes[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this.b.getSubject());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.b.getTBSCertificate().getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.b.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() != 3 || (extensions = this.b.getTBSCertificate().getExtensions()) == null) {
            return false;
        }
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (!aSN1ObjectIdentifier.equals(Extension.keyUsage) && !aSN1ObjectIdentifier.equals(Extension.certificatePolicies) && !aSN1ObjectIdentifier.equals(Extension.policyMappings) && !aSN1ObjectIdentifier.equals(Extension.inhibitAnyPolicy) && !aSN1ObjectIdentifier.equals(Extension.cRLDistributionPoints) && !aSN1ObjectIdentifier.equals(Extension.issuingDistributionPoint) && !aSN1ObjectIdentifier.equals(Extension.deltaCRLIndicator) && !aSN1ObjectIdentifier.equals(Extension.policyConstraints) && !aSN1ObjectIdentifier.equals(Extension.basicConstraints) && !aSN1ObjectIdentifier.equals(Extension.subjectAlternativeName) && !aSN1ObjectIdentifier.equals(Extension.nameConstraints) && extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.cert.Certificate, java.lang.Object
    public synchronized int hashCode() {
        if (!this.e) {
            this.f = super.hashCode();
            this.e = true;
        }
        return this.f;
    }

    @Override // org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.g.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // java.security.cert.Certificate, java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("  [0]         Version: ");
        stringBuffer.append(getVersion());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("         SerialNumber: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("           Start Date: ");
        stringBuffer.append(getNotBefore());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("           Final Date: ");
        stringBuffer.append(getNotAfter());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            SubjectDN: ");
        stringBuffer.append(getSubjectDN());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("           Public Key: ");
        stringBuffer.append(getPublicKey());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("  Signature Algorithm: ");
        stringBuffer.append(getSigAlgName());
        stringBuffer.append(lineSeparator);
        byte[] signature = getSignature();
        stringBuffer.append("            Signature: ");
        stringBuffer.append(new String(Hex.encode(signature, 0, 20)));
        stringBuffer.append(lineSeparator);
        for (int i = 20; i < signature.length; i += 20) {
            if (i < signature.length - 20) {
                stringBuffer.append("                       ");
                stringBuffer.append(new String(Hex.encode(signature, i, 20)));
                stringBuffer.append(lineSeparator);
            } else {
                stringBuffer.append("                       ");
                stringBuffer.append(new String(Hex.encode(signature, i, signature.length - i)));
                stringBuffer.append(lineSeparator);
            }
        }
        Extensions extensions = this.b.getTBSCertificate().getExtensions();
        if (extensions != null) {
            Enumeration oids = extensions.oids();
            if (oids.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
            }
            while (oids.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
                Extension extension = extensions.getExtension(aSN1ObjectIdentifier);
                if (extension.getExtnValue() != null) {
                    ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getExtnValue().getOctets());
                    stringBuffer.append("                       critical(");
                    stringBuffer.append(extension.isCritical());
                    stringBuffer.append(") ");
                    try {
                        if (aSN1ObjectIdentifier.equals(Extension.basicConstraints)) {
                            stringBuffer.append(BasicConstraints.getInstance(aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals(Extension.keyUsage)) {
                            stringBuffer.append(KeyUsage.getInstance(aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals(MiscObjectIdentifiers.netscapeCertType)) {
                            stringBuffer.append(new NetscapeCertType((DERBitString) aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals(MiscObjectIdentifiers.netscapeRevocationURL)) {
                            stringBuffer.append(new NetscapeRevocationURL((DERIA5String) aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else if (aSN1ObjectIdentifier.equals(MiscObjectIdentifiers.verisignCzagExtension)) {
                            stringBuffer.append(new VerisignCzagExtension((DERIA5String) aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        } else {
                            stringBuffer.append(aSN1ObjectIdentifier.getId());
                            stringBuffer.append(" value = ");
                            stringBuffer.append(ASN1Dump.dumpAsString(aSN1InputStream.readObject()));
                            stringBuffer.append(lineSeparator);
                        }
                    } catch (Exception unused) {
                        stringBuffer.append(aSN1ObjectIdentifier.getId());
                        stringBuffer.append(" value = ");
                        stringBuffer.append("*****");
                        stringBuffer.append(lineSeparator);
                    }
                } else {
                    stringBuffer.append(lineSeparator);
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String b2 = f.b(this.b.getSignatureAlgorithm());
        try {
            signature = this.a.createSignature(b2);
        } catch (Exception unused) {
            signature = Signature.getInstance(b2);
        }
        a(publicKey, signature);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() > getNotAfter().getTime()) {
            StringBuilder L = a.L("certificate expired on ");
            L.append(this.b.getEndDate().getTime());
            throw new CertificateExpiredException(L.toString());
        } else if (date.getTime() < getNotBefore().getTime()) {
            StringBuilder L2 = a.L("certificate not valid till ");
            L2.append(this.b.getStartDate().getTime());
            throw new CertificateNotYetValidException(L2.toString());
        }
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String b2 = f.b(this.b.getSignatureAlgorithm());
        if (str != null) {
            signature = Signature.getInstance(b2, str);
        } else {
            signature = Signature.getInstance(b2);
        }
        a(publicKey, signature);
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey publicKey, Provider provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature;
        String b2 = f.b(this.b.getSignatureAlgorithm());
        if (provider != null) {
            signature = Signature.getInstance(b2, provider);
        } else {
            signature = Signature.getInstance(b2);
        }
        a(publicKey, signature);
    }
}
