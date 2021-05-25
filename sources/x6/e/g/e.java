package x6.e.g;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.util.Strings;
public class e {
    public static Hashtable a = new Hashtable();
    public static Hashtable b = new Hashtable();
    public static Set c = new HashSet();

    public static class a {
        public Object a;
        public Provider b;

        public a(Object obj, Provider provider) {
            this.a = obj;
            this.b = provider;
        }
    }

    static {
        Hashtable hashtable = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.md2WithRSAEncryption;
        hashtable.put("MD2WITHRSAENCRYPTION", aSN1ObjectIdentifier);
        a.put("MD2WITHRSA", aSN1ObjectIdentifier);
        Hashtable hashtable2 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.md5WithRSAEncryption;
        hashtable2.put("MD5WITHRSAENCRYPTION", aSN1ObjectIdentifier2);
        a.put("MD5WITHRSA", aSN1ObjectIdentifier2);
        Hashtable hashtable3 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.sha1WithRSAEncryption;
        hashtable3.put("SHA1WITHRSAENCRYPTION", aSN1ObjectIdentifier3);
        a.put("SHA1WITHRSA", aSN1ObjectIdentifier3);
        Hashtable hashtable4 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.sha224WithRSAEncryption;
        hashtable4.put("SHA224WITHRSAENCRYPTION", aSN1ObjectIdentifier4);
        a.put("SHA224WITHRSA", aSN1ObjectIdentifier4);
        Hashtable hashtable5 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.sha256WithRSAEncryption;
        hashtable5.put("SHA256WITHRSAENCRYPTION", aSN1ObjectIdentifier5);
        a.put("SHA256WITHRSA", aSN1ObjectIdentifier5);
        Hashtable hashtable6 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.sha384WithRSAEncryption;
        hashtable6.put("SHA384WITHRSAENCRYPTION", aSN1ObjectIdentifier6);
        a.put("SHA384WITHRSA", aSN1ObjectIdentifier6);
        Hashtable hashtable7 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.sha512WithRSAEncryption;
        hashtable7.put("SHA512WITHRSAENCRYPTION", aSN1ObjectIdentifier7);
        a.put("SHA512WITHRSA", aSN1ObjectIdentifier7);
        Hashtable hashtable8 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.id_RSASSA_PSS;
        hashtable8.put("SHA1WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        a.put("SHA224WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        a.put("SHA256WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        a.put("SHA384WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        a.put("SHA512WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        Hashtable hashtable9 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160;
        hashtable9.put("RIPEMD160WITHRSAENCRYPTION", aSN1ObjectIdentifier9);
        a.put("RIPEMD160WITHRSA", aSN1ObjectIdentifier9);
        Hashtable hashtable10 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128;
        hashtable10.put("RIPEMD128WITHRSAENCRYPTION", aSN1ObjectIdentifier10);
        a.put("RIPEMD128WITHRSA", aSN1ObjectIdentifier10);
        Hashtable hashtable11 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256;
        hashtable11.put("RIPEMD256WITHRSAENCRYPTION", aSN1ObjectIdentifier11);
        a.put("RIPEMD256WITHRSA", aSN1ObjectIdentifier11);
        Hashtable hashtable12 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = X9ObjectIdentifiers.id_dsa_with_sha1;
        hashtable12.put("SHA1WITHDSA", aSN1ObjectIdentifier12);
        a.put("DSAWITHSHA1", aSN1ObjectIdentifier12);
        Hashtable hashtable13 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.dsa_with_sha224;
        hashtable13.put("SHA224WITHDSA", aSN1ObjectIdentifier13);
        Hashtable hashtable14 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.dsa_with_sha256;
        hashtable14.put("SHA256WITHDSA", aSN1ObjectIdentifier14);
        Hashtable hashtable15 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.dsa_with_sha384;
        hashtable15.put("SHA384WITHDSA", aSN1ObjectIdentifier15);
        Hashtable hashtable16 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NISTObjectIdentifiers.dsa_with_sha512;
        hashtable16.put("SHA512WITHDSA", aSN1ObjectIdentifier16);
        Hashtable hashtable17 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = X9ObjectIdentifiers.ecdsa_with_SHA1;
        hashtable17.put("SHA1WITHECDSA", aSN1ObjectIdentifier17);
        a.put("ECDSAWITHSHA1", aSN1ObjectIdentifier17);
        Hashtable hashtable18 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = X9ObjectIdentifiers.ecdsa_with_SHA224;
        hashtable18.put("SHA224WITHECDSA", aSN1ObjectIdentifier18);
        Hashtable hashtable19 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = X9ObjectIdentifiers.ecdsa_with_SHA256;
        hashtable19.put("SHA256WITHECDSA", aSN1ObjectIdentifier19);
        Hashtable hashtable20 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = X9ObjectIdentifiers.ecdsa_with_SHA384;
        hashtable20.put("SHA384WITHECDSA", aSN1ObjectIdentifier20);
        Hashtable hashtable21 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = X9ObjectIdentifiers.ecdsa_with_SHA512;
        hashtable21.put("SHA512WITHECDSA", aSN1ObjectIdentifier21);
        Hashtable hashtable22 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94;
        hashtable22.put("GOST3411WITHGOST3410", aSN1ObjectIdentifier22);
        a.put("GOST3411WITHGOST3410-94", aSN1ObjectIdentifier22);
        Hashtable hashtable23 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001;
        hashtable23.put("GOST3411WITHECGOST3410", aSN1ObjectIdentifier23);
        a.put("GOST3411WITHECGOST3410-2001", aSN1ObjectIdentifier23);
        a.put("GOST3411WITHGOST3410-2001", aSN1ObjectIdentifier23);
        c.add(aSN1ObjectIdentifier17);
        c.add(aSN1ObjectIdentifier18);
        c.add(aSN1ObjectIdentifier19);
        c.add(aSN1ObjectIdentifier20);
        c.add(aSN1ObjectIdentifier21);
        c.add(aSN1ObjectIdentifier12);
        c.add(aSN1ObjectIdentifier13);
        c.add(aSN1ObjectIdentifier14);
        c.add(aSN1ObjectIdentifier15);
        c.add(aSN1ObjectIdentifier16);
        c.add(aSN1ObjectIdentifier22);
        c.add(aSN1ObjectIdentifier23);
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = OIWObjectIdentifiers.idSHA1;
        DERNull dERNull = DERNull.INSTANCE;
        b.put("SHA1WITHRSAANDMGF1", c(new AlgorithmIdentifier(aSN1ObjectIdentifier24, dERNull), 20));
        b.put("SHA224WITHRSAANDMGF1", c(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, dERNull), 28));
        b.put("SHA256WITHRSAANDMGF1", c(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, dERNull), 32));
        b.put("SHA384WITHRSAANDMGF1", c(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, dERNull), 48));
        b.put("SHA512WITHRSAANDMGF1", c(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, dERNull), 64));
    }

    public static byte[] a(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, String str2, PrivateKey privateKey, SecureRandom secureRandom, ASN1Encodable aSN1Encodable) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature;
        if (aSN1ObjectIdentifier != null) {
            if (str2 != null) {
                signature = Signature.getInstance(str, str2);
            } else {
                signature = Signature.getInstance(str);
            }
            if (secureRandom != null) {
                signature.initSign(privateKey, secureRandom);
            } else {
                signature.initSign(privateKey);
            }
            signature.update(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
            return signature.sign();
        }
        throw new IllegalStateException("no signature algorithm specified");
    }

    public static byte[] b(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, PrivateKey privateKey, SecureRandom secureRandom, ASN1Encodable aSN1Encodable) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (aSN1ObjectIdentifier != null) {
            Signature instance = Signature.getInstance(str);
            if (secureRandom != null) {
                instance.initSign(privateKey, secureRandom);
            } else {
                instance.initSign(privateKey);
            }
            instance.update(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
            return instance.sign();
        }
        throw new IllegalStateException("no signature algorithm specified");
    }

    public static RSASSAPSSparams c(AlgorithmIdentifier algorithmIdentifier, int i) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }

    public static Iterator d() {
        Enumeration keys = a.keys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasMoreElements()) {
            arrayList.add(keys.nextElement());
        }
        return arrayList.iterator();
    }

    public static ASN1ObjectIdentifier e(String str) {
        String upperCase = Strings.toUpperCase(str);
        if (a.containsKey(upperCase)) {
            return (ASN1ObjectIdentifier) a.get(upperCase);
        }
        return new ASN1ObjectIdentifier(upperCase);
    }

    public static a f(String str, String str2) throws NoSuchAlgorithmException {
        Provider[] providers = Security.getProviders();
        if (providers.length != 0) {
            return g(str, Strings.toUpperCase(str2), providers[0]);
        }
        throw new NoSuchAlgorithmException(a2.b.a.a.a.c3("cannot find implementation ", str2));
    }

    public static a g(String str, String str2, Provider provider) throws NoSuchAlgorithmException {
        Class<?> cls;
        String upperCase = Strings.toUpperCase(str2);
        while (true) {
            String property = provider.getProperty("Alg.Alias." + str + "." + upperCase);
            if (property == null) {
                break;
            }
            upperCase = property;
        }
        String property2 = provider.getProperty(str + "." + upperCase);
        if (property2 != null) {
            try {
                ClassLoader classLoader = provider.getClass().getClassLoader();
                if (classLoader != null) {
                    cls = classLoader.loadClass(property2);
                } else {
                    cls = Class.forName(property2);
                }
                return new a(cls.newInstance(), provider);
            } catch (ClassNotFoundException unused) {
                StringBuilder R = a2.b.a.a.a.R("algorithm ", upperCase, " in provider ");
                R.append(provider.getName());
                R.append(" but no class \"");
                R.append(property2);
                R.append("\" found!");
                throw new IllegalStateException(R.toString());
            } catch (Exception unused2) {
                StringBuilder R2 = a2.b.a.a.a.R("algorithm ", upperCase, " in provider ");
                R2.append(provider.getName());
                R2.append(" but class \"");
                R2.append(property2);
                R2.append("\" inaccessible!");
                throw new IllegalStateException(R2.toString());
            }
        } else {
            StringBuilder R3 = a2.b.a.a.a.R("cannot find implementation ", upperCase, " for provider ");
            R3.append(provider.getName());
            throw new NoSuchAlgorithmException(R3.toString());
        }
    }

    public static Provider h(String str) throws NoSuchProviderException {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new NoSuchProviderException(a2.b.a.a.a.e3("Provider ", str, " not found"));
    }

    public static AlgorithmIdentifier i(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (c.contains(aSN1ObjectIdentifier)) {
            return new AlgorithmIdentifier(aSN1ObjectIdentifier);
        }
        String upperCase = Strings.toUpperCase(str);
        if (b.containsKey(upperCase)) {
            return new AlgorithmIdentifier(aSN1ObjectIdentifier, (ASN1Encodable) b.get(upperCase));
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.INSTANCE);
    }
}
