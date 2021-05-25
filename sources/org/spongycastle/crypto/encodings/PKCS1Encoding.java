package org.spongycastle.crypto.encodings;

import com.facebook.internal.ServerProtocol;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
public class PKCS1Encoding implements AsymmetricBlockCipher {
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.spongycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.spongycastle.pkcs1.strict";
    public SecureRandom a;
    public AsymmetricBlockCipher b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f = -1;
    public byte[] g = null;
    public byte[] h;

    public class a implements PrivilegedAction {
        public a(PKCS1Encoding pKCS1Encoding) {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(PKCS1Encoding.STRICT_LENGTH_ENABLED_PROPERTY);
        }
    }

    public class b implements PrivilegedAction {
        public b(PKCS1Encoding pKCS1Encoding) {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(PKCS1Encoding.NOT_STRICT_LENGTH_ENABLED_PROPERTY);
        }
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.b = asymmetricBlockCipher;
        this.e = a();
    }

    public final boolean a() {
        String str = (String) AccessController.doPrivileged(new a(this));
        String str2 = (String) AccessController.doPrivileged(new b(this));
        if (str2 != null) {
            return !str2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        if (str == null || str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        return false;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.b.getInputBlockSize();
        return this.c ? inputBlockSize - 10 : inputBlockSize;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.b.getOutputBlockSize();
        return this.c ? outputBlockSize : outputBlockSize - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.b;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.isPrivate() && z) {
                this.a = new SecureRandom();
            }
        }
        this.b.init(z, cipherParameters);
        this.d = asymmetricKeyParameter.isPrivate();
        this.c = z;
        this.h = new byte[this.b.getOutputBlockSize()];
        if (this.f > 0 && this.g == null && this.a == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int i3 = -1;
        boolean z = true;
        if (this.c) {
            if (i2 <= getInputBlockSize()) {
                int inputBlockSize = this.b.getInputBlockSize();
                byte[] bArr2 = new byte[inputBlockSize];
                if (this.d) {
                    bArr2[0] = 1;
                    for (int i4 = 1; i4 != (inputBlockSize - i2) - 1; i4++) {
                        bArr2[i4] = -1;
                    }
                } else {
                    this.a.nextBytes(bArr2);
                    bArr2[0] = 2;
                    for (int i5 = 1; i5 != (inputBlockSize - i2) - 1; i5++) {
                        while (bArr2[i5] == 0) {
                            bArr2[i5] = (byte) this.a.nextInt();
                        }
                    }
                }
                int i6 = inputBlockSize - i2;
                bArr2[i6 - 1] = 0;
                System.arraycopy(bArr, i, bArr2, i6, i2);
                return this.b.processBlock(bArr2, 0, inputBlockSize);
            }
            throw new IllegalArgumentException("input data too large");
        } else if (this.f == -1) {
            byte[] processBlock = this.b.processBlock(bArr, i, i2);
            boolean z2 = this.e & (processBlock.length != this.b.getOutputBlockSize());
            if (processBlock.length < getOutputBlockSize()) {
                processBlock = this.h;
            }
            byte b2 = processBlock[0];
            boolean z3 = !this.d ? b2 != 1 : b2 != 2;
            boolean z4 = false;
            int i7 = -1;
            for (int i8 = 1; i8 != processBlock.length; i8++) {
                byte b3 = processBlock[i8];
                if ((b3 == 0) && (i7 < 0)) {
                    i7 = i8;
                }
                z4 |= (b3 != -1) & (b2 == 1) & (i7 < 0);
            }
            if (!z4) {
                i3 = i7;
            }
            int i9 = i3 + 1;
            if (i9 >= 10) {
                z = false;
            }
            if (z3 || z) {
                Arrays.fill(processBlock, (byte) 0);
                throw new InvalidCipherTextException("block incorrect");
            } else if (!z2) {
                int length = processBlock.length - i9;
                byte[] bArr3 = new byte[length];
                System.arraycopy(processBlock, i9, bArr3, 0, length);
                return bArr3;
            } else {
                Arrays.fill(processBlock, (byte) 0);
                throw new InvalidCipherTextException("block incorrect size");
            }
        } else if (this.d) {
            byte[] processBlock2 = this.b.processBlock(bArr, i, i2);
            byte[] bArr4 = this.g;
            if (bArr4 == null) {
                bArr4 = new byte[this.f];
                this.a.nextBytes(bArr4);
            }
            if (this.e && (processBlock2.length != this.b.getOutputBlockSize())) {
                processBlock2 = this.h;
            }
            int i10 = this.f;
            int i11 = (processBlock2[0] ^ 2) | 0;
            int i12 = i10 + 1;
            int length2 = processBlock2.length - i12;
            for (int i13 = 1; i13 < length2; i13++) {
                byte b4 = processBlock2[i13];
                int i14 = b4 | (b4 >> 1);
                int i15 = i14 | (i14 >> 2);
                i11 |= ((i15 | (i15 >> 4)) & 1) - 1;
            }
            int i16 = processBlock2[processBlock2.length - i12] | i11;
            int i17 = i16 | (i16 >> 1);
            int i18 = i17 | (i17 >> 2);
            int i19 = ~(((i18 | (i18 >> 4)) & 1) - 1);
            byte[] bArr5 = new byte[this.f];
            int i20 = 0;
            while (true) {
                int i21 = this.f;
                if (i20 < i21) {
                    bArr5[i20] = (byte) ((processBlock2[(processBlock2.length - i21) + i20] & (~i19)) | (bArr4[i20] & i19));
                    i20++;
                } else {
                    Arrays.fill(processBlock2, (byte) 0);
                    return bArr5;
                }
            }
        } else {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, int i) {
        this.b = asymmetricBlockCipher;
        this.e = a();
        this.f = i;
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.b = asymmetricBlockCipher;
        this.e = a();
        this.g = bArr;
        this.f = bArr.length;
    }
}
