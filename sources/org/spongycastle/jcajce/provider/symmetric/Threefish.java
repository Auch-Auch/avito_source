package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
public final class Threefish {

    public static class AlgParams_1024 extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-1024 IV";
        }
    }

    public static class AlgParams_256 extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-256 IV";
        }
    }

    public static class AlgParams_512 extends IvAlgorithmParameters {
        @Override // org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "Threefish-512 IV";
        }
    }

    public static class CMAC_1024 extends BaseMac {
        public CMAC_1024() {
            super(new CMac(new ThreefishEngine(1024)));
        }
    }

    public static class CMAC_256 extends BaseMac {
        public CMAC_256() {
            super(new CMac(new ThreefishEngine(256)));
        }
    }

    public static class CMAC_512 extends BaseMac {
        public CMAC_512() {
            super(new CMac(new ThreefishEngine(512)));
        }
    }

    public static class ECB_1024 extends BaseBlockCipher {
        public ECB_1024() {
            super(new ThreefishEngine(1024));
        }
    }

    public static class ECB_256 extends BaseBlockCipher {
        public ECB_256() {
            super(new ThreefishEngine(256));
        }
    }

    public static class ECB_512 extends BaseBlockCipher {
        public ECB_512() {
            super(new ThreefishEngine(512));
        }
    }

    public static class KeyGen_1024 extends BaseKeyGenerator {
        public KeyGen_1024() {
            super("Threefish-1024", 1024, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_256 extends BaseKeyGenerator {
        public KeyGen_256() {
            super("Threefish-256", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGen_512 extends BaseKeyGenerator {
        public KeyGen_512() {
            super("Threefish-512", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = Threefish.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a.o1(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(a.Y(sb, str, "$CMAC_256", configurableProvider, "Mac.Threefish-256CMAC"), str, "$CMAC_512", configurableProvider, "Mac.Threefish-512CMAC"), str, "$CMAC_1024", configurableProvider, "Mac.Threefish-1024CMAC"), str, "$ECB_256", configurableProvider, "Cipher.Threefish-256"), str, "$ECB_512", configurableProvider, "Cipher.Threefish-512"), str, "$ECB_1024", configurableProvider, "Cipher.Threefish-1024"), str, "$KeyGen_256", configurableProvider, "KeyGenerator.Threefish-256"), str, "$KeyGen_512", configurableProvider, "KeyGenerator.Threefish-512"), str, "$KeyGen_1024", configurableProvider, "KeyGenerator.Threefish-1024"), str, "$AlgParams_256", configurableProvider, "AlgorithmParameters.Threefish-256"), str, "$AlgParams_512", configurableProvider, "AlgorithmParameters.Threefish-512"), str, "$AlgParams_1024", configurableProvider, "AlgorithmParameters.Threefish-1024");
        }
    }
}
