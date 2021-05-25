package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.DSAKeyPairGenerator;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Properties;
public class KeyPairGeneratorSpi extends KeyPairGenerator {
    public static Hashtable f = new Hashtable();
    public static Object g = new Object();
    public DSAKeyGenerationParameters a;
    public DSAKeyPairGenerator b = new DSAKeyPairGenerator();
    public int c = 2048;
    public SecureRandom d = new SecureRandom();
    public boolean e = false;

    public KeyPairGeneratorSpi() {
        super("DSA");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        DSAParametersGenerator dSAParametersGenerator;
        if (!this.e) {
            Integer valueOf = Integers.valueOf(this.c);
            if (f.containsKey(valueOf)) {
                this.a = (DSAKeyGenerationParameters) f.get(valueOf);
            } else {
                synchronized (g) {
                    if (f.containsKey(valueOf)) {
                        this.a = (DSAKeyGenerationParameters) f.get(valueOf);
                    } else {
                        int defaultCertainty = PrimeCertaintyCalculator.getDefaultCertainty(this.c);
                        int i = this.c;
                        if (i == 1024) {
                            dSAParametersGenerator = new DSAParametersGenerator();
                            if (Properties.isOverrideSet("org.spongycastle.dsa.FIPS186-2for1024bits")) {
                                dSAParametersGenerator.init(this.c, defaultCertainty, this.d);
                            } else {
                                dSAParametersGenerator.init(new DSAParameterGenerationParameters(1024, 160, defaultCertainty, this.d));
                            }
                        } else if (i > 1024) {
                            DSAParameterGenerationParameters dSAParameterGenerationParameters = new DSAParameterGenerationParameters(i, 256, defaultCertainty, this.d);
                            dSAParametersGenerator = new DSAParametersGenerator(new SHA256Digest());
                            dSAParametersGenerator.init(dSAParameterGenerationParameters);
                        } else {
                            dSAParametersGenerator = new DSAParametersGenerator();
                            dSAParametersGenerator.init(this.c, defaultCertainty, this.d);
                        }
                        DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(this.d, dSAParametersGenerator.generateParameters());
                        this.a = dSAKeyGenerationParameters;
                        f.put(valueOf, dSAKeyGenerationParameters);
                    }
                }
            }
            this.b.init(this.a);
            this.e = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.b.generateKeyPair();
        return new KeyPair(new BCDSAPublicKey((DSAPublicKeyParameters) generateKeyPair.getPublic()), new BCDSAPrivateKey((DSAPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 4096 || ((i < 1024 && i % 64 != 0) || (i >= 1024 && i % 1024 != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        this.c = i;
        this.d = secureRandom;
        this.e = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
            DSAKeyGenerationParameters dSAKeyGenerationParameters = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
            this.a = dSAKeyGenerationParameters;
            this.b.init(dSAKeyGenerationParameters);
            this.e = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
    }
}
