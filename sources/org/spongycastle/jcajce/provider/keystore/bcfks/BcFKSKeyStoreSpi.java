package org.spongycastle.jcajce.provider.keystore.bcfks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.bc.EncryptedObjectStoreData;
import org.spongycastle.asn1.bc.EncryptedPrivateKeyData;
import org.spongycastle.asn1.bc.EncryptedSecretKeyData;
import org.spongycastle.asn1.bc.ObjectData;
import org.spongycastle.asn1.bc.ObjectDataSequence;
import org.spongycastle.asn1.bc.ObjectStore;
import org.spongycastle.asn1.bc.ObjectStoreData;
import org.spongycastle.asn1.bc.ObjectStoreIntegrityCheck;
import org.spongycastle.asn1.bc.PbkdMacIntegrityCheck;
import org.spongycastle.asn1.bc.SecretKeyData;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.EncryptionScheme;
import org.spongycastle.asn1.pkcs.KeyDerivationFunc;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
public class BcFKSKeyStoreSpi extends KeyStoreSpi {
    public static final Map<String, ASN1ObjectIdentifier> h;
    public static final Map<ASN1ObjectIdentifier, String> i;
    public static final BigInteger j = BigInteger.valueOf(0);
    public static final BigInteger k = BigInteger.valueOf(1);
    public static final BigInteger l = BigInteger.valueOf(2);
    public static final BigInteger m = BigInteger.valueOf(3);
    public static final BigInteger n = BigInteger.valueOf(4);
    public final BouncyCastleProvider a;
    public final Map<String, ObjectData> b = new HashMap();
    public final Map<String, PrivateKey> c = new HashMap();
    public AlgorithmIdentifier d;
    public KeyDerivationFunc e;
    public Date f;
    public Date g;

    public static class Def extends BcFKSKeyStoreSpi {
        public Def() {
            super(null);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return BcFKSKeyStoreSpi.super.engineAliases();
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return BcFKSKeyStoreSpi.super.engineContainsAlias(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineDeleteEntry(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return BcFKSKeyStoreSpi.super.engineGetCertificate(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return BcFKSKeyStoreSpi.super.engineGetCertificateAlias(certificate);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return BcFKSKeyStoreSpi.super.engineGetCertificateChain(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return BcFKSKeyStoreSpi.super.engineGetCreationDate(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            return BcFKSKeyStoreSpi.super.engineGetKey(str, cArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return BcFKSKeyStoreSpi.super.engineIsCertificateEntry(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return BcFKSKeyStoreSpi.super.engineIsKeyEntry(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
            BcFKSKeyStoreSpi.super.engineLoad(inputStream, cArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return BcFKSKeyStoreSpi.super.engineSize();
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
            BcFKSKeyStoreSpi.super.engineStore(outputStream, cArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineSetKeyEntry(str, bArr, certificateArr);
        }
    }

    public static class Std extends BcFKSKeyStoreSpi {
        public Std() {
            super(new BouncyCastleProvider());
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return BcFKSKeyStoreSpi.super.engineAliases();
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return BcFKSKeyStoreSpi.super.engineContainsAlias(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineDeleteEntry(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return BcFKSKeyStoreSpi.super.engineGetCertificate(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return BcFKSKeyStoreSpi.super.engineGetCertificateAlias(certificate);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return BcFKSKeyStoreSpi.super.engineGetCertificateChain(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return BcFKSKeyStoreSpi.super.engineGetCreationDate(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            return BcFKSKeyStoreSpi.super.engineGetKey(str, cArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return BcFKSKeyStoreSpi.super.engineIsCertificateEntry(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return BcFKSKeyStoreSpi.super.engineIsKeyEntry(str);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
            BcFKSKeyStoreSpi.super.engineLoad(inputStream, cArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return BcFKSKeyStoreSpi.super.engineSize();
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
            BcFKSKeyStoreSpi.super.engineStore(outputStream, cArr);
        }

        @Override // org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            BcFKSKeyStoreSpi.super.engineSetKeyEntry(str, bArr, certificateArr);
        }
    }

    public class a implements Enumeration {
        public final /* synthetic */ Iterator a;

        public a(BcFKSKeyStoreSpi bcFKSKeyStoreSpi, Iterator it) {
            this.a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.a.next();
        }
    }

    public static class b extends KeyStoreException {
        public final Throwable a;

        public b(String str, Throwable th) {
            super(str);
            this.a = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.a;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        h = hashMap;
        HashMap hashMap2 = new HashMap();
        i = hashMap2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.desEDE;
        hashMap.put("DESEDE", aSN1ObjectIdentifier);
        hashMap.put("TRIPLEDES", aSN1ObjectIdentifier);
        hashMap.put("TDEA", aSN1ObjectIdentifier);
        hashMap.put("HMACSHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
        hashMap.put("HMACSHA224", PKCSObjectIdentifiers.id_hmacWithSHA224);
        hashMap.put("HMACSHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
        hashMap.put("HMACSHA384", PKCSObjectIdentifiers.id_hmacWithSHA384);
        hashMap.put("HMACSHA512", PKCSObjectIdentifiers.id_hmacWithSHA512);
        hashMap2.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        hashMap2.put(X9ObjectIdentifiers.id_ecPublicKey, "EC");
        hashMap2.put(OIWObjectIdentifiers.elGamalAlgorithm, "DH");
        hashMap2.put(PKCSObjectIdentifiers.dhKeyAgreement, "DH");
        hashMap2.put(X9ObjectIdentifiers.id_dsa, "DSA");
    }

    public BcFKSKeyStoreSpi(BouncyCastleProvider bouncyCastleProvider) {
        this.a = bouncyCastleProvider;
    }

    public final byte[] a(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, KeyDerivationFunc keyDerivationFunc, char[] cArr) throws NoSuchAlgorithmException, IOException {
        Mac mac;
        String id = algorithmIdentifier.getAlgorithm().getId();
        BouncyCastleProvider bouncyCastleProvider = this.a;
        if (bouncyCastleProvider != null) {
            mac = Mac.getInstance(id, bouncyCastleProvider);
        } else {
            mac = Mac.getInstance(id);
        }
        try {
            if (cArr == null) {
                cArr = new char[0];
            }
            mac.init(new SecretKeySpec(f(keyDerivationFunc, "INTEGRITY_CHECK", cArr), id));
            return mac.doFinal(bArr);
        } catch (InvalidKeyException e2) {
            StringBuilder L = a2.b.a.a.a.L("Cannot set up MAC calculation: ");
            L.append(e2.getMessage());
            throw new IOException(L.toString());
        }
    }

    public final EncryptedPrivateKeyData b(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo, Certificate[] certificateArr) throws CertificateEncodingException {
        org.spongycastle.asn1.x509.Certificate[] certificateArr2 = new org.spongycastle.asn1.x509.Certificate[certificateArr.length];
        for (int i2 = 0; i2 != certificateArr.length; i2++) {
            certificateArr2[i2] = org.spongycastle.asn1.x509.Certificate.getInstance(certificateArr[i2].getEncoded());
        }
        return new EncryptedPrivateKeyData(encryptedPrivateKeyInfo, certificateArr2);
    }

    public final Certificate c(Object obj) {
        BouncyCastleProvider bouncyCastleProvider = this.a;
        if (bouncyCastleProvider != null) {
            try {
                return CertificateFactory.getInstance("X.509", bouncyCastleProvider).generateCertificate(new ByteArrayInputStream(org.spongycastle.asn1.x509.Certificate.getInstance(obj).getEncoded()));
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(org.spongycastle.asn1.x509.Certificate.getInstance(obj).getEncoded()));
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public final byte[] d(String str, AlgorithmIdentifier algorithmIdentifier, char[] cArr, byte[] bArr) throws IOException {
        AlgorithmParameters algorithmParameters;
        Cipher cipher;
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_PBES2)) {
            PBES2Parameters instance = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
            EncryptionScheme encryptionScheme = instance.getEncryptionScheme();
            if (encryptionScheme.getAlgorithm().equals(NISTObjectIdentifiers.id_aes256_CCM)) {
                try {
                    CCMParameters instance2 = CCMParameters.getInstance(encryptionScheme.getParameters());
                    BouncyCastleProvider bouncyCastleProvider = this.a;
                    if (bouncyCastleProvider == null) {
                        cipher = Cipher.getInstance("AES/CCM/NoPadding");
                        algorithmParameters = AlgorithmParameters.getInstance("CCM");
                    } else {
                        cipher = Cipher.getInstance("AES/CCM/NoPadding", bouncyCastleProvider);
                        algorithmParameters = AlgorithmParameters.getInstance("CCM", this.a);
                    }
                    algorithmParameters.init(instance2.getEncoded());
                    KeyDerivationFunc keyDerivationFunc = instance.getKeyDerivationFunc();
                    if (cArr == null) {
                        cArr = new char[0];
                    }
                    cipher.init(2, new SecretKeySpec(f(keyDerivationFunc, str, cArr), "AES"), algorithmParameters);
                    return cipher.doFinal(bArr);
                } catch (Exception e2) {
                    throw new IOException(e2.toString());
                }
            } else {
                throw new IOException("BCFKS KeyStore cannot recognize protection encryption algorithm.");
            }
        } else {
            throw new IOException("BCFKS KeyStore cannot recognize protection algorithm.");
        }
    }

    public final Date e(ObjectData objectData, Date date) {
        try {
            return objectData.getCreationDate().getDate();
        } catch (ParseException unused) {
            return date;
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        return new a(this, new HashSet(this.b.keySet()).iterator());
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        Objects.requireNonNull(str, "alias value is null");
        return this.b.containsKey(str);
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        if (this.b.get(str) != null) {
            this.c.remove(str);
            this.b.remove(str);
            this.g = new Date();
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        ObjectData objectData = this.b.get(str);
        if (objectData == null) {
            return null;
        }
        if (objectData.getType().equals(k) || objectData.getType().equals(m)) {
            return c(EncryptedPrivateKeyData.getInstance(objectData.getData()).getCertificateChain()[0]);
        }
        if (objectData.getType().equals(j)) {
            return c(objectData.getData());
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        try {
            byte[] encoded = certificate.getEncoded();
            for (String str : this.b.keySet()) {
                ObjectData objectData = this.b.get(str);
                if (objectData.getType().equals(j)) {
                    if (Arrays.areEqual(objectData.getData(), encoded)) {
                        return str;
                    }
                } else if (objectData.getType().equals(k) || objectData.getType().equals(m)) {
                    try {
                        if (Arrays.areEqual(EncryptedPrivateKeyData.getInstance(objectData.getData()).getCertificateChain()[0].toASN1Primitive().getEncoded(), encoded)) {
                            return str;
                        }
                    } catch (IOException unused) {
                        continue;
                    }
                }
            }
        } catch (CertificateEncodingException unused2) {
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.security.cert.X509Certificate[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        ObjectData objectData = this.b.get(str);
        if (objectData == null) {
            return null;
        }
        if (!(objectData.getType().equals(k) || objectData.getType().equals(m))) {
            return null;
        }
        org.spongycastle.asn1.x509.Certificate[] certificateChain = EncryptedPrivateKeyData.getInstance(objectData.getData()).getCertificateChain();
        int length = certificateChain.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i2 = 0; i2 != length; i2++) {
            x509CertificateArr[i2] = c(certificateChain[i2]);
        }
        return x509CertificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        ObjectData objectData = this.b.get(str);
        if (objectData == null) {
            return null;
        }
        try {
            return objectData.getLastModifiedDate().getDate();
        } catch (ParseException unused) {
            return new Date();
        }
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyFactory keyFactory;
        SecretKeyFactory secretKeyFactory;
        ObjectData objectData = this.b.get(str);
        if (objectData == null) {
            return null;
        }
        if (objectData.getType().equals(k) || objectData.getType().equals(m)) {
            PrivateKey privateKey = this.c.get(str);
            if (privateKey != null) {
                return privateKey;
            }
            EncryptedPrivateKeyInfo instance = EncryptedPrivateKeyInfo.getInstance(EncryptedPrivateKeyData.getInstance(objectData.getData()).getEncryptedPrivateKeyInfo());
            try {
                PrivateKeyInfo instance2 = PrivateKeyInfo.getInstance(d("PRIVATE_KEY_ENCRYPTION", instance.getEncryptionAlgorithm(), cArr, instance.getEncryptedData()));
                if (this.a != null) {
                    keyFactory = KeyFactory.getInstance(instance2.getPrivateKeyAlgorithm().getAlgorithm().getId(), this.a);
                } else {
                    ASN1ObjectIdentifier algorithm = instance2.getPrivateKeyAlgorithm().getAlgorithm();
                    String str2 = i.get(algorithm);
                    if (str2 == null) {
                        str2 = algorithm.getId();
                    }
                    keyFactory = KeyFactory.getInstance(str2);
                }
                PrivateKey generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(instance2.getEncoded()));
                this.c.put(str, generatePrivate);
                return generatePrivate;
            } catch (Exception e2) {
                throw new UnrecoverableKeyException(a2.b.a.a.a.F2(e2, a2.b.a.a.a.R("BCFKS KeyStore unable to recover private key (", str, "): ")));
            }
        } else if (objectData.getType().equals(l) || objectData.getType().equals(n)) {
            EncryptedSecretKeyData instance3 = EncryptedSecretKeyData.getInstance(objectData.getData());
            try {
                SecretKeyData instance4 = SecretKeyData.getInstance(d("SECRET_KEY_ENCRYPTION", instance3.getKeyEncryptionAlgorithm(), cArr, instance3.getEncryptedKeyData()));
                if (this.a != null) {
                    secretKeyFactory = SecretKeyFactory.getInstance(instance4.getKeyAlgorithm().getId(), this.a);
                } else {
                    secretKeyFactory = SecretKeyFactory.getInstance(instance4.getKeyAlgorithm().getId());
                }
                return secretKeyFactory.generateSecret(new SecretKeySpec(instance4.getKeyBytes(), instance4.getKeyAlgorithm().getId()));
            } catch (Exception e3) {
                throw new UnrecoverableKeyException(a2.b.a.a.a.F2(e3, a2.b.a.a.a.R("BCFKS KeyStore unable to recover secret key (", str, "): ")));
            }
        } else {
            throw new UnrecoverableKeyException(a2.b.a.a.a.e3("BCFKS KeyStore unable to recover secret key (", str, "): type not recognized"));
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        ObjectData objectData = this.b.get(str);
        if (objectData != null) {
            return objectData.getType().equals(j);
        }
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        ObjectData objectData = this.b.get(str);
        if (objectData == null) {
            return false;
        }
        BigInteger type = objectData.getType();
        if (type.equals(k) || type.equals(l) || type.equals(m) || type.equals(n)) {
            return true;
        }
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        ObjectStoreData objectStoreData;
        this.b.clear();
        this.c.clear();
        this.f = null;
        this.g = null;
        this.d = null;
        if (inputStream == null) {
            Date date = new Date();
            this.f = date;
            this.g = date;
            this.d = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
            this.e = g(64);
            return;
        }
        ObjectStore instance = ObjectStore.getInstance(new ASN1InputStream(inputStream).readObject());
        ObjectStoreIntegrityCheck integrityCheck = instance.getIntegrityCheck();
        if (integrityCheck.getType() == 0) {
            PbkdMacIntegrityCheck instance2 = PbkdMacIntegrityCheck.getInstance(integrityCheck.getIntegrityCheck());
            this.d = instance2.getMacAlgorithm();
            this.e = instance2.getPbkdAlgorithm();
            if (Arrays.constantTimeAreEqual(a(instance.getStoreData().toASN1Primitive().getEncoded(), instance2.getMacAlgorithm(), instance2.getPbkdAlgorithm(), cArr), instance2.getMac())) {
                ASN1Encodable storeData = instance.getStoreData();
                if (storeData instanceof EncryptedObjectStoreData) {
                    EncryptedObjectStoreData encryptedObjectStoreData = (EncryptedObjectStoreData) storeData;
                    objectStoreData = ObjectStoreData.getInstance(d("STORE_ENCRYPTION", encryptedObjectStoreData.getEncryptionAlgorithm(), cArr, encryptedObjectStoreData.getEncryptedContent().getOctets()));
                } else {
                    objectStoreData = ObjectStoreData.getInstance(storeData);
                }
                try {
                    this.f = objectStoreData.getCreationDate().getDate();
                    this.g = objectStoreData.getLastModifiedDate().getDate();
                    if (objectStoreData.getIntegrityAlgorithm().equals(this.d)) {
                        Iterator<ASN1Encodable> it = objectStoreData.getObjectDataSequence().iterator();
                        while (it.hasNext()) {
                            ObjectData instance3 = ObjectData.getInstance(it.next());
                            this.b.put(instance3.getIdentifier(), instance3);
                        }
                        return;
                    }
                    throw new IOException("BCFKS KeyStore storeData integrity algorithm does not match store integrity algorithm.");
                } catch (ParseException unused) {
                    throw new IOException("BCFKS KeyStore unable to parse store data information.");
                }
            } else {
                throw new IOException("BCFKS KeyStore corrupted: MAC calculation failed.");
            }
        } else {
            throw new IOException("BCFKS KeyStore unable to recognize integrity check.");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        Date date;
        ObjectData objectData = this.b.get(str);
        Date date2 = new Date();
        if (objectData == null) {
            date = date2;
        } else if (objectData.getType().equals(j)) {
            date = e(objectData, date2);
        } else {
            throw new KeyStoreException(a2.b.a.a.a.c3("BCFKS KeyStore already has a key entry with alias ", str));
        }
        try {
            this.b.put(str, new ObjectData(j, str, date, date2, certificate.getEncoded(), null));
            this.g = date2;
        } catch (CertificateEncodingException e2) {
            StringBuilder L = a2.b.a.a.a.L("BCFKS KeyStore unable to handle certificate: ");
            L.append(e2.getMessage());
            throw new b(L.toString(), e2);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        Cipher cipher;
        byte[] bArr;
        Cipher cipher2;
        Date date = new Date();
        ObjectData objectData = this.b.get(str);
        Date e2 = objectData != null ? e(objectData, date) : date;
        this.c.remove(str);
        if (key instanceof PrivateKey) {
            if (certificateArr != null) {
                try {
                    byte[] encoded = key.getEncoded();
                    KeyDerivationFunc g2 = g(32);
                    if (cArr == null) {
                        cArr = new char[0];
                    }
                    byte[] f2 = f(g2, "PRIVATE_KEY_ENCRYPTION", cArr);
                    BouncyCastleProvider bouncyCastleProvider = this.a;
                    if (bouncyCastleProvider == null) {
                        cipher2 = Cipher.getInstance("AES/CCM/NoPadding");
                    } else {
                        cipher2 = Cipher.getInstance("AES/CCM/NoPadding", bouncyCastleProvider);
                    }
                    cipher2.init(1, new SecretKeySpec(f2, "AES"));
                    this.b.put(str, new ObjectData(k, str, e2, date, b(new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(g2, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(cipher2.getParameters().getEncoded())))), cipher2.doFinal(encoded)), certificateArr).getEncoded(), null));
                } catch (Exception e3) {
                    throw new b(a2.b.a.a.a.G2(e3, a2.b.a.a.a.L("BCFKS KeyStore exception storing private key: ")), e3);
                }
            } else {
                throw new KeyStoreException("BCFKS KeyStore requires a certificate chain for private key storage.");
            }
        } else if (!(key instanceof SecretKey)) {
            throw new KeyStoreException("BCFKS KeyStore unable to recognize key.");
        } else if (certificateArr == null) {
            try {
                byte[] encoded2 = key.getEncoded();
                KeyDerivationFunc g3 = g(32);
                if (cArr == null) {
                    cArr = new char[0];
                }
                byte[] f3 = f(g3, "SECRET_KEY_ENCRYPTION", cArr);
                BouncyCastleProvider bouncyCastleProvider2 = this.a;
                if (bouncyCastleProvider2 == null) {
                    cipher = Cipher.getInstance("AES/CCM/NoPadding");
                } else {
                    cipher = Cipher.getInstance("AES/CCM/NoPadding", bouncyCastleProvider2);
                }
                cipher.init(1, new SecretKeySpec(f3, "AES"));
                String upperCase = Strings.toUpperCase(key.getAlgorithm());
                if (upperCase.indexOf("AES") > -1) {
                    bArr = cipher.doFinal(new SecretKeyData(NISTObjectIdentifiers.aes, encoded2).getEncoded());
                } else {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = h.get(upperCase);
                    if (aSN1ObjectIdentifier != null) {
                        bArr = cipher.doFinal(new SecretKeyData(aSN1ObjectIdentifier, encoded2).getEncoded());
                    } else {
                        throw new KeyStoreException("BCFKS KeyStore cannot recognize secret key (" + upperCase + ") for storage.");
                    }
                }
                this.b.put(str, new ObjectData(l, str, e2, date, new EncryptedSecretKeyData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(g3, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(cipher.getParameters().getEncoded())))), bArr).getEncoded(), null));
            } catch (Exception e4) {
                throw new b(a2.b.a.a.a.G2(e4, a2.b.a.a.a.L("BCFKS KeyStore exception storing private key: ")), e4);
            }
        } else {
            throw new KeyStoreException("BCFKS KeyStore cannot store certificate chain with secret key.");
        }
        this.g = date;
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.b.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        Cipher cipher;
        ObjectData[] objectDataArr = (ObjectData[]) this.b.values().toArray(new ObjectData[this.b.size()]);
        KeyDerivationFunc g2 = g(32);
        byte[] f2 = f(g2, "STORE_ENCRYPTION", cArr != null ? cArr : new char[0]);
        ObjectStoreData objectStoreData = new ObjectStoreData(this.d, this.f, this.g, new ObjectDataSequence(objectDataArr), null);
        try {
            BouncyCastleProvider bouncyCastleProvider = this.a;
            if (bouncyCastleProvider == null) {
                cipher = Cipher.getInstance("AES/CCM/NoPadding");
            } else {
                cipher = Cipher.getInstance("AES/CCM/NoPadding", bouncyCastleProvider);
            }
            cipher.init(1, new SecretKeySpec(f2, "AES"));
            EncryptedObjectStoreData encryptedObjectStoreData = new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(g2, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(cipher.getParameters().getEncoded())))), cipher.doFinal(objectStoreData.getEncoded()));
            PBKDF2Params instance = PBKDF2Params.getInstance(this.e.getParameters());
            byte[] bArr = new byte[instance.getSalt().length];
            new SecureRandom().nextBytes(bArr);
            this.e = new KeyDerivationFunc(this.e.getAlgorithm(), new PBKDF2Params(bArr, instance.getIterationCount().intValue(), instance.getKeyLength().intValue(), instance.getPrf()));
            outputStream.write(new ObjectStore(encryptedObjectStoreData, new ObjectStoreIntegrityCheck(new PbkdMacIntegrityCheck(this.d, this.e, a(encryptedObjectStoreData.getEncoded(), this.d, this.e, cArr)))).getEncoded());
            outputStream.flush();
        } catch (NoSuchPaddingException e2) {
            throw new NoSuchAlgorithmException(e2.toString());
        } catch (BadPaddingException e3) {
            throw new IOException(e3.toString());
        } catch (IllegalBlockSizeException e4) {
            throw new IOException(e4.toString());
        } catch (InvalidKeyException e5) {
            throw new IOException(e5.toString());
        }
    }

    public final byte[] f(KeyDerivationFunc keyDerivationFunc, String str, char[] cArr) throws IOException {
        byte[] PKCS12PasswordToBytes = PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        byte[] PKCS12PasswordToBytes2 = PBEParametersGenerator.PKCS12PasswordToBytes(str.toCharArray());
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA512Digest());
        if (keyDerivationFunc.getAlgorithm().equals(PKCSObjectIdentifiers.id_PBKDF2)) {
            PBKDF2Params instance = PBKDF2Params.getInstance(keyDerivationFunc.getParameters());
            if (instance.getPrf().getAlgorithm().equals(PKCSObjectIdentifiers.id_hmacWithSHA512)) {
                pKCS5S2ParametersGenerator.init(Arrays.concatenate(PKCS12PasswordToBytes, PKCS12PasswordToBytes2), instance.getSalt(), instance.getIterationCount().intValue());
                return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(instance.getKeyLength().intValue() * 8)).getKey();
            }
            throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD PRF.");
        }
        throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD.");
    }

    public final KeyDerivationFunc g(int i2) {
        byte[] bArr = new byte[64];
        new SecureRandom().nextBytes(bArr);
        return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr, 1024, i2, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE)));
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        Date date = new Date();
        ObjectData objectData = this.b.get(str);
        Date e2 = objectData != null ? e(objectData, date) : date;
        if (certificateArr != null) {
            try {
                EncryptedPrivateKeyInfo instance = EncryptedPrivateKeyInfo.getInstance(bArr);
                try {
                    this.c.remove(str);
                    this.b.put(str, new ObjectData(m, str, e2, date, b(instance, certificateArr).getEncoded(), null));
                } catch (Exception e3) {
                    throw new b(a2.b.a.a.a.G2(e3, a2.b.a.a.a.L("BCFKS KeyStore exception storing protected private key: ")), e3);
                }
            } catch (Exception e4) {
                throw new b("BCFKS KeyStore private key encoding must be an EncryptedPrivateKeyInfo.", e4);
            }
        } else {
            try {
                this.b.put(str, new ObjectData(n, str, e2, date, bArr, null));
            } catch (Exception e5) {
                throw new b(a2.b.a.a.a.G2(e5, a2.b.a.a.a.L("BCFKS KeyStore exception storing protected private key: ")), e5);
            }
        }
        this.g = date;
    }
}
