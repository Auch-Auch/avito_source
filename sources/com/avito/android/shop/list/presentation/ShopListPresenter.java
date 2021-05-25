package com.avito.android.shop.list.presentation;

import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.list.presentation.item.ShopClickListener;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H&¢\u0006\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "Lcom/avito/android/shop/list/presentation/item/ShopClickListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/shop/list/presentation/ShopListView;", "view", "", "attachView", "(Lcom/avito/android/shop/list/presentation/ShopListView;)V", "detachView", "()V", "Lcom/avito/android/shop/list/presentation/ShopListRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/list/presentation/ShopListRouter;)V", "detachRouter", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "params", "Lcom/avito/android/remote/model/CaseText;", "locationNames", "onSearchParametersChanged", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Lcom/avito/android/remote/model/CaseText;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onDestroy", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopListPresenter extends ShopClickListener, AppendingListener {
    void attachRouter(@NotNull ShopListRouter shopListRouter);

    void attachView(@NotNull ShopListView shopListView);

    void detachRouter();

    void detachView();

    void onDestroy();

    @NotNull
    Kundle onSaveState();

    void onSearchParametersChanged(@NotNull ShopsSearchParameters shopsSearchParameters, @NotNull CaseText caseText);
}
