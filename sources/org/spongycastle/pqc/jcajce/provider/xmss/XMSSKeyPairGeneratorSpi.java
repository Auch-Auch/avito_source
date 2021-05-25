package org.spongycastle.pqc.jcajce.provider.xmss;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHAKEDigest;
import org.spongycastle.pqc.crypto.xmss.XMSSKeyGenerationParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSKeyPairGenerator;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.XMSSParameterSpec;
public class XMSSKeyPairGeneratorSpi extends KeyPairGenerator {
    public XMSSKeyGenerationParameters a;
    public ASN1ObjectIdentifier b;
    public XMSSKeyPairGenerator c = new XMSSKeyPairGenerator();
    public SecureRandom d = new SecureRandom();
    public boolean e = false;

    public XMSSKeyPairGeneratorSpi() {
        super("XMSS");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.e) {
            XMSSKeyGenerationParameters xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(10, new SHA512Digest()), this.d);
            this.a = xMSSKeyGenerationParameters;
            this.c.init(xMSSKeyGenerationParameters);
            this.e = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.c.generateKeyPair();
        return new KeyPair(new BCXMSSPublicKey(this.b, (XMSSPublicKeyParameters) generateKeyPair.getPublic()), new BCXMSSPrivateKey(this.b, (XMSSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof XMSSParameterSpec) {
            XMSSParameterSpec xMSSParameterSpec = (XMSSParameterSpec) algorithmParameterSpec;
            if (xMSSParameterSpec.getTreeDigest().equals("SHA256")) {
                this.b = NISTObjectIdentifiers.id_sha256;
                this.a = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHA256Digest()), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHA512")) {
                this.b = NISTObjectIdentifiers.id_sha512;
                this.a = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHA512Digest()), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHAKE128")) {
                this.b = NISTObjectIdentifiers.id_shake128;
                this.a = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHAKEDigest(128)), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHAKE256")) {
                this.b = NISTObjectIdentifiers.id_shake256;
                this.a = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHAKEDigest(256)), secureRandom);
            }
            this.c.init(this.a);
            this.e = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a XMSSParameterSpec");
    }
}
