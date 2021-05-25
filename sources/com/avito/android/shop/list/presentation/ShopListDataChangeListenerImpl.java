package com.avito.android.shop.list.presentation;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001f\u0010\rJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListDataChangeListenerImpl;", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "positionsProvider", "attachPositionsProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)V", "detachPositionsProvider", "()V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "attachAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "detachAdapterPresenter", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "attachSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)V", "detachSpanProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "serpSpanProvider", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "<init>", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListDataChangeListenerImpl implements ShopListDataChangeListener {
    public SpannedGridPositionProvider a;
    public AdapterPresenter b;
    public SerpSpanProvider c;

    @Override // com.avito.android.shop.list.presentation.AdapterPresenterWrapper
    public void attachAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.b = adapterPresenter;
    }

    @Override // com.avito.android.shop.list.presentation.PositionsProviderWrapper
    public void attachPositionsProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "positionsProvider");
        this.a = spannedGridPositionProvider;
    }

    @Override // com.avito.android.shop.list.presentation.SpanProviderWrapper
    public void attachSpanProvider(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        this.c = serpSpanProvider;
    }

    @Override // com.avito.android.shop.list.presentation.AdapterPresenterWrapper
    public void detachAdapterPresenter() {
        this.b = null;
    }

    @Override // com.avito.android.shop.list.presentation.PositionsProviderWrapper
    public void detachPositionsProvider() {
        this.a = null;
    }

    @Override // com.avito.android.shop.list.presentation.SpanProviderWrapper
    public void detachSpanProvider() {
        this.c = null;
    }

    @Override // com.avito.android.shop.list.presentation.ShopListDataChangeListener
    public void onDataSourceChanged(@NotNull DataSource<SpannedItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        SpannedGridPositionProvider spannedGridPositionProvider = this.a;
        if (spannedGridPositionProvider != null) {
            spannedGridPositionProvider.onDataSourceChanged(dataSource);
        }
        AdapterPresenter adapterPresenter = this.b;
        if (adapterPresenter != null) {
            adapterPresenter.onDataSourceChanged(dataSource);
        }
        SerpSpanProvider serpSpanProvider = this.c;
        if (serpSpanProvider != null) {
            serpSpanProvider.onDataSourceChanged(dataSource);
        }
    }
}
