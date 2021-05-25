package com.avito.android.ui.adapter.tab;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "T", "", "", VKApiConst.POSITION, "getItem", "(I)Ljava/lang/Object;", "getCount", "()I", "", "items", "", "updateItems", "(Ljava/util/List;)V", "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TabsDataProvider<T> {
    public DataSource<? extends T> a;

    public final int getCount() {
        DataSource<? extends T> dataSource = this.a;
        if (dataSource != null) {
            return dataSource.getCount();
        }
        return 0;
    }

    public final T getItem(int i) {
        DataSource<? extends T> dataSource = this.a;
        if (dataSource != null) {
            return (T) dataSource.getItem(i);
        }
        throw new IllegalStateException("Data source is not initialized yet");
    }

    public final void onDataSourceChanged(@NotNull DataSource<? extends T> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }

    public final void updateItems(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        onDataSourceChanged(new ListDataSource(list));
    }
}
