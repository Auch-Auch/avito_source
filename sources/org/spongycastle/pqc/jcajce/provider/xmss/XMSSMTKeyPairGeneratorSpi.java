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
import org.spongycastle.pqc.crypto.xmss.XMSSMTKeyGenerationParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTKeyPairGenerator;
import org.spongycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.XMSSMTParameterSpec;
public class XMSSMTKeyPairGeneratorSpi extends KeyPairGenerator {
    public XMSSMTKeyGenerationParameters a;
    public XMSSMTKeyPairGenerator b = new XMSSMTKeyPairGenerator();
    public ASN1ObjectIdentifier c;
    public SecureRandom d = new SecureRandom();
    public boolean e = false;

    public XMSSMTKeyPairGeneratorSpi() {
        super("XMSSMT");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.e) {
            XMSSMTKeyGenerationParameters xMSSMTKeyGenerationParameters = new XMSSMTKeyGenerationParameters(new XMSSMTParameters(10, 20, new SHA512Digest()), this.d);
            this.a = xMSSMTKeyGenerationParameters;
            this.b.init(xMSSMTKeyGenerationParameters);
            this.e = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.b.generateKeyPair();
        return new KeyPair(new BCXMSSMTPublicKey(this.c, (XMSSMTPublicKeyParameters) generateKeyPair.getPublic()), new BCXMSSMTPrivateKey(this.c, (XMSSMTPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof XMSSMTParameterSpec) {
            XMSSMTParameterSpec xMSSMTParameterSpec = (XMSSMTParameterSpec) algorithmParameterSpec;
            if (xMSSMTParameterSpec.getTreeDigest().equals("SHA256")) {
                this.c = NISTObjectIdentifiers.id_sha256;
                this.a = new XMSSMTKeyGenerationParameters(new XMSSMTParameters(xMSSMTParameterSpec.getHeight(), xMSSMTParameterSpec.getLayers(), new SHA256Digest()), secureRandom);
            } else if (xMSSMTParameterSpec.getTreeDigest().equals("SHA512")) {
                this.c = NISTObjectIdentifiers.id_sha512;
                this.a = new XMSSMTKeyGenerationParameters(new XMSSMTParameters(xMSSMTParameterSpec.getHeight(), xMSSMTParameterSpec.getLayers(), new SHA512Digest()), secureRandom);
            } else if (xMSSMTParameterSpec.getTreeDigest().equals("SHAKE128")) {
                this.c = NISTObjectIdentifiers.id_shake128;
                this.a = new XMSSMTKeyGenerationParameters(new XMSSMTParameters(xMSSMTParameterSpec.getHeight(), xMSSMTParameterSpec.getLayers(), new SHAKEDigest(128)), secureRandom);
            } else if (xMSSMTParameterSpec.getTreeDigest().equals("SHAKE256")) {
                this.c = NISTObjectIdentifiers.id_shake256;
                this.a = new XMSSMTKeyGenerationParameters(new XMSSMTParameters(xMSSMTParameterSpec.getHeight(), xMSSMTParameterSpec.getLayers(), new SHAKEDigest(256)), secureRandom);
            }
            this.b.init(this.a);
            this.e = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a XMSSMTParameterSpec");
    }
}
