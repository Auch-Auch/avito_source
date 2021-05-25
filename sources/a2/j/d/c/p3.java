package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
@GwtCompatible
public class p3<R, C, V> extends ImmutableTable<R, C, V> {
    public final R c;
    public final C d;
    public final V e;

    public p3(R r, C c2, V v) {
        this.c = (R) Preconditions.checkNotNull(r);
        this.d = (C) Preconditions.checkNotNull(c2);
        this.e = (V) Preconditions.checkNotNull(v);
    }

    @Override // com.google.common.collect.ImmutableTable, a2.j.d.c.q
    public Set b() {
        return ImmutableSet.of(ImmutableTable.e(this.c, this.d, this.e));
    }

    @Override // com.google.common.collect.ImmutableTable, a2.j.d.c.q
    public Collection c() {
        return ImmutableSet.of(this.e);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableSet<Table.Cell<R, C, V>> f() {
        return ImmutableSet.of(ImmutableTable.e(this.c, this.d, this.e));
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.a h() {
        return ImmutableTable.a.a(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableCollection<V> i() {
        return ImmutableSet.of(this.e);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, V> column(C c2) {
        Preconditions.checkNotNull(c2);
        if (containsColumn(c2)) {
            return ImmutableMap.of(this.c, (Object) this.e);
        }
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.d, ImmutableMap.of(this.c, (Object) this.e));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* renamed from: rowMap */
    public ImmutableMap<R, Map<C, V>> mo129rowMap() {
        return ImmutableMap.of(this.c, ImmutableMap.of(this.d, (Object) this.e));
    }
}
