package a2.j.d.j;

import com.google.common.annotations.GwtCompatible;
@GwtCompatible
public final class a {
    public final String a;
    public final int b;

    public a(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static a a(String str) {
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            int i = 16;
            if (str.startsWith("0x") || str.startsWith("0X")) {
                str = str.substring(2);
            } else if (charAt == '#') {
                str = str.substring(1);
            } else if (charAt != '0' || str.length() <= 1) {
                i = 10;
            } else {
                str = str.substring(1);
                i = 8;
            }
            return new a(str, i);
        }
        throw new NumberFormatException("empty string");
    }
}
