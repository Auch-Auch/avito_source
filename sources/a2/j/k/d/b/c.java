package a2.j.k.d.b;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
public class c implements f {
    public static void f(g gVar, StringBuilder sb) {
        int charAt = (sb.charAt(1) * '(') + (sb.charAt(0) * 1600) + sb.charAt(2) + 1;
        gVar.e.append(new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)}));
        sb.delete(0, 3);
    }

    @Override // a2.j.k.d.b.f
    public void a(g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.d()) {
                break;
            }
            char b = gVar.b();
            gVar.f++;
            int c = c(b, sb);
            int a = gVar.a() + ((sb.length() / 3) << 1);
            gVar.f(a);
            int dataCapacity = gVar.h.getDataCapacity() - a;
            if (gVar.d()) {
                if (sb.length() % 3 == 0 && HighLevelEncoder.g(gVar.a, gVar.f, d()) != d()) {
                    gVar.g = 0;
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    c = b(gVar, sb, sb2, c);
                }
                while (sb.length() % 3 == 1 && ((c <= 3 && dataCapacity != 1) || c > 3)) {
                    c = b(gVar, sb, sb2, c);
                }
            }
        }
        e(gVar, sb);
    }

    public final int b(g gVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        gVar.f--;
        int c = c(gVar.b(), sb2);
        gVar.h = null;
        return c;
    }

    public int c(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c < '`' || c > 127) {
            sb.append("\u0001\u001e");
            return c((char) (c - 128), sb) + 2;
        } else {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
    }

    public int d() {
        return 1;
    }

    public void e(g gVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int a = gVar.a() + ((sb.length() / 3) << 1);
        gVar.f(a);
        int dataCapacity = gVar.h.getDataCapacity() - a;
        if (length == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                f(gVar, sb);
            }
            if (gVar.d()) {
                gVar.e.append((char) 254);
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (sb.length() >= 3) {
                f(gVar, sb);
            }
            if (gVar.d()) {
                gVar.e.append((char) 254);
            }
            gVar.f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                f(gVar, sb);
            }
            if (dataCapacity > 0 || gVar.d()) {
                gVar.e.append((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        gVar.g = 0;
    }
}
