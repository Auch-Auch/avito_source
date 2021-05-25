package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
public final class XMSSMTKeyPairGenerator {
    public XMSSMTParameters a;
    public XMSSParameters b;
    public SecureRandom c;

    public AsymmetricCipherKeyPair generateKeyPair() {
        BDSStateMap bDSStateMap = new XMSSMTPrivateKeyParameters.Builder(this.a).build().i;
        int digestSize = this.a.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.c.nextBytes(bArr);
        byte[] bArr2 = new byte[digestSize];
        this.c.nextBytes(bArr2);
        byte[] bArr3 = new byte[digestSize];
        this.c.nextBytes(bArr3);
        XMSSMTPrivateKeyParameters build = new XMSSMTPrivateKeyParameters.Builder(this.a).withSecretKeySeed(bArr).withSecretKeyPRF(bArr2).withPublicSeed(bArr3).withBDSState(bDSStateMap).build();
        this.b.a.f(new byte[this.a.getDigestSize()], build.getPublicSeed());
        int layers = this.a.getLayers() - 1;
        BDS bds = new BDS(this.b, build.getPublicSeed(), build.getSecretKeySeed(), (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(layers)).build());
        XMSSNode root = bds.getRoot();
        build.i.put(layers, bds);
        XMSSMTPrivateKeyParameters build2 = new XMSSMTPrivateKeyParameters.Builder(this.a).withSecretKeySeed(build.getSecretKeySeed()).withSecretKeyPRF(build.getSecretKeyPRF()).withPublicSeed(build.getPublicSeed()).withRoot(root.getValue()).withBDSState(build.i).build();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XMSSMTPublicKeyParameters.Builder(this.a).withRoot(root.getValue()).withPublicSeed(build2.getPublicSeed()).build(), (AsymmetricKeyParameter) build2);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        XMSSMTKeyGenerationParameters xMSSMTKeyGenerationParameters = (XMSSMTKeyGenerationParameters) keyGenerationParameters;
        this.c = xMSSMTKeyGenerationParameters.getRandom();
        XMSSMTParameters parameters = xMSSMTKeyGenerationParameters.getParameters();
        this.a = parameters;
        this.b = parameters.getXMSSParameters();
    }
}
