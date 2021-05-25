package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.EphemeralKeyPair;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Pack;
public class IESEngine {
    public BasicAgreement a;
    public DerivationFunction b;
    public Mac c;
    public BufferedBlockCipher d;
    public boolean e;
    public CipherParameters f;
    public CipherParameters g;
    public IESParameters h;
    public byte[] i;
    public EphemeralKeyPairGenerator j;
    public KeyParser k;
    public byte[] l;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac) {
        this.a = basicAgreement;
        this.b = derivationFunction;
        this.c = mac;
        byte[] bArr = new byte[mac.getMacSize()];
        this.d = null;
    }

    public final byte[] a(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        if (i3 >= this.c.getMacSize() + this.i.length) {
            if (this.d == null) {
                int length = (i3 - this.i.length) - this.c.getMacSize();
                byte[] bArr4 = new byte[length];
                int macKeySize = this.h.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize];
                int i5 = length + macKeySize;
                byte[] bArr5 = new byte[i5];
                this.b.generateBytes(bArr5, 0, i5);
                if (this.i.length != 0) {
                    System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                    System.arraycopy(bArr5, macKeySize, bArr4, 0, length);
                } else {
                    System.arraycopy(bArr5, 0, bArr4, 0, length);
                    System.arraycopy(bArr5, length, bArr2, 0, macKeySize);
                }
                bArr3 = new byte[length];
                for (int i6 = 0; i6 != length; i6++) {
                    bArr3[i6] = (byte) (bArr[(this.i.length + i2) + i6] ^ bArr4[i6]);
                }
                i4 = 0;
            } else {
                int cipherKeySize = ((IESWithCipherParameters) this.h).getCipherKeySize() / 8;
                byte[] bArr6 = new byte[cipherKeySize];
                int macKeySize2 = this.h.getMacKeySize() / 8;
                bArr2 = new byte[macKeySize2];
                int i7 = cipherKeySize + macKeySize2;
                byte[] bArr7 = new byte[i7];
                this.b.generateBytes(bArr7, 0, i7);
                System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
                System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
                CipherParameters keyParameter = new KeyParameter(bArr6);
                byte[] bArr8 = this.l;
                if (bArr8 != null) {
                    keyParameter = new ParametersWithIV(keyParameter, bArr8);
                }
                this.d.init(false, keyParameter);
                bArr3 = new byte[this.d.getOutputSize((i3 - this.i.length) - this.c.getMacSize())];
                BufferedBlockCipher bufferedBlockCipher = this.d;
                byte[] bArr9 = this.i;
                i4 = bufferedBlockCipher.processBytes(bArr, i2 + bArr9.length, (i3 - bArr9.length) - this.c.getMacSize(), bArr3, 0);
            }
            byte[] encodingV = this.h.getEncodingV();
            byte[] bArr10 = null;
            if (this.i.length != 0) {
                bArr10 = getLengthTag(encodingV);
            }
            int i8 = i2 + i3;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i8 - this.c.getMacSize(), i8);
            int length2 = copyOfRange.length;
            byte[] bArr11 = new byte[length2];
            this.c.init(new KeyParameter(bArr2));
            Mac mac = this.c;
            byte[] bArr12 = this.i;
            mac.update(bArr, i2 + bArr12.length, (i3 - bArr12.length) - length2);
            if (encodingV != null) {
                this.c.update(encodingV, 0, encodingV.length);
            }
            if (this.i.length != 0) {
                this.c.update(bArr10, 0, bArr10.length);
            }
            this.c.doFinal(bArr11, 0);
            if (Arrays.constantTimeAreEqual(copyOfRange, bArr11)) {
                BufferedBlockCipher bufferedBlockCipher2 = this.d;
                if (bufferedBlockCipher2 == null) {
                    return bArr3;
                }
                return Arrays.copyOfRange(bArr3, 0, bufferedBlockCipher2.doFinal(bArr3, i4) + i4);
            }
            throw new InvalidCipherTextException("invalid MAC");
        }
        throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
    }

    public final byte[] b(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        if (this.d == null) {
            byte[] bArr4 = new byte[i3];
            int macKeySize = this.h.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize];
            int i4 = i3 + macKeySize;
            byte[] bArr5 = new byte[i4];
            this.b.generateBytes(bArr5, 0, i4);
            if (this.i.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, i3);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i3);
                System.arraycopy(bArr5, i3, bArr2, 0, macKeySize);
            }
            bArr3 = new byte[i3];
            for (int i5 = 0; i5 != i3; i5++) {
                bArr3[i5] = (byte) (bArr[i2 + i5] ^ bArr4[i5]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.h).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.h.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i6 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i6];
            this.b.generateBytes(bArr8, 0, i6);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            if (this.l != null) {
                this.d.init(true, new ParametersWithIV(new KeyParameter(bArr6), this.l));
            } else {
                this.d.init(true, new KeyParameter(bArr6));
            }
            bArr3 = new byte[this.d.getOutputSize(i3)];
            int processBytes = this.d.processBytes(bArr, i2, i3, bArr3, 0);
            i3 = this.d.doFinal(bArr3, processBytes) + processBytes;
            bArr2 = bArr7;
        }
        byte[] encodingV = this.h.getEncodingV();
        byte[] bArr9 = null;
        if (this.i.length != 0) {
            bArr9 = getLengthTag(encodingV);
        }
        int macSize = this.c.getMacSize();
        byte[] bArr10 = new byte[macSize];
        this.c.init(new KeyParameter(bArr2));
        this.c.update(bArr3, 0, bArr3.length);
        if (encodingV != null) {
            this.c.update(encodingV, 0, encodingV.length);
        }
        if (this.i.length != 0) {
            this.c.update(bArr9, 0, bArr9.length);
        }
        this.c.doFinal(bArr10, 0);
        byte[] bArr11 = this.i;
        byte[] bArr12 = new byte[(bArr11.length + i3 + macSize)];
        System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
        System.arraycopy(bArr3, 0, bArr12, this.i.length, i3);
        System.arraycopy(bArr10, 0, bArr12, this.i.length + i3, macSize);
        return bArr12;
    }

    public final void c(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.l = parametersWithIV.getIV();
            this.h = (IESParameters) parametersWithIV.getParameters();
            return;
        }
        this.l = null;
        this.h = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.d;
    }

    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.longToBigEndian(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public Mac getMac() {
        return this.c;
    }

    public void init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.e = z;
        this.f = cipherParameters;
        this.g = cipherParameters2;
        this.i = new byte[0];
        c(cipherParameters3);
    }

    public byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.e) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.j;
            if (ephemeralKeyPairGenerator != null) {
                EphemeralKeyPair generate = ephemeralKeyPairGenerator.generate();
                this.f = generate.getKeyPair().getPrivate();
                this.i = generate.getEncodedPublicKey();
            }
        } else if (this.k != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
            try {
                this.g = this.k.readKey(byteArrayInputStream);
                this.i = Arrays.copyOfRange(bArr, i2, (i3 - byteArrayInputStream.available()) + i2);
            } catch (IOException e2) {
                throw new InvalidCipherTextException(a.A2(e2, a.L("unable to recover ephemeral public key: ")), e2);
            } catch (IllegalArgumentException e3) {
                StringBuilder L = a.L("unable to recover ephemeral public key: ");
                L.append(e3.getMessage());
                throw new InvalidCipherTextException(L.toString(), e3);
            }
        }
        this.a.init(this.f);
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.a.getFieldSize(), this.a.calculateAgreement(this.g));
        byte[] bArr3 = this.i;
        byte b2 = 0;
        if (bArr3.length != 0) {
            byte[] concatenate = Arrays.concatenate(bArr3, asUnsignedByteArray);
            Arrays.fill(asUnsignedByteArray, (byte) 0);
            asUnsignedByteArray = concatenate;
        }
        try {
            this.b.init(new KDFParameters(asUnsignedByteArray, this.h.getDerivationV()));
            if (this.e) {
                bArr2 = b(bArr, i2, i3);
            } else {
                bArr2 = a(bArr, i2, i3);
            }
            return bArr2;
        } finally {
            Arrays.fill(asUnsignedByteArray, b2);
        }
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.e = true;
        this.g = asymmetricKeyParameter;
        this.j = ephemeralKeyPairGenerator;
        c(cipherParameters);
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac, BufferedBlockCipher bufferedBlockCipher) {
        this.a = basicAgreement;
        this.b = derivationFunction;
        this.c = mac;
        byte[] bArr = new byte[mac.getMacSize()];
        this.d = bufferedBlockCipher;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser) {
        this.e = false;
        this.f = asymmetricKeyParameter;
        this.k = keyParser;
        c(cipherParameters);
    }
}
