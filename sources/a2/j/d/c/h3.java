package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class h3<R, C, V> extends ImmutableTable<R, C, V> {

    public final class a extends r1<Table.Cell<R, C, V>> {
        public a(g3 g3Var) {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Object obj2 = h3.this.get(cell.getRowKey(), cell.getColumnKey());
            if (obj2 == null || !obj2.equals(cell.getValue())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return false;
        }

        @Override // a2.j.d.c.r1
        public Object get(int i) {
            return h3.this.m(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h3.this.size();
        }
    }

    public final class b extends ImmutableList<V> {
        public b(g3 g3Var) {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) h3.this.n(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return h3.this.size();
        }
    }

    public static <R, C, V> h3<R, C, V> l(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new j0(immutableList, immutableSet, immutableSet2) : new w3(immutableList, immutableSet, immutableSet2);
    }

    @Override // com.google.common.collect.ImmutableTable, a2.j.d.c.q
    public Set b() {
        return isEmpty() ? ImmutableSet.of() : new a(null);
    }

    @Override // com.google.common.collect.ImmutableTable, a2.j.d.c.q
    public Collection c() {
        return isEmpty() ? ImmutableList.of() : new b(null);
    }

    @Override // com.google.common.collect.ImmutableTable
    public final ImmutableSet<Table.Cell<R, C, V>> f() {
        return isEmpty() ? ImmutableSet.of() : new a(null);
    }

    @Override // com.google.common.collect.ImmutableTable
    public final ImmutableCollection<V> i() {
        return isEmpty() ? ImmutableList.of() : new b(null);
    }

    public final void j(R r, C c, V v, V v2) {
        Preconditions.checkArgument(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c, v2, v);
    }

    public abstract Table.Cell<R, C, V> m(int i);

    public abstract V n(int i);
}
