package com.avito.android.tariff.edit_info;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.tariff.edit_info.di.TabsAdapterPresenter;
import com.avito.android.tariff.edit_info.di.TabsRecyclerAdapter;
import com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModel;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class EditInfoFragment_MembersInjector implements MembersInjector<EditInfoFragment> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<DataAwareAdapterPresenter> b;
    public final Provider<EditInfoViewModel> c;
    public final Provider<AttributedTextFormatter> d;
    public final Provider<RecyclerView.ItemDecoration> e;
    public final Provider<Set<ItemPresenter<?, ?>>> f;
    public final Provider<DeepLinkIntentFactory> g;
    public final Provider<SimpleRecyclerAdapter> h;
    public final Provider<AdapterPresenter> i;
    public final Provider<TabsItemPresenter> j;

    public EditInfoFragment_MembersInjector(Provider<SimpleRecyclerAdapter> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<EditInfoViewModel> provider3, Provider<AttributedTextFormatter> provider4, Provider<RecyclerView.ItemDecoration> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<SimpleRecyclerAdapter> provider8, Provider<AdapterPresenter> provider9, Provider<TabsItemPresenter> provider10) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
    }

    public static MembersInjector<EditInfoFragment> create(Provider<SimpleRecyclerAdapter> provider, Provider<DataAwareAdapterPresenter> provider2, Provider<EditInfoViewModel> provider3, Provider<AttributedTextFormatter> provider4, Provider<RecyclerView.ItemDecoration> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<SimpleRecyclerAdapter> provider8, Provider<AdapterPresenter> provider9, Provider<TabsItemPresenter> provider10) {
        return new EditInfoFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.adapterPresenter")
    public static void injectAdapterPresenter(EditInfoFragment editInfoFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        editInfoFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(EditInfoFragment editInfoFragment, AttributedTextFormatter attributedTextFormatter) {
        editInfoFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(EditInfoFragment editInfoFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        editInfoFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.itemDecoration")
    public static void injectItemDecoration(EditInfoFragment editInfoFragment, RecyclerView.ItemDecoration itemDecoration) {
        editInfoFragment.itemDecoration = itemDecoration;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.itemPresenterSet")
    public static void injectItemPresenterSet(EditInfoFragment editInfoFragment, Set<ItemPresenter<?, ?>> set) {
        editInfoFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(EditInfoFragment editInfoFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        editInfoFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @TabsAdapterPresenter
    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.tabsAdapterPresenter")
    public static void injectTabsAdapterPresenter(EditInfoFragment editInfoFragment, AdapterPresenter adapterPresenter) {
        editInfoFragment.tabsAdapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.tabsItemPresenter")
    public static void injectTabsItemPresenter(EditInfoFragment editInfoFragment, TabsItemPresenter tabsItemPresenter) {
        editInfoFragment.tabsItemPresenter = tabsItemPresenter;
    }

    @TabsRecyclerAdapter
    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.tabsRecyclerAdapter")
    public static void injectTabsRecyclerAdapter(EditInfoFragment editInfoFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        editInfoFragment.tabsRecyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.tariff.edit_info.EditInfoFragment.viewModel")
    public static void injectViewModel(EditInfoFragment editInfoFragment, EditInfoViewModel editInfoViewModel) {
        editInfoFragment.viewModel = editInfoViewModel;
    }

    public void injectMembers(EditInfoFragment editInfoFragment) {
        injectRecyclerAdapter(editInfoFragment, this.a.get());
        injectAdapterPresenter(editInfoFragment, this.b.get());
        injectViewModel(editInfoFragment, this.c.get());
        injectAttributedTextFormatter(editInfoFragment, this.d.get());
        injectItemDecoration(editInfoFragment, this.e.get());
        injectItemPresenterSet(editInfoFragment, this.f.get());
        injectDeepLinkIntentFactory(editInfoFragment, this.g.get());
        injectTabsRecyclerAdapter(editInfoFragment, this.h.get());
        injectTabsAdapterPresenter(editInfoFragment, this.i.get());
        injectTabsItemPresenter(editInfoFragment, this.j.get());
    }
}
