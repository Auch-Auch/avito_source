package a2.j.k.d.b;
public final class e implements f {
    public static String b(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            char c = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(i + 3);
            }
            int i2 = (charAt << 18) + (charAt2 << '\f') + (charAt3 << 6) + c;
            char c2 = (char) ((i2 >> 8) & 255);
            char c3 = (char) (i2 & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        com.google.zxing.datamatrix.encoder.HighLevelEncoder.b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        throw null;
     */
    @Override // a2.j.k.d.b.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(a2.j.k.d.b.g r11) {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.k.d.b.e.a(a2.j.k.d.b.g):void");
    }
}
