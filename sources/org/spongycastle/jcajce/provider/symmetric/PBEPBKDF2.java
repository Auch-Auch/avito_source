package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.PasswordConverter;
import org.spongycastle.jcajce.PBKDF2Key;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.util.Integers;
public class PBEPBKDF2 {
    public static final Map a;

    public static class BasePBKDF2 extends BaseSecretKeyFactory {
        public int a;
        public int b;

        public BasePBKDF2(String str, int i) {
            this(str, i, 1);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    return new PBKDF2Key(pBEKeySpec.getPassword(), this.a == 1 ? PasswordConverter.ASCII : PasswordConverter.UTF8);
                } else if (pBEKeySpec.getIterationCount() <= 0) {
                    StringBuilder L = a.L("positive iteration count required: ");
                    L.append(pBEKeySpec.getIterationCount());
                    throw new InvalidKeySpecException(L.toString());
                } else if (pBEKeySpec.getKeyLength() <= 0) {
                    StringBuilder L2 = a.L("positive key length required: ");
                    L2.append(pBEKeySpec.getKeyLength());
                    throw new InvalidKeySpecException(L2.toString());
                } else if (pBEKeySpec.getPassword().length == 0) {
                    throw new IllegalArgumentException("password empty");
                } else if (pBEKeySpec instanceof PBKDF2KeySpec) {
                    ASN1ObjectIdentifier algorithm = ((PBKDF2KeySpec) pBEKeySpec).getPrf().getAlgorithm();
                    Integer num = (Integer) PBEPBKDF2.a.get(algorithm);
                    if (num != null) {
                        int intValue = num.intValue();
                        int keyLength = pBEKeySpec.getKeyLength();
                        return new BCPBEKey(this.algName, this.algOid, this.a, intValue, keyLength, -1, pBEKeySpec, PBE.Util.makePBEMacParameters(pBEKeySpec, this.a, intValue, keyLength));
                    }
                    throw new InvalidKeySpecException("Invalid KeySpec: unknown PRF algorithm " + algorithm);
                } else {
                    int i = this.b;
                    int keyLength2 = pBEKeySpec.getKeyLength();
                    return new BCPBEKey(this.algName, this.algOid, this.a, i, keyLength2, -1, pBEKeySpec, PBE.Util.makePBEMacParameters(pBEKeySpec, this.a, i, keyLength2));
                }
            } else {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        public BasePBKDF2(String str, int i, int i2) {
            super(str, PKCSObjectIdentifiers.id_PBKDF2);
            this.a = i;
            this.b = i2;
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = PBEPBKDF2.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            StringBuilder Y = a.Y(sb, str, "$AlgParams", configurableProvider, "AlgorithmParameters.PBKDF2");
            Y.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_PBKDF2;
            a.p1(a.b0(Y, aSN1ObjectIdentifier, configurableProvider, "PBKDF2", str), "$PBKDF2withUTF8", configurableProvider, "SecretKeyFactory.PBKDF2");
            StringBuilder c0 = a.c0(configurableProvider, "Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1", "PBKDF2", "Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1ANDUTF8", "PBKDF2");
            c0.append("Alg.Alias.SecretKeyFactory.");
            c0.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(c0.toString(), "PBKDF2");
            a.o1(new StringBuilder(), str, "$PBKDF2with8BIT", configurableProvider, "SecretKeyFactory.PBKDF2WITHASCII");
            a.o1(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.c0(configurableProvider, "Alg.Alias.SecretKeyFactory.PBKDF2WITH8BIT", "PBKDF2WITHASCII", "Alg.Alias.SecretKeyFactory.PBKDF2WITHHMACSHA1AND8BIT", "PBKDF2WITHASCII"), str, "$PBKDF2withSHA224", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA224"), str, "$PBKDF2withSHA256", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA256"), str, "$PBKDF2withSHA384", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA384"), str, "$PBKDF2withSHA512", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA512"), str, "$PBKDF2withSHA3_224", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA3-224"), str, "$PBKDF2withSHA3_256", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA3-256"), str, "$PBKDF2withSHA3_384", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA3-384"), str, "$PBKDF2withSHA3_512", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACSHA3-512"), str, "$PBKDF2withGOST3411", configurableProvider, "SecretKeyFactory.PBKDF2WITHHMACGOST3411");
        }
    }

    public static class PBKDF2with8BIT extends BasePBKDF2 {
        public PBKDF2with8BIT() {
            super("PBKDF2", 1);
        }
    }

    public static class PBKDF2withGOST3411 extends BasePBKDF2 {
        public PBKDF2withGOST3411() {
            super("PBKDF2", 5, 6);
        }
    }

    public static class PBKDF2withSHA224 extends BasePBKDF2 {
        public PBKDF2withSHA224() {
            super("PBKDF2", 5, 7);
        }
    }

    public static class PBKDF2withSHA256 extends BasePBKDF2 {
        public PBKDF2withSHA256() {
            super("PBKDF2", 5, 4);
        }
    }

    public static class PBKDF2withSHA384 extends BasePBKDF2 {
        public PBKDF2withSHA384() {
            super("PBKDF2", 5, 8);
        }
    }

    public static class PBKDF2withSHA3_224 extends BasePBKDF2 {
        public PBKDF2withSHA3_224() {
            super("PBKDF2", 5, 10);
        }
    }

    public static class PBKDF2withSHA3_256 extends BasePBKDF2 {
        public PBKDF2withSHA3_256() {
            super("PBKDF2", 5, 11);
        }
    }

    public static class PBKDF2withSHA3_384 extends BasePBKDF2 {
        public PBKDF2withSHA3_384() {
            super("PBKDF2", 5, 12);
        }
    }

    public static class PBKDF2withSHA3_512 extends BasePBKDF2 {
        public PBKDF2withSHA3_512() {
            super("PBKDF2", 5, 13);
        }
    }

    public static class PBKDF2withSHA512 extends BasePBKDF2 {
        public PBKDF2withSHA512() {
            super("PBKDF2", 5, 9);
        }
    }

    public static class PBKDF2withUTF8 extends BasePBKDF2 {
        public PBKDF2withUTF8() {
            super("PBKDF2", 5);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(CryptoProObjectIdentifiers.gostR3411Hmac, Integers.valueOf(6));
        hashMap.put(PKCSObjectIdentifiers.id_hmacWithSHA1, Integers.valueOf(1));
        hashMap.put(PKCSObjectIdentifiers.id_hmacWithSHA256, Integers.valueOf(4));
        hashMap.put(PKCSObjectIdentifiers.id_hmacWithSHA224, Integers.valueOf(7));
        hashMap.put(PKCSObjectIdentifiers.id_hmacWithSHA384, Integers.valueOf(8));
        hashMap.put(PKCSObjectIdentifiers.id_hmacWithSHA512, Integers.valueOf(9));
        hashMap.put(NISTObjectIdentifiers.id_hmacWithSHA3_256, Integers.valueOf(11));
        hashMap.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, Integers.valueOf(10));
        hashMap.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, Integers.valueOf(12));
        hashMap.put(NISTObjectIdentifiers.id_hmacWithSHA3_512, Integers.valueOf(13));
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public PBKDF2Params a;

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            try {
                return this.a.getEncoded(ASN1Encoding.DER);
            } catch (IOException e) {
                StringBuilder L = a.L("Oooops! ");
                L.append(e.toString());
                throw new RuntimeException(L.toString());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.a = new PBKDF2Params(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF2 PBE parameters algorithm parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PBKDF2 Parameters";
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.a.getSalt(), this.a.getIterationCount().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF2 PBE parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.a = PBKDF2Params.getInstance(ASN1Primitive.fromByteArray(bArr));
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PBKDF2 parameters object");
        }
    }
}
