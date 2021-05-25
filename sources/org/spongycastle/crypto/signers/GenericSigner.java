package org.spongycastle.crypto.signers;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
public class GenericSigner implements Signer {
    public final AsymmetricBlockCipher a;
    public final Digest b;
    public boolean c;

    public GenericSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this.a = asymmetricBlockCipher;
        this.b = digest;
    }

    @Override // org.spongycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.c) {
            int digestSize = this.b.getDigestSize();
            byte[] bArr = new byte[digestSize];
            this.b.doFinal(bArr, 0);
            return this.a.processBlock(bArr, 0, digestSize);
        }
        throw new IllegalStateException("GenericSigner not initialised for signature generation.");
    }

    @Override // org.spongycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.a.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("verification requires public key");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void reset() {
        this.b.reset();
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte b2) {
        this.b.update(b2);
    }

    @Override // org.spongycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        if (!this.c) {
            int digestSize = this.b.getDigestSize();
            byte[] bArr2 = new byte[digestSize];
            this.b.doFinal(bArr2, 0);
            try {
                byte[] processBlock = this.a.processBlock(bArr, 0, bArr.length);
                if (processBlock.length < digestSize) {
                    byte[] bArr3 = new byte[digestSize];
                    System.arraycopy(processBlock, 0, bArr3, digestSize - processBlock.length, processBlock.length);
                    processBlock = bArr3;
                }
                return Arrays.constantTimeAreEqual(processBlock, bArr2);
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("GenericSigner not initialised for verification");
        }
    }

    @Override // org.spongycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        this.b.update(bArr, i, i2);
    }
}
