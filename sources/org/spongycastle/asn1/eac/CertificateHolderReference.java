package org.spongycastle.asn1.eac;

import java.io.UnsupportedEncodingException;
public class CertificateHolderReference {
    public String a;
    public String b;
    public String c;

    public CertificateHolderReference(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getCountryCode() {
        return this.a;
    }

    public byte[] getEncoded() {
        try {
            return (this.a + this.b + this.c).getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    public String getHolderMnemonic() {
        return this.b;
    }

    public String getSequenceNumber() {
        return this.c;
    }

    public CertificateHolderReference(byte[] bArr) {
        try {
            String str = new String(bArr, "ISO-8859-1");
            this.a = str.substring(0, 2);
            this.b = str.substring(2, str.length() - 5);
            this.c = str.substring(str.length() - 5);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.toString());
        }
    }
}
