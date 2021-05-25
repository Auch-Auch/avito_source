package a2.a.b.a;

import com.avito.konveyor.data_source.DataSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class d<T, R> implements DataSource<R> {
    public final DataSource<T> a;
    public final Function1<T, R> b;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super T, ? extends R> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull DataSource<T> dataSource, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dataSource, "source");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        this.a = dataSource;
        this.b = function1;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.a.getCount();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public R getItem(int i) {
        return this.b.invoke(this.a.getItem(i));
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
}
