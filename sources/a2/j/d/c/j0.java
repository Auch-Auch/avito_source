package a2.j.d.c;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable(containerOf = {"R", "C", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@GwtCompatible
public final class j0<R, C, V> extends h3<R, C, V> {
    public final ImmutableMap<R, Integer> c;
    public final ImmutableMap<C, Integer> d;
    public final ImmutableMap<R, ImmutableMap<C, V>> e;
    public final ImmutableMap<C, ImmutableMap<R, V>> f;
    public final int[] g;
    public final int[] h;
    public final V[][] i;
    public final int[] j;
    public final int[] k;

    public final class b extends d<R, V> {
        public final int g;

        public b(int i) {
            super(j0.this.h[i]);
            this.g = i;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean h() {
            return true;
        }

        @Override // a2.j.d.c.j0.d
        public V l(int i) {
            return j0.this.i[i][this.g];
        }

        @Override // a2.j.d.c.j0.d
        public ImmutableMap<R, Integer> m() {
            return j0.this.c;
        }
    }

    public final class c extends d<C, ImmutableMap<R, V>> {
        public c(a aVar) {
            super(j0.this.h.length);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean h() {
            return false;
        }

        @Override // a2.j.d.c.j0.d
        public Object l(int i) {
            return new b(i);
        }

        @Override // a2.j.d.c.j0.d
        public ImmutableMap<C, Integer> m() {
            return j0.this.d;
        }
    }

    public static abstract class d<K, V> extends ImmutableMap.b<K, V> {
        public final int f;

        public class a extends AbstractIterator<Map.Entry<K, V>> {
            public int c = -1;
            public final int d;

            public a() {
                this.d = d.this.m().size();
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                Object l;
                do {
                    int i = this.c + 1;
                    this.c = i;
                    if (i >= this.d) {
                        return (Map.Entry) endOfData();
                    }
                    l = d.this.l(i);
                } while (l == null);
                d dVar = d.this;
                return Maps.immutableEntry(dVar.m().keySet().asList().get(this.c), l);
            }
        }

        public d(int i) {
            this.f = i;
        }

        @Override // com.google.common.collect.ImmutableMap.b, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> c() {
            if (this.f == m().size()) {
                return m().keySet();
            }
            return new j1(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            Integer num = m().get(obj);
            if (num == null) {
                return null;
            }
            return l(num.intValue());
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public UnmodifiableIterator<Map.Entry<K, V>> j() {
            return new a();
        }

        @NullableDecl
        public abstract V l(int i);

        public abstract ImmutableMap<K, Integer> m();

        @Override // java.util.Map
        public int size() {
            return this.f;
        }
    }

    public final class e extends d<C, V> {
        public final int g;

        public e(int i) {
            super(j0.this.g[i]);
            this.g = i;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean h() {
            return true;
        }

        @Override // a2.j.d.c.j0.d
        public V l(int i) {
            return j0.this.i[this.g][i];
        }

        @Override // a2.j.d.c.j0.d
        public ImmutableMap<C, Integer> m() {
            return j0.this.d;
        }
    }

    public final class f extends d<R, ImmutableMap<C, V>> {
        public f(a aVar) {
            super(j0.this.g.length);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean h() {
            return false;
        }

        @Override // a2.j.d.c.j0.d
        public Object l(int i) {
            return new e(i);
        }

        @Override // a2.j.d.c.j0.d
        public ImmutableMap<R, Integer> m() {
            return j0.this.c;
        }
    }

    public j0(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        int size = immutableSet.size();
        int[] iArr = new int[2];
        iArr[1] = immutableSet2.size();
        iArr[0] = size;
        this.i = (V[][]) ((Object[][]) Array.newInstance(Object.class, iArr));
        ImmutableMap<R, Integer> h2 = Maps.h(immutableSet);
        this.c = h2;
        ImmutableMap<C, Integer> h3 = Maps.h(immutableSet2);
        this.d = h3;
        this.g = new int[h2.size()];
        this.h = new int[h3.size()];
        int[] iArr2 = new int[immutableList.size()];
        int[] iArr3 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            Table.Cell<R, C, V> cell = immutableList.get(i2);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            int intValue = this.c.get(rowKey).intValue();
            int intValue2 = this.d.get(columnKey).intValue();
            j(rowKey, columnKey, this.i[intValue][intValue2], cell.getValue());
            this.i[intValue][intValue2] = cell.getValue();
            int[] iArr4 = this.g;
            iArr4[intValue] = iArr4[intValue] + 1;
            int[] iArr5 = this.h;
            iArr5[intValue2] = iArr5[intValue2] + 1;
            iArr2[i2] = intValue;
            iArr3[i2] = intValue2;
        }
        this.j = iArr2;
        this.k = iArr3;
        this.e = new f(null);
        this.f = new c(null);
    }

    @Override // a2.j.d.c.h3, com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.f);
    }

    @Override // com.google.common.collect.ImmutableTable, a2.j.d.c.q, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.c.get(obj);
        Integer num2 = this.d.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.i[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.a h() {
        return ImmutableTable.a.a(this, this.j, this.k);
    }

    @Override // a2.j.d.c.h3
    public Table.Cell<R, C, V> m(int i2) {
        int i3 = this.j[i2];
        int i4 = this.k[i2];
        return ImmutableTable.e(mo128rowKeySet().asList().get(i3), columnKeySet().asList().get(i4), this.i[i3][i4]);
    }

    @Override // a2.j.d.c.h3
    public V n(int i2) {
        return this.i[this.j[i2]][this.k[i2]];
    }

    @Override // a2.j.d.c.h3, com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* renamed from: rowMap */
    public ImmutableMap<R, Map<C, V>> mo129rowMap() {
        return ImmutableMap.copyOf(this.e);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.j.length;
    }
}
