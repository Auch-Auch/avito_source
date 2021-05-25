package org.spongycastle.jce.provider;

import com.adjust.sdk.Constants;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;
public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    public static final ProviderConfiguration CONFIGURATION = new x6.e.d.a.a();
    public static final String PROVIDER_NAME = "SC";
    public static final Map a = new HashMap();
    public static final String[] b = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF"};
    public static final String[] c = {"SipHash", "Poly1305"};
    public static final String[] d = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624"};
    public static final String[] e = {"X509", "IES"};
    public static final String[] f = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM"};
    public static final String[] g = {"GOST3411", "Keccak", "MD2", "MD4", Constants.MD5, "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "DSTU7564"};
    public static final String[] h = {"BC", "BCFKS", "PKCS12"};
    public static final String[] i = {"DRBG"};

    public class a implements PrivilegedAction {
        public a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            BouncyCastleProvider bouncyCastleProvider = BouncyCastleProvider.this;
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.digest.", BouncyCastleProvider.g);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.b);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.c);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.d);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.e);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.f);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.keystore.", BouncyCastleProvider.h);
            bouncyCastleProvider.a("org.spongycastle.jcajce.provider.drbg.", BouncyCastleProvider.i);
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.sphincs256, new Sphincs256KeyFactorySpi());
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.newHope, new NHKeyFactorySpi());
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.xmss, new XMSSKeyFactorySpi());
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyFactorySpi());
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.mcEliece, new McElieceKeyFactorySpi());
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.mcElieceCca2, new McElieceCCA2KeyFactorySpi());
            bouncyCastleProvider.addKeyInfoConverter(PQCObjectIdentifiers.rainbow, new RainbowKeyFactorySpi());
            bouncyCastleProvider.put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
            bouncyCastleProvider.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
            bouncyCastleProvider.put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
            bouncyCastleProvider.put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
            bouncyCastleProvider.put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
            bouncyCastleProvider.put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
            bouncyCastleProvider.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
            bouncyCastleProvider.put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
            bouncyCastleProvider.put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
            bouncyCastleProvider.put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
            bouncyCastleProvider.put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
            bouncyCastleProvider.put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
            bouncyCastleProvider.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
            bouncyCastleProvider.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
            bouncyCastleProvider.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
            bouncyCastleProvider.put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
            bouncyCastleProvider.put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
            bouncyCastleProvider.put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
            bouncyCastleProvider.put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
            bouncyCastleProvider.put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
            bouncyCastleProvider.put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
            bouncyCastleProvider.put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
            bouncyCastleProvider.put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
            bouncyCastleProvider.put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
            bouncyCastleProvider.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
            return null;
        }
    }

    public BouncyCastleProvider() {
        super(PROVIDER_NAME, 1.58d, "BouncyCastle Security Provider v1.58");
        AccessController.doPrivileged(new a());
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        Map map = a;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(algorithm);
        }
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePrivate(privateKeyInfo);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        Map map = a;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(algorithm);
        }
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePublic(subjectPublicKeyInfo);
    }

    public final void a(String str, String[] strArr) {
        for (int i2 = 0; i2 != strArr.length; i2++) {
            StringBuilder L = a2.b.a.a.a.L(str);
            L.append(strArr[i2]);
            L.append("$Mappings");
            Class loadClass = ClassUtil.loadClass(BouncyCastleProvider.class, L.toString());
            if (loadClass != null) {
                try {
                    ((AlgorithmProvider) loadClass.newInstance()).configure(this);
                } catch (Exception e2) {
                    StringBuilder Q = a2.b.a.a.a.Q("cannot create instance of ", str);
                    Q.append(strArr[i2]);
                    Q.append("$Mappings : ");
                    Q.append(e2);
                    throw new InternalError(Q.toString());
                }
            }
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException(a2.b.a.a.a.e3("duplicate provider key (", str, ") found"));
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addAttributes(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            String e3 = a2.b.a.a.a.e3(str, " ", str2);
            if (!containsKey(e3)) {
                put(e3, map.get(str2));
            } else {
                throw new IllegalStateException(a2.b.a.a.a.e3("duplicate provider attribute key (", e3, ") found"));
            }
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        Map map = a;
        synchronized (map) {
            map.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + "." + str2)) {
            if (!containsKey("Alg.Alias." + str + "." + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void setParameter(String str, Object obj) {
        ProviderConfiguration providerConfiguration = CONFIGURATION;
        synchronized (providerConfiguration) {
            ((x6.e.d.a.a) providerConfiguration).a(str, obj);
        }
    }

    @Override // org.spongycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        addAlgorithm(str + "." + aSN1ObjectIdentifier, str2);
        addAlgorithm(str + ".OID." + aSN1ObjectIdentifier, str2);
    }
}
