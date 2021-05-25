package x6.e.c.a.a.a;

import a2.b.a.a.a;
import java.security.Provider;
import java.security.Security;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.util.MessageDigestUtils;
import org.spongycastle.jce.provider.BouncyCastleProvider;
public class f {
    public static final ASN1Null a = DERNull.INSTANCE;

    public static String a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String digestName = MessageDigestUtils.getDigestName(aSN1ObjectIdentifier);
        int indexOf = digestName.indexOf(45);
        if (indexOf <= 0 || digestName.startsWith("SHA3")) {
            return MessageDigestUtils.getDigestName(aSN1ObjectIdentifier);
        }
        return digestName.substring(0, indexOf) + digestName.substring(indexOf + 1);
    }

    public static String b(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters != null && !a.equals(parameters)) {
            if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
                RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
                return a(instance.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
            } else if (algorithmIdentifier.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(parameters);
                return a((ASN1ObjectIdentifier) instance2.getObjectAt(0)) + "withECDSA";
            }
        }
        Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider != null) {
            StringBuilder L = a.L("Alg.Alias.Signature.");
            L.append(algorithmIdentifier.getAlgorithm().getId());
            String property = provider.getProperty(L.toString());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            Provider provider2 = providers[i];
            StringBuilder L2 = a.L("Alg.Alias.Signature.");
            L2.append(algorithmIdentifier.getAlgorithm().getId());
            String property2 = provider2.getProperty(L2.toString());
            if (property2 != null) {
                return property2;
            }
        }
        return algorithmIdentifier.getAlgorithm().getId();
    }
}
