package a2.g.t.a;

import java.util.NoSuchElementException;
import javax.annotation.Nullable;
public class a {
    @Nullable
    public byte[] a;
    public int b;
    public int c;
    public char d;
    public boolean e;

    public final int a() throws NoSuchElementException {
        f();
        e();
        int i = this.c;
        int i2 = this.b;
        if (i > i2) {
            byte[] bArr = this.a;
            char c2 = this.d;
            while (true) {
                if (i2 >= i) {
                    i2 = -1;
                    break;
                } else if (bArr[i2] == c2) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                int i3 = this.c;
                int i4 = i3 - this.b;
                this.b = i3;
                return i4;
            }
            int i5 = i2 - this.b;
            this.b = i2 + 1;
            return i5;
        }
        throw new NoSuchElementException(a2.b.a.a.a.j(a2.b.a.a.a.L("Reading past end of input stream at "), this.b, "."));
    }

    public int b() throws NoSuchElementException {
        f();
        e();
        int i = this.b;
        int a3 = a();
        byte[] bArr = this.a;
        int i2 = a3 + i;
        int i3 = 0;
        while (i < i2) {
            int i4 = i + 1;
            int i5 = bArr[i] - 48;
            if (i5 < 0 || i5 > 9) {
                StringBuilder L = a2.b.a.a.a.L("Invalid int in buffer at ");
                L.append(i4 - 1);
                L.append(".");
                throw new NumberFormatException(L.toString());
            }
            i3 = (i3 * 10) + i5;
            i = i4;
        }
        return i3;
    }

    public boolean c(String str) throws NoSuchElementException {
        int i = this.b;
        if (str.length() != a()) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != this.a[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public void d() throws NoSuchElementException {
        f();
        e();
        a();
    }

    public final void e() {
        if (!this.e) {
            throw new IllegalStateException("Must call useDelimiter first");
        }
    }

    public final void f() {
        if (this.a == null) {
            throw new IllegalStateException("Must call reset first");
        }
    }
}
