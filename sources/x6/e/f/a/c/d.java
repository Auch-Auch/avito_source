package x6.e.f.a.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.Objects;
public class d {
    public static void a(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 != 2144; i3++) {
            bArr[i3 + i] = 0;
        }
        AppCompatDelegateImpl.i.C1(bArr, i, 2144, bArr2, i2);
    }

    public static void b(a aVar, byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4) {
        for (int i5 = 0; i5 < 32; i5++) {
            bArr[i5 + i] = bArr2[i5 + i2];
        }
        int i6 = 0;
        while (i6 < i4 && i6 < 16) {
            int i7 = (i6 * 32) + i3;
            Objects.requireNonNull(aVar);
            byte[] bArr4 = new byte[32];
            for (int i8 = 0; i8 < 32; i8++) {
                bArr4[i8] = (byte) (bArr[i + i8] ^ bArr3[i7 + i8]);
            }
            aVar.b(bArr, i, bArr4, 0);
            i6++;
        }
    }
}
