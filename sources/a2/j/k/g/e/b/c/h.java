package a2.j.k.g.e.b.c;

import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
public abstract class h extends AbstractExpandedDecoder {
    public h(BitArray bitArray) {
        super(bitArray);
    }

    public final void a(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        b(sb, i, length);
    }

    public final void b(StringBuilder sb, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int c = getGeneralDecoder().c((i4 * 10) + i, 10);
            if (c / 100 == 0) {
                sb.append('0');
            }
            if (c / 10 == 0) {
                sb.append('0');
            }
            sb.append(c);
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 13; i6++) {
            int charAt = sb.charAt(i6 + i2) - '0';
            if ((i6 & 1) == 0) {
                charAt *= 3;
            }
            i5 += charAt;
        }
        int i7 = 10 - (i5 % 10);
        if (i7 != 10) {
            i3 = i7;
        }
        sb.append(i3);
    }
}
