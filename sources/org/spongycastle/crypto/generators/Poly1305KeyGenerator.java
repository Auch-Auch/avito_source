package org.spongycastle.crypto.generators;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
public class Poly1305KeyGenerator extends CipherKeyGenerator {
    public static void a(byte b, byte b2) {
        if ((b & (~b2)) != 0) {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
    }

    public static void checkKey(byte[] bArr) {
        if (bArr.length == 32) {
            a(bArr[3], Ascii.SI);
            a(bArr[7], Ascii.SI);
            a(bArr[11], Ascii.SI);
            a(bArr[15], Ascii.SI);
            a(bArr[4], (byte) -4);
            a(bArr[8], (byte) -4);
            a(bArr[12], (byte) -4);
            return;
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    public static void clamp(byte[] bArr) {
        if (bArr.length == 32) {
            bArr[3] = (byte) (bArr[3] & Ascii.SI);
            bArr[7] = (byte) (bArr[7] & Ascii.SI);
            bArr[11] = (byte) (bArr[11] & Ascii.SI);
            bArr[15] = (byte) (bArr[15] & Ascii.SI);
            bArr[4] = (byte) (bArr[4] & -4);
            bArr[8] = (byte) (bArr[8] & -4);
            bArr[12] = (byte) (bArr[12] & -4);
            return;
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    @Override // org.spongycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] generateKey = super.generateKey();
        clamp(generateKey);
        return generateKey;
    }

    @Override // org.spongycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        super.init(new KeyGenerationParameters(keyGenerationParameters.getRandom(), 256));
    }
}
