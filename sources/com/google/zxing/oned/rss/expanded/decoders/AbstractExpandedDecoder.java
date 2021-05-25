package com.google.zxing.oned.rss.expanded.decoders;

import a2.j.k.g.e.b.c.a;
import a2.j.k.g.e.b.c.b;
import a2.j.k.g.e.b.c.c;
import a2.j.k.g.e.b.c.d;
import a2.j.k.g.e.b.c.e;
import a2.j.k.g.e.b.c.g;
import a2.j.k.g.e.b.c.j;
import a2.j.k.g.e.b.c.r;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
public abstract class AbstractExpandedDecoder {
    public final BitArray a;
    public final r b;

    public AbstractExpandedDecoder(BitArray bitArray) {
        this.a = bitArray;
        this.b = new r(bitArray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new g(bitArray);
        }
        if (!bitArray.get(2)) {
            return new j(bitArray);
        }
        int d = r.d(bitArray, 1, 4);
        if (d == 4) {
            return new a(bitArray);
        }
        if (d == 5) {
            return new b(bitArray);
        }
        int d2 = r.d(bitArray, 1, 5);
        if (d2 == 12) {
            return new c(bitArray);
        }
        if (d2 == 13) {
            return new d(bitArray);
        }
        switch (r.d(bitArray, 1, 7)) {
            case 56:
                return new e(bitArray, "310", "11");
            case 57:
                return new e(bitArray, "320", "11");
            case 58:
                return new e(bitArray, "310", "13");
            case 59:
                return new e(bitArray, "320", "13");
            case 60:
                return new e(bitArray, "310", "15");
            case 61:
                return new e(bitArray, "320", "15");
            case 62:
                return new e(bitArray, "310", "17");
            case 63:
                return new e(bitArray, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(bitArray)));
        }
    }

    public final r getGeneralDecoder() {
        return this.b;
    }

    public final BitArray getInformation() {
        return this.a;
    }

    public abstract String parseInformation() throws NotFoundException, FormatException;
}
