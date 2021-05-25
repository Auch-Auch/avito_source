package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.util.Pack;
public class CryptoProWrapEngine extends GOST28147WrapEngine {
    @Override // org.spongycastle.crypto.engines.GOST28147WrapEngine, org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] bArr;
        KeyParameter keyParameter;
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof ParametersWithRandom) {
            cipherParameters2 = ((ParametersWithRandom) cipherParameters2).getParameters();
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters2;
        if (parametersWithUKM.getParameters() instanceof ParametersWithSBox) {
            keyParameter = (KeyParameter) ((ParametersWithSBox) parametersWithUKM.getParameters()).getParameters();
            bArr = ((ParametersWithSBox) parametersWithUKM.getParameters()).getSBox();
        } else {
            bArr = null;
            keyParameter = (KeyParameter) parametersWithUKM.getParameters();
        }
        byte[] key = keyParameter.getKey();
        byte[] ukm = parametersWithUKM.getUKM();
        for (int i = 0; i != 8; i++) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 == 8) {
                    break;
                }
                int littleEndianToInt = Pack.littleEndianToInt(key, i2 * 4);
                if ((ukm[i] & (1 << i2)) == 0) {
                    z2 = false;
                }
                if (z2) {
                    i3 += littleEndianToInt;
                } else {
                    i4 += littleEndianToInt;
                }
                i2++;
            }
            byte[] bArr2 = new byte[8];
            Pack.intToLittleEndian(i3, bArr2, 0);
            Pack.intToLittleEndian(i4, bArr2, 4);
            GCFBBlockCipher gCFBBlockCipher = new GCFBBlockCipher(new GOST28147Engine());
            gCFBBlockCipher.init(true, new ParametersWithIV(new ParametersWithSBox(new KeyParameter(key), bArr), bArr2));
            gCFBBlockCipher.processBlock(key, 0, key, 0);
            gCFBBlockCipher.processBlock(key, 8, key, 8);
            gCFBBlockCipher.processBlock(key, 16, key, 16);
            gCFBBlockCipher.processBlock(key, 24, key, 24);
        }
        KeyParameter keyParameter2 = new KeyParameter(key);
        if (bArr != null) {
            super.init(z, new ParametersWithUKM(new ParametersWithSBox(keyParameter2, bArr), parametersWithUKM.getUKM()));
        } else {
            super.init(z, new ParametersWithUKM(keyParameter2, parametersWithUKM.getUKM()));
        }
    }
}
