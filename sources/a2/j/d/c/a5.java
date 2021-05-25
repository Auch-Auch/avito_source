package a2.j.d.c;

import com.google.common.base.Function;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
public class a5 implements Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> {
    public final /* synthetic */ Tables.d a;

    public a5(Tables.d dVar) {
        this.a = dVar;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        Table.Cell cell = (Table.Cell) obj;
        return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), this.a.d.apply((Object) cell.getValue()));
    }
}
