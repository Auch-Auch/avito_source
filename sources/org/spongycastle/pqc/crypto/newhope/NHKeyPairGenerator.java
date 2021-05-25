package org.spongycastle.pqc.crypto.newhope;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import x6.e.f.a.b.a;
public class NHKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public SecureRandom a;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        byte[] bArr = new byte[1824];
        short[] sArr = new short[1024];
        SecureRandom secureRandom = this.a;
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        short[] sArr2 = new short[1024];
        AppCompatDelegateImpl.i.o0(sArr2, bArr2);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        a.f(sArr, bArr3, (byte) 0);
        a.k(sArr);
        short[] sArr3 = new short[1024];
        a.f(sArr3, bArr3, (byte) 1);
        a.k(sArr3);
        short[] sArr4 = new short[1024];
        a.h(sArr2, sArr, sArr4);
        short[] sArr5 = new short[1024];
        a.a(sArr4, sArr3, sArr5);
        a.j(bArr, sArr5);
        System.arraycopy(bArr2, 0, bArr, 1792, 32);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NHPublicKeyParameters(bArr), (AsymmetricKeyParameter) new NHPrivateKeyParameters(sArr));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.a = keyGenerationParameters.getRandom();
    }
}
