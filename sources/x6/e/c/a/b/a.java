package x6.e.c.a.b;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
public abstract class a extends AlgorithmProvider {
    public void addHMACAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        String c3 = a2.b.a.a.a.c3("HMAC", str);
        configurableProvider.addAlgorithm("Mac." + c3, str2);
        configurableProvider.addAlgorithm("Alg.Alias.Mac.HMAC-" + str, c3);
        configurableProvider.addAlgorithm("Alg.Alias.Mac.HMAC/" + str, c3);
        configurableProvider.addAlgorithm("KeyGenerator." + c3, str3);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.HMAC-" + str, c3);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator.HMAC/" + str, c3);
    }

    public void addHMACAlias(ConfigurableProvider configurableProvider, String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String c3 = a2.b.a.a.a.c3("HMAC", str);
        configurableProvider.addAlgorithm("Alg.Alias.Mac." + aSN1ObjectIdentifier, c3);
        configurableProvider.addAlgorithm("Alg.Alias.KeyGenerator." + aSN1ObjectIdentifier, c3);
    }
}
