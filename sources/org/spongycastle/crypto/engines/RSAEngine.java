package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import x6.e.b.a.a;
public class RSAEngine implements AsymmetricBlockCipher {
    public a a;

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.a.c();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.a.d();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (this.a == null) {
            this.a = new a();
        }
        this.a.e(z, cipherParameters);
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.b(aVar.f(aVar.a(bArr, i, i2)));
        }
        throw new IllegalStateException("RSA engine not initialised");
    }
}
