package org.spongycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.asn1.nsri.NSRIObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.ARIAEngine;
import org.spongycastle.crypto.engines.ARIAWrapEngine;
import org.spongycastle.crypto.engines.ARIAWrapPadEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.spec.AEADParameterSpec;
import x6.e.c.a.d.a;
import x6.e.c.a.d.b;
public final class ARIA {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("ARIA");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for ARIA parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "ARIA IV";
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
            if (a.e(algorithmParameterSpec)) {
                this.a = CCMParameters.getInstance(a.a(algorithmParameterSpec));
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
            if (cls == AlgorithmParameterSpec.class || a.d(cls)) {
                if (a.c()) {
                    return a.b(this.a.toASN1Primitive());
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
            if (a.e(algorithmParameterSpec)) {
                this.a = a.a(algorithmParameterSpec);
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
            if (cls == AlgorithmParameterSpec.class || a.d(cls)) {
                if (a.c()) {
                    return a.b(this.a.toASN1Primitive());
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
            super(new CBCBlockCipher(new ARIAEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new ARIAEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        public class a implements BlockCipherProvider {
            @Override // org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider
            public BlockCipher get() {
                return new ARIAEngine();
            }
        }

        public ECB() {
            super(new a());
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new GMac(new GCMBlockCipher(new ARIAEngine())));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("ARIA", i, new CipherKeyGenerator());
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
        public static final String a = ARIA.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a2.b.a.a.a.o1(sb, str, "$AlgParams", configurableProvider, "AlgorithmParameters.ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NSRIObjectIdentifiers.id_aria128_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NSRIObjectIdentifiers.id_aria192_cbc;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier2, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NSRIObjectIdentifiers.id_aria256_cbc;
            a2.b.a.a.a.p1(a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.AlgorithmParameters", aSN1ObjectIdentifier3, "ARIA", str), "$AlgParamGen", configurableProvider, "AlgorithmParameterGenerator.ARIA");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier, "ARIA");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier2, "ARIA");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier3, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NSRIObjectIdentifiers.id_aria128_ofb;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier4, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NSRIObjectIdentifiers.id_aria192_ofb;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier5, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NSRIObjectIdentifiers.id_aria256_ofb;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier6, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NSRIObjectIdentifiers.id_aria128_cfb;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier7, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NSRIObjectIdentifiers.id_aria192_cfb;
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier8, "ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NSRIObjectIdentifiers.id_aria256_cfb;
            a2.b.a.a.a.p1(a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.AlgorithmParameterGenerator", aSN1ObjectIdentifier9, "ARIA", str), "$ECB", configurableProvider, "Cipher.ARIA");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NSRIObjectIdentifiers.id_aria128_ecb;
            a2.b.a.a.a.e1(str, "$ECB", configurableProvider, "Cipher", aSN1ObjectIdentifier10);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NSRIObjectIdentifiers.id_aria192_ecb;
            a2.b.a.a.a.e1(str, "$ECB", configurableProvider, "Cipher", aSN1ObjectIdentifier11);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NSRIObjectIdentifiers.id_aria256_ecb;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier12, str + "$ECB");
            a2.b.a.a.a.p1(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "Cipher", aSN1ObjectIdentifier6, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "Cipher", aSN1ObjectIdentifier4, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "Cipher", aSN1ObjectIdentifier8, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "Cipher", aSN1ObjectIdentifier3, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "Cipher", aSN1ObjectIdentifier, a2.b.a.a.a.t(new StringBuilder(), str, "$CBC"), str), "$CBC", configurableProvider, "Cipher", aSN1ObjectIdentifier2), str, "$CBC"), str), "$CFB", configurableProvider, "Cipher", aSN1ObjectIdentifier7), str, "$CFB"), str), "$CFB", configurableProvider, "Cipher", aSN1ObjectIdentifier9), str, "$OFB"), str), "$OFB", configurableProvider, "Cipher", aSN1ObjectIdentifier5), str, "$OFB"), str), "$RFC3211Wrap", configurableProvider, "Cipher.ARIARFC3211WRAP", str), "$Wrap", configurableProvider, "Cipher.ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NSRIObjectIdentifiers.id_aria128_kw;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier13, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NSRIObjectIdentifiers.id_aria192_kw;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier14, "ARIAWRAP");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NSRIObjectIdentifiers.id_aria256_kw;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier15, "ARIAWRAP");
            configurableProvider.addAlgorithm("Cipher.ARIAWRAPPAD", a2.b.a.a.a.F(configurableProvider, "Alg.Alias.Cipher.ARIAKW", "ARIAWRAP", str, "$WrapPad"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NSRIObjectIdentifiers.id_aria128_kwp;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier16, "ARIAWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = NSRIObjectIdentifiers.id_aria192_kwp;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier17, "ARIAWRAPPAD");
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = NSRIObjectIdentifiers.id_aria256_kwp;
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier18, "ARIAWRAPPAD");
            StringBuilder d0 = a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier5, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier9, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier7, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier2, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier12, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier10, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier17, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier15, a2.b.a.a.a.t(a2.b.a.a.a.a0(a2.b.a.a.a.d0(configurableProvider, "KeyGenerator", aSN1ObjectIdentifier13, a2.b.a.a.a.F(configurableProvider, "KeyGenerator.ARIA", a2.b.a.a.a.F(configurableProvider, "Alg.Alias.Cipher.ARIAKWP", "ARIAWRAPPAD", str, "$KeyGen"), str, "$KeyGen128"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier14), str, "$KeyGen256"), str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier16), str, "$KeyGen192"), str), "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier18), str, "$KeyGen128"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier11), str, "$KeyGen256"), str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier), str, "$KeyGen192"), str), "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier3), str, "$KeyGen128"), str), "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier8), str, "$KeyGen256"), str), "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier4), str, "$KeyGen192"), str);
            d0.append("$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier6, d0.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = NSRIObjectIdentifiers.id_aria128_ccm;
            a2.b.a.a.a.e1(str, "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier19);
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = NSRIObjectIdentifiers.id_aria192_ccm;
            a2.b.a.a.a.e1(str, "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier20);
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = NSRIObjectIdentifiers.id_aria256_ccm;
            a2.b.a.a.a.e1(str, "$KeyGen256", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier21);
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NSRIObjectIdentifiers.id_aria128_gcm;
            a2.b.a.a.a.e1(str, "$KeyGen128", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier22);
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = NSRIObjectIdentifiers.id_aria192_gcm;
            a2.b.a.a.a.e1(str, "$KeyGen192", configurableProvider, "KeyGenerator", aSN1ObjectIdentifier23);
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = NSRIObjectIdentifiers.id_aria256_gcm;
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier24, str + "$KeyGen256");
            StringBuilder Y = a2.b.a.a.a.Y(new StringBuilder(), str, "$AlgParamGenCCM", configurableProvider, "AlgorithmParameterGenerator.ARIACCM");
            Y.append("Alg.Alias.AlgorithmParameterGenerator.");
            Y.append(aSN1ObjectIdentifier19);
            configurableProvider.addAlgorithm(Y.toString(), "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier20, "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier21, "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier19, "CCM");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier20, "CCM");
            StringBuilder b0 = a2.b.a.a.a.b0(a2.b.a.a.a.b0(a2.b.a.a.a.Z(a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.Cipher", aSN1ObjectIdentifier21, "CCM", str), "$AlgParamGenGCM", configurableProvider, "AlgorithmParameterGenerator.ARIAGCM", "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier22, configurableProvider, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator."), aSN1ObjectIdentifier23, configurableProvider, CodePackage.GCM, "Alg.Alias.AlgorithmParameterGenerator.");
            b0.append(aSN1ObjectIdentifier24);
            configurableProvider.addAlgorithm(b0.toString(), CodePackage.GCM);
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier22, CodePackage.GCM);
            configurableProvider.addAlgorithm("Alg.Alias.Cipher", aSN1ObjectIdentifier23, CodePackage.GCM);
            StringBuilder d02 = a2.b.a.a.a.d0(configurableProvider, "Alg.Alias.Cipher", aSN1ObjectIdentifier24, CodePackage.GCM, str);
            d02.append("$GMAC");
            addGMacAlgorithm(configurableProvider, "ARIA", d02.toString(), a2.b.a.a.a.c3(str, "$KeyGen"));
            addPoly1305Algorithm(configurableProvider, "ARIA", a2.b.a.a.a.t(new StringBuilder(), str, "$Poly1305"), a2.b.a.a.a.c3(str, "$Poly1305KeyGen"));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new ARIAEngine(), 128)), 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new ARIAEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-ARIA", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new ARIAEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new ARIAWrapEngine());
        }
    }

    public static class WrapPad extends BaseWrapCipher {
        public WrapPad() {
            super(new ARIAWrapPadEngine());
        }
    }
}
