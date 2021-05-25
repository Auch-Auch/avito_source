package a2.j.d.c;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;
@Immutable(containerOf = {"R", "C", ExifInterface.GPS_MEASUREMENT_INTERRUPTED})
@GwtCompatible
public final class w3<R, C, V> extends h3<R, C, V> {
    public static final ImmutableTable<Object, Object, Object> g = new w3(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    public final ImmutableMap<R, ImmutableMap<C, V>> c;
    public final ImmutableMap<C, ImmutableMap<R, V>> d;
    public final int[] e;
    public final int[] f;

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: a2.j.d.c.w3<R, C, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX DEBUG: Multi-variable search result rejected for r10v3, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    public w3(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap h = Maps.h(immutableSet);
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> it = immutableSet.mo99iterator();
        while (it.hasNext()) {
            newLinkedHashMap.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap newLinkedHashMap2 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> it2 = immutableSet2.mo99iterator();
        while (it2.hasNext()) {
            newLinkedHashMap2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell<R, C, V> cell = immutableList.get(i);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            V value = cell.getValue();
            iArr[i] = ((Integer) h.get(rowKey)).intValue();
            Map map = (Map) newLinkedHashMap.get(rowKey);
            iArr2[i] = map.size();
            j(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) newLinkedHashMap2.get(columnKey)).put(rowKey, value);
        }
        this.e = iArr;
        this.f = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(newLinkedHashMap.size());
        for (Map.Entry entry : newLinkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.c = builder.build();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(newLinkedHashMap2.size());
        for (Map.Entry entry2 : newLinkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.d = builder2.build();
    }

    @Override // a2.j.d.c.h3, com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.d);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.a h() {
        ImmutableMap h = Maps.h(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        UnmodifiableIterator<Table.Cell<R, C, V>> it = cellSet().mo99iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) h.get(it.next().getColumnKey())).intValue();
            i++;
        }
        return ImmutableTable.a.a(this, this.e, iArr);
    }

    @Override // a2.j.d.c.h3
    public Table.Cell<R, C, V> m(int i) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.c.entrySet().asList().get(this.e[i]);
        Map.Entry<C, V> entry2 = entry.getValue().entrySet().asList().get(this.f[i]);
        return ImmutableTable.e(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // a2.j.d.c.h3
    public V n(int i) {
        int i2 = this.e[i];
        return this.c.values().asList().get(i2).values().asList().get(this.f[i]);
    }

    @Override // a2.j.d.c.h3, com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* renamed from: rowMap */
    public ImmutableMap<R, Map<C, V>> mo129rowMap() {
        return ImmutableMap.copyOf(this.c);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.e.length;
    }
}
