package a2.j.k.g.e.b.c;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.zxing.common.BitArray;
public abstract class i extends h {
    public i(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void c(StringBuilder sb, int i);

    public abstract int d(int i);

    public final void e(StringBuilder sb, int i, int i2) {
        int d = r.d(getGeneralDecoder().a, i, i2);
        c(sb, d);
        int d2 = d(d);
        int i3 = AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
        for (int i4 = 0; i4 < 5; i4++) {
            if (d2 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(d2);
    }
}
