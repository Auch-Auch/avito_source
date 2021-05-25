package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Objects;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.util.Arrays;
public final class XMSSMT {
    public XMSSMTParameters a;
    public XMSSParameters b;
    public SecureRandom c;
    public XMSSMTPrivateKeyParameters d;
    public XMSSMTPublicKeyParameters e;

    public XMSSMT(XMSSMTParameters xMSSMTParameters, SecureRandom secureRandom) {
        Objects.requireNonNull(xMSSMTParameters, "params == null");
        this.a = xMSSMTParameters;
        this.b = xMSSMTParameters.getXMSSParameters();
        this.c = secureRandom;
        this.d = new XMSSMTPrivateKeyParameters.Builder(xMSSMTParameters).build();
        this.e = new XMSSMTPublicKeyParameters.Builder(xMSSMTParameters).build();
    }

    public final void a(XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters, XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters) {
        this.b.a.f(new byte[this.a.getDigestSize()], this.d.getPublicSeed());
        this.d = xMSSMTPrivateKeyParameters;
        this.e = xMSSMTPublicKeyParameters;
    }

    public byte[] exportPrivateKey() {
        return this.d.toByteArray();
    }

    public byte[] exportPublicKey() {
        return this.e.toByteArray();
    }

    public void generateKeys() {
        XMSSMTKeyPairGenerator xMSSMTKeyPairGenerator = new XMSSMTKeyPairGenerator();
        xMSSMTKeyPairGenerator.init(new XMSSMTKeyGenerationParameters(getParams(), this.c));
        AsymmetricCipherKeyPair generateKeyPair = xMSSMTKeyPairGenerator.generateKeyPair();
        this.d = (XMSSMTPrivateKeyParameters) generateKeyPair.getPrivate();
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) generateKeyPair.getPublic();
        this.e = xMSSMTPublicKeyParameters;
        a(this.d, xMSSMTPublicKeyParameters);
    }

    public XMSSMTParameters getParams() {
        return this.a;
    }

    public byte[] getPublicSeed() {
        return this.d.getPublicSeed();
    }

    public XMSSParameters getXMSS() {
        return this.b;
    }

    public void importState(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "privateKey == null");
        Objects.requireNonNull(bArr2, "publicKey == null");
        XMSSMTPrivateKeyParameters build = new XMSSMTPrivateKeyParameters.Builder(this.a).withPrivateKey(bArr, this.b).build();
        XMSSMTPublicKeyParameters build2 = new XMSSMTPublicKeyParameters.Builder(this.a).withPublicKey(bArr2).build();
        if (!Arrays.areEqual(build.getRoot(), build2.getRoot())) {
            throw new IllegalStateException("root of private key and public key do not match");
        } else if (Arrays.areEqual(build.getPublicSeed(), build2.getPublicSeed())) {
            this.b.a.f(new byte[this.a.getDigestSize()], build.getPublicSeed());
            this.d = build;
            this.e = build2;
        } else {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
    }

    public byte[] sign(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        XMSSMTSigner xMSSMTSigner = new XMSSMTSigner();
        xMSSMTSigner.init(true, this.d);
        byte[] generateSignature = xMSSMTSigner.generateSignature(bArr);
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) xMSSMTSigner.getUpdatedPrivateKey();
        this.d = xMSSMTPrivateKeyParameters;
        a(xMSSMTPrivateKeyParameters, this.e);
        return generateSignature;
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3) throws ParseException {
        Objects.requireNonNull(bArr, "message == null");
        Objects.requireNonNull(bArr2, "signature == null");
        Objects.requireNonNull(bArr3, "publicKey == null");
        XMSSMTSigner xMSSMTSigner = new XMSSMTSigner();
        xMSSMTSigner.init(false, new XMSSMTPublicKeyParameters.Builder(getParams()).withPublicKey(bArr3).build());
        return xMSSMTSigner.verifySignature(bArr, bArr2);
    }
}
