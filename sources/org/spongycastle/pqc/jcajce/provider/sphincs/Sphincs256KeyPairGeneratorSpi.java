package org.spongycastle.pqc.jcajce.provider.sphincs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA3Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters;
import org.spongycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;
public class Sphincs256KeyPairGeneratorSpi extends KeyPairGenerator {
    public ASN1ObjectIdentifier a = NISTObjectIdentifiers.id_sha512_256;
    public SPHINCS256KeyGenerationParameters b;
    public SPHINCS256KeyPairGenerator c = new SPHINCS256KeyPairGenerator();
    public SecureRandom d = new SecureRandom();
    public boolean e = false;

    public Sphincs256KeyPairGeneratorSpi() {
        super("SPHINCS256");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.e) {
            SPHINCS256KeyGenerationParameters sPHINCS256KeyGenerationParameters = new SPHINCS256KeyGenerationParameters(this.d, new SHA512tDigest(256));
            this.b = sPHINCS256KeyGenerationParameters;
            this.c.init(sPHINCS256KeyGenerationParameters);
            this.e = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.c.generateKeyPair();
        return new KeyPair(new BCSphincs256PublicKey(this.a, (SPHINCSPublicKeyParameters) generateKeyPair.getPublic()), new BCSphincs256PrivateKey(this.a, (SPHINCSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SPHINCS256KeyGenParameterSpec) {
            SPHINCS256KeyGenParameterSpec sPHINCS256KeyGenParameterSpec = (SPHINCS256KeyGenParameterSpec) algorithmParameterSpec;
            if (sPHINCS256KeyGenParameterSpec.getTreeDigest().equals(SPHINCS256KeyGenParameterSpec.SHA512_256)) {
                this.a = NISTObjectIdentifiers.id_sha512_256;
                this.b = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA512tDigest(256));
            } else if (sPHINCS256KeyGenParameterSpec.getTreeDigest().equals(SPHINCS256KeyGenParameterSpec.SHA3_256)) {
                this.a = NISTObjectIdentifiers.id_sha3_256;
                this.b = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA3Digest(256));
            }
            this.c.init(this.b);
            this.e = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
    }
}
