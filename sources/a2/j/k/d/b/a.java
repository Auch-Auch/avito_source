package a2.j.k.d.b;

import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
public final class a implements f {
    @Override // a2.j.k.d.b.f
    public void a(g gVar) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(gVar.a, gVar.f) >= 2) {
            char charAt = gVar.a.charAt(gVar.f);
            char charAt2 = gVar.a.charAt(gVar.f + 1);
            if (!HighLevelEncoder.c(charAt) || !HighLevelEncoder.c(charAt2)) {
                throw new IllegalArgumentException("not digits: " + charAt + charAt2);
            }
            gVar.e.append((char) a2.b.a.a.a.G1(charAt2, -48, (charAt - '0') * 10, 130));
            gVar.f += 2;
            return;
        }
        char b = gVar.b();
        int g = HighLevelEncoder.g(gVar.a, gVar.f, 0);
        if (g != 0) {
            if (g == 1) {
                gVar.e.append((char) 230);
                gVar.g = 1;
            } else if (g == 2) {
                gVar.e.append((char) 239);
                gVar.g = 2;
            } else if (g == 3) {
                gVar.e.append((char) 238);
                gVar.g = 3;
            } else if (g == 4) {
                gVar.e.append((char) 240);
                gVar.g = 4;
            } else if (g == 5) {
                gVar.e.append((char) 231);
                gVar.g = 5;
            } else {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(g)));
            }
        } else if (HighLevelEncoder.d(b)) {
            gVar.e.append((char) 235);
            gVar.e.append((char) ((b - 128) + 1));
            gVar.f++;
        } else {
            gVar.e.append((char) (b + 1));
            gVar.f++;
        }
    }
}
