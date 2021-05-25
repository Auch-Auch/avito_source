package a2.j.k.d.b;

import a2.b.a.a.a;
import androidx.core.view.InputDeviceCompat;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
public final class b implements f {
    @Override // a2.j.k.d.b.f
    public void a(g gVar) {
        StringBuilder I = a.I(0);
        while (true) {
            if (!gVar.d()) {
                break;
            }
            I.append(gVar.b());
            int i = gVar.f + 1;
            gVar.f = i;
            if (HighLevelEncoder.g(gVar.a, i, 5) != 5) {
                gVar.g = 0;
                break;
            }
        }
        int length = I.length() - 1;
        int a = gVar.a() + length + 1;
        gVar.f(a);
        boolean z = gVar.h.getDataCapacity() - a > 0;
        if (gVar.d() || z) {
            if (length <= 249) {
                I.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                I.setCharAt(0, (char) ((length / 250) + 249));
                I.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = I.length();
        for (int i2 = 0; i2 < length2; i2++) {
            int a3 = (((gVar.a() + 1) * 149) % 255) + 1 + I.charAt(i2);
            if (a3 > 255) {
                a3 += InputDeviceCompat.SOURCE_ANY;
            }
            gVar.e.append((char) a3);
        }
    }
}
