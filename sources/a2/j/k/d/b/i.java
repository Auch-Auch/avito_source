package a2.j.k.d.b;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
public final class i extends c {
    @Override // a2.j.k.d.b.c, a2.j.k.d.b.f
    public void a(g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.d()) {
                break;
            }
            char b = gVar.b();
            gVar.f++;
            c(b, sb);
            if (sb.length() % 3 == 0) {
                c.f(gVar, sb);
                if (HighLevelEncoder.g(gVar.a, gVar.f, 3) != 3) {
                    gVar.g = 0;
                    break;
                }
            }
        }
        e(gVar, sb);
    }

    @Override // a2.j.k.d.b.c
    public int c(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.b(c);
            throw null;
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    @Override // a2.j.k.d.b.c
    public int d() {
        return 3;
    }

    @Override // a2.j.k.d.b.c
    public void e(g gVar, StringBuilder sb) {
        gVar.e();
        int dataCapacity = gVar.h.getDataCapacity() - gVar.a();
        gVar.f -= sb.length();
        if (gVar.c() > 1 || dataCapacity > 1 || gVar.c() != dataCapacity) {
            gVar.e.append((char) 254);
        }
        if (gVar.g < 0) {
            gVar.g = 0;
        }
    }
}
