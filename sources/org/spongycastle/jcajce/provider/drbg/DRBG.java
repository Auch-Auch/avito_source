package org.spongycastle.jcajce.provider.drbg;

import java.security.AccessController;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.crypto.prng.EntropySourceProvider;
import org.spongycastle.crypto.prng.SP800SecureRandom;
import org.spongycastle.crypto.prng.SP800SecureRandomBuilder;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;
public class DRBG {
    public static final String[][] a = {new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom"}, new String[]{"org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom"}};
    public static final Object[] b;

    public static class Default extends SecureRandomSpi {
        public static final SecureRandom a = DRBG.a(true);

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i) {
            return a.generateSeed(i);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            a.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            a.setSeed(bArr);
        }
    }

    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String[][] strArr = DRBG.a;
            a2.b.a.a.a.o1(a2.b.a.a.a.Y(sb, "org.spongycastle.jcajce.provider.drbg.DRBG", "$Default", configurableProvider, "SecureRandom.DEFAULT"), "org.spongycastle.jcajce.provider.drbg.DRBG", "$NonceAndIV", configurableProvider, "SecureRandom.NONCEANDIV");
        }
    }

    public static class NonceAndIV extends SecureRandomSpi {
        public static final SecureRandom a = DRBG.a(false);

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i) {
            return a.generateSeed(i);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            a.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            a.setSeed(bArr);
        }
    }

    public static class a extends SecureRandom {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a() {
            /*
                r3 = this;
                java.lang.Object[] r0 = org.spongycastle.jcajce.provider.drbg.DRBG.b
                r1 = 1
                r1 = r0[r1]
                java.security.SecureRandomSpi r1 = (java.security.SecureRandomSpi) r1
                r2 = 0
                r0 = r0[r2]
                java.security.Provider r0 = (java.security.Provider) r0
                r3.<init>(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.drbg.DRBG.a.<init>():void");
        }
    }

    static {
        Object[] objArr;
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                objArr = null;
                break;
            }
            String[] strArr2 = strArr[i];
            try {
                objArr = new Object[]{Class.forName(strArr2[0]).newInstance(), Class.forName(strArr2[1]).newInstance()};
                break;
            } catch (Throwable unused) {
                i++;
            }
        }
        b = objArr;
    }

    public static SecureRandom a(boolean z) {
        byte[] bArr;
        byte[] bArr2;
        if (System.getProperty("org.spongycastle.drbg.entropysource") != null) {
            EntropySourceProvider entropySourceProvider = (EntropySourceProvider) AccessController.doPrivileged(new x6.e.c.a.c.a(System.getProperty("org.spongycastle.drbg.entropysource")));
            EntropySource entropySource = entropySourceProvider.get(128);
            if (z) {
                bArr2 = b(entropySource.getEntropy());
            } else {
                bArr2 = c(entropySource.getEntropy());
            }
            return new SP800SecureRandomBuilder(entropySourceProvider).setPersonalizationString(bArr2).buildHash(new SHA512Digest(), Arrays.concatenate(entropySource.getEntropy(), entropySource.getEntropy()), z);
        }
        b bVar = new b();
        if (z) {
            bArr = b(bVar.generateSeed(16));
        } else {
            bArr = c(bVar.generateSeed(16));
        }
        return new SP800SecureRandomBuilder(bVar, true).setPersonalizationString(bArr).buildHash(new SHA512Digest(), bVar.generateSeed(32), z);
    }

    public static byte[] b(byte[] bArr) {
        return Arrays.concatenate(Strings.toByteArray("Default"), bArr, Pack.longToBigEndian(Thread.currentThread().getId()), Pack.longToBigEndian(System.currentTimeMillis()));
    }

    public static byte[] c(byte[] bArr) {
        return Arrays.concatenate(Strings.toByteArray("Nonce"), bArr, Pack.longToLittleEndian(Thread.currentThread().getId()), Pack.longToLittleEndian(System.currentTimeMillis()));
    }

    public static class b extends SecureRandom {
        public final AtomicBoolean a = new AtomicBoolean(false);
        public final AtomicInteger b = new AtomicInteger(0);
        public final SecureRandom c;
        public final SP800SecureRandom d;

        public class a implements EntropySourceProvider {
            public a() {
            }

            @Override // org.spongycastle.crypto.prng.EntropySourceProvider
            public EntropySource get(int i) {
                return new C0549b(i);
            }
        }

        /* renamed from: org.spongycastle.jcajce.provider.drbg.DRBG$b$b  reason: collision with other inner class name */
        public class C0549b implements EntropySource {
            public final int a;
            public final AtomicReference b = new AtomicReference();
            public final AtomicBoolean c = new AtomicBoolean(false);

            /* renamed from: org.spongycastle.jcajce.provider.drbg.DRBG$b$b$a */
            public class a implements Runnable {
                public final int a;

                public a(int i) {
                    this.a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0549b bVar = C0549b.this;
                    bVar.b.set(b.this.c.generateSeed(this.a));
                    b.this.a.set(true);
                }
            }

            public C0549b(int i) {
                this.a = (i + 7) / 8;
            }

            @Override // org.spongycastle.crypto.prng.EntropySource
            public int entropySize() {
                return this.a * 8;
            }

            @Override // org.spongycastle.crypto.prng.EntropySource
            public byte[] getEntropy() {
                byte[] bArr = (byte[]) this.b.getAndSet(null);
                if (bArr == null || bArr.length != this.a) {
                    bArr = b.this.c.generateSeed(this.a);
                } else {
                    this.c.set(false);
                }
                if (!this.c.getAndSet(true)) {
                    new Thread(new a(this.a)).start();
                }
                return bArr;
            }

            @Override // org.spongycastle.crypto.prng.EntropySource
            public boolean isPredictionResistant() {
                return true;
            }
        }

        public b() {
            super(null, null);
            SecureRandom secureRandom;
            if (DRBG.b != null) {
                secureRandom = new a();
            } else {
                secureRandom = new SecureRandom();
            }
            this.c = secureRandom;
            this.d = new SP800SecureRandomBuilder(new a()).setPersonalizationString(Strings.toByteArray("Bouncy Castle Hybrid Entropy Source")).buildHMAC(new HMac(new SHA512Digest()), secureRandom.generateSeed(32), false);
        }

        @Override // java.security.SecureRandom
        public byte[] generateSeed(int i) {
            byte[] bArr = new byte[i];
            if (this.b.getAndIncrement() > 20 && this.a.getAndSet(false)) {
                this.b.set(0);
                this.d.reseed(null);
            }
            this.d.nextBytes(bArr);
            return bArr;
        }

        @Override // java.security.SecureRandom
        public void setSeed(byte[] bArr) {
            SP800SecureRandom sP800SecureRandom = this.d;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(bArr);
            }
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void setSeed(long j) {
            SP800SecureRandom sP800SecureRandom = this.d;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(j);
            }
        }
    }
}
