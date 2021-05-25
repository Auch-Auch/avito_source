package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CryptoProWrapEngine;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.engines.GOST28147WrapEngine;
import org.spongycastle.crypto.macs.GOST28147Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
public final class GOST28147 {
    public static Map<ASN1ObjectIdentifier, String> a = new HashMap();
    public static Map<String, ASN1ObjectIdentifier> b = new HashMap();

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public byte[] b = new byte[8];
        public byte[] c = GOST28147Engine.getSBox("E-A");

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(this.b);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("GOST28147");
                createParametersInstance.init(new GOST28147ParameterSpec(this.c, this.b));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.c = ((GOST28147ParameterSpec) algorithmParameterSpec).getSBox();
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter spec not supported");
        }
    }

    public static class AlgParams extends BaseAlgParams {
        public ASN1ObjectIdentifier c = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet;
        public byte[] d;

        @Override // org.spongycastle.jcajce.provider.symmetric.GOST28147.BaseAlgParams, java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.d = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.d = ((GOST28147ParameterSpec) algorithmParameterSpec).getIV();
                try {
                    this.c = BaseAlgParams.getSBoxOID(((GOST28147ParameterSpec) algorithmParameterSpec).getSBox());
                } catch (IllegalArgumentException e) {
                    throw new InvalidParameterSpecException(e.getMessage());
                }
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "GOST 28147 IV Parameters";
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.GOST28147.BaseAlgParams, org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.d);
            }
            if (cls == GOST28147ParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new GOST28147ParameterSpec(this.c, this.d);
            }
            throw new InvalidParameterSpecException(a.B2(cls, a.L("AlgorithmParameterSpec not recognized: ")));
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.GOST28147.BaseAlgParams
        public byte[] localGetEncoded() throws IOException {
            return new GOST28147Parameters(this.d, this.c).getEncoded();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.GOST28147.BaseAlgParams
        public void localInit(byte[] bArr) throws IOException {
            ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(bArr);
            if (fromByteArray instanceof ASN1OctetString) {
                this.d = ASN1OctetString.getInstance(fromByteArray).getOctets();
            } else if (fromByteArray instanceof ASN1Sequence) {
                GOST28147Parameters instance = GOST28147Parameters.getInstance(fromByteArray);
                this.c = instance.getEncryptionParamSet();
                this.d = instance.getIV();
            } else {
                throw new IOException("Unable to recognize parameters");
            }
        }
    }

    public static abstract class BaseAlgParams extends BaseAlgorithmParameters {
        public ASN1ObjectIdentifier a = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet;
        public byte[] b;

        public static ASN1ObjectIdentifier getSBoxOID(String str) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = GOST28147.b.get(str);
            if (aSN1ObjectIdentifier != null) {
                return aSN1ObjectIdentifier;
            }
            throw new IllegalArgumentException(a.c3("Unknown SBOX name: ", str));
        }

        @Override // java.security.AlgorithmParametersSpi
        public final byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        @Override // java.security.AlgorithmParametersSpi
        public final void engineInit(byte[] bArr) throws IOException {
            engineInit(bArr, "ASN.1");
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.b);
            }
            if (cls == GOST28147ParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new GOST28147ParameterSpec(this.a, this.b);
            }
            throw new InvalidParameterSpecException(a.B2(cls, a.L("AlgorithmParameterSpec not recognized: ")));
        }

        public byte[] localGetEncoded() throws IOException {
            return new GOST28147Parameters(this.b, this.a).getEncoded();
        }

        public abstract void localInit(byte[] bArr) throws IOException;

        @Override // java.security.AlgorithmParametersSpi
        public final byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return localGetEncoded();
            }
            throw new IOException(a.c3("Unknown parameter format: ", str));
        }

        @Override // java.security.AlgorithmParametersSpi
        public final void engineInit(byte[] bArr, String str) throws IOException {
            Objects.requireNonNull(bArr, "Encoded parameters cannot be null");
            if (isASN1FormatString(str)) {
                try {
                    localInit(bArr);
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IOException(a.F2(e2, a.L("Parameter parsing failed: ")));
                }
            } else {
                throw new IOException(a.c3("Unknown parameter format: ", str));
            }
        }

        public static ASN1ObjectIdentifier getSBoxOID(byte[] bArr) {
            return getSBoxOID(GOST28147Engine.getSBoxName(bArr));
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.b = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.b = ((GOST28147ParameterSpec) algorithmParameterSpec).getIV();
                try {
                    this.a = getSBoxOID(((GOST28147ParameterSpec) algorithmParameterSpec).getSBox());
                } catch (IllegalArgumentException e) {
                    throw new InvalidParameterSpecException(e.getMessage());
                }
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new GOST28147Engine()), 64);
        }
    }

    public static class CryptoProWrap extends BaseWrapCipher {
        public CryptoProWrap() {
            super(new CryptoProWrapEngine());
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new GOST28147Engine());
        }
    }

    public static class GCFB extends BaseBlockCipher {
        public GCFB() {
            super(new BufferedBlockCipher(new GCFBBlockCipher(new GOST28147Engine())), 64);
        }
    }

    public static class GostWrap extends BaseWrapCipher {
        public GostWrap() {
            super(new GOST28147WrapEngine());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("GOST28147", i, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new GOST28147Mac());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = GOST28147.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a.o1(sb, str, "$ECB", configurableProvider, "Cipher.GOST28147");
            StringBuilder c0 = a.c0(configurableProvider, "Alg.Alias.Cipher.GOST", "GOST28147", "Alg.Alias.Cipher.GOST-28147", "GOST28147");
            c0.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR28147_gcfb;
            c0.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(c0.toString(), str + "$GCFB");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            a.p1(sb2, "$KeyGen", configurableProvider, "KeyGenerator.GOST28147");
            StringBuilder c02 = a.c0(configurableProvider, "Alg.Alias.KeyGenerator.GOST", "GOST28147", "Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
            c02.append("Alg.Alias.KeyGenerator.");
            c02.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(c02.toString(), "GOST28147");
            StringBuilder Y = a.Y(a.Y(new StringBuilder(), str, "$AlgParams", configurableProvider, "AlgorithmParameters.GOST28147"), str, "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.GOST28147");
            Y.append("Alg.Alias.AlgorithmParameters.");
            Y.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(Y.toString(), "GOST28147");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, "GOST28147");
            configurableProvider.addAlgorithm("Cipher." + CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap, str + "$CryptoProWrap");
            configurableProvider.addAlgorithm("Cipher." + CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap, str + "$GostWrap");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            a.p1(sb3, "$Mac", configurableProvider, "Mac.GOST28147MAC");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
        }
    }

    static {
        a.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_TestParamSet, "E-TEST");
        Map<ASN1ObjectIdentifier, String> map = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet;
        map.put(aSN1ObjectIdentifier, "E-A");
        Map<ASN1ObjectIdentifier, String> map2 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet;
        map2.put(aSN1ObjectIdentifier2, "E-B");
        Map<ASN1ObjectIdentifier, String> map3 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet;
        map3.put(aSN1ObjectIdentifier3, "E-C");
        Map<ASN1ObjectIdentifier, String> map4 = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet;
        map4.put(aSN1ObjectIdentifier4, "E-D");
        b.put("E-A", aSN1ObjectIdentifier);
        b.put("E-B", aSN1ObjectIdentifier2);
        b.put("E-C", aSN1ObjectIdentifier3);
        b.put("E-D", aSN1ObjectIdentifier4);
    }
}
