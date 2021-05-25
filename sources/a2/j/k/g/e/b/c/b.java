package a2.j.k.g.e.b.c;

import com.google.zxing.common.BitArray;
public final class b extends f {
    public b(BitArray bitArray) {
        super(bitArray);
    }

    @Override // a2.j.k.g.e.b.c.i
    public void c(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // a2.j.k.g.e.b.c.i
    public int d(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
