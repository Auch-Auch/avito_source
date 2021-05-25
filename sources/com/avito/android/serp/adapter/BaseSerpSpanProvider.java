package com.avito.android.serp.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.konveyor.data_source.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00138\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R,\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0007R$\u0010#\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u000b¨\u0006&"}, d2 = {"Lcom/avito/android/serp/adapter/BaseSerpSpanProvider;", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "setAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "", VKApiConst.POSITION, "getSpan", "(I)I", "item", "getSpanCount", "(Lcom/avito/android/serp/adapter/SpannedItem;)I", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "c", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "getGridPositionProvider", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "getDataSource", "()Lcom/avito/konveyor/data_source/DataSource;", "setDataSource", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/AppendingListener;", "getListener", "()Lcom/avito/android/ui/adapter/AppendingListener;", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseSerpSpanProvider implements SerpSpanProvider {
    @Nullable
    public DataSource<? extends SpannedItem> a;
    @Nullable
    public AppendingListener b;
    @NotNull
    public final SpannedGridPositionProvider c;

    public BaseSerpSpanProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        this.c = spannedGridPositionProvider;
    }

    @Nullable
    public final DataSource<? extends SpannedItem> getDataSource() {
        return this.a;
    }

    @NotNull
    public final SpannedGridPositionProvider getGridPositionProvider() {
        return this.c;
    }

    @Nullable
    public final AppendingListener getListener() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.SpanProvider
    public int getSpan(int i) {
        DataSource<? extends SpannedItem> dataSource = this.a;
        if (dataSource != null) {
            AppendingListener appendingListener = this.b;
            if (appendingListener != null) {
                boolean z = true;
                if (i < 0 || i >= dataSource.getCount()) {
                    return 1;
                }
                SpannedItem spannedItem = (SpannedItem) dataSource.getItem(i);
                if (appendingListener.canAppend()) {
                    if (this.c.getRowForPosition(i) != this.c.getRows() - 1) {
                        z = false;
                    }
                    if (z) {
                        return getColumnsCount();
                    }
                }
                return Math.min(getColumnsCount(), getSpanCount(spannedItem));
            }
            throw new IllegalStateException("Appending Listener should be provided".toString());
        }
        throw new IllegalStateException("Data source should be provided".toString());
    }

    public abstract int getSpanCount(@NotNull SpannedItem spannedItem);

    @Override // com.avito.android.serp.adapter.SerpSpanProvider
    public void onDataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.a = dataSource;
    }

    @Override // com.avito.android.serp.adapter.SerpSpanProvider
    public void setAppendingListener(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        this.b = appendingListener;
    }

    public final void setDataSource(@Nullable DataSource<? extends SpannedItem> dataSource) {
        this.a = dataSource;
    }

    public final void setListener(@Nullable AppendingListener appendingListener) {
        this.b = appendingListener;
    }
}
