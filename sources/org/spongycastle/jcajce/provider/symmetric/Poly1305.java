package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
public class Poly1305 {

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("Poly1305", 256, new Poly1305KeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super(new org.spongycastle.crypto.macs.Poly1305());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = Poly1305.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a.o1(a.Y(sb, str, "$Mac", configurableProvider, "Mac.POLY1305"), str, "$KeyGen", configurableProvider, "KeyGenerator.POLY1305");
        }
    }
}
