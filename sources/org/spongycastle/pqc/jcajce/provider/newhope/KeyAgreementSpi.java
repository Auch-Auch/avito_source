package org.spongycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.pqc.crypto.ExchangePair;
import org.spongycastle.pqc.crypto.newhope.NHAgreement;
import org.spongycastle.pqc.crypto.newhope.NHExchangePairGenerator;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.spongycastle.util.Arrays;
public class KeyAgreementSpi extends BaseAgreementSpi {
    public NHAgreement h;
    public BCNHPublicKey i;
    public NHExchangePairGenerator j;
    public byte[] k;

    public KeyAgreementSpi() {
        super("NH", null);
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    public byte[] calcSecret() {
        return engineGenerateSecret();
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (z) {
            BCNHPublicKey bCNHPublicKey = (BCNHPublicKey) key;
            this.i = bCNHPublicKey;
            NHExchangePairGenerator nHExchangePairGenerator = this.j;
            if (nHExchangePairGenerator != null) {
                ExchangePair generateExchange = nHExchangePairGenerator.generateExchange(bCNHPublicKey.a);
                this.k = generateExchange.getSharedValue();
                return new BCNHPublicKey((NHPublicKeyParameters) generateExchange.getPublicKey());
            }
            this.k = this.h.calculateAgreement(bCNHPublicKey.a);
            return null;
        }
        throw new IllegalStateException("NewHope can only be between two parties.");
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        byte[] clone = Arrays.clone(this.k);
        Arrays.fill(this.k, (byte) 0);
        return clone;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key != null) {
            NHAgreement nHAgreement = new NHAgreement();
            this.h = nHAgreement;
            nHAgreement.init(((BCNHPrivateKey) key).a);
            return;
        }
        this.j = new NHExchangePairGenerator(secureRandom);
    }

    @Override // org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i2) throws IllegalStateException, ShortBufferException {
        byte[] bArr2 = this.k;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        Arrays.fill(this.k, (byte) 0);
        return this.k.length;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
    }
}
