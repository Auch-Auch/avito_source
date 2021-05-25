package com.avito.android.shop_settings_select;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.shop_settings_select.di.CheckedIds;
import com.avito.android.shop_settings_select.di.SelectContext;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class ShopSettingsSelectFragment_MembersInjector implements MembersInjector<ShopSettingsSelectFragment> {
    public final Provider<ShopSettingsSelectViewModel> a;
    public final Provider<RecyclerView.Adapter<BaseViewHolder>> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<Set<ItemPresenter<?, ?>>> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<List<String>> f;
    public final Provider<String> g;

    public ShopSettingsSelectFragment_MembersInjector(Provider<ShopSettingsSelectViewModel> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4, Provider<ActivityIntentFactory> provider5, Provider<List<String>> provider6, Provider<String> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<ShopSettingsSelectFragment> create(Provider<ShopSettingsSelectViewModel> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4, Provider<ActivityIntentFactory> provider5, Provider<List<String>> provider6, Provider<String> provider7) {
        return new ShopSettingsSelectFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ShopSettingsSelectFragment shopSettingsSelectFragment, ActivityIntentFactory activityIntentFactory) {
        shopSettingsSelectFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.adapterPresenter")
    public static void injectAdapterPresenter(ShopSettingsSelectFragment shopSettingsSelectFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        shopSettingsSelectFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.checkedIds")
    @CheckedIds
    public static void injectCheckedIds(ShopSettingsSelectFragment shopSettingsSelectFragment, List<String> list) {
        shopSettingsSelectFragment.checkedIds = list;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.itemPresenterSet")
    public static void injectItemPresenterSet(ShopSettingsSelectFragment shopSettingsSelectFragment, Set<ItemPresenter<?, ?>> set) {
        shopSettingsSelectFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(ShopSettingsSelectFragment shopSettingsSelectFragment, RecyclerView.Adapter<BaseViewHolder> adapter) {
        shopSettingsSelectFragment.recyclerAdapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.selectContext")
    @SelectContext
    public static void injectSelectContext(ShopSettingsSelectFragment shopSettingsSelectFragment, String str) {
        shopSettingsSelectFragment.selectContext = str;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings_select.ShopSettingsSelectFragment.viewModel")
    public static void injectViewModel(ShopSettingsSelectFragment shopSettingsSelectFragment, ShopSettingsSelectViewModel shopSettingsSelectViewModel) {
        shopSettingsSelectFragment.viewModel = shopSettingsSelectViewModel;
    }

    public void injectMembers(ShopSettingsSelectFragment shopSettingsSelectFragment) {
        injectViewModel(shopSettingsSelectFragment, this.a.get());
        injectRecyclerAdapter(shopSettingsSelectFragment, this.b.get());
        injectAdapterPresenter(shopSettingsSelectFragment, this.c.get());
        injectItemPresenterSet(shopSettingsSelectFragment, this.d.get());
        injectActivityIntentFactory(shopSettingsSelectFragment, this.e.get());
        injectCheckedIds(shopSettingsSelectFragment, this.f.get());
        injectSelectContext(shopSettingsSelectFragment, this.g.get());
    }
}
