package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Objects;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.util.Arrays;
import x6.e.f.a.d.c;
import x6.e.f.a.d.g;
public class XMSS {
    public final XMSSParameters a;
    public c b;
    public SecureRandom c;
    public XMSSPrivateKeyParameters d;
    public XMSSPublicKeyParameters e;

    public XMSS(XMSSParameters xMSSParameters, SecureRandom secureRandom) {
        Objects.requireNonNull(xMSSParameters, "params == null");
        this.a = xMSSParameters;
        this.b = xMSSParameters.a;
        this.c = secureRandom;
    }

    public byte[] exportPrivateKey() {
        return this.d.toByteArray();
    }

    public byte[] exportPublicKey() {
        return this.e.toByteArray();
    }

    public void generateKeys() {
        XMSSKeyPairGenerator xMSSKeyPairGenerator = new XMSSKeyPairGenerator();
        xMSSKeyPairGenerator.init(new XMSSKeyGenerationParameters(getParams(), this.c));
        AsymmetricCipherKeyPair generateKeyPair = xMSSKeyPairGenerator.generateKeyPair();
        this.d = (XMSSPrivateKeyParameters) generateKeyPair.getPrivate();
        this.e = (XMSSPublicKeyParameters) generateKeyPair.getPublic();
        this.b.f(new byte[this.a.getDigestSize()], this.d.getPublicSeed());
    }

    public int getIndex() {
        return this.d.getIndex();
    }

    public XMSSParameters getParams() {
        return this.a;
    }

    public XMSSPrivateKeyParameters getPrivateKey() {
        return this.d;
    }

    public byte[] getPublicSeed() {
        return this.d.getPublicSeed();
    }

    public byte[] getRoot() {
        return this.d.getRoot();
    }

    public c getWOTSPlus() {
        return this.b;
    }

    public void importState(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "privateKey == null");
        Objects.requireNonNull(bArr2, "publicKey == null");
        XMSSPrivateKeyParameters build = new XMSSPrivateKeyParameters.Builder(this.a).withPrivateKey(bArr, getParams()).build();
        XMSSPublicKeyParameters build2 = new XMSSPublicKeyParameters.Builder(this.a).withPublicKey(bArr2).build();
        if (!Arrays.areEqual(build.getRoot(), build2.getRoot())) {
            throw new IllegalStateException("root of private key and public key do not match");
        } else if (Arrays.areEqual(build.getPublicSeed(), build2.getPublicSeed())) {
            this.d = build;
            this.e = build2;
            this.b.f(new byte[this.a.getDigestSize()], this.d.getPublicSeed());
        } else {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
    }

    public void setIndex(int i) {
        this.d = new XMSSPrivateKeyParameters.Builder(this.a).withSecretKeySeed(this.d.getSecretKeySeed()).withSecretKeyPRF(this.d.getSecretKeyPRF()).withPublicSeed(this.d.getPublicSeed()).withRoot(this.d.getRoot()).withBDSState(this.d.g).build();
    }

    public void setPublicSeed(byte[] bArr) {
        this.d = new XMSSPrivateKeyParameters.Builder(this.a).withSecretKeySeed(this.d.getSecretKeySeed()).withSecretKeyPRF(this.d.getSecretKeyPRF()).withPublicSeed(bArr).withRoot(getRoot()).withBDSState(this.d.g).build();
        this.e = new XMSSPublicKeyParameters.Builder(this.a).withRoot(getRoot()).withPublicSeed(bArr).build();
        this.b.f(new byte[this.a.getDigestSize()], bArr);
    }

    public void setRoot(byte[] bArr) {
        this.d = new XMSSPrivateKeyParameters.Builder(this.a).withSecretKeySeed(this.d.getSecretKeySeed()).withSecretKeyPRF(this.d.getSecretKeyPRF()).withPublicSeed(getPublicSeed()).withRoot(bArr).withBDSState(this.d.g).build();
        this.e = new XMSSPublicKeyParameters.Builder(this.a).withRoot(bArr).withPublicSeed(getPublicSeed()).build();
    }

    public byte[] sign(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        XMSSSigner xMSSSigner = new XMSSSigner();
        xMSSSigner.init(true, this.d);
        byte[] generateSignature = xMSSSigner.generateSignature(bArr);
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) xMSSSigner.getUpdatedPrivateKey();
        this.d = xMSSPrivateKeyParameters;
        XMSSPublicKeyParameters xMSSPublicKeyParameters = this.e;
        if (!Arrays.areEqual(xMSSPrivateKeyParameters.getRoot(), xMSSPublicKeyParameters.getRoot())) {
            throw new IllegalStateException("root of private key and public key do not match");
        } else if (Arrays.areEqual(xMSSPrivateKeyParameters.getPublicSeed(), xMSSPublicKeyParameters.getPublicSeed())) {
            this.d = xMSSPrivateKeyParameters;
            this.e = xMSSPublicKeyParameters;
            this.b.f(new byte[this.a.getDigestSize()], this.d.getPublicSeed());
            return generateSignature;
        } else {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2, byte[] bArr3) throws ParseException {
        Objects.requireNonNull(bArr, "message == null");
        Objects.requireNonNull(bArr2, "signature == null");
        Objects.requireNonNull(bArr3, "publicKey == null");
        XMSSSigner xMSSSigner = new XMSSSigner();
        xMSSSigner.init(false, new XMSSPublicKeyParameters.Builder(getParams()).withPublicKey(bArr3).build());
        return xMSSSigner.verifySignature(bArr, bArr2);
    }

    public g wotsSign(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length == this.a.getDigestSize()) {
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            c cVar = this.b;
            cVar.f(cVar.e(this.d.getSecretKeySeed(), oTSHashAddress), getPublicSeed());
            return this.b.g(bArr, oTSHashAddress);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
