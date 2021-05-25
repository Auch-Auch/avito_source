package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.SerpentEngine;
import org.spongycastle.crypto.engines.TnepresEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.GMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import x6.e.c.a.d.b;
public final class Serpent {

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Serpent IV";
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new SerpentEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {

        public class a implements BlockCipherProvider {
            @Override // org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider
            public BlockCipher get() {
                return new SerpentEngine();
            }
        }

        public ECB() {
            super(new a());
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Serpent", 192, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends b {
        public static final String a = Serpent.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a.o1(a.Y(a.Y(a.Y(a.Y(a.Y(sb, str, "$ECB", configurableProvider, "Cipher.Serpent"), str, "$KeyGen", configurableProvider, "KeyGenerator.Serpent"), str, "$AlgParams", configurableProvider, "AlgorithmParameters.Serpent"), str, "$TECB", configurableProvider, "Cipher.Tnepres"), str, "$TKeyGen", configurableProvider, "KeyGenerator.Tnepres"), str, "$TAlgParams", configurableProvider, "AlgorithmParameters.Tnepres");
            a.e1(str, "$ECB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_128_ECB);
            a.e1(str, "$ECB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_192_ECB);
            a.e1(str, "$ECB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_256_ECB);
            a.e1(str, "$CBC", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_128_CBC);
            a.e1(str, "$CBC", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_192_CBC);
            a.e1(str, "$CBC", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_256_CBC);
            a.e1(str, "$CFB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_128_CFB);
            a.e1(str, "$CFB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_192_CFB);
            a.e1(str, "$CFB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_256_CFB);
            a.e1(str, "$OFB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_128_OFB);
            a.e1(str, "$OFB", configurableProvider, "Cipher", GNUObjectIdentifiers.Serpent_192_OFB);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = GNUObjectIdentifiers.Serpent_256_OFB;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$OFB");
            addGMacAlgorithm(configurableProvider, "SERPENT", a.t(new StringBuilder(), str, "$SerpentGMAC"), a.c3(str, "$KeyGen"));
            addGMacAlgorithm(configurableProvider, "TNEPRES", a.t(new StringBuilder(), str, "$TSerpentGMAC"), a.c3(str, "$TKeyGen"));
            addPoly1305Algorithm(configurableProvider, "SERPENT", a.t(new StringBuilder(), str, "$Poly1305"), a.c3(str, "$Poly1305KeyGen"));
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new SerpentEngine(), 128)), 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.spongycastle.crypto.macs.Poly1305(new TwofishEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-Serpent", 256, new Poly1305KeyGenerator());
        }
    }

    public static class SerpentGMAC extends BaseMac {
        public SerpentGMAC() {
            super(new GMac(new GCMBlockCipher(new SerpentEngine())));
        }
    }

    public static class TAlgParams extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Tnepres IV";
        }
    }

    public static class TECB extends BaseBlockCipher {

        public class a implements BlockCipherProvider {
            @Override // org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider
            public BlockCipher get() {
                return new TnepresEngine();
            }
        }

        public TECB() {
            super(new a());
        }
    }

    public static class TKeyGen extends BaseKeyGenerator {
        public TKeyGen() {
            super("Tnepres", 192, new CipherKeyGenerator());
        }
    }

    public static class TSerpentGMAC extends BaseMac {
        public TSerpentGMAC() {
            super(new GMac(new GCMBlockCipher(new TnepresEngine())));
        }
    }
}
