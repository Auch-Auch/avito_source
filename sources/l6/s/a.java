package l6.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.DataSource;
import java.util.concurrent.Executor;
import l6.s.e;
public abstract class a<Key, Value> extends DataSource<Key, Value> {
    @Override // androidx.paging.DataSource
    public boolean b() {
        return true;
    }

    public abstract void c(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar);

    public abstract void d(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull e.a<Value> aVar);

    public abstract void e(@Nullable Key key, int i, int i2, boolean z, @NonNull Executor executor, @NonNull e.a<Value> aVar);

    public abstract Key f(int i, Value value);
}
