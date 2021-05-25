package a2.j.d.c;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class m3 extends AbstractSet<E> {
    public final /* synthetic */ BitSet a;
    public final /* synthetic */ Sets.e.a b;

    public class a extends AbstractIterator<E> {
        public int c = -1;

        public a() {
        }

        @Override // com.google.common.collect.AbstractIterator
        public E computeNext() {
            int nextSetBit = m3.this.a.nextSetBit(this.c + 1);
            this.c = nextSetBit;
            return nextSetBit == -1 ? (E) endOfData() : (E) Sets.e.this.b.keySet().asList().get(this.c);
        }
    }

    public m3(Sets.e.a aVar, BitSet bitSet) {
        this.b = aVar;
        this.a = bitSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Integer num = (Integer) Sets.e.this.b.get(obj);
        return num != null && this.a.get(num.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Sets.e.this.a;
    }
}
