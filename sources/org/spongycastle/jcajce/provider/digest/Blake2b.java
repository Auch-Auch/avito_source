package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.crypto.digests.Blake2bDigest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import x6.e.c.a.b.a;
public class Blake2b {

    public static class Blake2b160 extends BCMessageDigest implements Cloneable {
        public Blake2b160() {
            super(new Blake2bDigest(160));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Blake2b160 blake2b160 = (Blake2b160) super.clone();
            blake2b160.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return blake2b160;
        }
    }

    public static class Blake2b256 extends BCMessageDigest implements Cloneable {
        public Blake2b256() {
            super(new Blake2bDigest(256));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Blake2b256 blake2b256 = (Blake2b256) super.clone();
            blake2b256.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return blake2b256;
        }
    }

    public static class Blake2b384 extends BCMessageDigest implements Cloneable {
        public Blake2b384() {
            super(new Blake2bDigest(384));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Blake2b384 blake2b384 = (Blake2b384) super.clone();
            blake2b384.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return blake2b384;
        }
    }

    public static class Blake2b512 extends BCMessageDigest implements Cloneable {
        public Blake2b512() {
            super(new Blake2bDigest(512));
        }

        @Override // java.security.MessageDigest, java.security.MessageDigestSpi, java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            Blake2b512 blake2b512 = (Blake2b512) super.clone();
            blake2b512.digest = new Blake2bDigest((Blake2bDigest) this.digest);
            return blake2b512;
        }
    }

    public static class Mappings extends a {
        public static final String a = Blake2b.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            StringBuilder Y = a2.b.a.a.a.Y(sb, str, "$Blake2b512", configurableProvider, "MessageDigest.BLAKE2B-512");
            Y.append("Alg.Alias.MessageDigest.");
            StringBuilder Z = a2.b.a.a.a.Z(a2.b.a.a.a.b0(a2.b.a.a.a.Z(a2.b.a.a.a.b0(a2.b.a.a.a.Z(a2.b.a.a.a.b0(Y, MiscObjectIdentifiers.id_blake2b512, configurableProvider, "BLAKE2B-512", str), "$Blake2b384", configurableProvider, "MessageDigest.BLAKE2B-384", "Alg.Alias.MessageDigest."), MiscObjectIdentifiers.id_blake2b384, configurableProvider, "BLAKE2B-384", str), "$Blake2b256", configurableProvider, "MessageDigest.BLAKE2B-256", "Alg.Alias.MessageDigest."), MiscObjectIdentifiers.id_blake2b256, configurableProvider, "BLAKE2B-256", str), "$Blake2b160", configurableProvider, "MessageDigest.BLAKE2B-160", "Alg.Alias.MessageDigest.");
            Z.append(MiscObjectIdentifiers.id_blake2b160);
            configurableProvider.addAlgorithm(Z.toString(), "BLAKE2B-160");
        }
    }
}
