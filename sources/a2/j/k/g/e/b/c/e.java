package a2.j.k.g.e.b.c;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public final class e extends i {
    public final String c;
    public final String d;

    public e(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.c = str2;
        this.d = str;
    }

    @Override // a2.j.k.g.e.b.c.i
    public void c(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.d);
        sb.append(i / AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
        sb.append(')');
    }

    @Override // a2.j.k.g.e.b.c.i
    public int d(int i) {
        return i % AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 84) {
            StringBuilder sb = new StringBuilder();
            a(sb, 8);
            e(sb, 48, 20);
            int d2 = r.d(getGeneralDecoder().a, 68, 16);
            if (d2 != 38400) {
                sb.append('(');
                sb.append(this.c);
                sb.append(')');
                int i = d2 % 32;
                int i2 = d2 / 32;
                int i3 = (i2 % 12) + 1;
                int i4 = i2 / 12;
                if (i4 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i4);
                if (i3 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i3);
                if (i / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i);
            }
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
