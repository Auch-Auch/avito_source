package com.avito.android.shop_settings;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.shop_settings.blueprints.address.ShopSettingsAddressItem;
import com.avito.android.shop_settings.blueprints.select.ShopSettingsSelectItem;
import com.avito.android.shop_settings.di.AddressItemClick;
import com.avito.android.shop_settings.di.SaveButtonClick;
import com.avito.android.shop_settings.di.SelectItemClick;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import kotlin.Unit;
public final class ShopSettingsFragment_MembersInjector implements MembersInjector<ShopSettingsFragment> {
    public final Provider<ShopSettingsViewModel> a;
    public final Provider<RecyclerView.Adapter<BaseViewHolder>> b;
    public final Provider<DataAwareAdapterPresenter> c;
    public final Provider<ActivityIntentFactory> d;
    public final Provider<PublishRelay<Unit>> e;
    public final Provider<PublishRelay<ShopSettingsSelectItem>> f;
    public final Provider<PublishRelay<ShopSettingsAddressItem>> g;

    public ShopSettingsFragment_MembersInjector(Provider<ShopSettingsViewModel> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<ActivityIntentFactory> provider4, Provider<PublishRelay<Unit>> provider5, Provider<PublishRelay<ShopSettingsSelectItem>> provider6, Provider<PublishRelay<ShopSettingsAddressItem>> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<ShopSettingsFragment> create(Provider<ShopSettingsViewModel> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<DataAwareAdapterPresenter> provider3, Provider<ActivityIntentFactory> provider4, Provider<PublishRelay<Unit>> provider5, Provider<PublishRelay<ShopSettingsSelectItem>> provider6, Provider<PublishRelay<ShopSettingsAddressItem>> provider7) {
        return new ShopSettingsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ShopSettingsFragment shopSettingsFragment, ActivityIntentFactory activityIntentFactory) {
        shopSettingsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.adapterPresenter")
    public static void injectAdapterPresenter(ShopSettingsFragment shopSettingsFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        shopSettingsFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.addressItemClickListener")
    @AddressItemClick
    public static void injectAddressItemClickListener(ShopSettingsFragment shopSettingsFragment, PublishRelay<ShopSettingsAddressItem> publishRelay) {
        shopSettingsFragment.addressItemClickListener = publishRelay;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(ShopSettingsFragment shopSettingsFragment, RecyclerView.Adapter<BaseViewHolder> adapter) {
        shopSettingsFragment.recyclerAdapter = adapter;
    }

    @SaveButtonClick
    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.saveButtonClickListener")
    public static void injectSaveButtonClickListener(ShopSettingsFragment shopSettingsFragment, PublishRelay<Unit> publishRelay) {
        shopSettingsFragment.saveButtonClickListener = publishRelay;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.selectItemClickListener")
    @SelectItemClick
    public static void injectSelectItemClickListener(ShopSettingsFragment shopSettingsFragment, PublishRelay<ShopSettingsSelectItem> publishRelay) {
        shopSettingsFragment.selectItemClickListener = publishRelay;
    }

    @InjectedFieldSignature("com.avito.android.shop_settings.ShopSettingsFragment.viewModel")
    public static void injectViewModel(ShopSettingsFragment shopSettingsFragment, ShopSettingsViewModel shopSettingsViewModel) {
        shopSettingsFragment.viewModel = shopSettingsViewModel;
    }

    public void injectMembers(ShopSettingsFragment shopSettingsFragment) {
        injectViewModel(shopSettingsFragment, this.a.get());
        injectRecyclerAdapter(shopSettingsFragment, this.b.get());
        injectAdapterPresenter(shopSettingsFragment, this.c.get());
        injectActivityIntentFactory(shopSettingsFragment, this.d.get());
        injectSaveButtonClickListener(shopSettingsFragment, this.e.get());
        injectSelectItemClickListener(shopSettingsFragment, this.f.get());
        injectAddressItemClickListener(shopSettingsFragment, this.g.get());
    }
}
