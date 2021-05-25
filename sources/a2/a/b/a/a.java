package a2.a.b.a;

import com.avito.konveyor.data_source.DataSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a<T> implements DataSource<T> {
    public final DataSource<? extends T>[] a;

    public a(@NotNull DataSource<? extends T>... dataSourceArr) {
        Intrinsics.checkNotNullParameter(dataSourceArr, "sources");
        this.a = dataSourceArr;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        int i = 0;
        for (DataSource<? extends T> dataSource : this.a) {
            i += dataSource.getCount();
        }
        return i;
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public T getItem(int i) {
        if (i >= 0) {
            DataSource<? extends T>[] dataSourceArr = this.a;
            int length = dataSourceArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                DataSource<? extends T> dataSource = dataSourceArr[i2];
                int count = dataSource.getCount() + i3;
                if (i < count) {
                    return (T) dataSource.getItem(i - i3);
                }
                i2++;
                i3 = count;
            }
            throw new IndexOutOfBoundsException(a2.b.a.a.a.M2("Invalid index: ", i));
        }
        throw new IndexOutOfBoundsException(a2.b.a.a.a.Q2("Illegal index: ", i, " – must not be negative"));
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        for (DataSource<? extends T> dataSource : this.a) {
            if (!dataSource.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
