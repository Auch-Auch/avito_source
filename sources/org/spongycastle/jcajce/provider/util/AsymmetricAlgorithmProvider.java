package org.spongycastle.jcajce.provider.util;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
public abstract class AsymmetricAlgorithmProvider extends AlgorithmProvider {
    public void addSignatureAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, String str3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String e3 = a.e3(str, "WITH", str2);
        String e32 = a.e3(str, "with", str2);
        String e33 = a.e3(str, "With", str2);
        String e34 = a.e3(str, "/", str2);
        configurableProvider.addAlgorithm("Signature." + e3, str3);
        configurableProvider.addAlgorithm("Alg.Alias.Signature." + e32, e3);
        configurableProvider.addAlgorithm("Alg.Alias.Signature." + e33, e3);
        configurableProvider.addAlgorithm("Alg.Alias.Signature." + e34, e3);
        StringBuilder sb = new StringBuilder();
        sb.append("Alg.Alias.Signature.");
        StringBuilder b0 = a.b0(sb, aSN1ObjectIdentifier, configurableProvider, e3, "Alg.Alias.Signature.OID.");
        b0.append(aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(b0.toString(), e3);
    }

    public void registerOid(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        configurableProvider.addAlgorithm("Alg.Alias.KeyFactory." + aSN1ObjectIdentifier, str);
        configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator." + aSN1ObjectIdentifier, str);
        configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    public void registerOidAlgorithmParameterGenerator(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, str);
        configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, str);
    }

    public void registerOidAlgorithmParameters(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, str);
    }
}
