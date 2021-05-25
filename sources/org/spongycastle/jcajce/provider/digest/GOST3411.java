package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.GOST3411_2012_256Digest;
import org.spongycastle.crypto.digests.GOST3411_2012_512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import x6.e.c.a.b.a;
public class GOST3411 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new GOST3411Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.digest = new GOST3411Digest((GOST3411Digest) this.digest);
            return digest;
        }
    }

    public static class Digest2012_256 extends BCMessageDigest implements Cloneable {
        public Digest2012_256() {
            super(new GOST3411_2012_256Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Digest2012_256 digest2012_256 = (Digest2012_256) super.clone();
            digest2012_256.digest = new GOST3411_2012_256Digest((GOST3411_2012_256Digest) this.digest);
            return digest2012_256;
        }
    }

    public static class Digest2012_512 extends BCMessageDigest implements Cloneable {
        public Digest2012_512() {
            super(new GOST3411_2012_512Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Digest2012_512 digest2012_512 = (Digest2012_512) super.clone();
            digest2012_512.digest = new GOST3411_2012_512Digest((GOST3411_2012_512Digest) this.digest);
            return digest2012_512;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new GOST3411Digest()));
        }
    }

    public static class HashMac2012_256 extends BaseMac {
        public HashMac2012_256() {
            super(new HMac(new GOST3411_2012_256Digest()));
        }
    }

    public static class HashMac2012_512 extends BaseMac {
        public HashMac2012_512() {
            super(new HMac(new GOST3411_2012_512Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACGOST3411", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator2012_256 extends BaseKeyGenerator {
        public KeyGenerator2012_256() {
            super("HMACGOST3411", 256, new CipherKeyGenerator());
        }
    }

    public static class KeyGenerator2012_512 extends BaseKeyGenerator {
        public KeyGenerator2012_512() {
            super("HMACGOST3411", 512, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends a {
        public static final String a = GOST3411.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a2.b.a.a.a.o1(sb, str, "$Digest", configurableProvider, "MessageDigest.GOST3411");
            StringBuilder c0 = a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.MessageDigest.GOST", "GOST3411", "Alg.Alias.MessageDigest.GOST-3411", "GOST3411");
            c0.append("Alg.Alias.MessageDigest.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3411;
            StringBuilder b0 = a2.b.a.a.a.b0(c0, aSN1ObjectIdentifier, configurableProvider, "GOST3411", str);
            b0.append("$HashMac");
            addHMACAlgorithm(configurableProvider, "GOST3411", b0.toString(), a2.b.a.a.a.c3(str, "$KeyGenerator"));
            addHMACAlias(configurableProvider, "GOST3411", aSN1ObjectIdentifier);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            a2.b.a.a.a.p1(sb2, "$Digest2012_256", configurableProvider, "MessageDigest.GOST3411-2012-256");
            StringBuilder c02 = a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.MessageDigest.GOST-2012-256", "GOST3411-2012-256", "Alg.Alias.MessageDigest.GOST-3411-2012-256", "GOST3411-2012-256");
            c02.append("Alg.Alias.MessageDigest.");
            StringBuilder b02 = a2.b.a.a.a.b0(c02, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256, configurableProvider, "GOST3411-2012-256", str);
            b02.append("$HashMac2012_256");
            addHMACAlgorithm(configurableProvider, "GOST3411-2012-256", b02.toString(), a2.b.a.a.a.c3(str, "$KeyGenerator2012_256"));
            addHMACAlias(configurableProvider, "GOST3411-2012-256", RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_256);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            a2.b.a.a.a.p1(sb3, "$Digest2012_512", configurableProvider, "MessageDigest.GOST3411-2012-512");
            StringBuilder c03 = a2.b.a.a.a.c0(configurableProvider, "Alg.Alias.MessageDigest.GOST-2012-512", "GOST3411-2012-512", "Alg.Alias.MessageDigest.GOST-3411-2012-512", "GOST3411-2012-512");
            c03.append("Alg.Alias.MessageDigest.");
            StringBuilder b03 = a2.b.a.a.a.b0(c03, RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512, configurableProvider, "GOST3411-2012-512", str);
            b03.append("$HashMac2012_512");
            addHMACAlgorithm(configurableProvider, "GOST3411-2012-512", b03.toString(), a2.b.a.a.a.c3(str, "$KeyGenerator2012_512"));
            addHMACAlias(configurableProvider, "GOST3411-2012-512", RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_512);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            StringBuilder Z = a2.b.a.a.a.Z(sb4, "$PBEWithMacKeyFactory", configurableProvider, "SecretKeyFactory.PBEWITHHMACGOST3411", "Alg.Alias.SecretKeyFactory.");
            Z.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(Z.toString(), "PBEWITHHMACGOST3411");
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacGOST3411", null, false, 2, 6, 256, 0);
        }
    }
}
