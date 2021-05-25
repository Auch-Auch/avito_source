package org.spongycastle.jce;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.CertificationRequest;
import org.spongycastle.asn1.pkcs.CertificationRequestInfo;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509Name;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Strings;
public class PKCS10CertificationRequest extends CertificationRequest {
    public static Hashtable a = new Hashtable();
    public static Hashtable b = new Hashtable();
    public static Hashtable c = new Hashtable();
    public static Hashtable d = new Hashtable();
    public static Set e = new HashSet();

    static {
        a.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        a.put("MD2WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        a.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        a.put("MD5WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        a.put("RSAWITHMD5", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        a.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        a.put("SHA1WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        Hashtable hashtable = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.sha224WithRSAEncryption;
        hashtable.put("SHA224WITHRSAENCRYPTION", aSN1ObjectIdentifier);
        a.put("SHA224WITHRSA", aSN1ObjectIdentifier);
        Hashtable hashtable2 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.sha256WithRSAEncryption;
        hashtable2.put("SHA256WITHRSAENCRYPTION", aSN1ObjectIdentifier2);
        a.put("SHA256WITHRSA", aSN1ObjectIdentifier2);
        Hashtable hashtable3 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.sha384WithRSAEncryption;
        hashtable3.put("SHA384WITHRSAENCRYPTION", aSN1ObjectIdentifier3);
        a.put("SHA384WITHRSA", aSN1ObjectIdentifier3);
        Hashtable hashtable4 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.sha512WithRSAEncryption;
        hashtable4.put("SHA512WITHRSAENCRYPTION", aSN1ObjectIdentifier4);
        a.put("SHA512WITHRSA", aSN1ObjectIdentifier4);
        Hashtable hashtable5 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.id_RSASSA_PSS;
        hashtable5.put("SHA1WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        a.put("SHA224WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        a.put("SHA256WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        a.put("SHA384WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        a.put("SHA512WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        a.put("RSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        Hashtable hashtable6 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128;
        hashtable6.put("RIPEMD128WITHRSAENCRYPTION", aSN1ObjectIdentifier6);
        a.put("RIPEMD128WITHRSA", aSN1ObjectIdentifier6);
        Hashtable hashtable7 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160;
        hashtable7.put("RIPEMD160WITHRSAENCRYPTION", aSN1ObjectIdentifier7);
        a.put("RIPEMD160WITHRSA", aSN1ObjectIdentifier7);
        Hashtable hashtable8 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256;
        hashtable8.put("RIPEMD256WITHRSAENCRYPTION", aSN1ObjectIdentifier8);
        a.put("RIPEMD256WITHRSA", aSN1ObjectIdentifier8);
        a.put("SHA1WITHDSA", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        a.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        Hashtable hashtable9 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.dsa_with_sha224;
        hashtable9.put("SHA224WITHDSA", aSN1ObjectIdentifier9);
        Hashtable hashtable10 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.dsa_with_sha256;
        hashtable10.put("SHA256WITHDSA", aSN1ObjectIdentifier10);
        a.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
        a.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
        Hashtable hashtable11 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = X9ObjectIdentifiers.ecdsa_with_SHA1;
        hashtable11.put("SHA1WITHECDSA", aSN1ObjectIdentifier11);
        Hashtable hashtable12 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = X9ObjectIdentifiers.ecdsa_with_SHA224;
        hashtable12.put("SHA224WITHECDSA", aSN1ObjectIdentifier12);
        Hashtable hashtable13 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = X9ObjectIdentifiers.ecdsa_with_SHA256;
        hashtable13.put("SHA256WITHECDSA", aSN1ObjectIdentifier13);
        Hashtable hashtable14 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = X9ObjectIdentifiers.ecdsa_with_SHA384;
        hashtable14.put("SHA384WITHECDSA", aSN1ObjectIdentifier14);
        Hashtable hashtable15 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = X9ObjectIdentifiers.ecdsa_with_SHA512;
        hashtable15.put("SHA512WITHECDSA", aSN1ObjectIdentifier15);
        a.put("ECDSAWITHSHA1", aSN1ObjectIdentifier11);
        Hashtable hashtable16 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94;
        hashtable16.put("GOST3411WITHGOST3410", aSN1ObjectIdentifier16);
        a.put("GOST3410WITHGOST3411", aSN1ObjectIdentifier16);
        Hashtable hashtable17 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001;
        hashtable17.put("GOST3411WITHECGOST3410", aSN1ObjectIdentifier17);
        a.put("GOST3411WITHECGOST3410-2001", aSN1ObjectIdentifier17);
        a.put("GOST3411WITHGOST3410-2001", aSN1ObjectIdentifier17);
        d.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        d.put(aSN1ObjectIdentifier, "SHA224WITHRSA");
        d.put(aSN1ObjectIdentifier2, "SHA256WITHRSA");
        d.put(aSN1ObjectIdentifier3, "SHA384WITHRSA");
        d.put(aSN1ObjectIdentifier4, "SHA512WITHRSA");
        d.put(aSN1ObjectIdentifier16, "GOST3411WITHGOST3410");
        d.put(aSN1ObjectIdentifier17, "GOST3411WITHECGOST3410");
        d.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        d.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        d.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        d.put(aSN1ObjectIdentifier11, "SHA1WITHECDSA");
        d.put(aSN1ObjectIdentifier12, "SHA224WITHECDSA");
        d.put(aSN1ObjectIdentifier13, "SHA256WITHECDSA");
        d.put(aSN1ObjectIdentifier14, "SHA384WITHECDSA");
        d.put(aSN1ObjectIdentifier15, "SHA512WITHECDSA");
        d.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        d.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        d.put(aSN1ObjectIdentifier9, "SHA224WITHDSA");
        d.put(aSN1ObjectIdentifier10, "SHA256WITHDSA");
        c.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        c.put(X9ObjectIdentifiers.id_dsa, "DSA");
        e.add(aSN1ObjectIdentifier11);
        e.add(aSN1ObjectIdentifier12);
        e.add(aSN1ObjectIdentifier13);
        e.add(aSN1ObjectIdentifier14);
        e.add(aSN1ObjectIdentifier15);
        e.add(X9ObjectIdentifiers.id_dsa_with_sha1);
        e.add(aSN1ObjectIdentifier9);
        e.add(aSN1ObjectIdentifier10);
        e.add(aSN1ObjectIdentifier16);
        e.add(aSN1ObjectIdentifier17);
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = OIWObjectIdentifiers.idSHA1;
        DERNull dERNull = DERNull.INSTANCE;
        b.put("SHA1WITHRSAANDMGF1", a(new AlgorithmIdentifier(aSN1ObjectIdentifier18, dERNull), 20));
        b.put("SHA224WITHRSAANDMGF1", a(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, dERNull), 28));
        b.put("SHA256WITHRSAANDMGF1", a(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, dERNull), 32));
        b.put("SHA384WITHRSAANDMGF1", a(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, dERNull), 48));
        b.put("SHA512WITHRSAANDMGF1", a(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, dERNull), 64));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PKCS10CertificationRequest(byte[] bArr) {
        super((ASN1Sequence) new ASN1InputStream(bArr).readObject());
        try {
        } catch (Exception unused) {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    public static RSASSAPSSparams a(AlgorithmIdentifier algorithmIdentifier, int i) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }

    public static String b(AlgorithmIdentifier algorithmIdentifier) {
        String str;
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || DERNull.INSTANCE.equals(parameters) || !algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            return algorithmIdentifier.getAlgorithm().getId();
        }
        RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
        StringBuilder sb = new StringBuilder();
        ASN1ObjectIdentifier algorithm = instance.getHashAlgorithm().getAlgorithm();
        if (PKCSObjectIdentifiers.md5.equals(algorithm)) {
            str = Constants.MD5;
        } else if (OIWObjectIdentifiers.idSHA1.equals(algorithm)) {
            str = "SHA1";
        } else if (NISTObjectIdentifiers.id_sha224.equals(algorithm)) {
            str = "SHA224";
        } else if (NISTObjectIdentifiers.id_sha256.equals(algorithm)) {
            str = "SHA256";
        } else if (NISTObjectIdentifiers.id_sha384.equals(algorithm)) {
            str = "SHA384";
        } else if (NISTObjectIdentifiers.id_sha512.equals(algorithm)) {
            str = "SHA512";
        } else if (TeleTrusTObjectIdentifiers.ripemd128.equals(algorithm)) {
            str = "RIPEMD128";
        } else if (TeleTrusTObjectIdentifiers.ripemd160.equals(algorithm)) {
            str = "RIPEMD160";
        } else if (TeleTrusTObjectIdentifiers.ripemd256.equals(algorithm)) {
            str = "RIPEMD256";
        } else if (CryptoProObjectIdentifiers.gostR3411.equals(algorithm)) {
            str = "GOST3411";
        } else {
            str = algorithm.getId();
        }
        return a.t(sb, str, "withRSAandMGF1");
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.util.Encodable
    public byte[] getEncoded() {
        try {
            return getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public PublicKey getPublicKey() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        return getPublicKey(BouncyCastleProvider.PROVIDER_NAME);
    }

    public boolean verify() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return verify(BouncyCastleProvider.PROVIDER_NAME);
    }

    public PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.reqInfo.getSubjectPublicKeyInfo();
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new DERBitString(subjectPublicKeyInfo).getOctets());
            AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
            if (str != null) {
                return KeyFactory.getInstance(algorithm.getAlgorithm().getId(), str).generatePublic(x509EncodedKeySpec);
            }
            try {
                return KeyFactory.getInstance(algorithm.getAlgorithm().getId()).generatePublic(x509EncodedKeySpec);
            } catch (NoSuchAlgorithmException e2) {
                if (c.get(algorithm.getAlgorithm()) != null) {
                    String str2 = (String) c.get(algorithm.getAlgorithm());
                    if (str == null) {
                        return KeyFactory.getInstance(str2).generatePublic(x509EncodedKeySpec);
                    }
                    return KeyFactory.getInstance(str2, str).generatePublic(x509EncodedKeySpec);
                }
                throw e2;
            }
        } catch (InvalidKeySpecException unused) {
            throw new InvalidKeyException("error decoding public key");
        } catch (IOException unused2) {
            throw new InvalidKeyException("error decoding public key");
        }
    }

    public boolean verify(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return verify(getPublicKey(str), str);
    }

    public boolean verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature signature;
        if (str == null) {
            try {
                signature = Signature.getInstance(b(this.sigAlgId));
            } catch (NoSuchAlgorithmException e2) {
                if (d.get(this.sigAlgId.getAlgorithm()) != null) {
                    String str2 = (String) d.get(this.sigAlgId.getAlgorithm());
                    if (str == null) {
                        signature = Signature.getInstance(str2);
                    } else {
                        signature = Signature.getInstance(str2, str);
                    }
                } else {
                    throw e2;
                }
            }
        } else {
            signature = Signature.getInstance(b(this.sigAlgId), str);
        }
        ASN1Encodable parameters = this.sigAlgId.getParameters();
        if (parameters != null && !DERNull.INSTANCE.equals(parameters)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER));
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e3) {
                        StringBuilder L = a.L("Exception extracting parameters: ");
                        L.append(e3.getMessage());
                        throw new SignatureException(L.toString());
                    }
                }
            } catch (IOException e4) {
                throw new SignatureException(a.A2(e4, a.L("IOException decoding parameters: ")));
            }
        }
        signature.initVerify(publicKey);
        try {
            signature.update(this.reqInfo.getEncoded(ASN1Encoding.DER));
            return signature.verify(this.sigBits.getOctets());
        } catch (Exception e5) {
            throw new SignatureException(a.a3("exception encoding TBS cert request - ", e5));
        }
    }

    public PKCS10CertificationRequest(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public PKCS10CertificationRequest(String str, X509Name x509Name, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, x509Name, publicKey, aSN1Set, privateKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PKCS10CertificationRequest(String str, X500Principal x500Principal, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, new X509Principal(x500Principal.getEncoded()), publicKey, aSN1Set, privateKey, BouncyCastleProvider.PROVIDER_NAME);
        try {
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PKCS10CertificationRequest(String str, X500Principal x500Principal, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, new X509Principal(x500Principal.getEncoded()), publicKey, aSN1Set, privateKey, str2);
        try {
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    public PKCS10CertificationRequest(String str, X509Name x509Name, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature signature;
        String upperCase = Strings.toUpperCase(str);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.get(upperCase);
        if (aSN1ObjectIdentifier == null) {
            try {
                aSN1ObjectIdentifier = new ASN1ObjectIdentifier(upperCase);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Unknown signature type requested");
            }
        }
        if (x509Name == null) {
            throw new IllegalArgumentException("subject must not be null");
        } else if (publicKey != null) {
            if (e.contains(aSN1ObjectIdentifier)) {
                this.sigAlgId = new AlgorithmIdentifier(aSN1ObjectIdentifier);
            } else if (b.containsKey(upperCase)) {
                this.sigAlgId = new AlgorithmIdentifier(aSN1ObjectIdentifier, (ASN1Encodable) b.get(upperCase));
            } else {
                this.sigAlgId = new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.INSTANCE);
            }
            try {
                this.reqInfo = new CertificationRequestInfo(x509Name, SubjectPublicKeyInfo.getInstance((ASN1Sequence) ASN1Primitive.fromByteArray(publicKey.getEncoded())), aSN1Set);
                if (str2 == null) {
                    signature = Signature.getInstance(str);
                } else {
                    signature = Signature.getInstance(str, str2);
                }
                signature.initSign(privateKey);
                try {
                    signature.update(this.reqInfo.getEncoded(ASN1Encoding.DER));
                    this.sigBits = new DERBitString(signature.sign());
                } catch (Exception e2) {
                    throw new IllegalArgumentException(a.a3("exception encoding TBS cert request - ", e2));
                }
            } catch (IOException unused2) {
                throw new IllegalArgumentException("can't encode public key");
            }
        } else {
            throw new IllegalArgumentException("public key must not be null");
        }
    }
}
