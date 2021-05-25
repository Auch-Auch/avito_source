package org.spongycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.crypto.newhope.NHKeyPairGenerator;
import org.spongycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;
public class NHKeyPairGeneratorSpi extends KeyPairGenerator {
    public NHKeyPairGenerator a = new NHKeyPairGenerator();
    public SecureRandom b = new SecureRandom();
    public boolean c = false;

    public NHKeyPairGeneratorSpi() {
        super("NH");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.c) {
            this.a.init(new KeyGenerationParameters(this.b, 1024));
            this.c = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.a.generateKeyPair();
        return new KeyPair(new BCNHPublicKey((NHPublicKeyParameters) generateKeyPair.getPublic()), new BCNHPrivateKey((NHPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        if (i == 1024) {
            this.a.init(new KeyGenerationParameters(secureRandom, 1024));
            this.c = true;
            return;
        }
        throw new IllegalArgumentException("strength must be 1024 bits");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("parameter object not recognised");
    }
}
