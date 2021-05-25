package com.avito.konveyor.data_source;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/avito/konveyor/data_source/ListDataSource;", "T", "Lcom/avito/konveyor/data_source/IterableDataSource;", "", "isEmpty", "()Z", "", VKApiConst.POSITION, "getItem", "(I)Ljava/lang/Object;", "", "iterator", "()Ljava/util/Iterator;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "list", "getCount", "count", "<init>", "(Ljava/util/List;)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class ListDataSource<T> implements IterableDataSource<T> {
    public final List<T> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public ListDataSource(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.a = list;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ListDataSource) && !(Intrinsics.areEqual(this.a, ((ListDataSource) obj).a) ^ true);
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public int getCount() {
        return this.a.size();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public T getItem(int i) {
        return this.a.get(i);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.avito.konveyor.data_source.DataSource
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return this.a.iterator();
    }
}
