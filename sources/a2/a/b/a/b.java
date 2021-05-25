package a2.a.b.a;

import com.avito.konveyor.data_source.DataSource;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
public final class b<T> implements Iterator<T>, KMappedMarker {
    public final int a;
    public int b;
    public final DataSource<T> c;

    public b(@NotNull DataSource<T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.c = dataSource;
        this.a = dataSource.getCount();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a > this.b;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            DataSource<T> dataSource = this.c;
            int i = this.b;
            this.b = i + 1;
            return dataSource.getItem(i);
        }
        throw new IllegalStateException("Iterator has exhausted");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
