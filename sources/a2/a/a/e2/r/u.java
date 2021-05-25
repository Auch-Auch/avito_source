package a2.a.a.e2.r;

import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.util.DataSources;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class u<T, R> implements Function<DataSource<? extends Item>, IterableDataSource<? extends Item>> {
    public static final u a = new u();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public IterableDataSource<? extends Item> apply(DataSource<? extends Item> dataSource) {
        DataSource<? extends Item> dataSource2 = dataSource;
        Intrinsics.checkNotNullParameter(dataSource2, "it");
        return DataSources.toIterableDataSource(dataSource2);
    }
}
