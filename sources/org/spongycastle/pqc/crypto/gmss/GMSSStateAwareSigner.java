package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.StateAwareMessageSigner;
import org.spongycastle.util.Memoable;
public class GMSSStateAwareSigner implements StateAwareMessageSigner {
    public final GMSSSigner a;
    public GMSSPrivateKeyParameters b;

    public class a implements GMSSDigestProvider {
        public final /* synthetic */ Memoable a;

        public a(GMSSStateAwareSigner gMSSStateAwareSigner, Memoable memoable) {
            this.a = memoable;
        }

        @Override // org.spongycastle.pqc.crypto.gmss.GMSSDigestProvider
        public Digest get() {
            return (Digest) this.a.copy();
        }
    }

    public GMSSStateAwareSigner(Digest digest) {
        if (digest instanceof Memoable) {
            this.a = new GMSSSigner(new a(this, ((Memoable) digest).copy()));
            return;
        }
        throw new IllegalArgumentException("digest must implement Memoable");
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        if (this.b != null) {
            byte[] generateSignature = this.a.generateSignature(bArr);
            this.b = this.b.nextKey();
            return generateSignature;
        }
        throw new IllegalStateException("signing key no longer usable");
    }

    @Override // org.spongycastle.pqc.crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = this.b;
        this.b = null;
        return gMSSPrivateKeyParameters;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                this.b = (GMSSPrivateKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters();
            } else {
                this.b = (GMSSPrivateKeyParameters) cipherParameters;
            }
        }
        this.a.init(z, cipherParameters);
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        return this.a.verifySignature(bArr, bArr2);
    }
}
