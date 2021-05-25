package com.avito.android.publish.select;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class SelectFragment_MembersInjector implements MembersInjector<SelectFragment> {
    public final Provider<SelectViewModelFactory> a;
    public final Provider<RecyclerView.Adapter<?>> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Set<ItemPresenter<?, ?>>> d;

    public SelectFragment_MembersInjector(Provider<SelectViewModelFactory> provider, Provider<RecyclerView.Adapter<?>> provider2, Provider<AdapterPresenter> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<SelectFragment> create(Provider<SelectViewModelFactory> provider, Provider<RecyclerView.Adapter<?>> provider2, Provider<AdapterPresenter> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4) {
        return new SelectFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.publish.select.SelectFragment.adapter")
    public static void injectAdapter(SelectFragment selectFragment, RecyclerView.Adapter<?> adapter) {
        selectFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.publish.select.SelectFragment.adapterPresenter")
    public static void injectAdapterPresenter(SelectFragment selectFragment, AdapterPresenter adapterPresenter) {
        selectFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.select.SelectFragment.itemPresenterSet")
    public static void injectItemPresenterSet(SelectFragment selectFragment, Set<ItemPresenter<?, ?>> set) {
        selectFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.publish.select.SelectFragment.viewModelFactory")
    public static void injectViewModelFactory(SelectFragment selectFragment, SelectViewModelFactory selectViewModelFactory) {
        selectFragment.viewModelFactory = selectViewModelFactory;
    }

    public void injectMembers(SelectFragment selectFragment) {
        injectViewModelFactory(selectFragment, this.a.get());
        injectAdapter(selectFragment, this.b.get());
        injectAdapterPresenter(selectFragment, this.c.get());
        injectItemPresenterSet(selectFragment, this.d.get());
    }
}
