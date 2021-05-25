package org.spongycastle.jcajce;

import org.spongycastle.crypto.PBEParametersGenerator;
public class PKCS12Key implements PBKDFKey {
    public final char[] a;
    public final boolean b;

    public PKCS12Key(char[] cArr) {
        this(cArr, false);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PKCS12";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (!this.b || this.a.length != 0) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(this.a);
        }
        return new byte[2];
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS12";
    }

    public char[] getPassword() {
        return this.a;
    }

    public PKCS12Key(char[] cArr, boolean z) {
        cArr = cArr == null ? new char[0] : cArr;
        char[] cArr2 = new char[cArr.length];
        this.a = cArr2;
        this.b = z;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }
}
