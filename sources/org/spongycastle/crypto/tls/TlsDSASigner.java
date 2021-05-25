package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSADigestSigner;
public abstract class TlsDSASigner extends AbstractTlsSigner {
    public abstract DSA createDSAImpl(short s);

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public Signer createSigner(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter) {
        return makeSigner(signatureAndHashAlgorithm, false, true, asymmetricKeyParameter);
    }

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public Signer createVerifyer(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter) {
        return makeSigner(signatureAndHashAlgorithm, false, false, asymmetricKeyParameter);
    }

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public byte[] generateRawSignature(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) throws CryptoException {
        Signer makeSigner = makeSigner(signatureAndHashAlgorithm, true, true, new ParametersWithRandom(asymmetricKeyParameter, this.context.getSecureRandom()));
        if (signatureAndHashAlgorithm == null) {
            makeSigner.update(bArr, 16, 20);
        } else {
            makeSigner.update(bArr, 0, bArr.length);
        }
        return makeSigner.generateSignature();
    }

    public abstract short getSignatureAlgorithm();

    public CipherParameters makeInitParameters(boolean z, CipherParameters cipherParameters) {
        return cipherParameters;
    }

    public Signer makeSigner(SignatureAndHashAlgorithm signatureAndHashAlgorithm, boolean z, boolean z2, CipherParameters cipherParameters) {
        short s;
        if ((signatureAndHashAlgorithm != null) != TlsUtils.isTLSv12(this.context)) {
            throw new IllegalStateException();
        } else if (signatureAndHashAlgorithm == null || signatureAndHashAlgorithm.getSignature() == getSignatureAlgorithm()) {
            if (signatureAndHashAlgorithm == null) {
                s = 2;
            } else {
                s = signatureAndHashAlgorithm.getHash();
            }
            DSADigestSigner dSADigestSigner = new DSADigestSigner(createDSAImpl(s), z ? new NullDigest() : TlsUtils.createHash(s));
            dSADigestSigner.init(z2, makeInitParameters(z2, cipherParameters));
            return dSADigestSigner;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public boolean verifyRawSignature(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr2) throws CryptoException {
        Signer makeSigner = makeSigner(signatureAndHashAlgorithm, true, false, asymmetricKeyParameter);
        if (signatureAndHashAlgorithm == null) {
            makeSigner.update(bArr2, 16, 20);
        } else {
            makeSigner.update(bArr2, 0, bArr2.length);
        }
        return makeSigner.verifySignature(bArr);
    }
}
