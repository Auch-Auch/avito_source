package org.spongycastle.util.test;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.crypto.prng.EntropySourceProvider;
public class TestRandomEntropySourceProvider implements EntropySourceProvider {
    public final SecureRandom a = new SecureRandom();
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
            byte[] bArr = new byte[((this.a + 7) / 8)];
            TestRandomEntropySourceProvider.this.a.nextBytes(bArr);
            return bArr;
        }

        @Override // org.spongycastle.crypto.prng.EntropySource
        public boolean isPredictionResistant() {
            return TestRandomEntropySourceProvider.this.b;
        }
    }

    public TestRandomEntropySourceProvider(boolean z) {
        this.b = z;
    }

    @Override // org.spongycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(int i) {
        return new a(i);
    }
}
