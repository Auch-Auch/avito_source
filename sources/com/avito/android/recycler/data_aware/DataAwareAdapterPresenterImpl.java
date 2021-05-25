package com.avito.android.recycler.data_aware;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenterImpl;", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/konveyor/blueprint/ItemView;", "view", "", VKApiConst.POSITION, "", "", "payloads", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;ILjava/util/List;)V", "getCount", "()I", "", "getItemId", "(I)J", "getViewType", "(I)I", "", "isEmpty", "()Z", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "items", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "updateListener", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "delegate", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "d", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "<init>", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class DataAwareAdapterPresenterImpl implements DataAwareAdapterPresenter, AdapterPresenter {
    public DataSource<? extends Item> a = new ListDataSource(CollectionsKt__CollectionsKt.emptyList());
    public final Lazy<ListUpdateCallback> b;
    public final AdapterPresenter c;
    public final DiffCalculator d;

    @Inject
    public DataAwareAdapterPresenterImpl(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, "updateListener");
        Intrinsics.checkNotNullParameter(adapterPresenter, "delegate");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        this.b = lazy;
        this.c = adapterPresenter;
        this.d = diffCalculator;
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public void bindView(@NotNull ItemView itemView, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.c.bindView(itemView, i, list);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public int getCount() {
        return this.c.getCount();
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public long getItemId(int i) {
        return this.c.getItemId(i);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public int getViewType(int i) {
        return this.c.getViewType(i);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.c.onDataSourceChanged(dataSource);
        DiffUtil.DiffResult calculateDiff = this.d.calculateDiff(this.a, dataSource);
        this.a = dataSource;
        calculateDiff.dispatchUpdatesTo(this.b.get());
    }
}
