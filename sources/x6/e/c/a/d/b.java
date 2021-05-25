package x6.e.c.a.d;

import a2.b.a.a.a;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
public abstract class b extends AlgorithmProvider {
    public void addCMacAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.addAlgorithm("Mac." + str + "-CMAC", str2);
        String u = a.u(new StringBuilder(), "Alg.Alias.Mac.", str, "CMAC");
        configurableProvider.addAlgorithm(u, str + "-CMAC");
        configurableProvider.addAlgorithm("KeyGenerator." + str + "-CMAC", str3);
        String u2 = a.u(new StringBuilder(), "Alg.Alias.KeyGenerator.", str, "CMAC");
        configurableProvider.addAlgorithm(u2, str + "-CMAC");
    }

    public void addGMacAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.addAlgorithm("Mac." + str + "-GMAC", str2);
        String u = a.u(new StringBuilder(), "Alg.Alias.Mac.", str, "GMAC");
        configurableProvider.addAlgorithm(u, str + "-GMAC");
        configurableProvider.addAlgorithm("KeyGenerator." + str + "-GMAC", str3);
        String u2 = a.u(new StringBuilder(), "Alg.Alias.KeyGenerator.", str, "GMAC");
        configurableProvider.addAlgorithm(u2, str + "-GMAC");
    }

    public void addPoly1305Algorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.addAlgorithm("Mac.POLY1305-" + str, str2);
        configurableProvider.addAlgorithm("Alg.Alias.Mac.POLY1305" + str, "POLY1305-" + str);
        configurableProvider.addAlgorithm("KeyGenerator.POLY1305-" + str, str3);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.POLY1305" + str, "POLY1305-" + str);
    }
}
