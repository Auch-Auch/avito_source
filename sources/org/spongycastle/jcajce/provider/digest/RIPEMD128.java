package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.RIPEMD128Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import x6.e.c.a.b.a;
public class RIPEMD128 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new RIPEMD128Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.digest = new RIPEMD128Digest((RIPEMD128Digest) this.digest);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new RIPEMD128Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACRIPEMD128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends a {
        public static final String a = RIPEMD128.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            StringBuilder Y = a2.b.a.a.a.Y(sb, str, "$Digest", configurableProvider, "MessageDigest.RIPEMD128");
            Y.append("Alg.Alias.MessageDigest.");
            StringBuilder b0 = a2.b.a.a.a.b0(Y, TeleTrusTObjectIdentifiers.ripemd128, configurableProvider, "RIPEMD128", str);
            b0.append("$HashMac");
            addHMACAlgorithm(configurableProvider, "RIPEMD128", b0.toString(), a2.b.a.a.a.c3(str, "$KeyGenerator"));
        }
    }
}
