package a2.j.k.g.e.b.c;

import a2.b.a.a.a;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public final class g extends h {
    public g(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        StringBuilder L = a.L("(01)");
        int length = L.length();
        L.append(getGeneralDecoder().c(4, 4));
        b(L, 8, length);
        return getGeneralDecoder().a(L, 48);
    }
}
