package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;
import org.spongycastle.util.Arrays;
public class PBKDF2Key implements PBKDFKey {
    public final char[] a;
    public final CharToByteConverter b;

    public PBKDF2Key(char[] cArr, CharToByteConverter charToByteConverter) {
        this.a = Arrays.clone(cArr);
        this.b = charToByteConverter;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF2";
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
