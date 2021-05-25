package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.RowSortedTable;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
@GwtCompatible
public class x3<R, C, V> extends y3<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;

    public class b extends y3<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b(a aVar) {
            super();
        }

        @Override // com.google.common.collect.Maps.g0
        public Set c() {
            return new Maps.v(this);
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return ((SortedMap) x3.this.c).comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) ((SortedMap) x3.this.c).firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r) {
            Preconditions.checkNotNull(r);
            return new x3(((SortedMap) x3.this.c).headMap(r), x3.this.d).mo129rowMap();
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) ((SortedMap) x3.this.c).lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            Preconditions.checkNotNull(r);
            Preconditions.checkNotNull(r2);
            return new x3(((SortedMap) x3.this.c).subMap(r, r2), x3.this.d).mo129rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r) {
            Preconditions.checkNotNull(r);
            return new x3(((SortedMap) x3.this.c).tailMap(r), x3.this.d).mo129rowMap();
        }
    }

    public x3(SortedMap<R, Map<C, V>> sortedMap, Supplier<? extends Map<C, V>> supplier) {
        super(sortedMap, supplier);
    }

    @Override // a2.j.d.c.y3
    public Map h() {
        return new b(null);
    }

    @Override // a2.j.d.c.y3, a2.j.d.c.q, com.google.common.collect.Table
    /* renamed from: rowKeySet */
    public SortedSet<R> mo128rowKeySet() {
        return (SortedSet) mo129rowMap().keySet();
    }

    @Override // a2.j.d.c.y3, com.google.common.collect.Table
    /* renamed from: rowMap */
    public SortedMap<R, Map<C, V>> mo129rowMap() {
        return (SortedMap) super.mo129rowMap();
    }
}
