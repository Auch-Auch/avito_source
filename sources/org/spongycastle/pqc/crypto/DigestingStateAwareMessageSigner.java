package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
public class DigestingStateAwareMessageSigner extends DigestingMessageSigner {
    public final StateAwareMessageSigner d;

    public DigestingStateAwareMessageSigner(StateAwareMessageSigner stateAwareMessageSigner, Digest digest) {
        super(stateAwareMessageSigner, digest);
        this.d = stateAwareMessageSigner;
    }

    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        return this.d.getUpdatedPrivateKey();
    }
}
