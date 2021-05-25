package a2.a.b.a;

import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class c<T> implements DataSource<T>, IterableDataSource<T> {
    public final DataSource<T> a;

    public c(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.a.getCount();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public T getItem(int i) {
        return this.a.getItem(i);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new b(this.a);
    }
}
