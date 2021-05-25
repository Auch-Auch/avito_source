package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Integers;
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public static Hashtable f = new Hashtable();
    public static Object g = new Object();
    public DHKeyGenerationParameters a;
    public DHBasicKeyPairGenerator b = new DHBasicKeyPairGenerator();
    public int c = 2048;
    public SecureRandom d = new SecureRandom();
    public boolean e = false;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.e) {
            Integer valueOf = Integers.valueOf(this.c);
            if (f.containsKey(valueOf)) {
                this.a = (DHKeyGenerationParameters) f.get(valueOf);
            } else {
                DHParameterSpec dHDefaultParameters = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.c);
                if (dHDefaultParameters != null) {
                    this.a = new DHKeyGenerationParameters(this.d, new DHParameters(dHDefaultParameters.getP(), dHDefaultParameters.getG(), null, dHDefaultParameters.getL()));
                } else {
                    synchronized (g) {
                        if (f.containsKey(valueOf)) {
                            this.a = (DHKeyGenerationParameters) f.get(valueOf);
                        } else {
                            DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                            int i = this.c;
                            dHParametersGenerator.init(i, PrimeCertaintyCalculator.getDefaultCertainty(i), this.d);
                            DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(this.d, dHParametersGenerator.generateParameters());
                            this.a = dHKeyGenerationParameters;
                            f.put(valueOf, dHKeyGenerationParameters);
                        }
                    }
                }
            }
            this.b.init(this.a);
            this.e = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.b.generateKeyPair();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters) generateKeyPair.getPublic()), new BCDHPrivateKey((DHPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.c = i;
        this.d = secureRandom;
        this.e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            DHKeyGenerationParameters dHKeyGenerationParameters = new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), null, dHParameterSpec.getL()));
            this.a = dHKeyGenerationParameters;
            this.b.init(dHKeyGenerationParameters);
            this.e = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
    }
}
