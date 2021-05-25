package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.TLSKeyMaterialSpec;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
public class TLSKDF {

    public static class Mappings extends AlgorithmProvider {
        public static final String a = TLSKDF.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            a.o1(a.Y(a.Y(a.Y(a.Y(sb, str, "$TLS10", configurableProvider, "SecretKeyFactory.TLS10KDF"), str, "$TLS11", configurableProvider, "SecretKeyFactory.TLS11KDF"), str, "$TLS12withSHA256", configurableProvider, "SecretKeyFactory.TLS12WITHSHA256KDF"), str, "$TLS12withSHA384", configurableProvider, "SecretKeyFactory.TLS12WITHSHA384KDF"), str, "$TLS12withSHA512", configurableProvider, "SecretKeyFactory.TLS12WITHSHA512KDF");
        }
    }

    public static final class TLS10 extends TLSKeyMaterialFactory {
        public TLS10() {
            super("TLS10KDF");
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                return new SecretKeySpec(TLSKDF.a((TLSKeyMaterialSpec) keySpec), this.algName);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class TLS11 extends TLSKeyMaterialFactory {
        public TLS11() {
            super("TLS11KDF");
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                return new SecretKeySpec(TLSKDF.a((TLSKeyMaterialSpec) keySpec), this.algName);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class TLS12 extends TLSKeyMaterialFactory {
        public final Mac a;

        public TLS12(String str, Mac mac) {
            super(str);
            this.a = mac;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                TLSKeyMaterialSpec tLSKeyMaterialSpec = (TLSKeyMaterialSpec) keySpec;
                Mac mac = this.a;
                byte[] concatenate = Arrays.concatenate(Strings.toByteArray(tLSKeyMaterialSpec.getLabel()), tLSKeyMaterialSpec.getSeed());
                byte[] secret = tLSKeyMaterialSpec.getSecret();
                byte[] bArr = new byte[tLSKeyMaterialSpec.getLength()];
                TLSKDF.b(mac, secret, concatenate, bArr);
                return new SecretKeySpec(bArr, this.algName);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static final class TLS12withSHA256 extends TLS12 {
        public TLS12withSHA256() {
            super("TLS12withSHA256KDF", new HMac(new SHA256Digest()));
        }
    }

    public static final class TLS12withSHA384 extends TLS12 {
        public TLS12withSHA384() {
            super("TLS12withSHA384KDF", new HMac(new SHA384Digest()));
        }
    }

    public static final class TLS12withSHA512 extends TLS12 {
        public TLS12withSHA512() {
            super("TLS12withSHA512KDF", new HMac(new SHA512Digest()));
        }
    }

    public static class TLSKeyMaterialFactory extends BaseSecretKeyFactory {
        public TLSKeyMaterialFactory(String str) {
            super(str, null);
        }
    }

    public static byte[] a(TLSKeyMaterialSpec tLSKeyMaterialSpec) {
        HMac hMac = new HMac(DigestFactory.createMD5());
        HMac hMac2 = new HMac(DigestFactory.createSHA1());
        byte[] concatenate = Arrays.concatenate(Strings.toByteArray(tLSKeyMaterialSpec.getLabel()), tLSKeyMaterialSpec.getSeed());
        byte[] secret = tLSKeyMaterialSpec.getSecret();
        int length = (secret.length + 1) / 2;
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        System.arraycopy(secret, 0, bArr, 0, length);
        System.arraycopy(secret, secret.length - length, bArr2, 0, length);
        int length2 = tLSKeyMaterialSpec.getLength();
        byte[] bArr3 = new byte[length2];
        byte[] bArr4 = new byte[length2];
        b(hMac, bArr, concatenate, bArr3);
        b(hMac2, bArr2, concatenate, bArr4);
        for (int i = 0; i < length2; i++) {
            bArr3[i] = (byte) (bArr3[i] ^ bArr4[i]);
        }
        return bArr3;
    }

    public static void b(Mac mac, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        mac.init(new KeyParameter(bArr));
        int macSize = mac.getMacSize();
        int length = ((bArr3.length + macSize) - 1) / macSize;
        int macSize2 = mac.getMacSize();
        byte[] bArr4 = new byte[macSize2];
        byte[] bArr5 = new byte[mac.getMacSize()];
        byte[] bArr6 = bArr2;
        int i = 0;
        while (i < length) {
            mac.update(bArr6, 0, bArr6.length);
            mac.doFinal(bArr4, 0);
            mac.update(bArr4, 0, macSize2);
            mac.update(bArr2, 0, bArr2.length);
            mac.doFinal(bArr5, 0);
            int i2 = macSize * i;
            System.arraycopy(bArr5, 0, bArr3, i2, Math.min(macSize, bArr3.length - i2));
            i++;
            bArr6 = bArr4;
        }
    }
}
