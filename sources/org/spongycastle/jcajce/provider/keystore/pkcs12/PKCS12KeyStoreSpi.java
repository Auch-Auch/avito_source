package org.spongycastle.jcajce.provider.keystore.pkcs12;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12StoreParameter;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.JDKPKCS12StoreParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Properties;
import org.spongycastle.util.Strings;
public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    public static final c m = new c();
    public final JcaJceHelper a = new BCJcaJceHelper();
    public d b = new d(null);
    public Hashtable c = new Hashtable();
    public d d = new d(null);
    public Hashtable e = new Hashtable();
    public Hashtable f = new Hashtable();
    public CertificateFactory g;
    public ASN1ObjectIdentifier h;
    public ASN1ObjectIdentifier i;
    public AlgorithmIdentifier j = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    public int k = 1024;
    public int l = 20;
    public SecureRandom random = new SecureRandom();

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BouncyCastleProvider(), PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BCPKCS12KeyStore3DES() {
            /*
                r2 = this;
                org.spongycastle.jce.provider.BouncyCastleProvider r0 = new org.spongycastle.jce.provider.BouncyCastleProvider
                r0.<init>()
                org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC
                r2.<init>(r0, r1, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.BCPKCS12KeyStore3DES.<init>():void");
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super(null, PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DefPKCS12KeyStore3DES() {
            /*
                r2 = this;
                org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC
                r1 = 0
                r2.<init>(r1, r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.DefPKCS12KeyStore3DES.<init>():void");
        }
    }

    public static class c {
        public final Map a;

        public c() {
            HashMap hashMap = new HashMap();
            hashMap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
            hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
            hashMap.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
            hashMap.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
            hashMap.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
            hashMap.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
            hashMap.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
            hashMap.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
            hashMap.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
            this.a = Collections.unmodifiableMap(hashMap);
        }

        public int a(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.a.get(algorithmIdentifier.getAlgorithm());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    public static class d {
        public Hashtable a = new Hashtable();
        public Hashtable b = new Hashtable();

        public d(a aVar) {
        }

        public Object a(String str) {
            String str2 = (String) this.b.get(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.a.get(str2);
        }

        public Enumeration b() {
            return this.a.keys();
        }

        public void c(String str, Object obj) {
            String lowerCase = str == null ? null : Strings.toLowerCase(str);
            String str2 = (String) this.b.get(lowerCase);
            if (str2 != null) {
                this.a.remove(str2);
            }
            this.b.put(lowerCase, str);
            this.a.put(str, obj);
        }

        public Object d(String str) {
            String str2 = (String) this.b.remove(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.a.remove(str2);
        }
    }

    public PKCS12KeyStoreSpi(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.h = aSN1ObjectIdentifier;
        this.i = aSN1ObjectIdentifier2;
        if (provider != null) {
            try {
                this.g = CertificateFactory.getInstance("X.509", provider);
            } catch (Exception e2) {
                throw new IllegalArgumentException(a2.b.a.a.a.G2(e2, a2.b.a.a.a.L("can't create cert factory - ")));
            }
        } else {
            this.g = CertificateFactory.getInstance("X.509");
        }
    }

    public final byte[] a(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i2, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i2);
        Mac createMac = this.a.createMac(aSN1ObjectIdentifier.getId());
        createMac.init(new PKCS12Key(cArr, z), pBEParameterSpec);
        createMac.update(bArr2);
        return createMac.doFinal();
    }

    public final Cipher b(int i2, char[] cArr, AlgorithmIdentifier algorithmIdentifier) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException {
        SecretKey secretKey;
        PBES2Parameters instance = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        PBKDF2Params instance2 = PBKDF2Params.getInstance(instance.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier instance3 = AlgorithmIdentifier.getInstance(instance.getEncryptionScheme());
        SecretKeyFactory createSecretKeyFactory = this.a.createSecretKeyFactory(instance.getKeyDerivationFunc().getAlgorithm().getId());
        if (instance2.isDefaultPrf()) {
            secretKey = createSecretKeyFactory.generateSecret(new PBEKeySpec(cArr, instance2.getSalt(), e(instance2.getIterationCount()), m.a(instance3)));
        } else {
            secretKey = createSecretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, instance2.getSalt(), e(instance2.getIterationCount()), m.a(instance3), instance2.getPrf()));
        }
        Cipher instance4 = Cipher.getInstance(instance.getEncryptionScheme().getAlgorithm().getId());
        ASN1Encodable parameters = instance.getEncryptionScheme().getParameters();
        if (parameters instanceof ASN1OctetString) {
            instance4.init(i2, secretKey, new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets()));
        } else {
            GOST28147Parameters instance5 = GOST28147Parameters.getInstance(parameters);
            instance4.init(i2, secretKey, new GOST28147ParameterSpec(instance5.getEncryptionParamSet(), instance5.getIV()));
        }
        return instance4;
    }

    public final SubjectKeyIdentifier c(PublicKey publicKey) {
        try {
            SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
            Digest createSHA1 = DigestFactory.createSHA1();
            byte[] bArr = new byte[createSHA1.getDigestSize()];
            byte[] bytes = instance.getPublicKeyData().getBytes();
            createSHA1.update(bytes, 0, bytes.length);
            createSHA1.doFinal(bArr, 0);
            return new SubjectKeyIdentifier(bArr);
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        int i2 = z ? 1 : 2;
        if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
            try {
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance.getIV(), instance.getIterations().intValue());
                PKCS12Key pKCS12Key = new PKCS12Key(cArr, z2);
                Cipher createCipher = this.a.createCipher(algorithm.getId());
                createCipher.init(i2, pKCS12Key, pBEParameterSpec);
                return createCipher.doFinal(bArr);
            } catch (Exception e2) {
                throw new IOException(a2.b.a.a.a.G2(e2, a2.b.a.a.a.L("exception decrypting data - ")));
            }
        } else if (algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
            try {
                return b(i2, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e3) {
                throw new IOException(a2.b.a.a.a.G2(e3, a2.b.a.a.a.L("exception decrypting data - ")));
            }
        } else {
            throw new IOException("unknown PBE algorithm: " + algorithm);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x01ac A[Catch:{ CertificateEncodingException -> 0x024e }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01c2 A[Catch:{ CertificateEncodingException -> 0x024e }, LOOP:3: B:38:0x01bc->B:40:0x01c2, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.io.OutputStream r19, char[] r20, boolean r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1279
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.d(java.io.OutputStream, char[], boolean):void");
    }

    public final int e(BigInteger bigInteger) {
        int intValue = bigInteger.intValue();
        if (intValue >= 0) {
            BigInteger asBigInteger = Properties.asBigInteger("org.spongycastle.pkcs12.max_it_count");
            if (asBigInteger == null || asBigInteger.intValue() >= intValue) {
                return intValue;
            }
            StringBuilder M = a2.b.a.a.a.M("iteration count ", intValue, " greater than ");
            M.append(asBigInteger.intValue());
            throw new IllegalStateException(M.toString());
        }
        throw new IllegalStateException("negative iteration count found");
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration b2 = this.d.b();
        while (b2.hasMoreElements()) {
            hashtable.put(b2.nextElement(), "cert");
        }
        Enumeration b3 = this.b.b();
        while (b3.hasMoreElements()) {
            String str = (String) b3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return (this.d.a(str) == null && this.b.a(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        Key key = (Key) this.b.d(str);
        Certificate certificate = (Certificate) this.d.d(str);
        if (certificate != null) {
            this.e.remove(new b(this, certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.c.remove(str);
            if (str2 != null) {
                certificate = (Certificate) this.f.remove(str2);
            }
            if (certificate != null) {
                this.e.remove(new b(this, certificate.getPublicKey()));
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.d.a(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.c.get(str);
            if (str2 != null) {
                return (Certificate) this.f.get(str2);
            }
            return (Certificate) this.f.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.d.a.elements();
        Enumeration b2 = this.d.b();
        while (elements.hasMoreElements()) {
            String str = (String) b2.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.f.elements();
        Enumeration keys = this.f.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a9 A[SYNTHETIC] */
    @Override // java.security.KeyStoreSpi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00c9
            boolean r0 = r8.engineIsKeyEntry(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.security.cert.Certificate r9 = r8.engineGetCertificate(r9)
            if (r9 == 0) goto L_0x00c8
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
        L_0x0015:
            if (r9 == 0) goto L_0x00b4
            r2 = r9
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.Extension.authorityKeyIdentifier
            java.lang.String r3 = r3.getId()
            byte[] r3 = r2.getExtensionValue(r3)
            if (r3 == 0) goto L_0x0065
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x005a }
            r4.<init>(r3)     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3     // Catch:{ IOException -> 0x005a }
            byte[] r3 = r3.getOctets()     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x005a }
            r4.<init>(r3)     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r3 = org.spongycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r3)     // Catch:{ IOException -> 0x005a }
            byte[] r4 = r3.getKeyIdentifier()     // Catch:{ IOException -> 0x005a }
            if (r4 == 0) goto L_0x0065
            java.util.Hashtable r4 = r8.e     // Catch:{ IOException -> 0x005a }
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$b r5 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$b     // Catch:{ IOException -> 0x005a }
            byte[] r3 = r3.getKeyIdentifier()     // Catch:{ IOException -> 0x005a }
            r5.<init>(r8, r3)     // Catch:{ IOException -> 0x005a }
            java.lang.Object r3 = r4.get(r5)     // Catch:{ IOException -> 0x005a }
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3     // Catch:{ IOException -> 0x005a }
            goto L_0x0066
        L_0x005a:
            r9 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x0065:
            r3 = r1
        L_0x0066:
            if (r3 != 0) goto L_0x00a3
            java.security.Principal r4 = r2.getIssuerDN()
            java.security.Principal r5 = r2.getSubjectDN()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00a3
            java.util.Hashtable r5 = r8.e
            java.util.Enumeration r5 = r5.keys()
        L_0x007c:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto L_0x00a3
            java.util.Hashtable r6 = r8.e
            java.lang.Object r7 = r5.nextElement()
            java.lang.Object r6 = r6.get(r7)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            java.security.Principal r7 = r6.getSubjectDN()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x007c
            java.security.PublicKey r7 = r6.getPublicKey()     // Catch:{ Exception -> 0x00a1 }
            r2.verify(r7)     // Catch:{ Exception -> 0x00a1 }
            r3 = r6
            goto L_0x00a3
        L_0x00a1:
            goto L_0x007c
        L_0x00a3:
            boolean r2 = r0.contains(r9)
            if (r2 == 0) goto L_0x00ac
        L_0x00a9:
            r9 = r1
            goto L_0x0015
        L_0x00ac:
            r0.addElement(r9)
            if (r3 == r9) goto L_0x00a9
            r9 = r3
            goto L_0x0015
        L_0x00b4:
            int r9 = r0.size()
            java.security.cert.Certificate[] r1 = new java.security.cert.Certificate[r9]
            r2 = 0
        L_0x00bb:
            if (r2 == r9) goto L_0x00c8
            java.lang.Object r3 = r0.elementAt(r2)
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x00bb
        L_0x00c8:
            return r1
        L_0x00c9:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "null alias passed to getCertificateChain."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        Objects.requireNonNull(str, "alias == null");
        if (this.b.a(str) == null && this.d.a(str) == null) {
            return null;
        }
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.b.a(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.d.a(str) != null && this.b.a(str) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.b.a(str) != null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:201:0x01e3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x04a5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00eb  */
    @Override // java.security.KeyStoreSpi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineLoad(java.io.InputStream r20, char[] r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1492
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineLoad(java.io.InputStream, char[]):void");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.b.a(str) == null) {
            this.d.c(str, certificate);
            this.e.put(new b(this, certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException(a2.b.a.a.a.e3("There is a key entry with the name ", str, "."));
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration b2 = this.d.b();
        while (b2.hasMoreElements()) {
            hashtable.put(b2.nextElement(), "cert");
        }
        Enumeration b3 = this.b.b();
        while (b3.hasMoreElements()) {
            String str = (String) b3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] cArr;
        if (loadStoreParameter != null) {
            boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
            if (z || (loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
                if (z) {
                    pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
                } else {
                    JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
                    pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.getOutputStream(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.isUseDEREncoding());
                }
                KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
                if (protectionParameter == null) {
                    cArr = null;
                } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
                    cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                } else {
                    StringBuilder L = a2.b.a.a.a.L("No support for protection parameter of type ");
                    L.append(protectionParameter.getClass().getName());
                    throw new IllegalArgumentException(L.toString());
                }
                d(pKCS12StoreParameter.getOutputStream(), cArr, pKCS12StoreParameter.isForDEREncoding());
                return;
            }
            StringBuilder L2 = a2.b.a.a.a.L("No support for 'param' of type ");
            L2.append(loadStoreParameter.getClass().getName());
            throw new IllegalArgumentException(L2.toString());
        }
        throw new IllegalArgumentException("'param' arg cannot be null");
    }

    @Override // org.spongycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws IOException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance.getIV(), e(instance.getIterations()));
                Cipher createCipher = this.a.createCipher(algorithm.getId());
                createCipher.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
                return (PrivateKey) createCipher.unwrap(bArr, "", 2);
            } else if (algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
                return (PrivateKey) b(4, cArr, algorithmIdentifier).unwrap(bArr, "", 2);
            } else {
                throw new IOException("exception unwrapping private key - cannot recognise: " + algorithm);
            }
        } catch (Exception e2) {
            throw new IOException(a2.b.a.a.a.G2(e2, a2.b.a.a.a.L("exception unwrapping private key - ")));
        }
    }

    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws IOException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory createSecretKeyFactory = this.a.createSecretKeyFactory(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher createCipher = this.a.createCipher(str);
            createCipher.init(3, createSecretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return createCipher.wrap(key);
        } catch (Exception e2) {
            throw new IOException(a2.b.a.a.a.G2(e2, a2.b.a.a.a.L("exception encrypting data - ")));
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        boolean z = key instanceof PrivateKey;
        if (!z) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        } else if (!z || certificateArr != null) {
            if (this.b.a(str) != null) {
                engineDeleteEntry(str);
            }
            this.b.c(str, key);
            if (certificateArr != null) {
                this.d.c(str, certificateArr[0]);
                for (int i2 = 0; i2 != certificateArr.length; i2++) {
                    this.e.put(new b(this, certificateArr[i2].getPublicKey()), certificateArr[i2]);
                }
            }
        } else {
            throw new KeyStoreException("no certificate chain for private key");
        }
    }

    public class b {
        public byte[] a;

        public b(PKCS12KeyStoreSpi pKCS12KeyStoreSpi, PublicKey publicKey) {
            c cVar = PKCS12KeyStoreSpi.m;
            this.a = pKCS12KeyStoreSpi.c(publicKey).getKeyIdentifier();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return Arrays.areEqual(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public b(PKCS12KeyStoreSpi pKCS12KeyStoreSpi, byte[] bArr) {
            this.a = bArr;
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        d(outputStream, cArr, false);
    }
}
