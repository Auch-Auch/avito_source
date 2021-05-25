package a2.j.e.d.d.f;

import java.io.UnsupportedEncodingException;
public final class a {
    public final byte[] a;
    public volatile int b = 0;

    public a(byte[] bArr) {
        this.a = bArr;
    }

    public static a a(String str) {
        try {
            return new a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.b;
        if (i == 0) {
            byte[] bArr = this.a;
            int length = bArr.length;
            int i2 = length;
            for (byte b2 : bArr) {
                i2 = (i2 * 31) + b2;
            }
            i = i2 == 0 ? 1 : i2;
            this.b = i;
        }
        return i;
    }
}
