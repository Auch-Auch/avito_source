package a2.j.k.g.e.b.c;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public final class d extends h {
    public d(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb = new StringBuilder();
            a(sb, 8);
            int c = getGeneralDecoder().c(48, 2);
            sb.append("(393");
            sb.append(c);
            sb.append(')');
            int c2 = getGeneralDecoder().c(50, 10);
            if (c2 / 100 == 0) {
                sb.append('0');
            }
            if (c2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(c2);
            sb.append(getGeneralDecoder().b(60, null).b);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
