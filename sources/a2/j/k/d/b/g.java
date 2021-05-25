package a2.j.k.d.b;

import com.google.zxing.Dimension;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.nio.charset.StandardCharsets;
public final class g {
    public final String a;
    public SymbolShapeHint b;
    public Dimension c;
    public Dimension d;
    public final StringBuilder e;
    public int f;
    public int g;
    public SymbolInfo h;
    public int i;

    public g(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.a = sb.toString();
        this.b = SymbolShapeHint.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    public int a() {
        return this.e.length();
    }

    public char b() {
        return this.a.charAt(this.f);
    }

    public int c() {
        return (this.a.length() - this.i) - this.f;
    }

    public boolean d() {
        return this.f < this.a.length() - this.i;
    }

    public void e() {
        f(a());
    }

    public void f(int i2) {
        SymbolInfo symbolInfo = this.h;
        if (symbolInfo == null || i2 > symbolInfo.getDataCapacity()) {
            this.h = SymbolInfo.lookup(i2, this.b, this.c, this.d, true);
        }
    }
}
