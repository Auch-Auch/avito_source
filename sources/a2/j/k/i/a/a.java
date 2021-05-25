package a2.j.k.i.a;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.Version;
public final class a {
    public final BitMatrix a;
    public Version b;
    public e c;
    public boolean d;

    public a(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.a = bitMatrix;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.a.get(i2, i) : this.a.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.a.getWidth()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.a.getHeight(); i3++) {
                if (this.a.get(i, i3) != this.a.get(i3, i)) {
                    this.a.flip(i3, i);
                    this.a.flip(i, i3);
                }
            }
            i = i2;
        }
    }

    public e c() throws FormatException {
        e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a3 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a3 = a(8, i4, a3);
        }
        int height = this.a.getHeight();
        int i5 = height - 7;
        for (int i6 = height - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = height - 8; i7 < height; i7++) {
            i = a(i7, 8, i);
        }
        e a4 = e.a(a3, i);
        if (a4 == null) {
            a4 = e.a(a3 ^ 21522, i ^ 21522);
        }
        this.c = a4;
        if (a4 != null) {
            return a4;
        }
        throw FormatException.getFormatInstance();
    }

    public Version d() throws FormatException {
        Version version = this.b;
        if (version != null) {
            return version;
        }
        int height = this.a.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i2; i6--) {
                i4 = a(i6, i5, i4);
            }
        }
        Version b2 = Version.b(i4);
        if (b2 == null || b2.getDimensionForVersion() != height) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = height - 9; i8 >= i2; i8--) {
                    i3 = a(i7, i8, i3);
                }
            }
            Version b3 = Version.b(i3);
            if (b3 == null || b3.getDimensionForVersion() != height) {
                throw FormatException.getFormatInstance();
            }
            this.b = b3;
            return b3;
        }
        this.b = b2;
        return b2;
    }

    public void e() {
        if (this.c != null) {
            c.values()[this.c.b].b(this.a, this.a.getHeight());
        }
    }
}
