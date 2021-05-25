package a2.j.d.c;

import com.google.common.collect.Table;
import java.util.Comparator;
public final class g3 implements Comparator<Table.Cell<R, C, V>> {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Comparator b;

    public g3(Comparator comparator, Comparator comparator2) {
        this.a = comparator;
        this.b = comparator2;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i;
        Table.Cell cell = (Table.Cell) obj;
        Table.Cell cell2 = (Table.Cell) obj2;
        Comparator comparator = this.a;
        int i2 = 0;
        if (comparator == null) {
            i = 0;
        } else {
            i = comparator.compare(cell.getRowKey(), cell2.getRowKey());
        }
        if (i != 0) {
            return i;
        }
        Comparator comparator2 = this.b;
        if (comparator2 != null) {
            i2 = comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
        }
        return i2;
    }
}
