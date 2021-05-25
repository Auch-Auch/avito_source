package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
public final class XMSSKeyPairGenerator {
    public XMSSParameters a;
    public SecureRandom b;

    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSParameters xMSSParameters = this.a;
        SecureRandom secureRandom = this.b;
        int digestSize = xMSSParameters.getDigestSize();
        byte[] bArr = new byte[digestSize];
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[digestSize];
        secureRandom.nextBytes(bArr2);
        byte[] bArr3 = new byte[digestSize];
        secureRandom.nextBytes(bArr3);
        XMSSPrivateKeyParameters.Builder withPublicSeed = new XMSSPrivateKeyParameters.Builder(xMSSParameters).withSecretKeySeed(bArr).withSecretKeyPRF(bArr2).withPublicSeed(bArr3);
        BDS bds = new BDS(xMSSParameters.a, xMSSParameters.getHeight(), xMSSParameters.c);
        bds.a(bArr3, bArr, (OTSHashAddress) new OTSHashAddress.Builder().build());
        XMSSPrivateKeyParameters build = withPublicSeed.withBDSState(bds).build();
        XMSSNode root = build.g.getRoot();
        XMSSPrivateKeyParameters build2 = new XMSSPrivateKeyParameters.Builder(this.a).withSecretKeySeed(build.getSecretKeySeed()).withSecretKeyPRF(build.getSecretKeyPRF()).withPublicSeed(build.getPublicSeed()).withRoot(root.getValue()).withBDSState(build.g).build();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XMSSPublicKeyParameters.Builder(this.a).withRoot(root.getValue()).withPublicSeed(build2.getPublicSeed()).build(), (AsymmetricKeyParameter) build2);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        XMSSKeyGenerationParameters xMSSKeyGenerationParameters = (XMSSKeyGenerationParameters) keyGenerationParameters;
        this.b = xMSSKeyGenerationParameters.getRandom();
        this.a = xMSSKeyGenerationParameters.getParameters();
    }
}
