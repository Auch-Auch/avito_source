package org.spongycastle.jcajce.provider.digest;

import com.adjust.sdk.Constants;
import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import x6.e.c.a.b.a;
public class MD5 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new MD5Digest());
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Digest digest = (Digest) super.clone();
            digest.digest = new MD5Digest((MD5Digest) this.digest);
            return digest;
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new MD5Digest()));
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACMD5", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends a {
        public static final String a = MD5.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            StringBuilder Y = a2.b.a.a.a.Y(sb, str, "$Digest", configurableProvider, "MessageDigest.MD5");
            Y.append("Alg.Alias.MessageDigest.");
            StringBuilder b0 = a2.b.a.a.a.b0(Y, PKCSObjectIdentifiers.md5, configurableProvider, Constants.MD5, str);
            b0.append("$HashMac");
            addHMACAlgorithm(configurableProvider, Constants.MD5, b0.toString(), a2.b.a.a.a.c3(str, "$KeyGenerator"));
            addHMACAlias(configurableProvider, Constants.MD5, IANAObjectIdentifiers.hmacMD5);
        }
    }
}
