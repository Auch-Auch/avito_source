package com.avito.android.recycler.responsive;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010#\u001a\u00020\u0001\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b$\u0010%J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenterImpl;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", "view", "", VKApiConst.POSITION, "", "viewAttached", "(Lcom/avito/konveyor/blueprint/ItemView;I)V", "viewDetached", "", "", "payloads", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;ILjava/util/List;)V", "getCount", "()I", "", "getItemId", "(I)J", "getViewType", "(I)I", "", "isEmpty", "()Z", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", AuthSource.SEND_ABUSE, "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "registry", "delegate", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class ResponsiveAdapterPresenterImpl implements AdapterPresenter, ResponsiveAdapterPresenter {
    public final CallableResponsiveItemPresenterRegistry a;
    public final /* synthetic */ AdapterPresenter b;

    @Inject
    public ResponsiveAdapterPresenterImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "delegate");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "registry");
        this.b = adapterPresenter;
        this.a = callableResponsiveItemPresenterRegistry;
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public void bindView(@NotNull ItemView itemView, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.b.bindView(itemView, i, list);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public int getCount() {
        return this.b.getCount();
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public long getItemId(int i) {
        return this.b.getItemId(i);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public int getViewType(int i) {
        return this.b.getViewType(i);
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // com.avito.konveyor.adapter.AdapterPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.b.onDataSourceChanged(dataSource);
    }

    @Override // com.avito.android.recycler.responsive.ResponsiveAdapterPresenter
    public void viewAttached(@NotNull ItemView itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        this.a.onViewAttached(itemView, i);
    }

    @Override // com.avito.android.recycler.responsive.ResponsiveAdapterPresenter
    public void viewDetached(@NotNull ItemView itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        this.a.onViewDetached(itemView, i);
    }
}
