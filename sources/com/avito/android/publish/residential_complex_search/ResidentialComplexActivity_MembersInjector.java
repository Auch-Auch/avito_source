package com.avito.android.publish.residential_complex_search;

import com.avito.android.publish.residential_complex_search.adapter.button.ResidentialComplexButtonPresenter;
import com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ResidentialComplexActivity_MembersInjector implements MembersInjector<ResidentialComplexActivity> {
    public final Provider<ResidentialComplexViewModel> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<ResidentialComplexSuggestPresenter> d;
    public final Provider<ResidentialComplexButtonPresenter> e;

    public ResidentialComplexActivity_MembersInjector(Provider<ResidentialComplexViewModel> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ResidentialComplexSuggestPresenter> provider4, Provider<ResidentialComplexButtonPresenter> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<ResidentialComplexActivity> create(Provider<ResidentialComplexViewModel> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<ResidentialComplexSuggestPresenter> provider4, Provider<ResidentialComplexButtonPresenter> provider5) {
        return new ResidentialComplexActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.publish.residential_complex_search.ResidentialComplexActivity.adapterPresenter")
    public static void injectAdapterPresenter(ResidentialComplexActivity residentialComplexActivity, AdapterPresenter adapterPresenter) {
        residentialComplexActivity.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.residential_complex_search.ResidentialComplexActivity.buttonPresenter")
    public static void injectButtonPresenter(ResidentialComplexActivity residentialComplexActivity, ResidentialComplexButtonPresenter residentialComplexButtonPresenter) {
        residentialComplexActivity.buttonPresenter = residentialComplexButtonPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.residential_complex_search.ResidentialComplexActivity.itemBinder")
    public static void injectItemBinder(ResidentialComplexActivity residentialComplexActivity, ItemBinder itemBinder) {
        residentialComplexActivity.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.publish.residential_complex_search.ResidentialComplexActivity.suggestPresenter")
    public static void injectSuggestPresenter(ResidentialComplexActivity residentialComplexActivity, ResidentialComplexSuggestPresenter residentialComplexSuggestPresenter) {
        residentialComplexActivity.suggestPresenter = residentialComplexSuggestPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.residential_complex_search.ResidentialComplexActivity.viewModel")
    public static void injectViewModel(ResidentialComplexActivity residentialComplexActivity, ResidentialComplexViewModel residentialComplexViewModel) {
        residentialComplexActivity.viewModel = residentialComplexViewModel;
    }

    public void injectMembers(ResidentialComplexActivity residentialComplexActivity) {
        injectViewModel(residentialComplexActivity, this.a.get());
        injectAdapterPresenter(residentialComplexActivity, this.b.get());
        injectItemBinder(residentialComplexActivity, this.c.get());
        injectSuggestPresenter(residentialComplexActivity, this.d.get());
        injectButtonPresenter(residentialComplexActivity, this.e.get());
    }
}
