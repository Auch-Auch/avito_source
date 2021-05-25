package a2.j.d.c;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
public class n1 extends ImmutableList<Range<C>> {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Range e;
    public final /* synthetic */ ImmutableRangeSet f;

    public n1(ImmutableRangeSet immutableRangeSet, int i, int i2, Range range) {
        this.f = immutableRangeSet;
        this.c = i;
        this.d = i2;
        this.e = range;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean e() {
        return true;
    }

    @Override // java.util.List
    public Object get(int i) {
        Preconditions.checkElementIndex(i, this.c);
        if (i == 0 || i == this.c - 1) {
            return this.f.a.get(i + this.d).intersection(this.e);
        }
        return this.f.a.get(i + this.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }
}
