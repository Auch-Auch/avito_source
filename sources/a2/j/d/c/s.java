package a2.j.d.c;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Tables;
public class s extends Tables.b<R, C, V> {
    public final int a;
    public final int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ArrayTable d;

    public s(ArrayTable arrayTable, int i) {
        this.d = arrayTable;
        this.c = i;
        this.a = i / arrayTable.d.size();
        this.b = i % arrayTable.d.size();
    }

    @Override // com.google.common.collect.Table.Cell
    public C getColumnKey() {
        return this.d.d.get(this.b);
    }

    @Override // com.google.common.collect.Table.Cell
    public R getRowKey() {
        return this.d.c.get(this.a);
    }

    @Override // com.google.common.collect.Table.Cell
    public V getValue() {
        return (V) this.d.at(this.a, this.b);
    }
}
