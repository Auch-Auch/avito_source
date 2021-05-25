package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.StateAwareMessageSigner;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSSignature;
import org.spongycastle.util.Arrays;
import x6.e.f.a.d.b;
import x6.e.f.a.d.c;
import x6.e.f.a.d.h;
public class XMSSSigner implements StateAwareMessageSigner {
    public XMSSPrivateKeyParameters a;
    public XMSSPrivateKeyParameters b;
    public XMSSPublicKeyParameters c;
    public XMSSParameters d;
    public b e;
    public boolean f;
    public boolean g;

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        if (this.f) {
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.a;
            if (xMSSPrivateKeyParameters == null) {
                throw new IllegalStateException("signing key no longer usable");
            } else if (!xMSSPrivateKeyParameters.g.getAuthenticationPath().isEmpty()) {
                int index = this.a.getIndex();
                long j = (long) index;
                if (XMSSUtil.isIndexValid(this.d.getHeight(), j)) {
                    byte[] b2 = this.e.b(this.a.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(j, 32));
                    byte[] a3 = this.e.a(Arrays.concatenate(b2, this.a.getRoot(), XMSSUtil.toBytesBigEndian(j, this.d.getDigestSize())), bArr);
                    OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.Builder().withOTSAddress(index).build();
                    if (a3.length == this.d.getDigestSize()) {
                        Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
                        c cVar = this.d.a;
                        cVar.f(cVar.e(this.a.getSecretKeySeed(), oTSHashAddress), this.a.getPublicSeed());
                        XMSSSignature xMSSSignature = (XMSSSignature) new XMSSSignature.Builder(this.d).withIndex(index).withRandom(b2).withWOTSPlusSignature(this.d.a.g(a3, oTSHashAddress)).withAuthPath(this.a.g.getAuthenticationPath()).build();
                        this.g = true;
                        XMSSPrivateKeyParameters xMSSPrivateKeyParameters2 = this.b;
                        if (xMSSPrivateKeyParameters2 != null) {
                            XMSSPrivateKeyParameters nextKey = xMSSPrivateKeyParameters2.getNextKey();
                            this.a = nextKey;
                            this.b = nextKey;
                        } else {
                            this.a = null;
                        }
                        return xMSSSignature.toByteArray();
                    }
                    throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
                }
                throw new IllegalStateException("index out of bounds");
            } else {
                throw new IllegalStateException("not initialized");
            }
        } else {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
    }

    @Override // org.spongycastle.pqc.crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        if (this.g) {
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.a;
            this.a = null;
            this.b = null;
            return xMSSPrivateKeyParameters;
        }
        XMSSPrivateKeyParameters nextKey = this.b.getNextKey();
        this.b = null;
        return nextKey;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.f = true;
            this.g = false;
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) cipherParameters;
            this.a = xMSSPrivateKeyParameters;
            this.b = xMSSPrivateKeyParameters;
            XMSSParameters parameters = xMSSPrivateKeyParameters.getParameters();
            this.d = parameters;
            this.e = parameters.a.b;
            return;
        }
        this.f = false;
        XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) cipherParameters;
        this.c = xMSSPublicKeyParameters;
        XMSSParameters parameters2 = xMSSPublicKeyParameters.getParameters();
        this.d = parameters2;
        this.e = parameters2.a.b;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        XMSSSignature build = new XMSSSignature.Builder(this.d).withSignature(bArr2).build();
        int index = build.getIndex();
        XMSSParameters xMSSParameters = this.d;
        xMSSParameters.a.f(new byte[xMSSParameters.getDigestSize()], this.c.getPublicSeed());
        long j = (long) index;
        byte[] a3 = this.e.a(Arrays.concatenate(build.getRandom(), this.c.getRoot(), XMSSUtil.toBytesBigEndian(j, this.d.getDigestSize())), bArr);
        int height = this.d.getHeight();
        int leafIndex = XMSSUtil.getLeafIndex(j, height);
        return Arrays.constantTimeAreEqual(h.a(this.d.a, height, a3, build, (OTSHashAddress) new OTSHashAddress.Builder().withOTSAddress(index).build(), leafIndex).getValue(), this.c.getRoot());
    }
}
