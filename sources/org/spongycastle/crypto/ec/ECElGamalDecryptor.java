package org.spongycastle.crypto.ec;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.math.ec.ECPoint;
public class ECElGamalDecryptor implements ECDecryptor {
    public ECPrivateKeyParameters a;

    @Override // org.spongycastle.crypto.ec.ECDecryptor
    public ECPoint decrypt(ECPair eCPair) {
        if (this.a != null) {
            return eCPair.getY().subtract(eCPair.getX().multiply(this.a.getD())).normalize();
        }
        throw new IllegalStateException("ECElGamalDecryptor not initialised");
    }

    @Override // org.spongycastle.crypto.ec.ECDecryptor
    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ECPrivateKeyParameters) {
            this.a = (ECPrivateKeyParameters) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
    }
}
