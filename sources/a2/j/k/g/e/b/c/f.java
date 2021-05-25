package a2.j.k.g.e.b.c;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public abstract class f extends i {
    public f(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 60) {
            StringBuilder sb = new StringBuilder();
            a(sb, 5);
            e(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
