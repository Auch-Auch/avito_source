package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;
public class RainbowSigner implements MessageSigner {
    public SecureRandom a;
    public int b;
    public short[] c;
    public ComputeInField d = new ComputeInField();
    public RainbowKeyParameters e;

    public final short[] a(Layer[] layerArr, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        short[] multiplyMatrix = this.d.multiplyMatrix(((RainbowPrivateKeyParameters) this.e).getInvA1(), this.d.addVect(((RainbowPrivateKeyParameters) this.e).getB1(), sArr));
        for (int i = 0; i < layerArr[0].getVi(); i++) {
            this.c[i] = (short) this.a.nextInt();
            short[] sArr3 = this.c;
            sArr3[i] = (short) (sArr3[i] & 255);
        }
        return multiplyMatrix;
    }

    public final short[] b(byte[] bArr) {
        int i = this.b;
        short[] sArr = new short[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            sArr[i2] = (short) bArr[i3];
            sArr[i2] = (short) (sArr[i2] & 255);
            i3++;
            i2++;
            if (i2 >= i) {
                break;
            }
        }
        return sArr;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        boolean z;
        Layer[] layers = ((RainbowPrivateKeyParameters) this.e).getLayers();
        int length = layers.length;
        this.c = new short[((RainbowPrivateKeyParameters) this.e).getInvA2().length];
        int viNext = layers[length - 1].getViNext();
        byte[] bArr2 = new byte[viNext];
        short[] b2 = b(bArr);
        int i = 0;
        do {
            try {
                short[] a3 = a(layers, b2);
                int i2 = 0;
                for (int i3 = 0; i3 < length; i3++) {
                    short[] sArr = new short[layers[i3].getOi()];
                    short[] sArr2 = new short[layers[i3].getOi()];
                    for (int i4 = 0; i4 < layers[i3].getOi(); i4++) {
                        sArr[i4] = a3[i2];
                        i2++;
                    }
                    short[] solveEquation = this.d.solveEquation(layers[i3].plugInVinegars(this.c), sArr);
                    if (solveEquation != null) {
                        for (int i5 = 0; i5 < solveEquation.length; i5++) {
                            this.c[layers[i3].getVi() + i5] = solveEquation[i5];
                        }
                    } else {
                        throw new Exception("LES is not solveable!");
                    }
                }
                short[] multiplyMatrix = this.d.multiplyMatrix(((RainbowPrivateKeyParameters) this.e).getInvA2(), this.d.addVect(((RainbowPrivateKeyParameters) this.e).getB2(), this.c));
                for (int i6 = 0; i6 < viNext; i6++) {
                    bArr2[i6] = (byte) multiplyMatrix[i6];
                }
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                break;
            }
            i++;
        } while (i < 65536);
        if (i != 65536) {
            return bArr2;
        }
        throw new IllegalStateException("unable to generate signature - LES not solvable");
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.e = (RainbowPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.getRandom();
            this.e = (RainbowPrivateKeyParameters) parametersWithRandom.getParameters();
        } else {
            this.a = new SecureRandom();
            this.e = (RainbowPrivateKeyParameters) cipherParameters;
        }
        this.b = this.e.getDocLength();
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        short[] sArr = new short[bArr2.length];
        for (int i = 0; i < bArr2.length; i++) {
            sArr[i] = (short) (((short) bArr2[i]) & 255);
        }
        short[] b2 = b(bArr);
        short[][] coeffQuadratic = ((RainbowPublicKeyParameters) this.e).getCoeffQuadratic();
        short[][] coeffSingular = ((RainbowPublicKeyParameters) this.e).getCoeffSingular();
        short[] coeffScalar = ((RainbowPublicKeyParameters) this.e).getCoeffScalar();
        int length = coeffQuadratic.length;
        short[] sArr2 = new short[length];
        int length2 = coeffSingular[0].length;
        for (int i2 = 0; i2 < coeffQuadratic.length; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < length2; i4++) {
                for (int i5 = i4; i5 < length2; i5++) {
                    sArr2[i2] = GF2Field.addElem(sArr2[i2], GF2Field.multElem(coeffQuadratic[i2][i3], GF2Field.multElem(sArr[i4], sArr[i5])));
                    i3++;
                }
                sArr2[i2] = GF2Field.addElem(sArr2[i2], GF2Field.multElem(coeffSingular[i2][i4], sArr[i4]));
            }
            sArr2[i2] = GF2Field.addElem(sArr2[i2], coeffScalar[i2]);
        }
        if (b2.length != length) {
            return false;
        }
        boolean z = true;
        for (int i6 = 0; i6 < b2.length; i6++) {
            z = z && b2[i6] == sArr2[i6];
        }
        return z;
    }
}
