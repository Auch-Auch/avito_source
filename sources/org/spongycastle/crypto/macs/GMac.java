package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
public class GMac implements Mac {
    public final GCMBlockCipher a;
    public final int b;

    public GMac(GCMBlockCipher gCMBlockCipher) {
        this.a = gCMBlockCipher;
        this.b = 128;
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
        return this.a.getUnderlyingCipher().getAlgorithmName() + "-GMAC";
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
        throw new IllegalArgumentException("GMAC requires ParametersWithIV");
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

    public GMac(GCMBlockCipher gCMBlockCipher, int i) {
        this.a = gCMBlockCipher;
        this.b = i;
    }
}
