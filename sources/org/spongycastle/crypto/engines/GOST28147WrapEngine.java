package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.macs.GOST28147Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.util.Arrays;
public class GOST28147WrapEngine implements Wrapper {
    public GOST28147Engine a = new GOST28147Engine();
    public GOST28147Mac b = new GOST28147Mac();

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "GOST28147Wrap";
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.a.init(z, parametersWithUKM.getParameters());
        if (parametersWithUKM.getParameters() instanceof ParametersWithSBox) {
            keyParameter = (KeyParameter) ((ParametersWithSBox) parametersWithUKM.getParameters()).getParameters();
        } else {
            keyParameter = (KeyParameter) parametersWithUKM.getParameters();
        }
        this.b.init(new ParametersWithIV(keyParameter, parametersWithUKM.getUKM()));
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int macSize = i2 - this.b.getMacSize();
        byte[] bArr2 = new byte[macSize];
        this.a.processBlock(bArr, i, bArr2, 0);
        this.a.processBlock(bArr, i + 8, bArr2, 8);
        this.a.processBlock(bArr, i + 16, bArr2, 16);
        this.a.processBlock(bArr, i + 24, bArr2, 24);
        byte[] bArr3 = new byte[this.b.getMacSize()];
        this.b.update(bArr2, 0, macSize);
        this.b.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[this.b.getMacSize()];
        System.arraycopy(bArr, (i + i2) - 4, bArr4, 0, this.b.getMacSize());
        if (Arrays.constantTimeAreEqual(bArr3, bArr4)) {
            return bArr2;
        }
        throw new IllegalStateException("mac mismatch");
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i, int i2) {
        this.b.update(bArr, i, i2);
        byte[] bArr2 = new byte[(this.b.getMacSize() + i2)];
        this.a.processBlock(bArr, i, bArr2, 0);
        this.a.processBlock(bArr, i + 8, bArr2, 8);
        this.a.processBlock(bArr, i + 16, bArr2, 16);
        this.a.processBlock(bArr, i + 24, bArr2, 24);
        this.b.doFinal(bArr2, i2);
        return bArr2;
    }
}
