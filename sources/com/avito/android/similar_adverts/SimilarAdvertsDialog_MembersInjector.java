package com.avito.android.similar_adverts;

import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SimilarAdvertsDialog_MembersInjector implements MembersInjector<SimilarAdvertsDialog> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<GridLayoutManager.SpanSizeLookup> c;
    public final Provider<SimilarAdvertsViewModel> d;
    public final Provider<FavoriteAdvertsPresenter> e;
    public final Provider<SimilarAdvertsResourceProvider> f;
    public final Provider<DataAwareAdapterPresenter> g;
    public final Provider<SerpSpanProvider> h;
    public final Provider<SectionActionPresenter> i;

    public SimilarAdvertsDialog_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<GridLayoutManager.SpanSizeLookup> provider3, Provider<SimilarAdvertsViewModel> provider4, Provider<FavoriteAdvertsPresenter> provider5, Provider<SimilarAdvertsResourceProvider> provider6, Provider<DataAwareAdapterPresenter> provider7, Provider<SerpSpanProvider> provider8, Provider<SectionActionPresenter> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static MembersInjector<SimilarAdvertsDialog> create(Provider<DeepLinkIntentFactory> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<GridLayoutManager.SpanSizeLookup> provider3, Provider<SimilarAdvertsViewModel> provider4, Provider<FavoriteAdvertsPresenter> provider5, Provider<SimilarAdvertsResourceProvider> provider6, Provider<DataAwareAdapterPresenter> provider7, Provider<SerpSpanProvider> provider8, Provider<SectionActionPresenter> provider9) {
        return new SimilarAdvertsDialog_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.adapterPresenter")
    public static void injectAdapterPresenter(SimilarAdvertsDialog similarAdvertsDialog, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        similarAdvertsDialog.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(SimilarAdvertsDialog similarAdvertsDialog, DeepLinkIntentFactory deepLinkIntentFactory) {
        similarAdvertsDialog.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.favoriteAdvertsPresenter")
    public static void injectFavoriteAdvertsPresenter(SimilarAdvertsDialog similarAdvertsDialog, FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        similarAdvertsDialog.favoriteAdvertsPresenter = favoriteAdvertsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.recyclerAdapter")
    public static void injectRecyclerAdapter(SimilarAdvertsDialog similarAdvertsDialog, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        similarAdvertsDialog.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.resourceProvider")
    public static void injectResourceProvider(SimilarAdvertsDialog similarAdvertsDialog, SimilarAdvertsResourceProvider similarAdvertsResourceProvider) {
        similarAdvertsDialog.resourceProvider = similarAdvertsResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.sectionActionPresenter")
    public static void injectSectionActionPresenter(SimilarAdvertsDialog similarAdvertsDialog, SectionActionPresenter sectionActionPresenter) {
        similarAdvertsDialog.sectionActionPresenter = sectionActionPresenter;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.serpSpanProvider")
    public static void injectSerpSpanProvider(SimilarAdvertsDialog similarAdvertsDialog, SerpSpanProvider serpSpanProvider) {
        similarAdvertsDialog.serpSpanProvider = serpSpanProvider;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.spanSizeLookup")
    public static void injectSpanSizeLookup(SimilarAdvertsDialog similarAdvertsDialog, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        similarAdvertsDialog.spanSizeLookup = spanSizeLookup;
    }

    @InjectedFieldSignature("com.avito.android.similar_adverts.SimilarAdvertsDialog.viewModel")
    public static void injectViewModel(SimilarAdvertsDialog similarAdvertsDialog, SimilarAdvertsViewModel similarAdvertsViewModel) {
        similarAdvertsDialog.viewModel = similarAdvertsViewModel;
    }

    public void injectMembers(SimilarAdvertsDialog similarAdvertsDialog) {
        injectDeepLinkIntentFactory(similarAdvertsDialog, this.a.get());
        injectRecyclerAdapter(similarAdvertsDialog, this.b.get());
        injectSpanSizeLookup(similarAdvertsDialog, this.c.get());
        injectViewModel(similarAdvertsDialog, this.d.get());
        injectFavoriteAdvertsPresenter(similarAdvertsDialog, this.e.get());
        injectResourceProvider(similarAdvertsDialog, this.f.get());
        injectAdapterPresenter(similarAdvertsDialog, this.g.get());
        injectSerpSpanProvider(similarAdvertsDialog, this.h.get());
        injectSectionActionPresenter(similarAdvertsDialog, this.i.get());
    }
}
