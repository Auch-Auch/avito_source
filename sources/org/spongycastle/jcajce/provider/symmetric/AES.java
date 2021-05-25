package org.spongycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.AESWrapEngine;
import org.spongycastle.crypto.engines.AESWrapPadEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.engines.RFC5649WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.spongycastle.jcajce.spec.AEADParameterSpec;
import x6.e.c.a.d.b;
public final class AES {
    public static final Map<String, String> a;

    public static class AESCCMMAC extends BaseMac {

        public static class a implements Mac {
            public final CCMBlockCipher a = new CCMBlockCipher(new AESEngine());
            public int b = 8;

            public a(a aVar) {
            }

            @Override // org.spongycastle.crypto.Mac
            public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
                try {
                    return this.a.doFinal(bArr, 0);
                } catch (InvalidCipherTextException e) {
                    StringBuilder L = a2.b.a.a.a.L("exception on doFinal(): ");
                    L.append(e.toString());
                    throw new IllegalStateException(L.toString());
                }
            }

            @Override // org.spongycastle.crypto.Mac
            public String getAlgorithmName() {
                return this.a.getAlgorithmName() + "Mac";
            }

            @Override // org.spongycastle.crypto.Mac
            public int getMacSize() {
                return this.b;
            }

            @Override // org.spongycastle.crypto.Mac
            public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
                this.a.init(true, cipherParameters);
                this.b = this.a.getMac().length;
            }

            @Override // org.spongycastle.crypto.Mac
            public void reset() {
                this.a.reset();
            }

            @Override // org.spongycastle.crypto.Mac
            public void update(byte b2) throws IllegalStateException {
                this.a.processAADByte(b2);
            }

            @Override // org.spongycastle.crypto.Mac
            public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
                this.a.processAADBytes(bArr, i, i2);
            }
        }

        public AESCCMMAC() {
            super(new a(null));
        }
    }

    public static class AESCMAC extends BaseMac {
        public AESCMAC() {
            super(new CMac(new AESEngine()));
        }
    }

    public static class AESGMAC extends BaseMac {
        public AESGMAC() {
            super(new GMac(new GCMBlockCipher(new AESEngine())));
        }
    }

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("AES");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParamGenCCM extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("CCM");
                createParametersInstance.init(new CCMParameters(bArr, 12).getEncoded());
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParamGenGCM extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[12];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance(CodePackage.GCM);
                createParametersInstance.init(new GCMParameters(bArr, 16).getEncoded());
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "AES IV";
        }
    }

    public static class AlgParamsCCM extends BaseAlgorithmParameters {
        public CCMParameters a;

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.a.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (x6.e.c.a.d.a.e(algorithmParameterSpec)) {
                this.a = CCMParameters.getInstance(x6.e.c.a.d.a.a(algorithmParameterSpec));
            } else if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                this.a = new CCMParameters(aEADParameterSpec.getNonce(), aEADParameterSpec.getMacSizeInBits() / 8);
            } else {
                StringBuilder L = a2.b.a.a.a.L("AlgorithmParameterSpec class not recognized: ");
                L.append(algorithmParameterSpec.getClass().getName());
                throw new InvalidParameterSpecException(L.toString());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "CCM";
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || x6.e.c.a.d.a.d(cls)) {
                if (x6.e.c.a.d.a.c()) {
                    return x6.e.c.a.d.a.b(this.a.toASN1Primitive());
                }
                return new AEADParameterSpec(this.a.getNonce(), this.a.getIcvLen() * 8);
            } else if (cls == AEADParameterSpec.class) {
                return new AEADParameterSpec(this.a.getNonce(), this.a.getIcvLen() * 8);
            } else {
                if (cls == IvParameterSpec.class) {
                    return new IvParameterSpec(this.a.getNonce());
                }
                throw new InvalidParameterSpecException(a2.b.a.a.a.B2(cls, a2.b.a.a.a.L("AlgorithmParameterSpec not recognized: ")));
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return this.a.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.a = CCMParameters.getInstance(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                this.a = CCMParameters.getInstance(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }
    }

    public static class AlgParamsGCM extends BaseAlgorithmParameters {
        public GCMParameters a;

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.a.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (x6.e.c.a.d.a.e(algorithmParameterSpec)) {
                this.a = x6.e.c.a.d.a.a(algorithmParameterSpec);
            } else if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                this.a = new GCMParameters(aEADParameterSpec.getNonce(), aEADParameterSpec.getMacSizeInBits() / 8);
            } else {
                StringBuilder L = a2.b.a.a.a.L("AlgorithmParameterSpec class not recognized: ");
                L.append(algorithmParameterSpec.getClass().getName());
                throw new InvalidParameterSpecException(L.toString());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return CodePackage.GCM;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == AlgorithmParameterSpec.class || x6.e.c.a.d.a.d(cls)) {
                if (x6.e.c.a.d.a.c()) {
                    return x6.e.c.a.d.a.b(this.a.toASN1Primitive());
                }
                return new AEADParameterSpec(this.a.getNonce(), this.a.getIcvLen() * 8);
            } else if (cls == AEADParameterSpec.class) {
                return new AEADParameterSpec(this.a.getNonce(), this.a.getIcvLen() * 8);
            } else {
                if (cls == IvParameterSpec.class) {
                    return new IvParameterSpec(this.a.getNonce());
                }
                throw new InvalidParameterSpecException(a2.b.a.a.a.B2(cls, a2.b.a.a.a.L("AlgorithmParameterSpec not recognized: ")));
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return this.a.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.a = GCMParameters.getInstance(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                this.a = GCMParameters.getInstance(bArr);
                return;
            }
            throw new IOException("unknown format specified");
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new AESEngine()), 128);
        }
    }

    public static class CCM extends BaseBlockCipher {
        public CCM() {
            super(new CCMBlockCipher(new AESEngine()), false, 16);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        public class a implements BlockCipherProvider {
            @Override // org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider
            public BlockCipher get() {
                return new AESEngine();
            }
        }

        public ECB() {
            super(new a());
        }
    }

    public static class GCM extends BaseBlockCipher {
        public GCM() {
            super(new GCMBlockCipher(new AESEngine()));
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("AES", null);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(192);
        }

        public KeyGen(int i) {
            super("AES", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(192);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class Mappings extends b {
        public static final String a = AES.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a2.b.a.a.a.o1(sb, str, "$AlgParams", configurableProvider, "AlgorithmParameters.AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            StringBuilder c0 = a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES", "Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            c0.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes128_CBC;
            StringBuilder b0 = a2.b.a.a.a.b0(c0, aSN1ObjectIdentifier, configurableProvider, "AES", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes192_CBC;
            StringBuilder b02 = a2.b.a.a.a.b0(b0, aSN1ObjectIdentifier2, configurableProvider, "AES", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes256_CBC;
            StringBuilder Z = a2.b.a.a.a.Z(a2.b.a.a.a.b0(b02, aSN1ObjectIdentifier3, configurableProvider, "AES", str), "$AlgParamsGCM", configurableProvider, "AlgorithmParameters.GCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_aes128_GCM;
            StringBuilder b03 = a2.b.a.a.a.b0(Z, aSN1ObjectIdentifier4, configurableProvider, CodePackage.GCM, "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_aes192_GCM;
            StringBuilder b04 = a2.b.a.a.a.b0(b03, aSN1ObjectIdentifier5, configurableProvider, CodePackage.GCM, "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_aes256_GCM;
            StringBuilder Z2 = a2.b.a.a.a.Z(a2.b.a.a.a.b0(b04, aSN1ObjectIdentifier6, configurableProvider, CodePackage.GCM, str), "$AlgParamsCCM", configurableProvider, "AlgorithmParameters.CCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_aes128_CCM;
            StringBuilder b05 = a2.b.a.a.a.b0(Z2, aSN1ObjectIdentifier7, configurableProvider, "CCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_aes192_CCM;
            StringBuilder b06 = a2.b.a.a.a.b0(b05, aSN1ObjectIdentifier8, configurableProvider, "CCM", "Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_aes256_CCM;
            a2.b.a.a.a.p1(a2.b.a.a.a.b0(b06, aSN1ObjectIdentifier9, configurableProvider, "CCM", str), "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            StringBuilder c02 = a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES", "Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            c02.append("Alg.Alias.AlgorithmParameterGenerator.");
            c02.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(c02.toString(), "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier2, "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier3, "AES");
            Map<String, String> map = AES.a;
            configurableProvider.addAttributes("Cipher.AES", map);
            configurableProvider.addAlgorithm("Cipher.AES", str + "$ECB");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_aes128_ECB;
            a2.b.a.a.a.e1(str, "$ECB", configurableProvider, "Cipher", aSN1ObjectIdentifier10);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.id_aes192_ECB;
            a2.b.a.a.a.e1(str, "$ECB", configurableProvider, "Cipher", aSN1ObjectIdentifier11);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_aes256_ECB;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier12, str + "$ECB");
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier3, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "Cipher", aSN1ObjectIdentifier, a2.b.a.a.a.t(new StringBuilder(), str, "$CBC"), str), "$CBC", configurableProvider, "Cipher", aSN1ObjectIdentifier2), str, "$CBC"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_aes128_OFB;
            a2.b.a.a.a.e1(str, "$OFB", configurableProvider, "Cipher", aSN1ObjectIdentifier13);
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.id_aes192_OFB;
            a2.b.a.a.a.e1(str, "$OFB", configurableProvider, "Cipher", aSN1ObjectIdentifier14);
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.id_aes256_OFB;
            a2.b.a.a.a.e1(str, "$OFB", configurableProvider, "Cipher", aSN1ObjectIdentifier15);
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NISTObjectIdentifiers.id_aes128_CFB;
            a2.b.a.a.a.e1(str, "$CFB", configurableProvider, "Cipher", aSN1ObjectIdentifier16);
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = NISTObjectIdentifiers.id_aes192_CFB;
            a2.b.a.a.a.e1(str, "$CFB", configurableProvider, "Cipher", aSN1ObjectIdentifier17);
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = NISTObjectIdentifiers.id_aes256_CFB;
            a2.b.a.a.a.e1(str, "$CFB", configurableProvider, "Cipher", aSN1ObjectIdentifier18);
            configurableProvider.addAttributes("Cipher.AESWRAP", map);
            configurableProvider.addAlgorithm("Cipher.AESWRAP", str + "$Wrap");
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = NISTObjectIdentifiers.id_aes128_wrap;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier19, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = NISTObjectIdentifiers.id_aes192_wrap;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier20, "AESWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = NISTObjectIdentifiers.id_aes256_wrap;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier21, "AESWRAP");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.AESKW", "AESWRAP");
            configurableProvider.addAttributes("Cipher.AESWRAPPAD", map);
            a2.b.a.a.a.o1(new StringBuilder(), str, "$WrapPad", configurableProvider, "Cipher.AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NISTObjectIdentifiers.id_aes128_wrap_pad;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier22, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = NISTObjectIdentifiers.id_aes192_wrap_pad;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier23, "AESWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = NISTObjectIdentifiers.id_aes256_wrap_pad;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier24, "AESWRAPPAD");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.CCM", a2.b.a.a.a.F(configurableProvider, "Cipher.AESRFC5649WRAP", a2.b.a.a.a.F(configurableProvider, "Cipher.AESRFC3211WRAP", a2.b.a.a.a.F(configurableProvider, "Alg.Alias.Cipher.AESKWP", "AESWRAPPAD", str, "$RFC3211Wrap"), str, "$RFC5649Wrap"), str, "$AlgParamGenCCM"));
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier7, "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier8, "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier9, "CCM");
            configurableProvider.addAttributes("Cipher.CCM", map);
            a2.b.a.a.a.o1(new StringBuilder(), str, "$CCM", configurableProvider, "Cipher.CCM");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier7, "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier8, "CCM");
            StringBuilder b07 = a2.b.a.a.a.b0(a2.b.a.a.a.b0(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.Cipher", aSN1ObjectIdentifier9, "CCM", str), "$AlgParamGenGCM", configurableProvider, "AlgorithmParameterGenerator.GCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier4, configurableProvider, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier5, configurableProvider, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator.");
            b07.append(aSN1ObjectIdentifier6);
            configurableProvider.addAlgorithm(b07.toString(), CodePackage.GCM);
            configurableProvider.addAttributes("Cipher.GCM", map);
            configurableProvider.addAlgorithm("Cipher.GCM", str + "$GCM");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier4, CodePackage.GCM);
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier5, CodePackage.GCM);
            StringBuilder Z3 = a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier24, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier22, a2.b.a.a.a.t(a2.b.a.a.a.Y(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier8, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier6, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier4, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier20, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier18, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier3, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier17, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier2, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier16, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.Cipher", aSN1ObjectIdentifier6, CodePackage.GCM, str), "$KeyGen", configurableProvider, "KeyGenerator.AES", str), "$KeyGen128", configurableProvider, "KeyGenerator.2.16.840.1.101.3.4.2", str), "$KeyGen192", configurableProvider, "KeyGenerator.2.16.840.1.101.3.4.22", str), "$KeyGen256", configurableProvider, "KeyGenerator.2.16.840.1.101.3.4.42", str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier10), str, "$KeyGen128"), str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier13), str, "$KeyGen128"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier11), str, "$KeyGen192"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier14), str, "$KeyGen192"), str), "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier12), str, "$KeyGen256"), str), "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier15), str, "$KeyGen256"), str), "$KeyGen", configurableProvider, "KeyGenerator.AESWRAP", str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier19), str, "$KeyGen192"), str), "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier21), str, "$KeyGen128"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier5), str, "$KeyGen256"), str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier7), str, "$KeyGen192"), str), "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier9), str, "$KeyGen", configurableProvider, "KeyGenerator.AESWRAPPAD"), str, "$KeyGen128"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier23), str, "$KeyGen256"), str), "$AESCMAC", configurableProvider, "Mac.AESCMAC", str), "$AESCCMMAC", configurableProvider, "Mac.AESCCMMAC", "Alg.Alias.Mac.");
            Z3.append(aSN1ObjectIdentifier7.getId());
            configurableProvider.addAlgorithm(Z3.toString(), "AESCCMMAC");
            configurableProvider.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier8.getId(), "AESCCMMAC");
            configurableProvider.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier9.getId(), "AESCCMMAC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier25, "PBEWITHSHAAND128BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier26, "PBEWITHSHAAND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier27, "PBEWITHSHAAND256BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier28, "PBEWITHSHA256AND128BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier29, "PBEWITHSHA256AND192BITAES-CBC-BC");
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc;
            a2.b.a.a.a.p1(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.Cipher", aSN1ObjectIdentifier30, "PBEWITHSHA256AND256BITAES-CBC-BC", str), "$PBEWithSHA1AESCBC128", configurableProvider, "Cipher.PBEWITHSHAAND128BITAES-CBC-BC", str), "$PBEWithSHA1AESCBC192", configurableProvider, "Cipher.PBEWITHSHAAND192BITAES-CBC-BC", str), "$PBEWithSHA1AESCBC256", configurableProvider, "Cipher.PBEWITHSHAAND256BITAES-CBC-BC", str), "$PBEWithSHA256AESCBC128", configurableProvider, "Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", str), "$PBEWithSHA256AESCBC192", configurableProvider, "Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", str), "$PBEWithSHA256AESCBC256", configurableProvider, "Cipher.PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHAAND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            a2.b.a.a.a.o1(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC", "Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC"), str, "$PBEWithAESCBC", configurableProvider, "Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL"), str, "$PBEWithAESCBC", configurableProvider, "Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL"), str, "$PBEWithAESCBC", configurableProvider, "Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL"), str, "$KeyFactory", configurableProvider, "SecretKeyFactory.AES");
            ASN1ObjectIdentifier aSN1ObjectIdentifier31 = NISTObjectIdentifiers.aes;
            configurableProvider.addAlgorithm("SecretKeyFactory", aSN1ObjectIdentifier31, str + "$KeyFactory");
            a2.b.a.a.a.o1(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(a2.b.a.a.a.Y(new StringBuilder(), str, "$PBEWithMD5And128BitAESCBCOpenSSL", configurableProvider, "SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL"), str, "$PBEWithMD5And192BitAESCBCOpenSSL", configurableProvider, "SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL"), str, "$PBEWithMD5And256BitAESCBCOpenSSL", configurableProvider, "SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL"), str, "$PBEWithSHAAnd128BitAESBC", configurableProvider, "SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC"), str, "$PBEWithSHAAnd192BitAESBC", configurableProvider, "SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC"), str, "$PBEWithSHAAnd256BitAESBC", configurableProvider, "SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC"), str, "$PBEWithSHA256And128BitAESBC", configurableProvider, "SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC"), str, "$PBEWithSHA256And192BitAESBC", configurableProvider, "SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC"), str, "$PBEWithSHA256And256BitAESBC", configurableProvider, "SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier25, "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier26, "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier27, "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier28, "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier29, "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory", aSN1ObjectIdentifier30, "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            StringBuilder c03 = a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE", "Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            c03.append("Alg.Alias.AlgorithmParameters.");
            c03.append(aSN1ObjectIdentifier25.getId());
            configurableProvider.addAlgorithm(c03.toString(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier26.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier27.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier28.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier29.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier30.getId(), "PKCS12PBE");
            addGMacAlgorithm(configurableProvider, "AES", a2.b.a.a.a.t(new StringBuilder(), str, "$AESGMAC"), a2.b.a.a.a.c3(str, "$KeyGen128"));
            addPoly1305Algorithm(configurableProvider, "AES", a2.b.a.a.a.t(new StringBuilder(), str, "$Poly1305"), a2.b.a.a.a.c3(str, "$Poly1305KeyGen"));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESEngine(), 128)), 128);
        }
    }

    public static class PBEWithAESCBC extends BaseBlockCipher {
        public PBEWithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()));
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And128BitAESCBCOpenSSL() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And192BitAESCBCOpenSSL() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", null, true, 3, 0, 192, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And256BitAESCBCOpenSSL() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithSHA1AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC128() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 128, 16);
        }
    }

    public static class PBEWithSHA1AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC192() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 192, 16);
        }
    }

    public static class PBEWithSHA1AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA1AESCBC256() {
            super(new CBCBlockCipher(new AESEngine()), 2, 1, 256, 16);
        }
    }

    public static class PBEWithSHA256AESCBC128 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC128() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 128, 16);
        }
    }

    public static class PBEWithSHA256AESCBC192 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC192() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 192, 16);
        }
    }

    public static class PBEWithSHA256AESCBC256 extends BaseBlockCipher {
        public PBEWithSHA256AESCBC256() {
            super(new CBCBlockCipher(new AESEngine()), 2, 4, 256, 16);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And128BitAESBC() {
            super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And192BitAESBC() {
            super("PBEWithSHA256And192BitAES-CBC-BC", null, true, 2, 4, 192, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And256BitAESBC() {
            super("PBEWithSHA256And256BitAES-CBC-BC", null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitAESBC() {
            super("PBEWithSHA1And128BitAES-CBC-BC", null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd192BitAESBC() {
            super("PBEWithSHA1And192BitAES-CBC-BC", null, true, 2, 1, 192, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd256BitAESBC() {
            super("PBEWithSHA1And256BitAES-CBC-BC", null, true, 2, 1, 256, 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new AESEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-AES", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESEngine()), 16);
        }
    }

    public static class RFC5649Wrap extends BaseWrapCipher {
        public RFC5649Wrap() {
            super(new RFC5649WrapEngine(new AESEngine()));
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new AESWrapEngine());
        }
    }

    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new AESWrapPadEngine());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.SecretKey");
        hashMap.put("SupportedKeyFormats", "RAW");
    }
}
