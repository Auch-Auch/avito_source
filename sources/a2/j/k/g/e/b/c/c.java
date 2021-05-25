package a2.j.k.g.e.b.c;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public final class c extends h {
    public c(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb = new StringBuilder();
            a(sb, 8);
            int c = getGeneralDecoder().c(48, 2);
            sb.append("(392");
            sb.append(c);
            sb.append(')');
            sb.append(getGeneralDecoder().b(50, null).b);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
