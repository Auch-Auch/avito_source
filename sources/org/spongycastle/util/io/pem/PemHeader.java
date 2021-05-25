package org.spongycastle.util.io.pem;
public class PemHeader {
    public String a;
    public String b;

    public PemHeader(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PemHeader)) {
            return false;
        }
        PemHeader pemHeader = (PemHeader) obj;
        if (pemHeader == this || (a(this.a, pemHeader.a) && a(this.b, pemHeader.b))) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.a;
    }

    public String getValue() {
        return this.b;
    }

    public int hashCode() {
        int i;
        String str = this.a;
        int i2 = 1;
        if (str == null) {
            i = 1;
        } else {
            i = str.hashCode();
        }
        String str2 = this.b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return (i2 * 31) + i;
    }
}
