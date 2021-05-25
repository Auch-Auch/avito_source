package com.avito.android.publish.category_suggest;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class CategoriesSuggestionsFragment_MembersInjector implements MembersInjector<CategoriesSuggestionsFragment> {
    public final Provider<CategoriesSuggestionsViewModelFactory> a;
    public final Provider<RecyclerView.Adapter<?>> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<Analytics> d;
    public final Provider<Set<ItemPresenter<?, ?>>> e;
    public final Provider<PublishDraftDataHolder> f;
    public final Provider<PublishEventTracker> g;

    public CategoriesSuggestionsFragment_MembersInjector(Provider<CategoriesSuggestionsViewModelFactory> provider, Provider<RecyclerView.Adapter<?>> provider2, Provider<AdapterPresenter> provider3, Provider<Analytics> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5, Provider<PublishDraftDataHolder> provider6, Provider<PublishEventTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<CategoriesSuggestionsFragment> create(Provider<CategoriesSuggestionsViewModelFactory> provider, Provider<RecyclerView.Adapter<?>> provider2, Provider<AdapterPresenter> provider3, Provider<Analytics> provider4, Provider<Set<ItemPresenter<?, ?>>> provider5, Provider<PublishDraftDataHolder> provider6, Provider<PublishEventTracker> provider7) {
        return new CategoriesSuggestionsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.adapter")
    public static void injectAdapter(CategoriesSuggestionsFragment categoriesSuggestionsFragment, RecyclerView.Adapter<?> adapter) {
        categoriesSuggestionsFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.adapterPresenter")
    public static void injectAdapterPresenter(CategoriesSuggestionsFragment categoriesSuggestionsFragment, AdapterPresenter adapterPresenter) {
        categoriesSuggestionsFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.analytics")
    public static void injectAnalytics(CategoriesSuggestionsFragment categoriesSuggestionsFragment, Analytics analytics) {
        categoriesSuggestionsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.itemPresenterSet")
    public static void injectItemPresenterSet(CategoriesSuggestionsFragment categoriesSuggestionsFragment, Set<ItemPresenter<?, ?>> set) {
        categoriesSuggestionsFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.publishDraftDataHolder")
    public static void injectPublishDraftDataHolder(CategoriesSuggestionsFragment categoriesSuggestionsFragment, PublishDraftDataHolder publishDraftDataHolder) {
        categoriesSuggestionsFragment.publishDraftDataHolder = publishDraftDataHolder;
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.publishEventTracker")
    public static void injectPublishEventTracker(CategoriesSuggestionsFragment categoriesSuggestionsFragment, PublishEventTracker publishEventTracker) {
        categoriesSuggestionsFragment.publishEventTracker = publishEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.category_suggest.CategoriesSuggestionsFragment.viewModelFactory")
    public static void injectViewModelFactory(CategoriesSuggestionsFragment categoriesSuggestionsFragment, CategoriesSuggestionsViewModelFactory categoriesSuggestionsViewModelFactory) {
        categoriesSuggestionsFragment.viewModelFactory = categoriesSuggestionsViewModelFactory;
    }

    public void injectMembers(CategoriesSuggestionsFragment categoriesSuggestionsFragment) {
        injectViewModelFactory(categoriesSuggestionsFragment, this.a.get());
        injectAdapter(categoriesSuggestionsFragment, this.b.get());
        injectAdapterPresenter(categoriesSuggestionsFragment, this.c.get());
        injectAnalytics(categoriesSuggestionsFragment, this.d.get());
        injectItemPresenterSet(categoriesSuggestionsFragment, this.e.get());
        injectPublishDraftDataHolder(categoriesSuggestionsFragment, this.f.get());
        injectPublishEventTracker(categoriesSuggestionsFragment, this.g.get());
    }
}
