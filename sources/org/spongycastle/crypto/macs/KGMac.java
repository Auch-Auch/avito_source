package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.KGCMBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class KGMac implements Mac {
    public final KGCMBlockCipher a;
    public final int b;

    public KGMac(KGCMBlockCipher kGCMBlockCipher) {
        this.a = kGCMBlockCipher;
        this.b = kGCMBlockCipher.getUnderlyingCipher().getBlockSize() * 8;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        try {
            return this.a.doFinal(bArr, i);
        } catch (InvalidCipherTextException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.a.getUnderlyingCipher().getAlgorithmName() + "-KGMAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.b / 8;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.a.init(true, new AEADParameters((KeyParameter) parametersWithIV.getParameters(), this.b, parametersWithIV.getIV()));
            return;
        }
        throw new IllegalArgumentException("KGMAC requires ParametersWithIV");
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) throws IllegalStateException {
        this.a.processAADByte(b2);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        this.a.processAADBytes(bArr, i, i2);
    }

    public KGMac(KGCMBlockCipher kGCMBlockCipher, int i) {
        this.a = kGCMBlockCipher;
        this.b = i;
    }
}
