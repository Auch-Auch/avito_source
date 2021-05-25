package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;
public class PBKDF1Key implements PBKDFKey {
    public final char[] a;
    public final CharToByteConverter b;

    public PBKDF1Key(char[] cArr, CharToByteConverter charToByteConverter) {
        char[] cArr2 = new char[cArr.length];
        this.a = cArr2;
        this.b = charToByteConverter;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF1";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.b.convert(this.a);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.b.getType();
    }

    public char[] getPassword() {
        return this.a;
    }
}
