package a2.a.a.e2.n;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.util.DataSources;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class d<T, R> implements Function<DataSource<? extends Item>, List<? extends Item>> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends Item> apply(DataSource<? extends Item> dataSource) {
        DataSource<? extends Item> dataSource2 = dataSource;
        Intrinsics.checkNotNullParameter(dataSource2, "it");
        IterableDataSource iterableDataSource = DataSources.toIterableDataSource(dataSource2);
        ArrayList arrayList = new ArrayList();
        for (T t : iterableDataSource) {
            if (t instanceof ParameterElement.Select) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((Item) it.next());
        }
        return arrayList2;
    }
}
