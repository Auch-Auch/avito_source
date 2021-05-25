package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
public class BasicEntropySourceProvider implements EntropySourceProvider {
    public final SecureRandom a;
    public final boolean b;

    public class a implements EntropySource {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // org.spongycastle.crypto.prng.EntropySource
        public int entropySize() {
            return this.a;
        }

        @Override // org.spongycastle.crypto.prng.EntropySource
        public byte[] getEntropy() {
            SecureRandom secureRandom = BasicEntropySourceProvider.this.a;
            if (!(secureRandom instanceof SP800SecureRandom) && !(secureRandom instanceof X931SecureRandom)) {
                return secureRandom.generateSeed((this.a + 7) / 8);
            }
            byte[] bArr = new byte[((this.a + 7) / 8)];
            secureRandom.nextBytes(bArr);
            return bArr;
        }

        @Override // org.spongycastle.crypto.prng.EntropySource
        public boolean isPredictionResistant() {
            return BasicEntropySourceProvider.this.b;
        }
    }

    public BasicEntropySourceProvider(SecureRandom secureRandom, boolean z) {
        this.a = secureRandom;
        this.b = z;
    }

    @Override // org.spongycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(int i) {
        return new a(i);
    }
}
