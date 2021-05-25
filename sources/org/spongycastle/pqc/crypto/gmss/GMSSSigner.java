package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.GMSSUtil;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.spongycastle.util.Arrays;
public class GMSSSigner implements MessageSigner {
    public GMSSUtil a = new GMSSUtil();
    public byte[] b;
    public Digest c;
    public int d;
    public int e;
    public Digest f;
    public WinternitzOTSignature g;
    public GMSSDigestProvider h;
    public int[] i;
    public byte[][][] j;
    public byte[][] k;
    public GMSSParameters l;
    public GMSSRandom m;
    public GMSSKeyParameters n;

    public GMSSSigner(GMSSDigestProvider gMSSDigestProvider) {
        this.h = gMSSDigestProvider;
        Digest digest = gMSSDigestProvider.get();
        this.c = digest;
        this.f = digest;
        this.d = digest.getDigestSize();
        this.m = new GMSSRandom(this.c);
    }

    public final void a() {
        int i2;
        this.c.reset();
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = (GMSSPrivateKeyParameters) this.n;
        if (gMSSPrivateKeyParameters.isUsed()) {
            throw new IllegalStateException("Private key already used");
        } else if (gMSSPrivateKeyParameters.getIndex(0) < gMSSPrivateKeyParameters.getNumLeafs(0)) {
            GMSSParameters parameters = gMSSPrivateKeyParameters.getParameters();
            this.l = parameters;
            this.e = parameters.getNumOfLayers();
            byte[] bArr = gMSSPrivateKeyParameters.getCurrentSeeds()[this.e - 1];
            int i3 = this.d;
            byte[] bArr2 = new byte[i3];
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, 0, bArr3, 0, i3);
            this.g = new WinternitzOTSignature(this.m.nextSeed(bArr3), this.h.get(), this.l.getWinternitzParameter()[this.e - 1]);
            byte[][][] currentAuthPaths = gMSSPrivateKeyParameters.getCurrentAuthPaths();
            this.j = new byte[this.e][][];
            int i4 = 0;
            while (true) {
                i2 = this.e;
                if (i4 >= i2) {
                    break;
                }
                byte[][][] bArr4 = this.j;
                int length = currentAuthPaths[i4].length;
                int[] iArr = new int[2];
                iArr[1] = this.d;
                iArr[0] = length;
                bArr4[i4] = (byte[][]) Array.newInstance(byte.class, iArr);
                for (int i5 = 0; i5 < currentAuthPaths[i4].length; i5++) {
                    System.arraycopy(currentAuthPaths[i4][i5], 0, this.j[i4][i5], 0, this.d);
                }
                i4++;
            }
            this.i = new int[i2];
            System.arraycopy(gMSSPrivateKeyParameters.getIndex(), 0, this.i, 0, this.e);
            this.k = new byte[(this.e - 1)][];
            for (int i6 = 0; i6 < this.e - 1; i6++) {
                byte[] subtreeRootSig = gMSSPrivateKeyParameters.getSubtreeRootSig(i6);
                byte[][] bArr5 = this.k;
                bArr5[i6] = new byte[subtreeRootSig.length];
                System.arraycopy(subtreeRootSig, 0, bArr5[i6], 0, subtreeRootSig.length);
            }
            gMSSPrivateKeyParameters.markUsed();
        } else {
            throw new IllegalStateException("No more signatures can be generated");
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        byte[] bArr2 = new byte[this.d];
        byte[] signature = this.g.getSignature(bArr);
        byte[] concatenateArray = this.a.concatenateArray(this.j[this.e - 1]);
        byte[] intToBytesLittleEndian = this.a.intToBytesLittleEndian(this.i[this.e - 1]);
        int length = intToBytesLittleEndian.length + signature.length + concatenateArray.length;
        byte[] bArr3 = new byte[length];
        System.arraycopy(intToBytesLittleEndian, 0, bArr3, 0, intToBytesLittleEndian.length);
        System.arraycopy(signature, 0, bArr3, intToBytesLittleEndian.length, signature.length);
        System.arraycopy(concatenateArray, 0, bArr3, intToBytesLittleEndian.length + signature.length, concatenateArray.length);
        byte[] bArr4 = new byte[0];
        for (int i2 = (this.e - 1) - 1; i2 >= 0; i2--) {
            byte[] concatenateArray2 = this.a.concatenateArray(this.j[i2]);
            byte[] intToBytesLittleEndian2 = this.a.intToBytesLittleEndian(this.i[i2]);
            int length2 = bArr4.length;
            byte[] bArr5 = new byte[length2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
            bArr4 = new byte[(intToBytesLittleEndian2.length + length2 + this.k[i2].length + concatenateArray2.length)];
            System.arraycopy(bArr5, 0, bArr4, 0, length2);
            System.arraycopy(intToBytesLittleEndian2, 0, bArr4, length2, intToBytesLittleEndian2.length);
            byte[][] bArr6 = this.k;
            System.arraycopy(bArr6[i2], 0, bArr4, intToBytesLittleEndian2.length + length2, bArr6[i2].length);
            System.arraycopy(concatenateArray2, 0, bArr4, length2 + intToBytesLittleEndian2.length + this.k[i2].length, concatenateArray2.length);
        }
        byte[] bArr7 = new byte[(bArr4.length + length)];
        System.arraycopy(bArr3, 0, bArr7, 0, length);
        System.arraycopy(bArr4, 0, bArr7, length, bArr4.length);
        return bArr7;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.n = (GMSSPublicKeyParameters) cipherParameters;
            this.c.reset();
            GMSSPublicKeyParameters gMSSPublicKeyParameters = (GMSSPublicKeyParameters) this.n;
            this.b = gMSSPublicKeyParameters.getPublicKey();
            GMSSParameters parameters = gMSSPublicKeyParameters.getParameters();
            this.l = parameters;
            this.e = parameters.getNumOfLayers();
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            parametersWithRandom.getRandom();
            this.n = (GMSSPrivateKeyParameters) parametersWithRandom.getParameters();
            a();
        } else {
            new SecureRandom();
            this.n = (GMSSPrivateKeyParameters) cipherParameters;
            a();
        }
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        this.f.reset();
        int i2 = 0;
        for (int i3 = this.e - 1; i3 >= 0; i3--) {
            WinternitzOTSVerify winternitzOTSVerify = new WinternitzOTSVerify(this.h.get(), this.l.getWinternitzParameter()[i3]);
            int signatureLength = winternitzOTSVerify.getSignatureLength();
            int bytesToIntLittleEndian = this.a.bytesToIntLittleEndian(bArr2, i2);
            int i4 = i2 + 4;
            byte[] bArr3 = new byte[signatureLength];
            System.arraycopy(bArr2, i4, bArr3, 0, signatureLength);
            i2 = i4 + signatureLength;
            bArr = winternitzOTSVerify.Verify(bArr, bArr3);
            if (bArr == null) {
                System.err.println("OTS Public Key is null in GMSSSignature.verify");
                return false;
            }
            int i5 = this.l.getHeightOfTrees()[i3];
            int[] iArr = new int[2];
            iArr[1] = this.d;
            iArr[0] = i5;
            byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, iArr);
            for (byte[] bArr5 : bArr4) {
                System.arraycopy(bArr2, i2, bArr5, 0, this.d);
                i2 += this.d;
            }
            byte[] bArr6 = new byte[this.d];
            int length = (1 << bArr4.length) + bytesToIntLittleEndian;
            for (int i6 = 0; i6 < bArr4.length; i6++) {
                int i7 = this.d;
                int i8 = i7 << 1;
                byte[] bArr7 = new byte[i8];
                if (length % 2 == 0) {
                    System.arraycopy(bArr, 0, bArr7, 0, i7);
                    byte[] bArr8 = bArr4[i6];
                    int i9 = this.d;
                    System.arraycopy(bArr8, 0, bArr7, i9, i9);
                    length /= 2;
                } else {
                    System.arraycopy(bArr4[i6], 0, bArr7, 0, i7);
                    System.arraycopy(bArr, 0, bArr7, this.d, bArr.length);
                    length = (length - 1) / 2;
                }
                this.c.update(bArr7, 0, i8);
                bArr = new byte[this.c.getDigestSize()];
                this.c.doFinal(bArr, 0);
            }
        }
        return Arrays.areEqual(this.b, bArr);
    }
}
